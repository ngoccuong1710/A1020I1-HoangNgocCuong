package _19_string_regex.bai_tap.validate_ten_lop_hoc;

public class CheckNameClass {
    private static final String CHECKNAME_PATTERN = "[CAP][0-9]{4}[GHIKLM]";

    public static void main(String[] args) {
        String str = "C0318G";
        String str2 = "M0318G";
        String str3 = "P0323A";
        System.out.println(str.matches(CHECKNAME_PATTERN));
        System.out.println(str2.matches(CHECKNAME_PATTERN));
        System.out.println(str3.matches(CHECKNAME_PATTERN));
    }
}
