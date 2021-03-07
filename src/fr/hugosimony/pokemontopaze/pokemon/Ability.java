package fr.hugosimony.pokemontopaze.pokemon;

public class Ability {

	public String name;
	public String battleDescription;
	public String fieldDescription;
	
	public Ability(Abilities ability) {
		
		String[] data = Abilities.getAbilityData(ability);
		name = data[0];
		battleDescription = data[1];
		fieldDescription = data[2];
	}
	
}
