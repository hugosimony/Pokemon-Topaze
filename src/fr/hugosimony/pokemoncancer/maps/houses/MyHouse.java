package fr.hugosimony.pokemoncancer.maps.houses;

import java.awt.Color;
import java.awt.KeyboardFocusManager;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JPanel;

import fr.hugosimony.pokemoncancer.Const;
import fr.hugosimony.pokemoncancer.Game;
import fr.hugosimony.pokemoncancer.Main;
import fr.hugosimony.pokemoncancer.Variables;
import fr.hugosimony.pokemoncancer.listeners.DeplacementDispatcher;
import fr.hugosimony.pokemoncancer.listeners.InteractDispatcher;
import fr.hugosimony.pokemoncancer.listeners.MenuXDispatcher;
import fr.hugosimony.pokemoncancer.listeners.TextMenuDispatcher;
import fr.hugosimony.pokemoncancer.maps.Deplacement;
import fr.hugosimony.pokemoncancer.maps.Direction;
import fr.hugosimony.pokemoncancer.maps.Map;
import fr.hugosimony.pokemoncancer.maps.Places;
import fr.hugosimony.pokemoncancer.maps.perso.Pnj;
import fr.hugosimony.pokemoncancer.maps.towns.Selenia;
import fr.hugosimony.pokemoncancer.sounds.Sounds;
import fr.hugosimony.pokemoncancer.transitions.TransitionSimple;
import fr.hugosimony.pokemoncancer.utils.IntTuple;

public class MyHouse extends JPanel {
	private static final long serialVersionUID = 1L;

	private Game game;
	
	private Clip clipSeleniaTheme;
	
	private boolean up;
	private IntTuple toDownStairs;
	private IntTuple toUpStairs;
	private IntTuple toExit;
	
	private Pnj mom;
	
	public MyHouse(Game game, boolean up, int locationX, int locationY, Direction direction, int mapLocationX, int mapLocationY) {
		
		this.game = game;
		game.myHouse = this;
		this.up = up;
		
		setClickableTiles();
		setWalls();
		setPnjs();
		toDownStairs = new IntTuple(535, 172);
		toUpStairs = new IntTuple(151, 140);
		toExit = new IntTuple(343, 492);
		
		setLayout(null);
		setBackground(new Color(0, 0, 0));
		
		//****************************************************************************************************
		// Music
		
		try {
			AudioInputStream audioInput = AudioSystem.getAudioInputStream(Const.themeSelenia);
			clipSeleniaTheme = AudioSystem.getClip();
			clipSeleniaTheme.open(audioInput);
			Main.actualClip = clipSeleniaTheme;
			Main.refreshVolume();
			clipSeleniaTheme.start();
			clipSeleniaTheme.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
		
		//****************************************************************************************************
	    // Listener
		
		KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
		manager.addKeyEventDispatcher(new DeplacementDispatcher(game, this));
		manager.addKeyEventDispatcher(new InteractDispatcher(game, this));
		manager.addKeyEventDispatcher(new MenuXDispatcher(game, this));
		manager.addKeyEventDispatcher(new TextMenuDispatcher(game, this));
		
		//****************************************************************************************************
	    // Map
		
		Variables.POSITION_Place = Places.SELENIA;
		if(up) {
			game.map = new Map(1, 1);
			game.map.setLocation(mapLocationX, mapLocationY);
			game.map.setSize(10000,10000);
		}
		else {
			game.map = new Map(1, 0);
			game.map.setLocation(mapLocationX, mapLocationY);
			game.map.setSize(10000,10000);
			game.map.add(mom);
		}
		add(game.map);
		
		game.actualPanel = this;
		game.firstMove = false;
		game.deplacement = new Deplacement(game, locationX, locationY, direction, mapLocationX, mapLocationY);
	}
	
	private void setClickableTiles() {
		game.clickableTiles = new ArrayList<IntTuple>();
		
		if(up) {
			game.clickableTiles.add(new IntTuple(439, 140)); // SIGN
			game.clickableTiles.add(new IntTuple(343, 172)); // CONSOLE
			game.clickableTiles.add(new IntTuple(311, 172)); // TV
			game.clickableTiles.add(new IntTuple(279, 172)); // TRASH
			game.clickableTiles.add(new IntTuple(215, 172)); // BOOK
			game.clickableTiles.add(new IntTuple(535, 332)); // COMPUTER
		}
		else {
			game.clickableTiles.add(new IntTuple(439, 236)); // TV
			game.clickableTiles.add(new IntTuple(599, 140)); // TRASH
			game.clickableTiles.add(new IntTuple(599, 236)); // FOOD
		}
		
	}
	
	private void setWalls() {
		game.walls = new ArrayList<IntTuple>();
		
		if(up) {
			game.walls.add(new IntTuple(375, 140));
			game.walls.add(new IntTuple(407, 140));
			game.walls.add(new IntTuple(439, 140));
			game.walls.add(new IntTuple(471, 140));
			game.walls.add(new IntTuple(343, 172));
			game.walls.add(new IntTuple(311, 172));
			game.walls.add(new IntTuple(279, 172));
			game.walls.add(new IntTuple(247, 172));
			game.walls.add(new IntTuple(215, 172));
			game.walls.add(new IntTuple(183, 204));
			game.walls.add(new IntTuple(503, 204));
			game.walls.add(new IntTuple(535, 236));
			game.walls.add(new IntTuple(183, 236));
			game.walls.add(new IntTuple(215, 268));
			game.walls.add(new IntTuple(247, 268));
			game.walls.add(new IntTuple(279, 268));
			game.walls.add(new IntTuple(567, 268));
			game.walls.add(new IntTuple(567, 300));
			game.walls.add(new IntTuple(279, 300));
			game.walls.add(new IntTuple(247, 300));
			game.walls.add(new IntTuple(215, 300));
			game.walls.add(new IntTuple(503, 332));
			game.walls.add(new IntTuple(535, 332));
			game.walls.add(new IntTuple(183, 332));
			game.walls.add(new IntTuple(215, 364));
			game.walls.add(new IntTuple(503, 364));
			game.walls.add(new IntTuple(503, 396));
			game.walls.add(new IntTuple(215, 396));
			game.walls.add(new IntTuple(247, 428));
			game.walls.add(new IntTuple(279, 428));
			game.walls.add(new IntTuple(311, 428));
			game.walls.add(new IntTuple(343, 428));
			game.walls.add(new IntTuple(375, 428));
			game.walls.add(new IntTuple(407, 428));
			game.walls.add(new IntTuple(439, 428));
			game.walls.add(new IntTuple(471, 428));
		}
		else {
			game.walls.add(new IntTuple(215, 108));
			game.walls.add(new IntTuple(247, 108));
			game.walls.add(new IntTuple(279, 108));
			game.walls.add(new IntTuple(311, 108));
			game.walls.add(new IntTuple(343, 108));
			game.walls.add(new IntTuple(375, 108));
			game.walls.add(new IntTuple(407, 108));
			game.walls.add(new IntTuple(439, 108));
			game.walls.add(new IntTuple(503, 108));
			game.walls.add(new IntTuple(535, 108));
			game.walls.add(new IntTuple(567, 108));
			game.walls.add(new IntTuple(471, 140));
			game.walls.add(new IntTuple(599, 140));
			game.walls.add(new IntTuple(151, 172));
			game.walls.add(new IntTuple(183, 172));
			game.walls.add(new IntTuple(375, 172));
			game.walls.add(new IntTuple(471, 172));
			game.walls.add(new IntTuple(599, 172));
			game.walls.add(new IntTuple(119, 204));
			game.walls.add(new IntTuple(375, 204));
			game.walls.add(new IntTuple(439, 204));
			game.walls.add(new IntTuple(471, 204));
			game.walls.add(new IntTuple(599, 204));
			game.walls.add(new IntTuple(119, 236));
			game.walls.add(new IntTuple(375, 236));
			game.walls.add(new IntTuple(439, 236));
			game.walls.add(new IntTuple(471, 236));
			game.walls.add(new IntTuple(599, 236));
			game.walls.add(new IntTuple(151, 268));
			game.walls.add(new IntTuple(183, 268));
			game.walls.add(new IntTuple(215, 268));
			game.walls.add(new IntTuple(247, 268));
			game.walls.add(new IntTuple(375, 268));
			game.walls.add(new IntTuple(471, 268));
			game.walls.add(new IntTuple(599, 268));
			game.walls.add(new IntTuple(151, 300));
			game.walls.add(new IntTuple(183, 300));
			game.walls.add(new IntTuple(215, 300));
			game.walls.add(new IntTuple(247, 300));
			game.walls.add(new IntTuple(471, 300));
			game.walls.add(new IntTuple(631, 300));
			game.walls.add(new IntTuple(119, 332));
			game.walls.add(new IntTuple(631, 332));
			game.walls.add(new IntTuple(119, 364));
			game.walls.add(new IntTuple(247, 364));
			game.walls.add(new IntTuple(471, 364));
			game.walls.add(new IntTuple(503, 364));
			game.walls.add(new IntTuple(535, 364));
			game.walls.add(new IntTuple(631, 364));
			game.walls.add(new IntTuple(119, 396));
			game.walls.add(new IntTuple(183, 396));
			game.walls.add(new IntTuple(247, 396));
			game.walls.add(new IntTuple(439, 396));
			game.walls.add(new IntTuple(471, 396));
			game.walls.add(new IntTuple(503, 396));
			game.walls.add(new IntTuple(535, 396));
			game.walls.add(new IntTuple(567, 396));
			game.walls.add(new IntTuple(631, 396));
			game.walls.add(new IntTuple(119, 428));
			game.walls.add(new IntTuple(183, 428));
			game.walls.add(new IntTuple(247, 428));
			game.walls.add(new IntTuple(631, 428));
			game.walls.add(new IntTuple(151, 460));
			game.walls.add(new IntTuple(215, 460));
			game.walls.add(new IntTuple(279, 460));
			game.walls.add(new IntTuple(311, 460));
			game.walls.add(new IntTuple(375, 460));
			game.walls.add(new IntTuple(407, 460));
			game.walls.add(new IntTuple(439, 460));
			game.walls.add(new IntTuple(471, 460));
			game.walls.add(new IntTuple(503, 460));
			game.walls.add(new IntTuple(535, 460));
			game.walls.add(new IntTuple(567, 460));
			game.walls.add(new IntTuple(599, 460));
		}
	}
	
	private void setPnjs() {
		for(Pnj pnj : game.pnjs)
			pnj.clearIA();
		game.pnjs = new ArrayList<Pnj>();
		
		
		if(!up) {
			mom = new Pnj(game, "mom", Direction.DOWN, 0, 535, 204, false, false, null, null, false, false);
			mom.setLocation(535, 204);
			mom.setSize(50,70);
			game.pnjs.add(mom);
		}
	}
	
	public String getInteractMessage(IntTuple tuple) {
		 String text = "";
		 if(up) {
			 if(IntTuple.getPosition(game.clickableTiles, tuple) == 1) {
				 text = "Note : Appuyer sur X pour ouvrir le menu.";
			 }
			 else if(IntTuple.getPosition(game.clickableTiles, tuple) == 2) {
				 text = "C'est la console qui appartenait à Papa.= Elle est plus vielle que moi...=\n"
						+ "Pfff, il y a que des jeux nuls.";
			 }
			 else if(IntTuple.getPosition(game.clickableTiles, tuple) == 3) {
				 text = "Trop bien ! Touche pas à mon Pokémon != Mais bon... =le Prof Chen\n"
						 + " m'attends.";
			 }
			 else if(IntTuple.getPosition(game.clickableTiles, tuple) == 4) {
				 text = "Merde j'ai oublié de vider ma poubelle.= Faudra vraiment que je le\n"
						 + "fasse...= J'ai pas envie d'être puni" + Variables.LANG_Feminin + " pendant un mois.";
			 }
			 else if(IntTuple.getPosition(game.clickableTiles, tuple) == 5) {
				 text = "J'ai pas trop compris pourquoi, mais...= je vais avoir mon premier\n"
						 + "Pokémon != Par contre, le Prof est un peu bizarre avec ma mère...";
			 }
			 else if(IntTuple.getPosition(game.clickableTiles, tuple) == 6) {
				 text = "Le film d'hier soir était vraiment nul.";
			 }
		 }
		 else {
			 if(IntTuple.getPosition(game.clickableTiles, tuple) == 1) {
				 text = "Poké-Achat...= Maman c'est vraiment nul sérieux.";
			 }
			 else if(IntTuple.getPosition(game.clickableTiles, tuple) == 2) {
				 text = "C'est vide.";
			 }
			 else if(IntTuple.getPosition(game.clickableTiles, tuple) == 3) {
				 text = "Sah quel plaisir != Un bon Katsu Curry.";
			 }
		 }
		 return text;
	}
	
	public boolean checkMapChange() {
		
		if(isVisible()){
			
			if((game.deplacement.getLookingTile().equals(toDownStairs) && up) || (game.deplacement.getLookingTile().equals(toUpStairs) && !up) || (game.deplacement.getLookingTile().equals(toExit) && !up)) {
				 game.deplacement.hero.setVisible(false);
				 setVisible(false);
				 if(game.deplacement.getLookingTile().equals(toDownStairs) || game.deplacement.getLookingTile().equals(toUpStairs))
					 Sounds.playSound(Const.soundEnterHouse);
				 else
					 Sounds.playSound(Const.soundLeaveHouse);
				 Main.actualClip.close();
				 if(game.deplacement.getLookingTile().equals(toDownStairs)){
					 new TransitionSimple(game, game.gamePanel, new MyHouse(game, false, 215, 140, Direction.RIGHT, 170, 150));
				 }
				 else if(game.deplacement.getLookingTile().equals(toUpStairs)){
					 new TransitionSimple(game, game.gamePanel, new MyHouse(game, true, 471, 172, Direction.LEFT, -100, 100));
				 }
				 else {
					 new TransitionSimple(game, game.gamePanel, new Selenia(game, 982, 710, Direction.DOWN, -600, -400));
				 }
				 return true;
			}
		}
		return false;
	}
	
	
	
}
