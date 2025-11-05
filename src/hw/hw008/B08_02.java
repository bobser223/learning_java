package hw.hw008;

public class B08_02 {

    public static void main(String[] args) {
        B08_02 b = new B08_02();
        String[] tests = {
                "", "a+b", "()", "([]){}", "([{}])", "(a[b]{c})", "{[()()]}", "((a+b)*(c+d))",
                "(((((((((())))))))))", "((a)[b]{c(d)e}f)",
                "(", ")", "((a+b)", "(a+b))", "([)]", "{[(])}", "){(", ")(()", "[}",
                "func(x[2] + arr[i*(j+1)])", "if (a[0] > b[1]) { return (x+y]; }"
        };
        boolean[] expected = {
                true, true, true, true, true, true, true, true,
                true, true,
                false, false, false, false, false, false, false, false, false,
                true, false
        };

        for (int i = 0; i < tests.length; i++) {
            boolean got = b.checkBreackets(tests[i]);
            System.out.printf("[%2d] %-45s -> got=%5s expected=%5s %s%n",
                    i, "\"" + tests[i] + "\"", got, expected[i],
                    (got == expected[i] ? "✓" : "✗"));
        }
    }

    public boolean checkBreackets(String expression){
        Stack<Character> st = new Stack<>(); // this is my stack implementation
        char[] chars = expression.toCharArray();
        for (char ch: chars){
            if (ch == '(' || ch == '[' || ch == '{')
                st.push(ch);
            else if (ch == ')' || ch == ']' || ch == '}'){
                if (st.isEmpty()) return false;
                char top = st.peek();
                if ((top == '(' && ch == ')') ||
                        (top == '[' && ch == ']') ||
                        (top == '{' && ch == '}')) {
                    st.pop();
                } else {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }

}
