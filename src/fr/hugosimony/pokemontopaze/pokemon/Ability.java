package fr.hugosimony.pokemontopaze.pokemon;

public class Ability {

	public Abilities ability;
	public String name;
	public String battleDescription;
	public String fieldDescription;
	
	public Ability(Abilities ability) {
		
		this.ability = ability;
		String[] data = Abilities.getAbilityData(ability);
		name = data[0];
		battleDescription = data[1];
		fieldDescription = data[2];
	}
	
	public static boolean doBriseMouleHandle(Abilities ability)
	{
		return ability == Abilities.ABSORB_EAU || ability == Abilities.ABSORB_VOLT || ability == Abilities.ANTI_BRUIT
			|| ability == Abilities.ARMURBASTON || ability == Abilities.ARMUMAGMA || ability == Abilities.AROMA_VOILE
			|| ability == Abilities.ATTENTION || ability == Abilities.BENET || ability == Abilities.COEUR_DE_COQ
			|| ability == Abilities.CONTESTATION || ability == Abilities.COQUE_ARMURE || ability == Abilities.CORPS_SAIN
			|| ability == Abilities.DON_FLORAL || ability == Abilities.ECAILLE_SPECIALE || ability == Abilities.ECHAUFFEMENT
			|| ability == Abilities.ECRAN_FUMEE || ability == Abilities.ECRAN_POUDRE || ability == Abilities.ESPRIT_VITAL
			|| ability == Abilities.FERMETE || ability == Abilities.FEUILLE_GARDE || ability == Abilities.FILTRE
			|| ability == Abilities.FLORA_VOILE || ability == Abilities.GARDE_AMIE || ability == Abilities.GARDE_MYSTIK
			|| ability == Abilities.GLUCO_VOILE || ability == Abilities.GLUE || ability == Abilities.HEAVY_METAL
			|| ability == Abilities.HERBIVORE || ability == Abilities.HYPER_CUTTER || ability == Abilities.IGNIFU_VOILE
			|| ability == Abilities.IGNIFUGE || ability == Abilities.INCONSCIENT || ability == Abilities.INSOMNIA
			|| ability == Abilities.ISOGRAISSE || ability == Abilities.LEVITATION || ability == Abilities.LAVABO
			|| ability == Abilities.LIGHT_METAL || ability == Abilities.MIROIR_MAGIK || ability == Abilities.MOITEUR
			|| ability == Abilities.MOTORISE || ability == Abilities.MULTIECAILLE || ability == Abilities.PARATONNERRE
			|| ability == Abilities.PARE_BALLES || ability == Abilities.PEAU_MIRACLE || ability == Abilities.PEAU_SECHE
			|| ability == Abilities.PIED_CONFUS || ability == Abilities.REGARD_VIF || ability == Abilities.RIDEAU_NEIGE
			|| ability == Abilities.SIMPLE || ability == Abilities.SOLIDE_ROC || ability == Abilities.TELEPATHE
			|| ability == Abilities.TEMPO_PERSO || ability == Abilities.TOISON_EPAISSE || ability == Abilities.TORCHE
			|| ability == Abilities.VACCIN || ability == Abilities.VENTOUSE || ability == Abilities.VOILE_SABLE;
	}
}
