package proba;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static ArrayList<Ciudad> ciudades = new ArrayList<Ciudad>();
	static ArrayList<NPC> npcs = new ArrayList<NPC>();
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) throws MaxInventoryException {
		
		newCity("Ciudad1");
		newCity("Ciudad2");
		newMercader("Mercader1", buscarCiudad("Ciudad1"));
		Item item1 = new Item("item1", "tipo1", 20);
		Item item2 = new Item("item2", "tipo2", 30);
		buscarNPC("Mercader1").addItem(item1);
		buscarNPC("Mercader1").addItem(item2);
		newMercader("Mercader2", buscarCiudad("Ciudad1"));
		newCampesino("Campesino1", buscarCiudad("Ciudad1"));
		newLadron("Ladron1", buscarCiudad("Ciudad1"));
		newMercader("Mercader3", buscarCiudad("Ciudad2"));
		Item item3 = new Item("item3", "tipo1", 50);
		Item item4 = new Item("item4", "tipo2", 10);
		buscarNPC("Campesino1").addItem(item3);
		buscarNPC("Ladron1").addItem(item4); 
		//datos insertados previamente para que la aplicacion funcione, en un caso real se recibirian de una base de datos
		
		
		int i = 0;
		while(i == 0) {
			switch(askString("Introduce la accion deseada:\n"
					+ "1- Consultar los items de un vendedor\n"
					+ "2- Consultar los vendedores que hay en una ciudad\n"
					+ "3- Mostrar el item mas barato de todos los vendedores de una ciudad\n"
					+ "4- Comprar item a un NPC\n"
					+ "0- Salir de la aplicacion")) {
			case "1":
				buscarNPC("Mercader1").checkItems();
				break;
			case "2":
				buscarCiudad("Ciudad1").checkCityNPC();
				break;
			case "3":
				buscarCiudad("Ciudad1").checkCheapestItemInCity();
				break;
			case "4":
				NPC npc = buscarNPC("Mercader1");
				npc.removeItem(npc.buscarItem("item1"));
				break;
			default:
				System.out.println("Saliendo de la aplicacion");
				i++;
			}
			
		}	
		
	}
	
	
	
	
	public static void newCity(String name) {
		Ciudad city = new Ciudad(name);
		ciudades.add(city);
	}
	
	public static Ciudad buscarCiudad(String name) {
		Ciudad city = null;
		
		city = ciudades.stream().filter(n -> n.getName() == name).findAny().orElse(null);
		
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
		NPC npc;
		
		npc = npcs.stream().filter(n -> n.getName() == name).findAny().orElse(null);
		
		if(npc == null) {
			System.out.println("NPC no encontrado");
		}
		
		return npc;
	}
	
	static String askString(String message) {
		System.out.println(message);
		return scan.nextLine().strip();
	}
	
	static int askInt(String message) {
		System.out.println(message);
		return scan.nextInt();
	}
	
	
	

}
