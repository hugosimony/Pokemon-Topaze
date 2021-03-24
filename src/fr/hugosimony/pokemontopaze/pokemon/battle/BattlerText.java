package fr.hugosimony.pokemontopaze.pokemon.battle;

import fr.hugosimony.pokemontopaze.Game;
import fr.hugosimony.pokemontopaze.Variables;

public class BattlerText {

	public static String getText(Game game, String battler, int moment) {
		if(battler.contains("rival")) {
			if(battler.equals("rival01")) {
				if(moment == -1) {
					if(Game.battleWin)
						return "Quel combat != C'était incroyable != T'es super fort" + Variables.LANG_Feminin + " != On se\n"
								+ "remet ça vite.= La prochaine fois je vais t'éclater !=+";	
					return "Quel combat != C'était incroyable != Je suis super fort" + Variables.RIVAL_Feminin + " != On se\n"
							+ "remet ça vite.= La prochaine fois j'espère que tu seras meilleur" + Variables.LANG_Feminin + " !=+";
				}
			}
		}
		else if(battler.equals("capboy002")) {
			if(moment == -1) {
				if(Game.battleWin) {
					Variables.BATTLERS.remove("capboy002");
					game.road01.setAnimations();
					return "T'as gagné.= J'ai perdu.= Il faut toujours un vainqueur\n"
							+ "et un perdant...";
				}
				return "J'ai gagné.= T'as perdu.= Il faut toujours un vainqueur\n"
						+ "et un perdant...";
			}
		}
		else if(battler.equals("campinggirl001")) {
			if(moment == -1) {
				if(Game.battleWin) {
					Variables.BATTLERS.remove("campinggirl001");
					game.road01.setAnimations();
					return "Pas grave,= j'ai perdu mais je peux camper.= Du coup\n"
							+ "ça va.";
				}
				return "Trop bien,= j'ai gagné et en plus je peux camper.= C'est génial.";
			}
		}
		else if(battler.equals("bugcatcher001")) {
			if(moment == -1) {
				if(Game.battleWin) {
					Variables.BATTLERS.remove("bugcatcher001");
					game.road01.setAnimations();
					return "Les Pokémons Insectes sont trop cools t'as vu != Ils sont trop\n"
							+ "forts en plus,= donc toi t'es encore plus fort" + Variables.LANG_Feminin + " !";
				}
				return "Les Pokémons Insectes sont trop cools t'as vu != C'est vraiment\n"
						+ "les meilleurs !";
			}
		}
		else if(battler.equals("campingboy001")) {
			if(moment == -1) {
				if(Game.battleWin) {
					Variables.BATTLERS.remove("campingboy001");
					game.road01.setAnimations();
					return "C'était un super combat,= mais je préfère quand même camper.";
				}
				return "J'ai gagné != C'était super != Mais bon,= je préfère quand même camper.";
			}
		}
		return "";
	}
	
}
