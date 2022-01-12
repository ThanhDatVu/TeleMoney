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
import Model.GuiTienTransModel;
import Model.MyStockBuyModel;
import Model.ThuModel;
import Model.TraGopTransModel;
import Model.UserModel;
import Model.VayTienTransModel;
import View.MasterTeleMoneyView;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.ui.TextAnchor;
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
    DecimalFormat dfvn = new DecimalFormat("0");

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
        setEvent();
        setChartChiTieu();
        setChartThuNhap();
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
        master.pnlThongKeChiTieu.removeAll();
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
        master.pnlThongKeChiTieu.revalidate();
        master.pnlThongKeChiTieu.repaint();
    }

    public void setChartThuNhap() throws IOException {
        master.pnlThongKeThuNhap.removeAll();
        ArrayList<ThuModel> thuList = new ArrayList<>();
        thuList = thuDAO.getAll(acc);
        float tong = 0;
        double luong = 0, thuong = 0, khac = 0;
        for (int i = 0; i < thuList.size(); i++) {
            ThuModel myThu = thuList.get(i);
            tong += myThu.getAmountThu();
            System.out.println(myThu.toString());
        }
        DefaultPieDataset dataSet1 = new DefaultPieDataset();
        for (int i = 0; i < thuList.size(); i++) {
            ThuModel myThu = thuList.get(i);
            if ("Lương chính".equals(myThu.getMucThu())) {
                luong += myThu.getAmountThu();
            }
            if ("Thưởng ".equals(myThu.getMucThu())) {
                thuong += myThu.getAmountThu();
            }
            if ("Khoản thu khác".equals(myThu.getMucThu())) {
                khac += myThu.getAmountThu();
            }

        }
        //Ăn uống Di chuyển Tiền nhà Tiền điện, nước Dịch vụ Sức khoẻ
        //Giải trí Xã giao Quà cáp Khác
        if (luong > 0) {
            dataSet1.setValue("Lương " + dfvn.format(luong) + " VND " + df.format(100 * luong / tong) + "%", luong);
        }
        if (thuong > 0) {
            dataSet1.setValue("Thưởng " + dfvn.format(thuong) + " VND " + df.format(100 * thuong / tong) + "%", thuong);
        }
        if (khac > 0) {
            dataSet1.setValue("Khoan thu khac " + dfvn.format(khac) + " VND " + df.format(100 * khac / tong) + "%", khac);
        }

        JFreeChart pieChart = ChartFactory.createPieChart3D("Phân bố tổng thu nhập", dataSet1, true, true, false);
        pieChart.setBackgroundPaint(Color.white);
        ChartPanel chartPanel = new ChartPanel(pieChart);
        chartPanel.setBackground(Color.lightGray);
        master.pnlThongKeThuNhap.add(chartPanel, java.awt.BorderLayout.WEST);
        master.pnlThongKeThuNhap.revalidate();
        master.pnlThongKeThuNhap.repaint();
    }

    public void setChartThuNhap(int thang, int nam) throws IOException {
        master.pnlThongKeThuNhap.removeAll();
        ArrayList<ThuModel> thuList1 = new ArrayList<>();
        ArrayList<ThuModel> thuList = new ArrayList<>();
        thuList1 = thuDAO.getAll(acc);
        for (int i = 0; i < thuList1.size(); i++) {
            ThuModel myThu = thuList1.get(i);
            LocalDateTime time = myThu.getTimeThu().toLocalDateTime();
            if (time.getMonthValue() == thang && time.getYear() == nam) {
                thuList.add(myThu);

            }

        }
        float tong = 0;
        double luong = 0, thuong = 0, khac = 0;
        for (int i = 0; i < thuList.size(); i++) {
            ThuModel myThu = thuList.get(i);
            tong += myThu.getAmountThu();
            System.out.println(myThu.toString());
        }
        DefaultPieDataset dataSet1 = new DefaultPieDataset();
        for (int i = 0; i < thuList.size(); i++) {
            ThuModel myThu = thuList.get(i);
            if ("Lương chính".equals(myThu.getMucThu())) {
                luong += myThu.getAmountThu();
            }
            if ("Thưởng ".equals(myThu.getMucThu())) {
                thuong += myThu.getAmountThu();
            }
            if ("Khoản thu khác".equals(myThu.getMucThu())) {
                khac += myThu.getAmountThu();
            }

        }
        //Ăn uống Di chuyển Tiền nhà Tiền điện, nước Dịch vụ Sức khoẻ
        //Giải trí Xã giao Quà cáp Khác
        if (luong > 0) {
            dataSet1.setValue("Lương " + dfvn.format(luong) + " VND " + df.format(100 * luong / tong) + "%", luong);
        }
        if (thuong > 0) {
            dataSet1.setValue("Thưởng " + dfvn.format(thuong) + " VND " + df.format(100 * thuong / tong) + "%", thuong);
        }
        if (khac > 0) {
            dataSet1.setValue("Khoan thu khac " + dfvn.format(khac) + " VND " + df.format(100 * khac / tong) + "%", khac);
        }

        JFreeChart pieChart = ChartFactory.createPieChart3D("Phân bố tổng thu nhập", dataSet1, true, true, false);
        pieChart.setBackgroundPaint(Color.white);
        ChartPanel chartPanel = new ChartPanel(pieChart);
        chartPanel.setBackground(Color.lightGray);
        master.pnlThongKeThuNhap.add(chartPanel, java.awt.BorderLayout.WEST);
        master.pnlThongKeThuNhap.revalidate();
        master.pnlThongKeThuNhap.repaint();
    }

    public void setChartChiTieu(int thang, int nam) throws IOException {
        master.pnlThongKeChiTieu.removeAll();
        ArrayList<ChiModel> chiList1 = new ArrayList<>();
        ArrayList<ChiModel> chiList = new ArrayList<>();
        chiList1 = chiDAO.getAll(acc);
        for (int i = 0; i < chiList1.size(); i++) {
            ChiModel myChi = chiList1.get(i);
            LocalDateTime time = myChi.getTimeChi().toLocalDateTime();
            if (time.getMonthValue() == thang && time.getYear() == nam) {
                chiList.add(myChi);

            }

        }

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
        JFreeChart pieChart = ChartFactory.createPieChart3D("Phân bố chi tiêu tháng " + thang + " năm " + nam, dataSet1, true, true, false);
        pieChart.setBackgroundPaint(Color.white);
        ChartPanel chartPanel = new ChartPanel(pieChart);
        chartPanel.setBackground(Color.lightGray);
        master.pnlThongKeChiTieu.add(chartPanel, java.awt.BorderLayout.WEST);
        master.pnlThongKeChiTieu.revalidate();
        master.pnlThongKeChiTieu.repaint();
    }

    public void setChartVayNo() throws IOException {
        master.pnlThongKeVayNo.removeAll();
        double vayTienTotal = 0;
        double guiTienTotal = 0;
        double traGopTotal = 0;

        // Lấy dữ liệu Vay tiền
        ArrayList<VayTienTransModel> vayTienTranList = new ArrayList<>();
        vayTienTranList = vayTienDAO.getAllTrans(acc);
        for (int i = 0; i < vayTienTranList.size(); i++) {
            if (vayTienTranList.get(i).getStatus().equalsIgnoreCase("chưa thanh toán")) {
                vayTienTotal += vayTienTranList.get(i).getSotien();

            }
        }
        // Lấy dữ liệu Trả góp
        ArrayList<TraGopTransModel> traGopTranList = new ArrayList<>();
        traGopTranList = traGopDAO.getAllTrans(acc);
        for (int i = 0; i < traGopTranList.size(); i++) {

            if (traGopTranList.get(i).getStatus().equalsIgnoreCase("chưa thanh toán")) {
                traGopTotal += traGopTranList.get(i).getSotien();

            }

        }
        // Lấy dữ liệu Gửi tiền / Cho vay / Tiết kiệm
        ArrayList<GuiTienTransModel> guiTienTranList = new ArrayList<>();
        guiTienTranList = guiTienDAO.getAllTrans(acc);
        for (int i = 0; i < guiTienTranList.size(); i++) {
            if (guiTienTranList.get(i).getStatus().equalsIgnoreCase("chưa thanh toán")) {
                guiTienTotal += guiTienTranList.get(i).getSotien();

            }
        }
        guiTienTotal = guiTienTotal / 1000000;
        vayTienTotal = vayTienTotal / 1000000;
        traGopTotal = traGopTotal / 1000000;

        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        dataSet.addValue(guiTienTotal, "Cho vay", "");
        dataSet.addValue(vayTienTotal, "Nợ", "");
        dataSet.addValue(traGopTotal, "Trả góp", "");

        JFreeChart barChart = ChartFactory.createBarChart("Thống kê cho vay, nợ, trả góp", "Loại", "triệu VND", dataSet);
        barChart.setBackgroundPaint(Color.white);
        CategoryPlot plot = (CategoryPlot) barChart.getPlot();
        CategoryItemRenderer renderer = ((CategoryPlot) barChart.getPlot()).getRenderer();
        renderer.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        renderer.setDefaultItemLabelsVisible(true);
        ItemLabelPosition position = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12,
                TextAnchor.BASELINE_CENTER);
        renderer.setDefaultPositiveItemLabelPosition(position);
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setUpperMargin(0.15);
        ChartPanel chartPanel = new ChartPanel(barChart);

        master.pnlThongKeVayNo.add(chartPanel, java.awt.BorderLayout.WEST);
        master.pnlThongKeVayNo.revalidate();
        master.pnlThongKeVayNo.repaint();
    }

    public void setChartDauTu() throws IOException {
        master.pnlThongKeDauTu.removeAll();
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
        master.pnlThongKeDauTu.revalidate();
        master.pnlThongKeDauTu.repaint();

    }
//    
//    
//    

    public void setChart() {
        try {
            setChartChiTieu();
            setChartVayNo();
            setChartDauTu();
        } catch (IOException ex) {
            Logger.getLogger(ThongKeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setEvent() {
        master.btnLocTheoThang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int thang = Integer.parseInt(master.comboThang.getSelectedItem().toString());
                    int nam = Integer.parseInt(master.comboNam.getSelectedItem().toString());
                    setChartChiTieu(thang, nam);
                    setChartThuNhap(thang, nam);
                } catch (IOException ex) {
                    Logger.getLogger(ThongKeController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }

}
