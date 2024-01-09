package org.example.Tomorroio.model.factory;

import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class HumidityDatasetFactory implements DatasetFactory {
    @Override
    public XYSeriesCollection createDataset() {
        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries series = new XYSeries("humidity");

        // Agregar datos a la serie según tus necesidades

        dataset.addSeries(series);
        return dataset;
    }
}