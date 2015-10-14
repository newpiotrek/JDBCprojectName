package com.piotr.dao;

import com.piotr.model.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Piotr on 14/10/2015.
 */
public interface UserDAO {
    void save(User user) throws SQLException;
    User findUserByID(Long id);
    void deleteUserByID(Long id);
    List<User> findAllUsers();
}
