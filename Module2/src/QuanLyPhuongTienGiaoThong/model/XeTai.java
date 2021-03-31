package QuanLyPhuongTienGiaoThong.model;

public class XeTai extends PhuongTienGiaoThong{
    private int trongTai;

    public XeTai() {
    }

    public XeTai(String bienKiemSoat, String tenHang, int namSanXuat, String chuSoHuu, int trongTai) {
        super(bienKiemSoat, tenHang, namSanXuat, chuSoHuu);
        this.trongTai = trongTai;
    }

    public int getTrongTai() {
        return trongTai;
    }

    public void setTrongTai(int trongTai) {
        this.trongTai = trongTai;
    }

    public String getInfoXeTai(){
        return getBienKiemSoat() + ", " + getTenHang() + ", " + getNamSanXuat() + ", " + getChuSoHuu() + ", " + getTrongTai();
    }

    @Override
    public String toString() {
        return "\n\tBiển kiểm soát: " + getBienKiemSoat() +
                "\n\tTên hãng sản xuất: " + getTenHang() +
                "\n\tNăm sản xuất: " + getNamSanXuat() +
                "\n\tChủ sở hữu: " + getChuSoHuu() +
                "\n\tTrọng tải: " + getTrongTai();
    }
}
