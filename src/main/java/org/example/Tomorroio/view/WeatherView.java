package org.example.Tomorroio.view;

import org.jfree.data.xy.XYSeriesCollection;

public interface WeatherView {
    void updateChart(String chartType, XYSeriesCollection dataset);
}

