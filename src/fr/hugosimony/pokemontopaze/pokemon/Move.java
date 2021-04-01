package fr.hugosimony.pokemontopaze.pokemon;

public class Move {

	public Moves move;
	public String name;
	public String description;
	public Type type;
	public Type category;
	public int power;
	public int precision;
	public int ppMax;
	public int pp;
	
	public Move(Moves move) {
		
		this.move = move;
		String[] data = Moves.getMoveData(move);
		name = data[0];
		description = data[2];
		type = Type.getTypeFromString(data[1]);
		category = Type.getCategoryFromString(data[6]);
		power = data[3].equals("-") ? -1 :Integer.parseInt(data[3]);
		precision = data[4].equals("-") ? 1000 : Integer.parseInt(data[4]);
		ppMax = data[5].equals("-") ? -1 : Integer.parseInt(data[5]);
		pp = ppMax;
	}
	
}
