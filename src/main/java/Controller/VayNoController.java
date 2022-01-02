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
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import lib.ButtonColumn;
import yahoofinance.YahooFinance;

public class VayNoController {
    DecimalFormat df = new DecimalFormat("0");
    private GuiTienDAO guiTienDAO = null;
    private VayTienDAO vayTienDAO = null;
    private TraGopDAO traGopDAO = null;
    private MasterTeleMoneyView master;
    private UserModel acc;
    GuiTienTableModel guiTienTableModel = new GuiTienTableModel();
    VayTienTableModel vayTienTableModel = new VayTienTableModel();
    TraGopTableModel traGopTableModel = new TraGopTableModel();
    Vector guiTienTableData, vayTienTableData, traGopTableData;

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
                guiTienModels.get(i).getId(),
                guiTienModels.get(i).getTen(),
                guiTienModels.get(i).getBank(),
                df.format(guiTienModels.get(i).getTiengoc()),
                guiTienModels.get(i).getLaisuat(),
                guiTienModels.get(i).getKyhan(),
                guiTienModels.get(i).getNgaygui()
            });
        }
        guiTienTableData = (Vector) ((DefaultTableModel) master.tableGuiTien.getModel()).getDataVector().clone();
        VayTienTableModel tableModel1 = (VayTienTableModel) master.tableVayTien.getModel();
        ArrayList<VayTienModel> vayTienModels = new ArrayList<>();
        vayTienModels = vayTienDAO.getAll(acc);
        tableModel1.setRowCount(0);
        for (int i = 0; i < vayTienModels.size(); i++) {
            tableModel1.addRow(new Object[]{
                vayTienModels.get(i).getId(),
                vayTienModels.get(i).getTen(),
                vayTienModels.get(i).getBank(),
                df.format(vayTienModels.get(i).getTiengoc()),
                vayTienModels.get(i).getLaisuat(),
                vayTienModels.get(i).getKyhan(),
                vayTienModels.get(i).getNgayvay()
            });
        }
        vayTienTableData = (Vector) ((DefaultTableModel) master.tableVayTien.getModel()).getDataVector().clone();

        TraGopTableModel tableModel2 = (TraGopTableModel) master.tableTraGop.getModel();
        ArrayList<TraGopModel> traGopModels = new ArrayList<>();
        traGopModels = traGopDAO.getAll(acc);
        tableModel2.setRowCount(0);

        for (int i = 0; i < traGopModels.size(); i++) {
            tableModel2.addRow(new Object[]{
                traGopModels.get(i).getId(),
                traGopModels.get(i).getTen(),
                traGopModels.get(i).getBank(),
                traGopModels.get(i).getTratruoc(),
                df.format(traGopModels.get(i).getTongtien()),
                traGopModels.get(i).getSothang(),
                df.format(traGopModels.get(i).getTienhangthang()),
                traGopModels.get(i).getTime()
            });
            //"Tên", "Công ty", "Trả trước", "Tổng tiền (VNĐ)","Số tháng", "Tiền hàng tháng", "Ngày"
        }
        traGopTableData = (Vector) ((DefaultTableModel) master.tableTraGop.getModel()).getDataVector().clone();
    }
//    public void setButton(){
//   

    public void setEventGuiTien() {
        System.out.println("Tao event tab vayno");
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
        System.out.println("tao xong event vayno");
        master.txtLocVay.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent documentEvent) {
                search();
            }

            public void insertUpdate(DocumentEvent documentEvent) {
                search();
            }

            public void removeUpdate(DocumentEvent documentEvent) {
                search();
            }

            private void search() {
                searchTableContents(master.txtLocVay.getText(), master.tableVayTien ,vayTienTableData );
            }
        });
        master.txtLocTK.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent documentEvent) {
                search();
            }

            public void insertUpdate(DocumentEvent documentEvent) {
                search();
            }

            public void removeUpdate(DocumentEvent documentEvent) {
                search();
            }

            private void search() {
                searchTableContents(master.txtLocTK.getText(), master.tableGuiTien ,guiTienTableData );
            }
        });
        master.txtLocTG.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent documentEvent) {
                search();
            }

            public void insertUpdate(DocumentEvent documentEvent) {
                search();
            }

            public void removeUpdate(DocumentEvent documentEvent) {
                search();
            }

            private void search() {
                searchTableContents(master.txtLocTG.getText(), master.tableTraGop ,traGopTableData );
            }
        });
    }

    public void searchTableContents(String searchString, JTable table, Vector OGVector) {
        DefaultTableModel currtableModel = (DefaultTableModel) table.getModel();
        //To empty the table before search
        currtableModel.setRowCount(0);
        //To search for contents from original table content
        for (Object rows : OGVector) {
            Vector rowVector = (Vector) rows;
            for (Object column : rowVector) {
                if (column.toString().contains(searchString)) {
                    //content found so adding to table
                    currtableModel.addRow(rowVector);
                    break;
                }
            }

        }
    }
}
