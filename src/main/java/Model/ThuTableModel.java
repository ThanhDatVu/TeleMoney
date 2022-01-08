package Model;

import javax.swing.table.DefaultTableModel;

/**
 * @author ashraf
 *
 */
@SuppressWarnings("serial")
public class ThuTableModel extends DefaultTableModel {

    public static final Object[] TABLE_HEADER = {"ID", "Tên khoản thu", "Danh mục", "Số tiền", "Ngày"};

    public static final Object[][] DATA = {};

    public ThuTableModel() {
        super(DATA, TABLE_HEADER);

    }

}
