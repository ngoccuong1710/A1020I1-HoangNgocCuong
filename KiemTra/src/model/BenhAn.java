package model;

abstract class BenhAn {
    private int idBenhAn;
    private String maBenhAn;
    private String maBenhNhan;
    private String tenBenhNhan;
    private String ngayNhapVien;
    private String ngayRaVien;
    private String lyDoNhapVien;

    public BenhAn(){

    }

    public BenhAn(int idBenhAn, String  maBenhAn, String maBenhNhan, String tenBenhNhan, String ngayNhapVien, String ngayRaVien, String lyDoNhapVien) {
        this.idBenhAn = idBenhAn;
        this.maBenhAn = maBenhAn;
        this.maBenhNhan = maBenhNhan;
        this.tenBenhNhan = tenBenhNhan;
        this.ngayNhapVien = ngayNhapVien;
        this.ngayRaVien = ngayRaVien;
        this.lyDoNhapVien = lyDoNhapVien;
    }

    public int getIdBenhAn() {
        return idBenhAn;
    }

    public void setIdBenhAn(int idBenhAn) {
        this.idBenhAn = idBenhAn;
    }

    public String  getMaBenhAn() {
        return maBenhAn;
    }

    public void setMaBenhAn(String  maBenhAn) {
        this.maBenhAn = maBenhAn;
    }

    public String  getMaBenhNhan() {
        return maBenhNhan;
    }

    public void setMaBenhNhan(String  maBenhAn) {
        this.maBenhNhan = maBenhAn;
    }

    public String getTenBenhNhan() {
        return tenBenhNhan;
    }

    public void setTenBenhNhan(String tenBenhNhan) {
        this.tenBenhNhan = tenBenhNhan;
    }

    public String getNgayNhapVien() {
        return ngayNhapVien;
    }

    public void setNgayNhapVien(String ngayNhapVien) {
        this.ngayNhapVien = ngayNhapVien;
    }

    public String getNgayRaVien() {
        return ngayRaVien;
    }

    public void setNgayRaVien(String ngayRaVien) {
        this.ngayRaVien = ngayRaVien;
    }

    public String getLyDoNhapVien() {
        return lyDoNhapVien;
    }

    public void setLyDoNhapVien(String lyDoNhapVien) {
        this.lyDoNhapVien = lyDoNhapVien;
    }

    @Override
    public String toString() {
        return "\n\tId bẹnh án: " + getIdBenhAn() +
                "\n\tMã bệnh án: " + getMaBenhAn() +
                "\n\tMã bệnh nhân: " + getMaBenhNhan() +
                "\n\tTên bệnh nhân: " + getTenBenhNhan() +
                "\n\tNgày nhập viện: " + getNgayNhapVien() +
                "\n\tNgày ra viện: " + getNgayRaVien() +
                "\n\tLý do nhập viện: " + getLyDoNhapVien();
    }
}
