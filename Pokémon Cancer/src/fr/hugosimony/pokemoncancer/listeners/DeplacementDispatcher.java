package fr.hugosimony.pokemoncancer.listeners;

import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import fr.hugosimony.pokemoncancer.Game;
import fr.hugosimony.pokemoncancer.Main;
import fr.hugosimony.pokemoncancer.maps.Direction;

public class DeplacementDispatcher implements KeyEventDispatcher {
	
	private Game game;
	private JPanel originalPanel;
	
	public DeplacementDispatcher(Game game, JPanel originalPanel) {
		this.game = game;
		this.originalPanel = originalPanel;
	}
	
	 @Override
     public boolean dispatchKeyEvent(KeyEvent event) {
	
		 if(originalPanel.isVisible()) {
			 if(!Main.settingsOn && !game.inTransition && !game.inXMenu && !game.inSaveMenu && !game.inTextMenu && game.actualPanel.isVisible()) {
				 if(event.getID() == KeyEvent.KEY_PRESSED && game.deplacement.released) {
					 int keyCode = event.getKeyCode();
					 if(game.deplacement.getDirection(keyCode) != null && !game.inXMenu && !game.inSaveMenu) {
						 Direction dir = game.deplacement.getDirection(keyCode);
		 				 if(game.deplacement.released) {
			 				 if(!game.deplacement.coolDown) {
			 					 game.deplacement.released = false;
			 					 game.deplacement.direction = dir;
			 					 game.deplacement.newDirection = dir;
			 					 game.deplacement.startMove(dir, false);
			 				 }
			 				 else if(dir != game.deplacement.direction)
			 					 game.deplacement.newDirection = dir;
		 				 }
					 }
					 else if(event.getKeyCode() == KeyEvent.VK_A) {
						 //System.out.println("game.walls.add(new IntTuple(" + game.deplacement.locationX + ", " + game.deplacement.locationY + "));");
					 }
				 }
				 else if(event.getID() == KeyEvent.KEY_RELEASED) {
	     			if(game.deplacement.getDirection(event.getKeyCode()) == game.deplacement.direction)
	     				game.deplacement.released = true;
	     		}
			 }
		 }
		 return false;
	 }
}
