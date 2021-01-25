package _06_Ke_thua.bai_tap.lop_point2d_va_lop_poin3d;

public class Main {
    public static void main(String[] args) {
        Point2D point2D = new Point2D(2, 5);
        System.out.println(point2D);
        point2D.setXY(6, 8);

        Point3D point3D = new Point3D(2, 3, 6);
        System.out.println(point3D);
        point3D.setXYZ(9, 3, 5);
    }
}
