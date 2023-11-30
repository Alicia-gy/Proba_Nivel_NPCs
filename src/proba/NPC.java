package proba;

import java.util.ArrayList;

abstract class NPC {
	
	private String name;
	private Ciudad city;
	private ArrayList<Item> items;


	
	
	public NPC(String name, Ciudad city) {
		this.name = name;
		this.city = city;
		items = new ArrayList<Item>();
	}
	
	
	
	public void addItem(Item item) throws MaxInventoryException {
		
	}

	
	public void removeItem(Item item) {
		if(items.contains(item)) {
			items.remove(item);
			System.out.println("item eliminado");
		} else {
			System.out.println("El NPC no tiene ese item");
		}
	}
	
	public Item buscarItem(String name) {
		Item item;
		
		item = items.stream().filter(n -> n.getName() == name).findAny().orElse(null);
		
		if(item == null) {
			System.out.println("Item no encontrado");
		}
		
		return item;
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
	
	public void checkItems() {
		System.out.println("Lista de objetos de " + name + "\n");
		items.forEach(n -> System.out.println(n.toString() + "\n"));
	} //imprime directamente la lista
	
	

	

}
