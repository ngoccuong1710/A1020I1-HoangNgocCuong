package model.repository;

import model.bean.User;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private BaseRepository baseRepository = new BaseRepository();

    private static final String INSERT_USERS_SQL = "INSERT INTO users" + "  (name, email, country) VALUES " + " (?, ?, ?);";
    private static final String SELECT_USER_BY_COUNTRY = "select * from users where country = ?;";
    private static final String SORT_BY_NAME = "select * from users order by `name`;";

    @Override
    public List<User> selectAllUser() {
        List<User> userList = new ArrayList<>();
        try{
            CallableStatement callableStatement = this.baseRepository.getConnection().prepareCall("call show_users();");
            ResultSet resultSet = callableStatement.executeQuery();
            User user = null;
            while (resultSet.next()){
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setCountry(resultSet.getString("country"));

                userList.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userList;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        boolean rowDeleted = false;
        CallableStatement callableStatement = this.baseRepository.getConnection().prepareCall("call delete_users(?)");
        callableStatement.setInt(1, id);
        rowDeleted = callableStatement.executeUpdate() > 0;
        return rowDeleted;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated = false;
        CallableStatement callableStatement = this.baseRepository.getConnection().prepareCall("call update_users(?,?,?,?)");
        callableStatement.setInt(1, user.getId());
        callableStatement.setString(2, user.getName());
        callableStatement.setString(3, user.getEmail());
        callableStatement.setString(4, user.getCountry());
        rowUpdated = callableStatement.executeUpdate() > 0;
        return rowUpdated;
    }

    @Override
    public List<User> searchByCountry(String keyword) throws SQLException {
        List<User> userList = new ArrayList<>();
        try{
            CallableStatement callableStatement = this.baseRepository.getConnection().prepareCall("call search_users(?)");
            callableStatement.setString(1, keyword);
            ResultSet resultSet = callableStatement.executeQuery();

            User user = null;
            while (resultSet.next()){
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setCountry(resultSet.getString("country"));

                userList.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userList;
    }

    public List<User> sortByName() {
        List<User> userList = new ArrayList<>();
        try{
            Statement statement = this.baseRepository.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(SORT_BY_NAME);

            User user = null;
            while (resultSet.next()){
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setCountry(resultSet.getString("country"));

                userList.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userList;
    }

    @Override
    public User getUserById(int id) {
        User user = null;
        try {
            CallableStatement callableStatement = this.baseRepository.getConnection().prepareCall("call get_user_by_id(?)");
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()){
                String name =  resultSet.getString("name");
                String email =  resultSet.getString("email");
                String country =  resultSet.getString("country");
                user = new User(id, name, email, country);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    @Override
    public void inserUserStore(User user) throws SQLException {
        CallableStatement callableStatement = this.baseRepository.getConnection().prepareCall("call insert_user(?,?,?)");
        callableStatement.setString(1, user.getName());
        callableStatement.setString(2, user.getEmail());
        callableStatement.setString(3, user.getCountry());
        callableStatement.executeUpdate();
    }

    @Override
    public void addUserTransaction(User user, int[] permision) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        PreparedStatement pstmtAssignment = null;
        ResultSet rs = null;

        try {

            conn = this.baseRepository.getConnection();
            conn.setAutoCommit(false);
            pstmt = conn.prepareStatement(INSERT_USERS_SQL, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getCountry());
            int rowAffected = pstmt.executeUpdate();
            rs = pstmt.getGeneratedKeys();
            int userId = 0;
            if (rs.next()){
                userId = rs.getInt(1);
            }
            if (rowAffected == 1) {
                String sqlPivot = "INSERT INTO user_permision(user_id,permision_id) " + "VALUES(?,?)";

                pstmtAssignment = conn.prepareStatement(sqlPivot);

                for (int permisionId : permision) {
                    pstmtAssignment.setInt(1, userId);
                    pstmtAssignment.setInt(2, permisionId);
                    pstmtAssignment.executeUpdate();
                }
                conn.commit();

            } else {
                conn.rollback();
            }

        } catch (SQLException ex) {

            try {
                if (conn != null){
                    conn.rollback();

                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            System.out.println(ex.getMessage());

        } finally {

            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (pstmtAssignment != null) pstmtAssignment.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        }
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
