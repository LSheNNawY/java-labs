package calculator;

/**
 * Calculator
 */
public class Calculator {

    public static float sum(float number1, float number2) {
        return number1 + number2;
    }

    public static float sub(float number1, float number2) {
        return number1 - number2;
    }

    public static float mult(float number1, float number2) {
        return number1 * number2;
    }

    public static float div(float number1, float number2) {
        return number1 / number2;
    }

    public static float mod(float number1, float number2) {
        return number1 % number2;
    }

    public static void main(String[] args) {

        if (args.length < 3) {
            System.out.println("You have to insert number1, operator, number2");
        } else {

            float num1 = (float) Double.parseDouble(args[0]);
            float num2 = (float) Double.parseDouble(args[2]);
            String oper = args[1];

            switch (oper) {
                case "+":
                    System.out.println(sum(num1, num2));
                    break;
                case "-":
                    System.out.println(sub(num1, num2));
                    break;
                case "x":
                    System.out.println(mult(num1, num2));
                    break;

                case "/":
                    System.out.println(div(num1, num2));
                    break;

                case "%":
                    System.out.println(mod(num1, num2));
                    break;

                default:
                    System.out.println("Wrong operation");
                    break;
            }
        }

    }
}