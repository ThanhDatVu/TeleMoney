/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.ChiTableModel;
import Model.ChiModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

    public void refresh(ChiTableModel chimodel) {
        chimodel.setRowCount(0);
        addall(chimodel);
    }

    public void addall(ChiTableModel chimodel) {
        String sql = "select * from chi";

        ChiModel chi = null;
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                chi = new ChiModel();
                chi.setNameChi(rs.getString("Tên khoản thu"));
                chi.setMucChi(rs.getString("Danh mục"));
                chi.setAmountChi(rs.getDouble("Số tiền"));
                chi.setTimeChi(rs.getTime("Ngày"));
                chimodel.addRow(new Object[]{chi.getNameChi(), chi.getMucChi(), chi.getAmountChi(), chi.getTimeChi()});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void add(ChiModel chi) {
        String sql = "INSERT INTO chi (namechi, mucchi, amountchi, timechi) VALUES (?,?,?,?)";

        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, chi.getNameChi());
            ps.setString(2, chi.getMucChi());
            ps.setDouble(3, chi.getAmountChi());
            ps.setTime(4, chi.getTimeChi());

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
            ps.setTime(4, chi.getTimeChi());

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
            ps.setTime(4, chi.getTimeChi());
            

            int executeUpdate = ps.executeUpdate();
            
            System.out.println("Xoá thành công");
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

}
