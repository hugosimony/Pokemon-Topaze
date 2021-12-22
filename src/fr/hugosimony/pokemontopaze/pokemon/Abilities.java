package fr.hugosimony.pokemontopaze.pokemon;

public enum Abilities {

	ABSENTEISME, ABSORB_EAU, ABSORB_VOLT, AGITATION, AIR_LOCK, ANTI_BRUIT,
	ARMUMAGMA, ARMURBASTON, ATTENTION, BENET, BRASIER, CACOPHONIE,
	CALQUE, CHLOROPHYLLE, CIEL_GRIS, COLOFORCE, COQUE_ARMURE, CORPS_ARDENT,
	CORPS_SAIN, CRACHIN, CRAN, CUVETTE, DEGUISEMENT, ECAILLE_SPECIALE,
	ECHAUFFEMENT, ECRAN_FUMEE, ECRAN_POUDRE, ENGRAIS, ESPRIT_VITAL, ESSAIM,
	FERMETE, FORCE_PURE, FUITE, GARDE_MYSTIK, GLISSADE, GLUE,
	HYPER_CUTTER, IGNIFU_VOILE, INSOMNIA, INTIMIDATION, ISOGRAISSE, JOLI_SOURIRE,
	LEVITATION, LUMIATTIRANCE, MAGNEPIEGE, MARQUE_OMBRE, MATINAL, MEDIC_NATURE,
	METEO, MINUS, MOITEUR, MUE, OEIL_COMPOSE, PARATONNERRE,
	PEAU_DURE, PIEGE, PLUS, POINT_POISON, POSE_SPORE, PRESSION,
	PUANTEUR, RAMASSAGE, REGARD_VIF, SABLE_VOLANT, SECHERESSE, SERENITE,
	STATIK, SUINTEMENT, SYNCHRO, TEMPO_PERSO, TETE_DE_ROC, TORCHE,
	TORRENT, TURBO, VACCIN, VENTOUSE, VOILE_SABLE, ADAPTABILITE,
	ALERTE_NEIGE, ANNULE_GARDE, ANTICIPATION, BOOM_FINAL, BRISE_MOULE, CHANCEUX,
	CHERCHE_MIEL, COLERIQUE, CORPS_GEL, DEBUT_CALME, DELESTAGE, DON_FLORAL,
	FEUILLE_GARDE, FILTRE, FORCE_SOLEIL, FOUILLE, FREIN, GARDE_MAGIK,
	GLOUTONNERIE, HYDRATATION, IGNIFUGE, IMPASSIBLE, INCONSCIENT, LAVABO,
	LENTITEINTEE, MALADRESSE, MAUVAIS_REVE, MOTORISE, MULTI_COUPS, MULTITYPE,
	NORMALISE, PEAU_SECHE, PIED_CONFUS, PIED_VELOCE, POING_DE_FER, PREDICTION,
	QUERELLEUR, RIDEAU_NEIGE, RIVALITE, SIMPLE, SNIPER, SOIN_POISON,
	SOLIDE_ROC, TECHNICIEN, TELECHARGE, TEMERAIRE, ACHARNE, ANALYSTE,
	ARMUROUILLEE, BAIGNE_SABLE, COEUR_DE_COQ, COEUR_NOBLE, COEUR_SOIN, CONTESTATION,
	CORPS_MAUDIT, DEFAITISTE, ENVELOCAPE, EPINE_DE_FER, FARCEUR, FORCE_SABLE,
	GARDE_AMIE, HEAVY_METAL, HERBIVORE, ILLUSION, IMPOSTEUR, IMPUDENCE,
	INFILTRATION, LIGHT_METAL, LUNATIQUE, MIROIR_MAGIK, MODE_TRANSE, MOMIE,
	MULTIECAILLE, PEAU_MIRACLE, PHOBIQUE, PICKPOCKET, RAGE_BRÛLURE, RAGE_POISON,
	RECOLTE, REGE_FORCE, SANS_LIMITE, TELEPATHE, TENSION, TERA_VOLTAGE,
	TOXITOUCHE, TURBOBRASIER, VICTORIEUX, AILES_BOURRASQUE, AMOUR_FILIAL, AROMA_VOILE,
	AURA_FEERIQUE, AURA_INVERSEE, AURA_TENEBREUSE, BAJOUES, BATTANT, DECLIC_TACTIQUE,
	FLORA_VOILE, GLUCO_VOILE, GRIFFE_DURE, MAGICIEN, MEGA_BLASTER, MER_PRIMAIRE,
	PARE_BALLES, PEAU_CELESTE, PEAU_FEERIQUE, PEAU_GELEE, POISSEUX, PROGNATHE,
	PROTEEN, SOUFFLE_DELTA, SYMBIOSE, TERRE_FINALE, TOISON_EPAISSE, TOISON_HERBUE,
	
	NULL;
	
	public static String[] getAbilityData(Abilities Abilities) {
		
		switch(Abilities) {
		case ABSENTEISME:
			return new String[] {"Absentéisme", "Le Pokémon n'attaque qu'un tour sur deux.", "-"};
		case ABSORB_EAU:
			return new String[] {"Absorb Eau", "Les attaques de type Eau reçues par le Pokémon régénèrent 1/4 de ses PV.", "-"};
		case ABSORB_VOLT: // TODO
			return new String[] {"Absorb Volt", "Les attaques de type Électrik reçues par le Pokémon régénèrent 1/4 de ses PV.", "-"};
		case AGITATION: // TODO
			return new String[] {"Agitation", "Augmente l'attaque de 50% mais baisse la précision de 20%.", "Augmente de 50% les chances de rencontrer un Pokémon sauvage de haut niveau."};
		case AIR_LOCK: // TODO
			return new String[] {"Air Lock", "Annule les effets du climat.", "-"};
		case ANTI_BRUIT: // TODO
			return new String[] {"Anti-Bruit", "Annule les effets dus à une attaque sonore.", "-"};
		case ARMUMAGMA: // TODO
			return new String[] {"Armumagma", "Immunise contre le gel.", "Divise par deux le nombre de pas nécessaire à l'éclosion d'un œuf."};
		case ARMURBASTON: // TODO
			return new String[] {"Armurbaston", "Annule les chances de coups critiques du Pokémon ennemi.", "-"};
		case ATTENTION: // TODO
			return new String[] {"Attention", "Immunise contre la peur.", "-"};
		case BENET: // TODO
			return new String[] {"Benêt", "Immunise contre l'attraction et la provocation.", "-"};
		case BRASIER: // TODO
			return new String[] {"Brasier", "Augmente la puissance des attaques de type Feu de 50% lorsque le Pokémon a moins d'1/3 de ses PV totaux.", "-"};
		case CACOPHONIE: // TODO
			return new String[] {"Cacophonie", "Annule les effets dus à une attaque sonore.", "-"};
		case CALQUE: // TODO
			return new String[] {"Calque", "Copie le talent du Pokémon adverse.", "-"};
		case CHLOROPHYLLE: // TODO
			return new String[] {"Chlorophylle", "Augmente la vitesse au soleil.", "-"};
		case CIEL_GRIS: // TODO
			return new String[] {"Ciel Gris", "Annule les effets du climat.", "-"};
		case COLOFORCE: // TODO
			return new String[] {"Coloforce", "Double l'attaque du Pokémon.", "-"};
		case COQUE_ARMURE: // TODO
			return new String[] {"Coque Armure", "Annule les chances de coups critiques du Pokémon ennemi.", "-"};
		case CORPS_ARDENT: // TODO
			return new String[] {"Corps Ardent", "30% de chance de provoquer une brûlure sur le Pokémon adverse ayant attaqué.", "Divise par deux le nombre de pas nécessaire à l'éclosion d'un œuf."};
		case CORPS_SAIN: // TODO
			return new String[] {"Corps Sain", "Empêche la diminution de statistiques par le Pokémon adverse.", "-"};
		case CRACHIN: // TODO
			return new String[] {"Crachin", "Fait tomber la pluie tant que le Pokémon est en jeu.", "-"};
		case CRAN: // TODO
			return new String[] {"Cran", "Augmente de 50% l'attaque du Pokémon s'il subit un changement de statut.", "-"};
		case CUVETTE: // TODO
			return new String[] {"Cuvette", "Régénère 1/16ème des PV par temps de pluie.", "-"};
		case DEGUISEMENT: // TODO
			return new String[] {"Déguisement", "Change le type du Pokémon en celui de la dernière attaque subie.", "-"};
		case ECAILLE_SPECIALE: // TODO
			return new String[] {"Écaille Spéciale", "Augmente la défense de 50% lorsque le Pokémon subit un changement de statut.", "-"};
		case ECHAUFFEMENT: // TODO
			return new String[] {"Échauffement", "Immunise contre la paralysie.", "-"};
		case ECRAN_FUMEE: // TODO
			return new String[] {"Écran Fumée", "Empêche la diminution de statistiques par le Pokémon adverse.", "Réduit de 50% les chances d'être attaqué par un Pokémon sauvage."};
		case ECRAN_POUDRE: // TODO
			return new String[] {"Écran Poudre", "Empêche les effets secondaires des attaques subies.", "-"};
		case ENGRAIS: // TODO
			return new String[] {"Engrais", "Augmente la puissance des attaques de type Plante de 50% lorsque le Pokémon a moins d'1/3 de ses PV totaux.", "-"};
		case ESPRIT_VITAL: // TODO
			return new String[] {"Esprit Vital", "Empêche le Pokémon d'être endormi.", "Augmente de 50% les chances de rencontrer un Pokémon sauvage de haut niveau."};
		case ESSAIM: // TODO
			return new String[] {"Essaim", "Augmente la puissance des attaques de type Insecte de 50% lorsque le Pokémon a moins d'1/3 de ses PV totaux.", "Augmente les chances de rencontrer un Pokémon sauvage."};
		case FERMETE: // TODO
			return new String[] {"Fermeté", "Immunise contre les attaques OHKO. Laisse le Pokémon à 1 PV après une attaque qui aurait dû le terrasser, s'il a tous ses PV.", "-"};
		case FORCE_PURE: // TODO
			return new String[] {"Force Pure", "Double l'attaque du Pokémon.", "-"};
		case FUITE: // TODO
			return new String[] {"Fuite", "Assure la fuite contre les Pokémon sauvages.", "-"};
		case GARDE_MYSTIK: // TODO
			return new String[] {"Garde Mystik", "Ne subit que les dégâts d'attaques super efficaces.", "-"};
		case GLISSADE: // TODO
			return new String[] {"Glissade", "Double la vitesse par temps de pluie.", "-"};
		case GLUE: // TODO
			return new String[] {"Glue", "Empêche la perte de l'objet tenu.", "Facilite la capture des Pokémon pêchés."};
		case HYPER_CUTTER: // TODO
			return new String[] {"Hyper Cutter", "Empêche la diminution d'attaque du Pokémon.", "-"};
		case IGNIFU_VOILE: // TODO
			return new String[] {"Ignifu-Voile", "Immunise contre la brûlure.", "-"};
		case INSOMNIA: // TODO
			return new String[] {"Insomnia", "Empêche le Pokémon d'être endormi.", "-"};
		case INTIMIDATION: // TODO
			return new String[] {"Intimidation", "Diminue d'un niveau l'attaque du Pokémon adverse.", "Réduit de 50% les chances d'être attaqué par un Pokémon sauvage de bas niveau."};
		case ISOGRAISSE: // TODO
			return new String[] {"Isograisse", "Les dégâts provoqués par les attaques des types Feu ou Glace sont divisés par 2.", "-"};
		case JOLI_SOURIRE: // TODO
			return new String[] {"Joli Sourire", "A 30% de chance de provoquer l'attirance du Pokémon adverse ayant attaqué.", "Augmente de 50% les chances d'être attaqué par un Pokémon sauvage du sexe opposé."};
		case LEVITATION: // TODO
			return new String[] {"Lévitation", "Immunise contre les attaques de type Sol.", "-"};
		case LUMIATTIRANCE: // TODO
			return new String[] {"Lumiattirance", "-", "Augmente les chances de rencontrer des Pokémon sauvages."};
		case MAGNEPIEGE: // TODO
			return new String[] {"Magnépiège", "Empêche la fuite et le changement des Pokémon de type Acier.", "Augmente de 50% les chances de rencontrer un Pokémon sauvage de type Acier."};
		case MARQUE_OMBRE: // TODO
			return new String[] {"Marque Ombre", "Empêche la fuite des Pokémon sauvage et le changement du Pokémon adverse.", "-"};
		case MATINAL: // TODO
			return new String[] {"Matinal", "Réduit le nombre de tours de sommeil du Pokémon.", "-"};
		case MEDIC_NATURE: // TODO
			return new String[] {"Médic Nature", "Le Pokémon est soigné de toute altération d'état lorsqu'il est changé ou en fin de combat.", "-"};
		case METEO: // TODO
			return new String[] {"Météo", "Change le type et la forme du Pokémon selon le climat.", "-"};
		case MINUS: // TODO
			return new String[] {"Minus", "Augmente l'attaque spéciale de 50% en Match Double, si le partenaire à le talent Plus ou Minus.", "-"};
		case MOITEUR: // TODO
			return new String[] {"Moiteur", "Émpêche l'utilisation d'attaques auto-destructrices par le Pokémon adverse.", "-"};
		case MUE: // TODO
			return new String[] {"Mue", "À chaque tour, le Pokémon a 33% de chance d'être soigné d'une altération d'état.", "-"};
		case OEIL_COMPOSE: // TODO
			return new String[] {"Œil Composé", "Double la précision du Pokémon.", "Augmente les chances de rencontrer un Pokémon sauvage tenant un objet."};
		case PARATONNERRE: // TODO
			return new String[] {"Paratonnerre", "Attire toutes les attaques de type Électrik. Augmente aussi l'Attaque Spéciale du Pokémon recevant l'attaque.", "-"};
		case PEAU_DURE: // TODO
			return new String[] {"Peau Dure", "Fait perdre 1/16è des PV du Pokémon adverse ayant lancé une attaque de contact.", "-"};
		case PIEGE: // TODO
			return new String[] {"Piège", "Empêche la fuite et le changement du Pokémon adverse, s'il est au sol.", "Augmente de 50% les chances d'être attaqué par un Pokémon sauvage."};
		case PLUS: // TODO
			return new String[] {"Plus", "Augmente l'attaque spéciale de 50% en Match Double, si le partenaire à le talent Minus ou Plus.", "-"};
		case POINT_POISON: // TODO
			return new String[] {"Point Poison", "30% de chance de provoquer l'empoisonnement du Pokémon adverse ayant lancé une attaque de contact.", "-"};
		case POSE_SPORE: // TODO
			return new String[] {"Pose Spore", "30% de chance de provoquer l'empoisonnement, le sommeil ou la paralysie du Pokémon adverse ayant lancé une attaque de contact.", "-"};
		case PRESSION: // TODO
			return new String[] {"Pression", "Double l'utilisation de PP des attaques offensives du Pokémon adverse.", "Augmente de 50% les chances d'être attaqué par un Pokémon sauvage."};
		case PUANTEUR: // TODO
			return new String[] {"Puanteur", "Les attaques physiques ont 10% d'apeurer la cible.", "Diminue les chances de rencontrer des Pokémon sauvages."};
		case RAMASSAGE: // TODO
			return new String[] {"Ramassage", "Donne une chance au Pokémon de ramasser un objet après un combat.", "-"};
		case REGARD_VIF: // TODO
			return new String[] {"Regard Vif", "Empêche la perte de précision.", "Réduit de 50% les chances d'être attaqué par un Pokémon sauvage de bas niveau."};
		case SABLE_VOLANT: // TODO
			return new String[] {"Sable Volant", "Déclenche une tempête de sable tant que le Pokémon est en jeu.", "-"};
		case SECHERESSE: // TODO
			return new String[] {"Sécheresse", "Crée un temps ensoleillé tant que le Pokémon est en jeu.", "-"};
		case SERENITE: // TODO
			return new String[] {"Sérénité", "Double les chances de réussite des effets secondaires des attaques.", "-"};
		case STATIK: // TODO
			return new String[] {"Statik", "30% de chance de provoquer la paralysie du Pokémon adverse ayant lancé une attaque de contact.", "Augmente de 50% les chances de rencontrer un Pokémon sauvage de type Électrik."};
		case SUINTEMENT: // TODO
			return new String[] {"Suintement", "Les attaques absorbantes du Pokémon adverse lui font perdre des PV.", "-"};
		case SYNCHRO: // TODO
			return new String[] {"Synchro", "Toute altération d'état subie est transmise au Pokémon adverse.", "Augmente les chances de rencontrer un Pokémon sauvage ayant la même nature."};
		case TEMPO_PERSO: // TODO
			return new String[] {"Tempo Perso", "Immunise contre la confusion.", "-"};
		case TETE_DE_ROC: // TODO
			return new String[] {"Tête de Roc", "Le Pokémon ne subit pas de dégâts de contrecoup.", "-"};
		case TORCHE: // TODO
			return new String[] {"Torche", "Annule les dégâts des attaques de type Feu subies et augmente de 50% la puissance des attaques de type Feu lancées.", "-"};
		case TORRENT: // TODO
			return new String[] {"Torrent", "Augmente la puissance des attaques de type Eau de 50% lorsque le Pokémon a moins d'1/3 de ses PV totaux.", "-"};
		case TURBO: // TODO
			return new String[] {"Turbo", "La vitesse du Pokémon augmente à chaque tour.", "-"};
		case VACCIN: // TODO
			return new String[] {"Vaccin", "Immunise contre l'empoisonnement.", "-"};
		case VENTOUSE: // TODO
			return new String[] {"Ventouse", "Empêche d'être changé de force par une attaque adverse.", "Augmente les chances qu'un Pokémon pêché morde à l'hameçon."};
		case VOILE_SABLE: // TODO
			return new String[] {"Voile Sable", "Augmente l'esquive de 20% lors d'une tempête de sable et immunise contre ses dégâts.", "Réduit de 50% les chances d'être attaqué par un Pokémon sauvage lors d'une tempête de sable."};
		case ADAPTABILITE: // TODO
			return new String[] {"Adaptabilité", "Si ce Pokémon utilise une attaque de son type, la puissance de l'attaque est multipliée par 2 au lieu de 1.5.", "-"};
		case ALERTE_NEIGE: // TODO
			return new String[] {"Alerte Neige", "Le Pokémon déclenche une grêle lorsqu'il est envoyé au combat.", "-"};
		case ANNULE_GARDE: // TODO
			return new String[] {"Annule Garde", "Toutes les attaques du Pokémon et de son adversaire ont une précision de 100%.", "Augmente les chances de rencontrer un Pokémon sauvage."};
		case ANTICIPATION: // TODO
			return new String[] {"Anticipation", "Alerte et protège lorsque le Pokémon adverse possède certaines attaques.", "-"};
		case BOOM_FINAL: // TODO
			return new String[] {"Boom Final", "Enlève 1/4 des PV totaux du Pokémon ennemi mettant K.O. par contact.", "-"};
		case BRISE_MOULE: // TODO
			return new String[] {"Brise Moule", "Peut toucher un Pokémon adverse malgré son talent.", "-"};
		case CHANCEUX: // TODO
			return new String[] {"Chanceux", "Double les chance de porter un coup critique.", "-"};
		case CHERCHE_MIEL: // TODO
			return new String[] {"Cherche Miel", "-", "Le Pokémon peut trouver du Miel après un combat."};
		case COLERIQUE: // TODO
			return new String[] {"Colérique", "L'attaque du Pokémon est fortement augmentée lorsqu'il subit un coup critique.", "-"};
		case CORPS_GEL: // TODO
			return new String[] {"Corps Gel", "Régénère 1/16ème des PV par temps de grêle. Immunise les Pokémon n'ayant pas le type Glace contre la grêle.", "-"};
		case DEBUT_CALME: // TODO
			return new String[] {"Début Calme", "Divise par deux l'attaque et la vitesse du Pokémon pendant 5 tours.", "-"};
		case DELESTAGE: // TODO
			return new String[] {"Délestage", "Augmente la vitesse lorsqu'un objet tenu est utilisé, lancé ou perdu.", "-"};
		case DON_FLORAL: // TODO
			return new String[] {"Don Floral", "Augmente l'attaque et la défense spéciale de 50% par temps ensoleillé.", "-"};
		case FEUILLE_GARDE: // TODO
			return new String[] {"Feuille Garde", "Soigne les altérations d'état par temps ensoleillé.", "-"};
		case FILTRE: // TODO
			return new String[] {"Filtre", "Retire 1/4 des dégâts subits lors d'une attaque super efficace.", "-"};
		case FORCE_SOLEIL: // TODO
			return new String[] {"Force Soleil", "Augmente l'attaque spéciale de 50% par temps ensoleillé, mais diminue les PV de 1/8ème par tour.", "-"};
		case FOUILLE: // TODO
			return new String[] {"Fouille", "Permet de connaitre l'objet tenu d'un Pokémon adverse.", "-"};
		case FREIN: // TODO
			return new String[] {"Frein", "Le Pokémon attaque toujours en second pour deux attaques de même priorité.", "-"};
		case GARDE_MAGIK: // TODO
			return new String[] {"Garde Magik", "Le Pokémon ne subit de dégâts que lors d'attaques directes.", "-"};
		case GLOUTONNERIE: // TODO
			return new String[] {"Gloutonnerie", "Le Pokémon utilise la baie portée lorsque les PV descendent en dessous de 50%.", "-"};
		case HYDRATATION: // TODO
			return new String[] {"Hydratation", "Soigne les altérations d'état par temps de pluie.", "-"};
		case IGNIFUGE: // TODO
			return new String[] {"Ignifuge", "Divise par 2 les dégâts des attaques de type Feu et les effets de brûlure subis par le Pokémon.", "-"};
		case IMPASSIBLE: // TODO
			return new String[] {"Impassible", "Augmente d'un niveau la vitesse du Pokémon lorsqu'il est apeuré.", "-"};
		case INCONSCIENT: // TODO
			return new String[] {"Inconscient", "Ignore les améliorations de statistiques du Pokémon adverse, à l'exception de sa Vitesse.", "-"};
		case LAVABO: // TODO
			return new String[] {"Lavabo", "Attire toutes les attaques de type Eau. Augmente aussi l'Attaque Spéciale du Pokémon recevant une attaque de type Eau.", "-"};
		case LENTITEINTEE: // TODO
			return new String[] {"Lentiteintée", "Double les dégâts des attaques peu efficaces portées au Pokémon adverse.", "-"};
		case MALADRESSE: // TODO
			return new String[] {"Maladresse", "Empêche l'utilisation et/ou ignore l'effet des objets tenus en combat.", "-"};
		case MAUVAIS_REVE: // TODO
			return new String[] {"Mauvais Rêve", "Fait perdre 1/8ème de ses PV au Pokémon adverse s'il est endormi.", "-"};
		case MOTORISE: // TODO
			return new String[] {"Motorisé", "Immunise le Pokémon contre les attaques de type Électrik et augmente la vitesse du Pokémon d'un niveau par attaque Électrik subie.", "-"};
		case MULTI_COUPS: // TODO
			return new String[] {"Multi-Coups", "Utilise toujours le nombre de coups maximum d'une attaque.", "-"};
		case MULTITYPE: // TODO
			return new String[] {"Multitype", "Le type et la forme du Pokémon changent en fonction de la plaque qu'il porte.", "-"};
		case NORMALISE: // TODO
			return new String[] {"Normalise", "Toutes les attaques du Pokémon sont considérées comme étant de type Normal.", "-"};
		case PEAU_SECHE: // TODO
			return new String[] {"Peau Sèche", "Les attaques de type Eau soignent le Pokémon, qui regagne 1/4 de ses PV totaux. Par temps de pluie, il gagne 1/8ème de ses PV par tour. Les attaques de type Feu infligent 25% de dégâts en plus. Par temps ensoleillé, il perd 1/8ème de ses PV par tour.", "-"};
		case PIED_CONFUS: // TODO
			return new String[] {"Pied Confus", "Augmente l'esquive de 20% lorsque le Pokémon est confus.", "-"};
		case PIED_VELOCE: // TODO
			return new String[] {"Pied Véloce", "Augmente la vitesse de 50% lorsque le Pokémon subit une altération d'état.", "-"};
		case POING_DE_FER: // TODO
			return new String[] {"Poing de Fer", "Augmente de 20% la puissance des attaques de Poing.", "-"};
		case PREDICTION: // TODO
			return new String[] {"Prédiction", "Alerte le Pokémon de l'attaque la plus puissante du Pokémon adverse.", "-"};
		case QUERELLEUR: // TODO
			return new String[] {"Querelleur", "Permet de toucher les Pokémon de type Spectre avec des attaques de type Normal ou Combat.", "-"};
		case RIDEAU_NEIGE: // TODO
			return new String[] {"Rideau Neige", "Augmente l'esquive de 20% par temps de grêle. Immunise les Pokémon n'ayant pas le type Glace contre la grêle.", "-"};
		case RIVALITE: // TODO
			return new String[] {"Rivalité", "Augmente l'attaque et l'attaque spéciale de 25% si le Pokémon adverse est de même sexe. Les diminue s'il est de sexe opposé.", "-"};
		case SIMPLE: // TODO
			return new String[] {"Simple", "Double les effets des modifications de statistiques, positives ou négatives.", "-"};
		case SNIPER: // TODO
			return new String[] {"Sniper", "Triple la puissance des coups critiques.", "-"};
		case SOIN_POISON: // TODO
			return new String[] {"Soin Poison", "Le Pokémon récupère 1/8è de ses PV par tour lors d'un empoisonnement.", "-"};
		case SOLIDE_ROC: // TODO
			return new String[] {"Solide Roc", "Retire 1/4 des dégâts subits si le Pokémon reçoit une attaque super efficace.", "-"};
		case TECHNICIEN: // TODO
			return new String[] {"Technicien", "Augmente de 50% la puissance des attaques dont la puissance est inférieure ou égale à 60.", "-"};
		case TELECHARGE: // TODO
			return new String[] {"Télécharge", "Augmente l'attaque ou l'attaque spéciale du Pokémon, selon la statistique de défense la plus faible du Pokémon adverse.", "-"};
		case TEMERAIRE: // TODO
			return new String[] {"Téméraire", "Augmente de 20% la puissance des attaques infligeant un contrecoup.", "-"};
		case ACHARNE: // TODO
			return new String[] {"Acharné", "Monte l'Attaque du Pokémon de deux niveaux si l'une de ses statistiques est baissée par l'adversaire.", "-"};
		case ANALYSTE: // TODO
			return new String[] {"Analyste", "Si le Pokémon frappe en dernier durant le tour, la puissance de son attaque est augmentée de 30%.", "-"};
		case ARMUROUILLEE: // TODO
			return new String[] {"Armurouillée", "Le Pokémon touché par une attaque physique voit sa défense diminuée d'un niveau et sa vitesse augmentée d'un niveau.", "-"};
		case BAIGNE_SABLE: // TODO
			return new String[] {"Baigne Sable", "Double la Vitesse du Pokémon lors d'une tempête de sable. Immunise contre les dégâts de la tempête.", "-"};
		case COEUR_DE_COQ: // TODO
			return new String[] {"Cœur de Coq", "Empêche la défense du Pokémon d'être baissée par les attaques adverses.", "-"};
		case COEUR_NOBLE: // TODO
			return new String[] {"Cœur Noble", "Si le Pokémon est touché par une attaque de type Ténèbres, son attaque augmente d'un niveau.", "-"};
		case COEUR_SOIN: // TODO
			return new String[] {"Cœur Soin", "À la fin de chaque tour, le Pokémon a 30% de chance de guérir ses alliés d'une altération d'état en Combat Double ou triple.", "-"};
		case CONTESTATION: // TODO
			return new String[] {"Contestation", "Inverse les effets des attaques modifiant les statistiques.", "-"};
		case CORPS_MAUDIT: // TODO
			return new String[] {"Corps Maudit", "Toute attaque portée par l'adversaire a 30% de chance de s'entraver.", "-"};
		case DEFAITISTE: // TODO
			return new String[] {"Défaitiste", "Divise par deux l'attaque et l'attaque spéciale du Pokémon s'il a moins de la moitié de ses PV totaux.", "-"};
		case ENVELOCAPE: // TODO
			return new String[] {"Envelocape", "Immunise contre les dégâts causés par la grêle et les tempêtes de sable.", "-"};
		case EPINE_DE_FER: // TODO
			return new String[] {"Épine de Fer", "Retire 1/8ème de ses PV à l'adversaire lorsque celui-ci porte une attaque physique.", "-"};
		case FARCEUR: // TODO
			return new String[] {"Farceur", "Augmente la priorité des attaques de statut d'un niveau.", "-"};
		case FORCE_SABLE: // TODO
			return new String[] {"Force Sable", "Lors d'une tempête de sable, la puissance des attaques de type Acier, Roche et Sol augmente de 30%.", "-"};
		case GARDE_AMIE: // TODO
			return new String[] {"Garde Amie", "Réduire de 25% les dégâts infligés aux alliés en Combat Double ou triple.", "-"};
		case HEAVY_METAL: // TODO
			return new String[] {"Heavy Metal", "Double la masse du Pokémon.", "-"};
		case HERBIVORE: // TODO
			return new String[] {"Herbivore", "Si le Pokémon est touché par une attaque de type Plante, son attaque augmente d'un niveau.", "-"};
		case ILLUSION: // TODO
			return new String[] {"Illusion", "Lorsqu'il entre en combat, le Pokémon prend l'apparence du dernier Pokémon de l'équipe.", "-"};
		case IMPOSTEUR: // TODO
			return new String[] {"Imposteur", "Le Pokémon entrant en combat prend automatiquement l'apparence du Pokémon adverse.", "-"};
		case IMPUDENCE: // TODO
			return new String[] {"Impudence", "Monte l'attaque du Pokémon d'un niveau lorsqu'il met un adversaire K.O.", "-"};
		case INFILTRATION: // TODO
			return new String[] {"Infiltration", "Empêche les attaques de protection adverses tels que Protection ou Mur Lumière de fonctionner. N'influe pas sur Détection et Abri.", "-"};
		case LIGHT_METAL: // TODO
			return new String[] {"Light Metal", "Divise par deux la masse du Pokémon.", "-"};
		case LUNATIQUE: // TODO
			return new String[] {"Lunatique", "Aléatoirement, à la fin de chaque tour, une statistique du Pokémon augmente de deux niveaux, et une autre baisse d'un niveau (précision et esquive comprises).", "-"};
		case MIROIR_MAGIK: // TODO
			return new String[] {"Miroir Magik", "Retourne les attaques de statut contre l'adversaire.", "-"};
		case MODE_TRANSE: // TODO
			return new String[] {"Mode Transe", "Le Pokémon change de forme et modifie la répartition de ses statistiques lorsque ses PV sont inférieurs à 50%.", "-"};
		case MOMIE: // TODO
			return new String[] {"Momie", "Si le Pokémon subit une attaque de contact, le talent de l'adversaire devient Momie. Ce talent est sans effet en lui-même.", "-"};
		case MULTIECAILLE: // TODO
			return new String[] {"Multiécaille", "Si le Pokémon possède 100% de ses PV, alors les dégâts infligés par l'adversaire sont divisés par deux.", "-"};
		case PEAU_MIRACLE: // TODO
			return new String[] {"Peau Miracle", "50% de chance de faire échouer les attaques de statut portées par l'adversaire.", "-"};
		case PHOBIQUE: // TODO
			return new String[] {"Phobique", "Si le Pokémon est touché par une attaque de type Insecte, Spectre ou Ténèbres, sa vitesse augmente d'un niveau.", "-"};
		case PICKPOCKET: // TODO
			return new String[] {"Pickpocket", "Si le Pokémon subit une attaque physique, il récupère l'objet tenu par son adversaire.", "-"};
		case RAGE_BRÛLURE: // TODO
			return new String[] {"Rage Brûlure", "Augmente l'attaque spéciale du Pokémon de 50% en cas de brûlure.", "-"};
		case RAGE_POISON: // TODO
			return new String[] {"Rage Poison", "Augmente l'attaque du Pokémon de 50% en cas d'empoisonnement.", "-"};
		case RECOLTE: // TODO
			return new String[] {"Récolte", "Une baie consommée par le Pokémon a 50% de chances d'être récupérée à la fin de chaque tour.", "-"};
		case REGE_FORCE: // TODO
			return new String[] {"Régé-Force", "Restaure 1/3 des PV totaux si le Pokémon est retiré du combat.", "-"};
		case SANS_LIMITE: // TODO
			return new String[] {"Sans Limite", "Augmente de 30% la puissance des attaques pouvant avoir un effet secondaire. L'effet secondaire est annulé.", "-"};
		case TELEPATHE: // TODO
			return new String[] {"Télépathe", "Anticipe et évite les attaques des alliés en Combat Double ou triple.", "-"};
		case TENSION: // TODO
			return new String[] {"Tension", "Empêche l'adversaire de consommer sa baie.", "-"};
		case TERA_VOLTAGE: // TODO
			return new String[] {"Téra-Voltage", "Peut toucher un Pokémon adverse malgré son talent.", "-"};
		case TOXITOUCHE: // TODO
			return new String[] {"Toxitouche", "Peut empoisonner l'adversaire après lui avoir porté une attaque physique.", "-"};
		case TURBOBRASIER: // TODO
			return new String[] {"TurboBrasier", "Peut toucher un Pokémon adverse malgré son talent.", "-"};
		case VICTORIEUX: // TODO
			return new String[] {"Victorieux", "Monte de 10% la précision des alliés en Combat Double ou triple.", "-"};
		case AILES_BOURRASQUE: // TODO
			return new String[] {"Ailes Bourrasque", "Augmente la priorité des capacités de type Vol.", "-"};
		case AMOUR_FILIAL: // TODO
			return new String[] {"Amour Filial", "Permet au lanceur de porter deux coups par tour au lieu d'un, le deuxième coup fera deux fois moins de dégâts que le premier.", "-"};
		case AROMA_VOILE: // TODO
			return new String[] {"Aroma-Voile", "Protège les Pokémon alliés des capacités ayant un effet sur l'état mental tels que Attraction ou Tourmente.", "-"};
		case AURA_FEERIQUE: // TODO
			return new String[] {"Aura Féérique", "Augmente la puissance des attaques de type Fée des Pokémon présents sur le terrain.", "-"};
		case AURA_INVERSEE: // TODO
			return new String[] {"Aura Inversée", "Inverse les effets des talents Aura.", "-"};
		case AURA_TENEBREUSE: // TODO
			return new String[] {"Aura Ténébreuse", "Augmente la puissance des attaques de type Ténèbres des Pokémon présents sur le terrain.", "-"};
		case BAJOUES: // TODO
			return new String[] {"Bajoues", "Lorsque le Pokémon mange une Baie, il obtient ses effets et regagne des PV en plus.", "-"};
		case BATTANT: // TODO
			return new String[] {"Battant", "Augmente l'Attaque Spéciale par deux niveaux lorsque n'importe quelle stat est baissée par un Pokémon adverse.", "-"};
		case DECLIC_TACTIQUE: // TODO
			return new String[] {"Déclic Tactique", "Change la forme du Pokémon selon le combat.", "-"};
		case FLORA_VOILE: // TODO
			return new String[] {"Flora-Voile", "Empêche la diminution des statistiques des alliés de type Plante par les Pokémon adverses.", "-"};
		case GLUCO_VOILE: // TODO
			return new String[] {"Gluco-Voile", "Empêche les Pokémon alliés de s'endormir.", "-"};
		case GRIFFE_DURE: // TODO
			return new String[] {"Griffe Dure", "Augmente d'un tiers la puissance des attaques directes.", "-"};
		case MAGICIEN: // TODO
			return new String[] {"Magicien", "Vole l'objet d'une cible après l'avoir touché avec une attaque directe.", "-"};
		case MEGA_BLASTER: // TODO
			return new String[] {"Méga Blaster", "Un Pokémon doté de ce talent verra la puissance de ses capacités d'aura augmentée.", "-"};
		case MER_PRIMAIRE: // TODO
			return new String[] {"Mer Primaire", "Fait tomber une Pluie ne pouvant être annulée par capacité ou talent tant que le Pokémon est en jeu. Annule toutes les capacités de type Feu.", "-"};
		case PARE_BALLES: // TODO
			return new String[] {"Pare-Balles", "Protège contre les capacités balles et bombes, par exemple Balle Graine ou Canon Graine.", "-"};
		case PEAU_CELESTE: // TODO
			return new String[] {"Peau Céleste", "Transforme les capacités de type Normal en type Vol et augmente leur puissance de 30%.", "-"};
		case PEAU_FEERIQUE: // TODO
			return new String[] {"Peau Féérique", "Transforme les capacités de type Normal en type Fée et augmente leur puissance de 30%.", "-"};
		case PEAU_GELEE: // TODO
			return new String[] {"Peau Gelée", "Transforme les capacités de type Normal en type Glace et augmente leur puissance de 30%.", "-"};
		case POISSEUX: // TODO
			return new String[] {"Poisseux", "Baisse la Vitesse des Pokémon qui touchent ce Pokémon avec une attaque directe.", "-"};
		case PROGNATHE: // TODO
			return new String[] {"Prognathe", "Augmente la puissance des attaques à base de morsures.", "-"};
		case PROTEEN: // TODO
			return new String[] {"Protéen", "Change le type du Pokémon en celui de toute capacité qu'il utilise.", "-"};
		case SOUFFLE_DELTA: // TODO
			return new String[] {"Souffle Delta", "Annule tout effet de climat, même Mer Primaire et Terre Finale. Annule les faiblesses du type Vol.", "-"};
		case SYMBIOSE: // TODO
			return new String[] {"Symbiose", "Passe un objet tenu à un Pokémon allié lorsque l'allié utilise son objet.", "-"};
		case TERRE_FINALE: // TODO
			return new String[] {"Terre Finale", "Crée un temps ensoleillé ne pouvant être annulé par capacité ou talent tant que le Pokémon est en jeu. Annule toutes les capacités de type Eau.", "-"};
		case TOISON_EPAISSE: // TODO
			return new String[] {"Toison Épaisse", "Divise par deux les dégâts reçus lors d'une attaque physique.", "-"};
		case TOISON_HERBUE: // TODO
			return new String[] {"Toison Herbue", "Augmente la Défense lorsque Champ Herbu est en vigueur.", "-"};
		default:
			return new String[] {"NULL", "NULL", "NULL"};
		}
	}
	
	public static Abilities getAbility(String ability) {
		return Abilities.valueOf(ability);
	}
	
	/*
	public static Abilities getAbility(String Abilities) {
		
		switch(Abilities) {
		case "ABSENTEISME":
			return ABSENTEISME;
		case "ABSORB_EAU":
			return ABSORB_EAU;
		case "ABSORB_VOLT":
			return ABSORB_VOLT;
		case "AGITATION":
			return AGITATION;
		case "AIR_LOCK":
			return AIR_LOCK;
		case "ANTI_BRUIT":
			return ANTI_BRUIT;
		case "ARMUMAGMA":
			return ARMUMAGMA;
		case "ARMURBASTON":
			return ARMURBASTON;
		case "ATTENTION":
			return ATTENTION;
		case "BENET":
			return BENET;
		case "BRASIER":
			return BRASIER;
		case "CACOPHONIE":
			return CACOPHONIE;
		case "CALQUE":
			return CALQUE;
		case "CHLOROPHYLLE":
			return CHLOROPHYLLE;
		case "CIEL_GRIS":
			return CIEL_GRIS;
		case "COLOFORCE":
			return COLOFORCE;
		case "COQUE_ARMURE":
			return COQUE_ARMURE;
		case "CORPS_ARDENT":
			return CORPS_ARDENT;
		case "CORPS_SAIN":
			return CORPS_SAIN;
		case "CRACHIN":
			return CRACHIN;
		case "CRAN":
			return CRAN;
		case "CUVETTE":
			return CUVETTE;
		case "DEGUISEMENT":
			return DEGUISEMENT;
		case "ECAILLE_SPECIALE":
			return ECAILLE_SPECIALE;
		case "ECHAUFFEMENT":
			return ECHAUFFEMENT;
		case "ECRAN_FUMEE":
			return ECRAN_FUMEE;
		case "ECRAN_POUDRE":
			return ECRAN_POUDRE;
		case "ENGRAIS":
			return ENGRAIS;
		case "ESPRIT_VITAL":
			return ESPRIT_VITAL;
		case "ESSAIM":
			return ESSAIM;
		case "FERMETE":
			return FERMETE;
		case "FORCE_PURE":
			return FORCE_PURE;
		case "FUITE":
			return FUITE;
		case "GARDE_MYSTIK":
			return GARDE_MYSTIK;
		case "GLISSADE":
			return GLISSADE;
		case "GLUE":
			return GLUE;
		case "HYPER_CUTTER":
			return HYPER_CUTTER;
		case "IGNIFU_VOILE":
			return IGNIFU_VOILE;
		case "INSOMNIA":
			return INSOMNIA;
		case "INTIMIDATION":
			return INTIMIDATION;
		case "ISOGRAISSE":
			return ISOGRAISSE;
		case "JOLI_SOURIRE":
			return JOLI_SOURIRE;
		case "LEVITATION":
			return LEVITATION;
		case "LUMIATTIRANCE":
			return LUMIATTIRANCE;
		case "MAGNEPIEGE":
			return MAGNEPIEGE;
		case "MARQUE_OMBRE":
			return MARQUE_OMBRE;
		case "MATINAL":
			return MATINAL;
		case "MEDIC_NATURE":
			return MEDIC_NATURE;
		case "METEO":
			return METEO;
		case "MINUS":
			return MINUS;
		case "MOITEUR":
			return MOITEUR;
		case "MUE":
			return MUE;
		case "OEIL_COMPOSE":
			return OEIL_COMPOSE;
		case "PARATONNERRE":
			return PARATONNERRE;
		case "PEAU_DURE":
			return PEAU_DURE;
		case "PIEGE":
			return PIEGE;
		case "PLUS":
			return PLUS;
		case "POINT_POISON":
			return POINT_POISON;
		case "POSE_SPORE":
			return POSE_SPORE;
		case "PRESSION":
			return PRESSION;
		case "PUANTEUR":
			return PUANTEUR;
		case "RAMASSAGE":
			return RAMASSAGE;
		case "REGARD_VIF":
			return REGARD_VIF;
		case "SABLE_VOLANT":
			return SABLE_VOLANT;
		case "SECHERESSE":
			return SECHERESSE;
		case "SERENITE":
			return SERENITE;
		case "STATIK":
			return STATIK;
		case "SUINTEMENT":
			return SUINTEMENT;
		case "SYNCHRO":
			return SYNCHRO;
		case "TEMPO_PERSO":
			return TEMPO_PERSO;
		case "TETE_DE_ROC":
			return TETE_DE_ROC;
		case "TORCHE":
			return TORCHE;
		case "TORRENT":
			return TORRENT;
		case "TURBO":
			return TURBO;
		case "VACCIN":
			return VACCIN;
		case "VENTOUSE":
			return VENTOUSE;
		case "VOILE_SABLE":
			return VOILE_SABLE;
		case "ADAPTABILITE":
			return ADAPTABILITE;
		case "ALERTE_NEIGE":
			return ALERTE_NEIGE;
		case "ANNULE_GARDE":
			return ANNULE_GARDE;
		case "ANTICIPATION":
			return ANTICIPATION;
		case "BOOM_FINAL":
			return BOOM_FINAL;
		case "BRISE_MOULE":
			return BRISE_MOULE;
		case "CHANCEUX":
			return CHANCEUX;
		case "CHERCHE_MIEL":
			return CHERCHE_MIEL;
		case "COLERIQUE":
			return COLERIQUE;
		case "CORPS_GEL":
			return CORPS_GEL;
		case "DEBUT_CALME":
			return DEBUT_CALME;
		case "DELESTAGE":
			return DELESTAGE;
		case "DON_FLORAL":
			return DON_FLORAL;
		case "FEUILLE_GARDE":
			return FEUILLE_GARDE;
		case "FILTRE":
			return FILTRE;
		case "FORCE_SOLEIL":
			return FORCE_SOLEIL;
		case "FOUILLE":
			return FOUILLE;
		case "FREIN":
			return FREIN;
		case "GARDE_MAGIK":
			return GARDE_MAGIK;
		case "GLOUTONNERIE":
			return GLOUTONNERIE;
		case "HYDRATATION":
			return HYDRATATION;
		case "IGNIFUGE":
			return IGNIFUGE;
		case "IMPASSIBLE":
			return IMPASSIBLE;
		case "INCONSCIENT":
			return INCONSCIENT;
		case "LAVABO":
			return LAVABO;
		case "LENTITEINTEE":
			return LENTITEINTEE;
		case "MALADRESSE":
			return MALADRESSE;
		case "MAUVAIS_REVE":
			return MAUVAIS_REVE;
		case "MOTORISE":
			return MOTORISE;
		case "MULTI_COUPS":
			return MULTI_COUPS;
		case "MULTITYPE":
			return MULTITYPE;
		case "NORMALISE":
			return NORMALISE;
		case "PEAU_SECHE":
			return PEAU_SECHE;
		case "PIED_CONFUS":
			return PIED_CONFUS;
		case "PIED_VELOCE":
			return PIED_VELOCE;
		case "POING_DE_FER":
			return POING_DE_FER;
		case "PREDICTION":
			return PREDICTION;
		case "QUERELLEUR":
			return QUERELLEUR;
		case "RIDEAU_NEIGE":
			return RIDEAU_NEIGE;
		case "RIVALITE":
			return RIVALITE;
		case "SIMPLE":
			return SIMPLE;
		case "SNIPER":
			return SNIPER;
		case "SOIN_POISON":
			return SOIN_POISON;
		case "SOLIDE_ROC":
			return SOLIDE_ROC;
		case "TECHNICIEN":
			return TECHNICIEN;
		case "TELECHARGE":
			return TELECHARGE;
		case "TEMERAIRE":
			return TEMERAIRE;
		case "ACHARNE":
			return ACHARNE;
		case "ANALYSTE":
			return ANALYSTE;
		case "ARMUROUILLEE":
			return ARMUROUILLEE;
		case "BAIGNE_SABLE":
			return BAIGNE_SABLE;
		case "COEUR_DE_COQ":
			return COEUR_DE_COQ;
		case "COEUR_NOBLE":
			return COEUR_NOBLE;
		case "COEUR_SOIN":
			return COEUR_SOIN;
		case "CONTESTATION":
			return CONTESTATION;
		case "CORPS_MAUDIT":
			return CORPS_MAUDIT;
		case "DEFAITISTE":
			return DEFAITISTE;
		case "ENVELOCAPE":
			return ENVELOCAPE;
		case "EPINE_DE_FER":
			return EPINE_DE_FER;
		case "FARCEUR":
			return FARCEUR;
		case "FORCE_SABLE":
			return FORCE_SABLE;
		case "GARDE_AMIE":
			return GARDE_AMIE;
		case "HEAVY_METAL":
			return HEAVY_METAL;
		case "HERBIVORE":
			return HERBIVORE;
		case "ILLUSION":
			return ILLUSION;
		case "IMPOSTEUR":
			return IMPOSTEUR;
		case "IMPUDENCE":
			return IMPUDENCE;
		case "INFILTRATION":
			return INFILTRATION;
		case "LIGHT_METAL":
			return LIGHT_METAL;
		case "LUNATIQUE":
			return LUNATIQUE;
		case "MIROIR_MAGIK":
			return MIROIR_MAGIK;
		case "MODE_TRANSE":
			return MODE_TRANSE;
		case "MOMIE":
			return MOMIE;
		case "MULTIECAILLE":
			return MULTIECAILLE;
		case "PEAU_MIRACLE":
			return PEAU_MIRACLE;
		case "PHOBIQUE":
			return PHOBIQUE;
		case "PICKPOCKET":
			return PICKPOCKET;
		case "RAGE_BRÛLURE":
			return RAGE_BRÛLURE;
		case "RAGE_POISON":
			return RAGE_POISON;
		case "RECOLTE":
			return RECOLTE;
		case "REGE_FORCE":
			return REGE_FORCE;
		case "SANS_LIMITE":
			return SANS_LIMITE;
		case "TELEPATHE":
			return TELEPATHE;
		case "TENSION":
			return TENSION;
		case "TERA_VOLTAGE":
			return TERA_VOLTAGE;
		case "TOXITOUCHE":
			return TOXITOUCHE;
		case "TURBOBRASIER":
			return TURBOBRASIER;
		case "VICTORIEUX":
			return VICTORIEUX;
		case "AILES_BOURRASQUE":
			return AILES_BOURRASQUE;
		case "AMOUR_FILIAL":
			return AMOUR_FILIAL;
		case "AROMA_VOILE":
			return AROMA_VOILE;
		case "AURA_FEERIQUE":
			return AURA_FEERIQUE;
		case "AURA_INVERSEE":
			return AURA_INVERSEE;
		case "AURA_TENEBREUSE":
			return AURA_TENEBREUSE;
		case "BAJOUES":
			return BAJOUES;
		case "BATTANT":
			return BATTANT;
		case "DECLIC_TACTIQUE":
			return DECLIC_TACTIQUE;
		case "FLORA_VOILE":
			return FLORA_VOILE;
		case "GLUCO_VOILE":
			return GLUCO_VOILE;
		case "GRIFFE_DURE":
			return GRIFFE_DURE;
		case "MAGICIEN":
			return MAGICIEN;
		case "MEGA_BLASTER":
			return MEGA_BLASTER;
		case "MER_PRIMAIRE":
			return MER_PRIMAIRE;
		case "PARE_BALLES":
			return PARE_BALLES;
		case "PEAU_CELESTE":
			return PEAU_CELESTE;
		case "PEAU_FEERIQUE":
			return PEAU_FEERIQUE;
		case "PEAU_GELEE":
			return PEAU_GELEE;
		case "POISSEUX":
			return POISSEUX;
		case "PROGNATHE":
			return PROGNATHE;
		case "PROTEEN":
			return PROTEEN;
		case "SOUFFLE_DELTA":
			return SOUFFLE_DELTA;
		case "SYMBIOSE":
			return SYMBIOSE;
		case "TERRE_FINALE":
			return TERRE_FINALE;
		case "TOISON_EPAISSE":
			return TOISON_EPAISSE;
		case "TOISON_HERBUE":
			return TOISON_HERBUE;
		default:
			return NULL;
		}
	}*/
	
}
