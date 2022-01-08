/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import Controller.LoginController;
import DAO.StockDAO;
import Model.MyStockBuyModel;
import View.LoginView;
import com.formdev.flatlaf.FlatLightLaf;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author dat26
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FlatLightLaf.setup();

        LoginView login = new LoginView();
    }

}
