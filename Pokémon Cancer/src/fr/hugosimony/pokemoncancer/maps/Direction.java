package fr.hugosimony.pokemoncancer.maps;

public enum Direction {
	UP, DOWN, LEFT, RIGHT;
	
	public static Direction getGoodDirection(String direction) {
		if(direction.equals("UP"))
			return UP;
		if(direction.equals("DOWN"))
			return DOWN;
		if(direction.equals("LEFT"))
			return LEFT;
		return RIGHT;
	}
	
	public static Direction getOpositeDirection(Direction direction) {
		if(direction == UP)
			return DOWN;
		if(direction == DOWN)
			return UP;
		if(direction == LEFT)
			return RIGHT;
		return LEFT;
	}
	
}
