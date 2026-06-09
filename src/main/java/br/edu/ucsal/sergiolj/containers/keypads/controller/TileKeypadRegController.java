package br.edu.ucsal.sergiolj.containers.keypads.controller;

import br.edu.ucsal.sergiolj.containers.keypads.model.KeyboardLayout;
import br.edu.ucsal.sergiolj.containers.keypads.model.NumericCard;
import javafx.fxml.FXML;
import javafx.geometry.Insets;

import javafx.scene.layout.TilePane;

import java.util.List;

public class TileKeypadRegController {
    @FXML
    private TilePane tile_pane_reg;

    @FXML
    public void initialize() {
        setupKeypad();
    }

    private void setupKeypad() {
        tile_pane_reg.setPrefColumns(4);

        tile_pane_reg.setPadding(new Insets(10));

        tile_pane_reg.setHgap(8);
        tile_pane_reg.setVgap(8);

        tile_pane_reg.setPrefTileWidth(90.0);
        tile_pane_reg.setPrefTileHeight(90.0);

        List<String> labels = KeyboardLayout.getNumericKeypadLabelsSmall();

        for(String label: labels){
            NumericCard card = new NumericCard(label);

            if (label.matches("[/*\\-+=C.]")) {
                card.getStyleClass().add("operation-key");
            }else{
                card.getStyleClass().add("numeric-key");
            }

            card.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            tile_pane_reg.getChildren().add(card);
        }
    }
}
