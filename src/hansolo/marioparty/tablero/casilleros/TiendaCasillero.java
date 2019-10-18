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
 * Casillero que, cuando un jugador cae en él, le permite comprar un item de una
 * lista de items a cambio de una cantidad de monedas, dependiendo del item.
 * 
 * @author facundotourn
 *
 */
public class TiendaCasillero extends Casillero {

	public TiendaCasillero(int id) {
		super(id, true);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void efecto(Jugador jugador, AdministradorUI administradorUI) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void dibujar(Graphics g) {
		g.drawImage(Texturas.casillero_tienda, x, y, null);
		
//		g.setFont(new Font("Calibri", Font.PLAIN, 20));
//		g.drawString(Integer.toString(id), x + 16, y + 16);
	}

}
