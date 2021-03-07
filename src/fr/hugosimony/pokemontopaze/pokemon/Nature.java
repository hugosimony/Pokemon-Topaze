package fr.hugosimony.pokemontopaze.pokemon;

public enum Nature {
	
	BOLD, QUIRKY, BRAVE, CALM, QUIET, DOCILE, MILD, RASH, GENTLE, HARDY, JOLLY, LAX,
	IMPISH, SASSY, NAUGHTY, MODEST, NAIVE, HASTY, CAREFUL, BASHFUL, RELAXED, ADAMANT,
	SERIOUS, LONELY, TIMID;
	
	public static double getModifier(Nature nature, String stat) {
		if(stat.equalsIgnoreCase("ATT")) {
			if(nature == BRAVE || nature == NAUGHTY || nature == ADAMANT || nature == LONELY)
				return 1.1;
			if(nature == BOLD || nature == CALM || nature == MODEST || nature == TIMID)
				return 0.9;
			return 1;
		}
		if(stat.equalsIgnoreCase("DEF")) {
			if(nature == BOLD || nature == LAX || nature == IMPISH || nature == RELAXED)
				return 1.1;
			if(nature == MILD || nature == GENTLE || nature == HASTY || nature == LONELY)
				return 0.9;
			return 1;
		}
		if(stat.equalsIgnoreCase("SPE_ATT")) {
			if(nature == QUIET || nature == MILD || nature == RASH || nature == MODEST)
				return 1.1;
			if(nature == JOLLY || nature == IMPISH || nature == CAREFUL || nature == ADAMANT)
				return 0.9;
			return 1;
		}
		if(stat.equalsIgnoreCase("SPE_DEF")) {
			if(nature == CALM || nature == GENTLE || nature == SASSY || nature == CAREFUL)
				return 1.1;
			if(nature == RASH || nature == LAX || nature == NAUGHTY || nature == NAIVE)
				return 0.9;
			return 1;
		}
		if(stat.equalsIgnoreCase("SPEED")) {
			if(nature == JOLLY || nature == NAIVE || nature == HASTY || nature == TIMID)
				return 1.1;
			if(nature == BRAVE || nature == QUIET || nature == SASSY || nature == RELAXED)
				return 0.9;
			return 1;
		}
		return 1;
	}
	
	public static String getGoodNatureName(Nature nature) {
		if(nature == BOLD)
			return "Assuré";
		if(nature == QUIRKY)
			return "Bizarre";
		if(nature == BRAVE)
			return "Brave";
		if(nature == CALM)
			return "Calme";
		if(nature == QUIET)
			return "Discret";
		if(nature == DOCILE)
			return "Docile";
		if(nature == MILD)
			return "Doux";
		if(nature == RASH)
			return "Foufou";
		if(nature == GENTLE)
			return "Gentil";
		if(nature == HARDY)
			return "Hardi";
		if(nature == JOLLY)
			return "Jovial";
		if(nature == LAX)
			return "Lâche";
		if(nature == IMPISH)
			return "Malin";
		if(nature == SASSY)
			return "Malpoli";
		if(nature == NAUGHTY)
			return "Mauvais";
		if(nature == MODEST)
			return "Modeste";
		if(nature == NAIVE)
			return "Naïf";
		if(nature == HASTY)
			return "Pressé";
		if(nature == CAREFUL)
			return "Prudent";
		if(nature == BASHFUL)
			return "Pudique";
		if(nature == RELAXED)
			return "Relax";
		if(nature == ADAMANT)
			return "Rigide";
		if(nature == SERIOUS)
			return "Sérieux";
		if(nature == LONELY)
			return "Solo";
		if(nature == TIMID)
			return "Timide";
		return "";
	}
}


