package hw.hw005;

public class B05_02 {

    public static void main(String[] args) {
        System.out.println("a-tests:");
        System.out.println(a("3abc"));
        System.out.println(a("0abc"));
        System.out.println(a("2ab1"));

        System.out.println("b-tests:");
        System.out.println(b("5abcd"));
        System.out.println(b("a2b3c"));
        System.out.println(b("abc"));

        System.out.println("c-tests:");
        System.out.println(c("a2b3c"));
        System.out.println(c("11111"));
        System.out.println(c("999"));
    }


    public static boolean a(String s){
        if (s == null || s.isEmpty()) return false;

        char[] chars = s.toCharArray();
        int cnt;

        if (Character.isDigit(chars[0]) && chars[0] != '0'){
            cnt = Character.getNumericValue(chars[0]);
        } else
            return false;


        for (int i = 1; i < chars.length; i++){
            if (Character.isDigit(chars[i]))
                return false;
        }

        return s.length() == (cnt+1);
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
            } else if (!Character.isLetter(ch)) {
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
