package hansolo.marioparty.tablero.casilleros;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import hansolo.marioparty.entidades.Jugador;
import hansolo.marioparty.graficos.Texturas;
import hansolo.marioparty.tablero.Casillero;
import hansolo.marioparty.tablero.SiguienteCasillero;

/**
 * Casillero que, si pag�s una cantidad de monedas, te lleva a la posici�n de
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
		System.out.println(jugador.getUser().getNombre() + " call� en un casillero para teletransportar");
	}

	@Override
	protected void dibujar(Graphics g) {
		if (x != 0 && y != 0) {
			g.setColor(Color.white);
			g.fillRect(x, y, Texturas.width, Texturas.height);
			
			g.setColor(Color.black);
			g.drawRect(x, y, Texturas.width, Texturas.height);
			
			g.setFont(new Font("Calibri", Font.PLAIN, 20));
			g.drawString(Integer.toString(id), x + 16, y + 16);
		}
	}

}
