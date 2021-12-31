/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.LoginDAO;
import Model.UserModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import View.LoginView;
import View.MasterViewTest;
import View.MasterTeleMoneyView;

import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import lib.ButtonColumn;

public class LoginController {

    private LoginView loginView;
    private UserModel user;
    private LoginDAO loginDAO = null;

    public LoginController() {

        loginView = new LoginView();
        setEventLogin();

        loginView.setVisible(true);
        loginDAO = new LoginDAO();

    }
//    public void setButton(){
//    Action delete = new AbstractAction() {
//        public void actionPerformed(ActionEvent e) {
//            JTable table = (JTable) e.getSource();
//            int modelRow = Integer.valueOf(e.getActionCommand());
//            ((DefaultTableModel) table.getModel()).removeRow(modelRow);
//        }
//    };
//    ButtonColumn buttonColumn = new ButtonColumn(loginView, delete, 2);
//
//    buttonColumn.setMnemonic (KeyEvent.VK_D);
//    
//    
//    }

    public void setEventLogin() {

        loginView.addLoginListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    user = loginView.getUser();
                    if (user.getPassword().equals("")
                            || user.getUsername().equals("")) {
                        JOptionPane.showMessageDialog(null, "Ban chua nhap du thong tin");
                    } else {
                        UserModel check = loginDAO.login(user.getUsername(), user.getPassword());
                        if (check == null) {
                            JOptionPane.showMessageDialog(null, "Tai khoan hoac mat khau sai");
                            return;

                        }else{
                            MasterTeleMoneyView master = new MasterTeleMoneyView(check);
                            master.setVisible(true);
                            loginView.dispose();
                        }
                        
                    }

                } catch (Exception ex) {
                }
            }
        });

    }

}
