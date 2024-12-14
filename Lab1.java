// ІО-25 Савельєв Артем
// Залікова книжка: 2526
// C5 = 1 => C = Bᵀ
// C7 = 5 => type: char
// C11 = 7 => Обчислити суму найбільших елементів в стовпцях матриці з непарними номерами та найменших елементів в стовпцях матриці з парними номерами

import java.util.Arrays;

public class Lab1 {
	// Вивід
	public static void printMatrix(char[][] matrix, String name) {
		System.out.print("Матриця " + name + ":\n");
		for (int i = 0; i < matrix.length; i++) {
			if (i == 0) {
				System.out.print("[");
			} else {
				System.out.print(" ");
			}
			System.out.print(Arrays.toString(matrix[i]));
			if (i+1 == matrix.length) {
				System.out.println("]");
			} else {
				System.out.println(",");
			}
		}
	}
	
	// Дія 1
	public static char[][] transposeMatrix(char[][] matrix) {
		char[][] result = new char[matrix[0].length][matrix.length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				result[i][j] = matrix[j][i];
			}
		}
		return result;
	}
	
	// Дія 2
	public static void action2(char[][] matrix) {
		char sum = 0;
		for (int i = 0; i < matrix.length; i++) {
			char max = Character.MIN_VALUE;
			char min = Character.MAX_VALUE;
			
			if (i%2 == 0) {
				for (int j = 0; j < matrix.length; j++) {
					if (max < matrix[j][i]) {
						max = matrix[j][i];
					}
				}
				sum = (char) (sum + max);
			} else {
				for (int j = 0; j < matrix.length; j++) {
					if (min > matrix[j][i]) {
						min = matrix[j][i];
					}
				}
				sum = (char) (sum + min);
			}
		}
		System.out.println("Сума найбільших елементів в стовпцях матриці з непарними номерами та найменших елементів в стовпцях матриці з парними номерами дорівнює '" + sum + "' (" + (int) sum + ")");
	}
	
    public static void main(String[] args) {
        char[][] B = {{'a', 'b', 'c', 'd'}, {'a', 'b', 'c', 'd'}, {'a', 'b', 'c', 'd'}, {'a', 'b', 'c', 'd'}};
		char[][] C = transposeMatrix(B);
		printMatrix(B, "B");
		printMatrix(C, "C");
		action2(C);
    }
}