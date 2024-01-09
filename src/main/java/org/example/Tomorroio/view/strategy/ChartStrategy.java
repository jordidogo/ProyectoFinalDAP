package org.example.Tomorroio.view.strategy;

import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeriesCollection;

public interface ChartStrategy {
    JFreeChart createChart(String chartType, String xAxisLabel, String yAxisLabel, XYSeriesCollection dataset);
}
