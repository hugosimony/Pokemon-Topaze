package fr.hugosimony.pokemontopaze.maps.perso;

import java.awt.Graphics;

import javax.swing.JPanel;

import fr.hugosimony.pokemontopaze.Const;
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
			if(speed == 2) {
				if(direction == Direction.UP) {
					if(foot == 0)
						g.drawImage(Const.boyRunBack.getImage(), 0, 0, null);
					else if(foot == 1)
						g.drawImage(Const.boyRunBackRight.getImage(), 0, 0, null);
					else if(foot == 2)
						g.drawImage(Const.boyRunBackLeft.getImage(), 0, 0, null);
				}
					else if(direction == Direction.DOWN) {
					if(foot == 0)
						g.drawImage(Const.boyRunFront.getImage(), 0, 0, null);
					else if(foot == 1)
						g.drawImage(Const.boyRunFrontRight.getImage(), 0, 0, null);
					else if(foot == 2)
						g.drawImage(Const.boyRunFrontLeft.getImage(), 0, 0, null);
				}
				else if(direction == Direction.LEFT) {
					if(foot == 0)	
						g.drawImage(Const.boyRunLeft.getImage(), 0, 0, null);
					else if(foot == 1)	
						g.drawImage(Const.boyRunLeftRight.getImage(), 0, 0, null);
					else if(foot == 2)	
						g.drawImage(Const.boyRunLeftLeft.getImage(), 0, 0, null);
					
				}
				else if(direction == Direction.RIGHT) {
					if(foot == 0)	
						g.drawImage(Const.boyRunRight.getImage(), 0, 0, null);
					else if(foot == 1)	
						g.drawImage(Const.boyRunRightRight.getImage(), 0, 0, null);
					else if(foot == 2)	
						g.drawImage(Const.boyRunRightLeft.getImage(), 0, 0, null);
				}
			}
			else if(speed == 1) {
				if(direction == Direction.UP) {
					if(foot == 0)
						g.drawImage(Const.boyBack.getImage(), 0, 0, null);
					else if(foot == 1)
						g.drawImage(Const.boyBackRight.getImage(), 0, 0, null);
					else if(foot == 2)
						g.drawImage(Const.boyBackLeft.getImage(), 0, 0, null);
				}
					else if(direction == Direction.DOWN) {
					if(foot == 0)
						g.drawImage(Const.boyFront.getImage(), 0, 0, null);
					else if(foot == 1)
						g.drawImage(Const.boyFrontRight.getImage(), 0, 0, null);
					else if(foot == 2)
						g.drawImage(Const.boyFrontLeft.getImage(), 0, 0, null);
				}
				else if(direction == Direction.LEFT) {
					if(foot == 0)	
						g.drawImage(Const.boyLeft.getImage(), 0, 0, null);
					else if(foot == 1)	
						g.drawImage(Const.boyLeftRight.getImage(), 0, 0, null);
					else if(foot == 2)	
						g.drawImage(Const.boyLeftLeft.getImage(), 0, 0, null);
					
				}
				else if(direction == Direction.RIGHT) {
					if(foot == 0)	
						g.drawImage(Const.boyRight.getImage(), 0, 0, null);
					else if(foot == 1)	
						g.drawImage(Const.boyRightRight.getImage(), 0, 0, null);
					else if(foot == 2)	
						g.drawImage(Const.boyRightLeft.getImage(), 0, 0, null);
				}
			}
		}
		else {
			if(direction == Direction.UP) {
				if(foot == 0)
					g.drawImage(Const.girlBack.getImage(), 0, 0, null);
				else if(foot == 1)
					g.drawImage(Const.girlBackRight.getImage(), 0, 0, null);
				else if(foot == 2)
					g.drawImage(Const.girlBackLeft.getImage(), 0, 0, null);
			}
				else if(direction == Direction.DOWN) {
				if(foot == 0)
					g.drawImage(Const.girlFront.getImage(), 0, 0, null);
				else if(foot == 1)
					g.drawImage(Const.girlFrontRight.getImage(), 0, 0, null);
				else if(foot == 2)
					g.drawImage(Const.girlFrontLeft.getImage(), 0, 0, null);
			}
			else if(direction == Direction.LEFT) {
				if(foot == 0)	
					g.drawImage(Const.girlLeft.getImage(), 0, 0, null);
				else if(foot == 1)	
					g.drawImage(Const.girlLeftRight.getImage(), 0, 0, null);
				else if(foot == 2)	
					g.drawImage(Const.girlLeftLeft.getImage(), 0, 0, null);
				
			}
			else if(direction == Direction.RIGHT) {
				if(foot == 0)	
					g.drawImage(Const.girlRight.getImage(), 0, 0, null);
				else if(foot == 1)	
					g.drawImage(Const.girlRightRight.getImage(), 0, 0, null);
				else if(foot == 2)	
					g.drawImage(Const.girlRightLeft.getImage(), 0, 0, null);
			}
		}
		
	}
}
