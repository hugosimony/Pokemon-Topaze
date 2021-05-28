package fr.hugosimony.pokemontopaze.pokemon;

import java.util.ArrayList;
import java.util.HashMap;

import fr.hugosimony.pokemontopaze.pokemon.items.Items;
import fr.hugosimony.pokemontopaze.pokemon.items.PokeBalls;
import fr.hugosimony.pokemontopaze.utils.Utils;

@SuppressWarnings("unused")
public class Pokemon {
	
	// TODO
	// Fix the move sets (moves at the same level or same moves at different levels)
	
	public PKM pokemon;
	public String name;
	public Nature nature;
	public int gender; // 0 = Neutre / 1 = Male / 2 = Femelle
	public Ability ability;
	public Type type1;
	public Type type2;
	public int level;
	private int xp; // https://www.pokepedia.fr/Exp%C3%A9rience
	public int xpToNextLevel; // https://www.pokepedia.fr/Courbe_d%27exp%C3%A9rience
	private int xpDropped;
	public int friendship;
	public boolean isKO;
	public Status status;
	public int HP;
	public int currentHP;
	public int ATK;
	public int ATK_SPE;
	public int DEF;
	public int DEF_SPE;
	public int SPEED;
	private int EV_PV;
	private int EV_ATK;
	private int EV_ATK_SPE;
	private int EV_DEF;
	private int EV_DEF_SPE;
	private int EV_SPEED;
	private int[] EV_DROPPED;
	private int IV_PV;
	private int IV_ATK;
	private int IV_ATK_SPE;
	private int IV_DEF;
	private int IV_DEF_SPE;
	private int IV_SPEED;
	public double weight;
	public Move move1;
	public Move move2;
	public Move move3;
	public Move move4;
	public Items item;
	public int catchRate;
	private PokeBalls ball;
	private String catchDressorName;
	public boolean shiny;
	
	private HashMap<Integer, ArrayList<Moves>> moveSetLvl;
	private ArrayList<Moves> moveSetCT;
	
	private int ID;
	
	public Pokemon(PKM pokemon, int level, Items item) {
		// Generate a random pokemon
		this.pokemon = pokemon;
		this.name = PKM.getGoodName(pokemon);
		this.level = level;
		this.item = item;
		initGlobalDatas();
		initEVs();
		initIVs();
		initNature();
		setStats();
		currentHP = HP;
		status = Status.NULL;
		isKO = false;
		
		initMoveSet();
		initMoves();
		
		initShiny();
		
		ID = Utils.randomNumber(0, Integer.MAX_VALUE);
		if(ID < 0) ID *= -1;
	}
	
	public Pokemon(PKM pokemon, String name, Nature nature, int gender, Ability ability, int level, int xp, int xpToNextLevel, boolean isKO, int HP, int currentHP, int ATK, int ATK_SPE, int DEF, int DEF_SPE, int SPEED, Move move1, Move move2, Move move3, Move move4, Items item, PokeBalls ball, String catchDressorName, boolean shiny, int ID) {
		
		this.pokemon = pokemon;
		this.name = name;
		this.nature = nature;
		this.gender = gender;
		this.ability = ability;
		this.level = level;
		this.xp = xp;
		this.xpToNextLevel = xpToNextLevel;

		this.isKO = isKO;
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
		
		this.ID = ID;
	}
	
	public void removeHP(int HP) {
		if(HP >= currentHP) {
			currentHP = 0;
			kill();
		}
		else 
			currentHP -= HP;
	}
	
	private void kill() {
		currentHP = 0;
		isKO = true;
	}
	
	public void gainXp(int xpGain) {
		if(xpGain >= xpToNextLevel) {
			levelUp();
			// TODO Set new xpToNextLevel
		}
		else
			xpToNextLevel -= xpGain;
	}
	
	private void levelUp() {
		level++;
		setStats();
	}
	
	private void initGlobalDatas() {
		String[] datas = PKM.getPokemonData(pokemon);
		// Types
		String type1S = datas[1].replace("é", "e").replace("è", "e").toUpperCase();
		String type2S = datas[2].replace("é", "e").replace("è", "e").toUpperCase();
		type1 = Type.getTypeFromString(type1S);
		type2 = Type.getTypeFromString(type2S);
		// Weight
		weight = Double.parseDouble(datas[5]);
		// Ability
		ability = new Ability(Abilities.NULL);
		int random = Utils.randomNumber(1, 20);
		if(!datas[8].equals("NULL")) {
			// Hidden ability
			if(random == 20)
				ability = new Ability(Abilities.getAbility(datas[8]));
		}
		if(ability.ability == Abilities.NULL) {
			if(Abilities.getAbility(datas[7]) != Abilities.NULL) {
				random = Utils.randomNumber(1, 2);
				ability = new Ability(Abilities.getAbility(datas[6]));
				if(random == 2)
					ability = new Ability(Abilities.getAbility(datas[7]));
			}
			else
				ability = new Ability(Abilities.getAbility(datas[6]));
		}
		// Gender
		gender = 0;
		double probaBoy = Double.parseDouble(datas[14]);
		double probaGirl = Double.parseDouble(datas[15]);
		if(probaBoy != 0 || probaGirl != 0) {
			if(probaBoy == 0)
				gender = 2;
			else {
				random = Utils.randomNumber(1, 1000);
				if(random <= probaBoy*10)
					gender = 1;
				else
					gender = 2;
			}
		}
		// Catch Rate
		catchRate = Integer.parseInt(datas[16]);
	}
	
	private void initEVs() {
		EV_PV = 0;
		EV_ATK = 0;
		EV_DEF = 0;
		EV_ATK_SPE = 0;
		EV_DEF_SPE = 0;
		EV_SPEED = 0;
	}
	
	private void initIVs() {
		IV_PV = Utils.randomNumber(0, 31);
		IV_ATK = Utils.randomNumber(0, 31);
		IV_DEF = Utils.randomNumber(0, 31);
		IV_ATK_SPE = Utils.randomNumber(0, 31);
		IV_DEF_SPE = Utils.randomNumber(0, 31);
		IV_SPEED = Utils.randomNumber(0, 31);
	}
	
	private void initNature() {
		int randomNature = Utils.randomNumber(0, 24);
		nature = Nature.values()[randomNature];
	}
	
	private void initMoveSet() {
		String[] moves = PKM.getMoveSet(pokemon);
		moveSetLvl = new HashMap<Integer, ArrayList<Moves>>();
		moveSetCT = new ArrayList<Moves>();
		if(!moves[0].equals("")) {
			String[] lvls = moves[0].split(",");
			for(String lvl : lvls) {
				String[] data = lvl.split(":");
				int lvl_ = Integer.parseInt(data[0]);
				ArrayList<Moves> a = new ArrayList<Moves>();
				if(moveSetLvl.containsKey(lvl_))
					a = moveSetLvl.get(lvl_);
				a.add(Moves.valueOf(data[1]));
				moveSetLvl.put(lvl_, a);
			}
		}
		if(!moves[1].equals("")) {
			String[] cts = moves[1].split(",");
			for(String ct : cts)
				moveSetCT.add(Moves.valueOf(ct));
		}
	}
	
	private void initMoves() {
		move1 = new Move(Moves.NULL);
		move2 = new Move(Moves.NULL);
		move3 = new Move(Moves.NULL);
		move4 = new Move(Moves.NULL);
		for(int i = level; i > 0 && move4.move == Moves.NULL; i--) {
			if(moveSetLvl.containsKey(i)) {
				ArrayList<Moves> moves = moveSetLvl.get(i);
				for(Moves move : moves) {
					if(move1.move == Moves.NULL)
						move1 = new Move(move);
					else if(move2.move == Moves.NULL)
						move2 = new Move(move);
					else if(move3.move == Moves.NULL)
						move3 = new Move(move);
					else if(move4.move == Moves.NULL)
						move4 = new Move(move);
				}
			}
		}
	}
	
	private void initShiny() {
		shiny = false;
		int random = Utils.randomNumber(1, 4096);
		if(random == 4096)
			shiny = true;
	}
	
	public void setStats() {
		if(pokemon == PKM.MUNJA)
			HP = 1;
		else
			HP = (int) ((long) (((2 * PKM.getBaseStats(pokemon)[0] + IV_PV + (long) (EV_PV / 4)) * level) / 100) + level + 10);
		ATK = (int) ((long) (((((2 * PKM.getBaseStats(pokemon)[1] + IV_ATK + (long) (EV_ATK / 4)) * level) / 100) + 5) * Nature.getModifier(nature, "ATT")));
		DEF = (int) ((long) (((((2 * PKM.getBaseStats(pokemon)[2] + IV_DEF + (long) (EV_DEF / 4)) * level) / 100) + 5) * Nature.getModifier(nature, "DEF")));
		ATK_SPE = (int) ((long) (((((2 * PKM.getBaseStats(pokemon)[3] + IV_ATK_SPE + (long) (EV_ATK_SPE / 4)) * level) / 100) + 5) * Nature.getModifier(nature, "SPE_ATT")));
		DEF_SPE = (int) ((long) (((((2 * PKM.getBaseStats(pokemon)[4] + IV_DEF_SPE + (long) (EV_DEF_SPE / 4)) * level) / 100) + 5) * Nature.getModifier(nature, "SPE_DEF")));
		SPEED = (int) ((long) (((((2 * PKM.getBaseStats(pokemon)[5] + IV_SPEED + (long) (EV_SPEED / 4)) * level) / 100) + 5) * Nature.getModifier(nature, "SPEED")));
	}
	
	public void printPokemon() {
		System.out.println("---------------------------------------");
		System.out.println("Data of " + name + " : ");
		System.out.println("ID : " + ID);
		System.out.println("Pokemon : " + PKM.getGoodName(pokemon));
		System.out.println("Nature : " + Nature.getGoodNatureName(nature));
		String gen = "Neutral"; if(gender != 0) gen = gender == 1 ? "Male" : "Female";
		System.out.println("Gender : " + gen);
		System.out.println("Ability : " + ability.name);
		System.out.println("Types : " + type1.name() + " ; " + type2.name());
		System.out.println("Level : " + level);
		System.out.println("XP : " + xp);
		System.out.println("XP to next level : " + xp);
		//System.out.println("XP dropped : " + xpDropped);
		System.out.println("Friendship : " + friendship);
		System.out.println("Is KO ? " + isKO);
		System.out.println("Status : " + status.name());
		System.out.println("Current HP : " + currentHP + " / " + HP);
		System.out.println("HP              : " + HP + " (IV : " + IV_PV + " | EV : " + EV_PV + ")");
		System.out.println("Attack          : " + ATK + " (IV : " + IV_ATK + " | EV : " + EV_ATK + ")");
		System.out.println("Defense         : " + DEF + " (IV : " + IV_DEF + " | EV : " + EV_DEF + ")");
		System.out.println("Special Attack  : " + ATK_SPE + " (IV : " + IV_ATK_SPE + " | EV : " + EV_ATK_SPE + ")");
		System.out.println("Special Defense : " + DEF_SPE + " (IV : " + IV_DEF_SPE + " | EV : " + EV_DEF_SPE + ")");
		System.out.println("Speed           : " + SPEED + " (IV : " + IV_SPEED + " | EV : " + EV_SPEED + ")");
		//if(EV_DROPPED != null) System.out.println("EV dropped : " + EV_DROPPED.toString());
		//System.out.println("Move set" + moveSetLvl.toString());
		//System.out.println("Move set CT " + moveSetCT.toString());
		System.out.println("Move 1 : " + move1.name);
		System.out.println("Move 2 : " + move2.name);
		System.out.println("Move 3 : " + move3.name);
		System.out.println("Move 4 : " + move4.name);
		System.out.println("Item : " + item.name());
		//System.out.println("Catch rate : " + catchRate);
		if(catchDressorName != null) {
			System.out.println("Dressor : " + catchDressorName);
			System.out.println("Ball : " + ball.name());
		}
		System.out.println("Shiny ? " + shiny);
		System.out.println("Weight : " + weight);
		System.out.println();
	}
	
}
