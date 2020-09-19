package com.danske;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Helper {

	/**
	 * Reads values from poker.txt file
	 * @return List of lines
	 */
	public static List<String> readHands() {

		List<String> data = new ArrayList<String>();
		
		try {
			
			File file = new File("poker.txt");
			Scanner scanner = new Scanner(file);
			
			while(scanner.hasNextLine()) {
				data.add(scanner.nextLine());
			}
			
			scanner.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Error - poker.txt not found");
			e.printStackTrace();
		}
		
		return data;
	}
}
