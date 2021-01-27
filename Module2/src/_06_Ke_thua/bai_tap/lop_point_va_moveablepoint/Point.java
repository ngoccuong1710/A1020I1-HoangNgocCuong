package _06_Ke_thua.bai_tap.lop_point_va_moveablepoint;

public class Point {
    float x = 0.0f;
    float y = 0.0f;

    public Point(){

    }

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float[] getXY(){
        float[] arrXY = new float[2];
        return arrXY;
    }

    public void setXY(float x, float y){
        System.out.println("x: " + x + ", y: " +y);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + getX() +
                ", y=" + getY() +
                '}';
    }
}
