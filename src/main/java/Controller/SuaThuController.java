/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ThuDAO;
import Model.ThuModel;
import View.MasterTeleMoneyView;
import View.SuaThuView;

public class SuaThuController {

    private SuaThuView viewSuaThu;
    private ThuModel thu;
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
         
    }

    public void setEventSuaThu() {
        
    
}
}
