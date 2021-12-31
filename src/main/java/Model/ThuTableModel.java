package Model;

import javax.swing.table.DefaultTableModel;

/**
 * @author ashraf
 *
 */
@SuppressWarnings("serial")
public class ThuTableModel extends DefaultTableModel {

    public static final Object[] TABLE_HEADER = {"Tẻn khoản thu", "Danh mục", "Số tiền","Ngày"};

    public static final Object[][] DATA = {
        {"Lương tháng 12", "Lương", "100000000000", "12/12/2021"}};
    public ThuTableModel() {
        super(DATA, TABLE_HEADER);
        
    }
    
}
