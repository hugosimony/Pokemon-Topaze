package fr.hugosimony.pokemontopaze.pokemon;

public class PokemonInfos {

	public int pokedex;
	public Type type1;
	public Type type2;
	// https://www.pokepedia.fr/Liste_des_Pokémon_avec_des_évolutions_spéciales
	public int evolutionLevel;
	
	public PokemonInfos(int pokedex, Type type1, Type type2) {
		this.pokedex = pokedex;
		this.type1 = type1;
		this.type2 = type2;
	}
	
}
