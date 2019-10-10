package hansolo.marioparty.tablero.casilleros;

import java.awt.Graphics;

import hansolo.marioparty.entidades.Jugador;
import hansolo.marioparty.tablero.Casillero;
import hansolo.marioparty.tablero.SiguienteCasillero;

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
	public void efecto(Jugador jugador) {
		System.out.println(jugador.getUser().getNombre() + " calló en un casillero de item");
	}

	@Override
	protected void dibujar(Graphics g) {
		// TODO Auto-generated method stub
		
	}

}
