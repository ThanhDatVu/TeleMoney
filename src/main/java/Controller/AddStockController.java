/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.StockDAO;
import Model.MyStockBuyModel;
import Model.MyStockBuyTableModel;
import Model.NhanvienModel;
import Model.UserModel;
import View.AddStockView;
import View.MasterTeleMoneyView;
import View.MuaStockView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import View.NhanvienView;
import View.ViewThem;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import lib.ButtonColumn;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public class AddStockController {

    AddStockView master;
    UserModel acc;
    StockDAO stockDAO = null;
    MyStockBuyModel myStock;
    Stock stock;
    BigDecimal usd;
    ArrayList<MyStockBuyModel> stockList = new ArrayList<>();
    double soDu;

    public AddStockController(AddStockView master, UserModel acc) {
        stockDAO = new StockDAO();
        this.master = master;
        this.acc = acc;
        soDu = stockDAO.getSoDu(acc);
        stockList = stockDAO.getAllStockSymbol();
        try {
            System.out.println("Tao controller stock");
            usd = YahooFinance.get("USDVND=X").getQuote().getPrice();
            setEventStock();
            master.setVisible(true);
            setData();
            //setTableButton();
        } catch (IOException ex) {
            Logger.getLogger(AddStockController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public AddStockController(AddStockView aThis) {
        try {
            System.out.println("Tao controller stock");
            this.master = master;
            this.acc = acc;
            usd = YahooFinance.get("USDVND=X").getQuote().getPrice();
            setEventStock();

            master.setVisible(true);
            stockDAO = new StockDAO();

            setData();

            //setTableButton();
        } catch (IOException ex) {
            Logger.getLogger(AddStockController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void enable() {
        setEventStock();

        //setTableButton();
    }

    public void setData() {
        BigDecimal bigVND, bigUSD;
        bigVND = new BigDecimal(String.valueOf(soDu)).setScale(1);
        master.txtVND.setText((bigVND.toString()) + " VND");
        bigUSD = new BigDecimal(String.valueOf(soDu / usd.doubleValue())).setScale(2, BigDecimal.ROUND_HALF_UP);
        master.txtUSD.setText(bigUSD.toString() + " USD");
      

        for (int i = 0; i < stockList.size(); i++) {
//            stock = YahooFinance.get(stockList.get(i).getSymbol());
//            long giaTriHienTai = (long) ((Math.round(stock.getQuote().getPrice().floatValue() * stockList.get(i).getSoLuong() * 100.0)) / 100.0);
            master.comboStock.addItem(stockList.get(i).getSymbol() + " - " + stockList.get(i).getName());
            
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

        master.comboStock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (master.comboStock.getSelectedIndex() == 0) {
                        return;
                    }
                    int index = master.comboStock.getSelectedIndex();
                    myStock = stockList.get(index - 1);
                    System.out.println(myStock.getSymbol());
                    stock = YahooFinance.get(stockList.get(index - 1).getSymbol());
                    BigDecimal giaTriHienTai = stock.getQuote().getPrice();
                    master.textGiaNow.setText(giaTriHienTai.toString());
                    master.textGiaMuaTB.setText(giaTriHienTai.toString());
                    master.textGiaNow.setEditable(false);

                } catch (IOException ex) {
                    Logger.getLogger(AddStockController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        master.textGiaMuaTB.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                warn();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                warn();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                warn();
            }

            public void warn() {
                double giaMuaTB;
                double soLuong;
                if (master.textSoLuong.getText() == null || master.textGiaMuaTB.getText() == null) {
                    giaMuaTB = 0;
                    soLuong = 0;
                } else {

                    soLuong = Double.parseDouble(master.textSoLuong.getText());
                    giaMuaTB = Double.parseDouble(master.textGiaMuaTB.getText());
                }
                if (soLuong > -1 && giaMuaTB > -1) {
                    master.txtTongMuaUSD.setEditable(true);
                    master.txtTongMuaVND.setEditable(true);
                    BigDecimal bigDecimal = new BigDecimal(String.valueOf(giaMuaTB * soLuong)).setScale(2);
                    master.txtTongMuaUSD.setText(String.valueOf(bigDecimal.toString()));
                    bigDecimal = new BigDecimal(String.valueOf(giaMuaTB * soLuong * usd.doubleValue())).setScale(2);
                    master.txtTongMuaVND.setText(bigDecimal.toString());

                    master.txtTongMuaUSD.setEditable(false);
                    master.txtTongMuaVND.setEditable(false);
                }
            }
        });
        master.textSoLuong.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                warn();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                warn();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                warn();
            }

            public void warn() {
                double giaMuaTB;
                double soLuong;
                if (master.textSoLuong.getText() == null && master.textGiaMuaTB.getText() == null) {
                    giaMuaTB = 0;
                    soLuong = 0;
                } else {

                    soLuong = Double.parseDouble(master.textSoLuong.getText());
                    giaMuaTB = Double.parseDouble(master.textGiaMuaTB.getText());
                }
                if (soLuong > -1 && giaMuaTB > -1) {
                    master.txtTongMuaUSD.setEditable(true);
                    master.txtTongMuaVND.setEditable(true);
                    BigDecimal bigDecimal = new BigDecimal(String.valueOf(giaMuaTB * soLuong)).setScale(2);
                    master.txtTongMuaUSD.setText(String.valueOf(bigDecimal.toString()));
                    bigDecimal = new BigDecimal(String.valueOf(giaMuaTB * soLuong * usd.doubleValue())).setScale(2);
                    master.txtTongMuaVND.setText(bigDecimal.toString());

                    master.txtTongMuaUSD.setEditable(false);
                    master.txtTongMuaVND.setEditable(false);
                }

            }
        }
        );

        master.btnThemStock.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                double tongMuaVND = Double.parseDouble(master.txtTongMuaVND.getText());
                if (tongMuaVND > soDu) {
                    JOptionPane.showMessageDialog(null, "Vượt quá số dư khả dụng");
                } else {
                    int opt = JOptionPane.showConfirmDialog(master, "Xác nhận mua " + master.textSoLuong.getText() + " "
                            + master.comboStock.getSelectedItem().toString() + " với tổng giá trị "
                            + master.txtTongMuaVND.getText() + " VND ?", "Xác nhận", JOptionPane.YES_NO_CANCEL_OPTION);
                    if (opt == 0) {
                        System.out.println(myStock.toString());
                        myStock.setSoLuong(Integer.parseInt(master.textSoLuong.getText()));
                        myStock.setGiaBanDau(Float.parseFloat(master.textGiaMuaTB.getText()));
                        myStock.setTongBanDau(Float.parseFloat(master.txtTongMuaUSD.getText()));
                        Timestamp time = new Timestamp(System.currentTimeMillis());
                        myStock.setTime(time);
                        stockDAO.add(myStock);
                        master.owner.refreshTabDauTu();
                        master.dispose();
                    }
                }
            }
        }
        );

    }
}
