package hansolo.marioparty.tablero.casilleros;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import hansolo.marioparty.entidades.Jugador;
import hansolo.marioparty.graficos.Texturas;
import hansolo.marioparty.tablero.Casillero;
import hansolo.marioparty.tablero.SiguienteCasillero;
import hansolo.marioparty.ui.AdministradorUI;

/**
 * Casillero que le da un item al jugador que cae en él
 * 
 * @author facundotourn
 *
 */
public class ItemCasillero extends Casillero {

	public ItemCasillero(int id) {
		super(id, false);
	}

	@Override
	public void efecto(Jugador jugador, AdministradorUI administradorUI) {
		System.out.println(jugador.getUser().getNombre() + " calló en un casillero de item");
	}

	@Override
	protected void dibujar(Graphics g) {
		g.drawImage(Texturas.casillero_item, x, y, null);
		
//		g.setFont(new Font("Calibri", Font.PLAIN, 20));
//		g.drawString(Integer.toString(id), x + 16, y + 16);
	}

}
