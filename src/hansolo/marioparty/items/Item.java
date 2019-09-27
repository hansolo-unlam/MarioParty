package hansolo.marioparty.items;

import hansolo.marioparty.entidades.Jugador;

/**
 * Clase abstracta que define todo lo que comparten en común los items
 * Por ahi habría que hacer una clase abstracta Dado que herede de ésta. Así los dados quedan heredando de Dado que hereda de Item.
 * @author facundotourn
 *
 */
public abstract class Item {
	
	private String descripcion;
	private int precio;
	private int cantidad;
	
	public Item (String descripcion, int precio, int cantidad) {
		this.descripcion = descripcion;
		this.precio = precio;
		this.cantidad = cantidad;
	}
	
	public abstract void usar(Jugador jugador);
	
	public String getDescripcion() {	return descripcion;	}
	public int getPrecio() {	return precio;	}
	public int getCantidad() {	return cantidad;		}
	
	public void setCantidad(int cantidad) {	this.cantidad = cantidad;	}

}
