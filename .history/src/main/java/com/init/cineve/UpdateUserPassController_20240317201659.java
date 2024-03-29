package com.init.cineve;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.bson.Document;

import java.security.Timestamp;

import static com.init.cineve.HelloApplication.conn;
import static com.init.cineve.HelloApplication.employee;


public class UpdateUserPassController {
    @FXML
    public TextField User;
    @FXML
    private PasswordField Password;
    public DatabaseConnection condb;
    private static final int MAX_CAMBIOS = 4; // Número máximo de cambios a mantener

    @FXML
    private void OnUpdate() throws Exception {
        this.condb = conn;
        String name = employee.Name;

        String encodedUser = HelloApplication.encode(User.getText().getBytes());
        String encodedPassword = HelloApplication.encode(Password.getText().getBytes());
        MongoCollection<Document> collection = conn.DB.getCollection("history_user_pass");
        MongoCollection<Document> Logincollection = conn.DB.getCollection("employees");
        // Verificar si hay más de MAX_CAMBIOS registros para este usuario
        long numCambios = collection.countDocuments(new Document("name_employee", name));
        if (numCambios >= MAX_CAMBIOS) {
            // Eliminar el registro más antiguo
            // Ordenar por fecha y eliminar el primero
            collection.deleteOne(new Document("name_employee", name));
            InsertOneResult updateDoc = collection.insertOne(
                    new Document("name_employee", name)
                            .append("newPass", encodedPassword)
                            .append("newUser", encodedUser)
                            .append("date", System.currentTimeMillis())
            );

            UpdateResult updateLogin =  Logincollection.updateOne(
                    new Document("name", name),
                    new Document("$set", new Document("user", encodedUser).append("password", encodedPassword))
            );
            HelloApplication.Home();
            User.getScene().getWindow().hide();


        } else {
            InsertOneResult updateDoc = collection.insertOne(
                new Document("name_employee", name)
                        .append("newPass", encodedPassword)
                        .append("newUser", encodedUser)
                        .append("date", System.currentTimeMillis())
        );

            UpdateResult updateLogin =  Logincollection.updateOne(
                    new Document("name", name),
                    new Document("$set", new Document("user", encodedUser).append("password", encodedPassword))
            );}
        HelloApplication.Home();
        User.getScene().getWindow().hide();
        MongoCollection<Document> collection = conn.DB.getCollection("history_user_pass");
        InsertOneResult updateDoc = collection.insertOne(
                new Document("name_employee", name)
                        .append("newPass", Password.getText())
                        .append("newUser", User.getText())
                        .append("date", System.currentTimeMillis())
        );
        MongoCollection<Document> Logincollection = conn.DB.getCollection("employees");
        UpdateResult updateLogin =  Logincollection.updateOne(
                new Document("name", name),
                new Document("$set", new Document("user", User.getText()).append("password", Password.getText()))
        );
    }


}
