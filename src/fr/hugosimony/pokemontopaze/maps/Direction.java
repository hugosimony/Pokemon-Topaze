package fr.hugosimony.pokemontopaze.maps;

public enum Direction {
	UP, DOWN, LEFT, RIGHT, NULL, BLANK;
	
	public static Direction getGoodDirection(String direction) {
		if(direction.equals("UP"))
			return UP;
		if(direction.equals("DOWN"))
			return DOWN;
		if(direction.equals("LEFT"))
			return LEFT;
		return RIGHT;
	}
	
	public static Direction getGoodDirectionFromInt(int direction) {
		if(direction == 1)
			return UP;
		if(direction == 2)
			return DOWN;
		if(direction == 3)
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
