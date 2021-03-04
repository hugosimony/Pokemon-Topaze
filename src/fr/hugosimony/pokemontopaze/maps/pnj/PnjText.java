package fr.hugosimony.pokemontopaze.maps.pnj;

import fr.hugosimony.pokemontopaze.Variables;

public class PnjText {

	public static String getText(String perso) {
		if(perso.equals("mom")) {
			if(Variables.ADVENTURE_Step == 0)
				return "Ah t'es enfin réveillé" + Variables.LANG_Feminin + "...= Bon, t'as pas un truc à faire là ?\n="
						+ "Le Prof Chen t'attend à Villaube, au nord.";
			if(Variables.ADVENTURE_Step == 1)
				return "Bon, t'as pas un truc à faire là ?= Le Prof Chen t'attend\n"
						+ "à Villaube, au nord.";
		}
		else if(perso.equals("brownboy001")) {
			if(Variables.ADVENTURE_Step < 2)
				return "Coucou " + Variables.PERSO_Name + ",= tu vas enfin choper ton premier Pokémon !=\n"
						+ "T'en as de la chance...\n";
			return "Coucou " + Variables.PERSO_Name + ",= il est cool ton Pokémon !=\n"
			+ "T'en as de la chance...\n";
		}
		else if(perso.equals("brownboy002")) {
			return "Tu connais le Prof Chen ?= C'est un vieux monsieur qui aime bien\n"
					+ "les femmes.= J'ai entendu dire qu'il avait des Pokémons rares !";
		}
		else if(perso.equals("police001")) {
			return "Désolé,= la forêt est encore trop dangereuse pour toi.";
		}
		else if(perso.equals("profChen")) {
			if(Variables.ADVENTURE_Step == 1)
				return "Bonjour " + Variables.PERSO_Name + " != J'ai failli oublier que tu ne pouvais\n"
						+ "pas venir à mon labo sans Pokémon.=\n"
						+ "Mais cela va vite changer.= Tu es sur le point d'obtenir\n"
						+ "ton premier Pokémon !=+";
			if(Variables.ADVENTURE_Step >= 2 && Variables.ADVENTURE_Step <=4)
				return "+";
			if(Variables.ADVENTURE_Step == 5)
				return "Dans chacune de ces Poké Balls se trouve un Pokémon.\n="
						+ "Ils sont encore jeunes.=\n"
						+ "Le Pokémon que tu choisiras explorera la région avec toi.\n="
						+ "Tu t'amélioreras avec lui.=+";
			if(Variables.ADVENTURE_Step == 6)
				return "C'est le moment.= Choisis bien,= tu ne pourras pas revenir\n"
						+ "en arrière.";
		}
		return "";
	}
	
}
