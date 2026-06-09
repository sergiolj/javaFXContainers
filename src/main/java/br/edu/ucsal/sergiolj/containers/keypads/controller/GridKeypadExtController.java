package br.edu.ucsal.sergiolj.containers.keypads.controller;

import br.edu.ucsal.sergiolj.containers.keypads.model.KeySet;
import br.edu.ucsal.sergiolj.containers.keypads.model.KeyboardLayout;
import br.edu.ucsal.sergiolj.containers.keypads.model.NumericCard;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

import java.util.List;

public class GridKeypadExtController {
    @FXML
    private GridPane grid_pane_ext;

    @FXML
    public void initialize() {
        setupGridKeypad();
    }

    private void setupGridKeypad() {
        grid_pane_ext.setPadding(new Insets(10));

        grid_pane_ext.setHgap(8);
        grid_pane_ext.setVgap(8);

        List<KeySet> keys = KeyboardLayout.getNumericKeypadLabelsExtended();
        for (KeySet key : keys) {
            NumericCard card = new NumericCard(key.label());

            if (key.label().matches("[/*\\-+=C.]")) {
                card.getStyleClass().add("operation-key");
            }else{
                card.getStyleClass().add("numeric-key");
            }

            card.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

            GridPane.setHgrow(card, Priority.ALWAYS);
            GridPane.setVgrow(card, Priority.ALWAYS);

            grid_pane_ext.add(card, key.col(),key.row(),key.colSpan(),key.rowSpan());
        }

    }

}
