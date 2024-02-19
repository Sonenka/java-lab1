import java.util.Scanner;
public class Matrix {
    private int rows;
    private int cols;
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

    public Matrix(Complex_number other[][]) {
        this.rows = data.length;
        this.cols = data[0].length;
        this.data = other;
    }

    public Matrix(double other[][]) {
        this.rows = data.length;
        this.cols = data[0].length;
        this.data = new Complex_number[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.data[i][j] = data[i][j];
            }
        }
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
    
    public void inputMatrix() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.println("Enter [" + i + "][" + j + "] element:");

                System.out.println("Enter real part:");
                double real = scanner.nextDouble();

                System.out.println("Enter imaginary part:");
                double imaginary = scanner.nextDouble();

                data[i][j] = new Complex_number(real, imaginary);

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
    }

    public Matrix add(Matrix other) {
        if (rows != other.rows || cols != other.cols) {
            throw new IllegalArgumentException("Несовместимые размеры матриц");
        }

        Matrix res = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                res.data[i][j] = this.data[i][j].add(other.data[i][j]);
            }
        }

        return res;
    }

    public Matrix substract(Matrix other) {
        if (rows != other.rows || cols != other.cols) {
            throw new IllegalArgumentException("Несовместимые размеры матриц");
        }

        Matrix res = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                res.data[i][j] = this.data[i][j].substract(other.data[i][j]);
            }
        }

        return res;
    }

    public Matrix multiply(Matrix other) {
        if (cols != rows) {
            throw new IllegalArgumentException("Несоответствие размеров для умножения");
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

    public Matrix multiply(int n) {
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

}
