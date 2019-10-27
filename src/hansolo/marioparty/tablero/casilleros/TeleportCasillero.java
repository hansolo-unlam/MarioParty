package hansolo.marioparty.tablero.casilleros;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import hansolo.marioparty.entidades.Jugador;
import hansolo.marioparty.graficos.Texturas;
import hansolo.marioparty.tablero.Casillero;
import hansolo.marioparty.tablero.SiguienteCasillero;
import hansolo.marioparty.ui.AdministradorUI;
import hansolo.marioparty.ui.ClickListener;
import hansolo.marioparty.ui.ImageButton;

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
	public void efecto(Jugador jugador, AdministradorUI administradorUI) {
		List<Jugador> jugadores = jugador.getJuego().getJugadores();
		dibujarBotones(jugador, administradorUI, jugadores);
		// System.out.println(jugador.getUser().getNombre() + " calló en un casillero
		// para teletransportar");
	}

	private void dibujarBotones(Jugador jugador, AdministradorUI administradorUI, List<Jugador> jugadores) {
		JFrame frame = new JFrame();
		JOptionPane.showMessageDialog(frame, "Selecciona un oponente para teletransportarte a su posición");
		for (int i = 0; i < jugadores.size(); i++) {
			Jugador moverseHacia = jugadores.get(i);
			String btn = "btn" + i;
			administradorUI.agregarObjeto(btn, new ImageButton(moverseHacia.getX(), moverseHacia.getY(), Texturas.width,
					Texturas.height, Texturas.flecha_arriba, new ClickListener() {
						@Override
						public void onClick() {
							Casillero c = moverseHacia.getPosicion();
							jugador.setPosicion(c);
							jugador.setX(c.getX());
							jugador.setY(c.getY());
							eliminarBotones(administradorUI, jugadores, jugador);
						}
					}));
		}
	}

	private void eliminarBotones(AdministradorUI administradorUI, List<Jugador> jugadores, Jugador jugador) {
		for (int i = 0; i < jugadores.size(); i++)
			if (jugadores.get(i) != jugador) {
				administradorUI.removerObjeto("btn" + i);
			}
	}

	@Override
	protected void dibujar(Graphics g) {
		g.drawImage(Texturas.casillero_TP, x, y, null);

//		g.setFont(new Font("Calibri", Font.PLAIN, 20));
//		g.drawString(Integer.toString(id), x + 16, y + 16);

		// g.drawImage(Texturas.casillero_TP, x+8, y+12, null);
	}

}
