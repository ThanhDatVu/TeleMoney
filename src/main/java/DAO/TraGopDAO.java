/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.GuiTienModel;
import Model.MyStockBuyModel;
import Model.TraGopModel;
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
    
    public void add(TraGopModel traGop, UserModel acc){
        String sql = "INSERT INTO `tragop` (`uid`, `name`, `namecongty`, `tongtien`, `sothang`, `tienhangthang`, `time`, `tratruoc`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";;
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
}
