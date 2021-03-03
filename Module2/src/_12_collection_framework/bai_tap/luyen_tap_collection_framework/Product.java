package _12_collection_framework.bai_tap.luyen_tap_collection_framework;

public class Product {
    private int id;
    private String tenSP;
    private int giaTien;

    public Product() {
    }

    public Product(int id, String tenSP, int giaTien) {
        this.id = id;
        this.tenSP = tenSP;
        this.giaTien = giaTien;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(int giaTien) {
        this.giaTien = giaTien;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", tenSP='" + tenSP + '\'' +
                ", giaTien=" + giaTien +
                '}';
    }
}
