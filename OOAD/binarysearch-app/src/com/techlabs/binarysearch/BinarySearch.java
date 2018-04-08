package com.techlabs.binarysearch;

public class BinarySearch {

	int[] sortedarr;

	public BinarySearch(ISortingAlgorithm s) {
		this.sortedarr = s.sort();
		System.out.print("Sorted Array -> ");
		for (int i : sortedarr)
			System.out.print(i + "\t");
		System.out.println();
	}

	public String find(int search) {
		int left = 0, right = sortedarr.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (sortedarr[mid] == search)
				return "Element found at " + (mid + 1)
						+ "th position in above array.";

			if (sortedarr[mid] < search)
				left = mid + 1;
			else
				right = mid - 1;
		}
		return "Element not found in above array.";
	}

}
