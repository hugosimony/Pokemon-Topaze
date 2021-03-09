package fr.hugosimony.pokemontopaze.utils;

import java.awt.Image;

public class Utils {

	public static long randomLongNumber(long min, long max) {
		// Return a random number between min and max (both included)
		return (long) (Math.random() * (max-min+1)) + min;
	}
	
	public static int randomNumber(int min, int max) {
		// Return a random number between min and max (both included)
		return (int) (Math.random() * (max-min+1)) + min;
	}
	
	public static int randomNumber(int max) {
		// Return a random number between 0 and max (both included)
		return randomNumber(0, max);
	}
	
	public static Image resizeImage(Image image, int new_width, int new_height) {
		// Resize the image given in parameter
		return image.getScaledInstance(new_width, new_height, Image.SCALE_DEFAULT);
	}
}
