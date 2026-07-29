package Calculator;

public class CalculatorMethods {

    private double result;

    public double add(double number) {
        return result += number;
    }

    public double subtract(double number) {
        return result -= number;
    }

    public double divide(double number) {
        if (number == 0) {
            throw new ArithmeticException("Деление на ноль запрещено");
        }

        return result /= number;
    }

    public double multiply(double number) {
        return result *= number;
    }

    public double degree(double number) {
        result = Math.pow(result, number);
        return result;
    }

    public double sqrt() {
        result = Math.sqrt(result);
        return result;
    }

    public double getResult() {
        return result;
    }
}