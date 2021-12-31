package Model;

import javax.swing.table.DefaultTableModel;

/**
 * @author ashraf
 *
 */
@SuppressWarnings("serial")
public class ThuTableModel extends DefaultTableModel {

    public static final Object[] TABLE_HEADER = {"Tên khoản thu", "Danh mục", "Số tiền","Ngày"};

    public static final Object[][] DATA = {
        {"mua đậu" , "ăn uống", "120000", "16/12/2000"}
    };
    public ThuTableModel() {
        super(DATA, TABLE_HEADER);
        
    }
    
}
