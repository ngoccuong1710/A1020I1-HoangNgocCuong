package KiemTra.model;

public class BenhAnVip extends BenhAn{
    private String loaiVip;
    private String thoiHanVip;

    public BenhAnVip() {

    }

    public BenhAnVip(int idBenhAn, String maBenhAn, String maBenhNhan, String tenBenhNhan, String ngayNhapVien, String ngayRaVien, String lyDoNhapVien, String loaiVip, String thoiHanVip) {
        super(idBenhAn, maBenhAn, maBenhNhan, tenBenhNhan, ngayNhapVien, ngayRaVien, lyDoNhapVien);
        this.loaiVip = loaiVip;
        this.thoiHanVip = thoiHanVip;
    }

    public String getLoaiVip() {
        return loaiVip;
    }

    public void setLoaiVip(String loaiVip) {
        this.loaiVip = loaiVip;
    }

    public String getThoiHanVip() {
        return thoiHanVip;
    }

    public void setThoiHanVip(String thoiHanVip) {
        this.thoiHanVip = thoiHanVip;
    }

    public String getInfor(){
        return getIdBenhAn() + ", " + getMaBenhAn() + ", " + getMaBenhNhan() + ", " + getTenBenhNhan() + ", " + getNgayNhapVien() + ", " +
                getNgayRaVien() + ", " + getLyDoNhapVien() + ", " + getLoaiVip() + ", " + getThoiHanVip();
    }

    @Override
    public String toString() {
        return "\n\tId bẹnh án: " + getIdBenhAn() +
                "\n\tMã bệnh án: " + getMaBenhAn() +
                "\n\tMã bệnh nhân: " + getMaBenhNhan() +
                "\n\tTên bệnh nhân: " + getTenBenhNhan() +
                "\n\tNgày nhập viện: " + getNgayNhapVien() +
                "\n\tNgày ra viện: " + getNgayRaVien() +
                "\n\tLý do nhập viện: " + getLyDoNhapVien() +
                "\n\tLoại vip: " + getLoaiVip() +
                "\n\tThời hạn vip: " + getThoiHanVip();
    }
}
