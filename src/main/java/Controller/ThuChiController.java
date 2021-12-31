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
import View.MasterTeleMoneyView;
import View.MuaStockView;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JTable;
import lib.ButtonColumn;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public class ThuChiController {

    private MasterTeleMoneyView master;
    private UserModel acc;
    private StockDAO stockDAO = null;
    Stock stock;
    BigDecimal usd;

    public ThuChiController(MasterTeleMoneyView master, UserModel acc) {
        try {
            System.out.println("Tao controller stock");
            this.master = master;
            this.acc = acc;
            usd = YahooFinance.get("USDVND=X").getQuote().getPrice();
            setEventStock();
            
            master.setVisible(true);
            stockDAO = new StockDAO();
            MyStockBuyTableModel tableModel = (MyStockBuyTableModel) master.tableDanhMuc.getModel();
            setDataTable();
            setEventStock();
            //setTableButton();
        } catch (IOException ex) {
            Logger.getLogger(ThuChiController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void enable() {
        setEventStock();
       
        //setTableButton();

    }

    public void setDataTable() throws IOException {
        MyStockBuyTableModel tableModel = (MyStockBuyTableModel) master.tableDanhMuc.getModel();
        ArrayList<MyStockBuyModel> myStockList = new ArrayList<>();
        myStockList = stockDAO.getAll();
        tableModel.setRowCount(0);
        for (int i = 0; i < myStockList.size(); i++) {
            stock = YahooFinance.get(myStockList.get(i).getSymbol());
            long giaTriHienTai = (long) ((Math.round(stock.getQuote().getPrice().floatValue() * myStockList.get(i).getSoLuong() * 100.0)) / 100.0);
            tableModel.addRow(new Object[]{
                myStockList.get(i).getSymbol(),
                myStockList.get(i).getSoLuong(),
                myStockList.get(i).getGiaBanDau(),
                (Math.round(stock.getQuote().getPrice().floatValue() * 100.0)) / 100.0,
                myStockList.get(i).get24hchange(),
                (Math.round(stock.getQuote().getPrice().floatValue() * myStockList.get(i).getSoLuong() * 100.0)) / 100.0,
                ((giaTriHienTai - (myStockList.get(i).getSoLuong() * myStockList.get(i).getGiaBanDau())) > -1)
                && ((giaTriHienTai - (myStockList.get(i).getSoLuong() * myStockList.get(i).getGiaBanDau())) < 1)
                ? 0 : ((giaTriHienTai - (myStockList.get(i).getSoLuong() * myStockList.get(i).getGiaBanDau()))),
                "Mua thêm",
                "Bán"

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
                        Logger.getLogger(ThuChiController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        System.out.println("Taoj xong event");
    }

}
