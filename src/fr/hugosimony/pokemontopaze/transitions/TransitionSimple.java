package fr.hugosimony.pokemontopaze.transitions;

import java.awt.Component;
import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

import fr.hugosimony.pokemontopaze.Const;
import fr.hugosimony.pokemontopaze.Game;

public class TransitionSimple {
	
	public TransitionSimple(Game game, JPanel panel, Object typePanel) {
		
		game.inTransition = true;
		
		new Timer().schedule(new TimerTask() {
			
			private int x = 1;
			private Transition transition;
			
			@Override
			public void run() {
				if(x<6) {
					if(x != 1)
						transition.setVisible(false);
					transition = new Transition(x);
					transition.setVisible(false);
					transition.setLocation(0, 0);
					transition.setSize(800,600);
					transition.setVisible(true);
					panel.add(transition);
					transition.setVisible(false);
					transition.setLocation(0, 0);
					transition.setSize(800,600);
					transition.setVisible(true);
					panel.add(transition);
					x++;
				}
				else {
					transition.setVisible(false);
					panel.removeAll();
					panel.validate();
					game.add((Component) typePanel);
					game.validate();
					game.inTransition = false;
					this.cancel();
				}
				
			}
		}, 0, 100);
		
	}
	private class Transition extends JPanel {
		private static final long serialVersionUID = 1L;
		
		private int x;
		
		public Transition(int x) {
			this.x = x;
			setLayout(null);
			setVisible(true);
			setOpaque(false);
		}

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			if(x == 1)
				g.drawImage(Const.transtionSimple1.getImage(), 0, 0, null);
			else if(x == 2)
				g.drawImage(Const.transtionSimple2.getImage(), 0, 0, null);
			else if(x == 3)
				g.drawImage(Const.transtionSimple3.getImage(), 0, 0, null);
			else if(x == 4)
				g.drawImage(Const.transtionSimple4.getImage(), 0, 0, null);
			else if(x == 5)
				g.drawImage(Const.transtionSimple5.getImage(), 0, 0, null);
		}
	}
	
}
