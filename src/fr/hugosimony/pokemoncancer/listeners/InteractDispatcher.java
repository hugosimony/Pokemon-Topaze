package fr.hugosimony.pokemoncancer.listeners;

import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import fr.hugosimony.pokemoncancer.Game;
import fr.hugosimony.pokemoncancer.Main;
import fr.hugosimony.pokemoncancer.Variables;
import fr.hugosimony.pokemoncancer.maps.Direction;
import fr.hugosimony.pokemoncancer.maps.pnj.Pnj;
import fr.hugosimony.pokemoncancer.maps.pnj.PnjText;
import fr.hugosimony.pokemoncancer.menus.TextZone;
import fr.hugosimony.pokemoncancer.pokemon.battle.Battle;
import fr.hugosimony.pokemoncancer.transitions.TransitionSimple;
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
			 if(event.getID() == KeyEvent.KEY_PRESSED && game.deplacement.released && !Main.settingsOn && !game.inTransition && !game.inBattle) {
				 int keyCode = event.getKeyCode();
				 
				 if(!game.inTextMenu && !game.inXMenu && !game.inSaveMenu && (keyCode == Variables.CONTROLS_A)){
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
							 game.pnjs.remove(pnj);
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
