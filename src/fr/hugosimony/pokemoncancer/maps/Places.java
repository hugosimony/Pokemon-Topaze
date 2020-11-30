package fr.hugosimony.pokemoncancer.maps;

public enum Places {
	SELENIA;
	
	public static String getGoodName(Places place) {
		if(place == SELENIA)
			return "Sélénia";
		return "";
	}
	
	public static Places getGoodPlace(String place) {
		if(place.equals("Sélénia"))
			return SELENIA;
		return null;
	}

}

