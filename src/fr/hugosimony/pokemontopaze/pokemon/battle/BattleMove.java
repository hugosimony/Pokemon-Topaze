package fr.hugosimony.pokemontopaze.pokemon.battle;

import fr.hugosimony.pokemontopaze.pokemon.Abilities;
import fr.hugosimony.pokemontopaze.pokemon.Move;
import fr.hugosimony.pokemontopaze.pokemon.Status;
import fr.hugosimony.pokemontopaze.utils.Utils;

public class BattleMove {
	
	private Battle battle;
	private BattlePokemon sender;
	private BattlePokemon target;
	private Move move;
	private boolean subMove;
	private boolean player;
	
	private String senderName;
	private String targetName;
	
	public BattleMove(Battle battle, BattlePokemon sender, BattlePokemon target, Move move, boolean subMove, boolean player) {
		this.battle = battle;
		this.sender = sender;
		this.target = target;
		this.move = move;
		this.subMove = subMove;
		this.player = player;
	
		senderName = sender.name + (player ? " ennemi " : " ");
		targetName = sender.name + (player ? " " : " ennemi ");
		
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("Start of the move " + move.name + " by " + senderName + " against " + targetName);
		
		// https://github.com/smogon/pokemon-showdown/blob/master/simulator-doc.txt
		// https://github.com/smogon/pokemon-showdown/blob/master/sim/battle.ts
		// https://www.pokebip.com/page/general/particularites_attaques
		// https://www.pokepedia.fr/Cible#Rater_et_r.C3.A9ussir_son_attaque_dans_les_jeux_vid.C3.A9o
		String result = startMove();
		System.out.println(result);
	}
	
	private String startMove() {
		
		if(!subMove) {
			if(checkStatus())
				return "status";
		}
		
		System.out.println(senderName + "utilise " + move.name);
		
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
		
		//TODO 
		// Check Brise Moule
		
		//TODO
		// Get Damage
		// https://www.pokepedia.fr/Calcul_des_d%C3%A9g%C3%A2ts
		
		// TODO 
		// Handle the freeze after an attack
		
		// End of the move
		
		// Update the pokemon data
		battle.battlePokemon1 = player ? sender : target;
		battle.battlePokemon2 = player ? target : sender;
		
		return "0";
	}
	
	private boolean checkStatus() {
		
		// https://www.pokepedia.fr/Statut
		
		boolean canceled = false;
		
		if(Status.hasPreMoveEffect(sender.status)) {
			if(sender.secondaryStatus.contains(Status.FLINCH)) {
				System.out.println(senderName + "est appeuré et ne peut pas bouger.");
				canceled = true;
			}
			if(!canceled && sender.secondaryStatus.contains(Status.OVERLEVEL)) {
				int random = Utils.randomNumber(8);
				if(random == 0 || random == 1)
					System.out.println(senderName + "ignore les ordres.");
				else if(random == 2)
					System.out.println(senderName + "s'amuse de son côté.");
				else if(random == 3)
					System.out.println(senderName + "se retourne et ne vous écoute pas.");
				else if(random == 4)
					System.out.println(senderName + "ne veut pas obéir.");
				else if(random == 5)
					System.out.println(senderName + "fait comme s'il n'avais pas entendu.");
				else if(random == 6)
					System.out.println(senderName + "se fiche de vous.");
				else if(random == 7) {
					System.out.println(senderName + "s'endort.");
					sender.status = Status.SLEEP;
				}
				else if(random == 8) {
					System.out.println(senderName + "ne veut pas obéir et se blesse tout seul.");
					//TODO
					// Hurt the pokemon as a confusion
				}
				if(random == 0 || random == 3 || random == 4 || random == 5 || random == 6) {
					Move randomMove = null;
					int r = Utils.randomNumber(3);
					if(r == 0) randomMove = sender.move1;
					else if(r == 1) randomMove = sender.move2;
					else if(r == 2) randomMove = sender.move3;
					else if(r == 3) randomMove = sender.move4;
					System.out.println(senderName + "utilise plutôt" + randomMove.name);
					new BattleMove(battle, sender, target, randomMove, true, player);
				}
				canceled = true;
			}
			if(!canceled && sender.status == Status.PARALYSIS) {
				if(Utils.randomNumber(3) == 0) {
					System.out.println(senderName + "est paralysé et ne peut pas attaquer.");
					canceled = true;
				}
			}
			else if(!canceled && sender.status == Status.FREEZE) {
				if(Utils.randomNumber(4) == 0 || move.doUnfreeze()) {
					System.out.println(senderName + "dégèle.");
					sender.status = Status.NULL;
				}
				else {
					System.out.println(senderName + "est gelé et ne peut pas attaquer.");
					canceled = true;
				}
			}
			else if(!canceled && sender.status == Status.SLEEP) {
				if(sender.statusTurn == 0) {
					System.out.println(senderName + "se réveille.");
					sender.status = Status.NULL;
				}
				else if(!move.canMoveInSleep()) {
					System.out.println(senderName + "dort.");
					sender.statusTurn--;
					canceled = true;
				}
			}
			if(!canceled && sender.secondaryStatus.contains(Status.ATTRACTION)) {
				System.out.println(senderName + "est amoureux de " + targetName);
				if(Utils.randomNumber(1) == 0) {
					System.out.println("L'amour empèche " + senderName + "d'attaquer");
					canceled = true;
				}
			}
			if(!canceled && sender.secondaryStatus.contains(Status.CONFUSION)) {
				if(sender.confusionTurn == 0) {
					System.out.println(senderName + "n'est plus confus.");
					sender.secondaryStatus.remove(Status.CONFUSION);
				}
				else {
					System.out.println(senderName + "est confus.");
					if(Utils.randomNumber(1) == 0) {
						System.out.println(senderName + "se blesse dans sa confusion");
						canceled = true;
						//TODO
						// Hurt the pokemon as a confusion
					}
					sender.confusionTurn--;
				}
			}
		}
		return canceled;
	}

}
