/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.ChiTableModel;
import Model.ChiModel;
import Model.UserModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author dat26
 */
public class ChiDAO {

    private Connection con;

    public ChiDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/telemoney", "root", "");
//here sonoo is database name, root is username and password  

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    

   public ArrayList<ChiModel> getAll(UserModel user) {
        String sql = "select * from chi where uid=?";
        int x = user.getId();
        ResultSet rs;
        ArrayList<ChiModel> chiModels = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, x);
            rs = ps.executeQuery();
            while (rs.next()) {
                ChiModel chiModel = new ChiModel();
                chiModel.setIdChi(rs.getInt("id"));
                chiModel.setNameChi(rs.getString("namechi"));
                chiModel.setAmountChi(rs.getDouble("amountchi"));
                chiModel.setMucChi(rs.getString("mucchi"));
                chiModel.setTimestampChi(rs.getTimestamp("datechi"));
                
                chiModels.add(chiModel);
            }
        } catch (Exception e) {
        }
        return chiModels;
    }
    public void add(ChiModel chi, UserModel user) {
        String sql = "INSERT INTO chi (namechi, mucchi, amountchi, timechi, uid) VALUES (?,?,?,?,?)";

        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, chi.getNameChi());
            ps.setString(2, chi.getMucChi());
            ps.setDouble(3, chi.getAmountChi());
            ps.setTimestamp(4, chi.getTimestampChi());
            ps.setInt(5, user.getId());
            int executeUpdate = ps.executeUpdate();
            System.out.println(chi.toString());
            System.out.println("Thêm thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(ChiModel chi, ChiModel chi2) {
        //To change body of generated methods, choose Tools | Templates.
        String sql = "UPDATE chi SET namechi = ?, mucchi = ?, amoutchi = ?, timechi = ?  WHERE ID = ?;";

        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, chi.getNameChi());
            ps.setString(2, chi.getMucChi());
            ps.setDouble(3, chi.getAmountChi());
            ps.setTimestamp(4, chi.getTimestampChi());

            int executeUpdate = ps.executeUpdate();
            System.out.println(chi2.toString());
            System.out.println("Sửa thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    

    public void delete(ChiModel chi) {
       String sql = "DELETE FROM chi WHERE namechi = ? and mucchi = ? and amountchi = ? and timechi = ?";;

        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, chi.getNameChi());
            ps.setString(2, chi.getMucChi());
            ps.setDouble(3, chi.getAmountChi());
            ps.setTimestamp(4, chi.getTimestampChi());
            

            int executeUpdate = ps.executeUpdate();
            
            System.out.println("Xoá thành công");
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

}
