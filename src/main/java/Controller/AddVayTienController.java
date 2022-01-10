/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.VayTienDAO;
import DAO.StockDAO;
import Model.GuiTienModel;
import Model.MyStockBuyModel;
import Model.UserModel;
import Model.VayTienModel;
import Model.VayTienTransModel;
import View.VayTienView;
import View.VayTienView;
import View.VayTienView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public class AddVayTienController {

    VayTienView vayTienView;
    UserModel acc;
    VayTienDAO vayTienDAO = null;
    VayTienModel vayTienModel = new VayTienModel();
    StockDAO stockDAO;
    double soDu;

    public AddVayTienController(VayTienView vayTienView, UserModel acc) {
        vayTienDAO = new VayTienDAO();
        stockDAO = new StockDAO();
        this.vayTienView = vayTienView;
        this.acc = acc;
        vayTienView.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        soDu = stockDAO.getSoDu(acc);
        setEventVayTien();
        vayTienView.setVisible(true);
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
    public void setEventVayTien() {
        System.out.println("Tao event");
        vayTienView.btnThemVayTien.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                double x = Double.parseDouble(vayTienView.txtTien.getText());
                if (x <= 0) {
                    JOptionPane.showMessageDialog(null, "Nhập sai");
                } else {
                    int opt = JOptionPane.showConfirmDialog(vayTienView, "Xác nhận vay " + vayTienView.cboBank.getSelectedItem().toString() + " "
                            + " số tiền " + vayTienView.txtTien.getText() + " VND ?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                    if (opt == 0) {
                        //String ten, String bank, double tiengoc, double laisuat, int kyhan, Timestamp ngayvay
                        vayTienModel.setTen(vayTienView.txtTen.getText());
                        vayTienModel.setBank(vayTienView.cboBank.getSelectedItem().toString());
                        vayTienModel.setTiengoc(Double.parseDouble(vayTienView.txtTien.getText()));
                        vayTienModel.setLaisuat(Double.parseDouble(vayTienView.txtLaisuat.getText()));
                        vayTienModel.setKyhan(Integer.parseInt(vayTienView.cboKyHan.getSelectedItem().toString()));
                        vayTienModel.setNgaytralai(Integer.parseInt(vayTienView.txtNgayTraLai.getText().toString()));
                        Timestamp time = new Timestamp(System.currentTimeMillis());
                        vayTienModel.setNgayvay(time);
                        vayTienDAO.add(vayTienModel, acc);
                        int idVayTien = vayTienDAO.getIDByName(vayTienModel, acc);
                        themGiaoDich(vayTienModel, acc, idVayTien);

                        vayTienView.master.soDuKhaDung = vayTienView.master.soDuKhaDung + Double.parseDouble(vayTienView.txtTien.getText());
                        vayTienView.master.refreshTabVayNo();
                        vayTienView.dispose();
                    }
                }
            }
        }
        );

        vayTienView.cboKyHan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tinhLaiHangThang();
            }
        });
        vayTienView.txtTien.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                tinhLaiHangThang();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                tinhLaiHangThang();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                tinhLaiHangThang();
            }

        }
        );
        vayTienView.txtLaisuat.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                tinhLaiHangThang();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                tinhLaiHangThang();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                tinhLaiHangThang();
            }

        }
        );

    }

    public void tinhLaiHangThang() throws NumberFormatException {
        double laiXuat = 1;
        double soTien = 1;
        double kyHan = 1;
        {

            soTien = Double.parseDouble(vayTienView.txtTien.getText());
            laiXuat = Double.parseDouble(vayTienView.txtLaisuat.getText());
            kyHan = Double.parseDouble(vayTienView.cboKyHan.getSelectedItem().toString());

            if (soTien > -1 && laiXuat > -1) {
                vayTienView.txtLai.setEditable(true);
                double laihangthang;
                laihangthang = (soTien * (laiXuat / 12)) / 100;

                vayTienView.txtLai.setText(String.valueOf(Math.round(laihangthang)));

                vayTienView.txtLai.setEditable(false);

            }

        }

    }

    public void themGiaoDich(VayTienModel vayTienModel, UserModel user, int vayTienID) {
        vayTienModel.getNgayvay().setDate(vayTienModel.getNgaytralai());

        LocalDateTime localDateTime = vayTienModel.getNgayvay().toLocalDateTime();
        for (int i = 1; i <= vayTienModel.getKyhan(); i++) {
            VayTienTransModel vayTienTransModel = new VayTienTransModel();
            vayTienTransModel.setVayTienID(vayTienID);
            vayTienTransModel.setTen("Trả lãi lần " + i + " - " + vayTienModel.getTen());
            vayTienTransModel.setSotien(Float.parseFloat(vayTienView.txtLai.getText()));
            vayTienTransModel.setBank(vayTienModel.getBank());

            LocalDateTime newDate = localDateTime.plusMonths(i - 1);

            System.out.println("tháng" + newDate.toString());
            Timestamp timeStamp = Timestamp.valueOf(newDate);
            vayTienTransModel.setTime(timeStamp);
            vayTienDAO.addTrans(vayTienTransModel, user);
        }
        VayTienTransModel traGoc = new VayTienTransModel();
        traGoc.setVayTienID(vayTienID);
        traGoc.setTen("Trả tiền gốc  " + vayTienModel.getTen());
        traGoc.setSotien(vayTienModel.getTiengoc());
        traGoc.setBank(vayTienModel.getBank());
        LocalDateTime newDate = localDateTime.plusMonths(vayTienModel.getKyhan());

        System.out.println("tháng" + newDate.toString());
        Timestamp timeStamp = Timestamp.valueOf(newDate);
        traGoc.setTime(timeStamp);
        vayTienDAO.addTrans(traGoc, user);

    }

    public boolean check() {
        if (true) {

        }
        return true;
    }
}
