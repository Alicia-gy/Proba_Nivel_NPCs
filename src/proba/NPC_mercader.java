package proba;

public class NPC_mercader extends NPC {
	
	private static final int maxInventory = 7;
	private static final double tax = 1.04;
	
	public NPC_mercader(String name, Ciudad city) {
		super(name, city);
	}
	

	
	@Override
	public void addItem(Item item) throws MaxInventoryException {
		if (super.getItems().size() < maxInventory) {
			super.getItems().add(item);
			item.setPrice(item.getPrice() * tax);
		} else {
			throw new MaxInventoryException("Inventario lleno! no puedes añadir este item");
		}
	}
}
