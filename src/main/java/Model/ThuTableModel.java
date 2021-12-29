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
public class ThuTableModel extends DefaultTableModel {

    public static final Object[] TABLE_HEADER = {"Tẻn khoản thu", "Số tiền", "Mô tả","Ngày"};

    public static final Object[][] DATA = {
        {"Lương", "10000000", "Lương tháng 12", "12/12/2021"}};
    public ThuTableModel() {
        super(DATA, TABLE_HEADER);
        
    }
    
}
