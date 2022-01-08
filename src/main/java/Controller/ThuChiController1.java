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
import Model.ChiTableModel;
import Model.GuiTienModel;
import Model.GuiTienTableModel;
import Model.MyStockBuyModel;
import Model.MyStockBuyTableModel;
import Model.ThuModel;
import Model.ThuTableModel;
import Model.UserModel;
import Model.VayTienTableModel;
import View.ThemChiView;
import View.MasterTeleMoneyView;
import View.MuaStockView;
import View.ShowChiView;
import View.ShowThuView;
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
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import lib.ButtonColumn;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public class ThuChiController1 {

    DecimalFormat df = new DecimalFormat("0");
    private MasterTeleMoneyView master;
    private UserModel acc;
    private StockDAO stockDAO;
    private ThuDAO thuDAO;
    private ChiDAO chiDAO;
    private ChiModel chiModel;
    private ThuModel thuModel;
    private Integer tableSelect;
    Stock stock;
    BigDecimal usd;
    ThuTableModel chiTableModel = new ThuTableModel();
    ChiTableModel thuTableModel = new ChiTableModel();
    Vector chiTableData, thuTableData;

    public ThuChiController1(MasterTeleMoneyView master, UserModel acc) throws IOException {
        this.master = master;
        this.acc = acc;
        master.setVisible(true);
        stockDAO = new StockDAO();
        thuDAO = new ThuDAO();
        chiDAO = new ChiDAO();
        this.master.tbChi.setModel(chiTableModel);
        this.master.tbThu.setModel(thuTableModel);
        System.out.println("chuan bị set table");
        setEventThuChi();
        setDataTable();
        System.out.println("set xong table");

    }

    public void enable() {
        //setEventThuChi();

        //setTableButton();
    }

    public void setDataTable() throws IOException {
        System.out.println("1");
        //ChiTableModel chiTableModel1 = (ChiTableModel) master.tbChi.getModel();
        System.out.println("1.5");
        ArrayList<ChiModel> chiModels = new ArrayList<>();
        System.out.println("2");
        chiModels = chiDAO.getAll(acc);

        System.out.println("CHi size " + chiModels.size());
        chiTableModel.setRowCount(0);
        for (int i = 0; i < chiModels.size(); i++) {
            chiTableModel.addRow(new Object[]{//"ID","Tên khoản chi", "Danh mục", "Số tiền","Ngày"
                chiModels.get(i).getIdChi(),
                chiModels.get(i).getNameChi(),
                chiModels.get(i).getMucChi(),
                df.format(chiModels.get(i).getAmountChi()),
                chiModels.get(i).getTimeChi()

            });
        }

        //chiTableData = (Vector) (chiTableModel).getDataVector().clone();
        //ThuTableModel thuTableModel1 = (ThuTableModel) master.tbThu.getModel();
        ArrayList<ThuModel> thuModels = new ArrayList<>();
        thuModels = thuDAO.getAll(acc);
        System.out.println("Thu size " + thuModels.size());
        thuTableModel.setRowCount(0);
        for (int j = 0; j < thuModels.size(); j++) {
            thuTableModel.addRow(new Object[]{//"ID","Tên khoản chi", "Danh mục", "Số tiền","Ngày"
                thuModels.get(j).getIdThu(),
                thuModels.get(j).getNameThu(),
                thuModels.get(j).getMucThu(),
                df.format(thuModels.get(j).getAmountThu()),
                thuModels.get(j).getTimeThu()

            });
        }

        //thuTableData = (Vector) (thuTableModel).getDataVector().clone();
        System.out.println("aloaloaloalaoaloalao");
    }
//    
//    
//    
//    

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
        master.btnXoaThu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int xoaThuID = (int) master.tbThu.getValueAt(tableSelect, 0);
                int check = JOptionPane.showConfirmDialog(null, "Bạn muốn xóa khoản thu này ?", "Confirm", JOptionPane.YES_NO_OPTION);
                if (check == 0) {
                    thuDAO.delete(xoaThuID);
                    master.refreshTabThuChi();
                }
            }
        });
        master.btnXoaChi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int xoaChiID = (int) master.tbChi.getValueAt(tableSelect, 0);
                int check = JOptionPane.showConfirmDialog(null, "Bạn muốn xóa khoản chi này ?", "Confirm", JOptionPane.YES_NO_OPTION);
                if (check == 0) {
                    chiDAO.delete(xoaChiID);
                    master.refreshTabThuChi();
                }
            }
        });
        master.btnSuaChi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int suaChiID = (int) master.tbChi.getValueAt(tableSelect, 0);
                chiModel = chiDAO.getByID(suaChiID);
                SuaChiView suaChiView = new SuaChiView(master, chiModel, acc);
                suaChiView.setVisible(true);
            }
        });
        master.btnSuaThu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int suaThuID = (int) master.tbThu.getValueAt(tableSelect, 0);
                thuModel = thuDAO.getByID(suaThuID);
                SuaThuView suaThuView = new SuaThuView(master, thuModel, acc);
                suaThuView.setVisible(true);
            }
        });

        master.btnShowChi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ShowChiView suaChiView = new ShowChiView(master, acc);
                suaChiView.setVisible(true);
            }
        });
        master.btnShowThu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ShowThuView suaThuView = new ShowThuView(master, acc);
                suaThuView.setVisible(true);
            }
        });

        System.out.println("Tao xong event tab thuchi");
    }

    public void searchTableContents(String searchString, JTable table, Vector OGVector) {
        DefaultTableModel currtableModel = (DefaultTableModel) table.getModel();
        //To empty the table before search
        currtableModel.setRowCount(0);
        //To search for contents from original table content
        for (Object rows : OGVector) {
            Vector rowVector = (Vector) rows;
            for (Object column : rowVector) {
                if (column.toString().contains(searchString)) {
                    //content found so adding to table
                    currtableModel.addRow(rowVector);
                    break;
                }
            }

        }
    }

}
