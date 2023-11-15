package proba;

public class NPC_mercader extends NPC {
	
	public NPC_mercader(String name, Ciudad city) {
		super(name, city);
	}
	

	
	@Override
	public void addItem(Item item) {
		if (super.getItems().size() < 7) {
			super.addItem(item);
			item.setPrice(item.getPrice() * 1.04);
		} else {
			System.out.println("Inventario lleno! no puedes añadir este item");
		}
	}
}