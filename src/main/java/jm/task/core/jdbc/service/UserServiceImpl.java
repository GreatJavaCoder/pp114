package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDaoJDBCImpl udji = new UserDaoJDBCImpl();

    @Override
    public void createUsersTable() throws SQLException {
        udji.createUsersTable();
    }

    @Override
    public void dropUsersTable() throws SQLException {
        udji.dropUsersTable();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) throws SQLException {
        udji.saveUser(name, lastName, age);
    }

    @Override
    public void removeUserById(long id) {
        udji.removeUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return udji.getAllUsers();
    }

    @Override
    public void cleanUsersTable() {
        udji.cleanUsersTable();
    }
}