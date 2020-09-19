package com.danske;

import java.util.List;

public class Poker {

	public static void main(String[] args) {

		List<String> data = Helper.readHands();

		for (String a: data) {
			System.out.println(a);
		}
	}

}
