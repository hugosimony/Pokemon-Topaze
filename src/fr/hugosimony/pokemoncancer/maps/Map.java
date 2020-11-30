package fr.hugosimony.pokemoncancer.maps;

import java.awt.Graphics;

import javax.swing.JPanel;

import fr.hugosimony.pokemoncancer.Const;

public class Map extends JPanel {
	private static final long serialVersionUID = 1L;

	public int map;
	public int floor;
	
	public Map(int map, int floor) {
		setOpaque(false);
		setLayout(null);
		setVisible(true);
		this.map = map;
		this.floor = floor;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(map == 1) { // MyHouse
			if(floor == 1)
				g.drawImage(Const.myHouseBackGround1.getImage(), -224, -160, null);
			else 
				g.drawImage(Const.myHouseBackGround2.getImage(), -3, -8, null);
		}
		if(map == 2) // Sélénia
			g.drawImage(Const.seleniaMap.getImage(), 0, 0, null);
	}
}
