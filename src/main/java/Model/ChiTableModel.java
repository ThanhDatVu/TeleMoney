package Model;

import javax.swing.table.DefaultTableModel;

/**
 * @author ashraf
 *
 */
@SuppressWarnings("serial")
public class ChiTableModel extends DefaultTableModel {

    public static final Object[] TABLE_HEADER = {"ID","Tên khoản chi", "Danh mục", "Số tiền","Ngày"};

    public static final Object[][] DATA = {
        {"Trúng đề" , "Bài bạc", "4000000", "16/12/2000"}
    };
    public ChiTableModel() {
        super(DATA, TABLE_HEADER);
        
    }
    
}
