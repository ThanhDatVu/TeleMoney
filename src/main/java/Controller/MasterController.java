/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.StockDAO;
import Model.MyStockBuyModel;
import Model.MyStockBuyTableModel;
import Model.UserModel;
import View.BanStockView;
import View.LoginView;
import View.MasterTeleMoneyView;
import View.MuaStockView;
import View.MyTransView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import lib.ButtonColumn;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public class MasterController {

    DecimalFormat df = new DecimalFormat("0.00");
    private MasterTeleMoneyView master;
    private UserModel acc;
    private StockDAO stockDAO = null;
    Stock stock;
    BigDecimal usd;
    MyStockBuyTableModel stockModel = new MyStockBuyTableModel();
    Vector stockTableData;

    public MasterController(MasterTeleMoneyView master, UserModel acc) {
        this.master = master;
        this.acc = acc;
        setEventStock();
        master.setVisible(true);
        stockDAO = new StockDAO();

        //setTableButton();
    }

// 
    public void setEventStock() {
        System.out.println("Tao event tab menu");

        master.labelMenuThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                try {
                    master.cardLayout.show(master.pnlCards, "cardThongKe");
                    master.thongKeController = new ThongKeController(master, acc);
                } catch (IOException ex) {
                    Logger.getLogger(MasterController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        master.labelMenuChiTieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                try {
                    master.cardLayout.show(master.pnlCards, "cardChiTieu");
                    master.thuChiController1 = new ThuChiController1(master, acc);
                    master.thuChiController2 = new ThuChiController2(master, acc);
                } catch (IOException ex) {
                    Logger.getLogger(MasterController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        master.labelMenuDauTu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                master.cardLayout.show(master.pnlCards, "cardDauTu");
                master.stockController = new StockController(master, acc);
            }
        });
        master.labelMenuVayNo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                try {
                    master.cardLayout.show(master.pnlCards, "cardVayNo");
                    master.vayNoController = new VayNoController(master, acc);
                } catch (IOException ex) {
                    Logger.getLogger(MasterController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        master.labelMenuTaiKhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                master.cardLayout.show(master.pnlCards, "cardTaiKhoan");

            }
        });
        master.btnDangXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                master.dispose();
                LoginView login = new LoginView();
            }
        });
    }

}
