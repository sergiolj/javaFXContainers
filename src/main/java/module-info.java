module br.edu.ucsal.sergiolj.containers {
    requires javafx.controls;
    requires javafx.fxml;
    requires atlantafx.base;

    exports br.edu.ucsal.sergiolj.containers.keypads;
    opens br.edu.ucsal.sergiolj.containers.keypads to javafx.fxml;
    exports br.edu.ucsal.sergiolj.containers.keypads.navigation;
    opens br.edu.ucsal.sergiolj.containers.keypads.navigation to javafx.fxml;
    exports br.edu.ucsal.sergiolj.containers.keypads.model;
    opens br.edu.ucsal.sergiolj.containers.keypads.model to javafx.fxml;
    exports br.edu.ucsal.sergiolj.containers.keypads.controller;
    opens br.edu.ucsal.sergiolj.containers.keypads.controller to javafx.fxml;

    exports br.edu.ucsal.sergiolj.containers.chat;
    opens br.edu.ucsal.sergiolj.containers.chat to javafx.fxml;
    exports br.edu.ucsal.sergiolj.containers.chat.controller;
    opens br.edu.ucsal.sergiolj.containers.chat.controller to javafx.fxml;
}