package fr.hugosimony.pokemontopaze.maps.animations;

import java.util.Timer;
import java.util.TimerTask;

import fr.hugosimony.pokemontopaze.Game;
import fr.hugosimony.pokemontopaze.maps.Direction;
import fr.hugosimony.pokemontopaze.maps.pnj.ExclamationMark;
import fr.hugosimony.pokemontopaze.maps.pnj.PnjText;
import fr.hugosimony.pokemontopaze.utils.IntTuple;

public class BattlerAnimations {

	public static void startGoodAnimation(Game game, int battler, IntTuple finalAnimation) {
		game.deplacement.setStoppedSprites();
		if(battler <= 10)
			startGoodAnimation0_10(game, battler, finalAnimation);
	}
	
	public static void startGoodAnimation0_10(Game game, int battler, IntTuple finalAnimation) {
		if(battler == 0) {
			new ExclamationMark(game, game.road01.battler01.getLocation(), true);
			new Timer().schedule(new TimerTask() {
				@Override
				public void run() {
					Game.waitingBattle = "capboy001";
					Game.waitingBattlefield = "GymLeader7";
					Game.waitingWeather = "Good";
					new Timer().schedule(game.road01.battler01.new Move(Direction.UP, true, finalAnimation, "uu",
							Direction.UP, PnjText.getText("capboy001")), 0, 8);
					game.deplacement.hero.direction = Direction.DOWN;
					game.deplacement.setStoppedSprites();
					this.cancel();
				}
			}, 1000);
			return;
		}
		else if (battler == 1) {
			return;
		}
	}
	
}
