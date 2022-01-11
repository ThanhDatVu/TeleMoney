/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.GuiTienDAO;
import DAO.StockDAO;
import Model.GuiTienModel;
import Model.MyStockBuyTableModel;
import Model.GuiTienTableModel;
import Model.MyTransModel;
import Model.UserModel;
import Model.GuiTienTransModel;
import View.MasterTeleMoneyView;
import View.ShowGuiTienView;
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

public class ShowGuiTienController {

    DecimalFormat df = new DecimalFormat("0");
    ShowGuiTienView showGuiTienView;
    UserModel acc;
    GuiTienDAO guiTienDAO = null;
    GuiTienModel guiTienModel;
    GuiTienTransTableModel thisModel = new GuiTienTransTableModel();
    ArrayList<GuiTienModel> stockList = new ArrayList<>();
    double soDu;

    public ShowGuiTienController(ShowGuiTienView showGuiTienView, UserModel acc) {

        guiTienDAO = new GuiTienDAO();
        this.showGuiTienView = showGuiTienView;
        this.acc = acc;
        this.showGuiTienView.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        this.showGuiTienView.tableChi.setModel(thisModel);

        setEventTrans();
        this.showGuiTienView.setVisible(true);
        setData();
        //setTableButton();

    }
    public ShowGuiTienController(ShowGuiTienView showGuiTienView, UserModel acc, int guiTienID) {

        guiTienDAO = new GuiTienDAO();
        this.showGuiTienView = showGuiTienView;
        this.acc = acc;
        this.showGuiTienView.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        this.showGuiTienView.tableChi.setModel(thisModel);

        setEventTrans();
        this.showGuiTienView.setVisible(true);
        setDataChiTiet(guiTienID);
        

    }

    public void enable() {
        setEventTrans();

      
    }

    public void setData() {//thêm dũ liệu vào bảng
        GuiTienTransTableModel guiTienTransTableModel = (GuiTienTransTableModel) showGuiTienView.tableChi.getModel();
        ArrayList<GuiTienTransModel> guiTienTranList = new ArrayList<>();

        guiTienTranList = guiTienDAO.getAllTrans(acc);

        guiTienTransTableModel.setRowCount(0);
        for (int i = 0; i < guiTienTranList.size(); i++) {
            guiTienTransTableModel.addRow(new Object[]{
                //                {"ID",  "Tên","Ngân hàng", "Số tiền", "Thời gian", "Trạng thái"};
                guiTienTranList.get(i).getId(),
                guiTienTranList.get(i).getTen(),
                guiTienTranList.get(i).getBank(),
                df.format(guiTienTranList.get(i).getSotien()),
                guiTienTranList.get(i).getTime(),
                guiTienTranList.get(i).getStatus(),});
        }

    }
    public void setDataChiTiet(int guiTienID) {//thêm dũ liệu vào bảng
        GuiTienTransTableModel guiTienTransTableModel = (GuiTienTransTableModel) showGuiTienView.tableChi.getModel();
        ArrayList<GuiTienTransModel> guiTienTranList = new ArrayList<>();

        guiTienTranList = guiTienDAO.getTrans(acc,guiTienID);

        guiTienTransTableModel.setRowCount(0);
        for (int i = 0; i < guiTienTranList.size(); i++) {
            guiTienTransTableModel.addRow(new Object[]{
                //                {"ID",  "Tên","Ngân hàng", "Số tiền", "Thời gian", "Trạng thái"};
                guiTienTranList.get(i).getId(),
                guiTienTranList.get(i).getTen(),
                guiTienTranList.get(i).getBank(),
                df.format(guiTienTranList.get(i).getSotien()),
                guiTienTranList.get(i).getTime(),
                guiTienTranList.get(i).getStatus(),});
        }

    }

    public void setEventTrans() {
        System.out.println("Tao event");

        showGuiTienView.btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    LocalDateTime time = LocalDateTime.now();
                    File myNewFile = new File("D:\\Project\\document\\Thong ke cac giao dich gui tien_" + time.getDayOfMonth() + " " + time.getMonth() + ".xlsx");
                    Path path = Paths.get(myNewFile.getAbsolutePath());
                    writeToExcell(showGuiTienView.tableChi, path);//viết vào file

                    File file = new File("D:\\Project\\document\\");
                    Desktop desktop = Desktop.getDesktop();// mở thư mục 
                    desktop.open(file);
                } catch (IOException ex) {
                    Logger.getLogger(ShowGuiTienController.class.getName()).log(Level.SEVERE, null, ex);
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

class GuiTienTransTableModel extends DefaultTableModel {

    public static final Object[] TABLE_HEADER = {"ID", "Tên", "Ngân hàng", "Số tiền", "Thời gian", "Trạng thái"};

    public static final Object[][] DATA = {};

    public GuiTienTransTableModel() {
        super(DATA, TABLE_HEADER);

    }

}
