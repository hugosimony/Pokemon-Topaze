package fr.hugosimony.pokemoncancer.listeners;

import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import fr.hugosimony.pokemoncancer.Game;
import fr.hugosimony.pokemoncancer.Main;
import fr.hugosimony.pokemoncancer.Variables;
import fr.hugosimony.pokemoncancer.maps.Direction;
import fr.hugosimony.pokemoncancer.maps.perso.Pnj;
import fr.hugosimony.pokemoncancer.menus.TextZone;
import fr.hugosimony.pokemoncancer.utils.IntTuple;

public class InteractDispatcher implements KeyEventDispatcher {

	private Game game;
	private JPanel originalPanel;
	
	public InteractDispatcher(Game game, JPanel originalPanel) {
		this.game = game;
		this.originalPanel = originalPanel;
	}
	
	@Override
	public boolean dispatchKeyEvent(KeyEvent event) {
		
		 if(originalPanel.isVisible()) {
			 if(event.getID() == KeyEvent.KEY_PRESSED && game.deplacement.released && !Main.settingsOn && !game.inTransition) {
				 int keyCode = event.getKeyCode();
				 
				 if(!game.inTextMenu && !game.inXMenu && !game.inSaveMenu && (keyCode == Variables.CONTROLS_A)){
					 IntTuple tuple = game.deplacement.getLookingTile();
					 String text = "";
					 
					 if(IntTuple.contains(game.clickableTiles, game.deplacement.getLookingTile())) {
						 if(game.myHouse != null && game.myHouse.isVisible())
							 text = game.myHouse.getInteractMessage(tuple);
						 else if(game.selenia != null && game.selenia.isVisible())
							 text = game.selenia.getInteractMessage(tuple);
					 }
					 else if(IntTuple.containsPnj(game.pnjs, game.deplacement.getLookingTile())) {
						 int i = IntTuple.getPnjIndex(game.pnjs, tuple);
						 Pnj pnj = game.pnjs.get(i);
						 pnj.setVisible(false);
						 text = pnj.getText();
						 game.pnjs.remove(i);
						 pnj = new Pnj(pnj.perso, Direction.getOpositeDirection(game.deplacement.direction), 0, pnj.positionX, pnj.positionY);
						 pnj.setLocation(pnj.positionX, pnj.positionY);
						 pnj.setSize(50,70);
						 game.pnjs.add(pnj);
						 game.deplacement.setSprites(game.deplacement.direction);
					 }
						 
					
					 if(text != "") {
						 game.textZone = new TextZone(game.actualPanel, text);
						 TextZone.printTextZone(game.textZone, game);
					 }
				 }
			 }
		 }
		 return false;
	}

}
