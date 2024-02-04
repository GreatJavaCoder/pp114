package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static jm.task.core.jdbc.util.Util.getConnection;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    @Override
    public void createUsersTable() throws SQLException {
        String sql = " CREATE TABLE IF NOT EXISTS users ( " +
                " id BIGINT AUTO_INCREMENT, " +
                " name VARCHAR(255), " +
                " lastName VARCHAR(255),  " +
                " age TINYINT," +
                " PRIMARY KEY(id) ); ";
        try (Statement statement = getConnection().createStatement()) {
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void dropUsersTable() throws SQLException {
        String sql = " DROP TABLE IF EXISTS users; ";
        try (Statement statement = getConnection().createStatement()) {
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) throws SQLException {
        String sql = " INSERT INTO users (name, lastName, age) values (?, ?, ?); ";
        try (PreparedStatement prep_st = getConnection().prepareStatement(sql)) {
            prep_st.setString(1, name);
            prep_st.setString(2, lastName);
            prep_st.setByte(3, age);
            prep_st.executeUpdate();
            System.out.println("User с именем " + name + " добавлен в базу");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeUserById(long id) {
        String sql = " DELETE FROM training_db.users WHERE id = ?; ";
        try (PreparedStatement prep_st = getConnection().prepareStatement(sql)) {
            prep_st.setLong(1, id);
            prep_st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        String sql = " SELECT * FROM users; ";
        try (PreparedStatement statement = getConnection().prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public void cleanUsersTable() {
        String sql = " DELETE FROM training_db.users WHERE id > 0; ";
        try (Statement statement = getConnection().createStatement()) {
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}