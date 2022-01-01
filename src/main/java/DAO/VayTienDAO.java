/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.GuiTienModel;
import Model.MyStockBuyModel;
import Model.UserModel;
import Model.VayTienModel;
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
public class VayTienDAO {
    private Connection con;
    private UserModel userModel;
    
    public VayTienDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/telemoney", "root", "");
//here sonoo is database name, root is username and password  

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void add(VayTienModel vayTien, UserModel acc){
        String sql = "INSERT INTO `vay` (`uid`, `ten`, `bank`, `tiengoc`, `laisuat`, `kyhan`, `ngayvay`) VALUES (?, ?, ?, ?, ?, ?, ?)";;
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, acc.getId());
            ps.setString(2, vayTien.getTen());
            ps.setString(3, vayTien.getBank());
            ps.setDouble(4, vayTien.getTiengoc());
            ps.setDouble(5, vayTien.getLaisuat());
            ps.setDouble(6, vayTien.getKyhan());
            ps.setTimestamp(7, vayTien.getNgayvay());
            
            int executeUpdate = ps.executeUpdate();
            System.out.println(vayTien.toString());
            System.out.println("thêm thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<VayTienModel> getAll(UserModel user) {
        String sql = "select * from vay where uid=?";
        int x = user.getId();
        ResultSet rs;
        ArrayList<VayTienModel> vayTienModels = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, x);
            rs = ps.executeQuery();
            while (rs.next()) {
                VayTienModel vayTienModel = new VayTienModel();
                vayTienModel.setId(rs.getInt("id"));
                vayTienModel.setTen(rs.getString("ten"));
                vayTienModel.setBank(rs.getString("bank"));
                vayTienModel.setTiengoc(rs.getDouble("tiengoc"));
                vayTienModel.setLaisuat(rs.getDouble("laisuat"));
                vayTienModel.setKyhan(rs.getInt("kyhan"));
                vayTienModel.setNgayvay(rs.getTimestamp("ngayvay"));
                vayTienModels.add(vayTienModel);
            }
        } catch (Exception e) {
        }
        return vayTienModels;
    }
    
    public void delete(VayTienModel vayTienModel, UserModel acc) {
       String sql = "DELETE FROM vay WHERE uid = ?, ten = ?, tiengoc=?";;
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, acc.getId());
            ps.setString(2, vayTienModel.getTen());
            ps.setDouble(3, vayTienModel.getTiengoc());
            int executeUpdate = ps.executeUpdate();           
            System.out.println("Xoá");
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
}
