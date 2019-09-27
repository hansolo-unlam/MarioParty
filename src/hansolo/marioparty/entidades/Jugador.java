package hansolo.marioparty.entidades;

import java.util.ArrayList;
import java.util.List;

import hansolo.marioparty.Partida;
import hansolo.marioparty.admin.Usuario;
import hansolo.marioparty.items.DadoDoble;
import hansolo.marioparty.items.DadoSimple;
import hansolo.marioparty.items.Item;
import hansolo.marioparty.tablero.Casillero;
import hansolo.marioparty.tablero.EnumDireccion;

public class Jugador {

	private Usuario user;
	private int monedas, estrellas;
	private Casillero posicion;
	private List<Item> items = new ArrayList<Item>();
	private int cantMovimientos;

	private Partida partida;

	public Jugador(Usuario user, Casillero start, Partida partida) {
		this.user = user;
		this.monedas = this.estrellas = 0;
		this.posicion = start;

		this.partida = partida;
		this.cantMovimientos = 0;
		
		//CREAR ITEMS
		items.add(new DadoDoble(0));
		
	}
	
	/**
	 * M�todo que tira el dado del jugador. Deber�a ser ac� donde se le deja elegir al jugador cu�l de sus dados tirar. Si es que agregamos m�s dados.
	 * @return int n�mero que sali� en el dado
	 */
	public void tirarDado() {
		this.cantMovimientos = DadoSimple.tirar();
	}
	
	public void tiempoAcciones() {
//		 *	PREGUNTAR SI EJECUTARA ACCIONES (CON TIEMPO)
//		 * 	SI								
//		 *		PREGUNTAR QUE ITEM USARA
				Item item = this.items.get(0);
				item.usar(this);
//		 * 	No
//		 * 		... sin acciones ...
//		 *
	}
	
	/**
	 * Mueve al jugador una cierta cantidad de casilleros
	 * @param cant la cantidad de casilleros que hay que avanzar
	 */
	public void avanzar() {
		while (cantMovimientos > 0) {
			// En el primer ciclo, yo s� que no est� parado en un casillero de bifurcaci�n
			avanzarAlSiguienteCasillero();
			
			// Si quedan movimientos y ca� en un casillero que se activa solo pasando, ejecuto el efecto del casillero antes de moverme de nuevo
			// Este puede ser el efecto tanto de una BifurcacionCasillero, EstrellaCasillero o TiendaCasillero
			cantMovimientos--;
		}
		this.posicion.efecto(this);
	}

	/**
	 * Mueve al jugador desde su casillero actual al casillero al que corresponde avanzar
	 */
	public void avanzarAlSiguienteCasillero() {
		int idCasilleroSiguiente = this.posicion.getSiguiente().getId();
		EnumDireccion dir = this.posicion.getSiguiente().getDireccion();
		
		// Ac� deber�a moverse al jugador hasta el siguiente casillero, con la direcci�n ya se puede calcular la nueva ubicaci�n del jugador
		
		this.posicion = partida.getTablero().getCasilleros().get(idCasilleroSiguiente);
		
		if (cantMovimientos > 1 && this.posicion.isEfectoPasandoSobre())
			this.posicion.efecto(this);
	}

	public void terminarTurno() {
		partida.pasarTurno();
	}

	public int getMonedas() {
		return monedas;
	}
	public int getEstrellas() {
		return estrellas;
	}

	public void setEstrellas(int estrellasGanadas) {
		//estrellas += (-estrellasGanadas > estrellas ? -estrellas : estrellasGanadas);
		estrellas = estrellasGanadas;
	}

	public void setMonedas(int monedasGanadas) {
		//this.monedas += (-monedasGanadas > this.monedas ? -this.monedas : monedasGanadas);
		monedas = monedasGanadas;
	}
	
	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public Casillero getPosicion() {
		return posicion;
	}

	public void setPosicion(Casillero posicion) {
		this.posicion = posicion;
	}
	
	public int getCantMovimientos() {
		return cantMovimientos;
	}

	public void setCantMovimientos(int cantMovimientos) {
		this.cantMovimientos = cantMovimientos;
	}
	
	public Item getItem(int pos) {
		return items.get(pos);
	}
	
	
	
	
}
