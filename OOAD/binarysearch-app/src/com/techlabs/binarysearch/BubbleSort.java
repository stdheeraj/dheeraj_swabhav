package com.techlabs.binarysearch;

public class BubbleSort implements ISortingAlgorithm {

	int[] arr;

	public BubbleSort(int[] arr) {
		this.arr = arr;
	}

	@Override
	public int[] sort() {

		int n = arr.length;
		for (int i = 0; i < n - 1; i++)
			for (int j = 0; j < n - i - 1; j++)
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}

		return arr;
	}

}
