package fr.hugosimony.pokemoncancer.utils;

import java.util.ArrayList;

public class IntTriple {

	public int x;
	public int y;
	public int z;
	
	public IntTriple(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public boolean equals(IntTriple triple) {
		return this.x == triple.x && this.y == triple.y && this.z == triple.z;
	}
	
	public static boolean containsTuple(ArrayList<IntTriple> list, IntTuple tuple) {
		int x = 0;
		boolean contains = false;
		while(!contains && x<list.size()) {
			contains = list.get(x).x == tuple.x && list.get(x).y == tuple.y;
			x++;
		}
		return contains;
	}
	
	public static boolean contains(ArrayList<IntTriple> list, IntTriple triple) {
		int x = 0;
		boolean contains = false;
		while(!contains && x<list.size()) {
			contains = (list.get(x).equals(triple));
			x++;
		}
		return contains;
	}
	
	public static boolean containsWallJump(ArrayList<IntTriple> list, IntTriple triple) {
		int x = 0;
		boolean contains = false;
		while(!contains && x<list.size()) {
			contains = list.get(x).equals(triple);
			x++;
		}
		return contains;
	}
	
	public static boolean doesNotContainWallJump(ArrayList<IntTriple> list, IntTriple triple) {
		int x = 0;
		boolean contains = false;
		while(!contains && x<list.size()) {
			contains = list.get(x).x == triple.x && list.get(x).y == triple.y && list.get(x).z != triple.z;
			x++;
		}
		return contains;
	}
	
	public static IntTriple getTripleFromTuple(ArrayList<IntTriple> list, IntTuple tuple) {
		IntTriple triple = null;
		int x = 0;
		boolean contains = false;
		while(!contains && x<list.size()) {
			if(list.get(x).x == tuple.x && list.get(x).y == tuple.y) {
				triple = list.get(x);
				contains = true;
			}
			x++;
		}
		return triple;
	}
	
}