package org.example.Tomorroio.view;


import org.example.Tomorroio.model.WeatherData;

import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;

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

    private void createAndShowUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        // Utilizar las coordenadas establecidas en WeatherData
        addChartPanel("Temperature", "Time", "Temperature (°C)", convertToXYSeriesCollection(weatherData.fetchDataSeries("temperature")));
        addChartPanel("Humidity", "Time", "Humidity (%)", convertToXYSeriesCollection(weatherData.fetchDataSeries("humidity"))); // Changed from PrecipitationProbability to Humidity
        addChartPanel("WindSpeed", "Time", "Wind Speed (m/s)", convertToXYSeriesCollection(weatherData.fetchDataSeries("windSpeed")));
        addChartPanel("PressureSurfaceLevel", "Time", "Pressure (hPa)", convertToXYSeriesCollection(weatherData.fetchDataSeries("pressureSurfaceLevel")));
        addChartPanel("CloudCover", "Time", "Cloud Cover", convertToXYSeriesCollection(weatherData.fetchDataSeries("cloudCover")));
        addChartPanel("WindGust", "Time", "Wind Gust (m/s)", convertToXYSeriesCollection(weatherData.fetchDataSeries("windGust"))); // Added new chart panel
        pack();
        setLocationRelativeTo(null);
    }

    public void updateChart(String chartType, XYSeriesCollection newDataset) {
    }
}
