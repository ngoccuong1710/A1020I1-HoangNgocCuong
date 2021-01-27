package case_study.Models;

public class Villa extends Services {
    private String tieuChuanPhong;
    private String moTaTienNghiKhac;
    private int dienTichHoBoi;
    private int soTang;

    public Villa(String id, String tenDichVu, int dienTichSuDung, double chiPhiThue, int soLuongNguoi, String kieuThue, String tieuChuanPhong, String moTaTienNghiKhac, int dienTichHoBoi, int soTang) {
        super(id, tenDichVu, dienTichSuDung, chiPhiThue, soLuongNguoi, kieuThue);
        this.tieuChuanPhong = tieuChuanPhong;
        this.moTaTienNghiKhac = moTaTienNghiKhac;
        this.dienTichHoBoi = dienTichHoBoi;
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

    public int getDienTichHoBoi() {
        return dienTichHoBoi;
    }

    public void setDienTichHoBoi(int dienTichHoBoi) {
        this.dienTichHoBoi = dienTichHoBoi;
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
                "9. Diện tích hồ bơi " + getDienTichHoBoi() +
                "10. Số tầng: " + getSoTang());
    }

    @Override
    public String toString() {
        return "Villa{" +
                "tieuChuanPhong='" + tieuChuanPhong + '\'' +
                ", moTaTienNghiKhac='" + moTaTienNghiKhac + '\'' +
                ", dienTichHoBoi=" + dienTichHoBoi +
                ", soTang=" + soTang +
                '}';
    }
}
