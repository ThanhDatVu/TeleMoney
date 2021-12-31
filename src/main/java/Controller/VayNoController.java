/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.GuiTienDAO;
import DAO.StockDAO;
import Model.GuiTienModel;
import Model.GuiTienTableModel;
import Model.MyStockBuyModel;
import Model.MyStockBuyTableModel;
import Model.UserModel;
import View.GuiTienView;
import View.MasterTeleMoneyView;
import View.MuaStockView;
import View.VayTienView;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import lib.ButtonColumn;
import yahoofinance.YahooFinance;


public class VayNoController {
    private GuiTienDAO guiTienDAO = null;
    private MasterTeleMoneyView master;
    private UserModel acc;
    GuiTienTableModel tableGuiTien = new GuiTienTableModel();
    
    public VayNoController(MasterTeleMoneyView master, UserModel acc) throws IOException {
        this.master = master;
        this.acc = acc;
        master.setVisible(true);
        guiTienDAO = new GuiTienDAO();
        this.master.tableGuiTien.setModel(tableGuiTien);
        setDataTable();
        setEventGuiTien();
        //setTableButton();
    }
    public void enable() {
        setEventGuiTien();
        //setTableButton();
        //setTableButton();

    }

    public void setDataTable() throws IOException {
        GuiTienTableModel tableModel = (GuiTienTableModel) master.tableGuiTien.getModel();
        ArrayList<GuiTienModel> guiTienModels = new ArrayList<>();
        guiTienModels = guiTienDAO.getAll(acc);
        tableModel.setRowCount(0);
        for (int i = 0; i < guiTienModels.size(); i++){
            tableModel.addRow(new Object[]{
                guiTienModels.get(i).getTen(),
                guiTienModels.get(i).getBank(),
                guiTienModels.get(i).getTiengoc(),
                guiTienModels.get(i).getLaisuat(),
                guiTienModels.get(i).getKyhan(),
                guiTienModels.get(i).getNgaygui()
        });
    }
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
            master.btnThemTK.addActionListener(
            new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiTienView guiTienView = new GuiTienView(master, acc);
                guiTienView.setVisible(true);
            }
        }
        );
            master.btnThemVay.addActionListener(
            new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VayTienView vayTienView = new VayTienView(master, acc);
                vayTienView.setVisible(true);
            }
        }
        );
    }            
}
