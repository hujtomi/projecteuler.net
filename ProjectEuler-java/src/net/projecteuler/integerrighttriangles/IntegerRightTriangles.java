package net.projecteuler.integerrighttriangles;

import java.util.Arrays;
import java.util.LinkedList;

public class IntegerRightTriangles {

	public IntegerRightTriangles() {

		LinkedList<Integer[]> solutions = new LinkedList<Integer[]>();
		int[] p = new int[1001];

		for (int a = 1; a <= 1000; a++) {
			for (int b = 1; b <= 1000 - a; b++) {
				for (int c = 1; c <= 1000 - a - b; c++) {

					if (a * a + b * b == c * c) {
						Integer[] solution = new Integer[3];
						solution[0] = a;
						solution[1] = b;
						solution[2] = c;

						p[a + b + c]++;

						Arrays.sort(solution);

						boolean contains = false;
						for (Integer[] item : solutions) {
							if (item[0] == a && item[1] == b && item[2] == c)
								contains = true;
						}

						if (!contains)
							solutions.add(solution);
					}
				}
			}
		}

		for (Integer[] item : solutions) {
			System.out.println("a: " + item[0] + " b: " + item[1] + " c:"
					+ item[2]);

		}

		int index = indexOfMaxValue(p);
		System.out.println("p index: " + index + " value: " + p[index]);
		System.out.println("number of solutions: " + solutions.size());
	}

	public int indexOfMaxValue(int[] array) {
		int maxValue = Integer.MIN_VALUE;

		int index = -1;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > maxValue) {
				index = i;
				maxValue = array[i];
			}
		}
		
		return index;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new IntegerRightTriangles();

	}

}
