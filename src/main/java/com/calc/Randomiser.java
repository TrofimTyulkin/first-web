package com.calc;

import java.util.Random;

public class Randomiser {
	
	public static int randomise() {
		int min = 48;
		int max = 560;
		return generateRandom(min, max);
		
	}
	private static int generateRandom(int min, int max) {
		int diff = max - min;
		Random random = new Random();
		int i = random.nextInt(diff + 1);
		i += min;
		return i;
	}
	
	/*
	 * public static void main(String args[]) { System.out.println(randomise()); }
	 */

}
