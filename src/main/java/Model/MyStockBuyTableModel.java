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
public class MyStockBuyTableModel extends DefaultTableModel {

    public static final Object[] TABLE_HEADER = {"Tên", "Số lượng", "Giá mua TB ($)", "Giá hiện tại ($)", "Biến động phiên giao dịch", "Giá trị hiện tại ($)", "Lợi nhuận ($)", "", ""};

    public static final Object[][] DATA = { // {"APPL (Apple)", 100, 24000, 26000,+5,26000000,"Mua thêm", "Bán"},
    };

    public MyStockBuyTableModel() {
        super(DATA, TABLE_HEADER);

    }

}
