package hw.hw005;

public class B05_01 {


    public static void main(String[] args) {
        System.out.println(removeParentheses("Hello (world)!"));
        System.out.println(removeParentheses("a(<one>)b(<two>)"));
        System.out.println(removeParentheses("a(<one>(b(<two>)c"));
        System.out.println(removeParentheses("(external(internal))"));
    }

    public static boolean bracketsCheck(String s){
        char[] chars = s.toCharArray();
        Boolean opened = false;

        for (char c : chars){
            if (c == '('){
                if (opened)
                    return false;
                opened = true;
            } else if (c == ')') {
                if (!opened)
                    return false;
                opened = false;
            }
        }
        return !opened;
    }

    public static String removeParentheses(String s){
        if (!bracketsCheck(s))
            return s;
        return s.replaceAll("\\(.*?\\)", "");

    }


}
