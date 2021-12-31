package Model;

import javax.swing.table.DefaultTableModel;

/**
 * @author ashraf
 *
 */
@SuppressWarnings("serial")
public class ChiTableModel extends DefaultTableModel {

    public static final Object[] TABLE_HEADER = {"Tẻn khoản chi", "Danh mục", "Số tiền","Ngày"};

    public static final Object[][] DATA = {};
    public ChiTableModel() {
        super(DATA, TABLE_HEADER);
        
    }
    
}
