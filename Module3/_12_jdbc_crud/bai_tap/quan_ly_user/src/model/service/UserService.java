package model.service;

import model.bean.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    void insertUser(User user) throws SQLException;

    User selectUser(int id);

    List<User> selectAllUser();

    boolean deleteUser(int id) throws SQLException;

    boolean updateUser(User user) throws SQLException;

    List<User> selectByCountry(String country) throws SQLException;

    List<User> sortByName();
}
