package fr.hugosimony.pokemontopaze.pokemon;

public enum Status {

	BURN,
	FREEZE,
	PARALYSIS,
	POISON,
	SLEEP,
	
	ATTRACTION,
	CONFUSION,
	CURSE,
	FLINCH,
	LEACH_SEED,
	TRAPP,
	OVERLEVEL,
	
	NULL;
	
	public static boolean hasPreMoveEffect(Status status) {
		return status == FREEZE || status == PARALYSIS || status == SLEEP || status == ATTRACTION || status == CONFUSION || status == FLINCH || status == OVERLEVEL;
	}
	
}
