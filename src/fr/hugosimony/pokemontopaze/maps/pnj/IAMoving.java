package fr.hugosimony.pokemontopaze.maps.pnj;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import fr.hugosimony.pokemontopaze.maps.Direction;
import fr.hugosimony.pokemontopaze.utils.IntTuple;
import fr.hugosimony.pokemontopaze.utils.Utils;

public class IAMoving extends TimerTask{

	private Pnj pnj;
	
	private int[][] directions;
	private IntTuple coo;

	public IAMoving(Pnj pnj, int[][] directions) {
		
		this.pnj = pnj;
		
		this.directions = directions;
		this.coo = findPosition();
	}
	
	@Override
	public void run() {
		
		if(pnj.IA) {
			try {
				Thread.sleep(Utils.randomNumber(2500, 4000));
			} catch (Exception e) {}
			
			if(!pnj.game.inAnimation && !pnj.game.inXMenu && !pnj.game.inSaveMenu && !pnj.game.inTextMenu && !pnj.game.inYesNoMenu && !pnj.mooving && !pnj.game.inBattle) {
				
				ArrayList<Direction> possibleDirections = getPossibleDirections();
				if(possibleDirections.size() > 0) {
					int random = Utils.randomNumber(possibleDirections.size()-1);
					
					if(pnj.isLookingTileFree(possibleDirections.get(random))) {
						new Timer().schedule(pnj.new Move(possibleDirections.get(random), false, null, null, null, null), 0, 8);
						setPosition(possibleDirections, random);
					}
				}
			}
		}
		else
			this.cancel();
	}
	
	private IntTuple findPosition() {
		for(int i = 0; i < directions.length; i++) {
			for(int j = 0; j < directions[i].length; j++) {
				if(directions[i][j] == 2)
					return new IntTuple(i, j);
			}
		}
		return new IntTuple(-1, -1);
	}
	
	private ArrayList<Direction> getPossibleDirections() {
		ArrayList<Direction> possibleDirections = new ArrayList<Direction>();
		if(coo.x-1 >= 0 && directions[coo.x-1][coo.y] == 1)
			possibleDirections.add(Direction.UP);
		if(coo.x+1 < directions.length && directions[coo.x+1][coo.y] == 1)
			possibleDirections.add(Direction.DOWN);
		if(coo.y-1 >= 0 && directions[coo.x][coo.y-1] == 1)
			possibleDirections.add(Direction.LEFT);
		if(coo.y+1 < directions[0].length && directions[coo.x][coo.y+1] == 1)
			possibleDirections.add(Direction.RIGHT);
		return possibleDirections;
	}
	
	private void setPosition(ArrayList<Direction> possibleDirections, int random) {
		if(possibleDirections.get(random) == Direction.UP) {
			directions[coo.x][coo.y] = 1;
			directions[coo.x-1][coo.y] = 2;
			coo.x--;
		}
		else if(possibleDirections.get(random) == Direction.DOWN) {
			directions[coo.x][coo.y] = 1;
			directions[coo.x+1][coo.y] = 2;
			coo.x++;
		}
		else if(possibleDirections.get(random) == Direction.LEFT) {
			directions[coo.x][coo.y] = 1;
			directions[coo.x][coo.y-1] = 2;
			coo.y--;
		}
		else {
			directions[coo.x][coo.y] = 1;
			directions[coo.x][coo.y+1] = 2;
			coo.y++;
		}
	}

}
