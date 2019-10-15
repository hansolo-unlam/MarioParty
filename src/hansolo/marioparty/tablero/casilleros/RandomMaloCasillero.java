package hansolo.marioparty.tablero.casilleros;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import hansolo.marioparty.entidades.Jugador;
import hansolo.marioparty.graficos.Texturas;
import hansolo.marioparty.tablero.Casillero;
import hansolo.marioparty.tablero.SiguienteCasillero;

/**
 * Casillero que le hace algo malo al jugador que cae en �l
 * 
 * @author facundotourn
 *
 */
public class RandomMaloCasillero extends Casillero {

	public RandomMaloCasillero(int id) {
		super(id, false);
	}

	@Override
	public void efecto(Jugador jugador) {
		System.out.println(jugador.getUser().getNombre() + " call� en un casillero malo");
	}

	@Override
	protected void dibujar(Graphics g) {
		g.setColor(Color.orange);
		g.fillRect(x, y, Texturas.width, Texturas.height);
		
		g.setColor(Color.black);
		g.drawRect(x, y, Texturas.width, Texturas.height);
		
		g.setFont(new Font("Calibri", Font.PLAIN, 20));
		g.drawString(Integer.toString(id), x + 16, y + 16);
		
		g.drawImage(Texturas.casillero_random_malo, x+8, y+12, null);
		
	}

}
