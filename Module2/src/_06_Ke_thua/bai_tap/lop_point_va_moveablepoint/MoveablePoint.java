package _06_Ke_thua.bai_tap.lop_point_va_moveablepoint;

public class MoveablePoint extends Point{
    private float xSpeed = 0.0f;
    private float ySpeed = 0.0f;

    public MoveablePoint(){

    }

    public MoveablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MoveablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public float[] getSpeed(){
        float[] arrSpeed = new float[2];
        return arrSpeed;
    }

    public void setSpeed(float xSpeed, float ySpeed){
        System.out.println("xSpeed: " + xSpeed + ", ySpeed: " + ySpeed);
    }

    public float move(float x, float y){
        x += this.xSpeed;
        y += this.ySpeed;
        return this.move(x, y);
    }

    @Override
    public String toString() {
        return "MoveablePoint{" +
                "xSpeed=" + xSpeed +
                ", ySpeed=" + ySpeed +
                '}';
    }
}
