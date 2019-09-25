package hansolo.marioparty.items;

/**
 * Clase abstracta que define todo lo que comparten en común los items
 * Por ahi habría que hacer una clase abstracta Dado que herede de ésta. Así los dados quedan heredando de Dado que hereda de Item.
 * @author facundotourn
 *
 */
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
