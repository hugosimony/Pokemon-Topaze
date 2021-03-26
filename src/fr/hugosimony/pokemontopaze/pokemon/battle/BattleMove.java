package fr.hugosimony.pokemontopaze.pokemon.battle;

import fr.hugosimony.pokemontopaze.pokemon.Abilities;
import fr.hugosimony.pokemontopaze.pokemon.Move;
import fr.hugosimony.pokemontopaze.pokemon.Status;

public class BattleMove {
	
	public BattleMove(Battle battle, BattlePokemon sender, BattlePokemon target, Move move, boolean player) {
		
		boolean canceled = false;
		
		if(Status.hasPreMoveEffect(sender.status)) {
			
		}
		
		if(canceled)
			return;
		
		System.out.println(sender.name + (player ? " ennemi " : " ") + "utilise " + move.name);
		
		//TODO 
		// Handle case like solar beam, etc
		
		//TODO
		// Start sub moves like metronome or sleep talk, etc (do not check status)
		
		move.pp--;
		if(target.ability.ability == Abilities.PRESSION)
			move.pp--;
		
	}

}
