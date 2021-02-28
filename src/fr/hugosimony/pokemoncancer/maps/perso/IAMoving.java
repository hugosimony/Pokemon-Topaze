package fr.hugosimony.pokemoncancer.maps.perso;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import fr.hugosimony.pokemoncancer.maps.Direction;

public class IAMoving extends TimerTask{

	private Pnj pnj;
	
	public int spot;
	private ArrayList<ArrayList<Direction>> directions;
	private ArrayList<Direction> actualDirections;

	public IAMoving(Pnj pnj, int spot, int spots, ArrayList<Direction> directions) {
		
		this.pnj = pnj;
		
		this.directions = new ArrayList<ArrayList<Direction>>();
		for(int i = 0; i<spots; i++)
			this.directions.add(new ArrayList<Direction>());
		
		this.spot = 0;
		for(Direction dir : directions) {
			if(dir != Direction.NULL)
				this.directions.get(this.spot).add(dir);
			else
				this.spot++;
		}
		
		this.spot = spot;
	}
	
	@Override
	public void run() {
		
		if(!pnj.game.inXMenu && !pnj.game.inSaveMenu && !pnj.game.inTextMenu && !pnj.game.inYesNoMenu && !pnj.mooving && !pnj.game.inBattle) {
			
			actualDirections = directions.get(spot + 2);
			
			int random = (int) (Math.random() * actualDirections.size());
			while(actualDirections.get(random) == Direction.BLANK)
				random = (int) (Math.random() * actualDirections.size());
			
			if(pnj.isLookingTileFree(actualDirections.get(random))) {
				new Timer().schedule(pnj.new Move(actualDirections.get(random)), 0, 5);
				setSpot(random);
			}
			
		}
	}
	
	private void setSpot(int random) {
		if(random == 0)
			spot += 2;
		else if(random == 1)
			spot += 1;
		else if(random == 2)
			spot -= 1;
		else if(random == 3)
			spot -= 2;
	}

}
