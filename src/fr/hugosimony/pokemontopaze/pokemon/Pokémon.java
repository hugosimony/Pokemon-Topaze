package fr.hugosimony.pokemontopaze.pokemon;

import fr.hugosimony.pokemontopaze.pokemon.items.Item;
import fr.hugosimony.pokemontopaze.pokemon.items.PokeBalls;

public class Pokémon {
	
	public PKM pokemon;
	private String name;
	private Nature nature;
	public int gender; // 0 = Neutre / 1 = Male / 2 = Femelle
	private Ability ability;
	private Type type1;
	private Type type2;
	private int level;
	private int xp;
	private int xpToNextLevel;
	private int friendship;
	private boolean isKo;
	private int HP;
	private int currentHP;
	private int ATK;
	private int ATK_SPE;
	private int DEF;
	private int DEF_SPE;
	private int SPEED;
	private int EV_PV;
	private int EV_ATK;
	private int EV_ATK_SPE;
	private int EV_DEF;
	private int EV_DEF_SPE;
	private int EV_SPEED;
	private int IV_PV;
	private int IV_ATK;
	private int IV_ATK_SPE;
	private int IV_DEF;
	private int IV_DEF_SPE;
	private int IV_SPEED;
	private Move move1;
	private Move move2;
	private Move move3;
	private Move move4;
	private Item item;
	private PokeBalls ball;
	private String catchDressorName;
	public boolean shiny;
	
	public Pokémon(PKM pokemon, String name, Nature nature, int gender, Ability ability, int level, int xp, boolean isKo, int HP, int currentHP, int ATK, int ATK_SPE, int DEF, int DEF_SPE, int SPEED, Move move1, Move move2, Move move3, Move move4, Item item, PokeBalls ball, String catchDressorName, boolean shiny) {
		this.pokemon = pokemon;
		this.name = name;
		this.nature = nature;
		this.gender = gender;
		this.ability = ability;
		setTypes();

		this.isKo = isKo;
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
		if(HP >= currentHP) {
			currentHP = 0;
			kill();
		}
		else 
			currentHP -= HP;
	}
	
	private void kill() {
		currentHP = 0;
		isKo = true;
	}
	
	public void gainXp(int xpGain) {
		if(xpGain >= xpToNextLevel) {
			levelUp();
			// Set new xpToNextLevel
		}
		else
			xpToNextLevel -= xpGain;
	}
	
	private void levelUp() {
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
	
	private void setTypes() {
		
	}
	
}
