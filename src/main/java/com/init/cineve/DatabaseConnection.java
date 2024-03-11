package com.init.cineve;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import static com.init.cineve.HelloApplication.alertError;

public class DatabaseConnection {

    public MongoClient mongoClient;
    public  MongoDatabase DB = null;
    public DatabaseConnection() {
        try {
            String connectionString = "mongodb+srv://admin:password@cluster0.p2diax9.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
            // Construct a ServerApi instance using the ServerApi.builder() method
            ServerApi serverApi = ServerApi.builder()
                    .version(ServerApiVersion.V1)
                    .build();
            MongoClientSettings settings = MongoClientSettings.builder()
                    .applyConnectionString(new ConnectionString(connectionString))
                    .serverApi(serverApi)
                    .build();
            // Create a new client and connect to the server
            this.mongoClient = MongoClients.create(settings);
            MongoDatabase database = mongoClient.getDatabase("cineve");
            try {
                database.runCommand(new Document("ping", 1));
                System.out.println("Pinged your deployment. You successfully connected to MongoDB!");
            } catch (MongoException e) {
                e.printStackTrace();
            }
            DB = mongoClient.getDatabase("cineve");
        }catch (Exception e){
            alertError("Error de conexion", "No se pudo conectar","No se pudo conectar con la base de datos el programa se cerrara");

        }
    }
}
