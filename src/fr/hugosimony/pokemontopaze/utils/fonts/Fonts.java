package fr.hugosimony.pokemontopaze.utils.fonts;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.net.URL;

import fr.hugosimony.pokemontopaze.Main;

public class Fonts {
	
	public static final URL FONT_POKEMON = Main.class.getResource("utils/fonts/pokemonFont.ttf");
	
	public static void loadFonts() {
		try {
	        File fontFile = new File(FONT_POKEMON.toURI());
	        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
	        System.out.println(font.getFontName());
	        GraphicsEnvironment ge = GraphicsEnvironment
	                .getLocalGraphicsEnvironment();
	        ge.registerFont(font);
	    } catch (Exception ex) {
	    	System.out.println("Error while loading a font.");
	    }
	}
	
}
