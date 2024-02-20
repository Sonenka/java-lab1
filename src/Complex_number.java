import java.util.Scanner;
public class Complex_number {
    private double real, imaginary;

    public Complex_number() {
        this(0, 0);
    }

    public Complex_number(double real) {
        this(real, 0);
    }

    public Complex_number(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public void input_complex() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter real part:");
        real = scanner.nextInt();

        System.out.println("Enter imaginary part:");
        imaginary = scanner.nextInt();
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }

    public Complex_number add(Complex_number other) {
        return new Complex_number(real+other.real, imaginary+other.imaginary);
    }

    public Complex_number add(double n) {
        return new Complex_number(real+n, imaginary);
    }

    public Complex_number subtract(Complex_number other) {
        return new Complex_number(real-other.real, imaginary-other.imaginary);
    }

    public Complex_number subtract(double n) {
        return new Complex_number(real-n, imaginary);
    }

    public Complex_number multiply(Complex_number other) {
        return new Complex_number(real*other.real-imaginary*other.imaginary, real*other.imaginary+imaginary*other.real);
    }

    public Complex_number multiply(double n) {
        return new Complex_number(real*n, imaginary*n);
    }

    public void printComplex() {
        if (real == 0 && imaginary == 0) {
            System.out.print("0 ");
            return;
        }

        if (real != 0) {
            if (real % 1 == 0) {
                System.out.printf("%.0f", real);
            }

            else {
                System.out.printf("%.1f", real);
            }
        }

        if (imaginary == 0) {
            System.out.print(" ");
            return;
        }

        else if (imaginary > 0 && real != 0) {
            System.out.print("+");
        }

        else if (imaginary < 0){
            System.out.print("-");
        }

        if (Math.abs(imaginary) == 1) {
            System.out.print("i ");
            return;
        }

        if (imaginary % 1 == 0) {
            System.out.printf("%.0fi ", Math.abs(imaginary));
        }

        else {
            System.out.printf("%.1fi ", Math.abs(imaginary));
        }
    }
}