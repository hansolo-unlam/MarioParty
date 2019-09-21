package hansolo.marioparty.tablero;

// casillero que, al caer en él, te da o te quita una cierta cantidad de monedas (+3 o -3)
public class MonedaCasillero extends Casillero {
	private int cantMonedas; // positivo o negativo

	public MonedaCasillero(Casillero[] next, int cantMonedas) {
		super(next);
		this.cantMonedas = cantMonedas;
		// TODO Auto-generated constructor stub
	}

}
