package proba;

import java.util.ArrayList;

public class Ciudad {
	
	private String name;
	private ArrayList<NPC> habitants;
	
	public Ciudad(String name) {
		this.name = name;
		habitants = new ArrayList<NPC>();
	}
	
	
	public void addHabitants(NPC npc) {
		habitants.add(npc);
	}
	
	public void checkCityNPC() {
		System.out.println("Lista de habitantes de " + name);
		habitants.forEach(n -> System.out.println(n.getName() + "\n "));
	} //imprime lista de NPCs
	
	public void checkCheapestItemInCity() {
		ArrayList<Item> items= new ArrayList<Item>();
		int index = 0;
		
		habitants.forEach(n -> n.getItems().forEach(i -> items.add(i)));
		
		for(int i = 0; i < items.size(); i++) {
			if(items.get(index).getPrice() < items.get(i).getPrice()) {
				index = i;
			}
		}
		System.out.println("El item mas barato de " + name + " es: \n" + items.get(index).toString());
	} //imprime el objeto mas barato de la ciudad
	
	
	public ArrayList<NPC> getHabitants() {
		return habitants;
	}
	
	public String getName() {
		return name;
	}
	

	
	
}
