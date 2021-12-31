/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.StockDAO;
import Model.MyStockBuyModel;
import Model.UserModel;
import View.MuaStockView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public class MuaStockController {

    MuaStockView muaStockView;
    UserModel acc;
    StockDAO stockDAO = null;
    MyStockBuyModel myStock;
    Stock stock;
    BigDecimal usd;
    ArrayList<MyStockBuyModel> stockList = new ArrayList<>();
    double soDu;

    public MuaStockController(MuaStockView muaStockView, UserModel acc) {
        stockDAO = new StockDAO();
        this.muaStockView = muaStockView;
        this.acc = acc;
        soDu = stockDAO.getSoDu(acc);
        stockList = stockDAO.getAllStockSymbol();
        try {
            System.out.println("Tao controller stock");
            usd = YahooFinance.get("USDVND=X").getQuote().getPrice();
            setEventMuaStock();
            muaStockView.setVisible(true);
            setData();
            //setTableButton();
        } catch (IOException ex) {
            Logger.getLogger(MuaStockController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public MuaStockController(MuaStockView muaStockView, MyStockBuyModel myStock, UserModel acc) {
        stockDAO = new StockDAO();
        this.myStock = myStock;
        this.muaStockView = muaStockView;
        this.acc = acc;
        soDu = stockDAO.getSoDu(acc);
        stockList = stockDAO.getAllStockSymbol();
        try {
            System.out.println("Tao controller stock");
            usd = YahooFinance.get("USDVND=X").getQuote().getPrice();
            setEventMuaStock();
            muaStockView.setVisible(true);
            setData();
            //setTableButton();
        } catch (IOException ex) {
            Logger.getLogger(MuaStockController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void enable() {
        setEventMuaStock();

        //setTableButton();
    }

    public void setData() {
        try {
            BigDecimal bigVND, bigUSD;
            bigVND = new BigDecimal(String.valueOf(soDu)).setScale(1);
            muaStockView.txtVND.setText((bigVND.toString()) + " VND");
            bigUSD = new BigDecimal(String.valueOf(soDu / usd.doubleValue())).setScale(2, BigDecimal.ROUND_HALF_UP);
            muaStockView.txtUSD.setText(bigUSD.toString() + " USD");
            muaStockView.txtSymbol.setText(myStock.getSymbol());
            stock = YahooFinance.get(myStock.getSymbol());
            BigDecimal giaTriHienTai = stock.getQuote().getPrice();
            muaStockView.textGiaNow.setText(giaTriHienTai.toString());
            muaStockView.textGiaNow.setEditable(false);
            muaStockView.txtSymbol.setEditable(false);

            muaStockView.textGiaMuaTB.setText(giaTriHienTai.toString());
        } catch (IOException ex) {
            Logger.getLogger(MuaStockController.class.getName()).log(Level.SEVERE, null, ex);
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

    public void setEventMuaStock() {
        muaStockView.textGiaMuaTB.getDocument().addDocumentListener(new DocumentListener() {
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

            public void warn() throws NumberFormatException {
                double giaMuaTB;
                double soLuong;
                if (muaStockView.textSoLuong.getText() == null || muaStockView.textGiaMuaTB.getText() == null) {
                    giaMuaTB = 0;
                    soLuong = 0;
                } else {

                    soLuong = Double.parseDouble(muaStockView.textSoLuong.getText());
                    giaMuaTB = Double.parseDouble(muaStockView.textGiaMuaTB.getText());
                }
                if (soLuong > -1 && giaMuaTB > -1) {
                    muaStockView.txtTongMuaUSD.setEditable(true);
                    muaStockView.txtTongMuaVND.setEditable(true);
                    BigDecimal bigDecimal = new BigDecimal(String.valueOf(giaMuaTB * soLuong)).setScale(2);
                    muaStockView.txtTongMuaUSD.setText(String.valueOf(bigDecimal.toString()));
                    bigDecimal = new BigDecimal(String.valueOf(giaMuaTB * soLuong * usd.doubleValue())).setScale(2);
                    muaStockView.txtTongMuaVND.setText(bigDecimal.toString());

                    muaStockView.txtTongMuaUSD.setEditable(false);
                    muaStockView.txtTongMuaVND.setEditable(false);
                }
            }
        });
        muaStockView.textSoLuong.getDocument().addDocumentListener(new DocumentListener() {
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

            public void warn() throws NumberFormatException {
                double giaMuaTB;
                double soLuong;
                if (muaStockView.textSoLuong.getText() == null && muaStockView.textGiaMuaTB.getText() == null) {
                    giaMuaTB = 0;
                    soLuong = 0;
                } else {

                    soLuong = Double.parseDouble(muaStockView.textSoLuong.getText());
                    giaMuaTB = Double.parseDouble(muaStockView.textGiaMuaTB.getText());

                    if (soLuong > -1 && giaMuaTB > -1) {
                        muaStockView.txtTongMuaUSD.setEditable(true);
                        muaStockView.txtTongMuaVND.setEditable(true);
                        BigDecimal bigDecimal = new BigDecimal(String.valueOf(giaMuaTB * soLuong)).setScale(2);
                        muaStockView.txtTongMuaUSD.setText(String.valueOf(bigDecimal.toString()));
                        bigDecimal = new BigDecimal(String.valueOf(giaMuaTB * soLuong * usd.doubleValue())).setScale(2);
                        muaStockView.txtTongMuaVND.setText(bigDecimal.toString());

                        muaStockView.txtTongMuaUSD.setEditable(false);
                        muaStockView.txtTongMuaVND.setEditable(false);
                    }

                }

            }
        }
        );

        muaStockView.btnThemStock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                double tongMuaVND = Double.parseDouble(muaStockView.txtTongMuaVND.getText());
                if (tongMuaVND > soDu) {
                    JOptionPane.showMessageDialog(null, "Vượt quá số dư khả dụng");
                } else if (tongMuaVND < 0) {
                } else {
                    int opt = JOptionPane.showConfirmDialog(muaStockView, "Xác nhận mua " + muaStockView.textSoLuong.getText() + " "
                            + muaStockView.txtSymbol.getText() + " với tổng giá trị "
                            + muaStockView.txtTongMuaVND.getText() + " VND ?", "Xác nhận", JOptionPane.YES_NO_CANCEL_OPTION);
                    if (opt == 0) {
                        float giaCuoi = 0;
                        float giaMoi, giaCu;
                        int soMoi, soCu;
                        giaCu = myStock.getGiaBanDau();
                        soCu = myStock.getSoLuong();
                        System.out.println("myStock cu:  " + myStock.toString());
                        MyStockBuyModel myTrans = myStock;
                        myTrans.setSoLuong(Integer.parseInt(muaStockView.textSoLuong.getText()));
                        myTrans.setGiaBanDau(Float.parseFloat(muaStockView.textGiaMuaTB.getText()));
                        myTrans.setTongBanDau(Float.parseFloat(muaStockView.txtTongMuaUSD.getText()));
                        Timestamp time = new Timestamp(System.currentTimeMillis());
                        myTrans.setTime(time);
                        System.out.println("trans " + myTrans.toString());
                        stockDAO.addTrans(myTrans, acc, "mua");
                        giaMoi = myTrans.getGiaBanDau();
                        soMoi = myTrans.getSoLuong();
                        giaCuoi = (soCu * giaCu + soMoi * giaMoi) / (soCu + soMoi);
                        myStock.setGiaBanDau(giaCuoi);
                        System.out.println("gia moi la: " + giaCuoi);
                        myStock.setSoLuong(soCu + soMoi);
                        stockDAO.updateMyStock(myStock.getSymbol(), myStock);
                        System.out.println("mýTOCK moi " + myStock.toString());
                        muaStockView.owner.soDuKhaDung = muaStockView.owner.soDuKhaDung - Float.parseFloat(muaStockView.txtTongMuaVND.getText());
                        muaStockView.owner.refreshTabDauTu();
                        muaStockView.owner.refreshTabDauTu();
                        muaStockView.dispose();
                    }
                }
            }
        }
        );

    }
}
