package Models;

public class Customer extends Services {
    private String tenCustomer;
    private String ngaySinh;
    private String gioiTinh;
    private String cmnd;
    private String soDT;
    private String email;
    private String loaiKhach;
    private String diaChi;

    public Customer() {
    }

    public Customer(String tenCustomer, String ngaySinh, String gioiTinh, String cmnd, String soDT, String email, String loaiKhach, String diaChi) {
        this.tenCustomer = tenCustomer;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.cmnd = cmnd;
        this.soDT = soDT;
        this.email = email;
        this.loaiKhach = loaiKhach;
        this.diaChi = diaChi;
    }

    public Customer(String tenCustomer, String ngaySinh, String gioiTinh, String cmnd, String soDT, String email, String loaiKhach, String diaChi, String id, String tenDichVu, int dienTichSuDung, int chiPhiThue, int soLuongNguoi, String kieuThue) {
        super(id, tenDichVu, dienTichSuDung, chiPhiThue, soLuongNguoi, kieuThue);
        this.tenCustomer = tenCustomer;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.cmnd = cmnd;
        this.soDT = soDT;
        this.email = email;
        this.loaiKhach = loaiKhach;
        this.diaChi = diaChi;
    }

    public String getTenCustomer() {
        return tenCustomer;
    }

    public void setTenCustomer(String tenCustomer) {
        this.tenCustomer = tenCustomer;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLoaiKhach() {
        return loaiKhach;
    }

    public void setLoaiKhach(String loaiKhach) {
        this.loaiKhach = loaiKhach;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Override
    public void showInfor(){
        System.out.println(
                "\n1. Họ tên Customer: " + getTenCustomer() +
                "\n2. Ngày sinh: " + getNgaySinh() +
                "\n3. Giới tính: " + getGioiTinh() +
                "\n4. Số CMND: " + getCmnd() +
                "\n5. Số điện thoại: " + getSoDT() +
                "\n6. Email: " + getEmail() +
                "\n7. loại khách: " + getLoaiKhach() +
                "\n8. Địa chỉ: " + getDiaChi() +
                "\n9. Id dịch vụ: " + getId() +
                "\n10. Tên dịch vụ: " + getTenDichVu() +
                "\n11. Diện tích sử dụng: " + getDienTichSuDung() +
                "\n12. Chi phí thuê: " + getChiPhiThue() +
                "\n13. Số lượng người: " + getSoLuongNguoi() +
                "\n14. Kiểu thuê: " + getKieuThue());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "tenCustomer='" + tenCustomer + '\'' +
                ", ngaySinh='" + ngaySinh + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", cmnd='" + cmnd + '\'' +
                ", soDT='" + soDT + '\'' +
                ", email='" + email + '\'' +
                ", loaiKhach='" + loaiKhach + '\'' +
                ", diaChi='" + diaChi + '\'' +
                '}';
    }
}
