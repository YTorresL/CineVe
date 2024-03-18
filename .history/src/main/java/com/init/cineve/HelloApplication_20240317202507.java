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

    public static String encode(byte [] data){
        return Base64.getEncoder().encodeToString(data);
    }

    public static void DeleteMovies() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("deleteMovies.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 680, 450);
        Stage stage = new Stage();
        stage.setTitle("CineVe! Eliminar Película");
        stage.setScene(scene);
        stage.show();
    }
    public static void EditMovies() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("editMovies.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 680, 450);
        Stage stage = new Stage();
        stage.setTitle("CineVe! Modificar Película");
        stage.setScene(scene);
        stage.show();
    }
    public static void AddMovies() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("addMovies.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 680, 450);
        Stage stage = new Stage();
        stage.setTitle("CineVe! Agregar Película");
        stage.setScene(scene);
        stage.show();
    }

    public static void DeleteClient() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("deleteClients.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 680, 450);
        Stage stage = new Stage();
        stage.setTitle("CineVe! Eliminar Cliente");
        stage.setScene(scene);
        stage.show();
    }
    public static void EditClient() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("editClients.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 680, 450);
        Stage stage = new Stage();
        stage.setTitle("CineVe! Modificar Cliente");
        stage.setScene(scene);
        stage.show();
    }
    public static void AddClient() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("addClients.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 680, 450);
        Stage stage = new Stage();
        stage.setTitle("CineVe! Agregar Cliente");
        stage.setScene(scene);
        stage.show();
    }
    public static void HistoryClient() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("historyClient.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 680, 450);
        Stage stage = new Stage();
        stage.setTitle("CineVe! Historial Cliente");
        stage.setScene(scene);
        stage.show();
    }

public static void DeleteEmployees() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("deleteEmployees.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 680, 450);
        Stage stage = new Stage();
        stage.setTitle("CineVe! Eliminar Empleado");
        stage.setScene(scene);
        stage.show();
    }
    public static void EditEmployees() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("editEmployees.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 680, 450);
        Stage stage = new Stage();
        stage.setTitle("CineVe! Modificar Empleado");
        stage.setScene(scene);
        stage.show();
    }
    public static void AddEmployees() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("addEmployees.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 680, 450);
        Stage stage = new Stage();
        stage.setTitle("CineVe! Agregar Empleado");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {

        launch();

    }
}
