package fr.hugosimony.pokemoncancer.pokemon;

import fr.hugosimony.pokemoncancer.pokemon.items.Item;
import fr.hugosimony.pokemoncancer.pokemon.items.PokeBalls;

public class Pokémon {
	
	private PKM pokemon;
	private String name;
	private Nature nature;
	private Ability ability;
	private Type type1;
	private Type type2;
	private int level;
	private int xp;
	private boolean isDead;
	private int HP;
	private int currentHP;
	private int ATK;
	private int ATK_SPE;
	private int DEF;
	private int DEF_SPE;
	private int SPEED;
	private Move move1;
	private Move move2;
	private Move move3;
	private Move move4;
	private Item item;
	private PokeBalls ball;
	private String catchDressorName;
	private boolean shiny;
	
	public Pokémon(PKM pokemon, String name, Nature nature, Ability ability, int level, int xp, boolean isDead, int HP, int currentHP, int ATK, int ATK_SPE, int DEF, int DEF_SPE, int SPEED, Move move1, Move move2, Move move3, Move move4, Item item, PokeBalls ball, String catchDressorName, boolean shiny) {
		this.pokemon = pokemon;
		this.name = name;
		this.nature = nature;
		this.ability = ability;
		setTypes();
		this.level = level;
		this.xp = xp;
		this.isDead = isDead;
		this.HP = HP;
		this.currentHP = currentHP;
		this.ATK = ATK;
		this.ATK_SPE = ATK_SPE;
		this.DEF = DEF;
		this.DEF_SPE = DEF_SPE;
		this.SPEED = SPEED;
		this.move1 = move1;
		this.move2 = move2;
		this.move3 = move3;
		this.move4 = move4;
		this.item = item;
		this.ball = ball;
		this.catchDressorName = catchDressorName;
		this.shiny = shiny;
	}
	
	public void removeHP(int HP) {
		if(HP > currentHP) {
			currentHP = 0;
			kill();
		}
		else 
			currentHP -= HP;
	}
	
	private void kill() {
		currentHP = 0;
		isDead = true;
	}
	
	private void setTypes() {
		
	}
	
}
