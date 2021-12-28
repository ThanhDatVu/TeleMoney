/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.MyStockBuyModel;
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
public class StockDAO {

    private Connection con;

    public StockDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/telemoney", "root", "");
//here sonoo is database name, root is username and password  

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void add(MyStockBuyModel myStock) {
        String sql = "INSERT INTO `mystock` (`symbol`, `name`, `soluong`, `tongbandau`, `giabandau`, `time`) VALUES (?, ?, ?, ?, ?, ?)";;

        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, myStock.getSymbol());
            ps.setString(2, myStock.getName());
            ps.setInt(3, myStock.getSoLuong());
            ps.setFloat(4, myStock.getTongBanDau());
            ps.setFloat(5, myStock.getGiaBanDau());
            ps.setString(6, myStock.getTime().toString());

            int executeUpdate = ps.executeUpdate();
            System.out.println(myStock.toString());
            System.out.println("thêm thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
