package com.example.usersapi.dao;

import com.example.usersapi.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    private final JdbcTemplate jdbcTemplate;

    public UserDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> findAllUsers() throws SQLException {
        String sql = "SELECT id, name, email FROM users ORDER BY id";
        return jdbcTemplate.query(sql, (resultSet, rowNumber) ->
                new User(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email")
                )
        );
    }
}
