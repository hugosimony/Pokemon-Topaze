package fr.hugosimony.pokemoncancer.listeners;

import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;
import java.util.Arrays;

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
			 if(!Main.settingsOn && !game.inTransition && !game.inXMenu && !game.inSaveMenu && !game.inTextMenu && !game.inBattle && game.actualPanel.isVisible()) {
				 if(event.getID() == KeyEvent.KEY_PRESSED) {
					 int keyCode = event.getKeyCode();
					 Direction dir = game.deplacement.getDirection(keyCode);
					 if(dir != Direction.NULL) {
						 if(!game.deplacement.pressed.contains(keyCode + ""))
							 game.deplacement.pressed.add(keyCode + "");
						 if(dir != game.deplacement.direction) {
							 game.deplacement.newDirection = dir;
		 					 game.deplacement.released = false;
						 }
						 if(!game.deplacement.coolDown) {
		 					 game.deplacement.released = false;
		 					 game.deplacement.direction = dir;
		 					 game.deplacement.newDirection = dir;
		 					 game.deplacement.startMove(dir, false);
		 				 }
					 }
					 else if(event.getKeyCode() == KeyEvent.VK_A) {
						 //System.out.println("game.walls.add(new IntTuple(" + game.deplacement.locationX + ", " + game.deplacement.locationY + "));");
						 //System.out.println("game.herbs.add(new IntTriple(" + game.deplacement.locationX + ", " + game.deplacement.locationY + ", 2));");
						 System.out.println("perso : " + game.deplacement.locationX  + " ; "  + game.deplacement.locationY);
						 //System.out.println("map : " + game.deplacement.mapLocationX  + " ; "  + game.deplacement.mapLocationY);
					 }
				 }
				 else if(event.getID() == KeyEvent.KEY_RELEASED) {
					 int keyCode = event.getKeyCode();
					 if(game.deplacement.getDirection(keyCode) == game.deplacement.direction)
						 game.deplacement.released = true;
					 if(game.deplacement.pressed.contains(keyCode + ""))
						 game.deplacement.pressed.remove(keyCode + "");
					 if(!game.deplacement.coolDown && game.deplacement.pressed.size() == 1) {
							game.deplacement.released = false;
							game.deplacement.direction = game.deplacement.getDirection(Integer.parseInt(game.deplacement.pressed.get(0)));
							game.deplacement.newDirection = game.deplacement.direction;
							game.deplacement.startMove(game.deplacement.direction, true);
					 }
	     		}
			 }
		 }
		 return false;
	 }
}
