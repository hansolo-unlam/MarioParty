package hansolo.marioparty.tablero.casilleros;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import hansolo.marioparty.entidades.Jugador;
import hansolo.marioparty.graficos.Texturas;
import hansolo.marioparty.tablero.Casillero;
import hansolo.marioparty.tablero.SiguienteCasillero;

/**
 * Casillero que, si pagás una cantidad de monedas, te lleva a la posición de
 * otro jugador
 * 
 * @author facundotourn
 *
 */
public class TeleportCasillero extends Casillero {

	public TeleportCasillero(int id) {
		super(id, false);
	}

	@Override
	public void efecto(Jugador jugador) {
		System.out.println(jugador.getUser().getNombre() + " calló en un casillero para teletransportar");
	}

	@Override
	protected void dibujar(Graphics g) {
		g.drawImage(Texturas.casillero_TP, x, y, null);
		
//		g.setFont(new Font("Calibri", Font.PLAIN, 20));
//		g.drawString(Integer.toString(id), x + 16, y + 16);
		
		//g.drawImage(Texturas.casillero_TP, x+8, y+12, null);
	}

}
