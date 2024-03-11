package com.init.cineve;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.util.Base64;

public class HelloApplication extends Application {

    public static DatabaseConnection conn = null;
    public static Employees employee = null;

    @Override
    public void start(Stage stage) throws IOException {
        conn = new DatabaseConnection();
        employee = new Employees(conn);
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 680, 450);
        stage.setTitle("CineVe! Administración");
        stage.setScene(scene);
        stage.show();
    }

    public static void Home() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 680, 450);
        Stage stage = new Stage();
        stage.setTitle("CineVe! Home");
        stage.setScene(scene);
        stage.show();
    }

    public static void alertError(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public static void  updatePasswordEmployee() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("updatePasswordEmployees.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 580, 350);
        Stage stage = new Stage();
        stage.setTitle("CineVe! Actualización de usuario y contraseña");
        stage.setScene(scene);
        stage.show();
    }

    public static String encode(byte [] data){
        return Base64.getEncoder().encodeToString(data);
    }

    public static void main(String[] args) {

        launch();

    }
}
