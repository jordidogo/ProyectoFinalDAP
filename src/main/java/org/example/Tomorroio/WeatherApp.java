package org.example.Tomorroio;


import org.example.Tomorroio.controller.WeatherChartController;
import org.example.Tomorroio.model.WeatherData;
import org.example.Tomorroio.model.factory.*;
import org.example.Tomorroio.view.WeatherChartView;
import org.example.Tomorroio.view.strategy.BarChartStrategy;
import org.example.Tomorroio.view.strategy.ChartStrategy;
import org.example.Tomorroio.view.strategy.LineChartStrategy;

import javax.swing.*;

public class WeatherApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GraphTypeSelectionView selectionView = new GraphTypeSelectionView();
            selectionView.addOkButtonListener(e -> {
                String selectedType = selectionView.getSelectedGraphType();
                String selectedCity = selectionView.getSelectedCity();
                ChartStrategy strategy = "Lineas".equals(selectedType) ? new LineChartStrategy() : new BarChartStrategy();

                // Crear una nueva instancia de WeatherData para cada selección
                WeatherData weatherData = new WeatherData();
                weatherData.setLocation(selectedCity);

                // Crear y mostrar la vista del gráfico para la ciudad seleccionada
                WeatherChartView chartView = new WeatherChartView("Weather Chart - " + selectedCity, strategy, weatherData);
                WeatherChartController chartController = new WeatherChartController(
                        weatherData, chartView,
                        new TemperatureDatasetFactory(), new HumidityDatasetFactory(),
                        new WindSpeedDatasetFactory(), new PressureDatasetFactory(), new CloudCoverDatasetFactory(), new WindGustDatasetFactory()
                );

                chartController.updateCharts();
                chartView.setVisible(true);
            });

            selectionView.setVisible(true);
        });
    }
}