import java.util.Random;
import java.util.Scanner;
public class Matrix {
    private final int rows, cols;
    private Complex_number[][] data;

    public Matrix() {
        this(0, 0);
    }

    public Matrix(int n) {
        this(n, n);
    }

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        data = new Complex_number[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i][j] = new Complex_number();
            }
        }
    }

    public Matrix(Complex_number[][] other) {
        this.rows = other.length;
        this.cols = other[0].length;
        this.data = other;
    }

    public Matrix(double[][] other) {
        this.rows = other.length;
        this.cols = other[0].length;
        this.data = new Complex_number[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.data[i][j] = new Complex_number(other[i][j]);
            }
        }
    }

    public Matrix(Matrix other) {
        rows = other.rows;
        cols = other.cols;
        data = other.data;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public Complex_number[][] getMatrix() { return data; }

    public Complex_number getElement(int i, int j) { return data[i][j]; }

    public void setElement(int i, int j, Complex_number n) { data[i][j] = n; }

    public void setElement(int i, int j, double n) { data[i][j] = new Complex_number(n); }
    
    public void inputMatrix() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.println("Enter [" + i + "][" + j + "] element:");

                System.out.print("Enter real part: ");
                double real = scanner.nextDouble();

                System.out.print("Enter imaginary part: ");
                double imaginary = scanner.nextDouble();

                data[i][j] = new Complex_number(real, imaginary);

            }
        }
    }

    public void fillMatrix(char ch) {
        Random rand = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (ch == 'd') {
                    this.setElement(i, j, new Complex_number(rand.nextInt() % 10 + rand.nextInt() % 10 * 0.1, rand.nextInt() % 10 + rand.nextInt() % 10 * 0.1));
                }

                else {
                    this.setElement(i, j, new Complex_number(rand.nextInt()%10, rand.nextInt()%10));
                }
            }
        }
    }

    public void printMatrix() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i][j].printComplex();
            }
            System.out.println();
        }
        System.out.println();
    }

    public Matrix add(Matrix other) {
        if (rows != other.rows || cols != other.cols) {
            throw new IllegalArgumentException("Incompatible matrix sizes.");
        }

        Matrix res = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                res.data[i][j] = this.data[i][j].add(other.data[i][j]);
            }
        }

        return res;
    }

    public Matrix subtract(Matrix other) {
        if (rows != other.rows || cols != other.cols) {
            throw new IllegalArgumentException("Incompatible matrix sizes.");
        }

        Matrix res = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                res.data[i][j] = data[i][j].subtract(other.data[i][j]);
            }
        }

        return res;
    }

    public Matrix multiply(Matrix other) {
        if (cols != rows) {
            throw new IllegalArgumentException("Size mismatch for multiplication.");
        }

        Matrix res = new Matrix(rows, other.cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < other.cols; j++) {
                for (int k = 0; k < cols; k++) {
                    res.data[i][j] = res.data[i][j].add(data[i][k].multiply(other.data[k][j]));
                }
            }
        }

        return res;
    }

    public Matrix multiply(double n) {
        Matrix res = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                res.data[i][j].multiply(new Complex_number(n));
            }
        }

        return res;
    }

    public Matrix transpose() {
        Matrix res = new Matrix(cols, rows);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                res.data[j][i] = data[i][j];
            }
        }

        return res;
    }

    public Matrix getMinor(Matrix matrix, int del_col) {
        Matrix res = new Matrix(matrix.rows - 1, matrix.cols - 1);
        int c = 0;

        for (int i = 0; i < matrix.rows; i++) {
            if (i == 0) {
                continue;
            }

            for (int j = 0; j < matrix.cols; j++) {
                if (j == del_col) {
                    continue;
                }
                res.data[(c / (matrix.cols - 1))][(c % (matrix.cols - 1))] = matrix.data[i][j];
                c++;
            }
        }

        return res;
    }

    public Complex_number determinant() {
        if (cols != rows) {
            throw new IllegalArgumentException("Matrix is not quadratic.");
        }

        if (rows == 1) {
            return data[0][0];
        }

        if (rows == 2) {
            return data[0][0].multiply(data[1][1]).subtract(data[0][1].multiply(data[1][0]));
        }

        Complex_number res = new Complex_number();

        for (int i = 0; i < rows; i++) {
            Matrix minor = getMinor(this, i);
            res = res.add(data[0][i].multiply(new Complex_number(Math.pow(-1, 2 + i))).multiply(minor.determinant()));
        }

        return res;
    }


}
