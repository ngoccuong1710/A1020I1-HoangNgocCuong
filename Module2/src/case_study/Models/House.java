package case_study.Models;

public class House extends Services {
    private String tieuChuanPhong;
    private String moTaTienNghiKhac;
    private int soTang;

    public House(String id, String tenDichVu, int dienTichSuDung, int chiPhiThue, int soLuongNguoi, String kieuThue, String tieuChuanPhong, String moTaTienNghiKhac, int soTang) {
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
                "\n9. Số tầng: " + getSoTang());
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
                "\n9. Số tầng: " + getSoTang();
    }
}
