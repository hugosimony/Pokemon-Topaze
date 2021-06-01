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
	
	public boolean isStatusMove() {
		// TODO do the list
		return move == Moves.TOXIK;
	}
	
	public boolean isBonusNonOffensiceStatMove() {
		return move == Moves.ACUPRESSION || move == Moves.DANSE_LAMES || move == Moves.AFFUTAGE
			|| move == Moves.DANSE_DRACO || move == Moves.GONFLETTE || move == Moves.GRONDEMENT
			|| move == Moves.MALEDICTION || move == Moves.YOGA || move == Moves.BOUCLIER
			|| move == Moves.MUR_DE_FER || move == Moves.ACIDARMURE || move == Moves.FORCE_COSMIQUE
			|| move == Moves.APPEL_DEFENS || move == Moves.BOUL_ARMURE || move == Moves.ARMURE
			|| move == Moves.STOCKAGE || move == Moves.REPLI || move == Moves.MACHINATION
			|| move == Moves.LUMIQUEUE || move == Moves.PLENITUDE || move == Moves.CROISSANCE
			|| move == Moves.FLATTERIE || move == Moves.AMNESIE || move == Moves.CHARGEUR
			|| move == Moves.GRAVITE || move == Moves.REFLET || move == Moves.LILLIPUT
			|| move == Moves.ENROULEMENT || move == Moves.TELEKINESIE || move == Moves.JET_DE_SABLE
			|| move == Moves.BROUILLARD;
	}
	
	public boolean isMalusNonOffensiveStatMove() {
		// TODO do the list
		return move == Moves.CHARME;
	}
	
	public boolean isBonusOffensiveStatMove() {
		// TODO do the list
		return move == Moves.FRENESIE;
	}
	
	public boolean isMalusOffensiveStatMove() {
		// TODO do the list
		return move == Moves.FRENESIE;
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
	
	public boolean isSound() {
		return move == Moves.ABOIEMENT || move == Moves.BABIL || move == Moves.BANG_SONIQUE
			|| move == Moves.BERCEUSE || move == Moves.BROUHAHA || move == Moves.CHANTANTIQUE
			|| move == Moves.CHANT_CANON || move == Moves.CONFIDENCE || move == Moves.DERNIER_MOT
			|| move == Moves.ECHO || move == Moves.GLAS_DE_SOIN || move == Moves.HURLEMENT
			|| move == Moves.MEGAPHONE || move == Moves.RALE_MALE || move == Moves.REQUIEM
			|| move == Moves.RONFLEMENT || move == Moves.RUGISSEMENT || move == Moves.SIFFL_HERBE
			|| move == Moves.ULTRASON || move == Moves.VOIX_ENJOLEUSE;
	}
}
