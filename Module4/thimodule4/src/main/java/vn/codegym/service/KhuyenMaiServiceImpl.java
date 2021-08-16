package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.model.KhuyenMai;
import vn.codegym.repository.KhuyenMaiRepository;

@Service
public class KhuyenMaiServiceImpl implements KhuyenMaiService{
    @Autowired
    private KhuyenMaiRepository khuyenMaiRepository;

    @Override
    public Page<KhuyenMai> findAll(Pageable pageable) {
        return khuyenMaiRepository.findAll(pageable);
    }

    @Override
    public KhuyenMai findById(Integer ma) {
        return khuyenMaiRepository.findById(ma).orElse(null);
    }

    @Override
    public void save(KhuyenMai khuyenMai) {
        khuyenMaiRepository.save(khuyenMai);
    }

    @Override
    public void delete(KhuyenMai khuyenMai) {
        khuyenMaiRepository.delete(khuyenMai);
    }

    @Override
    public Page<KhuyenMai> findAllByMucGiamGiaContaining(String mucGiamGia, Pageable pageable) {
        return khuyenMaiRepository.findAllByMucGiamGiaContaining(mucGiamGia, pageable);
    }
}
