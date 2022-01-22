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
import View.MasterTeleMoneyView;
import View.SignUpView;

public class DangKyController {

    private SignUpView signUpView;
    private UserModel user;
    private LoginDAO loginDAO = null;

    public DangKyController() {

    }

    public DangKyController(SignUpView signUpView) {

        this.signUpView = signUpView;
        setEventLogin();

        this.signUpView.setVisible(true);
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

        signUpView.addSignUpListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    user = signUpView.getUser();
                    if (user.getPassword().equals("")
                            || user.getUsername().equals("")
                            || signUpView.txt_pwd1.getPassword().toString().equals("")) {
                        JOptionPane.showMessageDialog(null, "Ban chua nhap du thong tin");
                    } else if (!user.getPassword().equals(signUpView.txt_pwd1.getPassword().toString())) {
                        JOptionPane.showMessageDialog(null, "Mật khẩu chưa khớp");
                    } else {
                        loginDAO.dangky(user.getUsername(), user.getPassword());
                        JOptionPane.showMessageDialog(null, "Đăng ký thành công");
                        LoginView login = new LoginView();
                        signUpView.dispose();

                    }

                } catch (Exception ex) {
                }
            }
        });
        signUpView.addHuyListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                 LoginView login = new LoginView();
                 signUpView.dispose();
                
            }
        });

    }

}
