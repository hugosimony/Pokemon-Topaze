package fr.hugosimony.pokemontopaze.maps.pnj;

import java.awt.Image;

import fr.hugosimony.pokemontopaze.sprites.perso.ConstPersoSprites;
import fr.hugosimony.pokemontopaze.Variables;
import fr.hugosimony.pokemontopaze.maps.Direction;

public class PnjSprites {

	public static Image getGoodPnjSprite(String pnj, Direction direction, int foot) {
		
		//*********************************************************************************************
		// Mom
		
		if(pnj.equals("mom")) {
			if(direction == Direction.UP) {
				if(foot == 0)
					return ConstPersoSprites.momBack.getImage();
				else if(foot == 1)
					return ConstPersoSprites.momBackRight.getImage();
				else if(foot == 2)
					return ConstPersoSprites.momBackLeft.getImage();
			}
			else if(direction == Direction.DOWN) {
				if(foot == 0)
					return ConstPersoSprites.momFront.getImage();
				else if(foot == 1)
					return ConstPersoSprites.momFrontRight.getImage();
				else if(foot == 2)
					return ConstPersoSprites.momFrontLeft.getImage();
			}
			else if(direction == Direction.LEFT) {
				if(foot == 0)	
					return ConstPersoSprites.momLeft.getImage();
				else if(foot == 1)	
					return ConstPersoSprites.momLeftRight.getImage();
				else if(foot == 2)	
					return ConstPersoSprites.momLeftLeft.getImage();
				
			}
			else if(direction == Direction.RIGHT) {
				if(foot == 0)	
					return ConstPersoSprites.momRight.getImage();
				else if(foot == 1)	
					return ConstPersoSprites.momRightRight.getImage();
				else if(foot == 2)	
					return ConstPersoSprites.momRightLeft.getImage();
			}
		}
		
		//*********************************************************************************************
		// Brown Boy
		
		if(pnj.contains("brownboy")) {
			if(direction == Direction.UP) {
				if(foot == 0)
					return ConstPersoSprites.brownboyBack.getImage();
				else if(foot == 1)
					return ConstPersoSprites.brownboyBackRight.getImage();
				else if(foot == 2)
					return ConstPersoSprites.brownboyBackLeft.getImage();
			}
			else if(direction == Direction.DOWN) {
				if(foot == 0)
					return ConstPersoSprites.brownboyFront.getImage();
				else if(foot == 1)
					return ConstPersoSprites.brownboyFrontRight.getImage();
				else if(foot == 2)
					return ConstPersoSprites.brownboyFrontLeft.getImage();
			}
			else if(direction == Direction.LEFT) {
				if(foot == 0)	
					return ConstPersoSprites.brownboyLeft.getImage();
				else if(foot == 1)	
					return ConstPersoSprites.brownboyLeftRight.getImage();
				else if(foot == 2)	
					return ConstPersoSprites.brownboyLeftLeft.getImage();
				
			}
			else if(direction == Direction.RIGHT) {
				if(foot == 0)	
					return ConstPersoSprites.brownboyRight.getImage();
				else if(foot == 1)	
					return ConstPersoSprites.brownboyRightRight.getImage();
				else if(foot == 2)	
					return ConstPersoSprites.brownboyRightLeft.getImage();
			}
		}
		
		//*********************************************************************************************
		// Brown Girl
		
		if(pnj.contains("browngirl")) {
			if(direction == Direction.UP) {
				if(foot == 0)
					return ConstPersoSprites.browngirlBack.getImage();
				else if(foot == 1)
					return ConstPersoSprites.browngirlBackRight.getImage();
				else if(foot == 2)
					return ConstPersoSprites.browngirlBackLeft.getImage();
			}
			else if(direction == Direction.DOWN) {
				if(foot == 0)
					return ConstPersoSprites.browngirlFront.getImage();
				else if(foot == 1)
					return ConstPersoSprites.browngirlFrontRight.getImage();
				else if(foot == 2)
					return ConstPersoSprites.browngirlFrontLeft.getImage();
			}
			else if(direction == Direction.LEFT) {
				if(foot == 0)	
					return ConstPersoSprites.browngirlLeft.getImage();
				else if(foot == 1)	
					return ConstPersoSprites.browngirlLeftRight.getImage();
				else if(foot == 2)	
					return ConstPersoSprites.browngirlLeftLeft.getImage();
				
			}
			else if(direction == Direction.RIGHT) {
				if(foot == 0)	
					return ConstPersoSprites.browngirlRight.getImage();
				else if(foot == 1)	
					return ConstPersoSprites.browngirlRightRight.getImage();
				else if(foot == 2)	
					return ConstPersoSprites.browngirlRightLeft.getImage();
			}
		}
		
		//*********************************************************************************************
		// Cap Boy
		
		if(pnj.contains("capboy")) {
			if(direction == Direction.UP) {
				if(foot == 0)
					return ConstPersoSprites.capboyBack.getImage();
				else if(foot == 1)
					return ConstPersoSprites.capboyBackRight.getImage();
				else if(foot == 2)
					return ConstPersoSprites.capboyBackLeft.getImage();
			}
			else if(direction == Direction.DOWN) {
				if(foot == 0)
					return ConstPersoSprites.capboyFront.getImage();
				else if(foot == 1)
					return ConstPersoSprites.capboyFrontRight.getImage();
				else if(foot == 2)
					return ConstPersoSprites.capboyFrontLeft.getImage();
			}
			else if(direction == Direction.LEFT) {
				if(foot == 0)	
					return ConstPersoSprites.capboyLeft.getImage();
				else if(foot == 1)	
					return ConstPersoSprites.capboyLeftRight.getImage();
				else if(foot == 2)	
					return ConstPersoSprites.capboyLeftLeft.getImage();
				
			}
			else if(direction == Direction.RIGHT) {
				if(foot == 0)	
					return ConstPersoSprites.capboyRight.getImage();
				else if(foot == 1)	
					return ConstPersoSprites.capboyRightRight.getImage();
				else if(foot == 2)	
					return ConstPersoSprites.capboyRightLeft.getImage();
			}
		}
		
		//*********************************************************************************************
		// Cap Boy
		
		if(pnj.contains("bugcatcher")) {
			if(direction == Direction.UP) {
				if(foot == 0)
					return ConstPersoSprites.bugcatcherBack.getImage();
				else if(foot == 1)
					return ConstPersoSprites.bugcatcherBackRight.getImage();
				else if(foot == 2)
					return ConstPersoSprites.bugcatcherBackLeft.getImage();
			}
			else if(direction == Direction.DOWN) {
				if(foot == 0)
					return ConstPersoSprites.bugcatcherFront.getImage();
				else if(foot == 1)
					return ConstPersoSprites.bugcatcherFrontRight.getImage();
				else if(foot == 2)
					return ConstPersoSprites.bugcatcherFrontLeft.getImage();
			}
			else if(direction == Direction.LEFT) {
				if(foot == 0)	
					return ConstPersoSprites.bugcatcherLeft.getImage();
				else if(foot == 1)	
					return ConstPersoSprites.bugcatcherLeftRight.getImage();
				else if(foot == 2)	
					return ConstPersoSprites.bugcatcherLeftLeft.getImage();
				
			}
			else if(direction == Direction.RIGHT) {
				if(foot == 0)	
					return ConstPersoSprites.bugcatcherRight.getImage();
				else if(foot == 1)	
					return ConstPersoSprites.bugcatcherRightRight.getImage();
				else if(foot == 2)	
					return ConstPersoSprites.bugcatcherRightLeft.getImage();
			}
		}
		
		//*********************************************************************************************
		// Camping Boy
		
		if(pnj.contains("campingboy")) {
			if(direction == Direction.UP) {
				if(foot == 0)
					return ConstPersoSprites.campingboyBack.getImage();
				else if(foot == 1)
					return ConstPersoSprites.campingboyBackRight.getImage();
				else if(foot == 2)
					return ConstPersoSprites.campingboyBackLeft.getImage();
			}
			else if(direction == Direction.DOWN) {
				if(foot == 0)
					return ConstPersoSprites.campingboyFront.getImage();
				else if(foot == 1)
					return ConstPersoSprites.campingboyFrontRight.getImage();
				else if(foot == 2)
					return ConstPersoSprites.campingboyFrontLeft.getImage();
			}
			else if(direction == Direction.LEFT) {
				if(foot == 0)	
					return ConstPersoSprites.campingboyLeft.getImage();
				else if(foot == 1)	
					return ConstPersoSprites.campingboyLeftRight.getImage();
				else if(foot == 2)	
					return ConstPersoSprites.campingboyLeftLeft.getImage();
				
			}
			else if(direction == Direction.RIGHT) {
				if(foot == 0)	
					return ConstPersoSprites.campingboyRight.getImage();
				else if(foot == 1)	
					return ConstPersoSprites.campingboyRightRight.getImage();
				else if(foot == 2)	
					return ConstPersoSprites.campingboyRightLeft.getImage();
			}
		}
		
		//*********************************************************************************************
		// Camping Girl
		
		if(pnj.contains("campinggirl")) {
			if(direction == Direction.UP) {
				if(foot == 0)
					return ConstPersoSprites.campinggirlBack.getImage();
				else if(foot == 1)
					return ConstPersoSprites.campinggirlBackRight.getImage();
				else if(foot == 2)
					return ConstPersoSprites.campinggirlBackLeft.getImage();
			}
			else if(direction == Direction.DOWN) {
				if(foot == 0)
					return ConstPersoSprites.campinggirlFront.getImage();
				else if(foot == 1)
					return ConstPersoSprites.campinggirlFrontRight.getImage();
				else if(foot == 2)
					return ConstPersoSprites.campinggirlFrontLeft.getImage();
			}
			else if(direction == Direction.LEFT) {
				if(foot == 0)	
					return ConstPersoSprites.campinggirlLeft.getImage();
				else if(foot == 1)	
					return ConstPersoSprites.campinggirlLeftRight.getImage();
				else if(foot == 2)	
					return ConstPersoSprites.campinggirlLeftLeft.getImage();
				
			}
			else if(direction == Direction.RIGHT) {
				if(foot == 0)	
					return ConstPersoSprites.campinggirlRight.getImage();
				else if(foot == 1)	
					return ConstPersoSprites.campinggirlRightRight.getImage();
				else if(foot == 2)	
					return ConstPersoSprites.campinggirlRightLeft.getImage();
			}
		}
		
		//*********************************************************************************************
		// Overalls Man
		
		if(pnj.contains("overallsman")) {
			if(direction == Direction.UP) {
				if(foot == 0)
					return ConstPersoSprites.overallsmanBack.getImage();
				else if(foot == 1)
					return ConstPersoSprites.overallsmanBackRight.getImage();
				else if(foot == 2)
					return ConstPersoSprites.overallsmanBackLeft.getImage();
			}
			else if(direction == Direction.DOWN) {
				if(foot == 0)
					return ConstPersoSprites.overallsmanFront.getImage();
				else if(foot == 1)
					return ConstPersoSprites.overallsmanFrontRight.getImage();
				else if(foot == 2)
					return ConstPersoSprites.overallsmanFrontLeft.getImage();
			}
			else if(direction == Direction.LEFT) {
				if(foot == 0)	
					return ConstPersoSprites.overallsmanLeft.getImage();
				else if(foot == 1)	
					return ConstPersoSprites.overallsmanLeftRight.getImage();
				else if(foot == 2)	
					return ConstPersoSprites.overallsmanLeftLeft.getImage();
				
			}
			else if(direction == Direction.RIGHT) {
				if(foot == 0)	
					return ConstPersoSprites.overallsmanRight.getImage();
				else if(foot == 1)	
					return ConstPersoSprites.overallsmanRightRight.getImage();
				else if(foot == 2)	
					return ConstPersoSprites.overallsmanRightLeft.getImage();
			}
		}
		
		//*********************************************************************************************
		// Police
		
		if(pnj.contains("police")) {
			if(direction == Direction.RIGHT) {
				if(foot == 0)	
					return ConstPersoSprites.policeRight.getImage();
			}
		}
		
		//*********************************************************************************************
		// Seller Boy
		
		if(pnj.contains("sellerboy")) {
			if(direction == Direction.UP) {
				if(foot == 0)	
					return ConstPersoSprites.sellerboyFront.getImage();
			}
			else if(direction == Direction.DOWN) {
				if(foot == 0)	
					return ConstPersoSprites.sellerboyBack.getImage();
			}
			else if(direction == Direction.LEFT) {
				if(foot == 0)	
					return ConstPersoSprites.sellerboyLeft.getImage();
			}
			else if(direction == Direction.RIGHT) {
				if(foot == 0)	
					return ConstPersoSprites.sellerboyRight.getImage();
			}
		}		
		
		//*********************************************************************************************
		// Umbrella Girl
		
		if(pnj.contains("umbrellagirl")) {
			if(direction == Direction.UP) {
				if(foot == 0)
					return ConstPersoSprites.umbrellagirlBack.getImage();
				else if(foot == 1)
					return ConstPersoSprites.umbrellagirlBackRight.getImage();
				else if(foot == 2)
					return ConstPersoSprites.umbrellagirlBackLeft.getImage();
			}
			else if(direction == Direction.DOWN) {
				if(foot == 0)
					return ConstPersoSprites.umbrellagirlFront.getImage();
				else if(foot == 1)
					return ConstPersoSprites.umbrellagirlFrontRight.getImage();
				else if(foot == 2)
					return ConstPersoSprites.umbrellagirlFrontLeft.getImage();
			}
			else if(direction == Direction.LEFT) {
				if(foot == 0)	
					return ConstPersoSprites.umbrellagirlLeft.getImage();
				else if(foot == 1)	
					return ConstPersoSprites.umbrellagirlLeftRight.getImage();
				else if(foot == 2)	
					return ConstPersoSprites.umbrellagirlLeftLeft.getImage();
				
			}
			else if(direction == Direction.RIGHT) {
				if(foot == 0)	
					return ConstPersoSprites.umbrellagirlRight.getImage();
				else if(foot == 1)	
					return ConstPersoSprites.umbrellagirlRightRight.getImage();
				else if(foot == 2)	
					return ConstPersoSprites.umbrellagirlRightLeft.getImage();
			}
		}
		
		//*********************************************************************************************
		// Prof Chen
		
		if(pnj.equals("profChen")) {
			if(direction == Direction.UP) {
				if(foot == 0)
					return ConstPersoSprites.profChenBack.getImage();
				else if(foot == 1)
					return ConstPersoSprites.profChenBackRight.getImage();
				else if(foot == 2)
					return ConstPersoSprites.profChenBackLeft.getImage();
			}
			else if(direction == Direction.DOWN) {
				if(foot == 0)
					return ConstPersoSprites.profChenFront.getImage();
				else if(foot == 1)
					return ConstPersoSprites.profChenFrontRight.getImage();
				else if(foot == 2)
					return ConstPersoSprites.profChenFrontLeft.getImage();
			}
			else if(direction == Direction.LEFT) {
				if(foot == 0)	
					return ConstPersoSprites.profChenLeft.getImage();
				else if(foot == 1)	
					return ConstPersoSprites.profChenLeftRight.getImage();
				else if(foot == 2)	
					return ConstPersoSprites.profChenLeftLeft.getImage();
				
			}
			else if(direction == Direction.RIGHT) {
				if(foot == 0)	
					return ConstPersoSprites.profChenRight.getImage();
				else if(foot == 1)	
					return ConstPersoSprites.profChenRightRight.getImage();
				else if(foot == 2)	
					return ConstPersoSprites.profChenRightLeft.getImage();
			}
		}
		
		//*********************************************************************************************
		// Rival
		
		if(pnj.equals("rival")) {
			if(Variables.PERSO_Sex.equals("boy")) {
				if(direction == Direction.UP) {
					if(foot == 0)
						return ConstPersoSprites.girlBack.getImage();
					else if(foot == 1)
						return ConstPersoSprites.girlBackRight.getImage();
					else if(foot == 2)
						return ConstPersoSprites.girlBackLeft.getImage();
				}
				else if(direction == Direction.DOWN) {
					if(foot == 0)
						return ConstPersoSprites.girlFront.getImage();
					else if(foot == 1)
						return ConstPersoSprites.girlFrontRight.getImage();
					else if(foot == 2)
						return ConstPersoSprites.girlFrontLeft.getImage();
				}
				else if(direction == Direction.LEFT) {
					if(foot == 0)	
						return ConstPersoSprites.girlLeft.getImage();
					else if(foot == 1)	
						return ConstPersoSprites.girlLeftRight.getImage();
					else if(foot == 2)	
						return ConstPersoSprites.girlLeftLeft.getImage();
					
				}
				else if(direction == Direction.RIGHT) {
					if(foot == 0)	
						return ConstPersoSprites.girlRight.getImage();
					else if(foot == 1)	
						return ConstPersoSprites.girlRightRight.getImage();
					else if(foot == 2)	
						return ConstPersoSprites.girlRightLeft.getImage();
				}
			}
			else {
				if(direction == Direction.UP) {
					if(foot == 0)
						return ConstPersoSprites.boyBack.getImage();
					else if(foot == 1)
						return ConstPersoSprites.boyBackRight.getImage();
					else if(foot == 2)
						return ConstPersoSprites.boyBackLeft.getImage();
				}
				else if(direction == Direction.DOWN) {
					if(foot == 0)
						return ConstPersoSprites.boyFront.getImage();
					else if(foot == 1)
						return ConstPersoSprites.boyFrontRight.getImage();
					else if(foot == 2)
						return ConstPersoSprites.boyFrontLeft.getImage();
				}
				else if(direction == Direction.LEFT) {
					if(foot == 0)	
						return ConstPersoSprites.boyLeft.getImage();
					else if(foot == 1)	
						return ConstPersoSprites.boyLeftRight.getImage();
					else if(foot == 2)	
						return ConstPersoSprites.boyLeftLeft.getImage();
					
				}
				else if(direction == Direction.RIGHT) {
					if(foot == 0)	
						return ConstPersoSprites.boyRight.getImage();
					else if(foot == 1)	
						return ConstPersoSprites.boyRightRight.getImage();
					else if(foot == 2)	
						return ConstPersoSprites.boyRightLeft.getImage();
				}
			}
		}
		return null;
	}
	
}
