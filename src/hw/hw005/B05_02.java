package hw.hw005;

public class B05_02 {

    public static void main(String[] args) {

    }

    public static boolean a(String s){
        if (s == null || s.isEmpty()) return false;

        char[] chars = s.toCharArray();
        int cnt;

        if (Character.isDigit(chars[0]) || chars[0] == '0'){
            cnt = Character.getNumericValue(chars[0]);
        } else
            return false;

        for (char ch: chars){
            if (Character.isDigit(ch))
                return false;
        }

        return s.length() == cnt;
    }


    public static boolean b(String s){
        char[] chars = s.toCharArray();
        int cnt = -1;

        for (char ch: chars){
            if (Character.isDigit(ch)){
                if (cnt == -1)
                    cnt = Character.getNumericValue(ch);
                else
                    return false;
            }
        }
        return s.length() == cnt;
    }


    public static boolean c(String s){
        char[] chars = s.toCharArray();
        int sum = 0;

        for (char ch: chars){
            if (Character.isDigit(ch)){
                int cnt = Character.getNumericValue(ch);
                sum += cnt;
            }
        }
        return s.length() == sum;
    }
}
