package hansolo.marioparty.tablero.casilleros;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import hansolo.marioparty.entidades.Jugador;
import hansolo.marioparty.graficos.Texturas;
import hansolo.marioparty.tablero.Casillero;
import hansolo.marioparty.tablero.SiguienteCasillero;
import hansolo.marioparty.ui.AdministradorUI;
import hansolo.marioparty.ui.ClickListener;
import hansolo.marioparty.ui.ImageButton;

/**
 * Casillero que, cuando pasas o caés, te pregunta a cual de los next querés
 * moverte
 * 
 * @author facundotourn
 *
 */
public class BifurcacionCasillero extends Casillero {
	private Random r;
	private boolean dibujarBotones = false;

	public BifurcacionCasillero(int id) {
		super(id, true);
		r = new Random();
	}

	/**
	 * El efecto de la bifurcación consiste en confirmar en qué dirección quiere
	 * avanzar el jugador y moverlo al casillero siguiente. De esta forma, el
	 * jugador nunca va a terminar un turno parado sobre una bifurcación.
	 */
	@Override
	public void efecto(Jugador jugador, AdministradorUI administradorUI) {
		jugador.setCantMovimientos(jugador.getCantMovimientos() + 1);
		jugador.setAvanzando(false);
		
		dibujarBotones(jugador, administradorUI);
		
		
//		System.out.println(jugador.getUser().getNombre() + " pasó por una bifurcación");
//
//		seleccionarNext(0);
//		jugador.setCantMovimientos(jugador.getCantMovimientos() + 1);
		// jugador.avanzarAlSiguienteCasillero();
	}
	
	public void dibujarBotones(Jugador jugador, AdministradorUI administradorUI) {
		if (norte != null) {
			Casillero c = norte.getCasillero();
			administradorUI.agregarObjeto("btnIrArriba", new ImageButton(c.getX(), c.getY(), Texturas.width, Texturas.height, Texturas.flecha_arriba, new ClickListener() {

				@Override
				public void onClick() {
					jugador.setPosicion(c);
					jugador.setAvanzando(true);
					eliminarBotones(administradorUI);
				}
				
			}));
		}
		if (sur != null) {
			Casillero c = sur.getCasillero();
			administradorUI.agregarObjeto("btnIrAbajo", new ImageButton(c.getX(), c.getY(), Texturas.width, Texturas.height, Texturas.flecha_abajo, new ClickListener() {

				@Override
				public void onClick() {
					jugador.setPosicion(c);
					jugador.setAvanzando(true);
					eliminarBotones(administradorUI);
				}
				
			}));
		}
		if (oeste != null) {
			Casillero c = oeste.getCasillero();
			administradorUI.agregarObjeto("btnIrIzquierda", new ImageButton(c.getX(), c.getY(), Texturas.width, Texturas.height, Texturas.flecha_izquierda, new ClickListener() {

				@Override
				public void onClick() {
					jugador.setPosicion(c);
					jugador.setAvanzando(true);
					eliminarBotones(administradorUI);
				}
				
			}));

		}
		if (este != null) {
			Casillero c = este.getCasillero();
			administradorUI.agregarObjeto("btnIrDerecha", new ImageButton(c.getX(), c.getY(), Texturas.width, Texturas.height, Texturas.flecha_derecha, new ClickListener() {

				@Override
				public void onClick() {
					jugador.setPosicion(c);
					jugador.setAvanzando(true);
					eliminarBotones(administradorUI);
				}
				
			}));
		}
	}
	
	private void eliminarBotones(AdministradorUI administradorUI) {
		administradorUI.removerObjeto("btnIrArriba");
		administradorUI.removerObjeto("btnIrAbajo");
		administradorUI.removerObjeto("btnIrIzquierda");
		administradorUI.removerObjeto("btnIrDerecha");
	}

	/**
	 * Setea los boolean de seleccionado de los SiguienteCasillero del array
	 * 'siguientes' para que quede en true unicamente el seleccionado por el
	 * usuario. TEMPORALMENTE SE ELIGE UN VALOR ALEATORIO, IGNORANDO EL ID QUE SE
	 * RECIBE COMO PARÁMETRO. DEBERÍA SER UN MÉTODO DEL CASILLERO.
	 * 
	 * @param id del Casillero seleccionado
	 */

	private void seleccionarNext(int id) {
		ArrayList<SiguienteCasillero> opciones = this.getSiguientes();
		//id = opciones.get(r.nextInt(opciones.size())).getCasillero().getId();

		for (int i = 0; i < opciones.size(); i++) {
			if (opciones.get(i).getCasillero().getId() == id)
				opciones.get(i).setSeleccionado(true);
			else
				opciones.get(i).setSeleccionado(false);
		}
	}

	@Override
	protected void dibujar(Graphics g) {
//		g.setFont(new Font("Calibri", Font.PLAIN, 20));
//		g.drawString(Integer.toString(id), x + 16, y + 16);
	}
	
	
}
