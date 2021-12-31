/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.ThuModel;
import Model.ThuTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author dat26
 */
public class ThuDAO {

    private Connection con;

    public ThuDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/telemoney", "root", "");
//here sonoo is database name, root is username and password  

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void refresh(ThuTableModel thumodel) {
        thumodel.setRowCount(0);
        addall(thumodel);
    }

    public void addall(ThuTableModel thumodel) {
        String sql = "select * from thu";

        ThuModel thu = null;
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                thu = new ThuModel();
                thu.setNameThu(rs.getString("Tên khoản thu"));
                thu.setMucThu(rs.getString("Danh mục"));
                thu.setAmountThu(rs.getDouble("Số tiền"));
                thu.setTimeThu(rs.getTime("Ngày"));
                thumodel.addRow(new Object[]{thu.getNameThu(), thu.getMucThu(), thu.getAmountThu(), thu.getTimeThu()});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void add(ThuModel thu) {
        String sql = "INSERT INTO thu (namethu, mucthu, amountthu, timethu) VALUES (?,?,?,?)";

        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, thu.getNameThu());
            ps.setString(2, thu.getMucThu());
            ps.setDouble(3, thu.getAmountThu());
            ps.setTime(4, thu.getTimeThu());

            int executeUpdate = ps.executeUpdate();
            System.out.println(thu.toString());
            System.out.println("Thêm thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(ThuModel thu, ThuModel thu2) {
        //To change body of generated methods, choose Tools | Templates.
        String sql = "UPDATE thu SET namethu = ?, mucthu = ?, amoutthu = ?, timethu = ?  WHERE ID = ?;";

        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, thu.getNameThu());
            ps.setString(2, thu.getMucThu());
            ps.setDouble(3, thu.getAmountThu());
            ps.setTime(4, thu.getTimeThu());

            int executeUpdate = ps.executeUpdate();
            System.out.println(thu2.toString());
            System.out.println("Sửa thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    

    public void delete(ThuModel thu) {
       String sql = "DELETE FROM thu WHERE namethu = ? and mucthu = ? and amountthu = ? and timethu = ?";;

        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, thu.getNameThu());
            ps.setString(2, thu.getMucThu());
            ps.setDouble(3, thu.getAmountThu());
            ps.setTime(4, thu.getTimeThu());
            

            int executeUpdate = ps.executeUpdate();
            
            System.out.println("Xoá thành công");
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

}
