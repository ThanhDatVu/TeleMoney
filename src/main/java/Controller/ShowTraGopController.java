/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.TraGopDAO;
import DAO.StockDAO;
import Model.TraGopModel;
import Model.MyStockBuyTableModel;
import Model.TraGopTableModel;
import Model.MyTransModel;
import Model.UserModel;
import Model.TraGopTransModel;
import View.MasterTeleMoneyView;
import View.ShowTraGopView;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public class ShowTraGopController {

    DecimalFormat df = new DecimalFormat("0");
    ShowTraGopView showTraGopView;
    UserModel acc;
    TraGopDAO vayTienDAO = null;
    TraGopModel vayTienModel;
    TraGopTransTableModel thisModel = new TraGopTransTableModel();
    ArrayList<TraGopModel> stockList = new ArrayList<>();
    double soDu;

    public ShowTraGopController(ShowTraGopView showTraGopView, UserModel acc) {

        vayTienDAO = new TraGopDAO();
        this.showTraGopView = showTraGopView;
        this.acc = acc;
        this.showTraGopView.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        this.showTraGopView.tableChi.setModel(thisModel);

        setEventTrans();
        this.showTraGopView.setVisible(true);
        setData();
        //setTableButton();

    }

    public void enable() {
        setEventTrans();

        //setTableButton();
    }

    public void setData() {//thêm dũ liệu vào bảng
        TraGopTransTableModel vayTienTransTableModel = (TraGopTransTableModel) showTraGopView.tableChi.getModel();
        ArrayList<TraGopTransModel> vayTienTranList = new ArrayList<>();

        vayTienTranList = vayTienDAO.getAllTrans(acc);

        vayTienTransTableModel.setRowCount(0);
        for (int i = 0; i < vayTienTranList.size(); i++) {
            vayTienTransTableModel.addRow(new Object[]{
                //                {"ID",  "Tên","Ngân hàng", "Số tiền", "Thời gian", "Trạng thái"};
                vayTienTranList.get(i).getId(),
                vayTienTranList.get(i).getTen(),
                vayTienTranList.get(i).getBank(),
                vayTienTranList.get(i).getSotien(),
                vayTienTranList.get(i).getTime(),
                vayTienTranList.get(i).getStatus(),});
        }

    }

    public void setEventTrans() {
        System.out.println("Tao event");

        showTraGopView.btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    LocalDateTime time = LocalDateTime.now();
                    File myNewFile = new File("D:\\Project\\document\\Thong ke cac giao dich tra gop_" + time.getDayOfMonth() + " " + time.getMonth() + ".xlsx");
                    Path path = Paths.get(myNewFile.getAbsolutePath());
                    writeToExcell(showTraGopView.tableChi, path);//viết vào file

                    File file = new File("D:\\Project\\document\\");
                    Desktop desktop = Desktop.getDesktop();// mở thư mục 
                    desktop.open(file);
                } catch (IOException ex) {
                    Logger.getLogger(ShowTraGopController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }

    private static void writeToExcell(JTable table, Path path) throws FileNotFoundException, IOException {
        new WorkbookFactory();
        Workbook wb = new XSSFWorkbook(); //Excell workbook
        Sheet sheet = wb.createSheet(); //WorkSheet
        Row row = (Row) sheet.createRow(2); //Row created at line 3
        TableModel model = table.getModel(); //Table model

        Row headerRow = (Row) sheet.createRow(0); //Create row at line 0
        for (int headings = 0; headings < model.getColumnCount(); headings++) { //For each column
            headerRow.createCell(headings).setCellValue(model.getColumnName(headings));//Write column name
        }

        for (int rows = 0; rows < model.getRowCount(); rows++) { //For each table row
            for (int cols = 0; cols < table.getColumnCount(); cols++) { //For each table column
                row.createCell(cols).setCellValue(model.getValueAt(rows, cols).toString()); //Write value
            }

            //Set the row to the next one in the sequence 
            row = (Row) sheet.createRow((rows + 3));
        }
        wb.write(new FileOutputStream(path.toString()));//Save the file     
    }

}

class TraGopTransTableModel extends DefaultTableModel {

    public static final Object[] TABLE_HEADER = {"ID", "Tên", "Ngân hàng", "Số tiền", "Thời gian", "Trạng thái"};

    public static final Object[][] DATA = {};

    public TraGopTransTableModel() {
        super(DATA, TABLE_HEADER);

    }

}
