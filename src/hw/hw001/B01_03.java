//package hw.hw001;

public class B01_03 {
    public static void main(String[] args) {
        int mul = 1;
        boolean at_least_one_arg = false;

        for (String arg : args) {
            try {
                int value = Integer.parseInt(arg);
                mul *= value;
                at_least_one_arg = true;
            } catch (NumberFormatException e) {
                System.out.println(arg + " is not an integer");
            }

        }
        if (!at_least_one_arg) {
            System.out.println("No correct arguments, nothing to multiply");
        }

        System.out.println(mul);

    }
}
