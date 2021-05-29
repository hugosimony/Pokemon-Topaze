package fr.hugosimony.pokemontopaze.listeners;

import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

import fr.hugosimony.pokemontopaze.Game;
import fr.hugosimony.pokemontopaze.Main;
import fr.hugosimony.pokemontopaze.Variables;
import fr.hugosimony.pokemontopaze.maps.Direction;
import fr.hugosimony.pokemontopaze.maps.pnj.Pnj;
import fr.hugosimony.pokemontopaze.maps.pnj.PnjText;
import fr.hugosimony.pokemontopaze.menus.TextZone;
import fr.hugosimony.pokemontopaze.pokemon.PKM;
import fr.hugosimony.pokemontopaze.pokemon.Pokemon;
import fr.hugosimony.pokemontopaze.pokemon.battle.PokemonSprite;
import fr.hugosimony.pokemontopaze.pokemon.items.Items;
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
					 
					 if(IntTuple.contains(game.clickableTiles, tuple)) {
						 if(game.myHouse != null && game.myHouse.isVisible())
							 text = game.myHouse.getInteractMessage(tuple);
						 else if(game.selenia != null && game.selenia.isVisible())
							 text = game.selenia.getInteractMessage(tuple);
						 else if(game.rivalHouse != null && game.rivalHouse.isVisible())
							 text = game.rivalHouse.getInteractMessage(tuple);
						 else if(game.intertown01 != null && game.intertown01.isVisible())
							 text = game.intertown01.getInteractMessage(tuple);
						 else if(game.road01 != null && game.road01.isVisible())
							 text = game.road01.getInteractMessage(tuple);
						 else if(game.intertown02 != null && game.intertown02.isVisible())
							 text = game.intertown02.getInteractMessage(tuple);
						 else if(game.villaube != null && game.villaube.isVisible())
							 text = game.villaube.getInteractMessage(tuple);
						 else if(game.pokemonCenter01 != null && game.pokemonCenter01.isVisible())
							 text = game.pokemonCenter01.getInteractMessage(tuple);
						 else if(game.mart01 != null && game.mart01.isVisible())
							 text = game.mart01.getInteractMessage(tuple);
					 }
					 else {
						 Pnj pnj = IntTuple.containsPnj(game.pnjs, tuple);
						 if(pnj != null && !pnj.mooving) {
							 text = PnjText.getText(pnj.perso);
							 if(pnj.paraClick)
								 pnj.clearIA();
							 pnj.setSprites(new Pnj(game, pnj.perso, Direction.getOpositeDirection(game.deplacement.direction), 0, pnj.positionX, pnj.positionY, pnj.IA, false, pnj.directions, pnj.IAMoving, pnj.paraClick, pnj.mooving));
							 game.deplacement.setSprites();
						 }
					 }
					
					 if(text != "") {
						 game.textZone = new TextZone(game.actualPanel, text);
						 TextZone.printTextZone(game.textZone, game);
					 }
				 }
			 }
		 }
		 //********************************************************************************************
		 // DEBUG
		 if(event.getID() == KeyEvent.KEY_PRESSED && game.inBattle) {
			 int keyCode = event.getKeyCode();
			 if(keyCode == KeyEvent.VK_A) {
				 game.battle.x++;
				 game.battle.remove(game.battle.sprite1);
				 game.battle.remove(game.battle.sprite2);
				 game.battle.repaint();
				 game.battle.sprite1.setVisible(false);
				 game.battle.sprite2.setVisible(false);
				 Pokemon pokemon1 = new Pokemon(PKM.values()[game.battle.x], 50, Items.NONE);
				 Pokemon pokemon2 = new Pokemon(PKM.values()[game.battle.x], 50, Items.NONE);
				 try {
					 game.battle.sprite1 = new PokemonSprite(pokemon1, false);
					 game.battle.add(game.battle.sprite1);
					 game.battle.sprite2 = new PokemonSprite(pokemon2, true);
					 game.battle.add(game.battle.sprite2);
				 } catch (IOException e) {}
			 }
			 else if(keyCode == KeyEvent.VK_B) {
				 game.battle.x--;
				 game.battle.remove(game.battle.sprite1);
				 game.battle.remove(game.battle.sprite2);
				 game.battle.repaint();
				 game.battle.sprite1.setVisible(false);
				 game.battle.sprite2.setVisible(false);
				 Pokemon pokemon1 = new Pokemon(PKM.values()[game.battle.x], 50, Items.NONE);
				 Pokemon pokemon2 = new Pokemon(PKM.values()[game.battle.x], 50, Items.NONE);
				 try {
					 game.battle.sprite1 = new PokemonSprite(pokemon1, false);
					 game.battle.add(game.battle.sprite1);
					 game.battle.sprite2 = new PokemonSprite(pokemon2, true);
					 game.battle.add(game.battle.sprite2);
				 } catch (IOException e) {}
			 }
			 else if(keyCode == KeyEvent.VK_NUMPAD1) {
				 new Timer().scheduleAtFixedRate(new TimerTask() {
					@Override
					public void run() {
						if(game.battle.battlePokemon2.currentHP <= 1)
							this.cancel();
						else {
							game.battle.battlePokemon2.currentHP--;
							game.battle.playerBox.updateHp(game.battle.battlePokemon2);
						}
					}
				}, 0, 30);
			 }
			 else if(keyCode == KeyEvent.VK_NUMPAD2) {
				 new Timer().scheduleAtFixedRate(new TimerTask() {
					@Override
					public void run() {
						if(game.battle.battlePokemon2.currentHP <= (int) (game.battle.battlePokemon2.HP / 3))
							this.cancel();
						else {
							game.battle.battlePokemon2.currentHP--;
							game.battle.playerBox.updateHp(game.battle.battlePokemon2);
						}
					}
				}, 0, 30);
			 }
			 else if(keyCode == KeyEvent.VK_NUMPAD3) {
				 new Timer().scheduleAtFixedRate(new TimerTask() {
					@Override
					public void run() {
						if(game.battle.battlePokemon2.HP <= game.battle.battlePokemon2.currentHP)
							this.cancel();
						else {
							game.battle.battlePokemon2.currentHP++;
							game.battle.playerBox.updateHp(game.battle.battlePokemon2);
						}
					}
				}, 0, 30);
			 }
			 else if(keyCode == KeyEvent.VK_NUMPAD4) {
				 new Timer().scheduleAtFixedRate(new TimerTask() {
					@Override
					public void run() {
						if(game.battle.battlePokemon1.currentHP <= 1)
							this.cancel();
						else {
							game.battle.battlePokemon1.currentHP--;
							game.battle.opponentBox.updateHp(game.battle.battlePokemon1);
						}
					}
				}, 0, 30);
			 }
			 else if(keyCode == KeyEvent.VK_NUMPAD5) {
				 new Timer().scheduleAtFixedRate(new TimerTask() {
					@Override
					public void run() {
						if(game.battle.battlePokemon1.currentHP <= (int) (game.battle.battlePokemon1.HP / 3))
							this.cancel();
						else {
							game.battle.battlePokemon1.currentHP--;
							game.battle.opponentBox.updateHp(game.battle.battlePokemon1);
						}
					}
				}, 0, 30);
			 }
			 else if(keyCode == KeyEvent.VK_NUMPAD6) {
				 new Timer().scheduleAtFixedRate(new TimerTask() {
					@Override
					public void run() {
						if(game.battle.battlePokemon1.HP <= game.battle.battlePokemon1.currentHP)
							this.cancel();
						else {
							game.battle.battlePokemon1.currentHP++;
							game.battle.opponentBox.updateHp(game.battle.battlePokemon1);
						}
					}
				}, 0, 30);
			 }
		 }
		 return false;
	}

}
