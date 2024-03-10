module com.init.cineve {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.mongodb.driver.sync.client;
    requires org.mongodb.driver.core;
    requires org.mongodb.bson;


    opens com.init.cineve to javafx.fxml;
    exports com.init.cineve;
}
