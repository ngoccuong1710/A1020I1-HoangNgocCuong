package model.service;

import model.bean.MatBang;

import java.sql.SQLException;
import java.util.List;

public interface MatBangService {
    List<MatBang> selectAllMatBang() throws SQLException;

    void createMatBang(MatBang matBang) throws SQLException;

    boolean deleteMatBang(int id) throws SQLException;


}
