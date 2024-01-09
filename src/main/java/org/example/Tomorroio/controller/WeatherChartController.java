package org.example.Tomorroio.controller;

import org.example.Tomorroio.model.WeatherData;
import org.example.Tomorroio.model.factory.*;
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
            HumidityDatasetFactory humidityDatasetFactory,
            WindSpeedDatasetFactory windSpeedDatasetFactory,
            PressureDatasetFactory pressureDatasetFactory,
            CloudCoverDatasetFactory cloudCoverDatasetFactory,
            WindGustDatasetFactory windGustDatasetFactory) {

        this.weatherData = weatherData;
        this.chartView = chartView;
        this.temperatureDatasetFactory = temperatureDatasetFactory;
        this.humidityDatasetFactory = humidityDatasetFactory;
        this.windSpeedDatasetFactory = windSpeedDatasetFactory;
        this.pressureDatasetFactory = pressureDatasetFactory;
    }

        public void updateCharts() {
            XYSeriesCollection temperatureDataset = temperatureDatasetFactory.createDataset();
            XYSeriesCollection humidityDataset = humidityDatasetFactory.createDataset();
            XYSeriesCollection windSpeedDataset = windSpeedDatasetFactory.createDataset();
            XYSeriesCollection pressureDataset = pressureDatasetFactory.createDataset();
            XYSeriesCollection cloudCoverDataset = cloudCoverDatasetFactory.createDataset();
            XYSeriesCollection windGustDataset = windGustDatasetFactory.createDataset();

            chartView.updateChart("Temperature", temperatureDataset);
            chartView.updateChart("Humidity", humidityDataset);
            chartView.updateChart("WindSpeed", windSpeedDataset);
            chartView.updateChart("PressureSurfaceLevel", pressureDataset);
            chartView.updateChart("CloudCover", cloudCoverDataset);
            chartView.updateChart("WindGust", windGustDataset);
        }
    }
