/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.GuiTienDAO;
import DAO.StockDAO;
import Model.GuiTienModel;
import Model.UserModel;
import View.GuiTienView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.sql.Timestamp;

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
                    int opt = JOptionPane.showConfirmDialog(guiTienView, "Xác nhận gửi " + guiTienView.cboBank.getSelectedItem().toString()+ " "
                            + " số tiền " + guiTienView.txtTien.getText() + " VND ?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                    if (opt == 0) {
                        //String ten, String bank, double tiengoc, double laisuat, int kyhan, Timestamp ngaygui
                        guiTienModel.setTen(guiTienView.txtTen.getText());
                        guiTienModel.setBank(guiTienView.cboBank.getSelectedItem().toString());
                        guiTienModel.setTiengoc(Double.parseDouble(guiTienView.txtTien.getText()));
                        guiTienModel.setLaisuat(Double.parseDouble(guiTienView.txtLaisuat.getText()));
                        guiTienModel.setKyhan(Integer.parseInt(guiTienView.cboKyHan.getSelectedItem().toString()));
                        Timestamp time = new Timestamp(System.currentTimeMillis());
                        guiTienModel.setNgaygui(time);
                        guiTienDAO.add(guiTienModel, acc);
                        guiTienView.master.soDuKhaDung = guiTienView.master.soDuKhaDung - Double.parseDouble(guiTienView.txtTien.getText());
                        guiTienView.master.refreshTabVayNo();
                        guiTienView.dispose();
                    }
                }
            }
        }
        );

    }
}