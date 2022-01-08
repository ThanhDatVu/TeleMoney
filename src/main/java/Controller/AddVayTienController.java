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
import View.VayTienView;
import View.VayTienView;
import View.VayTienView;
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
                        Timestamp time = new Timestamp(System.currentTimeMillis());
                        vayTienModel.setNgayvay(time);
                        vayTienDAO.add(vayTienModel, acc);
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
}
