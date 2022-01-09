package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
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

public class Demo {

    public Demo(String symbol, int month) {

        try {

            // 1. Download MSFT quotes from Yahoo Finance and store them as OHLCDataItem
            List<OHLCDataItem> dataItems = new ArrayList<OHLCDataItem>();
            Calendar from = Calendar.getInstance();
            Calendar to = Calendar.getInstance();
            from.add(Calendar.MONTH, -month);
            Stock stock = YahooFinance.get(symbol, from, to, Interval.DAILY);
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
            ((CandlestickRenderer) plot.getRenderer()).setDrawVolume(false);
            // 7. Create and display full-screen JFrame
            JFrame myFrame = new JFrame();
            
            myFrame.setResizable(true);
            myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            myFrame.add(new ChartPanel(chart), BorderLayout.CENTER);
            Toolkit kit = Toolkit.getDefaultToolkit();
            Insets insets = kit.getScreenInsets(myFrame.getGraphicsConfiguration());
            Dimension screen = kit.getScreenSize();
            myFrame.setSize((int) (800), (int) (600));
            myFrame.setLocation((int) (insets.left), (int) (insets.top));
            myFrame.setVisible(true);

        } catch (IOException ex) {
            Logger.getLogger(Demo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String args[]) {
        Demo demo = new Demo("BTC-USD" , 12);

    }
}
