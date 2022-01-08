/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ChiDAO;
import DAO.StockDAO;
import Model.ChiModel;
import Model.UserModel;
import View.ThemChiView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.Time;
import javax.swing.JOptionPane;
import java.sql.Timestamp;

public class ThemChiController {

    ThemChiView themChiView;
    UserModel acc;
    ChiDAO chiDAO = null;
    ChiModel chiModel = new ChiModel();
    StockDAO stockDAO;
    double soDu;

    public ThemChiController(ThemChiView themChiView, UserModel acc) {
        chiDAO = new ChiDAO();
        stockDAO = new StockDAO();
        this.themChiView = themChiView;
        this.acc = acc;
        soDu = stockDAO.getSoDu(acc);
        setEventThemChi();
        //setData();
        //setTableButton();

    }

    public void setEventThemChi() {
        System.out.println("Tao event");
        themChiView.btnDongYChi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                double x = Double.parseDouble(themChiView.soTienChi.getText());
                if (x > soDu) {
                    JOptionPane.showMessageDialog(null, "Vượt quá số dư khả dụng");
                } else if (x <= 0) {
                    JOptionPane.showMessageDialog(null, "Nhập sai");
                } else {
                    int opt = JOptionPane.showConfirmDialog(themChiView, "Xác nhận thêm", "Xác nhận", JOptionPane.YES_NO_OPTION);
                    if (opt == 0) {
                        //String ten, String bank, double tiengoc, double laisuat, int kyhan, Timestamp ngaygui
                        chiModel.setNameChi(themChiView.tenChi.getText());
                        chiModel.setMucChi(themChiView.danhMucChi.getSelectedItem().toString());
                        chiModel.setAmountChi(Double.parseDouble(themChiView.soTienChi.getText()));
                        Timestamp time = new Timestamp(System.currentTimeMillis());
                        chiModel.setTimestampChi(time);
                        chiDAO.add(chiModel, acc);
                        System.out.println(chiModel.toString());
                        themChiView.master.soDuKhaDung = themChiView.master.soDuKhaDung - Double.parseDouble(themChiView.soTienChi.getText());
                        themChiView.master.refreshTabThuChi();
                        themChiView.dispose();
                    }
                }
            }
        }
        );

    }
}
