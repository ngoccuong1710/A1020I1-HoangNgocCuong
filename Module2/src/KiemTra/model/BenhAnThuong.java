package KiemTra.model;

public class BenhAnThuong extends BenhAn{
    private String phiNamVien;

    public BenhAnThuong() {

    }

    public BenhAnThuong(int idBenhAn, String maBenhAn, String maBenhNhan, String tenBenhNhan, String ngayNhapVien, String ngayRaVien, String lyDoNhapVien, String phiNamVien) {
        super(idBenhAn, maBenhAn, maBenhNhan, tenBenhNhan, ngayNhapVien, ngayRaVien, lyDoNhapVien);
        this.phiNamVien = phiNamVien;
    }

    public String getPhiNamVien() {
        return phiNamVien;
    }

    public void setPhiNamVien(String phiNamVien) {
        this.phiNamVien = phiNamVien;
    }

    public String getInfor(){
        return getIdBenhAn() + ", " + getMaBenhAn() + ", " + getMaBenhNhan() + ", " + getTenBenhNhan() + ", " + getNgayNhapVien() + ", " +
                getNgayRaVien() + ", " + getLyDoNhapVien() + ", " + getPhiNamVien();
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
