/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import javax.swing.table.DefaultTableModel;
import Controller.LoginController;
import Controller.StockController;
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
    
    UserModel user;
    CardLayout cardLayout;
    TableColumn col;
    StockController stockController;
    ThuChiController1 thuChiController;
    ThuChiController2 thuChiController2;
    VayNoController vayNoController;

    Float Usd;
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
        this.stockController = new StockController(this, user);
        this.vayNoController = new VayNoController(this, user);
        
        this.setTitle("TELEMONEY");
        setUsername();
        soDuKhaDung = stockDAO.getSoDu(user);
        tongTaiSan = stockDAO.getTongTaiSan(user);
        setTiGiaSoDu();
        setLocationRelativeTo(null);
        setSumText();
        System.out.println("user ID " + user.getId());
        this.thuChiController = new ThuChiController1(this, user);
        this.thuChiController2 = new ThuChiController2(this, user);
    }

    private void myInitComponent() throws IOException {
        
    }
    public void ChartTest() {
        XYSeries Goals = new XYSeries("Goals Scored");
        Goals.add(1, 1.0);
        Goals.add(2, 3.0);
        Goals.add(3, 2.0);
        Goals.add(4, 0.0);
        Goals.add(5, 3.0);
        XYDataset xyDataset = new XYSeriesCollection(Goals);
        JFreeChart chart = ChartFactory.createXYLineChart(
            "Goals Scored Over Time", "Fixture Number", "Goals",
            xyDataset, PlotOrientation.VERTICAL, true, true, false);
        ChartPanel cp = new ChartPanel(chart) {

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(320, 240);
            }
        };
        cp.setMouseWheelEnabled(true);
        pnlThongKeChung.add(cp);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
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
            thuChiController.setDataTable();
        } catch (IOException ex) {
            Logger.getLogger(MasterTeleMoneyView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }public void refreshTabVayNo() {
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
        labelRefresh = new javax.swing.JLabel();
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
        btnXoaTK = new javax.swing.JButton();
        btnThemVay = new javax.swing.JButton();
        btnXoaVay = new javax.swing.JButton();
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
        btnXoaTG = new javax.swing.JButton();
        btnThemTG = new javax.swing.JButton();
        btnLocTG = new javax.swing.JButton();
        txtLocTG = new javax.swing.JTextField();
        btnShowTG = new javax.swing.JButton();
        btnShowVay = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPaneThongKe = new javax.swing.JScrollPane();
        pnlThongKe = new javax.swing.JPanel();
        pnlThongKeChung = new javax.swing.JPanel();
        pnlThongKeChiTieu = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        pnlThongKeVayNo = new javax.swing.JPanel();
        pnlThongKeDauTu = new javax.swing.JPanel();
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

        tbThu.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
        jScrollPane5.setViewportView(tbThu);

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

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setText("CHI");

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

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel19.setText("THU");

        javax.swing.GroupLayout pnlChiTieuLayout = new javax.swing.GroupLayout(pnlChiTieu);
        pnlChiTieu.setLayout(pnlChiTieuLayout);
        pnlChiTieuLayout.setHorizontalGroup(
            pnlChiTieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                .addContainerGap(712, Short.MAX_VALUE))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlChiTieuLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(pnlChiTieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 1043, Short.MAX_VALUE)
                    .addComponent(jScrollPane5)))
            .addGroup(pnlChiTieuLayout.createSequentialGroup()
                .addGroup(pnlChiTieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlChiTieuLayout.createSequentialGroup()
                        .addGap(463, 463, 463)
                        .addComponent(jLabel16))
                    .addGroup(pnlChiTieuLayout.createSequentialGroup()
                        .addGap(484, 484, 484)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlChiTieuLayout.createSequentialGroup()
                        .addGap(488, 488, 488)
                        .addComponent(jLabel17)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlChiTieuLayout.setVerticalGroup(
            pnlChiTieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChiTieuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addGap(13, 13, 13)
                .addComponent(labelSoDuChiTieu)
                .addGap(15, 15, 15)
                .addComponent(jLabel19)
                .addGap(18, 18, 18)
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
                .addGap(12, 12, 12)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                .addContainerGap(334, Short.MAX_VALUE))
        );

        pnlCards.add(pnlChiTieu, "cardChiTieu");

        pnlDauTu.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel10.setText("QUẢN LÝ CÁC DANH MỤC ĐẦU TƯ");

        jLabel12.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel12.setText("SỐ DƯ KHẢ DỤNG: ");

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

        labelRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/refresh_30px.png"))); // NOI18N
        labelRefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                labelRefreshMousePressed(evt);
            }
        });

        btnThemStock.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        btnThemStock.setText("Thêm danh mục đầu tư");
        btnThemStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemStockActionPerformed(evt);
            }
        });

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
        btnShowTrans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowTransActionPerformed(evt);
            }
        });

        txtLocDauTu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLocDauTuActionPerformed(evt);
            }
        });

        btnLoc.setText("Lọc");

        javax.swing.GroupLayout pnlDauTuLayout = new javax.swing.GroupLayout(pnlDauTu);
        pnlDauTu.setLayout(pnlDauTuLayout);
        pnlDauTuLayout.setHorizontalGroup(
            pnlDauTuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(pnlDauTuLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(pnlDauTuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDauTuLayout.createSequentialGroup()
                        .addComponent(labelRefresh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 310, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addGap(355, 355, 355))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDauTuLayout.createSequentialGroup()
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
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDauTuLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)))
                        .addGroup(pnlDauTuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtLocDauTu)
                            .addGroup(pnlDauTuLayout.createSequentialGroup()
                                .addComponent(labelVND, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6)))
                        .addGap(22, 22, 22))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDauTuLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(btnThemStock, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnShowTrans, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        );
        pnlDauTuLayout.setVerticalGroup(
            pnlDauTuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDauTuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDauTuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(labelRefresh))
                .addGap(18, 18, 18)
                .addGroup(pnlDauTuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(labelSoDauTu)
                    .addComponent(labelUSD)
                    .addComponent(jLabel4)
                    .addComponent(labelVND)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                .addGroup(pnlDauTuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLocDauTu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLoc))
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
        btnDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangXuatActionPerformed(evt);
            }
        });

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
                .addContainerGap(428, Short.MAX_VALUE))
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
                .addContainerGap(650, Short.MAX_VALUE))
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
        btnThemTK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemTKMouseClicked(evt);
            }
        });

        btnXoaTK.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        btnXoaTK.setText("Xoá");

        btnThemVay.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        btnThemVay.setText("Thêm");

        btnXoaVay.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        btnXoaVay.setText("Xoá");

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel3.setText("VAY TIỀN");

        btnShowTK.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        btnShowTK.setText("Show giao dịch");

        btnLocTK.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        btnLocTK.setText("Lọc");

        btnLocVay.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        btnLocVay.setText("Lọc");

        txtLocTK.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N

        txtLocVay.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N
        txtLocVay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLocVayActionPerformed(evt);
            }
        });

        labelSoDuVayNo.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        labelSoDuVayNo.setText("Số dư khả dụng: ");

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
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

        btnXoaTG.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        btnXoaTG.setText("Xoá");

        btnThemTG.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        btnThemTG.setText("Thêm");

        btnLocTG.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        btnLocTG.setText("Lọc");

        txtLocTG.setFont(new java.awt.Font("Segoe UI Semilight", 0, 11)); // NOI18N

        btnShowTG.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        btnShowTG.setText("Show giao dịch");

        btnShowVay.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        btnShowVay.setText("Show giao dịch");

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel8.setText("GỬI TIỀN");

        jLabel18.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel18.setText("TRẢ GÓP");

        javax.swing.GroupLayout pnlVayNoLayout = new javax.swing.GroupLayout(pnlVayNo);
        pnlVayNo.setLayout(pnlVayNoLayout);
        pnlVayNoLayout.setHorizontalGroup(
            pnlVayNoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVayNoLayout.createSequentialGroup()
                .addGroup(pnlVayNoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlVayNoLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(labelSoDuVayNo, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(134, 134, 134)
                        .addComponent(jLabel8))
                    .addGroup(pnlVayNoLayout.createSequentialGroup()
                        .addGap(461, 461, 461)
                        .addComponent(jLabel18)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlVayNoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlVayNoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlVayNoLayout.createSequentialGroup()
                        .addComponent(btnThemTK, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoaTK, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLocTK, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(txtLocTK, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56))
                    .addGroup(pnlVayNoLayout.createSequentialGroup()
                        .addComponent(btnThemVay, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoaVay, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLocVay, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(txtLocVay, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61))
                    .addGroup(pnlVayNoLayout.createSequentialGroup()
                        .addComponent(btnThemTG, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoaTG, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jScrollPane4)
            .addGroup(pnlVayNoLayout.createSequentialGroup()
                .addGroup(pnlVayNoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlVayNoLayout.createSequentialGroup()
                        .addGap(464, 464, 464)
                        .addComponent(jLabel3))
                    .addGroup(pnlVayNoLayout.createSequentialGroup()
                        .addGap(418, 418, 418)
                        .addComponent(jLabel9)))
                .addGap(0, 489, Short.MAX_VALUE))
            .addComponent(jScrollPane7)
        );
        pnlVayNoLayout.setVerticalGroup(
            pnlVayNoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVayNoLayout.createSequentialGroup()
                .addGroup(pnlVayNoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlVayNoLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(labelSoDuVayNo)
                        .addGap(51, 51, 51))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlVayNoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(pnlVayNoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemTK)
                    .addComponent(btnXoaTK)
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
                    .addComponent(btnXoaVay)
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
                    .addComponent(btnXoaTG)
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

        pnlThongKeChung.setBackground(new java.awt.Color(51, 255, 51));
        pnlThongKeChung.setLayout(new java.awt.BorderLayout());

        pnlThongKeChiTieu.setBackground(new java.awt.Color(255, 102, 102));
        pnlThongKeChiTieu.setLayout(new java.awt.BorderLayout());

        jButton2.setText("jButton2");
        pnlThongKeChiTieu.add(jButton2, java.awt.BorderLayout.PAGE_END);

        jButton3.setText("jButton3");
        pnlThongKeChiTieu.add(jButton3, java.awt.BorderLayout.PAGE_START);

        pnlThongKeDauTu.setBackground(new java.awt.Color(255, 255, 102));

        javax.swing.GroupLayout pnlThongKeLayout = new javax.swing.GroupLayout(pnlThongKe);
        pnlThongKe.setLayout(pnlThongKeLayout);
        pnlThongKeLayout.setHorizontalGroup(
            pnlThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongKeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlThongKeChung, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlThongKeLayout.createSequentialGroup()
                        .addGroup(pnlThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlThongKeDauTu, javax.swing.GroupLayout.PREFERRED_SIZE, 982, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlThongKeVayNo, javax.swing.GroupLayout.PREFERRED_SIZE, 982, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlThongKeChiTieu, javax.swing.GroupLayout.PREFERRED_SIZE, 982, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 9, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlThongKeLayout.setVerticalGroup(
            pnlThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongKeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlThongKeChung, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(pnlThongKeChiTieu, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlThongKeVayNo, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlThongKeDauTu, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(236, Short.MAX_VALUE))
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
        labelMenuVayNo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                labelMenuVayNoMousePressed(evt);
            }
        });

        labelMenuDauTu.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        labelMenuDauTu.setForeground(new java.awt.Color(255, 255, 255));
        labelMenuDauTu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMenuDauTu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/invest_30px.png"))); // NOI18N
        labelMenuDauTu.setText("QUẢN LÝ ĐẦU TƯ");
        labelMenuDauTu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                labelMenuDauTuMousePressed(evt);
            }
        });

        labelMenuThongKe.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        labelMenuThongKe.setForeground(new java.awt.Color(255, 255, 255));
        labelMenuThongKe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMenuThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chart_30px.png"))); // NOI18N
        labelMenuThongKe.setText("THỐNG KÊ CHUNG");
        labelMenuThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                labelMenuThongKeMousePressed(evt);
            }
        });

        labelMenuTaiKhoan.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        labelMenuTaiKhoan.setForeground(new java.awt.Color(255, 255, 255));
        labelMenuTaiKhoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/acc_30px.png"))); // NOI18N
        labelMenuTaiKhoan.setText("TÀI KHOẢN");
        labelMenuTaiKhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                labelMenuTaiKhoanMousePressed(evt);
            }
        });

        labelLogo.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        labelLogo.setForeground(new java.awt.Color(255, 255, 255));
        labelLogo.setText("TELEMONEY");

        labelMenuChiTieu.setBackground(new java.awt.Color(255, 255, 255));
        labelMenuChiTieu.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        labelMenuChiTieu.setForeground(new java.awt.Color(255, 255, 255));
        labelMenuChiTieu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelMenuChiTieu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buying_30px.png"))); // NOI18N
        labelMenuChiTieu.setText("QUẢN LÝ CHI TIÊU");
        labelMenuChiTieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                labelMenuChiTieuMousePressed(evt);
            }
        });

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 485, Short.MAX_VALUE)
                .addComponent(labelMenuTaiKhoan)
                .addGap(43, 43, 43))
        );

        jSplitPane1.setTopComponent(pnlLeftNav);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1200, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 983, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void labelMenuVayNoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelMenuVayNoMousePressed
        // TODO add your handling code here:
        cardLayout.show(pnlCards, "cardVayNo");
    }//GEN-LAST:event_labelMenuVayNoMousePressed

    private void labelMenuDauTuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelMenuDauTuMousePressed
        // TODO add your handling code here:
        cardLayout.show(pnlCards, "cardDauTu");
    }//GEN-LAST:event_labelMenuDauTuMousePressed

    private void labelMenuThongKeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelMenuThongKeMousePressed
        // TODO add your handling code here:
        // cardLayout.show(pnlCards, "cardThongKe");
        cardLayout.show(pnlCards, "cardThongKe");
    }//GEN-LAST:event_labelMenuThongKeMousePressed

    private void labelMenuTaiKhoanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelMenuTaiKhoanMousePressed
        // TODO add your handling code here:
        cardLayout.show(pnlCards, "cardTaiKhoan");
    }//GEN-LAST:event_labelMenuTaiKhoanMousePressed

    private void labelMenuChiTieuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelMenuChiTieuMousePressed
        // TODO add your handling code here:
        cardLayout.show(pnlCards, "cardChiTieu");
    }//GEN-LAST:event_labelMenuChiTieuMousePressed

    private void btnDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangXuatActionPerformed
        // TODO add your handling code here:
        this.dispose();
        LoginController loginController = new LoginController();
    }//GEN-LAST:event_btnDangXuatActionPerformed

    private void labelRefreshMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelRefreshMousePressed
        // TODO add your handling code here:
//        try{
//        stockController.setDataTable();
//        }catch(IOException e){
//            
//        }
    }//GEN-LAST:event_labelRefreshMousePressed

    private void btnThemStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemStockActionPerformed
        try {
            // TODO add your handling code here:
            AddStockView addStock = new AddStockView(this, user);
            addStock.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(MasterTeleMoneyView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnThemStockActionPerformed

    private void btnThemTKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemTKMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemTKMouseClicked

    private void txtLocVayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLocVayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLocVayActionPerformed

    private void btnShowTransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowTransActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnShowTransActionPerformed

    private void txtLocDauTuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLocDauTuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLocDauTuActionPerformed

    public void setTiGiaSoDu() {
        try {
            Stock stock = YahooFinance.get("USDVND=X");
            labelVND.setText(String.valueOf(stock.getQuote().getPrice().floatValue()));
        } catch (IOException ex) {
            labelVND.setText("1 USD = 22835 VND");
            Logger.getLogger(MasterTeleMoneyView.class.getName()).log(Level.SEVERE, null, ex);
        }

        labelSoDauTu.setText(String.valueOf(df.format(soDuKhaDung)) + " VND");
        labelSoDuChiTieu.setText("Số dư khả dựng : " + String.valueOf(df.format(soDuKhaDung)) + " VND");
        labelSoDuVayNo.setText("Số dư khả dựng : " + String.valueOf(df.format(soDuKhaDung)) + " VND");
        stockDAO.updateSoDu((float)soDuKhaDung, user);
    }

    public void setSumText() {
//        double  total = 0, totalReturn = 0;
//        int i = 0;
//        int j = tableDanhMuc.getRowCount();
//        for (i; i < j; i++) {
//
//            double Amount =  tableDanhMuc.getValueAt(i, 5);
//            total= Amount + total;
//            double returnAmount =  tableDanhMuc.getValueAt(i, 6);
//            totalReturn = returnAmount + totalReturn;
//
//        }
        double total = 0, totalReturn = 0;
        int prow = 5;

        System.out.println(tableDanhMuc.getValueAt(0, prow).toString());
        for (int i = 0; i <= tableDanhMuc.getRowCount() - 1; i++) {
            total = total + Double.parseDouble(tableDanhMuc.getValueAt(i, 5).toString());
            totalReturn = totalReturn + Double.parseDouble(tableDanhMuc.getValueAt(i, 6).toString());

        }
        System.out.println(total);
        System.out.println(totalReturn);
        labelTotalStock.setText(String.valueOf(Math.round(total)) + " USD");
        labelTotalReturn.setText(String.valueOf(Math.round(totalReturn)) + " USD");
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

//    public void setTableButton() {
//        System.out.println("Tao nut jtable");
//        //Action muaStock
//        MasterTeleMoneyView thisview = this;
//        System.out.println(thisview.getTitle());
//        Action muaThem = new AbstractAction() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                int opt = JOptionPane.showConfirmDialog(thisview, "Bạn có muốn xoá nhân viên này không", "Delete", JOptionPane.YES_NO_CANCEL_OPTION);
//                if (opt == 0) {
//                }
//                JTable table = (JTable) e.getSource();
//                int modelRow = Integer.valueOf(e.getActionCommand());
//                System.out.println(modelRow);
//                MyStockBuyModel stockBuy = new MyStockBuyModel();
//                stockBuy.setSymbol((String) table.getValueAt(modelRow, 0));
//                stockBuy.setSoLuong((int) table.getValueAt(modelRow, 1));
//                stockBuy.setGiaBanDau((float) table.getValueAt(modelRow, 2));
//                MuaStockView muaStockView = new MuaStockView(thisview, stockBuy);
//                muaStockView.setVisible(true);
//                //stockDAO.delete(stockBuy);
//                //((DefaultTableModel) table.getModel()).removeRow(modelRow);
//
//            }
//        };
//        //Action banStock
//        Action banStock;
//        banStock = new AbstractAction() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                JTable table = (JTable) e.getSource();
//                int modelRow = Integer.valueOf(e.getActionCommand());
//                System.out.println(modelRow);
//                MyStockBuyModel stockBuy = new MyStockBuyModel();
//                stockBuy.setSymbol((String) table.getValueAt(modelRow, 0));
//                stockBuy.setSoLuong((int) table.getValueAt(modelRow, 1));
//                stockBuy.setGiaBanDau((float) table.getValueAt(modelRow, 2));
//                MuaStockView muaStockView = new MuaStockView(thisview, stockBuy);
//            }
//        };
//
//        ButtonColumn btnMua = new ButtonColumn(tableDanhMuc, muaThem, 7);
//
//        btnMua.setMnemonic(KeyEvent.VK_F1);
//
//        btnMua.setToolTipText(
//                "Mua thêm cổ phiếu");
//        ButtonColumn btnBan = new ButtonColumn(tableDanhMuc, banStock, 8, Color.BLUE);
//
//        btnBan.setMnemonic(KeyEvent.VK_F1);
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangXuat;
    private javax.swing.JButton btnLoc;
    public javax.swing.JButton btnLocTG;
    public javax.swing.JButton btnLocTK;
    public javax.swing.JButton btnLocVay;
    public javax.swing.JButton btnShowChi;
    public javax.swing.JButton btnShowTG;
    public javax.swing.JButton btnShowTK;
    public javax.swing.JButton btnShowThu;
    public javax.swing.JButton btnShowTrans;
    public javax.swing.JButton btnShowVay;
    public javax.swing.JButton btnSuaChi;
    public javax.swing.JButton btnSuaThu;
    public javax.swing.JButton btnThemChi;
    private javax.swing.JButton btnThemStock;
    public javax.swing.JButton btnThemTG;
    public javax.swing.JButton btnThemTK;
    public javax.swing.JButton btnThemThu;
    public javax.swing.JButton btnThemVay;
    public javax.swing.JButton btnTimKiemChi;
    public javax.swing.JButton btnTimKiemThu;
    public javax.swing.JButton btnXoaChi;
    public javax.swing.JButton btnXoaTG;
    public javax.swing.JButton btnXoaTK;
    public javax.swing.JButton btnXoaThu;
    public javax.swing.JButton btnXoaVay;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    public javax.swing.JLabel jLabel16;
    public javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    public javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPaneThongKe;
    private javax.swing.JScrollPane jScrollPaneVayNo;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JLabel labelMenuChiTieu;
    private javax.swing.JLabel labelMenuDauTu;
    private javax.swing.JLabel labelMenuTaiKhoan;
    private javax.swing.JLabel labelMenuThongKe;
    private javax.swing.JLabel labelMenuVayNo;
    public javax.swing.JLabel labelRefresh;
    public javax.swing.JLabel labelSoDauTu;
    public javax.swing.JLabel labelSoDuChiTieu;
    private javax.swing.JLabel labelSoDuVayNo;
    private javax.swing.JLabel labelTotalReturn;
    private javax.swing.JLabel labelTotalReturnVND;
    private javax.swing.JLabel labelTotalStock;
    private javax.swing.JLabel labelTotalStockVND;
    public javax.swing.JLabel labelUSD;
    public javax.swing.JLabel labelVND;
    private javax.swing.JPanel pnlCards;
    private javax.swing.JPanel pnlChiTieu;
    private javax.swing.JPanel pnlDauTu;
    private javax.swing.JPanel pnlLeftNav;
    private javax.swing.JPanel pnlTaiKhoan;
    public javax.swing.JPanel pnlThongKe;
    private javax.swing.JPanel pnlThongKeChiTieu;
    public javax.swing.JPanel pnlThongKeChung;
    private javax.swing.JPanel pnlThongKeDauTu;
    private javax.swing.JPanel pnlThongKeVayNo;
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
