/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.StockDAO;
import Model.ChiTableModel;
import Model.GuiTienTableModel;
import Model.MyStockBuyModel;
import Model.MyStockBuyTableModel;
import Model.ThuTableModel;
import Model.UserModel;
import Model.VayTienTableModel;
import View.ThemChiView;
import View.MasterTeleMoneyView;
import View.MuaStockView;
import View.SuaChiView;
import View.SuaThuView;
import View.ThemThuView;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JTable;
import lib.ButtonColumn;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public class ThuChiController {

    private MasterTeleMoneyView master;
    private UserModel acc;
    private StockDAO stockDAO = null;
    private Integer tableSelect;
    Stock stock;
    BigDecimal usd;
    ThuTableModel chiTableModel = new ThuTableModel();
    ChiTableModel thuTableModel = new ChiTableModel();
    Object[][] chiTableData,thuTableData ;
    public ThuChiController(MasterTeleMoneyView master, UserModel acc) {
        this.master = master;
        this.acc = acc;
        setEventThuChi();
        master.setVisible(true);
        this.master.tbChi.setModel(chiTableModel);
        this.master.tbThu.setModel(thuTableModel);
        //setDataTable();
    }

    public void enable() {
        setEventThuChi();

        //setTableButton();
    }

    public void setDataTable() throws IOException {
        MyStockBuyTableModel tableModel = (MyStockBuyTableModel) master.tableDanhMuc.getModel();
        ArrayList<MyStockBuyModel> myStockList = new ArrayList<>();
        myStockList = stockDAO.getAll();
        tableModel.setRowCount(0);
        for (int i = 0; i < myStockList.size(); i++) {
            stock = YahooFinance.get(myStockList.get(i).getSymbol());
            long giaTriHienTai = (long) ((Math.round(stock.getQuote().getPrice().floatValue() * myStockList.get(i).getSoLuong() * 100.0)) / 100.0);
            tableModel.addRow(new Object[]{
                myStockList.get(i).getSymbol(),
                myStockList.get(i).getSoLuong(),
                myStockList.get(i).getGiaBanDau(),
                (Math.round(stock.getQuote().getPrice().floatValue() * 100.0)) / 100.0,
                myStockList.get(i).get24hchange(),
                (Math.round(stock.getQuote().getPrice().floatValue() * myStockList.get(i).getSoLuong() * 100.0)) / 100.0,
                ((giaTriHienTai - (myStockList.get(i).getSoLuong() * myStockList.get(i).getGiaBanDau())) > -1)
                && ((giaTriHienTai - (myStockList.get(i).getSoLuong() * myStockList.get(i).getGiaBanDau())) < 1)
                ? 0 : ((giaTriHienTai - (myStockList.get(i).getSoLuong() * myStockList.get(i).getGiaBanDau()))),
                "Mua thêm",
                "Bán"

            });

        }

    }
//    public void setButton(){
//    Action delete = new AbstractAction() {
//        public void actionPerformed(ActionEvent e) {
//            JTable table = (JTable) e.getSource();
//            int modelRow = Integer.valueOf(e.getActionCommand());
//            ((DefaultTableModel) table.getModel()).removeRow(modelRow);
//        }
//    };
//    ButtonColumn buttonColumn = new ButtonColumn(nhanvienView, delete, 2);
//
//    buttonColumn.setMnemonic (KeyEvent.VK_D);
//    
//    
//    }

    public void setEventThuChi() {
        System.out.println("Tao event tab thuchi");

        master.btnThemChi.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ThemChiView themChiView = new ThemChiView(master, acc);
                themChiView.setVisible(true);
            }
        }
        );
        master.btnThemThu.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ThemThuView themThuView = new ThemThuView(master, acc);
                themThuView.setVisible(true);
            }
        }
        );
        master.btnSuaThu.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SuaThuView suaThuView = new SuaThuView();
                suaThuView.setVisible(true);
            }
        }
        );
        master.btnSuaChi.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SuaChiView suaChiView = new SuaChiView();
                suaChiView.setVisible(true);
            }
        }
        );

        master.tbChi.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                int keyCode = e.getKeyCode();
                switch (keyCode) {
                    case KeyEvent.VK_UP:
                        tableSelect = master.tbChi.getSelectedRow();
                        if (tableSelect != -1) {
                            master.btnXoaChi.setEnabled(true);
                            master.btnSuaChi.setEnabled(true);

                        }
                        break;
                    case KeyEvent.VK_DOWN:
                        tableSelect = master.tbChi.getSelectedRow();
                        if (tableSelect != -1) {
                            master.btnXoaChi.setEnabled(true);
                            master.btnSuaChi.setEnabled(true);

                        }
                        break;

                }
            }
        });
        master.tbThu.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                int keyCode = e.getKeyCode();
                switch (keyCode) {
                    case KeyEvent.VK_UP:
                        tableSelect = master.tbThu.getSelectedRow();
                        if (tableSelect != -1) {
                            master.btnXoaThu.setEnabled(true);
                            master.btnSuaThu.setEnabled(true);

                        }
                        break;
                    case KeyEvent.VK_DOWN:
                        tableSelect = master.tbThu.getSelectedRow();
                        if (tableSelect != -1) {
                            master.btnXoaThu.setEnabled(true);
                            master.btnSuaThu.setEnabled(true);

                        }
                        break;

                }
            }
        });

        master.tbChi.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tableSelect = master.tbChi.getSelectedRow();
                System.out.println("dang chon dong chi " + tableSelect);
                if (tableSelect != -1) {
                    master.btnXoaChi.setEnabled(true);
                    master.btnSuaChi.setEnabled(true);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        master.tbThu.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tableSelect = master.tbThu.getSelectedRow();
                System.out.println("dang chon dong thu " + tableSelect);
                if (tableSelect != -1) {
                    master.btnXoaThu.setEnabled(true);
                    master.btnSuaThu.setEnabled(true);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        System.out.println("Tao xong event tab thuchi");
    }

}
