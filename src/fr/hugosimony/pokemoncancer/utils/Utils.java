package fr.hugosimony.pokemoncancer.utils;

public class Utils {

	public static int randomNumber(int min, int max) {
		// Return a random number between min and max (both included)
		return (int) (Math.random() * (max-min+1)) + min;
	}
	
	public static int randomNumber(int max) {
		// Return a random number between 0 and max (both included)
		return randomNumber(0, max);
	}
	
}
