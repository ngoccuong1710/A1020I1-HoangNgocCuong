package QuanLyPhuongTienGiaoThong.model;

public class XeMay extends PhuongTienGiaoThong{
    private int congSuat;

    public XeMay() {
    }

    public XeMay(String bienKiemSoat, String tenHang, int namSanXuat, String chuSoHuu, int congSuat) {
        super(bienKiemSoat, tenHang, namSanXuat, chuSoHuu);
        this.congSuat = congSuat;
    }

    public int getCongSuat() {
        return congSuat;
    }

    public void setCongSuat(int congSuat) {
        this.congSuat = congSuat;
    }

    public String getInfoXeMay(){
        return getBienKiemSoat() + ", " + getTenHang() + ", " + getNamSanXuat() + ", " + getChuSoHuu() + ", " + getCongSuat();
    }

    @Override
    public String toString() {
        return "\n\tBiển kiểm soát: " + getBienKiemSoat() +
                "\n\tTên hãng sản xuất: " + getTenHang() +
                "\n\tNăm sản xuất: " + getNamSanXuat() +
                "\n\tChủ sở hữu: " + getChuSoHuu() +
                "\n\tCông suất: " + getCongSuat();
    }
}
