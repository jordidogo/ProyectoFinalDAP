package org.example.Tomorroio.model;

import org.jfree.data.xy.XYSeries;


public class WeatherData implements WeatherModel{
    private String apiKey = "caqZdWtMCbxjvLTlS3knSN7spqmj2LhD";
    private double latitude;
    private double longitude;
    @Override
    public void setLocation(String city) {
        switch (city) {
            case "Tokyo":
                setCoordinates(35.6821936, 139.762221);
                break;
            case "New York":
                setCoordinates(40.71289737728429, -74.006034165344);
                break;
            case "London":
                setCoordinates(51.5074456, -0.1277653);
                break;
            case "Barcelona":
                setCoordinates(41.3828939, 2.1774322);
                break;
            case "Berlin":
                setCoordinates(52.5170365, 13.3888599);
                break;
            case "Tenerife":
                setCoordinates(28.487675835494287, -16.314964377974878);
                break;
            case "Sydney":
                setCoordinates(-33.8698439,151.2082848);
                break;
            case "Buenos Aires":
                setCoordinates(-34.6037157, -58.381642);
                break;
            // Agregar más ciudades si es necesario
        }
    }

    private void setCoordinates(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
    @Override
    public XYSeries fetchDataSeries(String dataType) {
        return fetchDataSeries(dataType, this.latitude, this.longitude);
    }

    public XYSeries fetchDataSeries(String dataType, double latitude, double longitude) {
        XYSeries series = new XYSeries(dataType);
        return null;
    }
}
