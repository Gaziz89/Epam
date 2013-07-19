package net.gaziz.task00;

public class Matrix {
	int m, n;

	public Matrix(int rows, int columns) {
		m = rows;
		n = columns;
		massiv = new double[m][n];
	}

	double[][] massiv;

	int rows() {
		return m;
	}

	int columns() {
		return n;
	}

	double element(int row, int column) {
		return massiv[row][column];
	}

	void update(int row, int column, double value) {
		massiv[row][column] = value;
	}

	double[] row(int index) {
		return massiv[index];
	}

	double[] column(int index) {
		double[] temp = new double[this.n];
		for (int i = 0; i < index; i++)
			massiv[i][index] = temp[i];
		return temp;
	}
}