package com.sam.db.shard.read.write.split.sam_demo_sharding;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {

    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/order_db?allowPublicKeyRetrieval=true&useSSL=false";
        String user = "user";
        String password = "1234";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connection successful!");
        } catch (Exception e) {
            e.printStackTrace();
        }

        url = "jdbc:mysql://localhost:3307/order_db?allowPublicKeyRetrieval=true&useSSL=false";
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connection successful!");
        } catch (Exception e) {
            e.printStackTrace();
        }

        url = "jdbc:mysql://localhost:3308/order_db?allowPublicKeyRetrieval=true&useSSL=false";
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connection successful!");
        } catch (Exception e) {
            e.printStackTrace();
        }

        url = "jdbc:mysql://localhost:3316/order_db?allowPublicKeyRetrieval=true&useSSL=false";
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connection successful!");
        } catch (Exception e) {
            e.printStackTrace();
        }

        url = "jdbc:mysql://localhost:3317/order_db?allowPublicKeyRetrieval=true&useSSL=false";
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connection successful!");
        } catch (Exception e) {
            e.printStackTrace();
        }

        url = "jdbc:mysql://localhost:3318/order_db?allowPublicKeyRetrieval=true&useSSL=false";
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connection successful!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
