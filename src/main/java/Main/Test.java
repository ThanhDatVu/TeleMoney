/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import Controller.LoginController;
import Controller.NhanvienController;
import DAO.StockDAO;
import Model.MyStockBuyModel;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.Interval;

/**
 *
 * @author dat26
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        try {
            // TODO code application logic here
            javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
       // LoginController loginController = new LoginController();
         NhanvienController nvController = new NhanvienController();
        MyStockBuyModel myStock = new MyStockBuyModel();
        myStock.setSymbol("AAPL");
        System.out.println(myStock.get24hchange());
        System.out.println(get24hchange("AAPL"));
        // new DangNhapController(viewlogin).setEventLogin();
    }
    public static Float get24hchange(String symbol) {
        Float rounded = null;
        try {
            Calendar from = Calendar.getInstance();
            Calendar to = Calendar.getInstance();
            from.add(Calendar.DAY_OF_WEEK, -2);
            Stock google = YahooFinance.get(symbol, from, to, Interval.DAILY);
            BigDecimal price = google.getQuote().getPrice();
            System.out.println(google.getHistory().get(0));
            System.out.println(google.getHistory().get(0).getAdjClose());
            System.out.println(google.getHistory().get(1));
            System.out.println(google.getHistory().get(1).getAdjClose());

            Float change24h = 10000 * ((google.getHistory().get(1).getAdjClose().floatValue() / google.getHistory().get(0).getAdjClose().floatValue())-1);
//            System.out.println(change24h);
            rounded = (float) Math.round(change24h);
//            System.out.println(rounded / 100 + "%");
        } catch (IOException ex) {
            Logger.getLogger(MyStockBuyModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rounded/100;
    }
}
