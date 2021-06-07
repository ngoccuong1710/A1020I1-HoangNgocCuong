package model.repository;

import model.bean.MatBang;

import java.sql.SQLException;
import java.util.List;

public interface MatBangRepository {
    List<MatBang> selectAllMatBang() throws SQLException;

    void createMatBang(MatBang matBang) throws SQLException;

    boolean deleteMatBang(int id) throws SQLException;


}
