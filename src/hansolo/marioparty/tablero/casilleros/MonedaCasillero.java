package hansolo.marioparty.tablero.casilleros;

import java.awt.Font;
import java.awt.Graphics;

import hansolo.marioparty.entidades.Jugador;
import hansolo.marioparty.tablero.Casillero;
import hansolo.marioparty.tablero.SiguienteCasillero;

/**
 * Casillero que, al caer en él, te da o te quita una cierta cantidad de monedas
 * (+3 o -3)
 * 
 * @author facundotourn
 *
 */
public class MonedaCasillero extends Casillero {
	private int cantMonedas; // positivo o negativo

	public MonedaCasillero(int id, int signo) {
		super(id, false);
		this.cantMonedas = 3 * signo;
	}

	@Override
	public void efecto(Jugador jugador) {
		System.out.println(jugador.getUser().getNombre() + " calló en un casillero de monedas");

		jugador.setMonedas(jugador.getMonedas() + this.cantMonedas);
	}

	public int getMoneda() {
		return this.cantMonedas;
	}

	@Override
	protected void dibujar(Graphics g) {
		// TODO Auto-generated method stub
		if (x != 0 && y != 0) {
			g.drawRect(x, y, 32, 32);
			g.setFont(new Font("Calibri", Font.PLAIN, 20));
			g.drawString(Integer.toString(id), x + 16, y + 16);
		}
	}

}
