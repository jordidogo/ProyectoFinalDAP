package org.example.Tomorroio.view;


import org.example.Tomorroio.model.WeatherData;

import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;

public class WeatherChartView extends JFrame implements WeatherView {
    private WeatherData weatherData;


    public WeatherChartView(String title, WeatherData weatherData) {
        super(title);
        this.weatherData = weatherData;
    }

    public void updateChart(String chartType, XYSeriesCollection newDataset) {
    }
}
