package fr.hugosimony.pokemontopaze.pokemon.items;

public class Item {

	Items item;
	String name;
	String category;
	String description;
	int price;
	
	public Item(Items item) {
		this.item = item;
	}
	
	public boolean isHoldBattleItem() {
		return category.equals("") || category.equals("");
	}
	
}
