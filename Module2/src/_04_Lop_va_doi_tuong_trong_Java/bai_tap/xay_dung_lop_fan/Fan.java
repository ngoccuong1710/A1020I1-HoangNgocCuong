package _04_Lop_va_doi_tuong_trong_Java.bai_tap.xay_dung_lop_fan;

public class Fan {
    private static final int SLOW = 1;
    private static final int MEDIUM = 2;
    private static final int FAST = 3;

    private int speed;
    private boolean on;
    private double radius;
    private String color;

    public Fan(int speed, double radius, String color) {
        this.speed = speed;
        this.on = false;
        this.radius = radius;
        this.color = color;
    }

    public int getSpeed() {
        if (!isOn()){
            return 0;
        }
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        if (!false) {
            return on;
        }
        return false;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Fan{" +
                "speed=" + getSpeed() +
                ", on=" + isOn() +
                ", radius=" + getRadius() +
                ", color='" + getColor() + '\'' +
                '}';
    }
}
