package fr.hugosimony.pokemontopaze.pokemon.battle;

import java.util.ArrayList;

import fr.hugosimony.pokemontopaze.pokemon.Ability;
import fr.hugosimony.pokemontopaze.pokemon.Move;
import fr.hugosimony.pokemontopaze.pokemon.Nature;
import fr.hugosimony.pokemontopaze.pokemon.PKM;
import fr.hugosimony.pokemontopaze.pokemon.Pokemon;
import fr.hugosimony.pokemontopaze.pokemon.Status;
import fr.hugosimony.pokemontopaze.pokemon.Type;
import fr.hugosimony.pokemontopaze.pokemon.items.Item;

public class BattlePokemon {

	private Battle battle;
	public PKM pkm;
	public String name;
	public Nature nature;
	public int gender;
	public Ability ability;
	public Type type1;
	public Type type2;
	public int level;
	public int xpToNextLevel;
	public int friendship;
	public int currentHP;
	public boolean isKO;
	public Status status;
	public int HP;
	public int ATK;
	public int ATK_SPE;
	public int DEF;
	public int DEF_SPE;
	public int SPEED;
	public double weight;
	public Move move1;
	public Move move2;
	public Move move3;
	public Move move4;
	public Item item;
	
	private int BOOST_ATK;
	private int BOOST_ATK_SPE;
	private int BOOST_DEF;
	private int BOOST_DEF_SPE;
	private int BOOST_SPEED;
	private ArrayList<Status> secondaryStatus;
	
	public BattlePokemon(Battle battle, Pokemon pokemon) {
		this.battle = battle;
		this.pkm = pokemon.pokemon;
		this.name = pokemon.name;
		this.nature = pokemon.nature;
		this.gender = pokemon.gender;
		this.ability = pokemon.ability;
		this.type1 = pokemon.type1;
		this.type2 = pokemon.type2;
		this.level = pokemon.level;
		this.xpToNextLevel = pokemon.xpToNextLevel;
		this.friendship = pokemon.friendship;
		this.currentHP = pokemon.currentHP;
		this.isKO = pokemon.isKO;
		this.status = pokemon.status;
		this.HP = pokemon.HP;
		this.ATK = pokemon.ATK;
		this.ATK_SPE = pokemon.ATK_SPE;
		this.DEF = pokemon.DEF;
		this.DEF_SPE = pokemon.DEF_SPE;
		this.SPEED = pokemon.SPEED;
		this.weight = pokemon.weight;
		this.move1 = pokemon.move1;
		this.move2 = pokemon.move2;
		this.move3 = pokemon.move3;
		this.move4 = pokemon.move4;
		this.item = pokemon.item;
		BOOST_ATK = 0;
		BOOST_ATK_SPE = 0;
		BOOST_DEF = 0;
		BOOST_DEF_SPE = 0;
		BOOST_SPEED = 0;
		secondaryStatus = new ArrayList<Status>();
	}
}
