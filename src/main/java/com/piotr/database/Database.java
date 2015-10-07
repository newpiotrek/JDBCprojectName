package com.piotr.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Piotr on 07/10/2015.
 */
public class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/piotrek_schema";
    private static final String USER = "root";
    private static final String PASSWORD = "karolina1";

    private Connection connection;


    public void connect() throws SQLException {
        connection = DriverManager.getConnection(URL,USER,PASSWORD);
        String sqlQuery = "Create Table IF not EXISTS User(id int not null, first_name varchar(20), last_name varchar (50), primary key(id))";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.executeUpdate();
        String sqlQuery1 = "Insert into User(id, first_name, last_name) values (?, ? ,?)";
        PreparedStatement preparedStatement1 = connection.prepareStatement(sqlQuery1);
        preparedStatement1.setInt(1,2);
        preparedStatement1.setString(2,"Piotrus");
        preparedStatement1.setString(3,"Piorkowski");
        preparedStatement1.executeUpdate();
        // improve id primary key, czy nth istnieje, nie wkladac go ale go dodac nowy rekord albo update starego rekordu
        // utworzyc tabele, ktore zaimplementuja relacje jeden do wielu, wiele do jednego
        // sciagnac Tomcat version 7
        // zrobic formularz w html (input fileds + submit)

        // clean code, treemap, skasowac Comparable(compareTo) i zobaczyc komunikaty, jak zmienisz w HashaMap'ie ze String(klucz w mapie) na Word i zobacz jak dziala metoda HashCode
    }
    public void disconnect() throws SQLException {
        connection.close();
    }
}
