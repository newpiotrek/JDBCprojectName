package com.piotr.dao.impl;

import com.piotr.dao.UserDAO;
import com.piotr.database.Database;
import com.piotr.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Piotr on 14/10/2015.
 */
public class UserDAOImpl implements UserDAO{

    private Database database;

    public UserDAOImpl() {
        database = new Database();
    }



    public void save(User user) throws SQLException {
        database.connect();

        int primaryKey = 9;
        String checkIfPrimaryKeyExistsQuery = "select first_name, last_name from user where id = ?";
        PreparedStatement psSelectPrimaryKey = connection.prepareStatement(checkIfPrimaryKeyExistsQuery);
        psSelectPrimaryKey.setInt(1, primaryKey);
        ResultSet resultSelectQuery = psSelectPrimaryKey.executeQuery();
        System.out.println(resultSelectQuery);

        //SELECT COUNT(*) FROM user WHERE id=?
        //poprawic na update + uzyc Count(*)

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

        database.disconnect();

    }

    public User findUserByID(Long id) {
        return null;
    }

    public void deleteUserByID(Long id) {

    }

    public List<User> findAllUsers() {
        return null;
    }


}
