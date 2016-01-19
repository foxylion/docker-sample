package com.todoapp;

import com.mongodb.*;

import static spark.Spark.setIpAddress;
import static spark.Spark.setPort;
import static spark.SparkBase.staticFileLocation;

/**
 * Created by shekhargulati on 09/06/14.
 */
public class Bootstrap {

    public static void main(String[] args) throws Exception {
        setIpAddress("0.0.0.0");
        setPort(8080);
        while(true) {
            try {
                new TodoResource(new TodoService(mongo()));
                break;
            } catch(Exception e) {
                Thread.sleep(1000);
            }
        }
    }

    private static DB mongo() throws Exception {
        String host = System.getenv("MONGODB_HOST");
        int port = 27017;
        String dbname = System.getenv("MONGODB_NAME");
        String username = System.getenv("MONGODB_USERNAME");
        String password = System.getenv("MONGODB_PASSWORD");
        MongoClientOptions mongoClientOptions = MongoClientOptions.builder().connectionsPerHost(20).build();
        MongoClient mongoClient = new MongoClient(new ServerAddress(host, port), mongoClientOptions);
        mongoClient.setWriteConcern(WriteConcern.SAFE);
        DB db = mongoClient.getDB(dbname);
        if(username.isEmpty()) {
            return db;
        }
        if (db.authenticate(username, password.toCharArray())) {
            return db;
        } else {
            throw new RuntimeException("Not able to authenticate with MongoDB");
        }
    }
}
