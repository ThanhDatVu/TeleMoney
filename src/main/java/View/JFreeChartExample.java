package View;
import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;


public class JFreeChartExample extends JFrame {

  private static final long serialVersionUID = 1L;

  public JFreeChartExample(String applicationTitle, String chartTitle) {
        super(applicationTitle);
        //Creates a sample dataset
        DefaultPieDataset dataSet = new DefaultPieDataset();
        dataSet.setValue("BITCOIN 29%", 29);
        dataSet.setValue("APPLE 36%", 36);
        dataSet.setValue("Tesla 25%", 25);
        dataSet.setValue("DOGECOIN 15%",15 );
       
        // based on the dataset we create the chart
        JFreeChart pieChart = ChartFactory.createPieChart3D(chartTitle, dataSet, true, true, false);
        PiePlot plot = (PiePlot) pieChart.getPlot();
        plot.setStartAngle(290);
        plot.setForegroundAlpha(0.5f);

        // Adding chart into a chart panel
        ChartPanel chartPanel = new ChartPanel(pieChart);
       
        // settind default size
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
       
        // add to contentPane
        setContentPane(chartPanel);
    }
    public static void main(String[] args) {
      JFreeChartExample chart = new JFreeChartExample("Thống kê", "Chia các danh mục đầu tư");
        chart.pack();
        chart.setVisible(true);
    }
}