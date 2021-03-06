package model.repository;

import model.bean.User;

import java.sql.SQLException;
import java.util.List;

public interface UserRepository {

    List<User> selectAllUser();

    boolean deleteUser(int id) throws SQLException;

    boolean updateUser(User user) throws SQLException;

    List<User> searchByCountry(String country) throws SQLException;

    List<User> sortByName();

    User getUserById (int id);

    void inserUserStore(User user) throws SQLException;

    void addUserTransaction(User user, int[] permision);

}
