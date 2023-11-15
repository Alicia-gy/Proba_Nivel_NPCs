package proba;

import java.util.ArrayList;

public class NPC {
	
	private String name;
	private Ciudad city;
	private ArrayList<Item> items;

	
	
	public NPC(String name, Ciudad city) {
		this.name = name;
		this.city = city;
		items = new ArrayList<Item>();
	}
	
	
	
	public void addItem(Item item) {
		items.add(item);
	}
	
	public void removeItem(Item item) {
		items.removeIf(cond -> item.getName().equals(item.getName()));
	}
	
	public String getName() {
		return name;
	}
	
	public Ciudad getCity() {
		return city;
	}
	
	public ArrayList<Item> getItems() {
		return items;
	}
	

	

}
