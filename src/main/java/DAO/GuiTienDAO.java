/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.GuiTienModel;
import Model.GuiTienTransModel;
import Model.MyStockBuyModel;
import Model.TraGopTransModel;
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
public class GuiTienDAO {

    private Connection con;
    private UserModel userModel;

    public GuiTienDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/telemoney", "root", "");
//here sonoo is database name, root is username and password  

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void add(GuiTienModel guiTien, UserModel userModel) {
        String sql = "INSERT INTO `chovay` (`uid`, `ten`, `bank`, `tiengoc`, `laisuat`, `kyhan`, `ngaychovay`, `ngaythulai`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";;
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, userModel.getId());
            ps.setString(2, guiTien.getTen());
            ps.setString(3, guiTien.getBank());
            ps.setDouble(4, guiTien.getTiengoc());
            ps.setDouble(5, guiTien.getLaisuat());
            ps.setDouble(6, guiTien.getKyhan());
            ps.setTimestamp(7, guiTien.getNgaygui());
            ps.setInt(8, guiTien.getNgaythulai());

            int executeUpdate = ps.executeUpdate();
            System.out.println(guiTien.toString());
            System.out.println("thêm thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<GuiTienModel> getAll(UserModel user) {
        String sql = "select * from chovay where uid=?";
        int x = user.getId();
        ResultSet rs;
        ArrayList<GuiTienModel> guiTienModels = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, x);
            rs = ps.executeQuery();
            while (rs.next()) {
                GuiTienModel guiTienModel = new GuiTienModel();
                guiTienModel.setId(rs.getInt("id"));
                guiTienModel.setTen(rs.getString("ten"));
                guiTienModel.setBank(rs.getString("bank"));
                guiTienModel.setTiengoc(rs.getDouble("tiengoc"));
                guiTienModel.setLaisuat(rs.getDouble("laisuat"));
                guiTienModel.setKyhan(rs.getInt("kyhan"));
                guiTienModel.setNgaygui(rs.getTimestamp("ngaychovay"));
                guiTienModels.add(guiTienModel);
            }
        } catch (Exception e) {
        }
        return guiTienModels;
    }

    public void delete(GuiTienModel guiTienModel, UserModel acc) {
        String sql = "DELETE FROM chovay WHERE uid = ?, ten = ?, tiengoc=?";;
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, acc.getId());
            ps.setString(2, guiTienModel.getTen());
            ps.setDouble(3, guiTienModel.getTiengoc());
            int executeUpdate = ps.executeUpdate();
            System.out.println("Xoá");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addTrans(GuiTienTransModel guiTien, UserModel user) {
        String sql = "INSERT INTO `chovaytrans` ( `chovayid`, `uid`, `name`, `bank`, `sotien`, `time`) VALUES ( ?, ?, ?, ?, ?, ?)";;
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, guiTien.getGuiTienID());
            ps.setInt(2, user.getId());
            ps.setString(3, guiTien.getTen());
            ps.setString(4, guiTien.getBank());
            ps.setDouble(5, guiTien.getSotien());
            ps.setTimestamp(6, guiTien.getTime());

            int executeUpdate = ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("thêm vay tiền trans thất bại");
            e.printStackTrace();
        }
    }

    public int getIDByName(GuiTienModel guiTienModel, UserModel acc) {
        String sql = "select * from chovay where uid LIKE ? and ten LIKE ?";
        int x = acc.getId();
        ResultSet rs;
        int id = 0;
        ArrayList<GuiTienModel> guiTienModels = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);

            ps.setInt(1, x);
            ps.setString(2, guiTienModel.getTen());

            rs = ps.executeQuery();
            while (rs.next()) {

                id = (rs.getInt("id"));

            }
        } catch (Exception e) {
        }
        return id;
    }

    public ArrayList<GuiTienTransModel> getAllTrans(UserModel user) {
        ArrayList<GuiTienTransModel> guiTienTransList = new ArrayList<>();
        String sql = "select * from chovaytrans where uid=?";
        int x = user.getId();
        ResultSet rs;

        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, x);
            rs = ps.executeQuery();
            while (rs.next()) {
                GuiTienTransModel guiTienTrans = new GuiTienTransModel();
                guiTienTrans.setId(rs.getInt("id"));
                guiTienTrans.setTen(rs.getString("name"));
                guiTienTrans.setBank(rs.getString("bank"));
                guiTienTrans.setStatus(rs.getString("status"));
                guiTienTrans.setGuiTienID(rs.getInt("chovayid"));
                guiTienTrans.setTime(rs.getTimestamp("time"));
                guiTienTrans.setSotien(rs.getDouble("sotien"));
                guiTienTransList.add(guiTienTrans);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return guiTienTransList;
    }

    public ArrayList<GuiTienTransModel> getTrans(UserModel user, int guiTienID) {
        ArrayList<GuiTienTransModel> guiTienTransList = new ArrayList<>();
        String sql = "select * from chovaytrans where uid=? and chovayid = ?";
        int x = user.getId();
        ResultSet rs;

        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, x);
            ps.setInt(2, guiTienID);
            rs = ps.executeQuery();
            while (rs.next()) {
                GuiTienTransModel guiTienTrans = new GuiTienTransModel();
                guiTienTrans.setId(rs.getInt("id"));
                guiTienTrans.setTen(rs.getString("name"));
                guiTienTrans.setBank(rs.getString("bank"));
                guiTienTrans.setStatus(rs.getString("status"));
                guiTienTrans.setGuiTienID(rs.getInt("chovayid"));
                guiTienTrans.setTime(rs.getTimestamp("time"));
                guiTienTrans.setSotien(rs.getDouble("sotien"));
                guiTienTransList.add(guiTienTrans);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return guiTienTransList;
    }

    public void thanhToan(GuiTienTransModel guiTien) {
        String sql = "UPDATE chovaytrans SET status = ? WHERE id = ?;";;

        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, "đã thanh toán");
            ps.setInt(2, guiTien.getId());

            int executeUpdate = ps.executeUpdate();
            System.out.println(guiTien.toString());
            System.out.println("Thanh toán thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
