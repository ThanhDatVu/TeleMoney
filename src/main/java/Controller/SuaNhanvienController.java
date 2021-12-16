/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.NhanvienDAO;
import Model.NhanvienModel;
import View.NhanvienView;
import View.ViewSua;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public final class SuaNhanvienController {

    private ViewSua viewSua;
    private NhanvienModel nv;
    private NhanvienDAO nhanvienDAO = null;
    NhanvienView owner;

    public SuaNhanvienController() {

    }
//    

    public SuaNhanvienController(NhanvienView nhanvienView, NhanvienModel nv) {

        //To change body of generated methods, choose Tools | Templates.
        owner = nhanvienView;
        viewSua = new ViewSua(owner, nv);
        setEventNhanvien();
        viewSua.setVisible(true);

        nhanvienDAO = new NhanvienDAO();

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
