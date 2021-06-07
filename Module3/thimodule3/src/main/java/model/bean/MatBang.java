package model.bean;

public class MatBang {
    private int no;
    private String maMatBang;
    private double dienTich;
    private int trangThai;
    private int tang;
    private int loaiVanPhong;
    private String moTa;
    private double gia;
    private String ngayChoThue;
    private String ngayKetThuc;

    public MatBang() {
    }

    public MatBang( String maMatBang, double dienTich, int trangThai, int tang, int loaiVanPhong, String moTa, double gia, String ngayChoThue, String ngayKetThuc) {
        this.maMatBang = maMatBang;
        this.dienTich = dienTich;
        this.trangThai = trangThai;
        this.tang = tang;
        this.loaiVanPhong = loaiVanPhong;
        this.moTa = moTa;
        this.gia = gia;
        this.ngayChoThue = ngayChoThue;
        this.ngayKetThuc = ngayKetThuc;
    }

    public MatBang(int no, String maMatBang, double dienTich, int trangThai, int tang, int loaiVanPhong, String moTa, double gia, String ngayChoThue, String ngayKetThuc) {
        this.no= no;
        this.maMatBang = maMatBang;
        this.dienTich = dienTich;
        this.trangThai = trangThai;
        this.tang = tang;
        this.loaiVanPhong = loaiVanPhong;
        this.moTa = moTa;
        this.gia = gia;
        this.ngayChoThue = ngayChoThue;
        this.ngayKetThuc = ngayKetThuc;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getTang() {
        return tang;
    }

    public void setTang(int tang) {
        this.tang = tang;
    }

    public String getMaMatBang() {
        return maMatBang;
    }

    public void setMaMatBang(String maMatBang) {
        this.maMatBang = maMatBang;
    }

    public double getDienTich() {
        return dienTich;
    }

    public void setDienTich(double dienTich) {
        this.dienTich = dienTich;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public int getLoaiVanPhong() {
        return loaiVanPhong;
    }

    public void setLoaiVanPhong(int loaiVanPhong) {
        this.loaiVanPhong = loaiVanPhong;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public String getNgayChoThue() {
        return ngayChoThue;
    }

    public void setNgayChoThue(String ngayChoThue) {
        this.ngayChoThue = ngayChoThue;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }
}
