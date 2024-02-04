package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // реализуйте алгоритм здесь
        Class.forName("com.mysql.cj.jdbc.Driver");
        UserDaoJDBCImpl udji = new UserDaoJDBCImpl();
        udji.createUsersTable();
        udji.saveUser("JEZHEG", "HISCHNICK", (byte)(12));
        udji.saveUser("PONCHICK", "UBERKATZER", (byte)(6));
        udji.saveUser("ALEX", "SPIDER", (byte)(23));
        udji.saveUser("TORSCHER", "EAGLEOWL", (byte)(40));
        udji.cleanUsersTable();
        udji.dropUsersTable();
        //UserDaoHibernateImpl udhi = new UserDaoHibernateImpl();
        //udhi.createUsersTable();
        //udhi.saveUser("JEZHEG", "HISCHNICK", (byte) (12));
        //udhi.saveUser("PONCHICK", "UBERKATZER", (byte) (6));
        //udhi.saveUser("ALEX", "SPIDER", (byte) (23));
        //udhi.saveUser("TORSCHER", "EAGLEOWL", (byte) (40));

        //List<User> o_list = udhi.getAllUsers();
        //for (User o_user : o_list) {
        //    System.out.println(o_user.toString());
        //}

        //udhi.cleanUsersTable();
        //udhi.dropUsersTable();
    }
}
