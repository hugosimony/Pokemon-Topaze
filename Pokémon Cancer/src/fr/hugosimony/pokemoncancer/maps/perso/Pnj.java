package fr.hugosimony.pokemoncancer.maps.perso;

import java.awt.Graphics;

import javax.swing.JPanel;

import fr.hugosimony.pokemoncancer.Const;
import fr.hugosimony.pokemoncancer.Variables;
import fr.hugosimony.pokemoncancer.maps.Direction;

public class Pnj extends JPanel {
	private static final long serialVersionUID = 1L;

	public String perso;
	private Direction direction;
	private int foot;
	public int positionX;
	public int positionY;
	
	public Pnj(String perso, Direction direction, int foot, int positionX, int positionY) {
		this.perso = perso;
		this.direction = direction;
		this.foot = foot;
		this.positionX = positionX;
		this.positionY = positionY;
		setOpaque(false);
		setLayout(null);
		setVisible(true);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(perso.equals("mom")) {
			if(direction == Direction.UP) {
				if(foot == 0)
					g.drawImage(Const.momBack.getImage(), 0, 0, null);
			}
				else if(direction == Direction.DOWN) {
				if(foot == 0)
					g.drawImage(Const.momFront.getImage(), 0, 0, null);
			}
			else if(direction == Direction.LEFT) {
				if(foot == 0)	
					g.drawImage(Const.momLeft.getImage(), 0, 0, null);
				
			}
			else if(direction == Direction.RIGHT) {
				if(foot == 0)	
					g.drawImage(Const.momRight.getImage(), 0, 0, null);
			}
		}
		
		if(perso.contains("police")) {
			if(direction == Direction.RIGHT) {
				if(foot == 0)	
					g.drawImage(Const.policeRight.getImage(), 0, 0, null);
			}
		}
	}
	
	public String getText() {
		if(perso.equals("mom")) {
			return "Ah t'es enfin réveillé" + Variables.LANG_Feminin + "...= Bon, t'as pas un truc à faire là ?";
		}
		if(perso.equals("police001")) {
			return "Désolé,= la forêt est encore trop dangereuse pour toi.";
		}
		return "";
	}
	
}
