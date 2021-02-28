package fr.hugosimony.pokemoncancer.listeners;

import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import fr.hugosimony.pokemoncancer.Game;
import fr.hugosimony.pokemoncancer.Main;
import fr.hugosimony.pokemoncancer.Settings;
import fr.hugosimony.pokemoncancer.Variables;
import fr.hugosimony.pokemoncancer.menus.SaveMenu;
import fr.hugosimony.pokemoncancer.menus.TextZone;
import fr.hugosimony.pokemoncancer.menus.XMenu;

public class MenuXDispatcher implements KeyEventDispatcher {

	private Game game;
	private JPanel originalPanel;
	
	public MenuXDispatcher(Game game, JPanel originalPanel) {
		this.game = game;
		this.originalPanel = originalPanel;
	}
	
	@Override
	public boolean dispatchKeyEvent(KeyEvent event) {
		
		if(originalPanel.isVisible()) {
			 if(event.getID() == KeyEvent.KEY_PRESSED && game.deplacement.released && !game.inTextMenu && !Main.settingsOn && !game.inTransition && !game.inBattle) {
				 int keyCode = event.getKeyCode();
				 
				 if((keyCode == Variables.CONTROLS_MenuX || keyCode == Variables.CONTROLS_B || keyCode == KeyEvent.VK_ESCAPE)) {
	 				if(game.inXMenu)
	 					XMenu.unprintXMenu();
	 				else if(keyCode == Variables.CONTROLS_MenuX) 
	     				XMenu.printXMenu();
	 			}
	 			else if((keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN) && game.inXMenu)
	 				XMenu.changePosition(keyCode == KeyEvent.VK_UP);
	 			else if((keyCode == Variables.CONTROLS_A || keyCode == KeyEvent.VK_ENTER) && game.inXMenu) {
	 				if(XMenu.position == 1) {
	 					XMenu.unprintXMenu();
	 					game.textZone = new TextZone(game.actualPanel, "Vous n'avez pas encore accès à ce menu.");
	 					TextZone.printTextZone(game.textZone, game);
	 				}
	 				else if(XMenu.position == 2) {
	 					XMenu.unprintXMenu();	
	 					game.textZone = new TextZone(game.actualPanel, "Vous n'avez pas encore accès à ce menu.");
	 					TextZone.printTextZone(game.textZone, game);
					}
	 				else if(XMenu.position == 3) {
	 					XMenu.unprintXMenu();
	 					game.textZone = new TextZone(game.actualPanel, "Vous n'avez pas encore accès à ce menu.");
	 					TextZone.printTextZone(game.textZone, game);
					}
	 				else if(XMenu.position == 4) {
	 					XMenu.unprintXMenu();
	 					game.textZone = new TextZone(game.actualPanel, "Vous n'avez pas encore accès à ce menu.");
	 					TextZone.printTextZone(game.textZone, game);
					}
	 				else if(XMenu.position == 5) {
	 					XMenu.unprintXMenu();
	     				SaveMenu.printSaveMenu();
	     				game.textZone = new TextZone(game.actualPanel, SaveMenu.saveText);
	     				TextZone.printTextZone(game.textZone, game);
	 				}
	 				else if(XMenu.position == 6) {
	 					Main.settingsOn = true;
	             		Settings settings = new Settings();
	             		settings.setVisible(true);
	 				}
	 				else if(XMenu.position == 7)
	     				XMenu.unprintXMenu();
	 			}
			 }
		}
		return false;
	}
	
}
