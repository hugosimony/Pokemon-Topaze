package fr.hugosimony.pokemontopaze.maps.pnj;

import java.awt.Graphics;
import java.awt.Point;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

import fr.hugosimony.pokemontopaze.Const;
import fr.hugosimony.pokemontopaze.Game;
import fr.hugosimony.pokemontopaze.sounds.Sounds;

public class ExclamationMark extends JPanel{
	private static final long serialVersionUID = 1L;
	
	ExclamationMark em;

	public ExclamationMark(Game game, Point location, boolean sound) {
		
		if(sound)
			Sounds.playSound(Const.soundExclamation);
		
		em = this;
		em.setLocation(location.x + 2, location.y - Const.exclamationMark.getIconHeight());
		
		setOpaque(false);
		setLayout(null);
		setVisible(true);
		setSize(Const.exclamationMark.getIconWidth(), Const.exclamationMark.getIconHeight());
		
		game.map.add(em);
		game.map.repaint();
		
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				em.setVisible(false);
				game.map.remove(em);
				repaint();
				this.cancel();
			}
		}, 1000);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(Const.exclamationMark.getImage(), 0, 0, null);
	}
	
}
