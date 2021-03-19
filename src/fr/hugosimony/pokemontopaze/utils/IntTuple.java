package fr.hugosimony.pokemontopaze.utils;

import java.util.ArrayList;

import fr.hugosimony.pokemontopaze.maps.Deplacement;
import fr.hugosimony.pokemontopaze.maps.pnj.Pnj;

public class IntTuple {

	public int x;
	public int y;
	
	public IntTuple(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public boolean equals(IntTuple tuple) {
		return this.x == tuple.x && this.y == tuple.y;
	}
	
	public boolean almostEquals(IntTuple tuple) {
		return Math.abs(this.x - tuple.x) < 5 && Math.abs(this.y - tuple.y) < 5;
	}
	
	public static boolean contains(ArrayList<IntTuple> list, IntTuple tuple) {
		int x = 0;
		boolean contains = false;
		while(!contains && x<list.size()) {
			contains = (list.get(x).x == tuple.x && list.get(x).y == tuple.y);
			x++;
		}
		return contains;
	}
	
	public static Pnj containsPnj(ArrayList<Pnj> list, IntTuple tuple) {
		int x = 0;
		boolean contains = false;
		while(!contains && x<list.size()) {
			contains = Math.abs(list.get(x).positionX - tuple.x) < Deplacement.pixelMoved && Math.abs(list.get(x).positionY - tuple.y) < Deplacement.pixelMoved;
			x++;
		}
		if(contains)
			return list.get(x-1);
		return null;
	}
	
	public static int getPnjIndex(ArrayList<Pnj> list, IntTuple tuple) {
		int x = 0;
		boolean contains = false;
		while(!contains && x<list.size()) {
			contains = (list.get(x).positionX == tuple.x && list.get(x).positionY == tuple.y);
			x++;
		}
		if(contains)
			return x-1;
		return 0;
	}
	
	public static int getPosition(ArrayList<IntTuple> list, IntTuple tuple) {
		int x = 0;
		boolean contains = false;
		while(!contains && x<list.size()) {
			contains = (list.get(x).x == tuple.x && list.get(x).y == tuple.y);
			x++;
		}
		return x;
	}
	
	public static void removeTuple(ArrayList<IntTuple> list, IntTuple tuple) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).equals(tuple)) {
				list.remove(i);
				break;
			}
		}
	}
	
}