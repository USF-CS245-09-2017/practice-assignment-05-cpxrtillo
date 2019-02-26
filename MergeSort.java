// O(logn) --> dividing array by 2;
// merge two one element array into one array, until you have n items
// go logn levels
// always give you nlogn performance --> stable sort that gives you good performance at all times

import java.util.Arrays;

public class MergeSort implements SortingAlgorithm {

	public void sort(int[] a) {

		if (a.length > 1) {
			int[] left = get_left(a);
			int[] right = get_right(a);
			sort(left);
			sort(right);
			merging(a, left, right);
		}
	}

	private int[] get_left(int[] a) {
		int[] left = Arrays.copyOfRange(a, 0, a.length/2);
		return left;	
	}

	private int[] get_right(int[] a) {
		int[] right = Arrays.copyOfRange(a, a.length/2, a.length);
		return right;
	}

	private void merging(int[] a, int[] left, int[] right) {

		// ++ issue: 
		// int x = 17;
		// int y = 17;
		// print(x++); <-- prints 17, add one after
		// print(++y); <-- prints 18, forget about all stuff in the statement, add one before everything the function does

		int lefti = 0;
		int righti = 0;
		int targeti = 0;

		while (lefti < left.length && righti < right.length) {
			if (left[lefti] <= right[righti]) { // stability == if two arrays have the same value, choose the left first
				a[targeti++] = left[lefti++];
			}
			else {
				a[targeti++] = right[righti++];
			}
		}
		while (lefti < left.length) {
			a[targeti++] = left[lefti++];
		}
		while (righti < right.length) {
			a[targeti++] = right[righti++];
		}
	}
}