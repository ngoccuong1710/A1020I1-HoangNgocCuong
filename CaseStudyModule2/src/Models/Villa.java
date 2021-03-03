package Models;

public class Villa extends Services {
    private String tieuChuanPhong;
    private String moTaTienNghiKhac;
    private int dienTichHoBoi;
    private int soTang;

    public Villa(String id, String tenDichVu, int dienTichSuDung, int chiPhiThue, int soLuongNguoi, String kieuThue, String tieuChuanPhong, String moTaTienNghiKhac, int dienTichHoBoi, int soTang) {
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
    public void showInfor() {
        System.out.println(
                "\n1. Id: " + getId() +
                "\n2. Tên dịch vụ: " + getTenDichVu() +
                "\n3. Diện tích sử dụng " + getDienTichSuDung() +
                "\n4. Chi phí thuê: " + getChiPhiThue() +
                "\n5. Số lượng người tối đa: " + getSoLuongNguoi() +
                "\n6. Kiểu thuê: " + getKieuThue() +
                "\n7. Tiêu chuẩn phòng: " + getTieuChuanPhong() +
                "\n8. Mô tả tiện nghi khác: " + getMoTaTienNghiKhac() +
                "\n9. Diện tích hồ bơi " + getDienTichHoBoi() +
                "\n10. Số tầng: " + getSoTang());
    }

    @Override
    public String toString() {
        return "\n1. Id: " + getId() +
                "\n2. Tên dịch vụ: " + getTenDichVu() +
                "\n3. Diện tích sử dụng " + getDienTichSuDung() +
                "\n4. Chi phí thuê: " + getChiPhiThue() +
                "\n5. Số lượng người tối đa: " + getSoLuongNguoi() +
                "\n6. Kiểu thuê: " + getKieuThue() +
                "\n7. Tiêu chuẩn phòng: " + getTieuChuanPhong() +
                "\n8. Mô tả tiện nghi khác: " + getMoTaTienNghiKhac() +
                "\n9. Diện tích hồ bơi " + getDienTichHoBoi() +
                "\n10. Số tầng: " + getSoTang();
    }
}