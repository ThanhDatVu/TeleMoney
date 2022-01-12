/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.GuiTienDAO;
import DAO.TraGopDAO;
import DAO.VayTienDAO;
import Model.GuiTienTransModel;
import Model.TraGopModel;
import Model.TraGopTransModel;
import Model.UserModel;
import Model.VayTienTransModel;
import View.ThanhToanView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dat26
 */
public class ThanhToanController {

    DecimalFormat df = new DecimalFormat("0");
    ThanhToanView thanhToanView;
    private GuiTienDAO guiTienDAO = null;
    private VayTienDAO vayTienDAO = null;
    private TraGopDAO traGopDAO = null;
    UserModel acc;

    public ThanhToanController() {
    }

    public ThanhToanController(ThanhToanView thanhToanView, TraGopTransModel traGop) {
        this.thanhToanView = thanhToanView;
        this.acc = thanhToanView.user;
        this.traGopDAO = new TraGopDAO();
        setDataTraGop(traGop);
    }

    public ThanhToanController(ThanhToanView thanhToanView, VayTienTransModel vayTien) {
        this.thanhToanView = thanhToanView;
        this.acc = thanhToanView.user;
        this.vayTienDAO = new VayTienDAO();
        setDataVayTien(vayTien);
    }

    public ThanhToanController(ThanhToanView thanhToanView, GuiTienTransModel guiTien) {
        this.thanhToanView = thanhToanView;
        this.acc = thanhToanView.user;
        this.guiTienDAO = new GuiTienDAO();
        setDataGuiTien(guiTien);
    }

    public void setDataTraGop(TraGopTransModel traGop) {//thêm dũ liệu vào bảng
        thanhToanView.labelThongBao.setText("<html><p style=\"width:300px\">" + "Bạn có một giao dịch trả góp đến hạn thanh toán: " + traGop.toReadableString() + "</p></html>");
        thanhToanView.btnThanhToan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                traGopDAO.thanhToan(traGop);
                thanhToanView.masterTeleMoneyView.soDuKhaDung -= traGop.getSotien();
                thanhToanView.masterTeleMoneyView.refreshTabVayNo();
                thanhToanView.dispose();
            }
        });
        thanhToanView.btnHuy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                thanhToanView.dispose();
            }
        });
    }

    public void setDataGuiTien(GuiTienTransModel guiTien) {//thêm dũ liệu vào bảng
        thanhToanView.labelThongBao.setText("<html><p style=\"width:300px\">" + "Bạn có một giao dịch nhận lãi đến hạn thanh toán: " + guiTien.toReadableString() + "</p></html>");
        thanhToanView.btnThanhToan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guiTienDAO.thanhToan(guiTien);
                thanhToanView.masterTeleMoneyView.soDuKhaDung += guiTien.getSotien();
                thanhToanView.masterTeleMoneyView.refreshTabVayNo();
                thanhToanView.dispose();
            }
        });
        thanhToanView.btnHuy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                thanhToanView.dispose();
            }
        });
    }

    public void setDataVayTien(VayTienTransModel vayTien) {//thêm dũ liệu vào bảng
        thanhToanView.labelThongBao.setText("<html><p style=\"width:300px\">" + "Bạn có một giao dịch trả lãi đến hạn thanh toán: " + vayTien.toReadableString() + "</p></html>");
        thanhToanView.btnThanhToan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vayTienDAO.thanhToan(vayTien);
                thanhToanView.masterTeleMoneyView.soDuKhaDung -= vayTien.getSotien();
                thanhToanView.masterTeleMoneyView.refreshTabVayNo();
                thanhToanView.dispose();
            }
        });
        thanhToanView.btnHuy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                thanhToanView.dispose();
            }
        });
    }

}
