/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.ChiModel;
import Model.ThuModel;
import Model.ThuTableModel;
import Model.UserModel;
import Model.ThuModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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

    public ArrayList<ThuModel> getAll(UserModel user) {
        String sql = "select * from thu where uid=?";
        int x = user.getId();
        ResultSet rs;
        ArrayList<ThuModel> thuModels = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, x);
            rs = ps.executeQuery();
            while (rs.next()) {
                ThuModel thuModel = new ThuModel();
                thuModel.setIdThu(rs.getInt("id"));
                thuModel.setNameThu(rs.getString("namethu"));
                thuModel.setAmountThu(rs.getDouble("amountthu"));
                thuModel.setMucThu(rs.getString("mucthu"));
                thuModel.setTimestampThu(rs.getTimestamp("datethu"));

                thuModels.add(thuModel);
            }
        } catch (Exception e) {
        }
        return thuModels;
    }

    public void add(ThuModel thu, UserModel acc) {
        String sql = "INSERT INTO thu (namethu, mucthu, amountthu, datethu,uid) VALUES (?,?,?,?,?)";

        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, thu.getNameThu());
            ps.setString(2, thu.getMucThu());
            ps.setDouble(3, thu.getAmountThu());
            ps.setTimestamp(4, thu.getTimestampThu());
            ps.setInt(5, acc.getId());

            int executeUpdate = ps.executeUpdate();
            System.out.println(thu.toString());
            System.out.println("Thêm thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(ThuModel thu, ThuModel thu2) {
        //To change body of generated methods, choose Tools | Templates.
        String sql = "UPDATE thu SET namethu = ?, mucthu = ?, amountthu = ?, datethu = ?  WHERE ID = ?;";

        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, thu2.getNameThu());
            ps.setString(2, thu2.getMucThu());
            ps.setDouble(3, thu2.getAmountThu());
            ps.setTimestamp(4, thu2.getTimestampThu());
            ps.setInt(5, thu.getIdThu());

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
            ps.setTimestamp(4, thu.getTimestampThu());

            int executeUpdate = ps.executeUpdate();

            System.out.println("Xoá thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(int thuID) {
        String sql = "DELETE FROM thu WHERE ID = ?";;

        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, thuID);

            int executeUpdate = ps.executeUpdate();

            System.out.println("Xoá thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ThuModel getByID(int id) {
        String sql = "select * from thu where id=?";
        ResultSet rs;
        ThuModel thuModel = new ThuModel();
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                thuModel.setIdThu(rs.getInt("id"));
                thuModel.setNameThu(rs.getString("namethu"));
                thuModel.setAmountThu(rs.getDouble("amountthu"));
                thuModel.setMucThu(rs.getString("mucthu"));
                thuModel.setTimestampThu(rs.getTimestamp("datethu"));

            }
        } catch (Exception e) {
        }
        return thuModel;
    }

}
