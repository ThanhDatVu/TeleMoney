/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ThuDAO;
import Model.ThuModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import View.ThuView;
import View.ViewThem;
import java.awt.event.KeyEvent;
import java.sql.Date;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import lib.ButtonColumn;

public class ThuController {

    private ThuView nhanvienView;
    private ThuModel acc;
    private ThuDAO nhanvienDAO = null;

    public ThuController() {

        nhanvienView = new ThuView();
        setEventNhanvien();
        setTableButton();
        nhanvienView.setVisible(true);
        nhanvienDAO = new ThuDAO();

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

    public void setEventNhanvien() {

        nhanvienView.addThemListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ThemThuController add = new ThemThuController(nhanvienView);

                } catch (Exception ex) {
                }
            }
        });
        
    }

    public void setTableButton() {
        //Action delete 1 hang
        ThuView thisview = nhanvienView;
        Action delete = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                int opt = JOptionPane.showConfirmDialog(nhanvienView, "Bạn có muốn xoá nhân viên này không", "Delete", JOptionPane.YES_NO_CANCEL_OPTION);
                if (opt == 0) {
                    JTable table = (JTable) e.getSource();
                    int modelRow = Integer.valueOf(e.getActionCommand());

                    ThuModel nv = new ThuModel();
                    nv.setNameThu((String) table.getValueAt(modelRow, 0));
                    nv.setAmountThu((Double) table.getValueAt(modelRow, 1));
                    nv.setDescriptionThu((String) table.getValueAt(modelRow, 2));
                    nv.setDateThu((Date) table.getValueAt(modelRow, 3));
                    nhanvienDAO.delete(nv);
                    ((DefaultTableModel) table.getModel()).removeRow(modelRow);
                }
            }
        };
        //Action sua 1 hang
        Action sua;
        sua = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTable table = (JTable) e.getSource();
                int modelRow = Integer.valueOf(e.getActionCommand());
                //((DefaultTableModel) table.getModel()).removeRow(modelRow);
                ThuModel nv = new ThuModel();
                    nv.setNameThu((String) table.getValueAt(modelRow, 0));
                    nv.setAmountThu((Double) table.getValueAt(modelRow, 1));
                    nv.setDescriptionThu((String) table.getValueAt(modelRow, 2));
                    nv.setDateThu((Date) table.getValueAt(modelRow, 3));

                SuaThuController suaController = new SuaThuController(thisview, nv);
            }
        };

        ButtonColumn buttonXoa = new ButtonColumn(thisview.tableNhanvien, delete, 3);
        buttonXoa.setMnemonic(KeyEvent.VK_D);
        buttonXoa.setToolTipText("Xoá 1 hàng");
        ButtonColumn buttonSua = new ButtonColumn(thisview.tableNhanvien, sua, 4);
        buttonSua.setMnemonic(KeyEvent.VK_D);
    }
}
