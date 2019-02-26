public class InsertionSort implements SortingAlgorithm {
	
	public void sort(int[] a) {
		
		for (int i = 0; i < a.length; i++) { // O(n)
			int temp = a[i];
			int j = i - 1;
			
			while (j >= 0 && a[j] > temp) { // O(n) --> multiply O(n) * O(n) = O(n^2)
				a[j+1] = a[j];
				j--;
			}
			a[j+1] = temp;
		}
	}
}