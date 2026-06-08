module br.edu.ucsal.sergiolj.javafxexemplos {
    requires javafx.controls;
    requires javafx.fxml;


    opens br.edu.ucsal.sergiolj.javafxexemplos to javafx.fxml;
    exports br.edu.ucsal.sergiolj.javafxexemplos;
    exports br.edu.ucsal.sergiolj.javafxexemplos.controller;
    opens br.edu.ucsal.sergiolj.javafxexemplos.controller to javafx.fxml;
    exports br.edu.ucsal.sergiolj.javafxexemplos.navigation;
    opens br.edu.ucsal.sergiolj.javafxexemplos.navigation to javafx.fxml;
    exports br.edu.ucsal.sergiolj.javafxexemplos.model;
    opens br.edu.ucsal.sergiolj.javafxexemplos.model to javafx.fxml;

}