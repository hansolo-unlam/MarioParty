package hansolo.marioparty.tablero.casilleros;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import hansolo.marioparty.entidades.Jugador;
import hansolo.marioparty.graficos.Texturas;
import hansolo.marioparty.tablero.Casillero;
import hansolo.marioparty.tablero.SiguienteCasillero;

/**
 * Casillero que al caer en �l, te permite pagar para sacarle un item o una
 * estrella a otro jugador
 * 
 * @author facundotourn
 *
 */
public class HurtoCasillero extends Casillero {
	public HurtoCasillero(int id) {
		super(id, false);
	}

	@Override
	public void efecto(Jugador jugador) {
		System.out.println(jugador.getUser().getNombre() + " call� en un casillero de hurto");
	}

	@Override
	protected void dibujar(Graphics g) {
		g.drawImage(Texturas.casillero_hurto, x, y, null);
		
//		g.setFont(new Font("Calibri", Font.PLAIN, 20));
//		g.drawString(Integer.toString(id), x + 16, y + 16);
		
		//g.drawImage(Texturas.casillero_hurto, x+8, y+12, null);
	}

}
