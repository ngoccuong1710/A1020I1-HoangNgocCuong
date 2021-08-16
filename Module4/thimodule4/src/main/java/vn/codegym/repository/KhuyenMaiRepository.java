package vn.codegym.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.KhuyenMai;

public interface KhuyenMaiRepository extends JpaRepository<KhuyenMai, Integer> {
    Page<KhuyenMai> findAllByMucGiamGiaContaining(String mucGiamGia, Pageable pageable);
}
