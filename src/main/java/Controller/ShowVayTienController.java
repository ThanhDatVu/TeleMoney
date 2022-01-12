/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.VayTienDAO;
import DAO.StockDAO;
import Model.VayTienModel;
import Model.MyStockBuyTableModel;
import Model.VayTienTableModel;
import Model.MyTransModel;
import Model.UserModel;
import Model.VayTienTransModel;
import View.MasterTeleMoneyView;
import View.ShowVayTienView;
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

public class ShowVayTienController {

    DecimalFormat df = new DecimalFormat("0");
    ShowVayTienView showVayTienView;
    UserModel acc;
    VayTienDAO vayTienDAO = null;
    VayTienModel vayTienModel;
    VayTienTransTableModel thisModel = new VayTienTransTableModel();
    ArrayList<VayTienModel> stockList = new ArrayList<>();
    double soDu;

    public ShowVayTienController(ShowVayTienView showVayTienView, UserModel acc) {

        vayTienDAO = new VayTienDAO();
        this.showVayTienView = showVayTienView;
        this.acc = acc;
        this.showVayTienView.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        this.showVayTienView.tableChi.setModel(thisModel);

        setEventTrans();
        this.showVayTienView.setVisible(true);
        setData();
        //setTableButton();

    }

    public ShowVayTienController(ShowVayTienView showVayTienView, UserModel acc, int vayTienID) {

        vayTienDAO = new VayTienDAO();
        this.showVayTienView = showVayTienView;
        this.acc = acc;
        this.showVayTienView.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        this.showVayTienView.tableChi.setModel(thisModel);

        setEventTrans();
        this.showVayTienView.setVisible(true);
        setDataChiTiet(vayTienID);
        //setTableButton();

    }

    public void enable() {
        setEventTrans();

        //setTableButton();
    }

    public void setData() {//thêm dũ liệu vào bảng
        VayTienTransTableModel vayTienTransTableModel = (VayTienTransTableModel) showVayTienView.tableChi.getModel();
        ArrayList<VayTienTransModel> vayTienTranList = new ArrayList<>();

        vayTienTranList = vayTienDAO.getAllTrans(acc);

        vayTienTransTableModel.setRowCount(0);
        for (int i = 0; i < vayTienTranList.size(); i++) {
            if (vayTienTranList.get(i).getStatus().equalsIgnoreCase("đã thanh toán")) {
                vayTienTransTableModel.addRow(new Object[]{
                    //                {"ID",  "Tên","Ngân hàng", "Số tiền", "Thời gian", "Trạng thái"};
                    vayTienTranList.get(i).getId(),
                    vayTienTranList.get(i).getTen(),
                    vayTienTranList.get(i).getBank(),
                    df.format(vayTienTranList.get(i).getSotien()),
                    vayTienTranList.get(i).getTime(),
                    vayTienTranList.get(i).getStatus(),});
            }
        }

    }

    public void setDataChiTiet(int vayTienID) {//thêm dũ liệu vào bảng
        VayTienTransTableModel vayTienTransTableModel = (VayTienTransTableModel) showVayTienView.tableChi.getModel();
        ArrayList<VayTienTransModel> vayTienTranList = new ArrayList<>();

        vayTienTranList = vayTienDAO.getTrans(acc, vayTienID);

        vayTienTransTableModel.setRowCount(0);
        for (int i = 0; i < vayTienTranList.size(); i++) {
            vayTienTransTableModel.addRow(new Object[]{
                //                {"ID",  "Tên","Ngân hàng", "Số tiền", "Thời gian", "Trạng thái"};
                vayTienTranList.get(i).getId(),
                vayTienTranList.get(i).getTen(),
                vayTienTranList.get(i).getBank(),
                df.format(vayTienTranList.get(i).getSotien()),
                vayTienTranList.get(i).getTime(),
                vayTienTranList.get(i).getStatus(),});
        }

    }

    public void setEventTrans() {
        System.out.println("Tao event");

        showVayTienView.btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    LocalDateTime time = LocalDateTime.now();
                    File myNewFile = new File("D:\\Project\\document\\Thong ke cac giao dich vay tien_" + time.getDayOfMonth() + " " + time.getMonth() + ".xlsx");
                    Path path = Paths.get(myNewFile.getAbsolutePath());
                    writeToExcell(showVayTienView.tableChi, path);//viết vào file

                    File file = new File("D:\\Project\\document\\");
                    Desktop desktop = Desktop.getDesktop();// mở thư mục 
                    desktop.open(file);
                } catch (IOException ex) {
                    Logger.getLogger(ShowVayTienController.class.getName()).log(Level.SEVERE, null, ex);
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

class VayTienTransTableModel extends DefaultTableModel {

    public static final Object[] TABLE_HEADER = {"ID", "Tên", "Ngân hàng", "Số tiền", "Thời gian", "Trạng thái"};

    public static final Object[][] DATA = {};

    public VayTienTransTableModel() {
        super(DATA, TABLE_HEADER);

    }

}
