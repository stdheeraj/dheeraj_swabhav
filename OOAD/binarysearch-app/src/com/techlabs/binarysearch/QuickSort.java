package com.techlabs.binarysearch;

public class QuickSort implements ISortingAlgorithm {

	int[] arr;
	int low, high;

	public QuickSort(int[] arr) {
		this.arr = arr;
		this.low = 0;
		this.high = arr.length - 1;
	}

	@Override
	public int[] sort() {
		sortArray(low, high);
		return arr;
	}

	private void sortArray(int low, int high) {
		if (low < high) {
			int pi = partition(low, high);

			sortArray(low, pi - 1);
			sortArray(pi + 1, high);
		}
	}

	private int partition(int low, int high) {
		int pivot = arr[high];
		int i = (low - 1);
		for (int j = low; j < high; j++) {
			if (this.arr[j] <= pivot) {
				i++;

				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;

		return i + 1;
	}

}
