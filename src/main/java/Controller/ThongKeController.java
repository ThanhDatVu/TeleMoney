/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ChiDAO;
import DAO.StockDAO;
import DAO.ThuDAO;
import Model.ChiModel;
import Model.MyStockBuyModel;
import Model.UserModel;
import View.MasterTeleMoneyView;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import yahoofinance.Stock;

public class ThongKeController {

    private MasterTeleMoneyView master;
    private UserModel acc;
    private StockDAO stockDAO;
    private ThuDAO thuDAO;
    private ChiDAO chiDAO;
    DecimalFormat df = new DecimalFormat("0.00");

    Stock stock;

    public ThongKeController(MasterTeleMoneyView master, UserModel acc) throws IOException {
        this.master = master;
        this.acc = acc;
        master.setVisible(true);
        stockDAO = new StockDAO();
        thuDAO = new ThuDAO();
        chiDAO = new ChiDAO();

        setChartChiTieu();
        setChartVayNo();
        setChartDauTu();
        master.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        master.pack();

    }

    public void enable() {
        //setEventThuChi();

        //setTableButton();
    }

    public void setChartChiTieu() throws IOException {
        ArrayList<ChiModel> chiList = new ArrayList<>();
        chiList = chiDAO.getAll(acc);
        float tong = 0;
        double anUong, diChuyen, tienNha, tienDien, dichVu, sucKhoe, giaiTri, xaGiao, quaCap, khac;
        for (int i = 0; i < chiList.size(); i++) {
            ChiModel myChi = chiList.get(i);
            tong += myChi.getAmountChi();
        }
        DefaultPieDataset dataSet1 = new DefaultPieDataset();
        for (int i = 0; i < chiList.size(); i++) {
            ChiModel myChi = chiList.get(i);
            //Ăn uống Di chuyển Tiền nhà Tiền điện, nước Dịch vụ Sức khoẻ
            //Giải trí Xã giao Quà cáp Khác
            if (myChi.getMucChi() == "Ăn uống") {

            }
        }
        dataSet1.setValue("Ăn uống 34%", 34);
        dataSet1.setValue("Di chuyển 21%", 21);
        dataSet1.setValue("Tiền nhà 35%", 35);
        dataSet1.setValue("Quà cáp 10%", 10);

        // based on the dataset we create the chart
        JFreeChart pieChart1 = ChartFactory.createPieChart3D("Phân bố chi tiêu", dataSet1, true, true, false);
        ChartPanel chartPanel1 = new ChartPanel(pieChart1);
        master.pnlThongKeChiTieu.add(chartPanel1, java.awt.BorderLayout.WEST);

    }
//    

    public void setChartVayNo() throws IOException {
        DefaultPieDataset dataSet2 = new DefaultPieDataset();
        dataSet2.setValue("Vay 27%", 29);
        dataSet2.setValue("Nợ 73%", 73);
//        dataSet.setValue("Tesla 25%", 25);
//        dataSet.setValue("DOGECOIN 15%",15 );

        // based on the dataset we create the chart
        JFreeChart pieChart2 = ChartFactory.createPieChart3D("Phân bố tài sản vay, nợ", dataSet2, true, true, false);
        ChartPanel chartPanel2 = new ChartPanel(pieChart2);
        master.pnlThongKeVayNo.add(chartPanel2, java.awt.BorderLayout.WEST);

    }

    public void setChartDauTu() throws IOException {
        ArrayList<MyStockBuyModel> stockList = new ArrayList<>();
        stockList = stockDAO.getAll();
        float tong = 0;
        for (int i = 0; i < stockList.size(); i++) {
            MyStockBuyModel myStock = stockList.get(i);
            tong += myStock.getGiaBanDau() * myStock.getSoLuong();
        }
        DefaultPieDataset dataSet = new DefaultPieDataset();
        for (int i = 0; i < stockList.size(); i++) {
            MyStockBuyModel myStock = stockList.get(i);
            dataSet.setValue(myStock.getSymbol() + " "
                    + df.format(myStock.getGiaBanDau() * myStock.getSoLuong()) + " $ "
                    + df.format(100 * myStock.getGiaBanDau() * myStock.getSoLuong() / tong) + "%",
                    myStock.getGiaBanDau() * myStock.getSoLuong());
        }

//        dataSet.setValue("APPLE 19.3%", 19);
//        dataSet.setValue("Coinbase 1.4%", 1);
//        dataSet.setValue("Tesla 43.8%", 45);
//        dataSet.setValue("GOOGL 8.1%", 8);
//        dataSet.setValue("MDT 0.8%", 0.8);
//        dataSet.setValue("SLB 0.4%", 0.4);
        // based on the dataset we create the chart
        JFreeChart pieChart = ChartFactory.createPieChart3D("Phân bố tài sản theo danh mục đầu tư", dataSet, true, true, false);
        ChartPanel chartPanel = new ChartPanel(pieChart);
        master.pnlThongKeDauTu.add(chartPanel, java.awt.BorderLayout.WEST);

    }
//    
//    
//    

}
