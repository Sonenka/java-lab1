import java.util.Locale;
public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
/*
        Complex_number n1 = new Complex_number(1, 2);
        Complex_number n2 = new Complex_number(3, -4.5);

        double r = n1.getImaginary();
        System.out.println(r);

        Complex_number c = n1.multiply(n2);
        System.out.println(c.getReal());
        System.out.println(c.getImaginary());

        c.printComplex();
*/

        Matrix mat = new Matrix(3, 3);
        mat.inputMatrix();
        mat.printMatrix();

    }
}