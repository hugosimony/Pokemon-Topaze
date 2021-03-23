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
		// Cap Boy
		
		if(pnj.contains("capboy")) {
			if(direction == Direction.UP) {
				if(foot == 0)
					return Const.capboyBack.getImage();
				else if(foot == 1)
					return Const.capboyBackRight.getImage();
				else if(foot == 2)
					return Const.capboyBackLeft.getImage();
			}
			else if(direction == Direction.DOWN) {
				if(foot == 0)
					return Const.capboyFront.getImage();
				else if(foot == 1)
					return Const.capboyFrontRight.getImage();
				else if(foot == 2)
					return Const.capboyFrontLeft.getImage();
			}
			else if(direction == Direction.LEFT) {
				if(foot == 0)	
					return Const.capboyLeft.getImage();
				else if(foot == 1)	
					return Const.capboyLeftRight.getImage();
				else if(foot == 2)	
					return Const.capboyLeftLeft.getImage();
				
			}
			else if(direction == Direction.RIGHT) {
				if(foot == 0)	
					return Const.capboyRight.getImage();
				else if(foot == 1)	
					return Const.capboyRightRight.getImage();
				else if(foot == 2)	
					return Const.capboyRightLeft.getImage();
			}
		}
		
		//*********************************************************************************************
		// Cap Boy
		
		if(pnj.contains("bugcatcher")) {
			if(direction == Direction.UP) {
				if(foot == 0)
					return Const.bugcatcherBack.getImage();
				else if(foot == 1)
					return Const.bugcatcherBackRight.getImage();
				else if(foot == 2)
					return Const.bugcatcherBackLeft.getImage();
			}
			else if(direction == Direction.DOWN) {
				if(foot == 0)
					return Const.bugcatcherFront.getImage();
				else if(foot == 1)
					return Const.bugcatcherFrontRight.getImage();
				else if(foot == 2)
					return Const.bugcatcherFrontLeft.getImage();
			}
			else if(direction == Direction.LEFT) {
				if(foot == 0)	
					return Const.bugcatcherLeft.getImage();
				else if(foot == 1)	
					return Const.bugcatcherLeftRight.getImage();
				else if(foot == 2)	
					return Const.bugcatcherLeftLeft.getImage();
				
			}
			else if(direction == Direction.RIGHT) {
				if(foot == 0)	
					return Const.bugcatcherRight.getImage();
				else if(foot == 1)	
					return Const.bugcatcherRightRight.getImage();
				else if(foot == 2)	
					return Const.bugcatcherRightLeft.getImage();
			}
		}
		
		//*********************************************************************************************
		// Camping Boy
		
		if(pnj.contains("campingboy")) {
			if(direction == Direction.UP) {
				if(foot == 0)
					return Const.campingboyBack.getImage();
				else if(foot == 1)
					return Const.campingboyBackRight.getImage();
				else if(foot == 2)
					return Const.campingboyBackLeft.getImage();
			}
			else if(direction == Direction.DOWN) {
				if(foot == 0)
					return Const.campingboyFront.getImage();
				else if(foot == 1)
					return Const.campingboyFrontRight.getImage();
				else if(foot == 2)
					return Const.campingboyFrontLeft.getImage();
			}
			else if(direction == Direction.LEFT) {
				if(foot == 0)	
					return Const.campingboyLeft.getImage();
				else if(foot == 1)	
					return Const.campingboyLeftRight.getImage();
				else if(foot == 2)	
					return Const.campingboyLeftLeft.getImage();
				
			}
			else if(direction == Direction.RIGHT) {
				if(foot == 0)	
					return Const.campingboyRight.getImage();
				else if(foot == 1)	
					return Const.campingboyRightRight.getImage();
				else if(foot == 2)	
					return Const.campingboyRightLeft.getImage();
			}
		}
		
		//*********************************************************************************************
		// Camping Girl
		
		if(pnj.contains("campinggirl")) {
			if(direction == Direction.UP) {
				if(foot == 0)
					return Const.campinggirlBack.getImage();
				else if(foot == 1)
					return Const.campinggirlBackRight.getImage();
				else if(foot == 2)
					return Const.campinggirlBackLeft.getImage();
			}
			else if(direction == Direction.DOWN) {
				if(foot == 0)
					return Const.campinggirlFront.getImage();
				else if(foot == 1)
					return Const.campinggirlFrontRight.getImage();
				else if(foot == 2)
					return Const.campinggirlFrontLeft.getImage();
			}
			else if(direction == Direction.LEFT) {
				if(foot == 0)	
					return Const.campinggirlLeft.getImage();
				else if(foot == 1)	
					return Const.campinggirlLeftRight.getImage();
				else if(foot == 2)	
					return Const.campinggirlLeftLeft.getImage();
				
			}
			else if(direction == Direction.RIGHT) {
				if(foot == 0)	
					return Const.campinggirlRight.getImage();
				else if(foot == 1)	
					return Const.campinggirlRightRight.getImage();
				else if(foot == 2)	
					return Const.campinggirlRightLeft.getImage();
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
		// Umbrella Girl
		
		if(pnj.contains("umbrellagirl")) {
			if(direction == Direction.UP) {
				if(foot == 0)
					return Const.umbrellagirlBack.getImage();
				else if(foot == 1)
					return Const.umbrellagirlBackRight.getImage();
				else if(foot == 2)
					return Const.umbrellagirlBackLeft.getImage();
			}
			else if(direction == Direction.DOWN) {
				if(foot == 0)
					return Const.umbrellagirlFront.getImage();
				else if(foot == 1)
					return Const.umbrellagirlFrontRight.getImage();
				else if(foot == 2)
					return Const.umbrellagirlFrontLeft.getImage();
			}
			else if(direction == Direction.LEFT) {
				if(foot == 0)	
					return Const.umbrellagirlLeft.getImage();
				else if(foot == 1)	
					return Const.umbrellagirlLeftRight.getImage();
				else if(foot == 2)	
					return Const.umbrellagirlLeftLeft.getImage();
				
			}
			else if(direction == Direction.RIGHT) {
				if(foot == 0)	
					return Const.umbrellagirlRight.getImage();
				else if(foot == 1)	
					return Const.umbrellagirlRightRight.getImage();
				else if(foot == 2)	
					return Const.umbrellagirlRightLeft.getImage();
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
