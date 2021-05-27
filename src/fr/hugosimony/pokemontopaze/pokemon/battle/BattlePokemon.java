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

	public PKM pkm;
	public String name;
	public Nature nature;
	public int gender;
	public Ability ability; // https://www.pokemontrash.com/pokedex/liste-capacites.php
	public Type type1;
	public Type type2;
	public int level;
	public int xpToNextLevel;
	public int friendship;
	public int currentHP;
	public boolean isKO;
	public Status status;
	public int statusTurn;
	public int HP;
	public int ATK;
	public int ATK_SPE;
	public int DEF;
	public int DEF_SPE;
	public int SPEED;
	public int stageATK;
	public int stageATK_SPE;
	public int stageDEF;
	public int stageDEF_SPE;
	public int stageSPEED;
	public int stageACCURACY;
	public int stageAVOIDANCE;
	public boolean onTwoTurnAttack;
	public double weight; // https://www.pokepedia.fr/Poids
	public Move move1;
	public Move move2;
	public Move move3;
	public Move move4;
	public Item item;

	public ArrayList<Status> secondaryStatus;
	public int confusionTurn;
	
	public BattlePokemon(Pokemon pokemon) {
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
		this.stageATK = 0;
		this.stageATK_SPE = 0;
		this.stageDEF = 0;
		this.stageDEF_SPE = 0;
		this.stageSPEED = 0;
		this.stageACCURACY = 0;
		this.stageAVOIDANCE = 0;
		this.onTwoTurnAttack = false;
		this.weight = pokemon.weight;
		this.move1 = pokemon.move1;
		this.move2 = pokemon.move2;
		this.move3 = pokemon.move3;
		this.move4 = pokemon.move4;
		this.item = new Item(pokemon.item);
		this.secondaryStatus = new ArrayList<Status>();
	}
	
	public int getGeneralStatMultiplicator(int stat, int stage) {
		if(stage == -6)
			return stat * (2/8);
		if(stage == -5)
			return stat * (2/7);
		if(stage == -4)
			return stat * (2/6);
		if(stage == -3)
			return stat * (2/5);
		if(stage == -2)
			return stat * (2/4);
		if(stage == -1)
			return stat * (2/3);
		if(stage == 0)
			return stat;
		if(stage == 1)
			return stat * (3/2);
		if(stage == 2)
			return stat * 2;
		if(stage == 3)
			return stat * (5/2);
		if(stage == 4)
			return stat * 3;
		if(stage == 5)
			return stat * (7/2);
		if(stage == 6)
			return stat * 4;
		System.err.println("The stat stage is not correct.");
		return -1;
	}
	
	public int getAccuracyStatMultiplicator(int precision, int stage, boolean accuracy) {
		if(!accuracy)
			stage *= -1;
		if(stage == -6)
			return precision * (3/9);
		if(stage == -5)
			return precision * (3/8);
		if(stage == -4)
			return precision * (3/7);
		if(stage == -3)
			return precision * (3/6);
		if(stage == -2)
			return precision * (3/5);
		if(stage == -1)
			return precision * (3/4);
		if(stage == 0)
			return precision;
		if(stage == 1)
			return precision * (4/3);
		if(stage == 2)
			return precision * (5/3);
		if(stage == 3)
			return precision * 2;
		if(stage == 4)
			return precision * (7/3);
		if(stage == 5)
			return precision * (8/3);
		if(stage == 6)
			return precision * 3;
		System.err.println("The stat stage is not correct.");
		return -1;
	}
	
	public int getStat(String stat) {
		if(stat.equals("ATK"))
			return getGeneralStatMultiplicator(ATK, stageATK);
		if(stat.equals("ATK_SPE"))
			return getGeneralStatMultiplicator(ATK_SPE, stageATK_SPE);
		if(stat.equals("DEF"))
			return getGeneralStatMultiplicator(DEF, stageDEF);
		if(stat.equals("DEF_SPE"))
			return getGeneralStatMultiplicator(DEF_SPE, stageDEF_SPE);
		if(stat.equals("SPEED"))
			return getGeneralStatMultiplicator(SPEED, stageSPEED);
		System.err.println("The stat is not correct.");
		return -1;
	}
	
	public int getAccuracy(String stat, int precision) {
		if(stat.equals("PRECISION"))
			return getAccuracyStatMultiplicator(precision, stageACCURACY, true);
		if(stat.equals("AVOIDANCE"))
			return getAccuracyStatMultiplicator(precision, stageACCURACY, false);
		System.err.println("The stat is not correct.");
		return -1;
	}
}
