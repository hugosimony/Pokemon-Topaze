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
	
	public static final double[][] table = 
		{
		//Targ-Send | ACIER | COMBAT | DRAGON |  EAU  | ELECTRIK |  FEE  |  FEU  | GLACE | INSECTE | NORMAL | PLANTE | POISON |  PSY  | ROCHE |  SOL  | SPECTRE | TENEBRES |  VOL  |
		/*ACIER*/	{  0.5  ,    2   ,   0.5  ,   1   ,     1    ,  0.5  ,   2   ,  0.5  ,   0.5   ,  0.5   ,   0.5  ,    0   ,  0.5  ,  0.5  ,   2   ,    1    ,    1     ,  0.5  },
		/*COMBAT*/	{   1   ,    1   ,    1   ,   1   ,     1    ,   2   ,   1   ,   1   ,   0.5   ,   1    ,    1   ,    1   ,   2   ,  0.5  ,   1   ,    1    ,   0.5    ,   2   },
		/*DRAGON*/	{   1   ,    1   ,    2   ,  0.5  ,    0.5   ,   2   ,  0.5  ,   2   ,    1    ,   1    ,   0.5  ,    1   ,   1   ,   1   ,   1   ,    1    ,    1     ,   1   },
		/*EAU*/		{  0.5  ,    1   ,    1   ,  0.5  ,     2    ,   1   ,  0.5  ,  0.5  ,    1    ,   1    ,    2   ,    1   ,   1   ,   1   ,   1   ,    1    ,    1     ,   1   },
		/*ELECTRIK*/{  0.5  ,    1   ,    1   ,   1   ,    0.5   ,   1   ,   1   ,   1   ,    1    ,   1    ,    1   ,    1   ,   1   ,   1   ,   2   ,    1    ,    1     ,  0.5  },
		/*FEE*/		{   2   ,   0.5  ,    0   ,   1   ,     1    ,   1   ,   1   ,   1   ,   0.5   ,   1    ,    1   ,    2   ,   1   ,   1   ,   1   ,    1    ,   0.5    ,   1   },
		/*FEU*/		{  0.5  ,    1   ,    1   ,   2   ,     1    ,  0.5  ,  0.5  ,  0.5  ,   0.5   ,   1    ,   0.5  ,    1   ,   1   ,   2   ,   2   ,    1    ,    1     ,   1   },
		/*GLACE*/	{   2   ,    2   ,    1   ,   1   ,     1    ,   1   ,   2   ,  0.5  ,    1    ,   1    ,    1   ,    1   ,   1   ,   2   ,   1   ,    1    ,    1     ,   1   },
		/*INSECTE*/	{   1   ,   0.5  ,    1   ,   1   ,     1    ,   1   ,   2   ,   1   ,    1    ,   1    ,   0.5  ,    1   ,   1   ,   2   ,  0.5  ,    1    ,    1     ,   2   },
		/*NORMAL*/	{   1   ,    2   ,    1   ,   1   ,     1    ,   1   ,   1   ,   1   ,    1    ,   1    ,    1   ,    1   ,   1   ,   1   ,   1   ,    0    ,    1     ,   1   },
		/*PLANTE*/	{   1   ,    1   ,    1   ,  0.5  ,    0.5   ,   1   ,   2   ,   2   ,    2    ,   1    ,   0.5  ,    2   ,   1   ,   1   ,  0.5  ,    1    ,    1     ,   2   },
		/*POISON*/	{   1   ,   0.5  ,    1   ,   1   ,     1    ,  0.5  ,   1   ,   1   ,   0.5   ,   1    ,   0.5  ,   0.5  ,   2   ,   1   ,   2   ,    1    ,    1     ,   1   },
		/*PSY*/		{   1   ,   0.5  ,    1   ,   1   ,     1    ,   1   ,   1   ,   1   ,    2    ,   1    ,    1   ,    1   ,  0.5  ,   1   ,   1   ,    2    ,    2     ,   1   },
		/*ROCHE*/	{   2   ,    2   ,    1   ,   2   ,     1    ,   1   ,  0.5  ,   1   ,    1    ,  0.5   ,    2   ,   0.5  ,   1   ,   1   ,   2   ,    1    ,    1     ,  0.5  },
		/*SOL*/		{   1   ,    1   ,    1   ,   2   ,     0    ,   1   ,   1   ,   2   ,    1    ,   1    ,    2   ,   0.5  ,   1   ,  0.5  ,   1   ,    1    ,    1     ,   1   },
		/*SPECTRE*/	{   1   ,    0   ,    1   ,   1   ,     1    ,   1   ,   1   ,   1   ,   0.5   ,   0    ,    1   ,   0.5  ,   1   ,   1   ,   1   ,    2    ,    2     ,   1   },
		/*TENEBRES*/{   1   ,    2   ,    1   ,   1   ,     1    ,   2   ,   1   ,   1   ,    2    ,   1    ,    1   ,    1   ,   0   ,   1   ,   1   ,   0.5   ,   0.5    ,   1   },
		/*VOL*/		{   1   ,   0.5  ,    1   ,   1   ,     2    ,   1   ,   1   ,   2   ,   0.5   ,   1    ,   0.5  ,    1   ,   1   ,   2   ,   0   ,    1    ,    1     ,   1   },
		};
	
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
	
	public int getIndex() {
		if(this == ACIER)
			return 0;
		if(this == COMBAT)
			return 1;
		if(this == DRAGON)
			return 2;
		if(this == EAU)
			return 3;
		if(this == ELECTRIK)
			return 4;
		if(this == FEE)
			return 5;
		if(this == FEU)
			return 6;
		if(this == GLACE)
			return 7;
		if(this == INSECTE)
			return 8;
		if(this == NORMAL)
			return 9;
		if(this == PLANTE)
			return 10;
		if(this == POISON)
			return 11;
		if(this == PSY)
			return 12;
		if(this == ROCHE)
			return 13;
		if(this == SOL)
			return 14;
		if(this == SPECTRE)
			return 15;
		if(this == TENEBRES)
			return 16;
		if(this == VOL)
			return 17;
		return -1;
	}
	
	public static double getMultiplier(Type sender, Type targetType1, Type targetType2) {
		if(targetType2 == AUCUN)
			return table[targetType1.getIndex()][sender.getIndex()];
		return table[targetType1.getIndex()][sender.getIndex()] * table[targetType2.getIndex()][sender.getIndex()];
	}
	
}
