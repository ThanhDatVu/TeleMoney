/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.GuiTienDAO;
import DAO.StockDAO;
import Model.GuiTienModel;
import Model.GuiTienTransModel;
import Model.UserModel;
import View.GuiTienView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.swing.JOptionPane;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class AddGuiTienController {

    GuiTienView guiTienView;
    UserModel acc;
    GuiTienDAO guiTienDAO = null;
    GuiTienModel guiTienModel = new GuiTienModel();
    StockDAO stockDAO;
    double soDu;

    public AddGuiTienController(GuiTienView guiTienView, UserModel acc) {
        guiTienDAO = new GuiTienDAO();
        stockDAO = new StockDAO();
        this.guiTienView = guiTienView;
        this.acc = acc;
        guiTienView.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        soDu = stockDAO.getSoDu(acc);
        setEventGuiTien();
        guiTienView.setVisible(true);
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
    public void setEventGuiTien() {
        System.out.println("Tao event");

        guiTienView.btnThemGuiTien.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                double x = Double.parseDouble(guiTienView.txtTien.getText());
                if (x > soDu) {
                    JOptionPane.showMessageDialog(null, "Vượt quá số dư khả dụng");
                } else if (x <= 0) {
                    JOptionPane.showMessageDialog(null, "Nhập sai");
                } else {
                    int opt = JOptionPane.showConfirmDialog(guiTienView, "Xác nhận gửi " + guiTienView.cboBank.getSelectedItem().toString() + " "
                            + " số tiền " + guiTienView.txtTien.getText() + " VND ?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                    if (opt == 0) {
                        //String ten, String bank, double tiengoc, double laisuat, int kyhan, Timestamp ngaygui
                        guiTienModel.setTen(guiTienView.txtTen.getText());
                        guiTienModel.setBank(guiTienView.cboBank.getSelectedItem().toString());
                        guiTienModel.setTiengoc(Double.parseDouble(guiTienView.txtTien.getText()));
                        guiTienModel.setLaisuat(Double.parseDouble(guiTienView.txtLaisuat.getText()));
                        guiTienModel.setKyhan(Integer.parseInt(guiTienView.cboKyHan.getSelectedItem().toString()));
                        guiTienModel.setNgaythulai(Integer.parseInt(guiTienView.txtNgayNhanLai.getText().toString()));
                        Timestamp time = new Timestamp(System.currentTimeMillis());
                        guiTienModel.setNgaygui(time);
                        guiTienDAO.add(guiTienModel, acc);
                        int id = guiTienDAO.getIDByName(guiTienModel, acc);;
                        themGiaoDich(guiTienModel, acc, id);
                        guiTienView.master.soDuKhaDung = guiTienView.master.soDuKhaDung - Double.parseDouble(guiTienView.txtTien.getText());
                        guiTienView.master.refreshTabVayNo();
                        guiTienView.dispose();
                    }
                }
            }
        }
        );

        guiTienView.cboKyHan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tinhLaiHangThang();
            }
        });
        guiTienView.txtTien.getDocument().addDocumentListener(new DocumentListener() {
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
        guiTienView.txtLaisuat.getDocument().addDocumentListener(new DocumentListener() {
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

            soTien = Double.parseDouble(guiTienView.txtTien.getText());
            laiXuat = Double.parseDouble(guiTienView.txtLaisuat.getText());
            kyHan = Double.parseDouble(guiTienView.cboKyHan.getSelectedItem().toString());

            if (soTien > -1 && laiXuat > -1) {
                guiTienView.txtLai.setEditable(true);
                double laihangthang;
                laihangthang = (soTien * (laiXuat / 12)) / 100;

                guiTienView.txtLai.setText(String.valueOf(Math.round(laihangthang)));

                guiTienView.txtLai.setEditable(false);

            }

        }

    }

    public void themGiaoDich(GuiTienModel guiTienModel, UserModel user, int guiTienID) {
        guiTienModel.getNgaygui().setDate(guiTienModel.getNgaythulai());

        LocalDateTime localDateTime = guiTienModel.getNgaygui().toLocalDateTime();
        for (int i = 1; i <= guiTienModel.getKyhan(); i++) {
            GuiTienTransModel guiTienTransModel = new GuiTienTransModel();
            guiTienTransModel.setGuiTienID(guiTienID);
            guiTienTransModel.setTen("Nhận lãi lần " + i + " - " + guiTienModel.getTen());
            guiTienTransModel.setSotien(Float.parseFloat(guiTienView.txtLai.getText()));
            guiTienTransModel.setBank(guiTienModel.getBank());

            LocalDateTime newDate = localDateTime.plusMonths(i - 1);

            System.out.println("tháng" + newDate.toString());
            Timestamp timeStamp = Timestamp.valueOf(newDate);
            guiTienTransModel.setTime(timeStamp);
            guiTienDAO.addTrans(guiTienTransModel, user);
        }
        GuiTienTransModel traGoc = new GuiTienTransModel();
        traGoc.setGuiTienID(guiTienID);
        traGoc.setTen("Nhận tiền gốc  " + guiTienModel.getTen());
        traGoc.setSotien(guiTienModel.getTiengoc());
        traGoc.setBank(guiTienModel.getBank());
        LocalDateTime newDate = localDateTime.plusMonths(guiTienModel.getKyhan());

        System.out.println("tháng" + newDate.toString());
        Timestamp timeStamp = Timestamp.valueOf(newDate);
        traGoc.setTime(timeStamp);
        guiTienDAO.addTrans(traGoc, user);

    }
}
