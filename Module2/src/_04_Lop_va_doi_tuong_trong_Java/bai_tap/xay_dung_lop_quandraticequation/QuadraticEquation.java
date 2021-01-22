package _04_Lop_va_doi_tuong_trong_Java.bai_tap.xay_dung_lop_quandraticequation;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getDiscriminant(){
        return this.getB()*this.getB() - 4*this.getA()*this.getC();
    }

    public double getRoot1(){
        if (this.getDiscriminant() >= 0) {
            return (-this.getB() + Math.sqrt(this.getDiscriminant())) / 2 * this.getA();
        }
        else return 0;
    }

    public double getRoot2(){
        if (this.getDiscriminant() >= 0) {
            return (-this.getB() - Math.sqrt(this.getDiscriminant())) / 2 * this.getA();
        }
        else return 0;
    }

    public double getNghiemKep(){
        return -this.getB() / 2*this.getA();
    }

    public double get1Nghiem(){
        return -this.getC() / this.getB();
    }
}
