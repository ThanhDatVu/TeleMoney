/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.VayTienModel;
import Model.MyStockBuyModel;
import Model.UserModel;
import Model.VayTienModel;
import Model.VayTienTransModel;
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

    public void add(VayTienModel vayTien, UserModel acc) {
        String sql = "INSERT INTO `vay` (`uid`, `ten`, `bank`, `tiengoc`, `laisuat`, `kyhan`, `ngayvay`, `ngaytralai`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";;
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, acc.getId());
            ps.setString(2, vayTien.getTen());
            ps.setString(3, vayTien.getBank());
            ps.setDouble(4, vayTien.getTiengoc());
            ps.setDouble(5, vayTien.getLaisuat());
            ps.setDouble(6, vayTien.getKyhan());
            ps.setTimestamp(7, vayTien.getNgayvay());
            ps.setInt(8, vayTien.getNgaytralai());

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

    public int getIDByName(VayTienModel vayTienModel, UserModel acc) {
        String sql = "select * from vay where uid LIKE ? and ten LIKE ?";
        int x = acc.getId();
        ResultSet rs;
        int id = 0;
        ArrayList<VayTienModel> vayTienModels = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);

            ps.setInt(1, x);
            ps.setString(2, vayTienModel.getTen());

            rs = ps.executeQuery();
            while (rs.next()) {

                id = (rs.getInt("id"));

            }
        } catch (Exception e) {
        }
        return id;
    }

    public void addTrans(VayTienTransModel vayTien, UserModel user) {
        String sql = "INSERT INTO `vaytrans` ( `vayid`, `uid`, `name`, `bank`, `sotien`, `time`) VALUES ( ?, ?, ?, ?, ?, ?)";;
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, vayTien.getVayTienID());
            ps.setInt(2, user.getId());
            ps.setString(3, vayTien.getTen());
            ps.setString(4, vayTien.getBank());
            ps.setDouble(5, vayTien.getSotien());
            ps.setTimestamp(6, vayTien.getTime());

            int executeUpdate = ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("thêm vay tiền trans thất bại");
            e.printStackTrace();
        }
    }

    public ArrayList<VayTienTransModel> getAllTrans(UserModel user) {
        ArrayList<VayTienTransModel> vayTienTransList = new ArrayList<>();
        String sql = "select * from vaytrans where uid=?";
        int x = user.getId();
        ResultSet rs;

        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, x);
            rs = ps.executeQuery();
            while (rs.next()) {
                VayTienTransModel vayTienTrans = new VayTienTransModel();
                vayTienTrans.setId(rs.getInt("id"));
                vayTienTrans.setTen(rs.getString("name"));
                vayTienTrans.setBank(rs.getString("bank"));
                vayTienTrans.setStatus(rs.getString("status"));
                vayTienTrans.setVayTienID(rs.getInt("vayid"));
                vayTienTrans.setTime(rs.getTimestamp("time"));
                vayTienTrans.setSotien(rs.getDouble("sotien"));
                vayTienTransList.add(vayTienTrans);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vayTienTransList;
    }

    public ArrayList<VayTienTransModel> getTrans(UserModel user, int vayTienID) {
        ArrayList<VayTienTransModel> vayTienTransList = new ArrayList<>();
        String sql = "select * from vaytrans where uid=? and vayid = ?";
        int x = user.getId();
        ResultSet rs;

        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, x);
            ps.setInt(2, vayTienID);
            rs = ps.executeQuery();
            while (rs.next()) {
                VayTienTransModel vayTienTrans = new VayTienTransModel();
                vayTienTrans.setId(rs.getInt("id"));
                vayTienTrans.setTen(rs.getString("name"));
                vayTienTrans.setBank(rs.getString("bank"));
                vayTienTrans.setStatus(rs.getString("status"));
                vayTienTrans.setVayTienID(rs.getInt("vayid"));
                vayTienTrans.setTime(rs.getTimestamp("time"));
                vayTienTrans.setSotien(rs.getDouble("sotien"));
                vayTienTransList.add(vayTienTrans);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vayTienTransList;
    }

    public void thanhToan(VayTienTransModel vayTien) {
        String sql = "UPDATE vaytrans SET status = ? WHERE id = ?;";;

        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, "đã thanh toán");
            ps.setInt(2, vayTien.getId());

            int executeUpdate = ps.executeUpdate();
            System.out.println(vayTien.toString());
            System.out.println("Thanh toán thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
