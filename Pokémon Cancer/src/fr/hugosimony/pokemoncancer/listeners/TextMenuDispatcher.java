package fr.hugosimony.pokemoncancer.listeners;

import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;
import java.util.Timer;

import javax.swing.JPanel;

import fr.hugosimony.pokemoncancer.Game;
import fr.hugosimony.pokemoncancer.Main;
import fr.hugosimony.pokemoncancer.Variables;
import fr.hugosimony.pokemoncancer.menus.SaveMenu;
import fr.hugosimony.pokemoncancer.menus.TextZone;
import fr.hugosimony.pokemoncancer.menus.YesNo;

public class TextMenuDispatcher implements KeyEventDispatcher {

	private Game game;
	private JPanel originalPanel;
	
	public TextMenuDispatcher(Game game, JPanel originalPanel) {
		this.game = game;
		this.originalPanel = originalPanel;
	}
	
	@Override
	public boolean dispatchKeyEvent(KeyEvent event) {
		
		 if(originalPanel.isVisible()) {
			 if(event.getID() == KeyEvent.KEY_PRESSED && game.deplacement.released && !Main.settingsOn && !game.inTransition) {
				 int keyCode = event.getKeyCode();
				 
				 if(game.inTextMenu) {
	 				 if(game.inYesNoMenu) {
	 					 if(keyCode == Variables.CONTROLS_UP || keyCode == Variables.CONTROLS_DOWN || keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN) {
	 						 YesNo.changeYesNoMenu();
	 					 }
	 					 else if(keyCode == Variables.CONTROLS_B || keyCode == KeyEvent.VK_ESCAPE || keyCode == Variables.CONTROLS_A || keyCode == KeyEvent.VK_ENTER) {
	 						 YesNo.unprintYesNoMenu();
	 						 if((keyCode == Variables.CONTROLS_A || keyCode == KeyEvent.VK_ENTER) && YesNo.yes) {
	 							 game.waitingSave = true;
	 							 game.textZone.setText(SaveMenu.savingText);
	 							 TextZone.printTextZone(game.textZone, game);
	 							 game.save();
	 						 }
	 						 else {
	 							 TextZone.unprintTextZone();
	     						 SaveMenu.unprintSaveMenu();
	 						 }
	 					 }
	 				 }
	 				 else {
	 					 if((keyCode == Variables.CONTROLS_A || keyCode == Variables.CONTROLS_B) && game.textWaiting) {
	         				 game.textWaiting = false;
	         				 new Timer().schedule(game.textZone.new PrintText(game.actualPanel), 0, (long) Variables.SPEED_TEXT);
	     				 }
	 				 }
				 }
			 }
		 }
		 return false;
	}
	
}
