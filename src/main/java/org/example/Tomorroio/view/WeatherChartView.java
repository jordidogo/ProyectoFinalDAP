package org.example.Tomorroio.view;


import org.example.Tomorroio.model.WeatherData;

import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;

public class WeatherChartView extends JFrame implements WeatherView {
    private WeatherData weatherData;
    private ChartStrategy chartStrategy;

    private XYSeriesCollection temperatureDataset = new XYSeriesCollection();
    private XYSeriesCollection humidityDataset = new XYSeriesCollection();
    private XYSeriesCollection windSpeedDataset = new XYSeriesCollection();
    private XYSeriesCollection pressureDataset = new XYSeriesCollection();
    private XYSeriesCollection cloudCoverDataset = new XYSeriesCollection();
    private XYSeriesCollection windGustDataset = new XYSeriesCollection(); // Added new dataset


    public WeatherChartView(String title, ChartStrategy chartStrategy, WeatherData weatherData) {
        super(title);
        this.chartStrategy = chartStrategy;
        this.weatherData = weatherData;
        createAndShowUI();
    }

    public void updateChart(String chartType, XYSeriesCollection newDataset) {
    }
}
