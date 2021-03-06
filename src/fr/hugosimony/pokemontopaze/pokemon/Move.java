package fr.hugosimony.pokemontopaze.pokemon;

public class Move {

	public String name;
	public String description;
	public Type type;
	public Type category;
	public int power;
	public int precision;
	public int pp;
	
	public Move(Moves move) {
		
		String[] data = Moves.getMoveData(move);
		name = data[0];
		description = data[2];
		type = Type.getTypeFromString(data[1]);
		category = Type.getCategoryFromString(data[6]);
		power = Integer.parseInt(data[3]);
		precision = Integer.parseInt(data[4]);
		pp = Integer.parseInt(data[5]);
	}
	
}
