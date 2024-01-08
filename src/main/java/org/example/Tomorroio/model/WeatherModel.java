package org.example.Tomorroio.model;

import org.jfree.data.xy.XYSeries;

public interface WeatherModel {
    void setLocation(String city);
    XYSeries fetchDataSeries(String dataType);
}