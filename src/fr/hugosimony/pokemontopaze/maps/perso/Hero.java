package fr.hugosimony.pokemontopaze.maps.perso;

import java.awt.Graphics;

import javax.swing.JPanel;

import fr.hugosimony.pokemontopaze.sprites.perso.ConstPersoSprites;
import fr.hugosimony.pokemontopaze.Variables;
import fr.hugosimony.pokemontopaze.maps.Direction;

public class Hero extends JPanel {
	private static final long serialVersionUID = 1L;

	public Direction direction;
	public int foot;
	public int speed;
	
	public Hero(Direction direction, int foot, int speed) {
		this.direction = direction;
		this.foot = foot;
		this.speed = speed;
		setOpaque(false);
		setLayout(null);
		setVisible(true);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(Variables.PERSO_Sex.equals("boy")) {
			if(speed == 3) {
				if(direction == Direction.UP) {
					if(foot == 0)
						g.drawImage(ConstPersoSprites.boyBikeBack.getImage(), 0, 0, null);
					else if(foot == 1)
						g.drawImage(ConstPersoSprites.boyBikeBackRight.getImage(), 0, 0, null);
					else if(foot == 2)
						g.drawImage(ConstPersoSprites.boyBikeBackLeft.getImage(), 0, 0, null);
					else if(foot == 3)
						g.drawImage(ConstPersoSprites.boyBikeBackStop.getImage(), 0, 0, null);
				}
				else if(direction == Direction.DOWN) {
					if(foot == 0)
						g.drawImage(ConstPersoSprites.boyBikeFront.getImage(), 0, 0, null);
					else if(foot == 1)
						g.drawImage(ConstPersoSprites.boyBikeFrontRight.getImage(), 0, 0, null);
					else if(foot == 2)
						g.drawImage(ConstPersoSprites.boyBikeFrontLeft.getImage(), 0, 0, null);
					else if(foot == 3)
						g.drawImage(ConstPersoSprites.boyBikeFrontStop.getImage(), 0, 0, null);
				}
				else if(direction == Direction.LEFT) {
					if(foot == 0)	
						g.drawImage(ConstPersoSprites.boyBikeLeft.getImage(), 0, 0, null);
					else if(foot == 1)	
						g.drawImage(ConstPersoSprites.boyBikeLeftRight.getImage(), 0, 0, null);
					else if(foot == 2)	
						g.drawImage(ConstPersoSprites.boyBikeLeftLeft.getImage(), 0, 0, null);
					else if(foot == 3)
						g.drawImage(ConstPersoSprites.boyBikeLeftStop.getImage(), 0, 0, null);
					
				}
				else if(direction == Direction.RIGHT) {
					if(foot == 0)	
						g.drawImage(ConstPersoSprites.boyBikeRight.getImage(), 0, 0, null);
					else if(foot == 1)	
						g.drawImage(ConstPersoSprites.boyBikeRightRight.getImage(), 0, 0, null);
					else if(foot == 2)	
						g.drawImage(ConstPersoSprites.boyBikeRightLeft.getImage(), 0, 0, null);
					else if(foot == 3)
						g.drawImage(ConstPersoSprites.boyBikeRightStop.getImage(), 0, 0, null);
				}
			}
			else if(speed == 2) {
				if(direction == Direction.UP) {
					if(foot == 0)
						g.drawImage(ConstPersoSprites.boyRunBack.getImage(), 0, 0, null);
					else if(foot == 1)
						g.drawImage(ConstPersoSprites.boyRunBackRight.getImage(), 0, 0, null);
					else if(foot == 2)
						g.drawImage(ConstPersoSprites.boyRunBackLeft.getImage(), 0, 0, null);
				}
				else if(direction == Direction.DOWN) {
					if(foot == 0)
						g.drawImage(ConstPersoSprites.boyRunFront.getImage(), 0, 0, null);
					else if(foot == 1)
						g.drawImage(ConstPersoSprites.boyRunFrontRight.getImage(), 0, 0, null);
					else if(foot == 2)
						g.drawImage(ConstPersoSprites.boyRunFrontLeft.getImage(), 0, 0, null);
				}
				else if(direction == Direction.LEFT) {
					if(foot == 0)	
						g.drawImage(ConstPersoSprites.boyRunLeft.getImage(), 0, 0, null);
					else if(foot == 1)	
						g.drawImage(ConstPersoSprites.boyRunLeftRight.getImage(), 0, 0, null);
					else if(foot == 2)	
						g.drawImage(ConstPersoSprites.boyRunLeftLeft.getImage(), 0, 0, null);
					
				}
				else if(direction == Direction.RIGHT) {
					if(foot == 0)	
						g.drawImage(ConstPersoSprites.boyRunRight.getImage(), 0, 0, null);
					else if(foot == 1)	
						g.drawImage(ConstPersoSprites.boyRunRightRight.getImage(), 0, 0, null);
					else if(foot == 2)	
						g.drawImage(ConstPersoSprites.boyRunRightLeft.getImage(), 0, 0, null);
				}
			}
			else if(speed == 1) {
				if(direction == Direction.UP) {
					if(foot == 0)
						g.drawImage(ConstPersoSprites.boyBack.getImage(), 0, 0, null);
					else if(foot == 1)
						g.drawImage(ConstPersoSprites.boyBackRight.getImage(), 0, 0, null);
					else if(foot == 2)
						g.drawImage(ConstPersoSprites.boyBackLeft.getImage(), 0, 0, null);
				}
				else if(direction == Direction.DOWN) {
					if(foot == 0)
						g.drawImage(ConstPersoSprites.boyFront.getImage(), 0, 0, null);
					else if(foot == 1)
						g.drawImage(ConstPersoSprites.boyFrontRight.getImage(), 0, 0, null);
					else if(foot == 2)
						g.drawImage(ConstPersoSprites.boyFrontLeft.getImage(), 0, 0, null);
				}
				else if(direction == Direction.LEFT) {
					if(foot == 0)	
						g.drawImage(ConstPersoSprites.boyLeft.getImage(), 0, 0, null);
					else if(foot == 1)	
						g.drawImage(ConstPersoSprites.boyLeftRight.getImage(), 0, 0, null);
					else if(foot == 2)	
						g.drawImage(ConstPersoSprites.boyLeftLeft.getImage(), 0, 0, null);
					
				}
				else if(direction == Direction.RIGHT) {
					if(foot == 0)	
						g.drawImage(ConstPersoSprites.boyRight.getImage(), 0, 0, null);
					else if(foot == 1)	
						g.drawImage(ConstPersoSprites.boyRightRight.getImage(), 0, 0, null);
					else if(foot == 2)	
						g.drawImage(ConstPersoSprites.boyRightLeft.getImage(), 0, 0, null);
				}
			}
		}
		else {
			if(speed == 3) {
				if(direction == Direction.UP) {
					if(foot == 0)
						g.drawImage(ConstPersoSprites.boyBikeBack.getImage(), 0, 0, null);
					else if(foot == 1)
						g.drawImage(ConstPersoSprites.boyBikeBackRight.getImage(), 0, 0, null);
					else if(foot == 2)
						g.drawImage(ConstPersoSprites.boyBikeBackLeft.getImage(), 0, 0, null);
					else if(foot == 3)
						g.drawImage(ConstPersoSprites.boyBikeBackStop.getImage(), 0, 0, null);
				}
				else if(direction == Direction.DOWN) {
					if(foot == 0)
						g.drawImage(ConstPersoSprites.boyBikeFront.getImage(), 0, 0, null);
					else if(foot == 1)
						g.drawImage(ConstPersoSprites.boyBikeFrontRight.getImage(), 0, 0, null);
					else if(foot == 2)
						g.drawImage(ConstPersoSprites.boyBikeFrontLeft.getImage(), 0, 0, null);
					else if(foot == 3)
						g.drawImage(ConstPersoSprites.boyBikeFrontStop.getImage(), 0, 0, null);
				}
				else if(direction == Direction.LEFT) {
					if(foot == 0)	
						g.drawImage(ConstPersoSprites.boyBikeLeft.getImage(), 0, 0, null);
					else if(foot == 1)	
						g.drawImage(ConstPersoSprites.boyBikeLeftRight.getImage(), 0, 0, null);
					else if(foot == 2)	
						g.drawImage(ConstPersoSprites.boyBikeLeftLeft.getImage(), 0, 0, null);
					else if(foot == 3)
						g.drawImage(ConstPersoSprites.boyBikeLeftStop.getImage(), 0, 0, null);
					
				}
				else if(direction == Direction.RIGHT) {
					if(foot == 0)	
						g.drawImage(ConstPersoSprites.boyBikeRight.getImage(), 0, 0, null);
					else if(foot == 1)	
						g.drawImage(ConstPersoSprites.boyBikeRightRight.getImage(), 0, 0, null);
					else if(foot == 2)	
						g.drawImage(ConstPersoSprites.boyBikeRightLeft.getImage(), 0, 0, null);
					else if(foot == 3)
						g.drawImage(ConstPersoSprites.boyBikeRightStop.getImage(), 0, 0, null);
				}
			}
			else if(speed == 2) {
				if(direction == Direction.UP) {
					if(foot == 0)
						g.drawImage(ConstPersoSprites.girlRunBack.getImage(), 0, 0, null);
					else if(foot == 1)
						g.drawImage(ConstPersoSprites.girlRunBackRight.getImage(), 0, 0, null);
					else if(foot == 2)
						g.drawImage(ConstPersoSprites.girlRunBackLeft.getImage(), 0, 0, null);
				}
				else if(direction == Direction.DOWN) {
					if(foot == 0)
						g.drawImage(ConstPersoSprites.girlRunFront.getImage(), 0, 0, null);
					else if(foot == 1)
						g.drawImage(ConstPersoSprites.girlRunFrontRight.getImage(), 0, 0, null);
					else if(foot == 2)
						g.drawImage(ConstPersoSprites.girlRunFrontLeft.getImage(), 0, 0, null);
				}
				else if(direction == Direction.LEFT) {
					if(foot == 0)	
						g.drawImage(ConstPersoSprites.girlRunLeft.getImage(), 0, 0, null);
					else if(foot == 1)	
						g.drawImage(ConstPersoSprites.girlRunLeftRight.getImage(), 0, 0, null);
					else if(foot == 2)	
						g.drawImage(ConstPersoSprites.girlRunLeftLeft.getImage(), 0, 0, null);
					
				}
				else if(direction == Direction.RIGHT) {
					if(foot == 0)	
						g.drawImage(ConstPersoSprites.girlRunRight.getImage(), 0, 0, null);
					else if(foot == 1)	
						g.drawImage(ConstPersoSprites.girlRunRightRight.getImage(), 0, 0, null);
					else if(foot == 2)	
						g.drawImage(ConstPersoSprites.girlRunRightLeft.getImage(), 0, 0, null);
				}
			}
			else if(speed == 1) {
				if(direction == Direction.UP) {
					if(foot == 0)
						g.drawImage(ConstPersoSprites.girlBack.getImage(), 0, 0, null);
					else if(foot == 1)
						g.drawImage(ConstPersoSprites.girlBackRight.getImage(), 0, 0, null);
					else if(foot == 2)
						g.drawImage(ConstPersoSprites.girlBackLeft.getImage(), 0, 0, null);
				}
				else if(direction == Direction.DOWN) {
					if(foot == 0)
						g.drawImage(ConstPersoSprites.girlFront.getImage(), 0, 0, null);
					else if(foot == 1)
						g.drawImage(ConstPersoSprites.girlFrontRight.getImage(), 0, 0, null);
					else if(foot == 2)
						g.drawImage(ConstPersoSprites.girlFrontLeft.getImage(), 0, 0, null);
				}
				else if(direction == Direction.LEFT) {
					if(foot == 0)	
						g.drawImage(ConstPersoSprites.girlLeft.getImage(), 0, 0, null);
					else if(foot == 1)	
						g.drawImage(ConstPersoSprites.girlLeftRight.getImage(), 0, 0, null);
					else if(foot == 2)	
						g.drawImage(ConstPersoSprites.girlLeftLeft.getImage(), 0, 0, null);
					
				}
				else if(direction == Direction.RIGHT) {
					if(foot == 0)	
						g.drawImage(ConstPersoSprites.girlRight.getImage(), 0, 0, null);
					else if(foot == 1)	
						g.drawImage(ConstPersoSprites.girlRightRight.getImage(), 0, 0, null);
					else if(foot == 2)	
						g.drawImage(ConstPersoSprites.girlRightLeft.getImage(), 0, 0, null);
				}
			}	
		}
		
	}
}
