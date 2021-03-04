package fr.hugosimony.pokemontopaze.maps.pnj;

import java.awt.Component;
import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

import fr.hugosimony.pokemontopaze.Const;
import fr.hugosimony.pokemontopaze.Game;
import fr.hugosimony.pokemontopaze.maps.Deplacement;
import fr.hugosimony.pokemontopaze.maps.Direction;
import fr.hugosimony.pokemontopaze.menus.TextZone;
import fr.hugosimony.pokemontopaze.utils.IntTuple;

public class Pnj extends JPanel {
	private static final long serialVersionUID = 1L;

	public Game game;
	
	private Pnj pnj;
	public boolean IA;
	public IAMoving IAMoving;
	public boolean paraClick;
	public boolean mooving;
	
	public String perso;
	public Direction direction;
	public int[][] directions;
	public int foot;
	public int positionX;
	public int positionY;

	private int walkDirection = 1;
	
	private boolean checkAnyoneNearDone;
	
	public Pnj(Game game, String perso, Direction direction, int foot, int positionX, int positionY, boolean IA, boolean firstIA, int[][] directions, IAMoving IAMoving, boolean paraClick, boolean mooving) {
		this.game = game;
		this.pnj = this;
		this.perso = perso;
		this.direction = direction;
		this.directions = directions;
		this.foot = foot;
		this.positionX = positionX;
		this.positionY = positionY;
		this.IA = IA;
		if(IA && firstIA) {
			this.IAMoving = new IAMoving(pnj, directions);
			new Timer().schedule(this.IAMoving, 1, 1);
		}
		else
			this.IAMoving = IAMoving;
		this.paraClick = paraClick;
		this.mooving = mooving;
		checkAnyoneNearDone = false;
		setOpaque(false);
		setLayout(null);
		setVisible(true);
	}
	
	public class Move extends TimerTask {

		private Direction dir;
		private boolean animation;
		private IntTuple animationEnd;
		private String animationMoves;
		private Direction finalLookingDirection;
		private String finalText;
		private int x = 0;
		
		public Move(Direction direction, boolean animation, IntTuple animationEnd, String animationMoves, Direction finalLookingDirection, String finalText) {
			dir = direction;
			this.animation = animation;
			this.animationEnd = animationEnd;
			this.animationMoves = animationMoves;
			this.finalLookingDirection = finalLookingDirection;
			this.finalText = finalText;
		}
		
		@Override
		public void run() {
			if(game.actualPanel.isVisible()) {
				mooving = true;
				if(!game.inXMenu && !game.inSaveMenu && !game.inTextMenu && !game.inYesNoMenu && !game.inBattle) {
					
					if(x<Deplacement.pixelMoved) {
						
						if(dir == Direction.UP)
							positionY --;
						else if(dir == Direction.DOWN)
							positionY ++;
						else if(dir == Direction.LEFT)
							positionX --;
						else if(dir == Direction.RIGHT)
							positionX ++;
						setLocation(positionX, positionY);
						repaint();
						if(x==0)
							direction = dir;
						else {
							if(x < 10) {
								foot = 0;
								if(x==1)
									repaint();
							}else {
								if(walkDirection == 1) 
									foot = 1;
								else if(walkDirection == -1) 
									foot = 2;
								if(x==9)
									repaint();
							}
						}
						setSprites(new Pnj(game, perso, dir, foot, positionX, positionY, IA, false, directions, IAMoving, paraClick, true));
						
						if(isAnyoneNear() && !checkAnyoneNearDone) {
							checkAnyoneNearDone = true;
							//setSprites(new Pnj(game, perso, dir, foot, positionX, positionY, IA, false, directions, IAMoving, paraClick, true));
						}
						x++;
					}
					else {
						setSprites(new Pnj(game, perso, dir, 0, positionX, positionY, IA, false, directions, IAMoving, paraClick, false));
						walkDirection *= -1;
						mooving = false;
						checkAnyoneNearDone = false;
						if(animation) {
							if(pnj.getLocation().x == animationEnd.x && pnj.getLocation().y == animationEnd.y) {
								game.inAnimation = false;
								setSprites(new Pnj(game, perso, finalLookingDirection, 0, positionX, positionY, IA, false, directions, IAMoving, paraClick, false));
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
									animationMoves.replaceFirst(animationMoves.charAt(0)+"", "");
								}
								else {
									System.out.println("The moves are wrong.");
									this.cancel();
								}
							}
						}
						else 
							this.cancel();
					}
				}
			}
			else 
				this.cancel();
		}
	}
	
	public void setSprites(Pnj pnj_) {
		
		for(Component component : game.map.getComponents()) {
			if(component instanceof Pnj) {
				Pnj pnj__ = (Pnj) component;
				if(pnj__.perso.equals(pnj.perso)) {
					game.map.remove(component);
				}
			}
		}
		pnj = pnj_;
		pnj.setLocation(positionX, positionY);
		pnj.setSize(50,70);
		pnj.setVisible(true);
		game.map.add(pnj);
	
		
		int i = 0;
		boolean done = false;
		while(!done && i < game.pnjs.size()) {
			if(game.pnjs.get(i).perso.equals(pnj.perso)) {
				game.pnjs.remove(i);
				done = true;
			}
			i++;
		}
		game.pnjs.add(pnj);
		
		game.map.repaint();
		
		game.deplacement.setSprites(game.deplacement.direction, game.deplacement.hero, false);
		
	}
	
	public boolean isLookingTileFree(Direction direction) {
		int x = positionX;
		int y = positionY;
		if(direction == Direction.UP)
			y = positionY - Deplacement.pixelMoved;
		else if(direction == Direction.DOWN)
			y = positionY + Deplacement.pixelMoved;
		else if(direction == Direction.LEFT)
			x = positionX - Deplacement.pixelMoved;
		else if(direction == Direction.RIGHT)
			x = positionX + Deplacement.pixelMoved;
		return !(game.deplacement.locationX > x - Deplacement.pixelMoved && game.deplacement.locationX < x + Deplacement.pixelMoved && game.deplacement.locationY > y - Deplacement.pixelMoved && game.deplacement.locationY < y + Deplacement.pixelMoved);
	}
	
	public void clearIA() {
		if(IA) {
			IAMoving.cancel();
			IA = false;
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(perso.equals("mom")) {
			if(direction == Direction.UP) {
				if(foot == 0)
					g.drawImage(Const.momBack.getImage(), 0, 0, null);
				else if(foot == 1)
					g.drawImage(Const.momBackRight.getImage(), 0, 0, null);
				else if(foot == 2)
					g.drawImage(Const.momBackLeft.getImage(), 0, 0, null);
			}
			else if(direction == Direction.DOWN) {
				if(foot == 0)
					g.drawImage(Const.momFront.getImage(), 0, 0, null);
				else if(foot == 1)
					g.drawImage(Const.momFrontRight.getImage(), 0, 0, null);
				else if(foot == 2)
					g.drawImage(Const.momFrontLeft.getImage(), 0, 0, null);
			}
			else if(direction == Direction.LEFT) {
				if(foot == 0)	
					g.drawImage(Const.momLeft.getImage(), 0, 0, null);
				else if(foot == 1)	
					g.drawImage(Const.momLeftRight.getImage(), 0, 0, null);
				else if(foot == 2)	
					g.drawImage(Const.momLeftLeft.getImage(), 0, 0, null);
				
			}
			else if(direction == Direction.RIGHT) {
				if(foot == 0)	
					g.drawImage(Const.momRight.getImage(), 0, 0, null);
				else if(foot == 1)	
					g.drawImage(Const.momRightRight.getImage(), 0, 0, null);
				else if(foot == 2)	
					g.drawImage(Const.momRightLeft.getImage(), 0, 0, null);
			}
		}
		else if(perso.contains("brownboy")) {
			if(direction == Direction.UP) {
				if(foot == 0)
					g.drawImage(Const.brownboyBack.getImage(), 0, 0, null);
				else if(foot == 1)
					g.drawImage(Const.brownboyBackRight.getImage(), 0, 0, null);
				else if(foot == 2)
					g.drawImage(Const.brownboyBackLeft.getImage(), 0, 0, null);
			}
			else if(direction == Direction.DOWN) {
				if(foot == 0)
					g.drawImage(Const.brownboyFront.getImage(), 0, 0, null);
				else if(foot == 1)
					g.drawImage(Const.brownboyFrontRight.getImage(), 0, 0, null);
				else if(foot == 2)
					g.drawImage(Const.brownboyFrontLeft.getImage(), 0, 0, null);
			}
			else if(direction == Direction.LEFT) {
				if(foot == 0)	
					g.drawImage(Const.brownboyLeft.getImage(), 0, 0, null);
				else if(foot == 1)	
					g.drawImage(Const.brownboyLeftRight.getImage(), 0, 0, null);
				else if(foot == 2)	
					g.drawImage(Const.brownboyLeftLeft.getImage(), 0, 0, null);
				
			}
			else if(direction == Direction.RIGHT) {
				if(foot == 0)	
					g.drawImage(Const.brownboyRight.getImage(), 0, 0, null);
				else if(foot == 1)	
					g.drawImage(Const.brownboyRightRight.getImage(), 0, 0, null);
				else if(foot == 2)	
					g.drawImage(Const.brownboyRightLeft.getImage(), 0, 0, null);
			}
		}
		else if(perso.contains("police")) {
			if(direction == Direction.RIGHT) {
				if(foot == 0)	
					g.drawImage(Const.policeRight.getImage(), 0, 0, null);
			}
		}
		else if(perso.contains("sellerboy")) {
			if(direction == Direction.UP) {
				if(foot == 0)	
					g.drawImage(Const.sellerboyFront.getImage(), 0, 0, null);
			}
			else if(direction == Direction.DOWN) {
				if(foot == 0)	
					g.drawImage(Const.sellerboyBack.getImage(), 0, 0, null);
			}
			else if(direction == Direction.LEFT) {
				if(foot == 0)	
					g.drawImage(Const.sellerboyLeft.getImage(), 0, 0, null);
			}
			else if(direction == Direction.RIGHT) {
				if(foot == 0)	
					g.drawImage(Const.sellerboyRight.getImage(), 0, 0, null);
			}
		}
	}
	
	private boolean isAnyoneNear() {
		boolean yes = Math.abs(positionY - game.deplacement.locationY) < Deplacement.pixelMoved*2 &&  Math.abs(positionX - game.deplacement.locationX) < Deplacement.pixelMoved;
		int i = 0;
		while(!yes && i<game.pnjs.size()) {
			yes = !game.pnjs.get(i).perso.equals(perso) && Math.abs(game.pnjs.get(i).positionY - positionY) < Deplacement.pixelMoved*2 && Math.abs(game.pnjs.get(i).positionX - positionX) < Deplacement.pixelMoved;
			i++;
		}
		return yes;
	}
	
}
