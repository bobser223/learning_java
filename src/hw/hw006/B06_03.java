package hw.hw006;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class B06_03 {

    public static void main(String[] args) {
        String ok1 = "+2 – 57*33 + 25/ - 4";
        String ok2 = "   -10   +  5*  -3 / +2   ";
        String bad1 = "2 ++ 3";
        String bad2 = "2 +";
        String bad3 = "*3 - 1";

        System.out.println(isValidExpression(ok1));
        System.out.println(isValidExpression(ok2));
        System.out.println(isValidExpression(bad1));
        System.out.println(isValidExpression(bad2));
        System.out.println(isValidExpression(bad3));
    }

    public static boolean isValidExpression(String s) {
        s = s.replaceAll("[\\u2212\\p{Pd}]", "-");

        String eqRegex = "^(?!.*\\+\\+)(?!.*--)\\s*[+-]?\\s*\\d+(?:\\s*[+\\-*/]\\s*[+-]?\\s*\\d+)*\\s*$";;

        return Pattern.matches(eqRegex, s);
    }

}
