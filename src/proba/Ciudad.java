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
	
	public void mostrarHabitants() {
		for(int i = 0; i < habitants.size(); i++) {
			System.out.println(habitants.get(i).getName());
		}
	}
	
	public ArrayList<NPC> getHabitants() {
		return habitants;
	}
	
	public String getName() {
		return name;
	}
	

	
	
}
