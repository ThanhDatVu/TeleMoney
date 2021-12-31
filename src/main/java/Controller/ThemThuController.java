/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ThuDAO;
import Model.ThuModel;
import View.MasterTeleMoneyView;
import View.ThemThuView;

public class ThemThuController {

    private ThemThuView viewThemThu;
    private ThuModel thu;
    private ThuDAO thuDAO = null;
    MasterTeleMoneyView owner;
    public ThemThuController() {
    
    }
//    

    public ThemThuController(ThemThuView ThemThuView) {
        
         //To change body of generated methods, choose Tools | Templates.
        viewThemThu = ThemThuView;
        setEventThemThu();
        
        thuDAO = new ThuDAO();
         
    }

    public void setEventThemThu() {
        
    
}
}
