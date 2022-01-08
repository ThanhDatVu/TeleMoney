/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ChiDAO;
import DAO.GuiTienDAO;
import DAO.StockDAO;
import DAO.ThuDAO;
import DAO.TraGopDAO;
import DAO.VayTienDAO;
import Model.ChiModel;
import Model.MyStockBuyModel;
import Model.UserModel;
import View.MasterTeleMoneyView;
import java.awt.Color;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public class ThongKeController {

    private MasterTeleMoneyView master;
    private UserModel acc;
    private StockDAO stockDAO;
    private ThuDAO thuDAO;
    private ChiDAO chiDAO;
    private VayTienDAO vayTienDAO;
    private TraGopDAO traGopDAO;
    private GuiTienDAO guiTienDAO;
    DecimalFormat df = new DecimalFormat("0.00");

    public ThongKeController(MasterTeleMoneyView master, UserModel acc) throws IOException {
        this.master = master;
        this.acc = acc;
        master.setVisible(true);
        stockDAO = new StockDAO();
        thuDAO = new ThuDAO();
        chiDAO = new ChiDAO();
        vayTienDAO = new VayTienDAO();
        traGopDAO = new TraGopDAO();
        guiTienDAO = new GuiTienDAO();

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
        double anUong = 0, diChuyen = 0, tienNha = 0, tienDien = 0, dichVu = 0, sucKhoe = 0, giaiTri = 0, xaGiao = 0, quaCap = 0, khac = 0;
        for (int i = 0; i < chiList.size(); i++) {
            ChiModel myChi = chiList.get(i);
            tong += myChi.getAmountChi();
            System.out.println(myChi.toString());
        }
        DefaultPieDataset dataSet1 = new DefaultPieDataset();
        for (int i = 0; i < chiList.size(); i++) {
            ChiModel myChi = chiList.get(i);

            if ("Ăn uống".equals(myChi.getMucChi())) {
                anUong += myChi.getAmountChi();
            }
            if ("Di chuyển".equals(myChi.getMucChi())) {
                diChuyen += myChi.getAmountChi();
            }
            if ("Tiền nhà".equals(myChi.getMucChi())) {
                tienNha += myChi.getAmountChi();
            }
            if ("Tiền điện, nước".equals(myChi.getMucChi())) {
                tienDien += myChi.getAmountChi();
            }
            if ("Dịch vụ".equals(myChi.getMucChi())) {
                dichVu += myChi.getAmountChi();
            }
            if ("Sức khoẻ".equals(myChi.getMucChi())) {
                sucKhoe += myChi.getAmountChi();
            }
            if ("Giải trí".equals(myChi.getMucChi())) {
                giaiTri += myChi.getAmountChi();
            }
            if ("Xã giao".equals(myChi.getMucChi())) {
                xaGiao += myChi.getAmountChi();
            }
            if ("Quà cáp".equals(myChi.getMucChi())) {
                quaCap += myChi.getAmountChi();
            }
            if ("Khác".equals(myChi.getMucChi())) {
                khac += myChi.getAmountChi();
            }

        }
        //Ăn uống Di chuyển Tiền nhà Tiền điện, nước Dịch vụ Sức khoẻ
        //Giải trí Xã giao Quà cáp Khác
        if (anUong > 0) {
            dataSet1.setValue("Ăn uống " + anUong + " VND " + df.format(100 * anUong / tong) + "%", anUong);
        }
        if (diChuyen > 0) {
            dataSet1.setValue("Di chuyển " + diChuyen + " VND " + df.format(100 * diChuyen / tong) + "%", diChuyen);
        }
        if (tienNha > 0) {
            dataSet1.setValue("Tiền nhà " + tienNha + " VND " + df.format(100 * tienNha / tong) + "%", tienNha);
        }
        if (tienDien > 0) {
            dataSet1.setValue("Tiền điện, nước " + tienDien + " VND " + df.format(100 * tienDien / tong) + "%", tienDien);
        }
        if (dichVu > 0) {
            dataSet1.setValue("Dịch vụ " + dichVu + " VND " + df.format(100 * dichVu / tong) + "%", dichVu);
        }
        if (sucKhoe > 0) {
            dataSet1.setValue("Sức khoẻ " + sucKhoe + " VND " + df.format(100 * sucKhoe / tong) + "%", sucKhoe);
        }
        if (giaiTri > 0) {
            dataSet1.setValue("Giải trí " + giaiTri + " VND " + df.format(100 * giaiTri / tong) + "%", giaiTri);
        }
        if (xaGiao > 0) {
            dataSet1.setValue("Xã giao " + xaGiao + " VND " + df.format(100 * xaGiao / tong) + "%", xaGiao);
        }
        if (quaCap > 0) {
            dataSet1.setValue("Quà cáp " + quaCap + " VND " + df.format(100 * quaCap / tong) + "%", quaCap);
        }
        if (khac > 0) {
            dataSet1.setValue("Khác " + khac + " VND " + df.format(100 * khac / tong) + "%", khac);
        }
        JFreeChart pieChart = ChartFactory.createPieChart3D("Phân bố chi tiêu", dataSet1, true, true, false);
        pieChart.setBackgroundPaint(Color.white);
        ChartPanel chartPanel = new ChartPanel(pieChart);
        chartPanel.setBackground(Color.lightGray);
        master.pnlThongKeChiTieu.add(chartPanel, java.awt.BorderLayout.WEST);

    }

    public void setChartVayNo() throws IOException {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        dataSet.addValue(1.0, "Cho vay", "");
        dataSet.addValue(3.0, "Nợ", "");
        dataSet.addValue(5.0, "Trả góp", "");

        JFreeChart barChart = ChartFactory.createBarChart("Thống kê cho vay, nợ, trả góp", "Loại", "VND", dataSet);
        barChart.setBackgroundPaint(Color.white);
        ChartPanel chartPanel = new ChartPanel(barChart);

        master.pnlThongKeVayNo.add(chartPanel, java.awt.BorderLayout.WEST);

    }

    public void setChartDauTu() throws IOException {
        ArrayList<MyStockBuyModel> stockList = new ArrayList<>();
        stockList = stockDAO.getAll();
        float tong = 0;
        for (int i = 0; i < stockList.size(); i++) {
            MyStockBuyModel myStock = stockList.get(i);
            Stock stock = YahooFinance.get(myStock.getSymbol());
            tong += stock.getQuote().getPrice().floatValue() * myStock.getSoLuong();
        }
        DefaultPieDataset dataSet = new DefaultPieDataset();
        for (int i = 0; i < stockList.size(); i++) {
            MyStockBuyModel myStock = stockList.get(i);
            Stock stock = YahooFinance.get(myStock.getSymbol());
            dataSet.setValue(myStock.getSymbol() + " $"
                    + df.format(stock.getQuote().getPrice().floatValue() * myStock.getSoLuong()) + " ~ "
                    + df.format(100 * stock.getQuote().getPrice().floatValue() * myStock.getSoLuong() / tong) + "%",
                    stock.getQuote().getPrice().floatValue() * myStock.getSoLuong());
        }
        JFreeChart pieChart = ChartFactory.createPieChart3D("Phân bố tài sản theo danh mục đầu tư", dataSet, true, true, false);
        pieChart.setBackgroundPaint(Color.white);
        ChartPanel chartPanel = new ChartPanel(pieChart);

        master.pnlThongKeDauTu.add(chartPanel, java.awt.BorderLayout.WEST);

    }
//    
//    
//    

}
