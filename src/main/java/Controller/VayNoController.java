/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.GuiTienDAO;
import DAO.StockDAO;
import DAO.TraGopDAO;
import DAO.VayTienDAO;
import Model.GuiTienModel;
import Model.GuiTienTableModel;
import Model.MyStockBuyModel;
import Model.MyStockBuyTableModel;
import Model.TraGopModel;
import Model.TraGopTableModel;
import Model.UserModel;
import Model.VayTienModel;
import Model.VayTienTableModel;
import View.GuiTienView;
import View.MasterTeleMoneyView;
import View.MuaStockView;
import View.TraGopView;
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
    private VayTienDAO vayTienDAO = null;
    private TraGopDAO traGopDAO = null;
    private MasterTeleMoneyView master;
    private UserModel acc;
    GuiTienTableModel guiTienTableModel = new GuiTienTableModel();
    VayTienTableModel vayTienTableModel = new VayTienTableModel();
    TraGopTableModel traGopTableModel = new TraGopTableModel();

    public VayNoController(MasterTeleMoneyView master, UserModel acc) throws IOException {
        this.master = master;
        this.acc = acc;
        master.setVisible(true);
        guiTienDAO = new GuiTienDAO();
        vayTienDAO = new VayTienDAO();
        traGopDAO = new TraGopDAO();
        this.master.tableGuiTien.setModel(guiTienTableModel);
        this.master.tableVayTien.setModel(vayTienTableModel);
        this.master.tableTraGop.setModel(traGopTableModel);
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
        for (int i = 0; i < guiTienModels.size(); i++) {
            tableModel.addRow(new Object[]{
                guiTienModels.get(i).getTen(),
                guiTienModels.get(i).getBank(),
                guiTienModels.get(i).getTiengoc(),
                guiTienModels.get(i).getLaisuat(),
                guiTienModels.get(i).getKyhan(),
                guiTienModels.get(i).getNgaygui()
            });
        }
        VayTienTableModel tableModel1 = (VayTienTableModel) master.tableVayTien.getModel();
        ArrayList<VayTienModel> vayTienModels = new ArrayList<>();
        vayTienModels = vayTienDAO.getAll(acc);
        tableModel1.setRowCount(0);
        for (int i = 0; i < vayTienModels.size(); i++) {
            tableModel1.addRow(new Object[]{
                vayTienModels.get(i).getTen(),
                vayTienModels.get(i).getBank(),
                vayTienModels.get(i).getTiengoc(),
                vayTienModels.get(i).getLaisuat(),
                vayTienModels.get(i).getKyhan(),
                vayTienModels.get(i).getNgayvay()
            });
        }
        
        
        TraGopTableModel tableModel2 = (TraGopTableModel) master.tableTraGop.getModel();
        ArrayList<TraGopModel> traGopModels = new ArrayList<>();
        traGopModels = traGopDAO.getAll(acc);
        tableModel2.setRowCount(0);
        Object[] TABLE_HEADER = {"Tên", "Công ty", "Trả trước", "Tổng tiền (VNĐ)","Số tháng", "Tiền hàng tháng", "Ngày"};
        
        for (int i = 0; i < traGopModels.size(); i++) {
            tableModel2.addRow(new Object[]{
                traGopModels.get(i).getTen(),
                traGopModels.get(i).getBank(),
                traGopModels.get(i).getTratruoc(),
                traGopModels.get(i).getTongtien(),
                traGopModels.get(i).getSothang(),
                traGopModels.get(i).getTienhangthang(),
                traGopModels.get(i).getTime()
            });
            //"Tên", "Công ty", "Trả trước", "Tổng tiền (VNĐ)","Số tháng", "Tiền hàng tháng", "Ngày"
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
        master.btnThemTG.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TraGopView traGopView = new TraGopView(master, acc);
                traGopView.setVisible(true);
            }
        }
        );
    }
}
