package fr.hugosimony.pokemontopaze.listeners;

import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;
import java.util.Timer;

import javax.swing.JPanel;

import fr.hugosimony.pokemontopaze.Game;
import fr.hugosimony.pokemontopaze.Main;
import fr.hugosimony.pokemontopaze.Variables;
import fr.hugosimony.pokemontopaze.maps.animations.TextAnimations;
import fr.hugosimony.pokemontopaze.menus.SaveMenu;
import fr.hugosimony.pokemontopaze.menus.TextZone;
import fr.hugosimony.pokemontopaze.menus.YesNo;

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
	 					 if(keyCode == Variables.CONTROLS_UP || keyCode == Variables.CONTROLS_DOWN) {
	 						 YesNo.changeYesNoMenu();
	 					 }
	 					 else if(keyCode == Variables.CONTROLS_B || keyCode == KeyEvent.VK_ESCAPE || keyCode == Variables.CONTROLS_A || keyCode == KeyEvent.VK_ENTER) {
	 						 YesNo.unprintYesNoMenu();
	 						 if((keyCode == Variables.CONTROLS_A || keyCode == KeyEvent.VK_ENTER) && YesNo.yes) {
	 							 if(game.inSaveMenu) {
		 							 game.waitingSave = true;
		 							 game.textZone.setText(SaveMenu.savingText);
		 							 TextZone.printTextZone(game.textZone, game);
		 							 game.save();
	 							 }
	 							 else {
	 								 String text = TextAnimations.getTextAfterYesNo(game, game.deplacement.getActualLookingTile(), true);
	 								 if(!text.equals("")) {
	 									game.textZone.setText(text);
			 							TextZone.printTextZone(game.textZone, game);
	 								 }
	 							 }
	 						 }
	 						 else {
	 							 if(game.inSaveMenu) {
		 							 TextZone.unprintTextZone();
	 								 SaveMenu.unprintSaveMenu();
	 							 }
	 							 else {
	 								 String text = TextAnimations.getTextAfterYesNo(game, game.deplacement.getActualLookingTile(), false);
	 								 if(!text.equals("")) {
	 									game.textZone.setText(text);
			 							TextZone.printTextZone(game.textZone, game);
	 								 }
	 								 else
			 							 TextZone.unprintTextZone();
	 							 }
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
