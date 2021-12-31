/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ThuDAO;
import Model.ThuModel;
import View.MasterTeleMoneyView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import View.ThemThuView;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import lib.ButtonColumn;

public class ThemChiController {

    private ThemThuView viewThem;
    private ThuModel nv;
    private ThuDAO thuDAO = null;
    MasterTeleMoneyView owner;
    public ThemChiController() {
    
    }
//    

    public ThemChiController(ThemThuView ThemThuView) {
        
         //To change body of generated methods, choose Tools | Templates.
        viewThem = ThemThuView;
        setEventThem();
        viewThem.setVisible(true);
        thuDAO = new ThuDAO();
         
    }

    public void setEventThem() {
        
    
}
}
