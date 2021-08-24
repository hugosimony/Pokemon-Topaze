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
		return move == Moves.ACIDARMURE || move == Moves.ACUPRESSION || move == Moves.AFFUTAGE
			|| move == Moves.AIGUISAGE || move == Moves.ALLEGEMENT || move == Moves.AMNESIE
			|| move == Moves.APPEL_DEFENS || move == Moves.ARMURE || move == Moves.BOUCLIER
			|| move == Moves.BOUL_ARMURE || move == Moves.BRUME_CAPITEUSE || move == Moves.CHARGEUR
			|| move == Moves.CHGT_VITESSE || move == Moves.COGNOBIDON || move == Moves.COTOGARDE
			|| move == Moves.COUP_D_MAIN || move == Moves.CROISSANCE || move == Moves.DANSE_DRACO
			|| move == Moves.DANSE_LAMES || move == Moves.ENROULEMENT || move == Moves.EXUVIATION
			|| move == Moves.FERTILISATION || move == Moves.FORCE_COSMIQUE || move == Moves.GARDE_FLORALE
			|| move == Moves.GEO_CONTROLE || move == Moves.GONFLETTE || move == Moves.GRONDEMENT
			|| move == Moves.HATE || move == Moves.LILLIPUT || move == Moves.LUMIQUEUE
			|| move == Moves.MACHINATION || move == Moves.MAGNE_CONTROLE || move == Moves.MUR_DE_FER
			|| move == Moves.PAPILLODANSE || move == Moves.PLENITUDE || move == Moves.POLIROCHE
			|| move == Moves.RENGORGEMENT || move == Moves.REPLI || move == Moves.STOCKAGE
			|| move == Moves.YOGA || move == Moves.FLATTERIE || move == Moves.VANTARDISE;
	}
	
	public boolean isMalusNonOffensiveStatMove() {
		return move == Moves.ANTI_BRUME || move == Moves.BROUILLARD || move == Moves.CHATOUILLE
			|| move == Moves.CONFIDENCE || move == Moves.CROCO_LARME || move == Moves.DANSE_PLUMES
			|| move == Moves.DERNIER_MOT || move == Moves.DOUX_PARFUM || move == Moves.FLASH
			|| move == Moves.GRIMACE || move == Moves.GRINCEMENT || move == Moves.GROZ_YEUX
			|| move == Moves.JET_DE_SABLE || move == Moves.MIMI_QUEUE || move == Moves.ONDES_ETRANGES
			|| move == Moves.PIEGE_VENIN|| move == Moves.RALE_MALE || move == Moves.REGARD_TOUCHANT
			|| move == Moves.RUGISSEMENT || move == Moves.SECRETION || move == Moves.SEDUCTION
			|| move == Moves.SOUVENIR || move == Moves.SPORE_COTON || move == Moves.STRIDO_SON
			|| move == Moves.TELEKINESIE;
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
	
	public boolean isCriticalBoost() {
		return move == Moves.AEROBLAST || move == Moves.APPEL_ATTAK || move == Moves.COUP_CROIX
			|| move == Moves.COUPE_PSYCHO || move == Moves.GRIFFE_OMBRE || move == Moves.LAME_DE_ROC
			|| move == Moves.LAME_FEUILLE || move == Moves.POING_KARATE || move == Moves.PIED_BRULEUR
			|| move == Moves.PINCE_MASSE || move == Moves.POISON_CROIX || move == Moves.QUEUE_POISON
			|| move == Moves.SPATIO_RIFT || move == Moves.TRANCH_AIR || move == Moves.TRANCH_HERBE
			|| move == Moves.TRANCHE || move == Moves.TRANCHE_NUIT || move == Moves.TUNNELIER;
	}
	
	public boolean isAlwaysCritical() {
		return move == Moves.SOUFFLEGLACE || move == Moves.YAMA_ARASHI;
	}
}
