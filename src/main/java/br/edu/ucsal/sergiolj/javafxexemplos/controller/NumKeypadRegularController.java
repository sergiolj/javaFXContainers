package br.edu.ucsal.sergiolj.javafxexemplos.controller;

import br.edu.ucsal.sergiolj.javafxexemplos.model.KeyboardLayout;
import br.edu.ucsal.sergiolj.javafxexemplos.model.NumericCard;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.layout.TilePane;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class NumKeypadRegularController implements Initializable{
    //É um container especificamente para lidar com estruturas regulares com espaços iguais como azulejos numa parede.
    @FXML
    private TilePane tilePane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setupKeypad();
    }

    private void setupKeypad() {
        tilePane.setPadding(new Insets(20));
        tilePane.setPrefColumns(4);
        tilePane.setHgap(10);
        tilePane.setVgap(10);

        List<String> labels = KeyboardLayout.getNumericKeypadLabelsSmall();

        for(String label: labels){
            NumericCard card = new NumericCard(label);

            if (label.matches("[/*\\-+=C]")) {
                card.getStyleClass().add("operator-card");
            }

            tilePane.getChildren().add(card);
        }
    }
}
