package com.piotr.main;

import com.piotr.database.Database;

import java.sql.SQLException;

/**
 * Created by Piotr on 07/10/2015.
 */
public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        try {
            database.connect();
            database.disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
