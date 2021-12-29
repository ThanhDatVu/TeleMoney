/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ThuDAO;
import Model.ThuModel;
import View.ThuView;
import View.ViewSua;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public final class SuaThuController {

    private ViewSua viewSua;
    private ThuModel nv;
    private ThuDAO nhanvienDAO = null;
    ThuView owner;

    public SuaThuController() {

    }
//    

    public SuaThuController(ThuView nhanvienView, ThuModel nv) {

        //To change body of generated methods, choose Tools | Templates.
        owner = nhanvienView;
        viewSua = new ViewSua(owner, nv);
        setEventNhanvien();
        viewSua.setVisible(true);

        nhanvienDAO = new ThuDAO();

    }

    public void setEventNhanvien() {

        viewSua.addSuaListener((ActionEvent e) -> {
            try {
                viewSua.dispose();
                nv = viewSua.nv;
                viewSua.setnv();
                System.out.println("alo");
                nhanvienDAO.update(nv, viewSua.nv2);
                owner.refresh();
                JOptionPane.showMessageDialog(viewSua, "Sửa thành công");

            } catch (HeadlessException ex) {
                JOptionPane.showMessageDialog(viewSua, "Sửa thất bại");
                ex.printStackTrace();
            }
        });
        viewSua.addThoatListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    viewSua.dispose();
                    
                    
                } catch (HeadlessException ex) {
                    JOptionPane.showMessageDialog(viewSua, "Sửa thất bại");
                    ex.printStackTrace();
                }
            }
        });
        
    }

}
