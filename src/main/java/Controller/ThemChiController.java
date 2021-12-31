/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ThuDAO;
import Model.ThuModel;
import View.MasterTeleMoneyView;
import View.ThemChiView;

public class ThemChiController {

    private ThemChiView viewThemChi;
    private ThuModel chi;
    private ThuDAO thuDAO = null;
    MasterTeleMoneyView owner;
    public ThemChiController() {
    
    }
//    

    public ThemChiController(ThemChiView ThemChiView) {
        
         //To change body of generated methods, choose Tools | Templates.
        viewThemChi = ThemChiView;
        setEventThemChi();
        viewThemChi.setVisible(true);
        thuDAO = new ThuDAO();
         
    }

    public void setEventThemChi() {
        
    
}
}
