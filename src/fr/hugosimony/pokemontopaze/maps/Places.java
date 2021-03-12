package fr.hugosimony.pokemontopaze.maps;

public enum Places {
	SELENIA, ROAD01, VILLAUBE;
	
	public static String getGoodName(Places place) {
		if(place == SELENIA)
			return "Sélénia";
		if(place == ROAD01)
			return "Route 01";
		if(place == VILLAUBE)
			return "Villaube";
		return "";
	}
	
	public static Places getGoodPlace(String place) {
		if(place.equals("Sélénia"))
			return SELENIA;
		if(place.equals("Route 01"))
			return ROAD01;
		if(place.equals("Villaube"))
			return VILLAUBE;
		return null;
	}

}

