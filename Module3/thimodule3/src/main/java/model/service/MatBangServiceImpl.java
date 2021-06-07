package model.service;

import model.bean.MatBang;
import model.repository.MatBangRepository;
import model.repository.MatBangRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class MatBangServiceImpl implements MatBangService{
    private MatBangRepository matBangRepository = new MatBangRepositoryImpl();

    @Override
    public List<MatBang> selectAllMatBang() throws SQLException {
        return matBangRepository.selectAllMatBang();
    }

    @Override
    public void createMatBang(MatBang matBang) throws SQLException {
        matBangRepository.createMatBang(matBang);
    }

    @Override
    public boolean deleteMatBang(int id) throws SQLException {
        return matBangRepository.deleteMatBang(id);
    }

}
