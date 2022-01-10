/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.StockDAO;
import Model.MyStockBuyModel;
import View.ShowStockChart;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.SegmentedTimeline;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.CandlestickRenderer;
import org.jfree.data.xy.DefaultOHLCDataset;
import org.jfree.data.xy.OHLCDataItem;
import org.jfree.data.xy.OHLCDataset;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes.Interval;

/**
 *
 * @author dat26
 */
public class ShowStockChartController {

    ShowStockChart showView;
    StockDAO stockDAO;
    ArrayList<MyStockBuyModel> stockList = new ArrayList<>();

    public ShowStockChartController(ShowStockChart showView) {
        this.showView = showView;

        stockDAO = new StockDAO();
        setChart(showView.symbol, showView.month);
        setData();
        setEventStock();

    }

    public void setData() {
        stockList = stockDAO.getAllStockSymbol();

        for (int i = 0; i < stockList.size(); i++) {
//            stock = YahooFinance.get(stockList.get(i).getSymbol());
//            long giaTriHienTai = (long) ((Math.round(stock.getQuote().getPrice().floatValue() * stockList.get(i).getSoLuong() * 100.0)) / 100.0);
            showView.comboStockList.addItem(stockList.get(i).getSymbol());

        }

    }

    private void setChart(String symbol, int month) {
        showView.pnlChart.removeAll();
        try {
            // 1. Download MSFT quotes from Yahoo Finance and store them as OHLCDataItem
            List<OHLCDataItem> dataItems = new ArrayList<OHLCDataItem>();
            Calendar from = Calendar.getInstance();
            Calendar to = Calendar.getInstance();
            from.add(Calendar.MONTH, -month);
            Stock stock = YahooFinance.get(symbol, from, to, Interval.DAILY);
            stock.print();
            System.out.println(stock.getHistory(from, to, Interval.WEEKLY).size());
            List<HistoricalQuote> quoteList = stock.getHistory(from, to, Interval.DAILY);
            try {

                for (int i = 0; i < quoteList.size(); i++) {
                    Date date = quoteList.get(i).getDate().getTime();
                    double open = quoteList.get(i).getOpen().doubleValue();
                    double high = quoteList.get(i).getHigh().doubleValue();
                    double low = quoteList.get(i).getLow().doubleValue();
                    double close = quoteList.get(i).getClose().doubleValue();
                    double volume = quoteList.get(i).getVolume().doubleValue();
                    double adjClose = quoteList.get(i).getAdjClose().doubleValue();
// adjust data:
                    open = open * adjClose / close;
                    high = high * adjClose / close;
                    low = low * adjClose / close;

                    OHLCDataItem item = new OHLCDataItem(date, open, high, low, adjClose, volume);
                    dataItems.add(item);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            Collections.reverse(dataItems); // Data from Yahoo is from newest to oldest. Reverse so it is oldest to newest.
            //Convert the list into an array
            OHLCDataItem[] data = dataItems.toArray(new OHLCDataItem[dataItems.size()]);
            OHLCDataset dataset = new DefaultOHLCDataset(symbol, data);
            // 2. Create chart
            JFreeChart chart = ChartFactory.createCandlestickChart(symbol, "Thời gian", "Giá (USD)", dataset, false);
            // 3. Set chart background
            chart.setBackgroundPaint(Color.white);
            // 4. Set a few custom plot features
            XYPlot plot = (XYPlot) chart.getPlot();
            plot.setBackgroundPaint(Color.WHITE); // light yellow = new Color(0xffffe0)
            plot.setDomainGridlinesVisible(true);
            plot.setDomainGridlinePaint(Color.lightGray);
            plot.setRangeGridlinePaint(Color.lightGray);
            ((NumberAxis) plot.getRangeAxis()).setAutoRangeIncludesZero(false);
            // 5. Skip week-ends on the date axis
            ((DateAxis) plot.getDomainAxis()).setTimeline(SegmentedTimeline.newMondayThroughFridayTimeline());
            // 6. No volume drawn
            ((CandlestickRenderer) plot.getRenderer()).setDrawVolume(true);
            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setBackground(Color.lightGray);
            showView.pnlChart.add(chartPanel, java.awt.BorderLayout.WEST);
            
//add your elements
            showView.pnlChart.revalidate();
            showView.pnlChart.repaint();
        } catch (IOException ex) {
            Logger.getLogger(ShowStockChartController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setEventStock() {
        System.out.println("Tao event");

        showView.comboStockList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                setChart(showView.comboStockList.getSelectedItem().toString(), Integer.parseInt(showView.comboThang.getSelectedItem().toString()));

            }
        });
        showView.comboThang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setChart(showView.comboStockList.getSelectedItem().toString(), Integer.parseInt(showView.comboThang.getSelectedItem().toString()));

            }
        });

    }
}
