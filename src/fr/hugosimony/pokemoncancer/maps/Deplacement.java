package fr.hugosimony.pokemoncancer.maps;

import java.awt.Component;
import java.util.Timer;
import java.util.TimerTask;

import fr.hugosimony.pokemoncancer.Const;
import fr.hugosimony.pokemoncancer.Game;
import fr.hugosimony.pokemoncancer.Variables;
import fr.hugosimony.pokemoncancer.maps.perso.Hero;
import fr.hugosimony.pokemoncancer.maps.perso.Pnj;
import fr.hugosimony.pokemoncancer.menus.XMenu;
import fr.hugosimony.pokemoncancer.sounds.Sounds;
import fr.hugosimony.pokemoncancer.utils.IntTriple;
import fr.hugosimony.pokemoncancer.utils.IntTuple;

public class Deplacement {
	
	private static Timer timer = new Timer();
	
	private Game game;
	
	public Hero hero;
	
	public boolean released;
	public boolean coolDown;
	
	public Direction direction;
	public Direction newDirection;
	
	private int runDirection;
	
	public static int pixelMoved = 32;
	public int locationX = 375;
	public int locationY = 300;
	public int mapLocationX;
	public int mapLocationY;
	
	private boolean checkIANearDone;
	
	public Deplacement(Game game, int locationX, int locationY, Direction direction, int mapLocationX, int mapLocationY) {
		
		this.game = game;
		this.locationX = locationX;
		this.locationY = locationY;
		this.mapLocationX = mapLocationX;
		this.mapLocationY = mapLocationY;
		this.direction = direction;
		
		hero = new Hero(direction, 0, 1);
		setSprites(direction, hero, true);
		
		direction = Direction.DOWN;
		newDirection = Direction.DOWN;
		runDirection = 1;
		
		released = true;
		coolDown = false;
		
		checkIANearDone = false;
	}
	
	public Direction getDirection(int key) {
		if(key == Variables.CONTROLS_LEFT)
			return Direction.LEFT;
		if(key == Variables.CONTROLS_RIGHT)
			return Direction.RIGHT;
		if(key == Variables.CONTROLS_UP)
			return Direction.UP;
		if(key == Variables.CONTROLS_DOWN)
			return Direction.DOWN;
		return null;
	}
	
	public void startMove(Direction direction, boolean auto) {
		coolDown = true;
		boolean move = false;
		if(direction == Direction.UP && !IntTuple.contains(game.walls, getLookingTile()) && (!IntTriple.containsTuple(game.jumpWalls, getLookingTile()) || (IntTriple.containsTuple(game.jumpWalls, getLookingTile()) && !IntTriple.contains(game.jumpWalls, new IntTriple(locationX, locationY - pixelMoved, 1)))) && IntTuple.containsPnj(game.pnjs, getLookingTile()) == null)
			move = true;
		else if(direction == Direction.DOWN && !IntTuple.contains(game.walls, getLookingTile()) && (!IntTriple.containsTuple(game.jumpWalls, getLookingTile()) || (IntTriple.containsTuple(game.jumpWalls, getLookingTile()) && !IntTriple.contains(game.jumpWalls, new IntTriple(locationX, locationY + pixelMoved, 2)))) && IntTuple.containsPnj(game.pnjs, getLookingTile()) == null)
			move = true;
		else if(direction == Direction.LEFT && !IntTuple.contains(game.walls, getLookingTile()) && (!IntTriple.containsTuple(game.jumpWalls, getLookingTile()) || (IntTriple.containsTuple(game.jumpWalls, getLookingTile()) && !IntTriple.contains(game.jumpWalls, new IntTriple(locationX - pixelMoved, locationY, 3)))) && IntTuple.containsPnj(game.pnjs, getLookingTile()) == null)
			move = true;
		else if(direction == Direction.RIGHT && !IntTuple.contains(game.walls, getLookingTile()) && (!IntTriple.containsTuple(game.jumpWalls, getLookingTile()) || (IntTriple.containsTuple(game.jumpWalls, getLookingTile()) && !IntTriple.contains(game.jumpWalls, new IntTriple(locationX + pixelMoved, locationY, 4)))) && IntTuple.containsPnj(game.pnjs, getLookingTile()) == null)
			move = true;
		if(move) {
			
			//**********************************************************
			// Check Sounds / Herbs Check
			
			if(IntTriple.containsTuple(game.herbs, getLookingTile())) {
				Sounds.playSound(Const.soundOverHerbs);
				// Check Encounter
			}
			if(IntTriple.containsTuple(game.jumpWalls, new IntTuple(locationX, locationY)) && Direction.getOpositeDirection(Direction.getGoodDirectionFromInt(IntTriple.getTripleFromTuple(game.jumpWalls, new IntTuple(locationX, locationY)).z)) == direction)
				Sounds.playSound(Const.soundPlayerJump);
			
			//**********************************************************
			timer.schedule(new MoveDirection(direction, false, auto), 0, Variables.SPEED_PERSO);
		}
		else {
			Sounds.playSound(Const.soundPlayerStopped);
			timer.schedule(new MoveDirection(direction, true, auto), 0, Variables.SPEED_PERSO);
		}
			
	}
	
	private class MoveDirection extends TimerTask {

		private Direction dir;
		private boolean justChangeDirection;
		private boolean auto;
		private int x = 0;
		
		public MoveDirection(Direction direction, boolean justChangeDirection, boolean auto) {
			dir = direction;
			this.justChangeDirection = justChangeDirection;
			this.auto = auto;
		}
		
		@Override
		public void run() {
			if(game.actualPanel.isVisible() && !(auto && !game.firstMove)) {
				game.firstMove = true;
				if(!justChangeDirection) {
					if(x<pixelMoved) {
						if(dir == Direction.UP) {
							mapLocationY ++;
							locationY --;
						}
						else if(dir == Direction.DOWN) {
							mapLocationY --;
							locationY ++;
						}
						else if(dir == Direction.LEFT) {
							mapLocationX ++;
							locationX --;
						}
						else if(dir == Direction.RIGHT) {
							mapLocationX --;
							locationX ++;
						}
						hero.setLocation(locationX, locationY);
						if(x==0) {
							mapLocationX = game.map.getLocation().x;
							mapLocationY = game.map.getLocation().y;
							hero.direction = dir;
						}
						else {
							game.map.setLocation(mapLocationX, mapLocationY);
							
							if(Variables.SPEED_PERSO == 5) {
								hero.speed = 1;
								if(x < 10) {
									hero.foot = 0;
									if(x==1)
										hero.repaint();
								}else {
									if(runDirection == 1) 
										hero.foot = 1;
									else if(runDirection == -1) 
										hero.foot = 2;
									if(x==9)
										hero.repaint();
								}
							}
							else if(Variables.SPEED_PERSO == 3){
								hero.speed = 2;
								if(x < 10) {
									hero.foot = 0;
									if(x==1)
										hero.repaint();
								}else {
									if(runDirection == 1) 
										hero.foot = 1;
									else if(runDirection == -1) 
										hero.foot = 2;
									if(x==9)
										hero.repaint();
								}
							}
						}
						if(isIANear() && !checkIANearDone) {
							checkIANearDone = true;
							setSprites(direction, hero, false);
						}
						x++;
					}
					else {
						checkIANearDone = false;
						setSprites(dir, new Hero(dir, 0, 1), false);
						runDirection *= -1;
						this.cancel();
						if(!checkMapChange() && game.inXMenu) {
							XMenu.unprintXMenu();
							XMenu.printXMenu();
						}
						coolDown = false;
						checkIANearDone = false;
						if(!released)
							startMove(newDirection, true);
						else if(newDirection != dir) {
							released = false;
							direction = newDirection;
							startMove(newDirection, true);
						}
					}
				}
				else {
					setSprites(dir, new Hero(dir, 0, 1), false);
					coolDown = false;
					checkIANearDone = false;
					this.cancel();
				}
			}
			else 
				this.cancel();
		}
	}
	
	public void setSprites(Direction persoDir, Hero hero_, boolean first) {
		
		if(first) {
			for(Pnj pnj : game.pnjs) {
				if(pnj.positionY > locationY)
					game.map.add(pnj);
			}
		}
		else {
			for(Component component : game.map.getComponents()) {
				if(component instanceof Hero)
					game.map.remove(component);
			}
			
			for(Component component : game.map.getComponents()) {
				if(component instanceof Pnj) {
					Pnj pnj = (Pnj) component;
					if(!pnj.mooving && pnj.positionY > locationY && Math.abs(pnj.positionY - locationY) < pixelMoved*2 && Math.abs(pnj.positionX - locationX) < pixelMoved) {
						game.map.remove(pnj);
						pnj = new Pnj(game, pnj.perso, pnj.direction, pnj.foot, pnj.positionX, pnj.positionY, pnj.IA, false, pnj.directions, pnj.IAMoving, pnj.paraClick, pnj.mooving);
						pnj.setLocation(pnj.positionX, pnj.positionY);
						pnj.setSize(50,70);
						pnj.setVisible(true);
						game.map.add(pnj);
					}
				}
			}
		}
		
		hero = hero_;
		hero.setLocation(locationX, locationY);
		hero.setSize(50,70);
		hero.setVisible(true);
		game.map.add(hero);
		
		if(first) {
			for(Pnj pnj : game.pnjs) {
				if(pnj.positionY <= locationY)
					game.map.add(pnj);
			}
		}
		else {
			for(Component component : game.map.getComponents()) {
				if(component instanceof Pnj) {
					Pnj pnj = (Pnj) component;
					if(!pnj.mooving && pnj.positionY <= locationY && Math.abs(pnj.positionY - locationY) < pixelMoved*2 && Math.abs(pnj.positionX - locationX) < pixelMoved) {
						game.map.remove(pnj);
						pnj = new Pnj(game, pnj.perso, pnj.direction, pnj.foot, pnj.positionX, pnj.positionY, pnj.IA, false, pnj.directions, pnj.IAMoving, pnj.paraClick, pnj.mooving);
						pnj.setLocation(pnj.positionX, pnj.positionY);
						pnj.setSize(50,70);
						pnj.setVisible(true);
						game.map.add(pnj);
					}
				}
			}
		}
		
		
		game.map.repaint();
	}
	
	public IntTuple getLookingTile() {
		int x = 0;
		int y = 0;
		if(direction == Direction.UP)
			y -= pixelMoved; 
		else if(direction == Direction.DOWN)
			y += pixelMoved; 
		else if(direction == Direction.LEFT)
			x -= pixelMoved; 
		else if(direction == Direction.RIGHT)
			x += pixelMoved; 
		return new IntTuple(locationX + x, locationY + y);
	}
	
	private boolean checkMapChange() {
		boolean change = false;
		change = game.myHouse != null && game.myHouse.checkMapChange();
		if(!change)
			change = game.selenia != null && game.selenia.checkMapChange();
		if(!change)
			change = game.intertown1 != null && game.intertown1.checkMapChange();
		if(!change)
			change = game.road01 != null && game.road01.checkMapChange();
		return change;
	}
		
	public boolean isIANear() {
		boolean yes = false;
		int i = 0;
		while(!yes && i<game.pnjs.size()) {
			yes = Math.abs(game.pnjs.get(i).positionY - locationY) < pixelMoved*2 && Math.abs(game.pnjs.get(i).positionX - locationX) < pixelMoved;
			i++;
		}
		return yes;
	}
	
}
