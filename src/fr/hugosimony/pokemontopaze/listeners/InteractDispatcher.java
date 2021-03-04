package fr.hugosimony.pokemontopaze.listeners;

import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import fr.hugosimony.pokemontopaze.Game;
import fr.hugosimony.pokemontopaze.Main;
import fr.hugosimony.pokemontopaze.Variables;
import fr.hugosimony.pokemontopaze.maps.Direction;
import fr.hugosimony.pokemontopaze.maps.pnj.Pnj;
import fr.hugosimony.pokemontopaze.maps.pnj.PnjText;
import fr.hugosimony.pokemontopaze.menus.TextZone;
import fr.hugosimony.pokemontopaze.pokemon.battle.Battle;
import fr.hugosimony.pokemontopaze.transitions.TransitionSimple;
import fr.hugosimony.pokemontopaze.utils.IntTuple;

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
			 if(event.getID() == KeyEvent.KEY_PRESSED && game.deplacement.released && !Main.settingsOn && !game.inTransition && !game.inBattle) {
				 int keyCode = event.getKeyCode();
				 
				 if(!game.inTextMenu && !game.inAnimation && !game.inXMenu && !game.inSaveMenu && (keyCode == Variables.CONTROLS_A)){
					 IntTuple tuple = game.deplacement.getLookingTile();
					 String text = "";
					 
					 if(IntTuple.contains(game.clickableTiles, game.deplacement.getLookingTile())) {
						 if(game.myHouse != null && game.myHouse.isVisible())
							 text = game.myHouse.getInteractMessage(tuple);
						 else if(game.selenia != null && game.selenia.isVisible())
							 text = game.selenia.getInteractMessage(tuple);
						 else if(game.intertown1 != null && game.intertown1.isVisible())
							 text = game.intertown1.getInteractMessage(tuple);
						 else if(game.road01 != null && game.road01.isVisible())
							 text = game.road01.getInteractMessage(tuple);
						 else if(game.intertown2 != null && game.intertown2.isVisible())
							 text = game.intertown2.getInteractMessage(tuple);
					 }
					 else {
						 Pnj pnj = IntTuple.containsPnj(game.pnjs, game.deplacement.getLookingTile());
						 if(pnj != null && !pnj.mooving) {
							 
							 text = PnjText.getText(pnj.perso);
							 if(pnj.paraClick)
								 pnj.clearIA();
							 pnj.setSprites(new Pnj(game, pnj.perso, Direction.getOpositeDirection(game.deplacement.direction), 0, pnj.positionX, pnj.positionY, false, false, null, null, pnj.paraClick, pnj.mooving));
							 
							 //new TransitionSimple(game, game.gamePanel, new Battle(game, "test", "Water1", "good", game.actualPanel));
						 }
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
