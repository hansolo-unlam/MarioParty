package hansolo.marioparty.entidades;

import hansolo.marioparty.Partida;
import hansolo.marioparty.admin.Usuario;
import hansolo.marioparty.items.Item;
import hansolo.marioparty.tablero.Casillero;
import hansolo.marioparty.tablero.EnumDireccion;

public class Jugador {

	private Usuario user;
	private int monedas, estrellas;
	private Casillero posicion;
	private Item[] items;

	private Partida partida;

	public Jugador(Usuario user, Casillero start, Partida partida) {
		this.user = user;
		this.monedas = this.estrellas = 0;
		this.posicion = start;

		this.partida = partida;
	}

	public int tirarDado() {
		return 5;
//		int randomInt;
//		Random r = new Random();
//		if(dado normal)					//en las condiciones puse lo que deberia comprobar 
//			randomInt = r.nextInt(6-1);//dado los tipos de dados que tenemosno se como enviariamos un item o si creamos una clase dado
//		else							//no se como enviariamos un item o si creamos una clase dado
//			if(dado doble)				//segun eso habria que generar las condiciones y agregar mas si me falta algun dado
//				randomInt = r.nextInt(6-1)*2;
//			else
//				randomInt = r.nextInt(6-1)+5;
//		this.avanzar(randomInt);
	}
	
	/**
	 * Mueve al jugador una cierta cantidad de casilleros
	 * @param cant la cantidad de casilleros que hay que avanzar
	 */
	public void avanzar(int cant) {
		for (int i = 0; i < cant; i++) {
			// En el primer ciclo, yo sé que no está parado en un casillero de bifurcación
			avanzarAlSiguienteCasillero();
			
			// Si quedan movimientos y caí en un casillero que se activa solo pasando, ejecuto el efecto del casillero antes de moverme de nuevo
			// Este puede ser el efecto tanto de una BifurcacionCasillero, EstrellaCasillero o TiendaCasillero
			if (i < cant - 1 && this.posicion.isEfectoPasandoSobre())
				
				this.posicion.efecto(this);
		}
		this.posicion.efecto(this);
	}
	
	/**
	 * Mueve al jugador desde su casillero actual al casillero al que corresponde avanzar
	 */
	public void avanzarAlSiguienteCasillero() {
		int idCasilleroSiguiente = this.posicion.getSiguiente().getId();
		EnumDireccion dir = this.posicion.getSiguiente().getDireccion();
		
		// Acá debería moverse al jugador hasta el siguiente casillero, con la dirección ya se puede calcular la nueva ubicación del jugador
		
		this.posicion = partida.getTablero().getCasilleros().get(idCasilleroSiguiente);
	}

	public void terminarTurno() {
		partida.pasarTurno();
	}

	public int getMonedas() {
		return this.monedas;
	}

	public void setEstrellas(int estrellasGanadas) {
		estrellas += (-estrellasGanadas > estrellas ? -estrellas : estrellasGanadas);
	}

	public void setMonedas(int monedasGanadas) {
		this.monedas += (-monedasGanadas > this.monedas ? -this.monedas : monedasGanadas);
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
	
}
