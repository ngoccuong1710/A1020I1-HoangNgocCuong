package vn.codegym.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class KhuyenMai{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ma;

    @NotBlank(message = "Tiêu đề không được để trống")
    private String tieuDe;

    @NotEmpty(message = "Thời gian bắt đầu không được trống")
    private String thoiGianBatDau;

    @NotEmpty(message = "Thời gian Kết thúc không được trống")
    private String thoiGianKetThuc;

    @NotEmpty(message = "Mức giảm giá thúc không được trống")
    @Size(min = 5, message = "Mức giảm giá phải trên 10000VND")
    private String mucGiamGia;

    @NotBlank(message = "Chi tiết không được để trống")
    private String chiTiet;

    public KhuyenMai() {
    }

    public KhuyenMai(Integer ma, String tieuDe, String thoiGianBatDau, String thoiGianKetThuc, String mucGiamGia, String chiTiet) {
        this.ma = ma;
        this.tieuDe = tieuDe;
        this.thoiGianBatDau = thoiGianBatDau;
        this.thoiGianKetThuc = thoiGianKetThuc;
        this.mucGiamGia = mucGiamGia;
        this.chiTiet = chiTiet;
    }

    public Integer getMa() {
        return ma;
    }

    public void setMa(Integer ma) {
        this.ma = ma;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public void setThoiGianBatDau(String thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

    public String getThoiGianKetThuc() {
        return thoiGianKetThuc;
    }

    public void setThoiGianKetThuc(String thoiGianKetThuc) {
        this.thoiGianKetThuc = thoiGianKetThuc;
    }

    public String getMucGiamGia() {
        return mucGiamGia;
    }

    public void setMucGiamGia(String mucGiamGia) {
        this.mucGiamGia = mucGiamGia;
    }

    public String getChiTiet() {
        return chiTiet;
    }

    public void setChiTiet(String chiTiet) {
        this.chiTiet = chiTiet;
    }
}
