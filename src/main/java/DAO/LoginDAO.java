/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.NhanvienModel;
import Model.NhanvienTableModel;
import Model.UserModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author dat26
 */
public class LoginDAO {

    private Connection con;

    public LoginDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/telemoney", "root", "");
//here sonoo is database name, root is username and password  

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public UserModel login(String tenDangNhap, String matKhau) {
        String sql = "select * from USER where USERNAME LIKE ? and PASSWORD LIKE ?";

        UserModel user = null;
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, tenDangNhap);
            ps.setString(2, matKhau);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new UserModel();
                user.setUsername(rs.getString("USERNAME"));
                user.setPassword(rs.getString("PASSWORD"));
                user.setId(rs.getInt("ID"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public void dangky(String username, String password) {
        String sql = "INSERT INTO `user`( `USERNAME`, `PASSWORD`,`sodu`) VALUES (?,?,0)";

        UserModel user = null;
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

}
