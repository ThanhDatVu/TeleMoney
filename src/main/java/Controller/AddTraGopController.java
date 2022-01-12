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
import Model.TraGopModel;
import Model.TraGopTransModel;
import View.TraGopView;
import View.TraGopView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public class AddTraGopController {

    DecimalFormat df = new DecimalFormat("0");
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

                double x = Double.parseDouble(traGopView.txtTongTien.getText());
                if (x > soDu) {
                    JOptionPane.showMessageDialog(null, "Vượt quá số dư khả dụng");
                } else if (x <= 0) {
                    JOptionPane.showMessageDialog(null, "Nhập sai");
                } else {
                    int opt = JOptionPane.showConfirmDialog(traGopView, "Xác nhận thêm khoản trả góp " + traGopView.txtTen.getText() + " ?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                    if (opt == 0) {
                        //String ten, String bank, double tongtien, double tienhangthang, int sothang, Timestamp time, double tratruoc
                        traGopModel.setTen(traGopView.txtTen.getText());
                        traGopModel.setBank(traGopView.txtBank.getText());
                        traGopModel.setTongtien(Double.parseDouble(traGopView.txtTongTien.getText()));
                        double a = Double.parseDouble(traGopView.txtTongTien.getText());
                        int b = Integer.parseInt(traGopView.cboThang.getSelectedItem().toString());
                        double c = Double.parseDouble(traGopView.txtTraTruoc.getText());
                        traGopModel.setTienhangthang(Integer.parseInt(traGopView.txtTienHangThang.getText().toString()));
                        traGopModel.setSothang(b);
                        traGopModel.setTratruoc(c);
                        Timestamp time = new Timestamp(System.currentTimeMillis());
                        traGopModel.setTime(time);
                        traGopModel.setNgaytragop(Integer.parseInt(traGopView.txtNgayTraGop.getText().toString()));
                        traGopDAO.add(traGopModel, acc);
                        int id = traGopDAO.getIDByName(traGopModel, acc);;
                        themGiaoDich(traGopModel, acc, id);
                        traGopView.master.soDuKhaDung = traGopView.master.soDuKhaDung - Double.parseDouble(traGopView.txtTraTruoc.getText());

                        traGopView.master.refreshTabVayNo();
                        traGopView.dispose();
                    }
                }
            }
        }
        );

    }

    public void themGiaoDich(TraGopModel traGopModel, UserModel user, int traGopID) {
        traGopModel.getTime().setDate(traGopModel.getNgaytragop());

        LocalDateTime localDateTime = traGopModel.getTime().toLocalDateTime();
        TraGopTransModel traTruocTrans = new TraGopTransModel();
        traTruocTrans.setTraGopID(traGopID);
        traTruocTrans.setTen("Trả trước " + df.format(traGopModel.getTratruoc()) + " - " + traGopModel.getTen());
        traTruocTrans.setSotien(traGopModel.getTratruoc());
        traTruocTrans.setBank(traGopModel.getBank());

        traTruocTrans.setTime(Timestamp.valueOf(LocalDateTime.now()));
        traGopDAO.addDoneTrans(traTruocTrans, user);
        for (int i = 1; i <= traGopModel.getSothang(); i++) {
            TraGopTransModel traGopTransModel = new TraGopTransModel();
            traGopTransModel.setTraGopID(traGopID);
            traGopTransModel.setTen("Trả góp lần " + df.format(i) + " - " + traGopModel.getTen());
            traGopTransModel.setSotien(Float.parseFloat(traGopView.txtTienHangThang.getText()));
            traGopTransModel.setBank(traGopModel.getBank());

            LocalDateTime newDate = localDateTime.plusMonths(i - 1);

            System.out.println("tháng" + newDate.toString());
            Timestamp timeStamp = Timestamp.valueOf(newDate);
            traGopTransModel.setTime(timeStamp);
            traGopDAO.addTrans(traGopTransModel, user);
        }

    }
}
