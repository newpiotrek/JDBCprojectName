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

     /*   String queryCreateUserTable = "Create Table IF not EXISTS User(id int not null, first_name varchar(20), last_name varchar (50), primary key(id))";
        PreparedStatement preparedStatementCreateUserTable = connection.prepareStatement(queryCreateUserTable);
        preparedStatementCreateUserTable.executeUpdate();

        String queryCreateOrganizationTable = "Create Table IF not EXISTS Organization(org_id int not null, department varchar(20), profession varchar (50)," +
                " id int not null, primary key(org_id), FOREIGN KEY (id) REFERENCES User(id))";
        PreparedStatement preparedStatementCreateOrganizationTable = connection.prepareStatement(queryCreateOrganizationTable);
        preparedStatementCreateOrganizationTable.executeUpdate();
*/
        /*String queryCreateCharityTable = "Create Table IF not EXISTS Charity(charity_id int not null, charity_name varchar(20), charity_position varchar (50)," +
                " id int not null, primary key(charity_id), FOREIGN KEY (id) REFERENCES User(id))";
        PreparedStatement preparedStatementCreateCharityTable = connection.prepareStatement(queryCreateCharityTable);
        preparedStatementCreateCharityTable.executeUpdate();*/


    }
    public void disconnect() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    public PreparedStatement prepareStatement(String sql) throws SQLException {
        return connection.prepareStatement(sql);
    }
}
