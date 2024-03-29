package org.example.Tomorroio.model;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;
import org.jfree.data.xy.XYSeries;

import java.time.Instant;


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
        try {
            HttpResponse<JsonNode> response = Unirest.get("https://api.tomorrow.io/v4/weather/forecast")
                    .queryString("location", latitude + "," + longitude)
                    .queryString("apikey", apiKey)
                    .header("accept", "application/json")
                    .asJson();

            JSONObject jsonResponse = new JSONObject(response.getBody().toString());

            if (jsonResponse.has("timelines")) {
                JSONArray minutelyTimelines = jsonResponse.getJSONObject("timelines").getJSONArray("minutely");

                for (int i = 0; i < minutelyTimelines.length(); i++) {
                    JSONObject minuteData = minutelyTimelines.getJSONObject(i);
                    String time = minuteData.getString("time");
                    JSONObject values = minuteData.getJSONObject("values");
                    double dataValue = 0.0;
                    switch (dataType.toLowerCase()) {
                        case "temperature":
                            dataValue = values.getDouble("temperature");
                            break;
                        case "humidity":
                            dataValue = values.getDouble("humidity");
                            break;
                        case "windspeed":
                            dataValue = values.getDouble("windSpeed");
                            break;
                        case "windgust":
                            dataValue = values.getDouble("windGust");
                            break;
                        case "pressuresurfacelevel":
                            dataValue = values.getDouble("pressureSurfaceLevel");
                            break;
                        case "cloudcover":
                            dataValue = values.getDouble("cloudCover");
                            break;
                    }
                    Instant instant = Instant.parse(time);
                    series.add(instant.toEpochMilli(), dataValue);
                }
                return series;
            } else {
                System.err.println("Error: Estructura JSON no válida");
            }
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return null;
    }

}
