package org.example.Tomorroio.controller;


import org.example.Tomorroio.model.WeatherData;
import org.example.Tomorroio.view.WeatherView;

public class WeatherChartController implements WeatherController {
    private WeatherData weatherData;
    private WeatherView chartView;

    public WeatherChartController(
            WeatherData weatherData,
            WeatherView chartView) {

        this.weatherData = weatherData;
        this.chartView = chartView;
    }

    public void updateCharts() {
    }
}
