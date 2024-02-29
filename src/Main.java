import java.util.Locale;
import java.util.Random;

public class Main {
    public static void test_complex_number() {
        System.out.println("Test of complex number class.");
        // Create two complex numbers
        Complex_number num1 = new Complex_number(3.5, 2);
        Complex_number num2 = new Complex_number(1, -4);

        // Perform some operations
        Complex_number sum = num1.add(num2);
        Complex_number difference = num1.subtract(num2);
        Complex_number product = num1.multiply(num2);

        // Print the results
        System.out.print("num1 = ");
        num1.printComplex();
        System.out.print("\nnum2 = ");
        num2.printComplex();
        System.out.print("\nSum = ");
        sum.printComplex();
        System.out.print("\nDifference = ");
        difference.printComplex();
        System.out.print("\nProduct = ");
        product.printComplex();

        System.out.println("\n");
    }

    public static void test_matrix() {
        System.out.println("Test of complex matrix class.");

        // Create a 2x2 matrix with some random data
        Random rand = new Random();

        Matrix matrix1 = new Matrix(3, 3);
        matrix1.fillMatrix('i');

        Matrix matrix2 = new Matrix(3, 3);
        matrix2.fillMatrix('i');

        Matrix matrix3 = new Matrix(3, 1);
        matrix3.fillMatrix('i');

        // Print the original matrix
        System.out.println("Original Matrix1:");
        matrix1.printMatrix();

        System.out.println("Original Matrix2:");
        matrix2.printMatrix();

        System.out.println("Original Matrix3:");
        matrix3.printMatrix();

        // Transpose the matrix
        Matrix transposedMatrix = matrix1.transpose();
        System.out.println("Transposed Matrix1:");
        transposedMatrix.printMatrix();

        // Calculate determinant
        Complex_number det = matrix1.determinant();
        System.out.println("Determinant of Matrix1: ");
        det.printComplex();
        System.out.println();

        // Add Matrix2 to Matrix1
        Matrix sumMatrix = matrix1.add(matrix2);
        System.out.println("\nSum of Matrix1 and Matrix2:");
        sumMatrix.printMatrix();


        // Multiply Matrix1 by Matrix3
        Matrix multipliedMatrix = matrix1.multiply(matrix3);
        System.out.println("Matrix1 multiplied by Matrix3:");
        multipliedMatrix.printMatrix();
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        test_complex_number();
        test_matrix();
    }
}