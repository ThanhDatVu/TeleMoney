/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.MyStockBuyModel;
import Model.NhanvienModel;
import Model.NhanvienTableModel;
import Model.UserModel;
import com.mysql.cj.result.LocalDateTimeValueFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Vector;
import java.sql.Timestamp;

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

    public ArrayList<MyStockBuyModel> getAll() {
        String sql = "select * from MYSTOCK";
        ResultSet rs;
        ArrayList<MyStockBuyModel> myStockList = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                MyStockBuyModel myStock = new MyStockBuyModel();
                myStock.setSymbol(rs.getString("SYMBOL"));
                myStock.setName(rs.getString("NAME"));
                myStock.setSoLuong(rs.getInt("SOLUONG"));
                myStock.setGiaBanDau(rs.getFloat("GIABANDAU"));

                myStock.setTime(rs.getTimestamp("TIME"));
                myStock.setSymbol(rs.getString("SYMBOL"));
                myStockList.add(myStock);
            }
        } catch (Exception e) {
        }
        return myStockList;
    }

    public MyStockBuyModel getStockBySymbol(String s) {
        String sql = "select * from mystock where SYMBOL LIKE ?";

        MyStockBuyModel myStock = null;
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, s);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                myStock = new MyStockBuyModel();
                myStock.setSymbol(rs.getString("SYMBOL"));
                myStock.setName(rs.getString("NAME"));
                myStock.setSoLuong(rs.getInt("SOLUONG"));
                myStock.setGiaBanDau(rs.getFloat("GIABANDAU"));

                myStock.setTime(rs.getTimestamp("TIME"));
                myStock.setSymbol(rs.getString("SYMBOL"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return myStock;
    }

    public double getSoDu(UserModel user) {
        int id = user.getId();
        String sql = "select * from tong where UID LIKE ?";
        double soDu = 0;
        MyStockBuyModel myStock = null;
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                soDu = (rs.getDouble("SODU"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return soDu;
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
            ps.setTimestamp(6, myStock.getTime());

            int executeUpdate = ps.executeUpdate();
            System.out.println(myStock.toString());
            System.out.println("thêm thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<MyStockBuyModel> getAllStockSymbol() {
        String sql = "select * from STOCK";
        ResultSet rs;
        ArrayList<MyStockBuyModel> myStockList = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                MyStockBuyModel myStock = new MyStockBuyModel();
                myStock.setSymbol(rs.getString("SYMBOL"));
                myStock.setName(rs.getString("COMPANY"));

                myStockList.add(myStock);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return myStockList;

    }
}
