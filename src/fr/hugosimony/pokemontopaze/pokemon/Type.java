package fr.hugosimony.pokemontopaze.pokemon;

public enum Type {

	ACIER,
	COMBAT,
	DRAGON,
	EAU,
	ELECTRIK,
	FEE,
	FEU,
	GLACE,
	INSECTE,
	NORMAL,
	PLANTE,
	POISON,
	PSY,
	ROCHE,
	SOL,
	SPECTRE,
	TENEBRES,
	VOL,
	
	PHYSIQUE,
	SPECIALE,
	STATUT,
	
	AUCUN,
	
	NULL;
	
	public static Type getTypeFromString(String type) {
		if(type.equalsIgnoreCase("ACIER"))
			return ACIER;
		if(type.equalsIgnoreCase("COMBAT"))
			return COMBAT;
		if(type.equalsIgnoreCase("DRAGON"))
			return DRAGON;
		if(type.equalsIgnoreCase("EAU"))
			return EAU;
		if(type.equalsIgnoreCase("ELECTRIK"))
			return ELECTRIK;
		if(type.equalsIgnoreCase("FEE"))
			return FEE;
		if(type.equalsIgnoreCase("FEU"))
			return FEU;
		if(type.equalsIgnoreCase("GLACE"))
			return GLACE;
		if(type.equalsIgnoreCase("INSECTE"))
			return INSECTE;
		if(type.equalsIgnoreCase("NORMAL"))
			return NORMAL;
		if(type.equalsIgnoreCase("PLANTE"))
			return PLANTE;
		if(type.equalsIgnoreCase("POISON"))
			return POISON;
		if(type.equalsIgnoreCase("PSY"))
			return PSY;
		if(type.equalsIgnoreCase("ROCHE"))
			return ROCHE;
		if(type.equalsIgnoreCase("SOL"))
			return SOL;
		if(type.equalsIgnoreCase("SPECTRE"))
			return SPECTRE;
		if(type.equalsIgnoreCase("TENEBRES"))
			return TENEBRES;
		if(type.equalsIgnoreCase("VOL"))
			return VOL;
		return AUCUN;
	}
	
	public static Type getCategoryFromString(String category) {
		if(category.equalsIgnoreCase("PHYSIQUE"))
			return PHYSIQUE;
		if(category.equalsIgnoreCase("SPECIALE"))
			return SPECIALE;
		if(category.equalsIgnoreCase("STATUT"))
			return STATUT;
		return AUCUN;
	}
	
}
