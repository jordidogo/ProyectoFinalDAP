package org.example.Tomorroio;


import org.example.Tomorroio.controller.WeatherChartController;
import org.example.Tomorroio.model.WeatherData;
import org.example.Tomorroio.view.WeatherChartView;

import javax.swing.*;

public class WeatherApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
                // Crear una nueva instancia de WeatherData para cada selección
                WeatherData weatherData = new WeatherData();

                // Crear y mostrar la vista del gráfico para la ciudad seleccionada
                WeatherChartView chartView = new WeatherChartView("Weather Chart - ", weatherData);
                WeatherChartController chartController = new WeatherChartController(
                        weatherData, chartView
                );

                chartController.updateCharts();
                chartView.setVisible(true);
            });
    }
}
