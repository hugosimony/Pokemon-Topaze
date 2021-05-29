package fr.hugosimony.pokemontopaze.pokemon.items;

public class Item {

	public Items item;
	public String name;
	public String category;
	public String description;
	public int price;
	public int sellingPrice;
	
	public Item(Items item) {
		this.item = item;
		String[] data = Items.getItemDatas(item);
		name = data[0];
		category = data[1];
		description = data[2];
		if(data[3].equals("-"))
			price = -1;
		else
			price = Integer.parseInt(data[3]);
		if(data[4].equals("-"))
			sellingPrice = -1;
		else
			sellingPrice = Integer.parseInt(data[4]);
	}
	
	public boolean isHoldBattleItem() {
		return category.equals("") || category.equals("");
	}
	
}
