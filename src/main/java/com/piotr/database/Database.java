package com.piotr.database;

import java.sql.*;

/**
 * Created by Piotr on 07/10/2015.
 */
public class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/piotrek_schema";
    private static final String USER = "root";
    private static final String PASSWORD = "karolina1";

    private Connection connection;


    public void connect() throws SQLException {
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
        String createTableQuery = "Create Table IF not EXISTS User(id int not null, first_name varchar(20), last_name varchar (50), primary key(id))";
        PreparedStatement psCreateTable = connection.prepareStatement(createTableQuery);
        psCreateTable.executeUpdate();

        int primaryKey = 9;



        String checkIfPrimaryKeyExistsQuery = "select first_name, last_name from user where id = ?";
        PreparedStatement psSelectPrimaryKey = connection.prepareStatement(checkIfPrimaryKeyExistsQuery);
        psSelectPrimaryKey.setInt(1, primaryKey);
        ResultSet resultSelectQuery = psSelectPrimaryKey.executeQuery();
        System.out.println(resultSelectQuery);
        /*if (!resultSelectQuery.next()){
            System.out.println("Hurray");
        }*/
      /*  while (resultSelectQuery.next()) {

            String first_name = resultSelectQuery.getString("first_name");
            String last_name = resultSelectQuery.getString("last_name");

            System.out.println("first_name : " + first_name);
            System.out.println("username : " + last_name);

        }*/
        if (resultSelectQuery.next()) {
           /* String updateRecordQuery = "UPDATE user SET first_name=?, last_name=? WHERE id=?";
            PreparedStatement psUpdateRecord = connection.prepareStatement(updateRecordQuery);
            psUpdateRecord.setString(1, "Jan1");
            psUpdateRecord.setString(2, "Kowalski");
            psUpdateRecord.setInt(3, primaryKey);
            psUpdateRecord.executeUpdate();*/

            String deleteRecordQuery = "Delete from user where id = ?";
            PreparedStatement psDeleteRecord = connection.prepareStatement(deleteRecordQuery);
            psDeleteRecord.setInt(1, primaryKey);
            psDeleteRecord.execute();

            if (true) {
                String insertRecordQuery = "Insert into User(id, first_name, last_name) values (?, ? ,?)";
                PreparedStatement psInsertRecord = connection.prepareStatement(insertRecordQuery);
                psInsertRecord.setInt(1, primaryKey);
                psInsertRecord.setString(2, "J12");
                psInsertRecord.setString(3, "Smith3231");
                psInsertRecord.execute();
            }

        } else {
            String insertRecordQuery = "Insert into User(id, first_name, last_name) values (?, ? ,?)";
            PreparedStatement psInsertRecord = connection.prepareStatement(insertRecordQuery);
            psInsertRecord.setInt(1, primaryKey);
            psInsertRecord.setString(2, "John");
            psInsertRecord.setString(3, "Smith");
            psInsertRecord.executeUpdate();
        }

        // improve id primary key, czy nth istnieje, nie wkladac go ale go dodac nowy rekord albo update starego rekordu
        // utworzyc tabele, ktore zaimplementuja relacje jeden do wielu, wiele do jednego
        // spróbuj zrobi? jeszcze sortowanie po kluczach u?ywaj?c TreeMap (mo?e Ci by? potrzebne skorzystanie z Comparable :) ). Druga kwestia, któr? mo?esz jeszcze zrobi? to zamieni? String na Word jako klucz (w osobnej klasie).
        // clean code, treemap, skasowac Comparable(compareTo) i zobaczyc komunikaty, jak zmienisz w HashaMap'ie ze String(klucz w mapie) na Word i zobacz jak dziala metoda HashCode
        // sciagnac Tomcat version 7
        // zrobic formularz w html (input fileds + submit)
    }
    public void disconnect() throws SQLException {
        connection.close();
    }
}
