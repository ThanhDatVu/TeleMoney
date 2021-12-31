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
public class VayTienTableModel extends DefaultTableModel {

    public static final Object[] TABLE_HEADER = {"Tên", "Ngân hàng", "Số tiền (VNĐ)","Lãi suất (%)", "Kỳ hạn (tháng)","Ngày vay"};

    public static final Object[][] DATA = {
    };

    public VayTienTableModel() {
        super(DATA, TABLE_HEADER);
        
    }
    
    
    
    
    
}
