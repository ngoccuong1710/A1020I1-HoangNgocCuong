package _07_Abstract_class_interface.bai_tap.trien_khai_interface_resizeable_cho_cac_lop_hinh_hoc;

public class ResizeableCircle extends Circle implements Resizeable{
    public ResizeableCircle(double radius){
        super(radius);
    }

    @Override
    public void resize(double percent) {
        radius *= percent / 100;
    }
}
