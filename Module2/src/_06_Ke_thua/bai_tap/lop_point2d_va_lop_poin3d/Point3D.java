package _06_Ke_thua.bai_tap.lop_point2d_va_lop_poin3d;

public class Point3D extends Point2D {
    private float z = 0.0f;

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public float[] getXYZ(){
        float[] arrXYZ = new float[3];
        return arrXYZ;
    }

    public void setXYZ(float x, float y, float z){
        System.out.println("x: " + x + ", y: " + y + ", z: " + z);
    }

    @Override
    public String toString() {
        return "Point3D{" +
                "x=" + super.getX() +
                ", y=" + super.getY() +
                ", z=" + z +
                '}';
    }
}
