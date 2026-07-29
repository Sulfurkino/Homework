package Calculator;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        CalculatorMethods calc = new CalculatorMethods();

        while (true) {

            System.out.println();
            System.out.println("Текущий результат: " + calc.getResult());
            System.out.println("Выберите операцию:");
            System.out.println("1 - Сложение");
            System.out.println("2 - Вычитание");
            System.out.println("3 - Умножение");
            System.out.println("4 - Деление");
            System.out.println("5 - Возведение в степень");
            System.out.println("6 - Квадратный корень");
            System.out.println("0 - Выход");

            int choice = scanner.nextInt();

            if (choice == 0) {
                System.out.println("Калькулятор завершён");
                break;
            }

            try {
                switch (choice) {

                    case 1:
                        System.out.println("Введите число:");
                        double addNumber = scanner.nextDouble();
                        System.out.println("Результат: " + calc.add(addNumber));
                        break;

                    case 2:
                        System.out.println("Введите число:");
                        double subtractNumber = scanner.nextDouble();
                        System.out.println("Результат: " + calc.subtract(subtractNumber));
                        break;

                    case 3:
                        System.out.println("Введите число:");
                        double multiplyNumber = scanner.nextDouble();
                        System.out.println("Результат: " + calc.multiply(multiplyNumber));
                        break;

                    case 4:
                        System.out.println("Введите число:");
                        double divideNumber = scanner.nextDouble();
                        System.out.println("Результат: " + calc.divide(divideNumber));
                        break;

                    case 5:
                        System.out.println("Введите степень:");
                        double degreeNumber = scanner.nextDouble();
                        System.out.println("Результат: " + calc.degree(degreeNumber));
                        break;

                    case 6:
                        System.out.println("Результат: " + calc.sqrt());
                        break;

                    default:
                        throw new InvalidOperationException(
                                "Некорректная операция: " + choice
                        );
                }

            } catch (ArithmeticException | InvalidOperationException e) {
                System.out.println(e.getMessage());
            }
        }

        scanner.close();
    }
}