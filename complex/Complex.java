package complex;

/**
 * complex
 */
public class Complex {

    int real, imag;

    Complex(int _real, int _imag) {
        this.real = _real;
        this.imag = _imag;
    }

    public static Complex summation(Complex c1, Complex c2) {
        Complex newCom = new Complex(0, 0);

        newCom.real = c1.real + c2.real;
        newCom.imag = c1.imag + c2.imag;

        return newCom;
    }

    public static Complex subtraction(Complex c1, Complex c2) {
        Complex newCom = new Complex(0, 0);

        newCom.real = c1.real - c2.real;
        newCom.imag = c1.imag - c2.imag;

        return newCom;
    }

    public static void main(String[] args) {

        Complex c1 = new Complex(5, 6);
        Complex c2 = new Complex(8, 3);

        Complex sum = summation(c1, c2);
        Complex sub = subtraction(c1, c2);

        System.out.println("Summation: " + sum.real + " + " + sum.imag + "i");

        if (sub.imag > 0)
            System.out.println("Subtraction: " + sub.real + " + " + sub.imag + "i");
        else
            System.out.println("Subtraction: " + sub.real + " " + sub.imag + "i");

    }

}