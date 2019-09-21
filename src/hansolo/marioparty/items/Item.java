package hansolo.marioparty.items;

public abstract class Item {
	
	private String descripcion;
	
	private int precio;
	
	public Item (String descripcion, int precio) {
		
		this.precio = precio;
		this.descripcion = descripcion;
	}
	
	public abstract void usarObjeto();
	
	public String getDescripcion() {
		return this.descripcion;
	}

}
