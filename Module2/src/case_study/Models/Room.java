package case_study.Models;

public class Room extends Services {
    private String dichVuMienPhiDiKem;

    public Room(String id, String tenDichVu, int dienTichSuDung, double chiPhiThue, int soLuongNguoi, String kieuThue, String dichVuMienPhiDiKem) {
        super(id, tenDichVu, dienTichSuDung, chiPhiThue, soLuongNguoi, kieuThue);
        this.dichVuMienPhiDiKem = dichVuMienPhiDiKem;
    }

    public String getDichVuMienPhiDiKem() {
        return dichVuMienPhiDiKem;
    }

    public void setDichVuMienPhiDiKem(String dichVuMienPhiDiKem) {
        this.dichVuMienPhiDiKem = dichVuMienPhiDiKem;
    }

    @Override
    public void showInfo(){
        System.out.println(
                "1. Id: " + getId() +
                "2. Tên dịch vụ: " + getTenDichVu() +
                "3. Diện tích sử dụng " + getDienTichSuDung() +
                "4. Chi phí thuê: " + getChiPhiThue() +
                "5. Số lượng người tối đa: " + getSoLuongNguoi() +
                "6. Kiểu thuê: " + getKieuThue() +
                "7. Dịch vụ miễn phí đi kèm: " + getDichVuMienPhiDiKem());
    }

    @Override
    public String toString() {
        return "Room{" +
                "dichVuMienPhiDiKem='" + dichVuMienPhiDiKem + '\'' +
                '}';
    }
}
