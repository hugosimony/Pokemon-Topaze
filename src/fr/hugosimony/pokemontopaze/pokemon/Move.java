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
	
	public boolean doUnfreeze() {
		return move == Moves.ROUE_DE_FEU || move == Moves.FEU_SACRE || move == Moves.BOUTEFEU
			|| move == Moves.EBULLITION || move == Moves.FLAMME_CROIX || move == Moves.JET_DE_VAPEUR;
	}
	
	public boolean canMoveInSleep() {
		return move == Moves.BLABLA_DODO || move == Moves.RONFLEMENT;
	}
	
	public boolean doOHKO() {
		return move == Moves.ABIME || move == Moves.EMPAL_KORNE || move == Moves.GLACIATION
			|| move == Moves.GUILLOTINE;
	}
	
	public boolean isVariable() {
		return move == Moves.VAGUE_PSY || move == Moves.GYROBALLE || move == Moves.BOULE_ELEK
			|| move == Moves.BALAYAGE || move == Moves.NOEUD_HERBE || move == Moves.TACLE_FEU
			|| move == Moves.TACLE_LOURD || move == Moves.ERUPTION || move == Moves.GICLEDO
			|| move == Moves.CROC_FATAL || move == Moves.ESSORAGE || move == Moves.FRUSTRATION
			|| move == Moves.RETOUR;
	}
}
