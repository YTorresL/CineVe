package com.init.cineve;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javax.crypto.SecretKey;
import java.io.IOException;

import static com.init.cineve.HelloApplication.employee;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private TextField user;
    @FXML
    private PasswordField password;

    @FXML
    protected void OnClickLogin() throws Exception {
        String encodedUser = HelloApplication.encode(user.getText().getBytes());
        String encodedPassword = HelloApplication.encode(password.getText().getBytes());

        boolean Logged = employee.Login(encodedUser, encodedPassword);
        if (Logged) {
            welcomeText.setText("¡Bienvenido!, " + employee.Name);
            // to home
            HelloApplication.Home();
            //close login
            Scene scene = welcomeText.getScene();
            scene.getWindow().hide();
        } else {
            welcomeText.setText("Usuario o contraseña incorrectos");
        }
    }
}
