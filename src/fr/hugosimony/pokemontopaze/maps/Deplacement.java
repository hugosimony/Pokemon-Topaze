package fr.hugosimony.pokemontopaze.maps;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import fr.hugosimony.pokemontopaze.Const;
import fr.hugosimony.pokemontopaze.Game;
import fr.hugosimony.pokemontopaze.Variables;
import fr.hugosimony.pokemontopaze.maps.items.GroundItem;
import fr.hugosimony.pokemontopaze.maps.perso.Hero;
import fr.hugosimony.pokemontopaze.maps.pnj.Pnj;
import fr.hugosimony.pokemontopaze.menus.TextZone;
import fr.hugosimony.pokemontopaze.menus.XMenu;
import fr.hugosimony.pokemontopaze.sounds.Sounds;
import fr.hugosimony.pokemontopaze.utils.IntTriple;
import fr.hugosimony.pokemontopaze.utils.IntTuple;

public class Deplacement {
	
	private static Timer timer = new Timer();
	
	private Game game;
	
	public Hero hero;
	
	public boolean released;
	public boolean coolDown;
	
	public Direction direction;
	public Direction newDirection;
	public ArrayList<String> pressed;
	
	private int runDirection;
	private int runMove;
	
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
		this.newDirection = direction;
		
		hero = new Hero(direction, 0, 1);
		setSprites(direction, hero, true);
		
		pressed = new ArrayList<String>();
		runDirection = 1;
		runMove = 0;
		
		released = true;
		coolDown = false;
		
		checkIANearDone = false;
	}
	
	public static Direction getDirection(int key) {
		if(key == Variables.CONTROLS_LEFT)
			return Direction.LEFT;
		if(key == Variables.CONTROLS_RIGHT)
			return Direction.RIGHT;
		if(key == Variables.CONTROLS_UP)
			return Direction.UP;
		if(key == Variables.CONTROLS_DOWN)
			return Direction.DOWN;
		return Direction.NULL;
	}
	
	public static Direction getDirection(char c) {
		if(c == 'u')
			return Direction.UP;
		if(c == 'd')
			return Direction.DOWN;
		if(c == 'l')
			return Direction.LEFT;
		if(c == 'r')
			return Direction.RIGHT;
		return Direction.NULL;
	}
	
	public void startMove(Direction direction, boolean auto) {
		if(!game.inAnimation) {
			coolDown = true;
			boolean move = false;
			if(direction == Direction.UP && !IntTuple.contains(game.walls, getLookingTile()) && (!IntTriple.containsTuple(game.jumpWalls, getLookingTile()) 
					|| (IntTriple.containsTuple(game.jumpWalls, getLookingTile()) && !IntTriple.contains(game.jumpWalls, new IntTriple(locationX, locationY - pixelMoved, 1)))) 
					&& IntTuple.containsPnj(game.pnjs, getLookingTile()) == null)
				move = true;
			else if(direction == Direction.DOWN && !IntTuple.contains(game.walls, getLookingTile()) && (!IntTriple.containsTuple(game.jumpWalls, getLookingTile()) 
					|| (IntTriple.containsTuple(game.jumpWalls, getLookingTile()) && !IntTriple.contains(game.jumpWalls, new IntTriple(locationX, locationY + pixelMoved, 2)))) 
					&& IntTuple.containsPnj(game.pnjs, getLookingTile()) == null)
				move = true;
			else if(direction == Direction.LEFT && !IntTuple.contains(game.walls, getLookingTile()) && (!IntTriple.containsTuple(game.jumpWalls, getLookingTile()) 
					|| (IntTriple.containsTuple(game.jumpWalls, getLookingTile()) && !IntTriple.contains(game.jumpWalls, new IntTriple(locationX - pixelMoved, locationY, 3)))) 
					&& IntTuple.containsPnj(game.pnjs, getLookingTile()) == null)
				move = true;
			else if(direction == Direction.RIGHT && !IntTuple.contains(game.walls, getLookingTile()) && (!IntTriple.containsTuple(game.jumpWalls, getLookingTile()) 
					|| (IntTriple.containsTuple(game.jumpWalls, getLookingTile()) && !IntTriple.contains(game.jumpWalls, new IntTriple(locationX + pixelMoved, locationY, 4)))) 
					&& IntTuple.containsPnj(game.pnjs, getLookingTile()) == null)
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
				timer.scheduleAtFixedRate(new MoveDirection(direction, false, Variables.SPEED_PERSO, auto, false, null, null, null, null, false), 0, Variables.SPEED_PERSO);
			}
			else {
				Sounds.playSound(Const.soundPlayerStopped);
				timer.scheduleAtFixedRate(new MoveDirection(direction, true, Variables.SPEED_PERSO, auto, false, null, null, null, null, false), 0, Variables.SPEED_PERSO);
				if(Sounds.canPlayBumpSound) {
					timer.schedule(new TimerTask() {
						@Override
						public void run() {
							Sounds.canPlayBumpSound = true;
							this.cancel();
						}
					}, 1000);
				}
				Sounds.canPlayBumpSound = false;
			}
		}
	}
	
	public class MoveDirection extends TimerTask {

		private Direction dir;
		private boolean justChangeDirection;
		private long speed;
		private boolean auto;
		private boolean inAnimation;
		private IntTuple animationEnd;
		private String animationMoves;
		private Direction finalLookingDirection;
		private String finalText;
		private boolean endAnimation;
		private int x = 0;
		
		public MoveDirection(Direction direction, boolean justChangeDirection, long speed, boolean auto, boolean inAnimation, 
				IntTuple animationEnd, String animationMoves, Direction finalLookingDirection, String finalText, boolean endAnimation) {
			dir = direction;
			this.justChangeDirection = justChangeDirection;
			this.speed = speed;
			this.auto = auto;
			this.inAnimation = inAnimation;
			this.animationEnd = animationEnd;
			this.animationMoves = animationMoves;
			this.finalLookingDirection = finalLookingDirection;
			this.finalText = finalText;
			this.endAnimation = endAnimation;
		}
		
		@Override
		public void run() {
			if(game.actualPanel.isVisible() && !(auto && !game.firstMove)) {
				game.firstMove = true;
				if(!justChangeDirection) {
					if(x<pixelMoved) {
						if(dir == Direction.UP) {
							locationY --;
							mapLocationY ++;
							if(x == 15)
								mapLocationY ++;
						}
						else if(dir == Direction.DOWN) {
							locationY ++;
							mapLocationY --;
							if(x == 15)
								mapLocationY --;
						}
						else if(dir == Direction.LEFT) {
							locationX --;
							mapLocationX ++;
							if(x == 15)
								mapLocationX ++;
						}
						else if(dir == Direction.RIGHT) {
							locationX ++;
							mapLocationX --;
							if(x == 15)
								mapLocationX --;
						}
						hero.setLocation(locationX, locationY);
						if(x==0) {
							mapLocationX = game.map.getLocation().x;
							mapLocationY = game.map.getLocation().y;
							hero.direction = dir;
						}
						else {
							game.map.setLocation(mapLocationX, mapLocationY);
							
							if(speed > 5) {
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
									if(x==10)
										hero.repaint();
								}
							}
							else if(speed == 4){
								hero.speed = 2;
								if(x < 5) {
									hero.foot = 0;
									if(x==1)
										hero.repaint();
								}else {
									if(runMove == 0 || runMove == 2)
										hero.foot = 0;
									else if(runMove == 1)
										hero.foot = 1;
									else
										hero.foot = 2;
									if(x==5)
										hero.repaint();
								}
							}
							else if(speed == 2) {
								hero.speed = 3;
								if(x < 5) {
									hero.foot = 0;
									if(x==1)
										hero.repaint();
								}else {
									if(runMove == 0 || runMove == 2)
										hero.foot = 0;
									else if(runMove == 1)
										hero.foot = 1;
									else
										hero.foot = 2;
									if(x==5)
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
						if(inAnimation) {
							if(locationX == animationEnd.x && locationY == animationEnd.y) {
								game.deplacement.released = true;
								game.deplacement.pressed.clear();
								setDirection(finalLookingDirection);
								setSprites(finalLookingDirection, new Hero(finalLookingDirection, 0, 1), false);
								setSprites(finalLookingDirection, new Hero(finalLookingDirection, 0, 1), false);
								if(endAnimation)
									game.inAnimation = false;
								if(!finalText.equals("")) {
									game.textZone = new TextZone(game.actualPanel, finalText);
									TextZone.printTextZone(game.textZone, game);
								}
								this.cancel();
							}
							else {
								if(animationMoves.length() > 0) {
									x = 0;
									dir = Deplacement.getDirection(animationMoves.charAt(0));
									animationMoves = animationMoves.replaceFirst(animationMoves.charAt(0)+"", "");
									startMove(dir, true);
								}
								else
									this.cancel();
							}
						}
						else {
							checkIANearDone = false;
							if(pressed.size() == 0) {
								if(Variables.SPEED_PERSO == 2)
									setSprites(dir, new Hero(dir, 3, 3), false);
								else
									setSprites(dir, new Hero(dir, 0, 1), false);
							}
							else
								setSprites(dir, new Hero(dir, 0, hero.speed), false);
							runDirection *= -1;
							if(runMove == 3)
								runMove = 0;
							else
								runMove++;
							this.cancel();
							if(!checkAnimations() && !checkMapChange() && game.inXMenu) {
								XMenu.unprintXMenu();
								XMenu.printXMenu();
							}
							coolDown = false;
							checkIANearDone = false;
							if(!released) {
								if(pressed.size() == 1) {
									released = false;
									direction = getDirection(Integer.parseInt(pressed.get(0)));
									newDirection = direction;
									startMove(direction, true);
								}
								else {
									startMove(newDirection, true);
									direction = newDirection;
								}
							}
							else if(newDirection != dir) {
								released = false;
								direction = newDirection;
								startMove(newDirection, true);
							}
							else {
								if(pressed.size() == 1) {
									released = false;
									direction = getDirection(Integer.parseInt(pressed.get(0)));
									newDirection = direction;
									startMove(direction, true);
								}
							}
						}
					}
				}
				else {
					if(Variables.SPEED_PERSO == 2)
						setSprites(dir, new Hero(dir, 3, 3), false);
					else
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
	
	public void setDirection(Direction direction) {
		this.direction = direction;
		this.newDirection = direction;
	}
	
	public void setSprites() {
		setSprites(direction, hero, false);
	}
	
	public void setStoppedSprites() {
		hero.speed = 1;
		hero.foot = 0;
		setSprites(direction, hero, false);
	}
	
	public void setSprites(Direction persoDir, Hero hero_, boolean first) {
		
		ArrayList<Pnj> pnjToRedrawUp = new ArrayList<Pnj>();
		ArrayList<Pnj> pnjToRedrawDown = new ArrayList<Pnj>();
		
		if(!first) {
			for(Pnj pnj : game.pnjs) {
				if(Math.abs(pnj.positionY - locationY) < pixelMoved*2 && Math.abs(pnj.positionX - locationX) < pixelMoved) {
					if(pnj.positionY > locationY)
						pnjToRedrawUp.add(pnj);
					else
						pnjToRedrawDown.add(pnj);
				}
			}
		}
		
		if(first) {
			for(Pnj pnj : game.pnjs) {
				if(pnj.positionY > locationY)
					game.map.add(pnj);
			}
		}
		else if(pnjToRedrawUp.size() != 0){
			for(Component component : game.map.getComponents()) {
				if(component instanceof Pnj) {
					Pnj pnj = (Pnj) component;
					if(!pnj.mooving && pnj.positionY > locationY && Math.abs(pnj.positionY - locationY) < pixelMoved*2 && Math.abs(pnj.positionX - locationX) < pixelMoved) {
						pnj.copyParameters(new Pnj(game, pnj.perso, pnj.direction, pnj.foot, pnj.positionX, pnj.positionY, pnj.IA, false, pnj.directions, pnj.IAMoving, pnj.paraClick, pnj.mooving));
						pnj.repaint();
					}
				}
			}
		}
		
		for(Component component : game.map.getComponents()) {
			if(component instanceof Hero)
				game.map.remove(component);
		}
		
		hero = hero_;
		hero.direction = persoDir;
		hero.setLocation(locationX, locationY);
		hero.setSize(35,50);
		hero.setVisible(true);
		game.map.add(hero);
		hero.repaint();
		
		for(Component component : game.map.getComponents()) {
			if(component instanceof GroundItem) {
				GroundItem gi = (GroundItem) component;
				game.map.remove(gi);
				game.map.add(gi);
				gi.repaint();
			}
		}
		
		if(first) {
			for(Pnj pnj : game.pnjs) {
				if(pnj.positionY <= locationY)
					game.map.add(pnj);
			}
		}
		else if(pnjToRedrawDown.size() != 0){
			for(Component component : game.map.getComponents()) {
				if(component instanceof Pnj) {
					Pnj pnj = (Pnj) component;
					if(!pnj.mooving && pnj.positionY <= locationY && Math.abs(pnj.positionY - locationY) < pixelMoved*2 && Math.abs(pnj.positionX - locationX) < pixelMoved) {
						pnj.copyParameters(new Pnj(game, pnj.perso, pnj.direction, pnj.foot, pnj.positionX, pnj.positionY, pnj.IA, false, pnj.directions, pnj.IAMoving, pnj.paraClick, pnj.mooving));
						game.map.remove(pnj);
						game.map.add(pnj);
					}
				}
			}
		}
		game.map.repaint();
	}
	
	public IntTuple getPosition() {
		return new IntTuple(locationX, locationY);
	}
	
	public IntTuple getLookingTile() {
		int x = 0;
		int y = 0;
		if(newDirection == Direction.UP)
			y -= pixelMoved; 
		else if(newDirection == Direction.DOWN)
			y += pixelMoved; 
		else if(newDirection == Direction.LEFT)
			x -= pixelMoved; 
		else if(newDirection == Direction.RIGHT)
			x += pixelMoved; 
		return new IntTuple(locationX + x, locationY + y);
	}
	
	public IntTuple getActualLookingTile() {
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
	
	private boolean checkAnimations() {
		boolean animation = false;
		animation = game.myHouse != null && game.myHouse.isVisible() && game.myHouse.checkAnimations();
		if(!animation)
			animation = game.road01 != null && game.road01.isVisible() && game.road01.checkAnimations();
		return animation;
	}
	
	private boolean checkMapChange() {
		boolean change = false;
		change = game.myHouse != null && game.myHouse.isVisible() && game.myHouse.checkMapChange();
		if(!change)
			change = game.selenia != null && game.selenia.isVisible() && game.selenia.checkMapChange();
		if(!change)
			change = game.rivalHouse != null && game.rivalHouse.isVisible() &&  game.rivalHouse.checkMapChange();
		if(!change)
			change = game.house01 != null && game.house01.isVisible() && game.house01.checkMapChange();
		if(!change)
			change = game.house02 != null && game.house02.isVisible() && game.house02.checkMapChange();
		if(!change)
			change = game.intertown01 != null && game.intertown01.isVisible() &&  game.intertown01.checkMapChange();
		if(!change)
			change = game.road01 != null && game.road01.isVisible() &&  game.road01.checkMapChange();
		if(!change)
			change = game.intertown02 != null && game.intertown02.isVisible() &&  game.intertown02.checkMapChange();
		if(!change)
			change = game.villaube != null && game.villaube.isVisible() &&  game.villaube.checkMapChange();
		if(!change)
			change = game.pokemonCenter01 != null && game.pokemonCenter01.isVisible() && game.pokemonCenter01.checkMapChange();
		if(!change)
			change = game.mart01 != null && game.mart01.isVisible() && game.mart01.checkMapChange();
		if(!change)
			change = game.house03 != null && game.house03.isVisible() && game.house03.checkMapChange();
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
