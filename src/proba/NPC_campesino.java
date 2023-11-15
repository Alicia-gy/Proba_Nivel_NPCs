package proba;

public class NPC_campesino extends NPC {
	
	public NPC_campesino(String name, Ciudad city) {
		super(name, city);
	}
	
	
	@Override
	public void addItem(Item item) {
		if (super.getItems().size() < 5) {
			super.addItem(item);
			item.setPrice(item.getPrice() * 1.04);
			item.desgaste(15);
		} else {
			System.out.println("Inventario lleno! no puedes añadir este item");
		}
	}
}
