package fr.hugosimony.pokemontopaze.maps.pnj;

import java.util.Timer;
import java.util.TimerTask;

import fr.hugosimony.pokemontopaze.Const;
import fr.hugosimony.pokemontopaze.Game;
import fr.hugosimony.pokemontopaze.Variables;
import fr.hugosimony.pokemontopaze.maps.Direction;
import fr.hugosimony.pokemontopaze.maps.items.GroundItem;
import fr.hugosimony.pokemontopaze.sounds.Sounds;
import fr.hugosimony.pokemontopaze.utils.IntTuple;

public class PnjAnimations {
	
	public static void checkMapChange(Game game) {
		if(Variables.ADVENTURE_Step == 3) {
			new Timer().schedule(new TimerTask() {
				@Override
				public void run() {
					game.road01.starter1 = new GroundItem("pokeball");
					game.road01.starter1.setVisible(true);
					game.road01.starter1.setLocation(3744, 1738);
					game.clickableTiles.add(new IntTuple(3744, 1738));
					game.walls.add(new IntTuple(3744, 1738));
					game.map.add(game.road01.starter1);
					game.map.repaint();
					Sounds.playSound(Const.soundSelectionMenu);
				}
			}, 100);
			
			return;
		}
		else if(Variables.ADVENTURE_Step == 4) {
			new Timer().schedule(new TimerTask() {
				@Override
				public void run() {
					game.road01.starter2 = new GroundItem("pokeball");
					game.road01.starter2.setVisible(true);
					game.road01.starter2.setLocation(3776, 1738);
					game.clickableTiles.add(new IntTuple(3776, 1738));
					game.walls.add(new IntTuple(3776, 1738));
					game.map.add(game.road01.starter2);
					game.map.repaint();
					Sounds.playSound(Const.soundSelectionMenu);
				}
			}, 100);
			return;
		}
		else if(Variables.ADVENTURE_Step == 5) {
			new Timer().schedule(new TimerTask() {
				@Override
				public void run() {
					game.road01.starter3 = new GroundItem("pokeball");
					game.road01.starter3.setVisible(true);
					game.road01.starter3.setLocation(3808, 1738);
					game.clickableTiles.add(new IntTuple(3808, 1738));
					game.walls.add(new IntTuple(3808, 1738));
					game.map.add(game.road01.starter3);
					game.map.repaint();
					Sounds.playSound(Const.soundSelectionMenu);
				}
			}, 100);
			return;
		}
	}

	public static void startGoodAnimation(Game game, IntTuple finalAnimation) {
		if(Variables.ADVENTURE_Step == 0) {
			Sounds.playSound(Const.soundExclamation);
			new Timer().schedule(new TimerTask() {
				@Override
				public void run() {
					new Timer().schedule(game.myHouse.mom.new Move(Direction.DOWN, true, finalAnimation, "llllllll",
							Direction.UP, PnjText.getText("mom")), 0, 5);
					Variables.ADVENTURE_Step = 1;
					game.myHouse.setAnimations();
					this.cancel();
				}
			}, 1000);
			return;
		}
		else if(Variables.ADVENTURE_Step == 1) {
			Sounds.playSound(Const.soundExclamation);
			new Timer().schedule(new TimerTask() {
				@Override
				public void run() {
					new Timer().schedule(game.road01.profChen.new Move(Direction.RIGHT, true, new IntTuple(3712, 1738), "rrrrrrr", Direction.RIGHT,
							PnjText.getText("profChen")), 0, 5);
					if(game.deplacement.locationY <= 1738)
						new Timer().schedule(game.deplacement.new MoveDirection(Direction.LEFT, false, false, true, new IntTuple(3872, 1738), 
								"dddd", Direction.LEFT), 0, 5);
					else
						new Timer().schedule(game.deplacement.new MoveDirection(Direction.LEFT, false, false, true, new IntTuple(3872, 1738), 
								"uuu", Direction.LEFT), 0, 5);
					Variables.ADVENTURE_Step = 2;
					game.road01.setAnimations();
					this.cancel();
				}
			}, 1000);
			return;
		}
		else if(Variables.ADVENTURE_Step == 2) {
			new Timer().schedule(game.road01.profChen.new Move(Direction.UP, true, new IntTuple(3744, 1706), "r", Direction.DOWN,
					PnjText.getText("profChen")), 0, 5);
			Variables.ADVENTURE_Step = 3;
			return;
		}
		else if(Variables.ADVENTURE_Step == 3) {
			new Timer().schedule(game.road01.profChen.new Move(Direction.RIGHT, true, new IntTuple(3776, 1706), "", Direction.DOWN,
					PnjText.getText("profChen")), 0, 5);
			Variables.ADVENTURE_Step = 4;
			return;
		}
		else if(Variables.ADVENTURE_Step == 4) {
			new Timer().schedule(game.road01.profChen.new Move(Direction.RIGHT, true, new IntTuple(3808, 1706), "", Direction.DOWN,
					PnjText.getText("profChen")), 0, 5);
			Variables.ADVENTURE_Step = 5;
			return;
		}
		else if(Variables.ADVENTURE_Step == 5) {
			new Timer().schedule(game.road01.profChen.new Move(Direction.RIGHT, true, new IntTuple(3840, 1738), "d", Direction.RIGHT,
					PnjText.getText("profChen")), 0, 5);
			Variables.ADVENTURE_Step = 6;
			game.road01.setAnimations();
			return;
		}
		else if(Variables.ADVENTURE_Step == 6) {
			new Timer().schedule(game.road01.profChen.new Move(Direction.DOWN, true, new IntTuple(3712, 1738), "llllu", Direction.RIGHT,
					PnjText.getText("profChen")), 0, 5);
			Variables.ADVENTURE_Step = 7;
			game.road01.setAnimations();
			return;
		}
	}
	
}
