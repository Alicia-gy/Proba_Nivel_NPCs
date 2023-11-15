package proba;

public class NPC_ladron extends NPC {
	
	public NPC_ladron(String name, Ciudad city) {
		super(name, city);
	}
	
	
	@Override
	public void addItem(Item item) {
		if (super.getItems().size() < 3) {
			super.addItem(item);
			item.desgaste(25);
		} else {
			System.out.println("Inventario lleno! no puedes añadir este item");
		}
	}
}