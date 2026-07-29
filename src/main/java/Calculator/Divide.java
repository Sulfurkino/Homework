package Calculator;

public class Divide {
    static void safeDivide(double a, double b) throws Calculator.ArithmeticException {
        try {
            double test = a/b;
        } catch (Calculator.ArithmeticException e){
            throw new ArithmeticException("нельзя делить на ноль");
        }

    }
}
