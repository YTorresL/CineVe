module com.init.cineve {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.init.cineve to javafx.fxml;
    exports com.init.cineve;
}