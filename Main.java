package com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		MenuOP.printWelcome("VirtualPro", "Supriya");
		handleWelcomeScreenInput();
	}
	private static void handleWelcomeScreenInput() {
		boolean running = true;
		Scanner sc = new Scanner(System.in);
		
		do {
			MenuOP.displayMenu();
			int input = sc.nextInt();

			switch (input) {
			case 1:
				// All required files and folders inside main folder relative to current folder
				Fileop.lstFilesDirec("./main", 0);
				displayAllFiles();
				break;
			case 2:
				MenuOP.displayFileMenuOptions();
				break;
			case 3:
				System.out.println("Program exited successfully.");
				System.exit(0);
				break;
			default:
				System.out.println("Please select a valid option from above.");
			}
		} while (running == true);
		
		sc.close();

	}

	private static void displayAllFiles() {
		// All required files and folders inside main folder relative to current folder
		System.out.println("Displaying all files with directory structure in ascending order\n");
		List<String> filesListNames = Fileop.lstFilesDirec("./main", 0, new ArrayList<String>());

		System.out.println("Displaying all files in ascending order\n");
		Collections.sort(filesListNames);

		filesListNames.stream()
				.forEach(System.out::println);
	}
}