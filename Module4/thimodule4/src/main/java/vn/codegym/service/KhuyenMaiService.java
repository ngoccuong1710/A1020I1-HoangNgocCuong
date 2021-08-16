package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.KhuyenMai;

public interface KhuyenMaiService {
    Page<KhuyenMai> findAll(Pageable pageable);

    KhuyenMai findById(Integer ma);

    void save(KhuyenMai khuyenMai);

    void delete(KhuyenMai khuyenMai);

    Page<KhuyenMai> findAllByMucGiamGiaContaining(String mucGiamGia, Pageable pageable);
}
