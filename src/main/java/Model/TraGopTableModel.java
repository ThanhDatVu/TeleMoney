package Model;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import lib.ButtonColumn;

/**
 * @author ashraf
 *
 */
@SuppressWarnings("serial")
public class TraGopTableModel extends DefaultTableModel {

    public static final Object[] TABLE_HEADER = {"Tên", "Công ty", "Số tiền (VNĐ)","Số tháng", "Tiền hàng tháng","Ngày"};

    public static final Object[][] DATA = {
    };

    public TraGopTableModel() {
        super(DATA, TABLE_HEADER);
        
    }
    
    
    
    
    
}