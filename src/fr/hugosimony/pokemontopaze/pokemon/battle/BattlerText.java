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
		else if(battler.equals("capboy001")) {
			if(moment == -1) {
				if(Game.battleWin) {
					Variables.BATTLERS.remove("capboy001");
					game.road01.setAnimations();
					return "T'as gagné.= J'ai perdu.= Il faut toujours un vainqueur\n"
							+ "et un perdant...";
				}
				return "J'ai gagné.= T'as perdu.= Il faut toujours un vainqueur\n"
						+ "et un perdant...";
			}
		}
		return "";
	}
	
}
