package org.example.Tomorroio.view.strategy;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeriesCollection;

public class LineChartStrategy implements ChartStrategy {
    @Override
    public JFreeChart createChart(String chartType, String xAxisLabel, String yAxisLabel, XYSeriesCollection dataset) {
        return ChartFactory.createTimeSeriesChart(
                chartType,
                xAxisLabel,
                yAxisLabel,
                dataset,
                false,
                true,
                false
        );
    }
}
