package org.example.Tomorroio.view.strategy;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class BarChartStrategy implements ChartStrategy {
    @Override
    public JFreeChart createChart(String chartType, String xAxisLabel, String yAxisLabel, XYSeriesCollection dataset) {
        DefaultCategoryDataset categoryDataset = new DefaultCategoryDataset();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        // Intervalo de 10 minutos en milisegundos
        long intervalMillis = 10 * 60 * 1000;
        long lastTimestamp = -intervalMillis; // Iniciar antes para incluir el primer punto

        for (int i = 0; i < dataset.getSeriesCount(); i++) {
            XYSeries series = dataset.getSeries(i);
            for (int j = 0; j < series.getItemCount(); j++) {
                long currentTimestamp = series.getX(j).longValue();
                if (currentTimestamp >= lastTimestamp + intervalMillis) {
                    Number yValue = series.getY(j);
                    Comparable rowKey = series.getKey();
                    String formattedTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(currentTimestamp), ZoneId.systemDefault()).format(formatter);
                    categoryDataset.addValue(yValue, rowKey, formattedTime);
                    lastTimestamp = currentTimestamp; // Actualizar último timestamp
                }
            }
        }

        JFreeChart chart = ChartFactory.createBarChart(
                chartType,
                xAxisLabel,
                yAxisLabel,
                categoryDataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        CategoryAxis domainAxis = chart.getCategoryPlot().getDomainAxis();
        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);

        return chart;
    }
}