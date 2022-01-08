/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.TraGopDAO;
import DAO.StockDAO;
import Model.GuiTienModel;
import Model.MyStockBuyModel;
import Model.TraGopModel;
import Model.UserModel;
import View.TraGopView;
import View.TraGopView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public class AddTraGopController {

    TraGopView traGopView;
    UserModel acc;
    TraGopDAO traGopDAO = null;
    TraGopModel traGopModel = new TraGopModel();
    StockDAO stockDAO;
    double soDu;

    public AddTraGopController(TraGopView traGopView, UserModel acc) {
        traGopDAO = new TraGopDAO();
        stockDAO = new StockDAO();
        this.traGopView = traGopView;
        this.acc = acc;
        traGopView.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        soDu = stockDAO.getSoDu(acc);
        setEventTraGop();
        traGopView.setVisible(true);
        //setData();
        //setTableButton();

    }

//    public void setButton(){
//    Action delete = new AbstractAction() {
//        public void actionPerformed(ActionEvent e) {
//            JTable table = (JTable) e.getSource();
//            int modelRow = Integer.valueOf(e.getActionCommand());
//            ((DefaultTableModel) table.getModel()).removeRow(modelRow);
//        }
//    };
//    ButtonColumn buttonColumn = new ButtonColumn(nhanvienView, delete, 2);
//
//    buttonColumn.setMnemonic (KeyEvent.VK_D);
//    
//    
//    }
    public void setEventTraGop() {
        System.out.println("Tao event");
        traGopView.btnThemTraGop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                double x = Double.parseDouble(traGopView.txtTien.getText());
                if (x > soDu) {
                    JOptionPane.showMessageDialog(null, "Vượt quá số dư khả dụng");
                } else if (x <= 0) {
                    JOptionPane.showMessageDialog(null, "Nhập sai");
                } else {
                    int opt = JOptionPane.showConfirmDialog(traGopView, "Xác nhận gửi " + " "
                            + " số tiền " + traGopView.txtTien.getText() + " VND ?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                    if (opt == 0) {
                        //String ten, String bank, double tongtien, double tienhangthang, int sothang, Timestamp time, double tratruoc
                        traGopModel.setTen(traGopView.txtTen.getText());
                        traGopModel.setBank(traGopView.txtBank.getText());
                        traGopModel.setTongtien(Double.parseDouble(traGopView.txtTien.getText()));
                        double a = Double.parseDouble(traGopView.txtTien.getText());
                        int b = Integer.parseInt(traGopView.cboThang.getSelectedItem().toString());
                        double c = Double.parseDouble(traGopView.txtTraTruoc.getText());
                        traGopModel.setTienhangthang(((a - c) / b));
                        traGopModel.setSothang(b);
                        traGopModel.setTratruoc(c);
                        Timestamp time = new Timestamp(System.currentTimeMillis());
                        traGopModel.setTime(time);
                        traGopDAO.add(traGopModel, acc);
                        traGopView.master.soDuKhaDung = traGopView.master.soDuKhaDung - Double.parseDouble(traGopView.txtTraTruoc.getText());
                        traGopView.master.refreshTabVayNo();
                        traGopView.dispose();
                    }
                }
            }
        }
        );

    }
}
