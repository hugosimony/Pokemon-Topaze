package fr.hugosimony.pokemontopaze.pokemon.battle;

import javax.swing.ImageIcon;

import fr.hugosimony.pokemontopaze.Main;
import fr.hugosimony.pokemontopaze.pokemon.PKM;
import fr.hugosimony.pokemontopaze.pokemon.Pokemon;

public class BattleConst {

	//****************************************************************************************************
	// Backgrounds
	
	public static ImageIcon getBackground(String background) {
		return new ImageIcon(Main.class.getResource("pokemon/battle/backgrounds/background" + background + ".jpg"));
	}
	
	//****************************************************************************************************
	// Buttons
	
	public static final ImageIcon fightButton = new ImageIcon(Main.class.getResource("pokemon/battle/menus/fightButton.gif"));
	public static final ImageIcon bagButton = new ImageIcon(Main.class.getResource("pokemon/battle/menus/bagButton.gif"));
	public static final ImageIcon pokemonButton = new ImageIcon(Main.class.getResource("pokemon/battle/menus/pokemonButton.gif"));
	public static final ImageIcon runButton = new ImageIcon(Main.class.getResource("pokemon/battle/menus/runButton.gif"));
	public static ImageIcon getMoveButton(String move) {
		return new ImageIcon(Main.class.getResource("pokemon/battle/menus/moves/" + move + ".gif"));
	}
	
	//****************************************************************************************************
	// Databoxs
	
	public static final ImageIcon databoxHero1 = new ImageIcon(Main.class.getResource("pokemon/battle/menus/databoxHero1.gif"));
	public static final ImageIcon databoxHero2 = new ImageIcon(Main.class.getResource("pokemon/battle/menus/databoxHero2.gif"));
	public static final ImageIcon databoxTarget1 = new ImageIcon(Main.class.getResource("pokemon/battle/menus/databoxTarget1.gif"));
	public static final ImageIcon greenLife = new ImageIcon(Main.class.getResource("pokemon/battle/menus/greenLife.gif"));
	public static final ImageIcon orangeLife = new ImageIcon(Main.class.getResource("pokemon/battle/menus/orangeLife.gif"));
	public static final ImageIcon redLife = new ImageIcon(Main.class.getResource("pokemon/battle/menus/redLife.gif"));
	
	//****************************************************************************************************
	// Pokémon Sprites
	
	private static final String spritePath = "pokemon/sprites/";
	
	public static ImageIcon getSprite(PKM pokemon) {
		return new ImageIcon(Main.class.getResource(spritePath + pokemon.toString() + ".gif"));
	}
	
	public static String getAnimatedSprite(Pokemon pokemon, boolean back) {
		String side = back ? "2" : "1";
		String shiny = pokemon.shiny ? "S" : "";
		if(pokemon.gender == 2 && Main.class.getResource(spritePath + pokemon.pokemon.toString() + side + "F.gif") != null)
			return spritePath + pokemon.pokemon.toString() + side + "F" + shiny + ".gif";
		return spritePath + pokemon.pokemon.toString() + side + "M" + shiny + ".gif";
	}
	
}
