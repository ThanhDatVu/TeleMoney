/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.NhanvienDAO;
import Model.NhanvienModel;
import View.NhanvienView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import View.ViewThem;
import View.ViewThem;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import lib.ButtonColumn;

public class ThemNhanvienController {

    private ViewThem viewThem;
    private NhanvienModel nv;
    private NhanvienDAO nhanvienDAO = null;
    NhanvienView owner;
    public ThemNhanvienController() {
    
    }
//    

    public ThemNhanvienController(NhanvienView nhanvienView) {
        
         //To change body of generated methods, choose Tools | Templates.
        owner = nhanvienView;
         viewThem = new ViewThem(owner);
        setEventThem();
        viewThem.setVisible(true);
        
        nhanvienDAO = new NhanvienDAO();
         
    }

    public void setEventThem() {

        viewThem.addThemListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    nv = viewThem.getNV();
                    nhanvienDAO.add(nv);
                    JOptionPane.showMessageDialog(viewThem, "Thêm thành công");
                    owner.refresh();

                } catch (HeadlessException ex) {
                    JOptionPane.showMessageDialog(viewThem, "Thêm thất bại");
                    ex.printStackTrace();
                }
            }
        });
        
    }

}
