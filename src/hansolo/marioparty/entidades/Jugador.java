package hansolo.marioparty.entidades;

import hansolo.marioparty.Partida;
import hansolo.marioparty.admin.Usuario;
import hansolo.marioparty.items.Item;
import hansolo.marioparty.tablero.casilleros.Casillero;

public class Jugador {

	private Usuario user;
	private int monedas, orden, estrellas;
	private boolean turnoJugado;
	private Casillero posicion;
	private Item[] items;

	private Partida partida;

	public Jugador(Usuario user, Casillero start, Partida partida) {
		this.user = user;
		this.monedas = this.estrellas = 0;
		this.turnoJugado = false;
		this.posicion = start;

		this.partida = partida;
	}

	public void tirarDado() {
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

	public void avanzar(int cant) throws Exception {
		for (int i = 1; i < cant; i++) {
			if (this.posicion.getNext().length == 1) {
				// No estoy en una bifurcacion
				int idCasilleroSiguiente = this.posicion.getNext()[0];
				this.posicion = partida.getTablero().getCasilleros().get(idCasilleroSiguiente);

				if (this.posicion.isEfectoPasandoSobre())
					this.posicion.efecto(this);
			} else {
				// Es bifurcación, andá a saber que hacemos
				throw new Exception("En desarrollo");
			}
		}
		this.posicion.efecto(this);
	}

	public void terminarTurno() {
		this.turnoJugado = true;
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
}
