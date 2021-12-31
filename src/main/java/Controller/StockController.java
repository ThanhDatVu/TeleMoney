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
import View.MasterTeleMoneyView;
import View.MuaStockView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import lib.ButtonColumn;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public class StockController {
    DecimalFormat df = new DecimalFormat("0.00");
    private MasterTeleMoneyView master;
    private UserModel acc;
    private StockDAO stockDAO = null;
    Stock stock;
    BigDecimal usd;

    public StockController(MasterTeleMoneyView master, UserModel acc) {
        try {
            System.out.println("Tao controller stock");
            this.master = master;
            this.acc = acc;
            usd = YahooFinance.get("USDVND=X").getQuote().getPrice();
            setEventStock();
            setTableButton();
            master.setVisible(true);
            stockDAO = new StockDAO();
            MyStockBuyTableModel tableModel = (MyStockBuyTableModel) master.tableDanhMuc.getModel();
            setDataTable();
            setEventStock();
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
        MyStockBuyTableModel tableModel = (MyStockBuyTableModel) master.tableDanhMuc.getModel();
        ArrayList<MyStockBuyModel> myStockList = new ArrayList<>();
        myStockList = stockDAO.getAll();
        tableModel.setRowCount(0);
        for (int i = 0; i < myStockList.size(); i++)
        if(myStockList.get(i).getSoLuong()>0 ){
            stock = YahooFinance.get(myStockList.get(i).getSymbol());
            long giaTriHienTai = (long) ((Math.round(stock.getQuote().getPrice().floatValue() * myStockList.get(i).getSoLuong() * 100.0)) / 100.0);
            tableModel.addRow(new Object[]{
                myStockList.get(i).getSymbol(),
                myStockList.get(i).getSoLuong(),
                myStockList.get(i).getGiaBanDau(),
                (Math.round(stock.getQuote().getPrice().floatValue() * 100.0)) / 100.0,
                myStockList.get(i).get24hchange(),
                (Math.round(stock.getQuote().getPrice().floatValue() * myStockList.get(i).getSoLuong() * 100.0)) / 100.0,
                df.format(((giaTriHienTai - (myStockList.get(i).getSoLuong() * myStockList.get(i).getGiaBanDau())) > -1)
                    && ((giaTriHienTai - (myStockList.get(i).getSoLuong() * myStockList.get(i).getGiaBanDau())) < 1) 
                       ? 0 : ((giaTriHienTai - (myStockList.get(i).getSoLuong() * myStockList.get(i).getGiaBanDau())))),
                    
                "Mua thêm",
                "Bán"

            });

        }else{
            //TO DO xoas
            stockDAO.delete(myStockList.get(i));
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
        System.out.println("Tao event");

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
        master.labelRefresh.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent e) {
                if (e.getClickCount() == 1) {
                    try {
                        setDataTable();
                        master.setSumText();
                        System.out.println("refresh clicked");
                    } catch (IOException ex) {
                        Logger.getLogger(StockController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        System.out.println("Taoj xong event");
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
                MuaStockView muaStockView = new MuaStockView(master, stockBuy,acc);
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
                stockBuy.setGiaBanDau((float) table.getValueAt(modelRow, 2));
                BanStockView banStockView = new BanStockView(master, stockBuy,acc);
            }
        };

        ButtonColumn btnMua = new ButtonColumn(master.tableDanhMuc, muaThem, 7);

        btnMua.setMnemonic(KeyEvent.VK_D);

        btnMua.setToolTipText(
                "Mua thêm cổ phiếu");
        ButtonColumn btnBan = new ButtonColumn(master.tableDanhMuc, banStock, 8, Color.BLUE);

        btnBan.setMnemonic(KeyEvent.VK_D);
    }
}
