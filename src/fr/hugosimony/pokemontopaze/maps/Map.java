package fr.hugosimony.pokemontopaze.maps;

import java.awt.Graphics;

import javax.swing.JPanel;

import fr.hugosimony.pokemontopaze.Const;

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
		g.drawImage(Const.mainMap.getImage(), 0, 0, null);
	}
}
