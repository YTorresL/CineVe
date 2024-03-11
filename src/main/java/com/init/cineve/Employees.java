package com.init.cineve;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class Employees {
    public String Name;
    public String User;
    private String Password;
    public DatabaseConnection conn;


    public Employees(DatabaseConnection conn) {

        this.conn = conn;
}
public boolean Login(String user, String password) {
        this.User = user;
        this.Password = password;
    MongoCollection<Document> collection = conn.DB.getCollection("employees");
    Document LoginDoc = collection.find( new Document("user", User).append("password", Password)).first();

    if (LoginDoc == null) {
        System.out.println("No exist User");
        return false;
    } else {
        System.out.println(LoginDoc.toJson());
        this.Name = LoginDoc.getString("name");
        this.User = LoginDoc.getString("user");
        return true;
    }
}
}
