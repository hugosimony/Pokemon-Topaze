package fr.hugosimony.pokemoncancer.maps;

import java.util.Timer;
import java.util.TimerTask;

import fr.hugosimony.pokemoncancer.Game;
import fr.hugosimony.pokemoncancer.Variables;
import fr.hugosimony.pokemoncancer.maps.perso.Hero;
import fr.hugosimony.pokemoncancer.maps.perso.Pnj;
import fr.hugosimony.pokemoncancer.menus.XMenu;
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
	
	public int pixelMoved = 32;
	public int locationX = 375;
	public int locationY = 300;
	public int mapLocationX;
	public int mapLocationY;
	
	public Deplacement(Game game, int locationX, int locationY, Direction direction) {
		
		this.game = game;
		this.locationX = locationX;
		this.locationY = locationY;
		
		hero = new Hero(direction, 0, 1);
		setSprites(direction);
		
		direction = Direction.DOWN;
		newDirection = Direction.DOWN;
		runDirection = 1;
		
		released = true;
		coolDown = false;
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
		if(direction == Direction.UP && !IntTuple.contains(game.walls, new IntTuple(locationX, locationY - pixelMoved)) && !IntTuple.containsPnj(game.pnjs, new IntTuple(locationX, locationY - pixelMoved)))
			move = true;
		else if(direction == Direction.DOWN && !IntTuple.contains(game.walls, new IntTuple(locationX, locationY + pixelMoved))  && !IntTuple.containsPnj(game.pnjs, new IntTuple(locationX, locationY + pixelMoved)))
			move = true;
		else if(direction == Direction.LEFT && !IntTuple.contains(game.walls, new IntTuple(locationX - pixelMoved, locationY)) && !IntTuple.containsPnj(game.pnjs, new IntTuple(locationX - pixelMoved, locationY)))
			move = true;
		else if(direction == Direction.RIGHT && !IntTuple.contains(game.walls, new IntTuple(locationX + pixelMoved, locationY)) && !IntTuple.containsPnj(game.pnjs, new IntTuple(locationX + pixelMoved, locationY)))
			move = true;
		if(move)
			timer.schedule(new MoveDirection(direction, false, auto), 0, Variables.SPEED_PERSO);
		else
			timer.schedule(new MoveDirection(direction, true, auto), 0, Variables.SPEED_PERSO);
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
						if(x==0) {
							mapLocationX = game.map.getLocation().x;
							mapLocationY = game.map.getLocation().y;
						}
						if(x>=1) {
							
							game.map.setLocation(mapLocationX, mapLocationY);
							
							for(Pnj pnj : game.pnjs) {
								if(pnj.positionY > locationY)
									game.map.add(pnj);
							}
							
							hero.setVisible(false);
							if(Variables.SPEED_PERSO == 5) {
								if(x < 10)
									hero = new Hero(dir, 0, 1);
								else if(runDirection == 1)
									hero = new Hero(dir, 1, 1);
								else if(runDirection == -1)
									hero = new Hero(dir, 2, 1);
							}
							else if(Variables.SPEED_PERSO == 3){
								if(x < 10)
									hero = new Hero(dir, 0, 2);
								else if(runDirection == 1)
									hero = new Hero(dir, 1, 2);
								else if(runDirection == -1)
									hero = new Hero(dir, 2, 2);
							}
							hero.setLocation(locationX, locationY);
							hero.setSize(50,70);
							hero.setVisible(true);
							game.map.add(hero);
							
							for(Pnj pnj : game.pnjs) {
								if(pnj.positionY <= locationY)
									game.map.add(pnj);
							}
						}
						else 
							hero.setLocation(locationX, locationY);
						
						x++;
					}
					else {
						setSprites(dir);
						runDirection *= -1;
						this.cancel();
						if(!checkMapChange() && game.inXMenu) {
							XMenu.unprintXMenu();
							XMenu.printXMenu();
						}
						coolDown = false;
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
					setSprites(dir);
					coolDown = false;
					this.cancel();
				}
			}
			else 
				this.cancel();
		}
	}
	
	public void setSprites(Direction persoDir) {
		
		game.map.removeAll();
		
		for(Pnj pnj : game.pnjs) {
			if(pnj.positionY > locationY)
				game.map.add(pnj);
		}
		
		hero.setVisible(false);
		hero = new Hero(persoDir, 0, 1);
		hero.setLocation(locationX, locationY);
		hero.setSize(50,70);
		hero.setVisible(true);
		game.map.add(hero);
		hero.setVisible(false);
		hero = new Hero(persoDir, 0, 1);
		hero.setLocation(locationX, locationY);
		hero.setSize(50,70);
		hero.setVisible(true);
		game.map.add(hero);
		
		for(Pnj pnj : game.pnjs) {
			if(pnj.positionY <= locationY)
				game.map.add(pnj);
		}
		
		game.map.validate();
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
		if(!change) {
			change = game.selenia != null && game.selenia.checkMapChange();
		}
		return change;
	}
		
	
}
