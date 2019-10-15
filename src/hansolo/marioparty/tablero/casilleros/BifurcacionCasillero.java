package hansolo.marioparty.tablero.casilleros;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;
import hansolo.marioparty.entidades.Jugador;
import hansolo.marioparty.graficos.Texturas;
import hansolo.marioparty.tablero.Casillero;
import hansolo.marioparty.tablero.SiguienteCasillero;

/**
 * Casillero que, cuando pasas o ca�s, te pregunta a cual de los next quer�s
 * moverte
 * 
 * @author facundotourn
 *
 */
public class BifurcacionCasillero extends Casillero {
	private Random r;

	public BifurcacionCasillero(int id) {
		super(id, true);
	}

	/**
	 * El efecto de la bifurcaci�n consiste en confirmar en qu� direcci�n quiere
	 * avanzar el jugador y moverlo al casillero siguiente. De esta forma, el
	 * jugador nunca va a terminar un turno parado sobre una bifurcaci�n.
	 */
	@Override
	public void efecto(Jugador jugador) {
		System.out.println(jugador.getUser().getNombre() + " pas� por una bifurcaci�n");

		seleccionarNext(0);
		// jugador.avanzarAlSiguienteCasillero();
	}

	/**
	 * Setea los boolean de seleccionado de los SiguienteCasillero del array
	 * 'siguientes' para que quede en true unicamente el seleccionado por el
	 * usuario. TEMPORALMENTE SE ELIGE UN VALOR ALEATORIO, IGNORANDO EL ID QUE SE
	 * RECIBE COMO PAR�METRO. DEBER�A SER UN M�TODO DEL CASILLERO.
	 * 
	 * @param id del Casillero seleccionado
	 */

	private void seleccionarNext(int id) {
		SiguienteCasillero[] opciones = this.getSiguientes();
		id = opciones[r.nextInt(opciones.length)].getCasillero().getId();

		for (int i = 0; i < opciones.length; i++) {
			if (opciones[i].getCasillero().getId() == id)
				opciones[i].setSeleccionado(true);
			else
				opciones[i].setSeleccionado(false);
		}
		this.setSiguientes(opciones);
	}

	@Override
	protected void dibujar(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, Texturas.width, Texturas.height);
		
		g.setColor(Color.black);
		g.drawRect(x, y, Texturas.width, Texturas.height);
		
		g.setFont(new Font("Calibri", Font.PLAIN, 20));
		g.drawString(Integer.toString(id), x + 16, y + 16);
	}
}
