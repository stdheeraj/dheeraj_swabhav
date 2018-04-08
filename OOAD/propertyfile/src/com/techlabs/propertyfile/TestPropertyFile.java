package com.techlabs.propertyfile;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TestPropertyFile {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Set<String> rtocode = new HashSet<String>();

		rtocode.add("AP-01");
		rtocode.add("AP-36");
		rtocode.add("DL-01");
		rtocode.add("DL-22");
		rtocode.add("DL-1D");
		rtocode.add("GA-01");
		rtocode.add("GA-12");
		rtocode.add("GJ-01");
		rtocode.add("GJ-37");
		rtocode.add("JK-01");
		rtocode.add("JK-22");
		rtocode.add("KA-01");
		rtocode.add("KA-66");
		rtocode.add("KA-xx Gx-xxxx");
		rtocode.add("KL-01");
		rtocode.add("KL-73");
		rtocode.add("MH-01");
		rtocode.add("MH-51");
		rtocode.add("MP-01");
		rtocode.add("MP-69");
		rtocode.add("RJ-01");
		rtocode.add("RJ-52");
		rtocode.add("TN-01");
		rtocode.add("TN-99");
		rtocode.add("UP-01");
		rtocode.add("UP-96");
		rtocode.add("WB-01");
		rtocode.add("WB-96");

		int choice;

		do {
			System.out
					.println("Enter your choice -> 1: Display All RTO Codes\t2: Search for RTO Code\t3: Exit");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				displayRTOCodes(rtocode);
				break;

			case 2:
				System.out.println("Enter character : ");
				String search = sc.next();
				searchRTOCode(rtocode, search);
				break;

			case 3:
				break;

			default:
				System.out.println("Invalid Choice.");
			}

		} while (choice != 3);
		sc.close();
	}

	private static void searchRTOCode(Set<String> rtocode, String search) {
		int count = 0;
		for (String s : rtocode) {
			if (s.contains(search)) {
				System.out.println(s);
				count++;
			}
		}
		if (count == 0)
			System.out.println("This RTO code is not available.");
	}

	private static void displayRTOCodes(Set<String> rtocode) {
		for (String r : rtocode)
			System.out.println(r);
	}

}
