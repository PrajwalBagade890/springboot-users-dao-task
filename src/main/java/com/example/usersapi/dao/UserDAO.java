package com.example.usersapi.dao;

import com.example.usersapi.model.User;
import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    List<User> findAllUsers() throws SQLException;
}
