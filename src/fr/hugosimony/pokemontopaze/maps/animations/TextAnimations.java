package fr.hugosimony.pokemontopaze.maps.animations;

import java.util.Timer;
import java.util.TimerTask;

import fr.hugosimony.pokemontopaze.Const;
import fr.hugosimony.pokemontopaze.Game;
import fr.hugosimony.pokemontopaze.Variables;
import fr.hugosimony.pokemontopaze.sounds.Sounds;
import fr.hugosimony.pokemontopaze.utils.IntTuple;

public class TextAnimations {

	public static String getTextAfterYesNo(Game game, IntTuple tuple, boolean yes) {
		
		if(Variables.ADVENTURE_Step == 7) {
			if(yes) {
				IntTuple.removeTuple(game.walls, tuple);
				IntTuple.removeTuple(game.clickableTiles, tuple);
				game.inTransition = true;
				Sounds.playSound(Const.soundEvolutionDone);
				new Timer().schedule(new TimerTask() {
					@Override
					public void run() {
						game.inTransition = false;
					}
				}, 4000);
				Variables.ADVENTURE_Step = 8;
				if(tuple.equals(new IntTuple(3744, 1738))) {
					game.road01.starter1.setVisible(false);
					Variables.STARTER = 1;
					return "Vous avez choisi Tortipouss !=+";
				}
				if(tuple.equals(new IntTuple(3776, 1738))) {
					game.road01.starter2.setVisible(false);
					Variables.STARTER = 2;
					return "Vous avez choisi Ouisticram !=+";
				}
				if(tuple.equals(new IntTuple(3808, 1738))) {
					game.road01.starter3.setVisible(false);
					Variables.STARTER = 3;
					return "Vous avez choisi Tiplouf !=+";
				}
			}
			return "";
		}
		
		return "";
	}
	
}
