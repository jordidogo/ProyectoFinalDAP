package org.example.Tomorroio.controller;

import org.example.Tomorroio.model.WeatherData;
import org.example.Tomorroio.view.WeatherView;
import org.jfree.data.xy.XYSeriesCollection;

public class WeatherChartController implements WeatherController {
    private WeatherData weatherData;
    private WeatherView chartView;
    private TemperatureDatasetFactory temperatureDatasetFactory;
    private HumidityDatasetFactory humidityDatasetFactory;
    private WindSpeedDatasetFactory windSpeedDatasetFactory;
    private PressureDatasetFactory pressureDatasetFactory;
    private CloudCoverDatasetFactory cloudCoverDatasetFactory;
    private WindGustDatasetFactory windGustDatasetFactory;

    public WeatherChartController(
            WeatherData weatherData,
            WeatherView chartView,
            TemperatureDatasetFactory temperatureDatasetFactory,
            HumidityDatasetFactory humidityDatasetFactory) {

        this.weatherData = weatherData;
        this.chartView = chartView;
        this.temperatureDatasetFactory = temperatureDatasetFactory;
        this.humidityDatasetFactory = humidityDatasetFactory;
    }

        public void updateCharts() {
            XYSeriesCollection temperatureDataset = temperatureDatasetFactory.createDataset();
            XYSeriesCollection humidityDataset = humidityDatasetFactory.createDataset();


            chartView.updateChart("Temperature", temperatureDataset);
            chartView.updateChart("Humidity", humidityDataset);

        }
    }
