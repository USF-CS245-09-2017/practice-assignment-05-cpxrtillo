// first element in the array is the pivot --> want the pivot to be in the middle of the array
// worst case: O(n(n-1))
// best case: O(nlogn)
// average case: 

// called an inplace sorting algorithm, don't need a copy of the array

// code

public class QuickSort implements SortingAlgorithm{

	public void sort(int[] a) {
		quicksort(a, 0, a.length - 1);
	}

	public void quicksort(int [] arr, int left, int right) {
		if (left < right) {
			int p = partition(arr, left, right);
			quicksort(arr, left, p-1);
			quicksort(arr, p+1, right);
		}
	}

	public void swap(int[] a, int smallest, int largest) {
		int temp = a[smallest];
		a[smallest] = a[largest];
		a[largest] = temp;
	}

	public int partition (int [] arr, int left, int right) {
		if (left < right) {
			int pivot = left;
			int i = left + 1; // Avoids re-sorting the pivot
			int j = right;
			while (i < j) {
				while (i <= right && arr[i] <= arr[pivot]) {					++i;
				}
				while (j >= i && arr[j] > arr[pivot]) {
					--j;
				}
				if (i <= right && i < j) {
					swap(arr, i, j);
				}
			}
			swap(arr, pivot, j);  // pivot to the middle
			return j;
		}
		return left;
	}
}
