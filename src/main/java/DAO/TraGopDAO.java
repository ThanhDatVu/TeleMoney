/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.GuiTienModel;
import Model.MyStockBuyModel;
import Model.TraGopModel;
import Model.TraGopTransModel;
import Model.UserModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import View.MasterTeleMoneyView;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author xiaomi
 */
public class TraGopDAO {

    private Connection con;
    private UserModel userModel;

    public TraGopDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/telemoney", "root", "");
//here sonoo is database name, root is username and password  

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void add(TraGopModel traGop, UserModel acc) {
        String sql = "INSERT INTO `tragop` (`uid`, `name`, `namecongty`, `tongtien`, `sothang`, `tienhangthang`, `time`, `tratruoc`, `ngaytragop`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";;
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, acc.getId());
            ps.setString(2, traGop.getTen());
            ps.setString(3, traGop.getBank());
            ps.setDouble(4, traGop.getTongtien());
            ps.setInt(5, traGop.getSothang());
            ps.setDouble(6, traGop.getTienhangthang());
            ps.setTimestamp(7, traGop.getTime());
            ps.setDouble(8, traGop.getTratruoc());
            ps.setInt(9, traGop.getNgaytragop());

            int executeUpdate = ps.executeUpdate();
            System.out.println(traGop.toString());
            System.out.println("thêm thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<TraGopModel> getAll(UserModel user) {
        String sql = "select * from tragop where uid=?";
        int x = user.getId();
        ResultSet rs;
        ArrayList<TraGopModel> traGopModels = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, x);
            rs = ps.executeQuery();
            while (rs.next()) {
                TraGopModel traGopModel = new TraGopModel();
                traGopModel.setId(rs.getInt("id"));
                traGopModel.setTen(rs.getString("name"));
                traGopModel.setBank(rs.getString("namecongty"));
                traGopModel.setTratruoc(rs.getDouble("tratruoc"));
                traGopModel.setTongtien(rs.getDouble("tongtien"));
                traGopModel.setSothang(rs.getInt("sothang"));
                traGopModel.setTienhangthang(rs.getDouble("tienhangthang"));
                traGopModel.setTime(rs.getTimestamp("time"));
                traGopModels.add(traGopModel);
            }
            //"Tên", "Công ty", "Trả trước", "Tổng tiền (VNĐ)","Số tháng", "Tiền hàng tháng", "Ngày"
        } catch (Exception e) {
        }
        return traGopModels;
    }

    public void addTrans(TraGopTransModel traGop, UserModel user) {
         String sql = "INSERT INTO `tragoptrans` ( `tragopid`, `uid`, `name`, `namecongty`, `sotien`, `time`) VALUES ( ?, ?, ?, ?, ?, ?)";;
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, traGop.getTraGopID());
            ps.setInt(2, user.getId());
            ps.setString(3, traGop.getTen());
            ps.setString(4, traGop.getBank());
            ps.setDouble(5, traGop.getSotien());
            ps.setTimestamp(6, traGop.getTime());
            
            

            int executeUpdate = ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("thêm trả góp trans thất bại");
            e.printStackTrace();
        }
    }

    public int getIDByName(TraGopModel traGopModel, UserModel acc) {
        String sql = "select * from tragop where uid LIKE ? and name LIKE ?";
        int x = acc.getId();
        ResultSet rs;
        int id = 0;
        ArrayList<TraGopModel> traGopModels = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            
            ps.setInt(1, x);
            ps.setString(2, traGopModel.getTen());
            
            rs = ps.executeQuery();
            while (rs.next()) {
               
                id = (rs.getInt("id"));
               
            }
        } catch (Exception e) {
            System.out.println("Không tìm thấy khoản trả góp");
        }
        return id;
    }
}
