/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.StockDAO;
import Model.ChiTableModel;
import Model.GuiTienTableModel;
import Model.MyStockBuyModel;
import Model.MyStockBuyTableModel;
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
import java.awt.event.ActionListener;
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
    ThuTableModel chiTableModel = new ThuTableModel();
    ChiTableModel thuTableModel = new ChiTableModel();
    public ThuChiController(MasterTeleMoneyView master, UserModel acc) {
        this.master = master;
        this.acc = acc;
        setEventThuChi();
        master.setVisible(true);
        this.master.tbChi.setModel(chiTableModel);
        this.master.tbThu.setModel(thuTableModel);
        //setDataTable();
        setEventThuChi();
        //setTableButton();
    }

    public void enable() {
        setEventThuChi();
       
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

    public void setEventThuChi() {
        System.out.println("Tao event");

        
       
        
        master.btnThemChi.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ThemChiView themChiView = new ThemChiView(master, acc);
                themChiView.setVisible(true);
            }
        }
        );
        master.btnThemThu.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ThemThuView themThuView = new ThemThuView(master, acc);
                themThuView.setVisible(true);
            }
        }
        );
        master.btnSuaThu.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SuaThuView suaThuView = new SuaThuView();
                suaThuView.setVisible(true);
            }
        }
        );
        master.btnSuaChi.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SuaChiView suaChiView = new SuaChiView();
                suaChiView.setVisible(true);
            }
        }
        );
        System.out.println("Taoj xong event");
    }

}
