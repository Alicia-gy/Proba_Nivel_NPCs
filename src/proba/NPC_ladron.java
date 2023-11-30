package proba;

public class NPC_ladron extends NPC {
	
	private static final int maxInventory = 3;
	private static final int desgaste = 25;
	
	public NPC_ladron(String name, Ciudad city) {
		super(name, city);
	}
	
	
	@Override
	public void addItem(Item item) throws MaxInventoryException {
		if (super.getItems().size() < maxInventory) {
			super.getItems().add(item);
			item.desgaste(desgaste);
		} else {
			throw new MaxInventoryException("Inventario lleno! no puedes añadir este item");
		}
	}
}
