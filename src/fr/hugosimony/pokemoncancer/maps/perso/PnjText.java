package fr.hugosimony.pokemoncancer.maps.perso;

import fr.hugosimony.pokemoncancer.Variables;

public class PnjText {

	public static String getText(String perso) {
		if(perso.equals("mom")) {
			return "Ah t'es enfin réveillé" + Variables.LANG_Feminin + "...= Bon, t'as pas un truc à faire là ?";
		}
		else if(perso.equals("brownboy001")) {
			return "Coucou " + Variables.PERSO_Name + ",= tu vas enfin choper ton premier Pokémon !=\n"
					+ "T'en as de la chance...\n";
		}
		else if(perso.equals("police001")) {
			return "Désolé,= la forêt est encore trop dangereuse pour toi.";
		}
		return "";
	}
	
}
