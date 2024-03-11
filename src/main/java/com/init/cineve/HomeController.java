package com.init.cineve;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class HomeController {
    @FXML
    private TextField id;
    @FXML
    private TextField discount;

    @FXML
    private void OnCheckInTicket() {
    }
    @FXML
    private void OnExit() {
    }
    @FXML
    private void ViewdeleteMovie() throws IOException {
        HelloApplication.DeleteMovies();
    }
    @FXML
    private void ViewEditMovie() throws IOException {
        HelloApplication.EditMovies();
    }
    @FXML
    private void ViewAddMovie() throws IOException {
        HelloApplication.AddMovies();
    }
    @FXML
    private void ViewdeleteClient() throws IOException {
        HelloApplication.DeleteClient();
    }
    @FXML
    private void ViewEditClient() throws IOException {
        HelloApplication.EditClient();
    }
    @FXML
    private void ViewAddClient() throws IOException {
        HelloApplication.AddClient();
    }
    @FXML
    private void ViewHistoryClient() throws IOException {
        HelloApplication.HistoryClient();
    }
    @FXML
    private void ViewdeleteAdmin() throws IOException {
        HelloApplication.DeleteEmployees();
    }
    @FXML
    private void ViewEditAdmin() throws IOException {
        HelloApplication.EditEmployees();
    }
    @FXML
    private void ViewAddAdmin() throws IOException {
        HelloApplication.AddEmployees();
    }

}
