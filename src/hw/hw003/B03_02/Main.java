package hw.hw003.B03_02;

public class Main {
    public static void main(String[] args) {
        var equarions = QuadraticEquation.GenerateEquations(12);
        for (var equation : equarions){
            System.out.println(equation);
        }

        System.out.println("--------------------------------");

        var max_eq = QuadraticEquation.EquationWithMaxRoot(equarions);
        if (max_eq != null){
            System.out.println("Max equation is : " + max_eq + "with max root: " + max_eq.getRoots().getMaxRoot());
        }
        else{
            System.out.println("No equations with real roots");
        }
    }
}
