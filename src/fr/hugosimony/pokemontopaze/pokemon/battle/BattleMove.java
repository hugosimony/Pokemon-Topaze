package fr.hugosimony.pokemontopaze.pokemon.battle;

import fr.hugosimony.pokemontopaze.pokemon.Abilities;
import fr.hugosimony.pokemontopaze.pokemon.Gender;
import fr.hugosimony.pokemontopaze.pokemon.Move;
import fr.hugosimony.pokemontopaze.pokemon.Moves;
import fr.hugosimony.pokemontopaze.pokemon.Status;
import fr.hugosimony.pokemontopaze.pokemon.Type;
import fr.hugosimony.pokemontopaze.pokemon.items.Items;
import fr.hugosimony.pokemontopaze.utils.Utils;

public class BattleMove {
	
	private Battle battle;
	private BattlePokemon sender;
	private BattlePokemon target;
	private Move move;
	private boolean subMove;
	@SuppressWarnings("unused")
	private int subMoveCount;
	private boolean overlevel;
	private boolean player;
	
	private String senderName;
	private String senderNameMaj;
	private String targetName;
	private String targetNameMaj;
	@SuppressWarnings("unused")
	private String senderNameClean;
	private String targetNameClean;
	
	public BattleMove(Battle battle, BattlePokemon sender, BattlePokemon target, Move move, boolean subMove, int subMoveCount, boolean overlevel, boolean player) {
		this.battle = battle;
		this.sender = sender;
		this.target = target;
		this.move = move;
		this.subMove = subMove;
		this.subMoveCount = subMoveCount;
		this.overlevel = overlevel;
		this.player = player;
	
		senderName = (player ? "" : "le ") + sender.name + (player ? "" : " ennemi");
		targetName = (player ? "le " : "") + target.name + (player ? " ennemi" : "");
		senderName = (player ? "" : "le ") + sender.name + (player ? "" : " ennemi");
		targetName = (player ? "le " : "") + target.name + (player ? " ennemi" : "");
		senderNameClean = sender.name + (player ? "" : " ennemi");
		targetNameClean = target.name + (player ? " ennemi" : "");
		
		System.out.println("-------------------------------------------------------------");
		System.out.println(move.name + " par " + senderName + " contre " + targetName);
		
		// https://github.com/smogon/pokemon-showdown/blob/master/simulator-doc.txt
		// https://github.com/smogon/pokemon-showdown/blob/master/sim/battle.ts
		// https://www.pokebip.com/page/general/particularites_attaques
		// https://www.pokepedia.fr/Cible#Rater_et_r.C3.A9ussir_son_attaque_dans_les_jeux_vid.C3.A9o
		// https://www.pokepedia.fr/Modification_des_statistiques
		startMove();
	}
	
	private String startMove() {
		
		// https://www.pokepedia.fr/Cat%C3%A9gorie_de_talent
		
		if(!subMove) {
			if(checkStatus())
				return "status";
		}
		
		System.out.println(senderNameMaj + " utilise " + move.name);
		
		// https://www.pokepedia.fr/Brise_Moule
		
		//TODO 
		// Handle case like solar beam, etc
		
		// https://www.pokepedia.fr/Cat%C3%A9gorie:Capacit%C3%A9_Combo
		// https://www.pokepedia.fr/Cat%C3%A9gorie:Capacit%C3%A9_%C3%A0_plusieurs_coups
		
		//TODO
		// Start sub moves like metronome or sleep talk, etc (do not check status)
		
		if(!subMove) {
			if(move.pp != 0) move.pp--;
			if(move.pp != 0 && target.ability.ability == Abilities.PRESSION)
				move.pp--;
		}
		
		// https://www.pokepedia.fr/Pr%C3%A9cision
		
		if(move.move != Moves.TOXIK || !sender.isType(Type.POISON)) {
			if(checkPrecision())
				return "avoided";
		}
		
		//TODO 
		// Check Brise Moule
		
		if(move.isSound() && target.ability.ability == Abilities.ANTI_BRUIT) {
			battle.printAbility(target);
			System.out.println("Ça n'affecte pas" + targetName + "...");
			return "immune";
		}
		
		//TODO
		// Get Damage
		// https://www.pokepedia.fr/Calcul_des_d%C3%A9g%C3%A2ts
		
		int damage = 0;
		
		if(move.category == Type.STATUT) {
			
			if(move.isStatusMove()) {
				// Status
				// https://www.pokepedia.fr/Statut
				
				// TODO Abilities.FEUILLE_GARDE
				
				// Paralysis
				if(move.move == Moves.CAGE_ECLAIR || move.move == Moves.PARA_SPORE || move.move == Moves.INTIMIDATION) {
					if(target.ability.ability == Abilities.ECHAUFFEMENT) {
						battle.printAbility(target);
						System.out.println("Ça n'affecte pas " + targetName + "...");
						return "immune";
					}
					if(target.isType(Type.ELECTRIK)) {
						System.out.println("Ça n'affecte pas " + targetName + "...");
						return "immune";
					}
					target.status = Status.PARALYSIS;
					System.out.println(targetNameMaj + " est paralysé.");
					battle.updateData();
				}
				
				// Poison
				else if(move.move == Moves.GAZ_TOXIK || move.move == Moves.TOXIK) {
					if(target.ability.ability == Abilities.VACCIN) {
						battle.printAbility(target);
						System.out.println("Ça n'affecte pas " + targetName + "...");
						return "immune";
					}
					if(move.move == Moves.GAZ_TOXIK) {
						target.status = Status.POISON;
						System.out.println(targetNameMaj + " est empoisonné.");
					}
					else if(move.move == Moves.TOXIK) {
						target.status = Status.BIGPOISON;
						System.out.println(targetNameMaj + " est gravement empoisonné.");
					}
					target.statusTurn = 1;
					battle.updateData();
				}
			
				// Burn
				else if(move.move == Moves.FEU_FOLLET) {
					if(target.ability.ability == Abilities.IGNIFU_VOILE) {
						battle.printAbility(target);
						System.out.println("Ça n'affecte pas " + targetName + "...");
						return "immune";
					}
					target.status = Status.BURN;
					System.out.println(targetNameMaj + " brûle.");
					battle.updateData();
				}
				
				// Sleep
				else if(move.move == Moves.HYPNOSE || move.move == Moves.TROU_NOIR || move.move == Moves.GROBISOU
				|| move.move == Moves.BERCEUSE || move.move == Moves.POUDRE_DODO || move.move == Moves.SPORE
				|| move.move == Moves.SIFFL_HERBE) {
					sender.setSleep(false);
					System.out.println(targetNameMaj + " s'endort.");
					battle.updateData();
				}
				else if(move.move == Moves.BAILLEMENT) {
					target.baillement = 1;
					System.out.println(targetNameMaj + " somnole.");
				}
				else if(move.move == Moves.REPOS) {
					// TODO Full heal
					sender.setSleep(true);
					System.out.println(senderNameMaj + " s'endort.");
					battle.updateData();
					return "selfheal";
				}
				
				// Attraction
				else if(move.move == Moves.ATTRACTION) {
					if(target.secondaryStatus.contains(Status.ATTRACTION)) {
						System.out.println(targetNameMaj + " est déjà amoureux.");
						return "failed";
					}
					if(sender.gender == Gender.NEUTRAL) {
						System.out.println("Mais cela échoue...");
						return "failed";
					}
					if(target.gender == Gender.NEUTRAL) {
						System.out.println("Ça n'affecte pas " + targetName + "...");
						return "immune";
					}
					if(target.ability.ability == Abilities.BENET || target.ability.ability == Abilities.AROMA_VOILE) {
						battle.printAbility(target);
						System.out.println("Ça n'affecte pas " + targetName + "...");
						return "immune";
					}
					if(target.item.item == Items.HERBE_MENTAL) {
						battle.printItem(target);
						System.out.println(targetNameMaj + " est immunisé.");
						target.useItem(true);
						return "itemCanceled";
					}
					if(sender.gender != target.gender) {
						target.secondaryStatus.add(Status.ATTRACTION);
						System.out.println(targetNameMaj + " tombe amoureux.");
						if(target.item.item == Items.NOEUD_DESTIN && !sender.secondaryStatus.contains(Status.ATTRACTION)
						&& sender.ability.ability != Abilities.BENET && sender.ability.ability != Abilities.MIROIR_MAGIK
						&& sender.ability.ability != Abilities.AROMA_VOILE) {
							battle.printItem(target);
							System.out.println(targetNameMaj + " lie son destin avec " + senderName + ".");
							target.useItem(false);
							if(sender.item.item == Items.HERBE_MENTAL) {
								battle.printItem(sender);
								System.out.println(senderNameMaj + " est immunisé.");
								target.useItem(true);
								return "itemCanceled";
							}
							sender.secondaryStatus.add(Status.ATTRACTION);
							System.out.println(senderNameMaj + " tombe amoureux.");
						}
					}
				}
				
			}
			else if(move.isBonusNonOffensiceStatMove() || move.isMalusNonOffensiveStatMove()){
				// Statistics
				// https://www.pokebip.com/page/jeuxvideo/guide_tactique_strategie_pokemon/attaques
				if(move.isBonusNonOffensiceStatMove()) {
					// Bonus
				}
				else {
					// Malus
				}
			}
		}
		else {
			
			// Check immunity
			if(Type.getMultiplier(move.type, target.type1, target.type2) == 0) {
				System.out.println("Ça n'affecte pas " + targetName + "...");
				return "immune";
			}
			
			if(move.doOHKO()) {
				// TODO handle ohko
				System.out.println("KO en un coup !");
				damage = 1000000;
			}
			else if(move.move == Moves.SONICBOOM)
				damage = 20;
			else if(move.move == Moves.DRACO_RAGE)
				damage = 40;
			else if(move.move == Moves.OMBRE_NOCTURNE || move.move == Moves.FRAPPE_ATLAS)
				damage = sender.level;
			else {
				
				// Random range
				double CM = Utils.randomNumber(85, 100) / 100d;
				
				// STAB
				if(sender.type1 == move.type || sender.type2 == move.type) CM *= 1.5;
				
				// Types
				
				double typeTable = Type.getMultiplier(move.type, target.type1, target.type2);
				if(typeTable == 2)
					System.out.println("C'est super efficace.");
				else if(typeTable == 4)
					System.out.println("C'est extrémement efficace.");
				else if(typeTable == 0.5)
					System.out.println("Ce n'est pas très efficace.");
				else if(typeTable == 0.25)
					System.out.println("Ce n'est pas du tout efficace.");
				CM *= typeTable;
				
				//TODO Critical Hits
				
				//TODO Talents, Items, Field
				
				if(move.isVariable()) {
					// TODO
					// Handle each case
					damage = 100;
				}
				if(move.move == Moves.TRICHERIE)
					damage = (int) (((int) ((((sender.level * 0.4) + 2) * (target.getStat("ATK") * move.power)) / (target.getStat("DEF") * 50)) + 2) * CM);
				else if(move.move == Moves.CHOC_PSY || move.move == Moves.FRAPPE_PSY || move.move == Moves.LAME_OINTE)
					damage = (int) (((int) ((((sender.level * 0.4) + 2) * (target.getStat("ATK_SPE") * move.power)) / (target.getStat("DEF") * 50)) + 2) * CM);
				else {
					if(move.category == Type.PHYSIQUE)
						damage = (int) (((int) ((((sender.level * 0.4) + 2) * (sender.getStat("ATK") * move.power)) / (target.getStat("DEF") * 50)) + 2) * CM);
					else if(move.category == Type.SPECIALE)
						damage = (int) (((int) ((((sender.level * 0.4) + 2) * (sender.getStat("ATK_SPE") * move.power)) / (target.getStat("DEF_SPE") * 50)) + 2) * CM);
				}
			}
			System.out.println("The attack did " + damage + " HP(s) !");
			target.removeHP(damage);
		}
		
		// TODO
		// Check items to survive
		
		// TODO 
		// Check kill
		
		// TODO
		// Check Attack secondary effects
		
		// TODO 
		// Handle the freeze after an attack
		
		// TODO
		// Check overlevel
		
		// TODO
		// Check status / abilities
		
		// End of the move
		
		// Update the pokemon data
		battle.battlePokemon1 = player ? target : sender;
		battle.battlePokemon2 = player ? sender : target;
		
		battle.updateData();
		
		return "success";
	}
	
	private boolean checkStatus() {
		
		// https://www.pokepedia.fr/Statut
		
		boolean canceled = false;
		
		if(Status.hasPreMoveEffect(sender.status)) {
			if(sender.secondaryStatus.contains(Status.FLINCH)) {
				System.out.println(senderNameMaj + "est appeuré et ne peut pas bouger.");
				sender.secondaryStatus.remove(Status.FLINCH);
				canceled = true;
			}
			if(!overlevel && !canceled && sender.secondaryStatus.contains(Status.OVERLEVEL)) {
				int random = Utils.randomNumber(8);
				if(random == 0 || random == 1)
					System.out.println(senderNameMaj + "ignore les ordres.");
				else if(random == 2)
					System.out.println(senderNameMaj + "s'amuse de son côté.");
				else if(random == 3)
					System.out.println(senderNameMaj + "se retourne et ne vous écoute pas.");
				else if(random == 4)
					System.out.println(senderNameMaj + "ne veut pas obéir.");
				else if(random == 5)
					System.out.println(senderNameMaj + "fait comme s'il n'avais pas entendu.");
				else if(random == 6)
					System.out.println(senderNameMaj + "se fiche de vous.");
				else if(random == 7) {
					System.out.println(senderNameMaj + "s'endort.");
					sender.setSleep(false);
					// TODO set statut
				}
				else if(random == 8) {
					System.out.println(senderNameMaj + "ne veut pas obéir et se blesse tout seul.");
					doConfusionHurt();
				}
				if(random == 0 || random == 3 || random == 4 || random == 5 || random == 6) {
					Move randomMove = null;
					int r = Utils.randomNumber(3);
					if(r == 0) randomMove = sender.move1;
					else if(r == 1) randomMove = sender.move2;
					else if(r == 2) randomMove = sender.move3;
					else if(r == 3) randomMove = sender.move4;
					System.out.println(senderNameMaj + "utilise plutôt" + randomMove.name);
					new BattleMove(battle, sender, target, randomMove, false, 0, true, player);
				}
				canceled = true;
			}
			if(!canceled && sender.status == Status.PARALYSIS) {
				if(Utils.randomNumber(3) == 0) {
					System.out.println(senderNameMaj + "est paralysé et ne peut pas attaquer.");
					canceled = true;
				}
			}
			else if(!canceled && sender.status == Status.FREEZE) {
				if(Utils.randomNumber(4) == 0 || move.doUnfreeze()) {
					System.out.println(senderNameMaj + "dégèle.");
					sender.status = Status.NULL;
				}
				else {
					System.out.println(senderNameMaj + "est gelé et ne peut pas attaquer.");
					canceled = true;
				}
			}
			else if(!canceled && sender.status == Status.SLEEP) {
				if(sender.statusTurn == 0) {
					System.out.println(senderNameMaj + "se réveille.");
					sender.status = Status.NULL;
				}
				else if(!move.canMoveInSleep()) {
					System.out.println(senderNameMaj + "dort.");
					sender.statusTurn--;
					canceled = true;
				}
			}
			if(!canceled && sender.secondaryStatus.contains(Status.ATTRACTION)) {
				// TODO remove attraction if opponent switch
				System.out.println(senderNameMaj + "est amoureux de " + targetNameClean);
				if(Utils.randomNumber(1) == 0) {
					System.out.println("L'amour empèche " + senderName + "d'attaquer");
					canceled = true;
				}
			}
			if(!canceled && sender.secondaryStatus.contains(Status.CONFUSION)) {
				if(sender.confusionTurn == 0) {
					System.out.println(senderNameMaj + "n'est plus confus.");
					sender.secondaryStatus.remove(Status.CONFUSION);
				}
				else {
					System.out.println(senderNameMaj + "est confus.");
					if(Utils.randomNumber(1) == 0) {
						System.out.println(senderNameMaj + "se blesse dans sa confusion");
						doConfusionHurt();
						canceled = true;
					}
					sender.confusionTurn--;
				}
			}
		}
		return canceled;
	}
	

	private void doConfusionHurt() {
		
	}
	
	
	private boolean checkPrecision() {
		
		// https://www.pokepedia.fr/Pr%C3%A9cision
		// TODO lentille zomm et poudre claire
		
		if(move.precision == 1000)
			return false;
		
		boolean canceled = false;
		
		int accuracy = sender.getAccuracy("PRECISION", move.precision);
		accuracy = target.getAccuracy("AVOIDANCE", accuracy);
		if(sender.ability.ability == Abilities.AGITATION && move.category == Type.PHYSIQUE)
			accuracy = (int) (accuracy * 0.8);
		if(sender.ability.ability == Abilities.OEIL_COMPOSE)
			accuracy = (int) (accuracy * 1.3);
		if(sender.item.item == Items.LOUPE)
			accuracy = (int) (accuracy * 1.1);
		System.out.println(accuracy);
		if(accuracy < 100) {
			int random = Utils.randomNumber(1, 100);
			if(random > accuracy) {
				canceled = true;
				System.out.println(targetNameMaj + " avoided the attack.");
			}
		}
		
		return canceled;
		
	}
	
}
