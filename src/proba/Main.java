package proba;

import java.util.ArrayList;

public class Main {
	static ArrayList<Ciudad> ciudades = new ArrayList<Ciudad>();
	static ArrayList<NPC> npcs = new ArrayList<NPC>();
	
	public static void main(String[] args) {
		
		newCity("Ciudad1");
		newCity("Ciudad2");
		newMercader("Mercader1", buscarCiudad("Ciudad1"));
		
		Item item1 = new Item("item1", "tipo1", 20);
		Item item2 = new Item("item2", "tipo2", 30);
		buscarNPC("Mercader1").addItem(item1);
		buscarNPC("Mercader1").addItem(item2);
		
		checkItems(buscarNPC("Mercader1"));
		
		newMercader("Mercader2", buscarCiudad("Ciudad1"));
		newCampesino("Campesino1", buscarCiudad("Ciudad1"));
		newLadron("Ladron1", buscarCiudad("Ciudad1"));
		newMercader("Mercader3", buscarCiudad("Ciudad2"));
		
		checkCityNPC(buscarCiudad("Ciudad1"));
		
		Item item3 = new Item("item3", "tipo1", 50);
		Item item4 = new Item("item4", "tipo2", 10);
		
		buscarNPC("Campesino1").addItem(item3);
		buscarNPC("Ladron1").addItem(item4);
		
		checkCheapestItemInCity(buscarCiudad("Ciudad1"));
	}
	
	public static void checkItems(NPC npc) {
		System.out.println("Lista de objetos de " + npc.getName() + "\n");
		npc.getItems().forEach(n -> System.out.println(n.toString() + "\n"));
	}
	
	public static void checkCityNPC(Ciudad city) {
		System.out.println("Lista de habitantes de " + city.getName());
		city.getHabitants().forEach(n -> System.out.println(n.getName() + "\n "));
	}
	
	public static void checkCheapestItemInCity(Ciudad city) {
		ArrayList<Item> items= new ArrayList<Item>();
		int index = 0;
		
		city.getHabitants().forEach(n -> n.getItems().forEach(i -> items.add(i)));
		
		for(int i = 0; i < items.size(); i++) {
			if(items.get(index).getPrice() < items.get(i).getPrice()) {
				index = i;
			}
		}
		System.out.println("El item mas barato de " + city.getName() + " es: \n" + items.get(index).toString());
	}
	
	public static void newCity(String name) {
		Ciudad city = new Ciudad(name);
		ciudades.add(city);
	}
	
	public static Ciudad buscarCiudad(String name) {
		Ciudad city = null;
		for(Ciudad c : ciudades) {
			if(c.getName() == name) {
				city = c;
			}
		}
		if(city == null) {
			System.out.println("Ciudad no encontrada");
		}
		
		return city;
	}
	
	public static void newCampesino(String name, Ciudad city) {
		NPC_campesino npc = new NPC_campesino(name, city);
		city.addHabitants(npc);
		npcs.add(npc);
	}
	
	public static void newMercader(String name, Ciudad city) {
		NPC_mercader npc = new NPC_mercader(name, city);
		city.addHabitants(npc);
		npcs.add(npc);
	}
	
	public static void newLadron(String name, Ciudad city) {
		NPC_ladron npc = new NPC_ladron(name, city);
		city.addHabitants(npc);
		npcs.add(npc);
	}
	
	public static NPC buscarNPC(String name) {
		NPC npc = null;
		for(NPC n : npcs) {
			if(n.getName() == name) {
				npc = n;
			}
		}
		if(npc == null) {
			System.out.println("NPC no encontrado");
		}
		
		return npc;
	}

}
