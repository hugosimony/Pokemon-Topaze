package fr.hugosimony.pokemontopaze.maps.pnj;

import java.awt.Image;

import fr.hugosimony.pokemontopaze.Const;
import fr.hugosimony.pokemontopaze.Variables;
import fr.hugosimony.pokemontopaze.maps.Direction;

public class PnjSprites {

	public static Image getGoodPnjSprite(String pnj, Direction direction, int foot) {
		
		//*********************************************************************************************
		// Mom
		
		if(pnj.equals("mom")) {
			if(direction == Direction.UP) {
				if(foot == 0)
					return Const.momBack.getImage();
				else if(foot == 1)
					return Const.momBackRight.getImage();
				else if(foot == 2)
					return Const.momBackLeft.getImage();
			}
			else if(direction == Direction.DOWN) {
				if(foot == 0)
					return Const.momFront.getImage();
				else if(foot == 1)
					return Const.momFrontRight.getImage();
				else if(foot == 2)
					return Const.momFrontLeft.getImage();
			}
			else if(direction == Direction.LEFT) {
				if(foot == 0)	
					return Const.momLeft.getImage();
				else if(foot == 1)	
					return Const.momLeftRight.getImage();
				else if(foot == 2)	
					return Const.momLeftLeft.getImage();
				
			}
			else if(direction == Direction.RIGHT) {
				if(foot == 0)	
					return Const.momRight.getImage();
				else if(foot == 1)	
					return Const.momRightRight.getImage();
				else if(foot == 2)	
					return Const.momRightLeft.getImage();
			}
		}
		
		//*********************************************************************************************
		// Brown Boy
		
		if(pnj.contains("brownboy")) {
			if(direction == Direction.UP) {
				if(foot == 0)
					return Const.brownboyBack.getImage();
				else if(foot == 1)
					return Const.brownboyBackRight.getImage();
				else if(foot == 2)
					return Const.brownboyBackLeft.getImage();
			}
			else if(direction == Direction.DOWN) {
				if(foot == 0)
					return Const.brownboyFront.getImage();
				else if(foot == 1)
					return Const.brownboyFrontRight.getImage();
				else if(foot == 2)
					return Const.brownboyFrontLeft.getImage();
			}
			else if(direction == Direction.LEFT) {
				if(foot == 0)	
					return Const.brownboyLeft.getImage();
				else if(foot == 1)	
					return Const.brownboyLeftRight.getImage();
				else if(foot == 2)	
					return Const.brownboyLeftLeft.getImage();
				
			}
			else if(direction == Direction.RIGHT) {
				if(foot == 0)	
					return Const.brownboyRight.getImage();
				else if(foot == 1)	
					return Const.brownboyRightRight.getImage();
				else if(foot == 2)	
					return Const.brownboyRightLeft.getImage();
			}
		}
		
		//*********************************************************************************************
		// Brown Girl
		
		if(pnj.contains("browngirl")) {
			if(direction == Direction.UP) {
				if(foot == 0)
					return Const.browngirlBack.getImage();
				else if(foot == 1)
					return Const.browngirlBackRight.getImage();
				else if(foot == 2)
					return Const.browngirlBackLeft.getImage();
			}
			else if(direction == Direction.DOWN) {
				if(foot == 0)
					return Const.browngirlFront.getImage();
				else if(foot == 1)
					return Const.browngirlFrontRight.getImage();
				else if(foot == 2)
					return Const.browngirlFrontLeft.getImage();
			}
			else if(direction == Direction.LEFT) {
				if(foot == 0)	
					return Const.browngirlLeft.getImage();
				else if(foot == 1)	
					return Const.browngirlLeftRight.getImage();
				else if(foot == 2)	
					return Const.browngirlLeftLeft.getImage();
				
			}
			else if(direction == Direction.RIGHT) {
				if(foot == 0)	
					return Const.browngirlRight.getImage();
				else if(foot == 1)	
					return Const.browngirlRightRight.getImage();
				else if(foot == 2)	
					return Const.browngirlRightLeft.getImage();
			}
		}
		
		//*********************************************************************************************
		// Police
		
		if(pnj.contains("police")) {
			if(direction == Direction.RIGHT) {
				if(foot == 0)	
					return Const.policeRight.getImage();
			}
		}
		
		//*********************************************************************************************
		// Seller Boy
		
		if(pnj.contains("sellerboy")) {
			if(direction == Direction.UP) {
				if(foot == 0)	
					return Const.sellerboyFront.getImage();
			}
			else if(direction == Direction.DOWN) {
				if(foot == 0)	
					return Const.sellerboyBack.getImage();
			}
			else if(direction == Direction.LEFT) {
				if(foot == 0)	
					return Const.sellerboyLeft.getImage();
			}
			else if(direction == Direction.RIGHT) {
				if(foot == 0)	
					return Const.sellerboyRight.getImage();
			}
		}		
		
		//*********************************************************************************************
		// Prof Chen
		
		if(pnj.equals("profChen")) {
			if(direction == Direction.UP) {
				if(foot == 0)
					return Const.profChenBack.getImage();
				else if(foot == 1)
					return Const.profChenBackRight.getImage();
				else if(foot == 2)
					return Const.profChenBackLeft.getImage();
			}
			else if(direction == Direction.DOWN) {
				if(foot == 0)
					return Const.profChenFront.getImage();
				else if(foot == 1)
					return Const.profChenFrontRight.getImage();
				else if(foot == 2)
					return Const.profChenFrontLeft.getImage();
			}
			else if(direction == Direction.LEFT) {
				if(foot == 0)	
					return Const.profChenLeft.getImage();
				else if(foot == 1)	
					return Const.profChenLeftRight.getImage();
				else if(foot == 2)	
					return Const.profChenLeftLeft.getImage();
				
			}
			else if(direction == Direction.RIGHT) {
				if(foot == 0)	
					return Const.profChenRight.getImage();
				else if(foot == 1)	
					return Const.profChenRightRight.getImage();
				else if(foot == 2)	
					return Const.profChenRightLeft.getImage();
			}
		}
		
		//*********************************************************************************************
		// Rival
		
		if(pnj.equals("rival")) {
			if(Variables.PERSO_Sex.equals("boy")) {
				if(direction == Direction.UP) {
					if(foot == 0)
						return Const.girlBack.getImage();
					else if(foot == 1)
						return Const.girlBackRight.getImage();
					else if(foot == 2)
						return Const.girlBackLeft.getImage();
				}
				else if(direction == Direction.DOWN) {
					if(foot == 0)
						return Const.girlFront.getImage();
					else if(foot == 1)
						return Const.girlFrontRight.getImage();
					else if(foot == 2)
						return Const.girlFrontLeft.getImage();
				}
				else if(direction == Direction.LEFT) {
					if(foot == 0)	
						return Const.girlLeft.getImage();
					else if(foot == 1)	
						return Const.girlLeftRight.getImage();
					else if(foot == 2)	
						return Const.girlLeftLeft.getImage();
					
				}
				else if(direction == Direction.RIGHT) {
					if(foot == 0)	
						return Const.girlRight.getImage();
					else if(foot == 1)	
						return Const.girlRightRight.getImage();
					else if(foot == 2)	
						return Const.girlRightLeft.getImage();
				}
			}
			else {
				if(direction == Direction.UP) {
					if(foot == 0)
						return Const.boyBack.getImage();
					else if(foot == 1)
						return Const.boyBackRight.getImage();
					else if(foot == 2)
						return Const.boyBackLeft.getImage();
				}
				else if(direction == Direction.DOWN) {
					if(foot == 0)
						return Const.boyFront.getImage();
					else if(foot == 1)
						return Const.boyFrontRight.getImage();
					else if(foot == 2)
						return Const.boyFrontLeft.getImage();
				}
				else if(direction == Direction.LEFT) {
					if(foot == 0)	
						return Const.boyLeft.getImage();
					else if(foot == 1)	
						return Const.boyLeftRight.getImage();
					else if(foot == 2)	
						return Const.boyLeftLeft.getImage();
					
				}
				else if(direction == Direction.RIGHT) {
					if(foot == 0)	
						return Const.boyRight.getImage();
					else if(foot == 1)	
						return Const.boyRightRight.getImage();
					else if(foot == 2)	
						return Const.boyRightLeft.getImage();
				}
			}
		}
		return null;
	}
	
}
