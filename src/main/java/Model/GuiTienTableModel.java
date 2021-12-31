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
public class GuiTienTableModel extends DefaultTableModel {

    public static final Object[] TABLE_HEADER = {"Tên", "Ngân hàng", "Số tiền (VNĐ)","Lãi suất (%)", "Kỳ hạn (tháng)","Ngày gửi"};

    public static final Object[][] DATA = {
    };

    public GuiTienTableModel() {
        super(DATA, TABLE_HEADER);
        
    }
    
    
    
    
    
}
