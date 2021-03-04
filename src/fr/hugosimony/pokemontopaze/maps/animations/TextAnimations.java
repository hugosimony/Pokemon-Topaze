package fr.hugosimony.pokemontopaze.maps.animations;

import fr.hugosimony.pokemontopaze.Game;
import fr.hugosimony.pokemontopaze.Variables;
import fr.hugosimony.pokemontopaze.utils.IntTuple;

public class TextAnimations {

	public static String getTextAfterYesNo(Game game, IntTuple tuple, boolean yes) {
		
		if(Variables.ADVENTURE_Step == 7) {
			if(yes) {
				IntTuple.removeTuple(game.walls, tuple);
				IntTuple.removeTuple(game.clickableTiles, tuple);
				Variables.ADVENTURE_Step = 8;
				if(tuple.equals(new IntTuple(3744, 1738))) {
					game.road01.starter1.setVisible(false);
					return "Vous avez choisi Tortipouss !+";
				}
				if(tuple.equals(new IntTuple(3776, 1738))) {
					game.road01.starter2.setVisible(false);
					return "Vous avez choisi Ouisticram !+";
				}
				if(tuple.equals(new IntTuple(3808, 1738))) {
					game.road01.starter3.setVisible(false);
					return "Vous avez choisi Tiplouf !+";
				}
			}
			return "";
		}
		
		return "";
	}
	
}
