package fr.hugosimony.pokemontopaze.maps.pnj;

import java.awt.Component;
import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

import fr.hugosimony.pokemontopaze.Game;
import fr.hugosimony.pokemontopaze.Variables;
import fr.hugosimony.pokemontopaze.maps.Deplacement;
import fr.hugosimony.pokemontopaze.maps.Direction;
import fr.hugosimony.pokemontopaze.maps.animations.PnjAnimations;
import fr.hugosimony.pokemontopaze.menus.TextZone;
import fr.hugosimony.pokemontopaze.utils.IntTuple;

public class Pnj extends JPanel {
	private static final long serialVersionUID = 1L;

	public Game game;
	
	private Pnj pnj;
	public boolean IA;
	public boolean firstIA;
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
		this.firstIA = firstIA;
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
								setSprites(new Pnj(game, perso, finalLookingDirection, 0, positionX, positionY, IA, false, directions, IAMoving, paraClick, false));
								if(Variables.ADVENTURE_Step == 9) {
									game.deplacement.hero.direction = Direction.getOpositeDirection(finalLookingDirection);
									game.deplacement.hero.repaint();
								}
								if(!finalText.equals("")) {
									if(finalText.equals("+")) {
										PnjAnimations.checkMapChange(game);
										new Timer().schedule(new TimerTask() {
											@Override
											public void run() {
												PnjAnimations.startGoodAnimation(game, new IntTuple(game.deplacement.locationX, game.deplacement.locationY));
												this.cancel();
											}
										}, 1);
									}
									else {
										game.inAnimation = false;
										game.textZone = new TextZone(game.actualPanel, finalText);
										TextZone.printTextZone(game.textZone, game);
									}
								}
								this.cancel();
							}
							else {
								if(animationMoves.length() > 0) {
									x = 0;
									dir = Deplacement.getDirection(animationMoves.charAt(0));
									animationMoves = animationMoves.replaceFirst(animationMoves.charAt(0)+"", "");
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
	
	public void copyParameters(Pnj pnj_) {
		this.game = pnj_.game;
		this.perso = pnj_.perso;
		this.direction = pnj_.direction;
		this.directions = pnj_.directions;
		this.foot = pnj_.foot;
		this.positionX = pnj_.positionX;
		this.positionY = pnj_.positionY;
		this.IA = pnj_.IA;
		this.paraClick = pnj_.paraClick;
		this.mooving = pnj_.mooving;
		if(pnj_.IA && pnj_.firstIA) {
			this.IAMoving = new IAMoving(pnj, pnj_.directions);
			new Timer().schedule(this.IAMoving, 1, 1);
		}
		else
			this.IAMoving = pnj_.IAMoving;
	}
	
	public void setSprites(Pnj pnj_) {

		boolean toAdd = true;
		for(Component component : game.map.getComponents()) {
			if(component instanceof Pnj) {
				Pnj pnj1 = (Pnj) component;
				if(pnj1.perso.equals(pnj_.perso))
					toAdd = false;
			}
		}
		
		if(toAdd)
			game.map.add(pnj);
		
		pnj.copyParameters(pnj_);
		pnj.repaint();
		
		int i = 0;
		boolean done = false;
		while(!done && i < game.pnjs.size()) {
			if(game.pnjs.get(i).perso.equals(pnj.perso)) {
				game.pnjs.get(i).copyParameters(pnj_);;
				done = true;
			}
			i++;
		}
		
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
		g.drawImage(PnjSprites.getGoodPnjSprite(perso, direction, foot), 0, 0, null);
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
