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
	private boolean enabled;
	
	public Item (String descripcion, int precio, boolean enabled) {
		this.descripcion = descripcion;
		this.precio = precio;
		this.enabled = enabled;
	}
	
	public abstract void usar();
	
	public String getDescripcion() {	return descripcion;	}
	public int getPrecio() {	return precio;	}
	public boolean isEnabled() {	return enabled;		}

}
