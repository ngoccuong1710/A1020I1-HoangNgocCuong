package _19_string_regex.bai_tap.validate_so_dien_thoai;

public class CheckPhone {
    private static final String PHONE_PATTERN = "[(][0-9]{2}[)]-[(][0][0-9]{9}[)]";

    public static void main(String[] args) {
        String str = "(84)-(0978489648)";
        String str2 = "(a8)-(22222222)";

        System.out.println(str.matches(PHONE_PATTERN));
        System.out.println(str2.matches(PHONE_PATTERN));
    }
}
