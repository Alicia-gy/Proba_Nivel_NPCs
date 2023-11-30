package proba;

public class NPC_campesino extends NPC {
	
	private static final int maxInventory = 5;
	private static final double tax = 1.04;
	private static final int desgaste = 15;
	
	public NPC_campesino(String name, Ciudad city) {
		super(name, city);
	}
	
	
	@Override
	public void addItem(Item item) throws MaxInventoryException {
		if (super.getItems().size() < maxInventory) {
			super.getItems().add(item);
			item.setPrice(item.getPrice() * tax);
			item.desgaste(desgaste);
		} else {
			throw new MaxInventoryException("Inventario lleno! no puedes añadir este item");
		}
	}
}
