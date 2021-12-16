/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.NhanvienDAO;
import Model.NhanvienModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import View.NhanvienView;
import View.ViewThem;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import lib.ButtonColumn;

public class NhanvienController {

    private NhanvienView nhanvienView;
    private NhanvienModel acc;
    private NhanvienDAO nhanvienDAO = null;

    public NhanvienController() {

        nhanvienView = new NhanvienView();
        setEventNhanvien();
        setTableButton();
        nhanvienView.setVisible(true);
        nhanvienDAO = new NhanvienDAO();

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
                    ThemNhanvienController add = new ThemNhanvienController(nhanvienView);

                } catch (Exception ex) {
                }
            }
        });
        nhanvienView.addRefreshListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // TODO add your handling code here:

                    nhanvienDAO.refresh(nhanvienView.nvmodel);
                    nhanvienView.invalidate();
                    nhanvienView.validate();
                    nhanvienView.repaint();
                    // NhanvienView clone = new NhanvienView();
                    //clone.setVisible(true);
                    System.out.println("refresh");

                } catch (Exception ex) {
                }
            }
        });
    }

    public void setTableButton() {
        //Action delete 1 hang
        NhanvienView thisview = nhanvienView;
        Action delete = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                int opt = JOptionPane.showConfirmDialog(nhanvienView, "Bạn có muốn xoá nhân viên này không", "Delete", JOptionPane.YES_NO_CANCEL_OPTION);
                if (opt == 0) {
                    JTable table = (JTable) e.getSource();
                    int modelRow = Integer.valueOf(e.getActionCommand());

                    NhanvienModel nv = new NhanvienModel();
                    nv.setMaNV((String) table.getValueAt(modelRow, 0));
                    nv.setHoTen((String) table.getValueAt(modelRow, 1));
                    nv.setLuong((String) table.getValueAt(modelRow, 2));
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
                NhanvienModel nv = new NhanvienModel();
                nv.setMaNV((String) table.getValueAt(modelRow, 0));
                nv.setHoTen((String) table.getValueAt(modelRow, 1));
                nv.setLuong((String) table.getValueAt(modelRow, 2));

                SuaNhanvienController suaController = new SuaNhanvienController(thisview, nv);
            }
        };

        ButtonColumn buttonXoa = new ButtonColumn(thisview.tableNhanvien, delete, 3);
        buttonXoa.setMnemonic(KeyEvent.VK_D);
        buttonXoa.setToolTipText("Xoá 1 hàng");
        ButtonColumn buttonSua = new ButtonColumn(thisview.tableNhanvien, sua, 4);
        buttonSua.setMnemonic(KeyEvent.VK_D);
    }
}
