package fr.hugosimony.pokemontopaze.maps.animations;

import java.util.Timer;
import java.util.TimerTask;

import fr.hugosimony.pokemontopaze.Const;
import fr.hugosimony.pokemontopaze.Game;
import fr.hugosimony.pokemontopaze.Variables;
import fr.hugosimony.pokemontopaze.maps.Direction;
import fr.hugosimony.pokemontopaze.maps.items.GroundItem;
import fr.hugosimony.pokemontopaze.maps.pnj.ExclamationMark;
import fr.hugosimony.pokemontopaze.maps.pnj.Pnj;
import fr.hugosimony.pokemontopaze.maps.pnj.PnjText;
import fr.hugosimony.pokemontopaze.menus.TextZone;
import fr.hugosimony.pokemontopaze.pokemon.PKM;
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
		if(Variables.ADVENTURE_Step <= 10)
			startGoodAnimation0_10(game, finalAnimation);
		else if(Variables.ADVENTURE_Step > 10 && Variables.ADVENTURE_Step <= 20)
			startGoodAnimation11_20(game, finalAnimation);
	}
	
	public static void startGoodAnimation0_10(Game game, IntTuple finalAnimation) {
		if(Variables.ADVENTURE_Step == 0) {
			Sounds.playSound(Const.soundExclamation);
			new ExclamationMark(game, game.myHouse.mom.getLocation());
			new Timer().schedule(new TimerTask() {
				@Override
				public void run() {
					new Timer().schedule(game.myHouse.mom.new Move(Direction.DOWN, true, finalAnimation, "llllllll",
							Direction.UP, PnjText.getText("mom")), 0, 7);
					Variables.ADVENTURE_Step = 1;
					game.myHouse.setAnimations();
					this.cancel();
				}
			}, 1000);
			return;
		}
		else if(Variables.ADVENTURE_Step == 1) {
			Sounds.playSound(Const.soundExclamation);
			new ExclamationMark(game, game.road01.profChen.getLocation());
			new Timer().schedule(new TimerTask() {
				@Override
				public void run() {
					new Timer().schedule(game.road01.profChen.new Move(Direction.RIGHT, true, new IntTuple(3712, 1738), "rrrrrrr", Direction.RIGHT,
							PnjText.getText("profChen")), 0, 7);
					if(game.deplacement.locationY <= 1738)
						new Timer().schedule(game.deplacement.new MoveDirection(Direction.LEFT, false, false, true, new IntTuple(3872, 1738), 
								"dddd", Direction.LEFT, "", false), 0, 7);
					else
						new Timer().schedule(game.deplacement.new MoveDirection(Direction.LEFT, false, false, true, new IntTuple(3872, 1738), 
								"uuu", Direction.LEFT, "", false), 0, 7);
					Variables.ADVENTURE_Step = 2;
					game.road01.setAnimations();
					this.cancel();
				}
			}, 1000);
			return;
		}
		else if(Variables.ADVENTURE_Step == 2) {
			new Timer().schedule(game.road01.profChen.new Move(Direction.UP, true, new IntTuple(3744, 1706), "r", Direction.DOWN,
					PnjText.getText("profChen")), 300, 7);
			Variables.ADVENTURE_Step = 3;
			return;
		}
		else if(Variables.ADVENTURE_Step == 3) {
			new Timer().schedule(game.road01.profChen.new Move(Direction.RIGHT, true, new IntTuple(3776, 1706), "", Direction.DOWN,
					PnjText.getText("profChen")), 900, 7);
			Variables.ADVENTURE_Step = 4;
			return;
		}
		else if(Variables.ADVENTURE_Step == 4) {
			new Timer().schedule(game.road01.profChen.new Move(Direction.RIGHT, true, new IntTuple(3808, 1706), "", Direction.DOWN,
					PnjText.getText("profChen")), 900, 7);
			Variables.ADVENTURE_Step = 5;
			return;
		}
		else if(Variables.ADVENTURE_Step == 5) {
			new Timer().schedule(game.road01.profChen.new Move(Direction.RIGHT, true, new IntTuple(3840, 1738), "d", Direction.RIGHT,
					PnjText.getText("profChen")), 900, 7);
			Variables.ADVENTURE_Step = 6;
			game.road01.setAnimations();
			return;
		}
		else if(Variables.ADVENTURE_Step == 6) {
			new Timer().schedule(game.road01.profChen.new Move(Direction.DOWN, true, new IntTuple(3712, 1738), "llllu", Direction.RIGHT,
					PnjText.getText("profChen")), 300, 7);
			Variables.ADVENTURE_Step = 7;
			game.road01.setAnimations();
			return;
		}
		else if(Variables.ADVENTURE_Step == 8) {
			new ExclamationMark(game, game.road01.profChen.getLocation());
			if(finalAnimation.y == 1738)
				new Timer().schedule(game.road01.profChen.new Move(Direction.UP, true, new IntTuple(finalAnimation.x - 32, 1738), "rrrd", Direction.RIGHT, 
							PnjText.getText("profChen")), 1000, 7);
			else if(finalAnimation.y == 1706)
				new Timer().schedule(game.road01.profChen.new Move(Direction.UP, true, new IntTuple(finalAnimation.x - 32, 1706), "rrrr", Direction.RIGHT, 
						PnjText.getText("profChen")), 1000, 7);
			else 
				new Timer().schedule(game.road01.profChen.new Move(Direction.DOWN, true, new IntTuple(finalAnimation.x - 32, 1770), "rrrr", Direction.RIGHT, 
						PnjText.getText("profChen")), 1000, 7);
			Variables.ADVENTURE_Step = 9;
			game.road01.setAnimations();
			return;
		}
		else if(Variables.ADVENTURE_Step == 9) {
			new Timer().schedule(new TimerTask() {
				@Override
				public void run() {
					game.road01.rival = new Pnj(game, "rival", Direction.UP, 0, 4064, 1802, false, false, null, null, false, false);
					game.road01.rival.setLocation(4064, 1802);
					game.road01.rival.setSize(35, 50);
					game.pnjs.add(game.road01.rival);
					Sounds.playSound(Const.soundLeaveHouse);
					new ExclamationMark(game, game.road01.profChen.getLocation());
					new ExclamationMark(game, game.deplacement.hero.getLocation());
					game.road01.rival.setSprites(game.road01.rival);
					new Timer().schedule(new TimerTask() {
						@Override
						public void run() {
							game.deplacement.hero.direction = Direction.RIGHT;
							game.deplacement.setSprites();
							this.cancel();
						}
					}, 500);
					new Timer().schedule(new TimerTask() {
						@Override
						public void run() {
							new Timer().schedule(game.road01.rival.new Move(Direction.UP, true, new IntTuple(3936, 1770), "llll", Direction.LEFT, 
									PnjText.getText("rival")), 1000, 7);
							Variables.ADVENTURE_Step = 10;
							game.road01.setAnimations();
							this.cancel();
						}
					}, 1000);
					this.cancel();
				}
			}, 750);
			return;
		}
		else if(Variables.ADVENTURE_Step == 10) {
			int finalX = 3808;
			if(PKM.getOppositeStarter(Variables.STARTER) == 1)
				finalX = 3744;
			if(PKM.getOppositeStarter(Variables.STARTER) == 2)
				finalX = 3776;
			if(finalAnimation.y == 1770) {
				new Timer().schedule(game.road01.rival.new Move(Direction.UP, true, new IntTuple(finalX, 1706), "ulllllll", Direction.DOWN, 
						PnjText.getText("rival")), 1000, 7);	
				new Timer().schedule(new TimerTask() {
					@Override
					public void run() {
						game.road01.profChen.direction = Direction.UP;
						game.deplacement.hero.direction = Direction.UP;
						game.road01.profChen.setSprites(game.road01.profChen);
						this.cancel();
					}
				}, 2000);
			}
			else if(finalAnimation.y == 1738) {
				new Timer().schedule(game.road01.rival.new Move(Direction.DOWN, true, new IntTuple(finalX, 1770), "llllllu", Direction.UP, 
						PnjText.getText("rival")), 1000, 7);
				new Timer().schedule(new TimerTask() {
					@Override
					public void run() {
						game.road01.profChen.direction = Direction.DOWN;
						game.deplacement.hero.direction = Direction.DOWN;
						game.road01.profChen.setSprites(game.road01.profChen);
						this.cancel();
					}
				}, 1500);
				new Timer().schedule(new TimerTask() {
					@Override
					public void run() {
						game.road01.profChen.direction = Direction.LEFT;
						game.deplacement.hero.direction = Direction.LEFT;
						game.road01.profChen.setSprites(game.road01.profChen);
						this.cancel();
					}
				}, 2500);
			}
			else {
				new Timer().schedule(game.road01.rival.new Move(Direction.LEFT, true, new IntTuple(finalX, 1770), "llllll", Direction.UP, 
						PnjText.getText("rival")), 1000, 7);
				new Timer().schedule(new TimerTask() {
					@Override
					public void run() {
						game.road01.profChen.direction = Direction.DOWN;
						game.deplacement.hero.direction = Direction.DOWN;
						game.road01.profChen.setSprites(game.road01.profChen);
						this.cancel();
					}
				}, 1700);
			}
			Variables.ADVENTURE_Step = 11;
			game.road01.setAnimations();
			return;
		}
	}
	
	public static void startGoodAnimation11_20(Game game, IntTuple finalAnimation) {
		
		if(Variables.ADVENTURE_Step == 11) {
			IntTuple.removeTuple(game.walls, new IntTuple(game.road01.rival.positionX, 1738));
			IntTuple.removeTuple(game.clickableTiles, new IntTuple(game.road01.rival.positionX, 1738));
			int oppositeStarter = PKM.getOppositeStarter(Variables.STARTER);
			if(oppositeStarter == 1)
				game.road01.starter1.setVisible(false);
			else if(oppositeStarter == 2)
				game.road01.starter2.setVisible(false);
			else
				game.road01.starter3.setVisible(false);
			String text = PnjText.getText("profChen");
			new Timer().schedule(new TimerTask() {
				@Override
				public void run() {
					game.textZone = new TextZone(game.actualPanel, text);
					TextZone.printTextZone(game.textZone, game);
					this.cancel();
				}
			}, 1000);
			Variables.ADVENTURE_Step = 12;
			game.road01.setAnimations();
			return;
		}
		else if(Variables.ADVENTURE_Step == 12) {
			if(Variables.STARTER == 1) {
				if(finalAnimation.y == 1770)
					new Timer().schedule(game.road01.profChen.new Move(Direction.DOWN, true, new IntTuple(3808, 1770), "rrru", Direction.UP, 
							PnjText.getText("profChen")), 1000, 7);
				else
					new Timer().schedule(game.road01.profChen.new Move(Direction.DOWN, true, new IntTuple(3808, 1770), "ddrrru", Direction.UP, 
							PnjText.getText("profChen")), 1000, 7);
			}
			else {
				new Timer().schedule(new TimerTask() {
					@Override
					public void run() {
						PnjAnimations.startGoodAnimation(game, new IntTuple(game.deplacement.locationX, game.deplacement.locationY));
						this.cancel();
					}
				}, 100);
			}
			Variables.ADVENTURE_Step = 13;
			return;
		}
		else if(Variables.ADVENTURE_Step == 13) {
			String text = PnjText.getText("profChen");
			new Timer().schedule(new TimerTask() {
				@Override
				public void run() {
					game.road01.starter1.setVisible(false);
					game.road01.starter2.setVisible(false);
					game.road01.starter3.setVisible(false);
					if(game.deplacement.locationY == 1738) {
						IntTuple.removeTuple(game.walls, new IntTuple(game.road01.profChen.positionX - 32, 1738));
						IntTuple.removeTuple(game.clickableTiles, new IntTuple(game.road01.rival.positionX - 32, 1738));
					}
					else {
						IntTuple.removeTuple(game.walls, new IntTuple(game.road01.profChen.positionX, 1738));
						IntTuple.removeTuple(game.clickableTiles, new IntTuple(game.road01.rival.positionX, 1738));
					}
					new Timer().schedule(new TimerTask() {
						@Override
						public void run() {
							game.textZone = new TextZone(game.actualPanel, text);
							TextZone.printTextZone(game.textZone, game);
							this.cancel();
						}
					}, 1000);
					this.cancel();
				}
			}, 1000);
			Variables.ADVENTURE_Step = 14;
			return;
		}
		else if(Variables.ADVENTURE_Step == 14) {
			if(Variables.STARTER == 1) {
				new Timer().schedule(game.road01.profChen.new Move(Direction.DOWN, true, new IntTuple(3328, game.road01.profChen.positionY + 32), 
						"lllllllllllllll", Direction.LEFT, PnjText.getText("profChen")), 1000, 7);
			}
			else {
				if(game.road01.profChen.positionY == 1738)
					new Timer().schedule(game.road01.profChen.new Move(Direction.UP, true, new IntTuple(3360, game.road01.profChen.positionY - 32), 
							"llllllllllllll", Direction.LEFT, PnjText.getText("profChen")), 1000, 7);
				else
					new Timer().schedule(game.road01.profChen.new Move(Direction.LEFT, true, new IntTuple(3360, game.road01.profChen.positionY), 
							"llllllllllllll", Direction.LEFT, PnjText.getText("profChen")), 1000, 7);
			}
			Variables.ADVENTURE_Step = 15;
			return;
		}
	}
	
}
