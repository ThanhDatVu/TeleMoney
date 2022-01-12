/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import javax.swing.table.DefaultTableModel;
import Controller.LoginController;
import Controller.MasterController;
import Controller.StockController;
import Controller.ThongKeController;
import Controller.VayNoController;
import Controller.ThuChiController1;
import Controller.ThuChiController2;
import DAO.StockDAO;
import Model.MyStockBuyModel;
import Model.MyStockBuyTableModel;
import Model.UserModel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import lib.ButtonColumn;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

/**
 *
 * @author dat26
 */
public class MasterTeleMoneyView extends javax.swing.JFrame {

    /**
     * Creates new form TabbedPane
     */
    DecimalFormat df = new DecimalFormat("0");
    StockDAO stockDAO = new StockDAO();

    public UserModel user;
    public CardLayout cardLayout;
    TableColumn col;
    public MasterController masterController;
    public StockController stockController;
    public ThuChiController1 thuChiController1;
    public ThuChiController2 thuChiController2;
    public VayNoController vayNoController;
    public ThongKeController thongKeController;
    public Float Usd;
    public double soDuKhaDung, tongTaiSan;

    public MasterTeleMoneyView() throws IOException {
        //    this.Usd = YahooFinance.get("USDVND=X").getQuote().getPrice().floatValue();

        initComponents();
        setTiGiaSoDu();
        ChartTest();
        cardLayout = (CardLayout) (pnlCards.getLayout());
        setLocationRelativeTo(null);

//        col = tableDanhMuc.getColumnModel().getColumn(2);
//        //define the renderer
//        col.setCellRenderer(new MasterTeleMoneyView.MyRenderer(Color.red, Color.green));
    }

    public MasterTeleMoneyView(UserModel user) throws IOException {
        this.Usd = YahooFinance.get("USDVND=X").getQuote().getPrice().floatValue();
        this.user = user;
        initComponents();
        this.cardLayout = (CardLayout) (pnlCards.getLayout());
        this.masterController = new MasterController(this, user);
        this.stockController = new StockController(this, user);
        this.vayNoController = new VayNoController(this, user);

        this.thuChiController1 = new ThuChiController1(this, user);
        this.thuChiController2 = new ThuChiController2(this, user);
        this.thongKeController = new ThongKeController(this, user);

        this.setTitle("TELEMONEY");
        setUsername();
        soDuKhaDung = stockDAO.getSoDu(user);
        tongTaiSan = stockDAO.getTongTaiSan(user);
        setTiGiaSoDu();
        setLocationRelativeTo(null);
        setSumText();
        pack();
        System.out.println("user ID " + user.getId());

    }

    private void myInitComponent() throws IOException {

    }

    public void ChartTest() {

    }

    private void setUsername() {
        txtUsername.setText(user.getUsername());
    }

    public void refreshTabDauTu() {
        try {
            setTiGiaSoDu();
            setSumText();
            stockController.setDataTable();
        } catch (IOException ex) {
            Logger.getLogger(MasterTeleMoneyView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void refreshTabThuChi() {
        try {
            setTiGiaSoDu();
            thuChiController1.setDataTable();
        } catch (IOException ex) {
            Logger.getLogger(MasterTeleMoneyView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void refreshTabVayNo() {
        try {
            setTiGiaSoDu();

            vayNoController.setDataTable();
        } catch (IOException ex) {
            Logger.getLogger(MasterTeleMoneyView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jSplitPane1 = new javax.swing.JSplitPane();
        pnlCards = new javax.swing.JPanel();
        pnlChiTieu = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbThu = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbChi = new javax.swing.JTable();
        btnThemThu = new javax.swing.JButton();
        btnSuaThu = new javax.swing.JButton();
        btnXoaThu = new javax.swing.JButton();
        btnThemChi = new javax.swing.JButton();
        btnSuaChi = new javax.swing.JButton();
        btnXoaChi = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        btnShowThu = new javax.swing.JButton();
        btnShowChi = new javax.swing.JButton();
        btnTimKiemThu = new javax.swing.JButton();
        btnTimKiemChi = new javax.swing.JButton();
        textThu = new javax.swing.JTextField();
        textChi = new javax.swing.JTextField();
        labelSoDuChiTieu = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        pnlDauTu = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        labelSoDauTu = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDanhMuc = new javax.swing.JTable();
        labelUSD = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        labelVND = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnThemStock = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        labelTotalStock = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        labelTotalReturn = new javax.swing.JLabel();
        labelTotalStockVND = new javax.swing.JLabel();
        labelTotalReturnVND = new javax.swing.JLabel();
        btnShowTrans = new javax.swing.JButton();
        txtLocDauTu = new javax.swing.JTextField();
        btnLoc = new javax.swing.JButton();
        btnShowStockChart = new javax.swing.JButton();
        pnlTaiKhoan = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtUsername = new javax.swing.JTextPane();
        btnDangXuat = new javax.swing.JButton();
        jScrollPaneVayNo = new javax.swing.JScrollPane();
        pnlVayNo = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableGuiTien = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableVayTien = new javax.swing.JTable();
        btnThemTK = new javax.swing.JButton();
        btnXemChiTietGuiTien = new javax.swing.JButton();
        btnThemVay = new javax.swing.JButton();
        btnXemChiTietVayTien = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnShowTK = new javax.swing.JButton();
        btnLocTK = new javax.swing.JButton();
        btnLocVay = new javax.swing.JButton();
        txtLocTK = new javax.swing.JTextField();
        txtLocVay = new javax.swing.JTextField();
        labelSoDuVayNo = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tableTraGop = new javax.swing.JTable();
        btnXemChiTietTraGop = new javax.swing.JButton();
        btnThemTG = new javax.swing.JButton();
        btnLocTG = new javax.swing.JButton();
        txtLocTG = new javax.swing.JTextField();
        btnShowTG = new javax.swing.JButton();
        btnShowVay = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        btnCheckThanhToan = new javax.swing.JButton();
        jScrollPaneThongKe = new javax.swing.JScrollPane();
        pnlThongKe = new javax.swing.JPanel();
        pnlThongKeChiTieu = new javax.swing.JPanel();
        pnlThongKeVayNo = new javax.swing.JPanel();
        pnlThongKeDauTu = new javax.swing.JPanel();
        pnlThongKeText = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        labelTongNo = new javax.swing.JLabel();
        labelTongTaiSan = new javax.swing.JLabel();
        labelTongChoVay = new javax.swing.JLabel();
        labelSoDuThongKe = new javax.swing.JLabel();
        labelChiTieuThang = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        labelThuNhapThang = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        labelReturn2 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        labelTotalReturn2 = new javax.swing.JLabel();
        comboNam = new javax.swing.JComboBox<>();
        comboThang = new javax.swing.JComboBox<>();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        btnLocTheoThang = new javax.swing.JButton();
        pnlThongKeThuNhap = new javax.swing.JPanel();
        pnlLeftNav = new javax.swing.JPanel();
        labelMenuVayNo = new javax.swing.JLabel();
        labelMenuDauTu = new javax.swing.JLabel();
        labelMenuThongKe = new javax.swing.JLabel();
        labelMenuTaiKhoan = new javax.swing.JLabel();
        labelLogo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelMenuChiTieu = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlCards.setBackground(new java.awt.Color(153, 255, 204));
        pnlCards.setMinimumSize(new java.awt.Dimension(199, 200));
        pnlCards.setLayout(new java.awt.CardLayout());

        pnlChiTieu.setBackground(new java.awt.Color(255, 255, 255));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setText("QUẢN LÝ CHI TIÊU");

        tbThu.setAutoCreateRowSorter(true);
        tbThu.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
        jScrollPane5.setViewportView(tbThu);

        tbChi.setAutoCreateRowSorter(true);
        tbChi.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
        jScrollPane6.setViewportView(tbChi);

        btnThemThu.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        btnThemThu.setText("Thêm");

        btnSuaThu.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        btnSuaThu.setText("Sửa");

        btnXoaThu.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        btnXoaThu.setText("Xóa");

        btnThemChi.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        btnThemChi.setText("Thêm");

        btnSuaChi.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        btnSuaChi.setText("Sửa");

        btnXoaChi.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        btnXoaChi.setText("Xóa");

        jLabel17.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel17.setText("CÁC KHOẢN CHI TIÊU");

        btnShowThu.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        btnShowThu.setText("Show");

        btnShowChi.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        btnShowChi.setText("Show");

        btnTimKiemThu.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        btnTimKiemThu.setText("Tìm kiếm");

        btnTimKiemChi.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        btnTimKiemChi.setText("Tìm kiếm");

        textThu.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N

        textChi.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N

        labelSoDuChiTieu.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        labelSoDuChiTieu.setText("Số dư khả dụng");

        jLabel19.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel19.setText("CÁC KHOẢN THU NHẬP");

        javax.swing.GroupLayout pnlChiTieuLayout = new javax.swing.GroupLayout(pnlChiTieu);
        pnlChiTieu.setLayout(pnlChiTieuLayout);
        pnlChiTieuLayout.setHorizontalGroup(
            pnlChiTieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChiTieuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlChiTieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlChiTieuLayout.createSequentialGroup()
                        .addComponent(btnThemThu, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSuaThu, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXoaThu, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTimKiemThu)
                        .addGap(40, 40, 40)
                        .addComponent(textThu, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56))
                    .addGroup(pnlChiTieuLayout.createSequentialGroup()
                        .addComponent(btnThemChi, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSuaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXoaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTimKiemChi)
                        .addGap(39, 39, 39)
                        .addComponent(textChi, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61))))
            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(pnlChiTieuLayout.createSequentialGroup()
                .addGroup(pnlChiTieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlChiTieuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnShowThu, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlChiTieuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnShowChi, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlChiTieuLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(labelSoDuChiTieu, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(732, Short.MAX_VALUE))
            .addComponent(jScrollPane6)
            .addGroup(pnlChiTieuLayout.createSequentialGroup()
                .addGroup(pnlChiTieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlChiTieuLayout.createSequentialGroup()
                        .addGap(419, 419, 419)
                        .addComponent(jLabel17))
                    .addGroup(pnlChiTieuLayout.createSequentialGroup()
                        .addGap(415, 415, 415)
                        .addGroup(pnlChiTieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlChiTieuLayout.setVerticalGroup(
            pnlChiTieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChiTieuLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelSoDuChiTieu)
                .addGap(22, 22, 22)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlChiTieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemThu)
                    .addComponent(btnSuaThu)
                    .addComponent(btnXoaThu)
                    .addComponent(btnTimKiemThu)
                    .addComponent(textThu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnShowThu)
                .addGap(17, 17, 17)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlChiTieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemChi)
                    .addComponent(btnSuaChi)
                    .addComponent(btnXoaChi)
                    .addComponent(btnTimKiemChi)
                    .addComponent(textChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnShowChi)
                .addContainerGap(157, Short.MAX_VALUE))
        );

        pnlCards.add(pnlChiTieu, "cardChiTieu");

        pnlDauTu.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("QUẢN LÝ CÁC DANH MỤC ĐẦU TƯ");

        jLabel12.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel12.setText("Số dư khả dụng: ");

        labelSoDauTu.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        labelSoDauTu.setText("350.000.000VND");

        jScrollPane1.setBackground(new java.awt.Color(255, 204, 204));

        tableDanhMuc.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
        tableDanhMuc.setToolTipText("");
        jScrollPane1.setViewportView(tableDanhMuc);

        labelUSD.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        labelUSD.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelUSD.setText("1");

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel4.setText("USD=");

        labelVND.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        labelVND.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelVND.setText("xxx");

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel6.setText("VND");

        btnThemStock.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        btnThemStock.setText("Thêm danh mục đầu tư");

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel5.setText("Tổng giá trị các danh mục : ");

        labelTotalStock.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        labelTotalStock.setText("xUSD");

        jLabel14.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel14.setText("Tổng lợi nhuận                  :");

        labelTotalReturn.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        labelTotalReturn.setText("xUSD");

        labelTotalStockVND.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        labelTotalStockVND.setText("xVND");

        labelTotalReturnVND.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        labelTotalReturnVND.setText("xVND");

        btnShowTrans.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        btnShowTrans.setText("Xem lịch sử giao dịch");

        btnLoc.setText("Lọc");

        btnShowStockChart.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        btnShowStockChart.setText("Xem biểu đồ giá");

        javax.swing.GroupLayout pnlDauTuLayout = new javax.swing.GroupLayout(pnlDauTu);
        pnlDauTu.setLayout(pnlDauTuLayout);
        pnlDauTuLayout.setHorizontalGroup(
            pnlDauTuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(pnlDauTuLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(pnlDauTuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDauTuLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelSoDauTu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelUSD, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(pnlDauTuLayout.createSequentialGroup()
                        .addComponent(btnShowStockChart, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)))
                .addGroup(pnlDauTuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtLocDauTu)
                    .addGroup(pnlDauTuLayout.createSequentialGroup()
                        .addComponent(labelVND, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)))
                .addGap(22, 22, 22))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDauTuLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(btnThemStock, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnShowTrans, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addGroup(pnlDauTuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33)
                .addGroup(pnlDauTuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelTotalStock)
                    .addComponent(labelTotalReturn))
                .addGap(87, 87, 87)
                .addGroup(pnlDauTuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTotalStockVND)
                    .addComponent(labelTotalReturnVND))
                .addGap(90, 90, 90))
            .addGroup(pnlDauTuLayout.createSequentialGroup()
                .addGap(364, 364, 364)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlDauTuLayout.setVerticalGroup(
            pnlDauTuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDauTuLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDauTuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(labelSoDauTu)
                    .addComponent(labelUSD)
                    .addComponent(jLabel4)
                    .addComponent(labelVND)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlDauTuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLocDauTu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLoc)
                    .addComponent(btnShowStockChart))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlDauTuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemStock)
                    .addComponent(jLabel5)
                    .addComponent(labelTotalStock)
                    .addComponent(labelTotalStockVND)
                    .addComponent(btnShowTrans))
                .addGap(18, 18, 18)
                .addGroup(pnlDauTuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTotalReturnVND)
                    .addComponent(labelTotalReturn)
                    .addComponent(jLabel14))
                .addGap(230, 230, 230))
        );

        pnlCards.add(pnlDauTu, "cardDauTu");

        pnlTaiKhoan.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        jLabel1.setText("Tên đăng nhập: ");

        txtUsername.setEditable(false);
        txtUsername.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        txtUsername.setText("placeholder");
        jScrollPane2.setViewportView(txtUsername);

        btnDangXuat.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        btnDangXuat.setText("Đăng xuất");

        javax.swing.GroupLayout pnlTaiKhoanLayout = new javax.swing.GroupLayout(pnlTaiKhoan);
        pnlTaiKhoan.setLayout(pnlTaiKhoanLayout);
        pnlTaiKhoanLayout.setHorizontalGroup(
            pnlTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTaiKhoanLayout.createSequentialGroup()
                .addGap(249, 249, 249)
                .addGroup(pnlTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlTaiKhoanLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(478, Short.MAX_VALUE))
        );
        pnlTaiKhoanLayout.setVerticalGroup(
            pnlTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTaiKhoanLayout.createSequentialGroup()
                .addGap(248, 248, 248)
                .addGroup(pnlTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31)
                .addComponent(btnDangXuat)
                .addContainerGap(468, Short.MAX_VALUE))
        );

        pnlCards.add(pnlTaiKhoan, "cardTaiKhoan");

        pnlVayNo.setBackground(new java.awt.Color(255, 255, 255));

        tableGuiTien.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
        tableGuiTien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tableGuiTien);

        tableVayTien.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
        tableVayTien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(tableVayTien);

        btnThemTK.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        btnThemTK.setText("Thêm");

        btnXemChiTietGuiTien.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        btnXemChiTietGuiTien.setText("Xem");

        btnThemVay.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        btnThemVay.setText("Thêm");

        btnXemChiTietVayTien.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        btnXemChiTietVayTien.setText("Xem");

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel3.setText("VAY TIỀN");

        btnShowTK.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        btnShowTK.setText("Xem toàn bộ giao dịch đã thực hiện");

        btnLocTK.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        btnLocTK.setText("Tìm kiếm");

        btnLocVay.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        btnLocVay.setText("Tìm kiếm");

        txtLocTK.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N

        txtLocVay.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N

        labelSoDuVayNo.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        labelSoDuVayNo.setText("Số dư khả dụng: ");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("QUẢN LÝ VAY NỢ");

        tableTraGop.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
        tableTraGop.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane7.setViewportView(tableTraGop);

        btnXemChiTietTraGop.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        btnXemChiTietTraGop.setText("Xem");

        btnThemTG.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        btnThemTG.setText("Thêm");

        btnLocTG.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        btnLocTG.setText("Tìm kiếm");

        txtLocTG.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N

        btnShowTG.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        btnShowTG.setText("Xem toàn bộ giao dịch đã thực hiện");

        btnShowVay.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        btnShowVay.setText("Xem toàn bộ giao dịch đã thực hiện");

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel8.setText("GỬI TIỀN");

        jLabel18.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel18.setText("TRẢ GÓP");

        btnCheckThanhToan.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        btnCheckThanhToan.setText("Kiểm tra các giao dịch đến hạn");

        javax.swing.GroupLayout pnlVayNoLayout = new javax.swing.GroupLayout(pnlVayNo);
        pnlVayNo.setLayout(pnlVayNoLayout);
        pnlVayNoLayout.setHorizontalGroup(
            pnlVayNoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVayNoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlVayNoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlVayNoLayout.createSequentialGroup()
                        .addComponent(btnThemVay, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnXemChiTietVayTien, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLocVay, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(txtLocVay, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61))
                    .addGroup(pnlVayNoLayout.createSequentialGroup()
                        .addComponent(btnThemTG, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnXemChiTietTraGop, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLocTG, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(txtLocTG, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61))
                    .addGroup(pnlVayNoLayout.createSequentialGroup()
                        .addGroup(pnlVayNoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnShowTG, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnShowVay, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnShowTK, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlVayNoLayout.createSequentialGroup()
                        .addGroup(pnlVayNoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlVayNoLayout.createSequentialGroup()
                                .addGroup(pnlVayNoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlVayNoLayout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addComponent(labelSoDuVayNo, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(134, 134, 134)
                                        .addComponent(jLabel8))
                                    .addGroup(pnlVayNoLayout.createSequentialGroup()
                                        .addGap(451, 451, 451)
                                        .addComponent(jLabel18)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCheckThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlVayNoLayout.createSequentialGroup()
                                .addComponent(btnThemTK, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnXemChiTietGuiTien, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 556, Short.MAX_VALUE)
                                .addComponent(btnLocTK, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(txtLocTK, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(56, 56, 56))))
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jScrollPane4)
            .addComponent(jScrollPane7)
            .addGroup(pnlVayNoLayout.createSequentialGroup()
                .addGap(464, 464, 464)
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlVayNoLayout.setVerticalGroup(
            pnlVayNoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVayNoLayout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlVayNoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlVayNoLayout.createSequentialGroup()
                        .addComponent(labelSoDuVayNo)
                        .addGap(51, 51, 51))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlVayNoLayout.createSequentialGroup()
                        .addComponent(btnCheckThanhToan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(pnlVayNoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemTK)
                    .addComponent(btnXemChiTietGuiTien)
                    .addComponent(btnLocTK)
                    .addComponent(txtLocTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnShowTK)
                .addGap(25, 25, 25)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlVayNoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemVay)
                    .addComponent(btnXemChiTietVayTien)
                    .addComponent(btnLocVay)
                    .addComponent(txtLocVay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnShowVay)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlVayNoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemTG)
                    .addComponent(btnXemChiTietTraGop)
                    .addComponent(btnLocTG)
                    .addComponent(txtLocTG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnShowTG)
                .addGap(67, 67, 67))
        );

        jScrollPaneVayNo.setViewportView(pnlVayNo);

        pnlCards.add(jScrollPaneVayNo, "cardVayNo");

        pnlThongKe.setBackground(new java.awt.Color(255, 255, 255));

        pnlThongKeChiTieu.setBackground(new java.awt.Color(255, 255, 255));
        pnlThongKeChiTieu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnlThongKeChiTieu.setLayout(new java.awt.BorderLayout());

        pnlThongKeVayNo.setBackground(new java.awt.Color(255, 255, 255));
        pnlThongKeVayNo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnlThongKeVayNo.setLayout(new java.awt.BorderLayout());

        pnlThongKeDauTu.setBackground(new java.awt.Color(255, 255, 255));
        pnlThongKeDauTu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnlThongKeDauTu.setLayout(new java.awt.BorderLayout());

        pnlThongKeText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel7.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel7.setText("Số dư khả dụng: ");

        jLabel11.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel11.setText("Tổng tài sản:");

        jLabel13.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel13.setText("Tổng số nợ:");

        jLabel15.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel15.setText("Tổng số cho vay: ");

        labelTongNo.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        labelTongNo.setText("110000000 VND");

        labelTongTaiSan.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        labelTongTaiSan.setText("890760000 VND");

        labelTongChoVay.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        labelTongChoVay.setText("13722222 VND");

        labelSoDuThongKe.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        labelSoDuThongKe.setText("VND");

        labelChiTieuThang.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        labelChiTieuThang.setText(" 850000 VND");

        jLabel25.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel25.setText("Chi tiêu hàng ngày trong tháng: ");

        jLabel26.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel26.setText("Thu nhập trong tháng: ");

        labelThuNhapThang.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        labelThuNhapThang.setText("13000000 VND");

        jLabel28.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel28.setText("Tổng giá trị các danh mục đầu tư: ");

        labelReturn2.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        labelReturn2.setText("13000000 VND");

        jLabel30.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel30.setText("Lợi nhuận: ");

        labelTotalReturn2.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        labelTotalReturn2.setText("13000000 VND");

        javax.swing.GroupLayout pnlThongKeTextLayout = new javax.swing.GroupLayout(pnlThongKeText);
        pnlThongKeText.setLayout(pnlThongKeTextLayout);
        pnlThongKeTextLayout.setHorizontalGroup(
            pnlThongKeTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongKeTextLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(pnlThongKeTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlThongKeTextLayout.createSequentialGroup()
                        .addGroup(pnlThongKeTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel15)
                            .addComponent(jLabel11))
                        .addGap(43, 43, 43)
                        .addGroup(pnlThongKeTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelTongChoVay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelTongNo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelTongTaiSan, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                            .addComponent(labelSoDuThongKe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel13))
                .addGroup(pnlThongKeTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlThongKeTextLayout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addGroup(pnlThongKeTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addComponent(jLabel26)
                            .addComponent(jLabel28)))
                    .addGroup(pnlThongKeTextLayout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jLabel30)))
                .addGap(43, 43, 43)
                .addGroup(pnlThongKeTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelThuNhapThang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlThongKeTextLayout.createSequentialGroup()
                        .addGroup(pnlThongKeTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelChiTieuThang, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelReturn2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelTotalReturn2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlThongKeTextLayout.setVerticalGroup(
            pnlThongKeTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongKeTextLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(pnlThongKeTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlThongKeTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel25)
                        .addComponent(labelChiTieuThang))
                    .addGroup(pnlThongKeTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(labelSoDuThongKe)))
                .addGap(28, 28, 28)
                .addGroup(pnlThongKeTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlThongKeTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel26)
                        .addComponent(labelThuNhapThang))
                    .addGroup(pnlThongKeTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(labelTongTaiSan)))
                .addGap(28, 28, 28)
                .addGroup(pnlThongKeTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(labelTongNo)
                    .addComponent(jLabel28)
                    .addComponent(labelReturn2))
                .addGap(28, 28, 28)
                .addGroup(pnlThongKeTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlThongKeTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel30)
                        .addComponent(labelTotalReturn2))
                    .addGroup(pnlThongKeTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(labelTongChoVay)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        comboNam.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        comboNam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2021", "2022", "2023", "2024", "2025" }));
        comboNam.setSelectedIndex(1);

        comboThang.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        comboThang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        jLabel31.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel31.setText("Năm");

        jLabel32.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        jLabel32.setText("Tháng");

        btnLocTheoThang.setFont(new java.awt.Font("Segoe UI Semilight", 0, 14)); // NOI18N
        btnLocTheoThang.setText("Lọc theo thời gian");
        btnLocTheoThang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocTheoThangActionPerformed(evt);
            }
        });

        pnlThongKeThuNhap.setBackground(new java.awt.Color(255, 255, 255));
        pnlThongKeThuNhap.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pnlThongKeThuNhap.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout pnlThongKeLayout = new javax.swing.GroupLayout(pnlThongKe);
        pnlThongKe.setLayout(pnlThongKeLayout);
        pnlThongKeLayout.setHorizontalGroup(
            pnlThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongKeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlThongKeLayout.createSequentialGroup()
                        .addGroup(pnlThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pnlThongKeChiTieu, javax.swing.GroupLayout.DEFAULT_SIZE, 984, Short.MAX_VALUE)
                            .addComponent(pnlThongKeDauTu, javax.swing.GroupLayout.DEFAULT_SIZE, 984, Short.MAX_VALUE)
                            .addComponent(pnlThongKeVayNo, javax.swing.GroupLayout.DEFAULT_SIZE, 984, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlThongKeLayout.createSequentialGroup()
                        .addGroup(pnlThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlThongKeLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel32)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel31)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63)
                                .addComponent(btnLocTheoThang)
                                .addGap(218, 218, 218))
                            .addComponent(pnlThongKeText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(152, 152, 152))
                    .addGroup(pnlThongKeLayout.createSequentialGroup()
                        .addComponent(pnlThongKeThuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 982, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        pnlThongKeLayout.setVerticalGroup(
            pnlThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongKeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlThongKeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(pnlThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31)
                    .addComponent(jLabel32)
                    .addComponent(btnLocTheoThang))
                .addGap(18, 18, 18)
                .addComponent(pnlThongKeThuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(pnlThongKeChiTieu, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlThongKeVayNo, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlThongKeDauTu, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(335, 335, 335))
        );

        jScrollPaneThongKe.setViewportView(pnlThongKe);

        pnlCards.add(jScrollPaneThongKe, "cardThongKe");

        jSplitPane1.setBottomComponent(pnlCards);

        pnlLeftNav.setBackground(new java.awt.Color(178, 118, 216));
        pnlLeftNav.setMinimumSize(new java.awt.Dimension(180, 100));

        labelMenuVayNo.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        labelMenuVayNo.setForeground(new java.awt.Color(255, 255, 255));
        labelMenuVayNo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMenuVayNo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/borrow_money_30px.png"))); // NOI18N
        labelMenuVayNo.setText("QUẢN LÝ VAY NỢ");

        labelMenuDauTu.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        labelMenuDauTu.setForeground(new java.awt.Color(255, 255, 255));
        labelMenuDauTu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMenuDauTu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/invest_30px.png"))); // NOI18N
        labelMenuDauTu.setText("QUẢN LÝ ĐẦU TƯ");

        labelMenuThongKe.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        labelMenuThongKe.setForeground(new java.awt.Color(255, 255, 255));
        labelMenuThongKe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMenuThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chart_30px.png"))); // NOI18N
        labelMenuThongKe.setText("THỐNG KÊ CHUNG");

        labelMenuTaiKhoan.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        labelMenuTaiKhoan.setForeground(new java.awt.Color(255, 255, 255));
        labelMenuTaiKhoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/acc_30px.png"))); // NOI18N
        labelMenuTaiKhoan.setText("TÀI KHOẢN");

        labelLogo.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        labelLogo.setForeground(new java.awt.Color(255, 255, 255));
        labelLogo.setText("TELEMONEY");

        labelMenuChiTieu.setBackground(new java.awt.Color(255, 255, 255));
        labelMenuChiTieu.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        labelMenuChiTieu.setForeground(new java.awt.Color(255, 255, 255));
        labelMenuChiTieu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMenuChiTieu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buying_30px.png"))); // NOI18N
        labelMenuChiTieu.setText("QUẢN LÝ CHI TIÊU");

        javax.swing.GroupLayout pnlLeftNavLayout = new javax.swing.GroupLayout(pnlLeftNav);
        pnlLeftNav.setLayout(pnlLeftNavLayout);
        pnlLeftNavLayout.setHorizontalGroup(
            pnlLeftNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelMenuDauTu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlLeftNavLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlLeftNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlLeftNavLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLeftNavLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pnlLeftNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLeftNavLayout.createSequentialGroup()
                                .addComponent(labelLogo)
                                .addGap(32, 32, 32))
                            .addComponent(labelMenuTaiKhoan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))))
            .addComponent(labelMenuVayNo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(labelMenuChiTieu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlLeftNavLayout.createSequentialGroup()
                .addComponent(labelMenuThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlLeftNavLayout.setVerticalGroup(
            pnlLeftNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLeftNavLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(labelLogo)
                .addGap(70, 70, 70)
                .addComponent(jLabel2)
                .addGap(54, 54, 54)
                .addComponent(labelMenuChiTieu, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelMenuVayNo, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelMenuDauTu, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelMenuThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 303, Short.MAX_VALUE)
                .addComponent(labelMenuTaiKhoan)
                .addGap(43, 43, 43))
        );

        jSplitPane1.setTopComponent(pnlLeftNav);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1250, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 801, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLocTheoThangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocTheoThangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLocTheoThangActionPerformed

    public void setTiGiaSoDu() {
        try {
            Stock stock = YahooFinance.get("USDVND=X");
            labelVND.setText(String.valueOf(stock.getQuote().getPrice().floatValue()));
        } catch (IOException ex) {
            labelVND.setText("1 USD = 22835 VND");
            Logger.getLogger(MasterTeleMoneyView.class.getName()).log(Level.SEVERE, null, ex);
        }

        labelSoDauTu.setText(String.valueOf(df.format(soDuKhaDung)) + " VND");
        labelSoDuThongKe.setText(String.valueOf(df.format(soDuKhaDung)) + " VND");
        labelSoDuChiTieu.setText("Số dư khả dụng : " + String.valueOf(df.format(soDuKhaDung)) + " VND");
        labelSoDuVayNo.setText("Số dư khả dụng : " + String.valueOf(df.format(soDuKhaDung)) + " VND");
        stockDAO.updateSoDu((float) soDuKhaDung, user);
    }

    public void setSumText() {
        double total = 0, totalReturn = 0;
        int prow = 5;

        for (int i = 0; i <= tableDanhMuc.getRowCount() - 1; i++) {
            total = total + Double.parseDouble(tableDanhMuc.getValueAt(i, 5).toString());
            totalReturn = totalReturn + Double.parseDouble(tableDanhMuc.getValueAt(i, 6).toString());

        }
        System.out.println("total stock:" + total);
        System.out.println("total return:" + totalReturn);
        labelTotalStock.setText(String.valueOf(Math.round(total)) + " USD");
        labelReturn2.setText(String.valueOf(Math.round(total)) + " USD");
        labelTotalReturn.setText(String.valueOf(Math.round(totalReturn)) + " USD");
        labelTotalReturn2.setText(String.valueOf(Math.round(totalReturn)) + " USD");
        labelTotalStockVND.setText("( " + String.valueOf(Math.round(total * Usd)) + " VND)");
        labelTotalReturnVND.setText("( " + String.valueOf(Math.round(totalReturn * Usd)) + " VND)");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MasterTeleMoneyView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MasterTeleMoneyView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MasterTeleMoneyView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MasterTeleMoneyView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MasterTeleMoneyView().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(MasterTeleMoneyView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCheckThanhToan;
    public javax.swing.JButton btnDangXuat;
    private javax.swing.JButton btnLoc;
    public javax.swing.JButton btnLocTG;
    public javax.swing.JButton btnLocTK;
    public javax.swing.JButton btnLocTheoThang;
    public javax.swing.JButton btnLocVay;
    public javax.swing.JButton btnShowChi;
    public javax.swing.JButton btnShowStockChart;
    public javax.swing.JButton btnShowTG;
    public javax.swing.JButton btnShowTK;
    public javax.swing.JButton btnShowThu;
    public javax.swing.JButton btnShowTrans;
    public javax.swing.JButton btnShowVay;
    public javax.swing.JButton btnSuaChi;
    public javax.swing.JButton btnSuaThu;
    public javax.swing.JButton btnThemChi;
    public javax.swing.JButton btnThemStock;
    public javax.swing.JButton btnThemTG;
    public javax.swing.JButton btnThemTK;
    public javax.swing.JButton btnThemThu;
    public javax.swing.JButton btnThemVay;
    public javax.swing.JButton btnTimKiemChi;
    public javax.swing.JButton btnTimKiemThu;
    public javax.swing.JButton btnXemChiTietGuiTien;
    public javax.swing.JButton btnXemChiTietTraGop;
    public javax.swing.JButton btnXemChiTietVayTien;
    public javax.swing.JButton btnXoaChi;
    public javax.swing.JButton btnXoaThu;
    public javax.swing.JComboBox<String> comboNam;
    public javax.swing.JComboBox<String> comboThang;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    public javax.swing.JLabel jLabel16;
    public javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    public javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    public javax.swing.JScrollPane jScrollPaneThongKe;
    private javax.swing.JScrollPane jScrollPaneVayNo;
    private javax.swing.JSplitPane jSplitPane1;
    public javax.swing.JLabel labelChiTieuThang;
    private javax.swing.JLabel labelLogo;
    public javax.swing.JLabel labelMenuChiTieu;
    public javax.swing.JLabel labelMenuDauTu;
    public javax.swing.JLabel labelMenuTaiKhoan;
    public javax.swing.JLabel labelMenuThongKe;
    public javax.swing.JLabel labelMenuVayNo;
    public javax.swing.JLabel labelReturn2;
    public javax.swing.JLabel labelSoDauTu;
    public javax.swing.JLabel labelSoDuChiTieu;
    public javax.swing.JLabel labelSoDuThongKe;
    private javax.swing.JLabel labelSoDuVayNo;
    public javax.swing.JLabel labelThuNhapThang;
    public javax.swing.JLabel labelTongChoVay;
    public javax.swing.JLabel labelTongNo;
    public javax.swing.JLabel labelTongTaiSan;
    private javax.swing.JLabel labelTotalReturn;
    public javax.swing.JLabel labelTotalReturn2;
    private javax.swing.JLabel labelTotalReturnVND;
    private javax.swing.JLabel labelTotalStock;
    private javax.swing.JLabel labelTotalStockVND;
    public javax.swing.JLabel labelUSD;
    public javax.swing.JLabel labelVND;
    public javax.swing.JPanel pnlCards;
    private javax.swing.JPanel pnlChiTieu;
    private javax.swing.JPanel pnlDauTu;
    private javax.swing.JPanel pnlLeftNav;
    private javax.swing.JPanel pnlTaiKhoan;
    public javax.swing.JPanel pnlThongKe;
    public javax.swing.JPanel pnlThongKeChiTieu;
    public javax.swing.JPanel pnlThongKeDauTu;
    private javax.swing.JPanel pnlThongKeText;
    public javax.swing.JPanel pnlThongKeThuNhap;
    public javax.swing.JPanel pnlThongKeVayNo;
    private javax.swing.JPanel pnlVayNo;
    public javax.swing.JTable tableDanhMuc;
    public javax.swing.JTable tableGuiTien;
    public javax.swing.JTable tableTraGop;
    public javax.swing.JTable tableVayTien;
    public javax.swing.JTable tbChi;
    public javax.swing.JTable tbThu;
    public javax.swing.JTextField textChi;
    public javax.swing.JTextField textThu;
    public javax.swing.JTextField txtLocDauTu;
    public javax.swing.JTextField txtLocTG;
    public javax.swing.JTextField txtLocTK;
    public javax.swing.JTextField txtLocVay;
    private javax.swing.JTextPane txtUsername;
    // End of variables declaration//GEN-END:variables
}
