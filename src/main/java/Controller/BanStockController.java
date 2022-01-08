/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.StockDAO;
import Model.MyStockBuyModel;
import Model.UserModel;
import View.MasterTeleMoneyView;
import View.BanStockView;
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

public class BanStockController {

    BanStockView banStockView;
    UserModel acc;
    StockDAO stockDAO = null;
    MyStockBuyModel myStock;
    Stock stock;
    BigDecimal usd;
    ArrayList<MyStockBuyModel> stockList = new ArrayList<>();
    double soDu;

    public BanStockController(BanStockView banStockView, UserModel acc) {
        stockDAO = new StockDAO();
        this.banStockView = banStockView;
        this.acc = acc;
        soDu = stockDAO.getSoDu(acc);
        stockList = stockDAO.getAllStockSymbol();
        try {
            System.out.println("Tao controller stock");
            usd = YahooFinance.get("USDVND=X").getQuote().getPrice();
            setEventBanStock();
            banStockView.setVisible(true);
            setData();
            //setTableButton();
        } catch (IOException ex) {
            Logger.getLogger(BanStockController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public BanStockController(BanStockView banStockView, MyStockBuyModel myStock, UserModel acc) {
        stockDAO = new StockDAO();
        this.myStock = myStock;
        this.banStockView = banStockView;
        this.acc = acc;
        soDu = stockDAO.getSoDu(acc);
        stockList = stockDAO.getAllStockSymbol();
        try {
            System.out.println("Tao controller stock");
            usd = YahooFinance.get("USDVND=X").getQuote().getPrice();
            setEventBanStock();
            banStockView.setVisible(true);
            setData();
            //setTableButton();
        } catch (IOException ex) {
            Logger.getLogger(BanStockController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public BanStockController(MasterTeleMoneyView banStockView, MyStockBuyModel myStock, UserModel acc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void enable() {
        setEventBanStock();

        //setTableButton();
    }

    public void setData() {
        try {
            BigDecimal bigVND, bigUSD;
            bigVND = new BigDecimal(String.valueOf(soDu)).setScale(1);
            banStockView.txtVND.setText((bigVND.toString()) + " VND");
            bigUSD = new BigDecimal(String.valueOf(soDu / usd.doubleValue())).setScale(2, BigDecimal.ROUND_HALF_UP);
            banStockView.txtUSD.setText(bigUSD.toString() + " USD");
            banStockView.txtSymbol.setText(myStock.getSymbol());
            banStockView.textSoLuongBanDau.setText(String.valueOf(myStock.getSoLuong()));
            stock = YahooFinance.get(myStock.getSymbol());
            BigDecimal giaTriHienTai = stock.getQuote().getPrice();
            banStockView.textGiaNow.setText(giaTriHienTai.toString());

            banStockView.textGiaNow.setEditable(false);
            banStockView.txtSymbol.setEditable(false);
            banStockView.textSoLuongBanDau.setEditable(false);

            banStockView.textGiaBanTB.setText(giaTriHienTai.toString());
        } catch (IOException ex) {
            Logger.getLogger(BanStockController.class.getName()).log(Level.SEVERE, null, ex);
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

    public void setEventBanStock() {
        banStockView.textGiaBanTB.getDocument().addDocumentListener(new DocumentListener() {
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
                double giaBanTB;
                double soLuong;
                if (banStockView.textSoLuongBanRa.getText() == null || banStockView.textGiaBanTB.getText() == null) {
                    giaBanTB = 0;
                    soLuong = 0;
                } else {

                    soLuong = Double.parseDouble(banStockView.textSoLuongBanRa.getText());
                    giaBanTB = Double.parseDouble(banStockView.textGiaBanTB.getText());
                }
                if (soLuong > -1 && giaBanTB > -1) {
                    banStockView.txtTongBanUSD.setEditable(true);
                    banStockView.txtTongBanVND.setEditable(true);
                    BigDecimal bigDecimal = new BigDecimal(String.valueOf(giaBanTB * soLuong)).setScale(2);
                    banStockView.txtTongBanUSD.setText(String.valueOf(bigDecimal.toString()));
                    bigDecimal = new BigDecimal(String.valueOf(giaBanTB * soLuong * usd.doubleValue())).setScale(2);
                    banStockView.txtTongBanVND.setText(bigDecimal.toString());

                    banStockView.txtTongBanUSD.setEditable(false);
                    banStockView.txtTongBanVND.setEditable(false);
                }
            }
        });
        banStockView.textSoLuongBanRa.getDocument().addDocumentListener(new DocumentListener() {
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
                double giaBanTB;
                double soLuong;
                if (banStockView.textSoLuongBanRa.getText() == null && banStockView.textGiaBanTB.getText() == null) {
                    giaBanTB = 0;
                    soLuong = 0;
                } else {

                    soLuong = Double.parseDouble(banStockView.textSoLuongBanRa.getText());
                    giaBanTB = Double.parseDouble(banStockView.textGiaBanTB.getText());

                    if (soLuong > -1 && giaBanTB > -1) {
                        banStockView.txtTongBanUSD.setEditable(true);
                        banStockView.txtTongBanVND.setEditable(true);
                        BigDecimal bigDecimal = new BigDecimal(String.valueOf(giaBanTB * soLuong)).setScale(2);
                        banStockView.txtTongBanUSD.setText(String.valueOf(bigDecimal.toString()));
                        bigDecimal = new BigDecimal(String.valueOf(giaBanTB * soLuong * usd.doubleValue())).setScale(2);
                        banStockView.txtTongBanVND.setText(bigDecimal.toString());

                        banStockView.txtTongBanUSD.setEditable(false);
                        banStockView.txtTongBanVND.setEditable(false);
                    }

                }

            }
        }
        );

        banStockView.btnThemStock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                double tongBanVND = Double.parseDouble(banStockView.txtTongBanVND.getText());
                if (Integer.parseInt(banStockView.textSoLuongBanRa.getText()) > myStock.getSoLuong()) {
                    JOptionPane.showMessageDialog(null, "Vượt quá số lượng hiện có");
                } else {
                    int opt = JOptionPane.showConfirmDialog(banStockView, "Xác nhận ban " + banStockView.textSoLuongBanRa.getText() + " "
                            + banStockView.txtSymbol.getText() + " với tổng giá trị "
                            + banStockView.txtTongBanVND.getText() + " VND ?", "Xác nhận", JOptionPane.YES_NO_CANCEL_OPTION);
                    if (opt == 0) {
                        float giaCuoi = 0;
                        float giaMoi, giaCu;
                        int soMoi, soCu;
                        giaCu = myStock.getGiaBanDau();
                        soCu = myStock.getSoLuong();
                        System.out.println("myStock cu:  " + myStock.toString());
                        MyStockBuyModel myTrans = myStock;
                        myTrans.setSoLuong(Integer.parseInt(banStockView.textSoLuongBanRa.getText()));
                        myTrans.setGiaBanDau(Float.parseFloat(banStockView.textGiaBanTB.getText()));
                        myTrans.setTongBanDau(Float.parseFloat(banStockView.txtTongBanUSD.getText()));
                        Timestamp time = new Timestamp(System.currentTimeMillis());
                        myTrans.setTime(time);
                        System.out.println("trans " + myTrans.toString());
                        stockDAO.addTrans(myTrans, acc, "ban");
                        giaMoi = myTrans.getGiaBanDau();
                        soMoi = myTrans.getSoLuong();
                        giaCuoi = giaCu;
                        myStock.setGiaBanDau(giaCuoi);
                        System.out.println("gia moi la: " + giaCuoi);
                        myStock.setSoLuong(soCu - soMoi);
                        stockDAO.updateMyStock(myStock.getSymbol(), myStock);
                        System.out.println("mýTOCK moi " + myStock.toString());
                        banStockView.owner.soDuKhaDung = banStockView.owner.soDuKhaDung + Float.parseFloat(banStockView.txtTongBanVND.getText());
                        banStockView.owner.refreshTabDauTu();
                        banStockView.dispose();
                    }
                }
            }
        }
        );

    }
}
