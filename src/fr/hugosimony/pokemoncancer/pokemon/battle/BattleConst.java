package fr.hugosimony.pokemoncancer.pokemon.battle;

import java.net.URL;
import java.nio.file.Paths;

import javax.swing.ImageIcon;

import fr.hugosimony.pokemoncancer.Main;
import fr.hugosimony.pokemoncancer.pokemon.PKM;
import fr.hugosimony.pokemoncancer.pokemon.Pokemon;

public class BattleConst {

	//****************************************************************************************************
	// Backgrounds
	
	public static ImageIcon getBackground(String background) {
		return new ImageIcon(Main.class.getResource(Paths.get("pokemon/battle/backgrounds/background" + background + ".jpg").toString()));
	}
	
	//****************************************************************************************************
	// Buttons
	
	private static final URL fightButtonURL = Main.class.getResource("pokemon/battle/menus/fightButton.gif");
	public static final ImageIcon fightButton = new ImageIcon(fightButtonURL);
	private static final URL bagButtonURL = Main.class.getResource("pokemon/battle/menus/bagButton.gif");
	public static final ImageIcon bagButton = new ImageIcon(bagButtonURL);
	private static final URL pokemonButtonURL = Main.class.getResource("pokemon/battle/menus/pokemonButton.gif");
	public static final ImageIcon pokemonButton = new ImageIcon(pokemonButtonURL);
	private static final URL runButtonURL = Main.class.getResource("pokemon/battle/menus/runButton.gif");
	public static final ImageIcon runButton = new ImageIcon(runButtonURL);
	
	//****************************************************************************************************
	// Pokémon Sprites
	
	private static final String spritePath = "pokemon/sprites/";
	
	public static ImageIcon getSprite(PKM pokemon) {
		return new ImageIcon(Main.class.getResource(spritePath + pokemon.toString() + ".gif"));
	}
	
	public static ImageIcon getAnimatedSprite(Pokemon pokemon, boolean back) {
		String side = back ? "2" : "1";
		String shiny = pokemon.shiny ? "S" : "";
		if(pokemon.gender == 2 && Main.class.getResource(spritePath + pokemon.pokemon.toString() + side + "F.gif") != null)
			return new ImageIcon(Main.class.getResource(spritePath + pokemon.pokemon.toString() + side + "F" + shiny + ".gif"));
		return new ImageIcon(Main.class.getResource(spritePath + pokemon.pokemon.toString() + side + "M" + shiny + ".gif"));
	}
	
}
