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
public class NhanvienTableModel extends DefaultTableModel {

    public static final Object[] TABLE_HEADER = {"Mã Nhân viên", "Họ và Tên", "Lương", "", ""};

    public static final Object[][] DATA = {
        {"AT912837", "Vũ Thị Bưởi", "28000000", "Xoá", "Sửa"},};

    public NhanvienTableModel() {
        super(DATA, TABLE_HEADER);

    }

}
