/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ThuDAO;
import DAO.StockDAO;
import Model.ThuModel;
import Model.UserModel;
import View.ThemThuView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.Time;
import javax.swing.JOptionPane;
import java.sql.Timestamp;

public class ThemThuController {

    ThemThuView themThuView;
    UserModel acc;
    ThuDAO thuDAO = null;
    ThuModel thuModel = new ThuModel();
    StockDAO stockDAO;
    double soDu;

    public ThemThuController(ThemThuView themThuView, UserModel acc) {
        thuDAO = new ThuDAO();
        stockDAO = new StockDAO();
        this.themThuView = themThuView;
        this.acc = acc;
        themThuView.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        soDu = stockDAO.getSoDu(acc);
        setEventThemThu();
        themThuView.setVisible(true);
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
    public void setEventThemThu() {
        System.out.println("Tao event");
        themThuView.btnDongY.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                double x = Double.parseDouble(themThuView.soTien.getText());
                if (x <= 0) {
                    JOptionPane.showMessageDialog(null, "Nhập sai");
                } else {
                    int opt = JOptionPane.showConfirmDialog(themThuView, "Xác nhận thêm", "Xác nhận", JOptionPane.YES_NO_OPTION);
                    if (opt == 0) {
                        //String ten, String bank, double tiengoc, double laisuat, int kyhan, Timestamp ngaygui
                        thuModel.setNameThu(themThuView.tenThu.getText());
                        thuModel.setMucThu(themThuView.tenDanhMuc.getSelectedItem().toString());
                        thuModel.setAmountThu(Double.parseDouble(themThuView.soTien.getText()));
                        Timestamp time = new Timestamp(System.currentTimeMillis());
                        thuModel.setTimestampThu(time);
                        System.out.println(thuModel.toString());
                        thuDAO.add(thuModel, acc);
                        themThuView.master.soDuKhaDung = themThuView.master.soDuKhaDung + Double.parseDouble(themThuView.soTien.getText());
                        System.out.println("so du kha dung sau khi them khoan thu la: " + themThuView.master.soDuKhaDung);
                        themThuView.master.refreshTabThuChi();
                        themThuView.dispose();
                    }
                }
            }
        }
        );

    }
}
