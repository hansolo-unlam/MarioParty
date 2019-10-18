package hansolo.marioparty.tablero.casilleros;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import hansolo.marioparty.entidades.Jugador;
import hansolo.marioparty.graficos.Texturas;
import hansolo.marioparty.tablero.Casillero;
import hansolo.marioparty.tablero.SiguienteCasillero;
import hansolo.marioparty.tablero.Tablero;
import hansolo.marioparty.ui.AdministradorUI;

/**
 * Casillero que, al pasar o caer en él, varía su comportamiento dependiendo de
 * si en él se encuentra o no la estrella Si la estrella está en el casillero
 * cuando el jugador pasa o cae, se le pregunta si quiere comprar la estrella
 * por 30 monedas. Si la estrella no está en el casillero, se deja al jugador en
 * la posición siguiente, ahorrándole un movimiento.
 * 
 * @author facundotourn
 *
 */
public class EstrellaCasillero extends Casillero {
	public final static int PRECIO_ESTRELLA = 30;
	private boolean tieneEstrella;
	private Tablero tablero;

	public EstrellaCasillero(int id, Tablero tablero) {
		super(id, true);
		this.tieneEstrella = false;
		this.tablero = tablero;
	}

	public boolean isTieneEstrella() {
		return tieneEstrella;
	}

	public void setTieneEstrella(boolean tieneEstrella) {
		this.tieneEstrella = tieneEstrella;
	}

	@Override
	public void efecto(Jugador jugador, AdministradorUI administradorUI) {
		System.out.println(jugador.getUser().getNombre() + " pasó o calló en un casillero de estrella");

		// si la estrella está acá
		if (tieneEstrella) {
			if (jugador.getMonedas() >= PRECIO_ESTRELLA) {
				if (true) { // Debería fijarse si el jugador decide comprarla
					venderEstrella(jugador);
				}
			} else {
				System.out.println(jugador.getUser().getNombre() + " tiene " + jugador.getMonedas()
						+ " MONEDAS, pero la estrella tiene un precio de " + PRECIO_ESTRELLA + " MONEDAS.");
			}
		// si la estrella no está acá, dejar pasar al jugador sin que cuente este casillero como un movimiento
		} else {
			jugador.setCantMovimientos(jugador.getCantMovimientos() + 1);
		}
	}

	private void venderEstrella(Jugador jugador) {
		jugador.setMonedas(jugador.getMonedas() - PRECIO_ESTRELLA);
		jugador.setEstrellas(jugador.getEstrellas() + 1);
		this.tieneEstrella = false;
		tablero.ubicarEstrella(id);
	}

	@Override
	protected void dibujar(Graphics g) {		
		if (tieneEstrella) {
			g.drawImage(Texturas.casillero_estrella, x, y, null);
		}
		
//		g.setFont(new Font("Calibri", Font.PLAIN, 20));
//		g.drawString(Integer.toString(id), x + 16, y + 16);
		
//		if(tieneEstrella)
//			g.drawImage(Texturas.casillero_estrella, x+8, y+12, null);
	}

}
