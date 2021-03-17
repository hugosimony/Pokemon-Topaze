package fr.hugosimony.pokemontopaze.pokemon.battle;

import fr.hugosimony.pokemontopaze.Game;
import fr.hugosimony.pokemontopaze.Variables;

public class BattlerText {

	public static String getText(String battler, int moment) {
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
		return "";
	}
	
}
