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
import View.AddStockView;
import View.BanStockView;
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

public class StockController {

    DecimalFormat df = new DecimalFormat("0.00");
    private MasterTeleMoneyView master;
    private UserModel acc;
    private StockDAO stockDAO = null;
    Stock stock;
    BigDecimal usd;
    MyStockBuyTableModel stockModel = new MyStockBuyTableModel();
    Vector stockTableData;

    public StockController(MasterTeleMoneyView master, UserModel acc) {
        try {
            System.out.println("Tao controller stock");
            this.master = master;
            this.acc = acc;
            this.master.tableDanhMuc.setModel(stockModel);
            usd = YahooFinance.get("USDVND=X").getQuote().getPrice();
            setEventStock();
            setTableButton();
            master.setVisible(true);
            stockDAO = new StockDAO();

            MyStockBuyTableModel tableModel = (MyStockBuyTableModel) master.tableDanhMuc.getModel();
            setDataTable();

            //setTableButton();
        } catch (IOException ex) {
            Logger.getLogger(StockController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void enable() {
        setEventStock();
        setTableButton();
        //setTableButton();

    }

    public void setDataTable() throws IOException {
        DefaultPieDataset dataSet = new DefaultPieDataset();
        dataSet.setValue("BITCOIN 29%", 29);
        dataSet.setValue("APPLE 36%", 36);
        dataSet.setValue("Tesla 25%", 25);
        dataSet.setValue("DOGECOIN 15%", 15);

        // based on the dataset we create the chart
        JFreeChart pieChart = ChartFactory.createPieChart3D("chart", dataSet, true, true, false);
        PiePlot plot = (PiePlot) pieChart.getPlot();
        plot.setStartAngle(290);
        plot.setForegroundAlpha(0.5f);

        // Adding chart into a chart panel
        ChartPanel chartPanel = new ChartPanel(pieChart);
        chartPanel.setVisible(true);

        TableColumn col = master.tableDanhMuc.getColumnModel().getColumn(4);
        col.setCellRenderer(new MyRenderer(Color.red, Color.green));
        MyStockBuyTableModel tableModel = (MyStockBuyTableModel) master.tableDanhMuc.getModel();
        ArrayList<MyStockBuyModel> myStockList = new ArrayList<>();
        myStockList = stockDAO.getAll();
        tableModel.setRowCount(0);
        for (int i = 0; i < myStockList.size(); i++) {
            if (myStockList.get(i).getSoLuong() > 0) {
                stock = YahooFinance.get(myStockList.get(i).getSymbol());
                long giaTriHienTai = (long) ((Math.round(stock.getQuote().getPrice().floatValue() * myStockList.get(i).getSoLuong() * 100.0)) / 100.0);
                tableModel.addRow(new Object[]{
                    myStockList.get(i).getSymbol(),
                    myStockList.get(i).getSoLuong(),
                    myStockList.get(i).getGiaBanDau(),
                    (Math.round(stock.getQuote().getPrice().floatValue() * 100.0)) / 100.0,
                    stock.getQuote().getChangeInPercent(),
                    (Math.round(stock.getQuote().getPrice().floatValue() * myStockList.get(i).getSoLuong() * 100.0)) / 100.0,
                    df.format(((giaTriHienTai - (myStockList.get(i).getSoLuong() * myStockList.get(i).getGiaBanDau())) > -1)
                    && ((giaTriHienTai - (myStockList.get(i).getSoLuong() * myStockList.get(i).getGiaBanDau())) < 1)
                    ? 0 : ((giaTriHienTai - (myStockList.get(i).getSoLuong() * myStockList.get(i).getGiaBanDau())))),
                    "Mua thêm",
                    "Bán"

                });
                stockTableData = (Vector) ((DefaultTableModel) master.tableDanhMuc.getModel()).getDataVector().clone();

            } else {
                //TO DO xoas
                stockDAO.delete(myStockList.get(i));
            }
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

    public void setEventStock() {
        System.out.println("Tao event tab dautu");

        master.tableDanhMuc.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent e) {
                if (e.getClickCount() == 1) {
                    final JTable target = (JTable) e.getSource();
                    final int row = target.getSelectedRow();
                    final int column = target.getSelectedColumn();
                    // Cast to ur Object type
                    // final UrObjctInCell urObjctInCell = (UrObjctInCell) target.getValueAt(row, column);
                    // TODO WHAT U WANT!
                    if (column < 7 && column > 0) {
                        Float SoUSD = Float.valueOf(String.valueOf(target.getValueAt(row, column)));
                        master.labelUSD.setText(SoUSD.toString());
                        master.labelVND.setText(String.valueOf((usd.multiply(BigDecimal.valueOf(SoUSD)).setScale(0, RoundingMode.HALF_UP))));
                    }
                }
            }
        });

        System.out.println("Tao xong event tab dautu");
        master.txtLocDauTu.getDocument().addDocumentListener(new DocumentListener() {
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
                searchTableContents(master.txtLocDauTu.getText(), master.tableDanhMuc, stockTableData);
            }
        });

        master.btnShowTrans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MyTransView myTransView = new MyTransView(master, acc);
                myTransView.setVisible(true);
            }
        });
        master.btnThemStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    AddStockView addStock = new AddStockView(master, acc);
                    addStock.setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(StockController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public void setTableButton() {
        System.out.println("Tao nut jtable");
        //Action muaStock
        MasterTeleMoneyView thisview = master;
        System.out.println(thisview.getTitle());
        Action muaThem = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTable table = (JTable) e.getSource();
                int modelRow = Integer.valueOf(e.getActionCommand());
                MyStockBuyModel stockBuy = new MyStockBuyModel();
                stockBuy.setSymbol((String) table.getValueAt(modelRow, 0));
                stockBuy.setSoLuong((int) table.getValueAt(modelRow, 1));
                stockBuy.setGiaBanDau((float) table.getValueAt(modelRow, 2));
                //System.out.println("alo" + table.getValueAt(modelRow, 3));
                MuaStockView muaStockView = new MuaStockView(master, stockBuy, acc);
                muaStockView.setVisible(true);
                //stockDAO.delete(stockBuy);
                //((DefaultTableModel) table.getModel()).removeRow(modelRow);

            }
        };
        //Action banStock
        Action banStock;
        banStock = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTable table = (JTable) e.getSource();
                int modelRow = Integer.valueOf(e.getActionCommand());
                MyStockBuyModel stockBuy = new MyStockBuyModel();
                stockBuy.setSymbol((String) table.getValueAt(modelRow, 0));
                stockBuy.setSoLuong((int) table.getValueAt(modelRow, 1));
                stockBuy.setGiaBanDau((float) (table.getValueAt(modelRow, 2)));
                BanStockView banStockView = new BanStockView(master, stockBuy, acc);
            }
        };

        ButtonColumn btnMua = new ButtonColumn(master.tableDanhMuc, muaThem, 7);

        btnMua.setMnemonic(KeyEvent.VK_D);

        btnMua.setToolTipText(
                "Mua thêm cổ phiếu");
        ButtonColumn btnBan = new ButtonColumn(master.tableDanhMuc, banStock, 8, Color.BLUE);

        btnBan.setMnemonic(KeyEvent.VK_D);
        System.out.println("Tao xong nut jtable");
    }

    class MyRenderer extends DefaultTableCellRenderer {

        Color red, green;

        public MyRenderer(Color bg, Color fg) {
            super();
            this.red = bg;
            this.green = fg;
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value,
                    isSelected, hasFocus, row, column);
            //System.out.println(value);
            if (value == null) {
                return cell;
            }
            Float check = Float.parseFloat(value.toString());
            if (check >= 0) {

                cell.setForeground(green);
            } else {
                cell.setForeground(red);
            }

            return cell;
        }
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
