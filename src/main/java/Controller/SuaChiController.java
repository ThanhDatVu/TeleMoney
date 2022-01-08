/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ChiDAO;
import DAO.ThuDAO;
import Model.ChiModel;
import View.MasterTeleMoneyView;
import View.SuaChiView;
import View.ThemThuView;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class SuaChiController {

    private SuaChiView viewSuaChi;
    private ChiModel chiModel;
    private ChiDAO chiDAO = null;
    MasterTeleMoneyView owner;

    public SuaChiController() {

    }
//    

    public SuaChiController(SuaChiView SuaChiView) {

        //To change body of generated methods, choose Tools | Templates.
        viewSuaChi = SuaChiView;
        setEventSuaChi();
        viewSuaChi.setVisible(true);
        chiDAO = new ChiDAO();
        owner = viewSuaChi.owner;

    }

    public void setEventSuaChi() {
        viewSuaChi.btnDongYSuaChi.addActionListener((ActionEvent e) -> {
            try {
                viewSuaChi.dispose();
                viewSuaChi.setchi();
                System.out.println("alo");
                chiDAO.update(viewSuaChi.chi, viewSuaChi.chi2);
                owner.refreshTabThuChi();
                JOptionPane.showMessageDialog(viewSuaChi, "Sửa thành công");

            } catch (HeadlessException ex) {
                JOptionPane.showMessageDialog(viewSuaChi, "Sửa thất bại");
                ex.printStackTrace();
            }
        });

    }
}
