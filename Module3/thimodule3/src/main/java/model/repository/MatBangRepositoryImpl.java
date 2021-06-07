package model.repository;

import model.bean.MatBang;
import model.repository.base.BaseRepository;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MatBangRepositoryImpl implements MatBangRepository{
    private BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<MatBang> selectAllMatBang() throws SQLException {
        List<MatBang> matBangList = new ArrayList<>();
        CallableStatement callableStatement = this.baseRepository.getConnection().prepareCall("call list_mat_bang();");
        ResultSet resultSet = callableStatement.executeQuery();
        MatBang matBang = null;
        while (resultSet.next()){
            matBang = new MatBang();
            matBang.setNo(resultSet.getInt("no"));
            matBang.setMaMatBang(resultSet.getString("ma"));
            matBang.setDienTich(resultSet.getDouble("dien_tich"));
            matBang.setTrangThai(resultSet.getInt("trang_thai"));
            matBang.setTang(resultSet.getInt("tang"));
            matBang.setLoaiVanPhong(resultSet.getInt("loai_van_phong"));
            matBang.setMoTa(resultSet.getString("mo_ta"));
            matBang.setGia(resultSet.getDouble("gia"));
            matBang.setNgayChoThue(resultSet.getString("ngay_bat_dau"));
            matBang.setNgayKetThuc(resultSet.getString("ngay_ket_thuc"));

            matBangList.add(matBang);

        }
        return matBangList;
    }

    @Override
    public void createMatBang(MatBang matBang) throws SQLException {
        CallableStatement callableStatement = this.baseRepository.getConnection().prepareCall("call them_mat_bang(?, ?, ?, ?, ?, ?, ?, ?, ?);");
        callableStatement.setString(1, matBang.getMaMatBang());
        callableStatement.setDouble(2, matBang.getDienTich());
        callableStatement.setInt(3, matBang.getTrangThai());
        callableStatement.setInt(4, matBang.getTang());
        callableStatement.setInt(5, matBang.getLoaiVanPhong());
        callableStatement.setString(6, matBang.getMoTa());
        callableStatement.setDouble(7, matBang.getGia());
        callableStatement.setString(8, matBang.getNgayChoThue());
        callableStatement.setString(9, matBang.getNgayKetThuc());
        callableStatement.executeUpdate();
    }

    @Override
    public boolean deleteMatBang(int id) throws SQLException {
        boolean rowDeleted = false;
        CallableStatement callableStatement = this.baseRepository.getConnection().prepareCall("call xoa_mat_bang(?);");
        callableStatement.setInt(1, id);
        rowDeleted = callableStatement.executeUpdate() > 0;
        return rowDeleted;
    }

}
