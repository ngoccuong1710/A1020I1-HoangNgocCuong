package Models;

public class Room extends Services {
    private String dichVuMienPhiDiKem;

    public Room() {
    }

    public Room(String id, String tenDichVu, int dienTichSuDung, int chiPhiThue, int soLuongNguoi, String kieuThue, String dichVuMienPhiDiKem) {
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
    public void showInfor(){
        System.out.println(
                "\n1. Id: " + getId() +
                "\n2. Tên dịch vụ: " + getTenDichVu() +
                "\n3. Diện tích sử dụng " + getDienTichSuDung() +
                "\n4. Chi phí thuê: " + getChiPhiThue() +
                "\n5. Số lượng người tối đa: " + getSoLuongNguoi() +
                "\n6. Kiểu thuê: " + getKieuThue() +
                "\n7. Dịch vụ miễn phí đi kèm: " + getDichVuMienPhiDiKem());
    }

    @Override
    public String toString() {
        return "Room{" +
                "dichVuMienPhiDiKem='" + dichVuMienPhiDiKem + '\'' +
                '}';
    }
}
