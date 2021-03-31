package QuanLyPhuongTienGiaoThong.model;

public class OTo extends PhuongTienGiaoThong {
    private int soChoNgoi;
    private String kieuXe;

    public OTo() {
    }

    public OTo(String bienKiemSoat, String tenHang, int namSanXuat, String chuSoHuu, int soChoNgoi, String kieuXe) {
        super(bienKiemSoat, tenHang, namSanXuat, chuSoHuu);
        this.soChoNgoi = soChoNgoi;
        this.kieuXe = kieuXe;
    }

    public int getSoChoNgoi() {
        return soChoNgoi;
    }

    public void setSoChoNgoi(int soChoNgoi) {
        this.soChoNgoi = soChoNgoi;
    }

    public String getKieuXe() {
        return kieuXe;
    }

    public void setKieuXe(String kieuXe) {
        this.kieuXe = kieuXe;
    }

    public String getInfoOTo(){
        return getBienKiemSoat() + ", " + getTenHang() + ", " + getNamSanXuat() + ", " + getChuSoHuu() + ", " + getSoChoNgoi() + getKieuXe();
    }

    @Override
    public String toString() {
        return "\n\tBiển kiểm soát: " + getBienKiemSoat() +
                "\n\tTên hãng sản xuất: " + getTenHang() +
                "\n\tNăm sản xuất: " + getNamSanXuat() +
                "\n\tChủ sở hữu: " + getChuSoHuu() +
                "\n\tSố chỗ ngồi: " + getSoChoNgoi() +
                "\n\tKiểu xe: " + getKieuXe();
    }
}
