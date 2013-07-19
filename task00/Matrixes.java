package net.gaziz.task00;

import java.util.Scanner;

public class Matrixes {
	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		Matrixes matrixes = new Matrixes();
		Matrix first = matrixes.read();
		Matrix second = matrixes.read();
		Matrix product = matrixes.product(first, second);
		if (product == null)
			System.out.println("Ёти матрицы не могут быть умножены");
		else
			matrixes.print(product);
	}

	Matrix read() {
		System.out.println("¬ведите размерность массива");
		System.out.println("¬ведите количество строк");
		int row = in.nextInt();
		System.out.println("¬ведите количество столбцов");
		int column = in.nextInt();
		Matrix mass = new Matrix(row, column);
		System.out.println("¬ведите элементы этого массива");
		for (int i = 0; i < mass.rows(); i++)
			for (int j = 0; j < mass.columns(); j++) {
				double temp = in.nextDouble();
				mass.update(i, j, temp);
			}
		return mass;
	}

	void print(Matrix matrix) {
		for (int i = 0; i < matrix.rows(); ++i, System.out.println())
			for (int j = 0; j < matrix.columns(); ++j)
				System.out.printf(" %10.4f", matrix.element(i, j));
	}

	Matrix product(Matrix first, Matrix second) {
		int row1 = first.rows(), col1 = first.columns(), row2 = second.rows(), col2 = second
				.columns();
		Matrix res = new Matrix(first.rows(), second.columns());
		if (col1 == row2) {
			for (int i = 0; i < row1; i++)
				for (int k = 0; k < col2; k++)
					for (int j = 0; j < row2; j++)
						res.update(i, k,
								res.element(i, k) + first.element(i, j)
										* second.element(j, k));
			return res;
		} else
			return null;
	}
}