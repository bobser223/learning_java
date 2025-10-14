package hw.hw006;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class B06_02 {

    public static void main(String[] args) {
        String text = """
            Call me at +44 (123) 123-45-67 or +44(123)1234567.
            Backup: 1 123 123-45-67, +7-123-1234567, 380(501)123-45-67.
            Noise: abc+44123123-45-67xyz (shouldn't match across letters).
            """;

        System.out.println(findAllPhoneNumbers(text));

    }


    public static ArrayList<String> findAllPhoneNumbers(String s){
        ArrayList<String> res = new ArrayList<>();

        String plusOpt       = "(?:\\+?)";
        String countryCodes  = "(?:1|7|\\d{2}|\\d{3})";
        String sepOpt        = "(?:[\\s\\-.]?)";
        String middle        = "(?:\\(\\d{3}\\)|\\d{3})";
        String ending        = "(?:\\d{7}|\\d{3}[\\s\\-.]?\\d{2}[\\s\\-.]?\\d{2})";

        // межі: не всередині букв/цифр


        String phoneRegex = plusOpt + countryCodes + sepOpt + middle + sepOpt + ending;

        Matcher m = Pattern.compile(phoneRegex).matcher(s);
        while (m.find()) {
            res.add(m.group());
        }
        return res;
    }
}
