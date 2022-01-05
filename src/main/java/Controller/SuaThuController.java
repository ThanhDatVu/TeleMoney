/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ChiDAO;
import DAO.ThuDAO;
import Model.ChiModel;
import Model.ThuModel;
import View.MasterTeleMoneyView;
import View.SuaChiView;
import View.SuaThuView;
import View.ThemThuView;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class SuaThuController {

    private SuaThuView viewSuaThu;
    private ThuModel thuModel;
    private ThuDAO thuDAO = null;
    MasterTeleMoneyView owner;
    public SuaThuController() {
    
    }
//    

    public SuaThuController(SuaThuView SuaThuView) {
        
         //To change body of generated methods, choose Tools | Templates.
        viewSuaThu = SuaThuView;
        setEventSuaThu();
        viewSuaThu.setVisible(true);
        thuDAO = new ThuDAO();
        owner = viewSuaThu.owner;
         
    }

    public void setEventSuaThu() {
         viewSuaThu.btnDongY.addActionListener((ActionEvent e) -> {
            try {
                viewSuaThu.dispose();
                viewSuaThu.setthu();
                System.out.println("alo");
                thuDAO.update(viewSuaThu.thu, viewSuaThu.thu2);
                owner.refreshTabThuChi();
                JOptionPane.showMessageDialog(viewSuaThu, "Sửa thành công");

            } catch (HeadlessException ex) {
                JOptionPane.showMessageDialog(viewSuaThu, "Sửa thất bại");
                ex.printStackTrace();
            }
        });
    
}
}
