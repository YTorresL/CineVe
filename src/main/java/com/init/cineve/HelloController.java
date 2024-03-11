package com.init.cineve;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import static com.init.cineve.HelloApplication.employee;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private TextField user;
    @FXML
    private PasswordField password;

    private static final long TIME_TEMPORIZADOR = 2000;

    private long LAST_UPDATE = System.currentTimeMillis();


    @FXML
    protected void OnClickLogin() throws Exception {
        String encodedUser = HelloApplication.encode(user.getText().getBytes());
        String encodedPassword = HelloApplication.encode(password.getText().getBytes());

        boolean Logged = employee.Login(encodedUser, encodedPassword);
        if (Logged) {
            welcomeText.setText("¡Bienvenido/a! " + employee.Name);
            // to home
            if (System.currentTimeMillis() - LAST_UPDATE >= TIME_TEMPORIZADOR) {
                HelloApplication.updatePasswordEmployee();
            } else {
                HelloApplication.Home();
                //close login
                Scene scene = welcomeText.getScene();
                scene.getWindow().hide();
            }
        } else {
            welcomeText.setText("Usuario o contraseña incorrectos");
        }
    }
}
