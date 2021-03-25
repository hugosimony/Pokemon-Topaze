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
			startGoodAnimation1_10(game, battler, finalAnimation);
	}
	
	public static void startGoodAnimation1_10(Game game, int battler, IntTuple finalAnimation) {
		if(battler == 1) {
			new ExclamationMark(game, game.road01.battler01.getLocation(), true);
			new Timer().schedule(new TimerTask() {
				@Override
				public void run() {
					Game.waitingBattle = "capboy002";
					Game.waitingBattlefield = "GymLeader7";
					Game.waitingWeather = "Good";
					new Timer().schedule(game.road01.battler01.new Move(Direction.UP, true, finalAnimation, "uu",
							Direction.UP, PnjText.getText("capboy002")), 0, 8);
					game.deplacement.setDirection(Direction.DOWN);
					game.deplacement.setStoppedSprites();
					this.cancel();
				}
			}, 1000);
			return;
		}
		else if (battler == 2) {
			new ExclamationMark(game, game.road01.battler02.getLocation(), true);
			new Timer().schedule(new TimerTask() {
				@Override
				public void run() {
					Game.waitingBattle = "campinggirl001";
					Game.waitingBattlefield = "GymLeader7";
					Game.waitingWeather = "Good";
					new Timer().schedule(game.road01.battler02.new Move(Direction.UP, true, finalAnimation, "uuuuu",
							Direction.UP, PnjText.getText("campinggirl001")), 0, 8);
					
					game.deplacement.setDirection(Direction.DOWN);
					game.deplacement.setStoppedSprites();
					this.cancel();
				}
			}, 1000);
			return;
		}
		else if (battler == 3) {
			new ExclamationMark(game, game.road01.battler03.getLocation(), true);
			new Timer().schedule(new TimerTask() {
				@Override
				public void run() {
					Game.waitingBattle = "bugcatcher001";
					Game.waitingBattlefield = "GymLeader7";
					Game.waitingWeather = "Good";
					new Timer().schedule(game.road01.battler03.new Move(Direction.RIGHT, true, finalAnimation, "rrr",
							Direction.RIGHT, PnjText.getText("bugcatcher001")), 0, 8);
					game.deplacement.setDirection(Direction.LEFT);
					game.deplacement.setStoppedSprites();
					this.cancel();
				}
			}, 1000);
			return;
		}
		else if (battler == 4) {
			new ExclamationMark(game, game.road01.battler04.getLocation(), true);
			new Timer().schedule(new TimerTask() {
				@Override
				public void run() {
					Game.waitingBattle = "campingboy001";
					Game.waitingBattlefield = "GymLeader7";
					Game.waitingWeather = "Good";
					new Timer().schedule(game.road01.battler04.new Move(Direction.UP, true, finalAnimation, "uuu",
							Direction.UP, PnjText.getText("campingboy001")), 0, 8);
					game.deplacement.setDirection(Direction.DOWN);
					game.deplacement.setStoppedSprites();
					this.cancel();
				}
			}, 1000);
			return;
		}
	}
	
}
