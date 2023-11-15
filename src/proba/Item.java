package proba;

public class Item {
	
	private String name;
	private String type;
	private double price;
	private int durability;
	
	public Item(String name, String type, double price) {
		this.name = name;
		this.type = type;
		this.price = price;
		durability = 100;
	}
	
	
	public String getName() {
		return name;
	}
	
	public String getType() {
		return type;
	}
	
	public double getPrice() {
		return price;
	}
	
	public int getDurability() {
		return durability;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void desgaste(int desgaste) {
		durability -= desgaste;
	}
	
	@Override
	public String toString() {
		return("Nombre: " + name + 
				"\nTipo: " + type + 
				"\nPrecio: " + price + 
				"\nDurabilidad restante: " + durability);
	}

}
