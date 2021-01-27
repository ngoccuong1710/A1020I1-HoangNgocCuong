package case_study.Models;

public class House extends Services {
    private String tieuChuanPhong;
    private String moTaTienNghiKhac;
    private int soTang;

    public House(String id, String tenDichVu, int dienTichSuDung, double chiPhiThue, int soLuongNguoi, String kieuThue, String tieuChuanPhong, String moTaTienNghiKhac, int soTang) {
        super(id, tenDichVu, dienTichSuDung, chiPhiThue, soLuongNguoi, kieuThue);
        this.tieuChuanPhong = tieuChuanPhong;
        this.moTaTienNghiKhac = moTaTienNghiKhac;
        this.soTang = soTang;
    }

    public String getTieuChuanPhong() {
        return tieuChuanPhong;
    }

    public void setTieuChuanPhong(String tieuChuanPhong) {
        this.tieuChuanPhong = tieuChuanPhong;
    }

    public String getMoTaTienNghiKhac() {
        return moTaTienNghiKhac;
    }

    public void setMoTaTienNghiKhac(String moTaTienNghiKhac) {
        this.moTaTienNghiKhac = moTaTienNghiKhac;
    }

    public int getSoTang() {
        return soTang;
    }

    public void setSoTang(int soTang) {
        this.soTang = soTang;
    }

    @Override
    public void showInfo() {
        System.out.println(
                "1. Id: " + getId() +
                "2. Tên dịch vụ: " + getTenDichVu() +
                "3. Diện tích sử dụng " + getDienTichSuDung() +
                "4. Chi phí thuê: " + getChiPhiThue() +
                "5. Số lượng người tối đa: " + getSoLuongNguoi() +
                "6. Kiểu thuê: " + getKieuThue() +
                "7. Tiêu chuẩn phòng: " + getTieuChuanPhong() +
                "8. Mô tả tiện nghi khác: " + getMoTaTienNghiKhac() +
                "9. Số tầng: " + getSoTang());
    }

    @Override
    public String toString() {
        return "House{" +
                "tieuChuanPhong='" + tieuChuanPhong + '\'' +
                ", moTaTienNghiKhac='" + moTaTienNghiKhac + '\'' +
                ", soTang=" + soTang +
                '}';
    }
}
