/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ChiDAO;
import DAO.StockDAO;
import DAO.ThuDAO;
import Model.ChiModel;
import Model.ChiTableModel;
import Model.GuiTienModel;
import Model.GuiTienTableModel;
import Model.MyStockBuyModel;
import Model.MyStockBuyTableModel;
import Model.ThuModel;
import Model.ThuTableModel;
import Model.UserModel;
import Model.VayTienTableModel;
import View.ThemChiView;
import View.MasterTeleMoneyView;
import View.MuaStockView;
import View.SuaChiView;
import View.SuaThuView;
import View.ThemThuView;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import lib.ButtonColumn;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public class ThuChiController2 {

    private MasterTeleMoneyView master;
    private UserModel acc;
    private StockDAO stockDAO;
    private ThuDAO thuDAO;
    private ChiDAO chiDAO;
    private Integer tableSelect;
    Stock stock;
    BigDecimal usd;

    Vector chiTableData, thuTableData;

    public ThuChiController2(MasterTeleMoneyView master, UserModel acc) throws IOException {
        this.master = master;
        this.acc = acc;
        master.setVisible(true);
        stockDAO = new StockDAO();
        thuDAO = new ThuDAO();
        chiDAO = new ChiDAO();

        System.out.println("chuan bị set table");
        setVector();
        setEventThuChi();

        System.out.println("set xong table");

    }

    public void enable() {
        //setEventThuChi();

        //setTableButton();
    }

    public void setVector() throws IOException {

        chiTableData = (Vector) ((DefaultTableModel) master.tbChi.getModel()).getDataVector().clone();
        thuTableData = (Vector) ((DefaultTableModel) master.tbThu.getModel()).getDataVector().clone();

        System.out.println("setVector xong");

        DefaultPieDataset dataSet = new DefaultPieDataset();
        dataSet.setValue("BITCOIN 27.2%", 27);
        dataSet.setValue("APPLE 19.3%", 19);
        dataSet.setValue("Coinbase 1.4%", 1);
        dataSet.setValue("Tesla 43.8%", 45);
        dataSet.setValue("GOOGL 8.1%", 8);
        dataSet.setValue("MDT 0.8%", 0.8);
        dataSet.setValue("SLB 0.4%", 0.4);

        // based on the dataset we create the chart
        JFreeChart pieChart = ChartFactory.createPieChart3D("Phân bố tài sản theo danh mục đầu tư", dataSet, true, true, false);
        ChartPanel chartPanel = new ChartPanel(pieChart);
        master.pnlThongKeDauTu.add(chartPanel, java.awt.BorderLayout.WEST);

        DefaultPieDataset dataSet1 = new DefaultPieDataset();
        dataSet1.setValue("Ăn uống 34%", 34);
        dataSet1.setValue("Di chuyển 21%", 21);
        dataSet1.setValue("Tiền nhà 35%", 35);
        dataSet1.setValue("Quà cáp 10%", 10);

        // based on the dataset we create the chart
        JFreeChart pieChart1 = ChartFactory.createPieChart3D("Phân bố chi tiêu", dataSet1, true, true, false);
        ChartPanel chartPanel1 = new ChartPanel(pieChart1);
        master.pnlThongKeChiTieu.add(chartPanel1, java.awt.BorderLayout.WEST);

        DefaultPieDataset dataSet2 = new DefaultPieDataset();
        dataSet2.setValue("Vay 27%", 29);
        dataSet2.setValue("Nợ 73%", 73);
//        dataSet.setValue("Tesla 25%", 25);
//        dataSet.setValue("DOGECOIN 15%",15 );

        // based on the dataset we create the chart
        JFreeChart pieChart2 = ChartFactory.createPieChart3D("Phân bố tài sản vay, nợ", dataSet2, true, true, false);
        ChartPanel chartPanel2 = new ChartPanel(pieChart2);
        master.pnlThongKeVayNo.add(chartPanel2, java.awt.BorderLayout.WEST);
        master.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        master.pack();
    }
//    
//    
//    
//    

    public void setEventThuChi() {
        master.textChi.getDocument().addDocumentListener(new DocumentListener() {
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
                searchTableContents(master.textChi.getText(), master.tbChi, chiTableData);
            }
        });
        master.textThu.getDocument().addDocumentListener(new DocumentListener() {
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
                searchTableContents(master.textThu.getText(), master.tbThu, thuTableData);
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
