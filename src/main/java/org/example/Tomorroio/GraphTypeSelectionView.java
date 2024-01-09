package org.example.Tomorroio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GraphTypeSelectionView extends JFrame {
    private JComboBox<String> graphTypeComboBox;
    private JComboBox<String> cityComboBox;
    private JButton okButton;

    public GraphTypeSelectionView() {
        super("Select Graph Type and City");

        graphTypeComboBox = new JComboBox<>(new String[]{"Lineas", "Barras"});
        cityComboBox = new JComboBox<>(new String[]{"Tokyo", "New York", "London", "Barcelona", "Berlin", "Tenerife", "Sydney", "Buenos Aires"}); // Añadir ciudades

        okButton = new JButton("OK");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }
}

