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
 * Casillero que al caer en él, te permite pagar para sacarle un item o una
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
	public void efecto(Jugador jugador, AdministradorUI administradorUI) {
		List<Jugador> jugadores = jugador.getJuego().getJugadores();

		dibujarBotones(jugador, administradorUI, jugadores);

//		for(int i=0; i<jugadores.size();i++)
//			if(jugadores.get(i)!=jugador)
//				System.out.println(jugadores.get(i).getUser().getNombre());
		// System.out.println(jugador.getUser().getNombre() + " calló en un casillero de
		// hurto");
	}

	private void dibujarBotones(Jugador jugador, AdministradorUI administradorUI, List<Jugador> jugadores) {
		JFrame frame = new JFrame();
		JOptionPane.showMessageDialog(frame, "Selecciona un oponente para robarle hasta 5 monedas");
		for (int i = 0; i < jugadores.size(); i++)

			if (jugadores.get(i) != jugador) {
				Jugador jugadorARobar = jugadores.get(i);
				String btn = "btn" + i;

				switch (i) {

				case 0:
					administradorUI.agregarObjeto(btn,
							new ImageButton(720, 78, 235, 36, Texturas.botonHurto, new ClickListener() {
								@Override
								public void onClick() {
									if (jugadorARobar.getMonedas() >= 5) {
										jugadorARobar.setMonedas(jugadorARobar.getMonedas() - 5);
										jugador.setMonedas(jugador.getMonedas() + 5);
									} else {
										jugador.setMonedas(jugador.getMonedas() + jugadorARobar.getMonedas());
										jugadorARobar.setMonedas(0);
									}

									JOptionPane.showMessageDialog(frame,
											"Le robaste a: " + jugadorARobar.getUser().getNombre());
									eliminarBotones(administradorUI, jugadores, jugador);
									jugador.setAvanzando(true);

								}
							}));
					// fin case 0
					break;

				case 1:

					administradorUI.agregarObjeto(btn,
							new ImageButton(720, 146, 235, 36, Texturas.botonHurto, new ClickListener() {
								@Override
								public void onClick() {
									if (jugadorARobar.getMonedas() >= 5) {
										jugadorARobar.setMonedas(jugadorARobar.getMonedas() - 5);
										jugador.setMonedas(jugador.getMonedas() + 5);
									} else {
										jugador.setMonedas(jugador.getMonedas() + jugadorARobar.getMonedas());
										jugadorARobar.setMonedas(0);
									}
									JOptionPane.showMessageDialog(frame,
											"Le robaste a: " + jugadorARobar.getUser().getNombre());
									eliminarBotones(administradorUI, jugadores, jugador);
									jugador.setAvanzando(true);

								}
							}));
					// fin case 1
					break;

				case 2:

					administradorUI.agregarObjeto(btn,
							new ImageButton(720, 214, 235, 36, Texturas.botonHurto, new ClickListener() {
								@Override
								public void onClick() {
									if (jugadorARobar.getMonedas() >= 5) {
										jugadorARobar.setMonedas(jugadorARobar.getMonedas() - 5);
										jugador.setMonedas(jugador.getMonedas() + 5);
									} else {
										jugador.setMonedas(jugador.getMonedas() + jugadorARobar.getMonedas());
										jugadorARobar.setMonedas(0);
									}
									JOptionPane.showMessageDialog(frame,
											"Le robaste a: " + jugadorARobar.getUser().getNombre());
									eliminarBotones(administradorUI, jugadores, jugador);
									jugador.setAvanzando(true);

								}
							}));
					// fin case 2
					break;

				case 3:

					administradorUI.agregarObjeto(btn,
							new ImageButton(720, 280, 235, 36, Texturas.botonHurto, new ClickListener() {
								@Override
								public void onClick() {
									if (jugadorARobar.getMonedas() >= 5) {
										jugadorARobar.setMonedas(jugadorARobar.getMonedas() - 5);
										jugador.setMonedas(jugador.getMonedas() + 5);
									} else {
										jugador.setMonedas(jugador.getMonedas() + jugadorARobar.getMonedas());
										jugadorARobar.setMonedas(0);
									}
									JOptionPane.showMessageDialog(frame,
											"Le robaste a: " + jugadorARobar.getUser().getNombre());
									eliminarBotones(administradorUI, jugadores, jugador);
									jugador.setAvanzando(true);

								}
							}));
					// fin case3
					break;
				}// llave switch

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
		g.drawImage(Texturas.casillero_hurto, x, y, null);

//		g.setFont(new Font("Calibri", Font.PLAIN, 20));
//		g.drawString(Integer.toString(id), x + 16, y + 16);

		// g.drawImage(Texturas.casillero_hurto, x+8, y+12, null);
	}

}
