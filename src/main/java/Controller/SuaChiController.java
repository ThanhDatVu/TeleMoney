/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ThuDAO;
import Model.ChiModel;
import View.MasterTeleMoneyView;
import View.SuaChiView;
import View.ThemThuView;

public class SuaChiController {

    private SuaChiView viewSuaChi;
    private ChiModel nv;
    private ThuDAO thuDAO = null;
    MasterTeleMoneyView owner;
    public SuaChiController() {
    
    }
//    

    public SuaChiController(SuaChiView SuaChiView) {
        
         //To change body of generated methods, choose Tools | Templates.
        viewSuaChi = SuaChiView;
        setEventSuaChi();
        viewSuaChi.setVisible(true);
        thuDAO = new ThuDAO();
         
    }

    public void setEventSuaChi() {
        
    
}
}
