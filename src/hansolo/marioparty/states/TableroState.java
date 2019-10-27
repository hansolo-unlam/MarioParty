package hansolo.marioparty.states;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JOptionPane;

import hansolo.marioparty.Juego;
import hansolo.marioparty.admin.Usuario;
import hansolo.marioparty.entidades.Jugador;
import hansolo.marioparty.graficos.Texturas;
import hansolo.marioparty.tablero.Tablero;
import hansolo.marioparty.ui.AdministradorUI;
import hansolo.marioparty.ui.ClickListener;
import hansolo.marioparty.ui.ImageButton;

public class TableroState extends State {
	private Tablero tablero;
	private Jugador tieneTurno;
	private int ronda = 1;
	String userJugadores; 
	private AdministradorUI administradorUI;

	private EnumEstadoJuego subEstado;

	public TableroState(Juego juego) {
		super(juego);

		tablero = new Tablero("./recursos/map0.txt", juego);
		this.tieneTurno = juego.getJugadores().get(0);
		this.subEstado = EnumEstadoJuego.TIEMPO_DE_ACCIONES;
		administradorUI = new AdministradorUI(juego);
		juego.getMouseManager().settearAdministradorUI(administradorUI);
		this.userJugadores =  tieneTurno.getUser().getNombre();

				
		administradorUI.agregarObjeto("btnTirarDado",
				//new ImageButton(20, 50, 82, 32, Texturas.btnTirarDado, new ClickListener() {
			new ImageButton(800, 525, 150, 160, Texturas.btnTirarDado1, new ClickListener() {

					@Override
					public void onClick() {
						tieneTurno.tirarDado();
						subEstado = EnumEstadoJuego.VIENDO_DADO;

						new java.util.Timer().schedule(new java.util.TimerTask() {
							@Override
							public void run() {
								subEstado = EnumEstadoJuego.MOVIENDOSE;
								tieneTurno.startAvanzar();
							}

						}, 3000);
					}
				}));

		administradorUI.agregarObjeto("btnTerminarTurno",
				//new ImageButton(20, 100, 115, 32, Texturas.btnTerminarTurno, new ClickListener() {
				new ImageButton(800, 525, 150, 160, Texturas.btnTerminarTurno, new ClickListener() {

					@Override
					public void onClick() {
						pasarTurno();
					}

				}));
	}

	@Override
	public void calcular() {
		// acá calculo todo lo que tenga que ir cambiando
		tablero.calcular();
		administradorUI.calcular();

		for (Jugador j : juego.getJugadores())
			j.calcular();

		if (subEstado == EnumEstadoJuego.TIEMPO_DE_ACCIONES) {
			administradorUI.getObjetos().get("btnTirarDado").setHidden(false);
			administradorUI.getObjetos().get("btnTerminarTurno").setHidden(true);

		} else if (subEstado == EnumEstadoJuego.VIENDO_ITEMS) {
			administradorUI.getObjetos().get("btnTirarDado").setHidden(true);
			administradorUI.getObjetos().get("btnTerminarTurno").setHidden(true);

		} else if (subEstado == EnumEstadoJuego.VIENDO_DADO) {
			administradorUI.getObjetos().get("btnTirarDado").setHidden(true);
			administradorUI.getObjetos().get("btnTerminarTurno").setHidden(true);

		} else if (subEstado == EnumEstadoJuego.MOVIENDOSE) {
			administradorUI.getObjetos().get("btnTirarDado").setHidden(true);
			administradorUI.getObjetos().get("btnTerminarTurno").setHidden(true);

		} else if (subEstado == EnumEstadoJuego.FIN_TURNO) {
			administradorUI.getObjetos().get("btnTirarDado").setHidden(true);
			administradorUI.getObjetos().get("btnTerminarTurno").setHidden(false);

		}
	}

	@Override
	public void dibujar(Graphics g) {
		// acá dibujo tablero, jugadores, etc
		String userJugador = tieneTurno.getUser().getNombre();
	
		
		g.setColor(Color.white);
		g.drawString("Le toca jugar a " + userJugador, 20, 15);
		g.drawString("Monedas de " + userJugador + ": " + tieneTurno.getMonedas(), 20, 30);
		g.drawString("Estrellas de " + userJugador + ": " + tieneTurno.getEstrellas(), 20, 45);
		g.drawString("Ronda: " + ronda, 750, 20);

		tablero.predibujar(g);
		tablero.dibujar(g);
		administradorUI.dibujar(g);

		for (Jugador j : juego.getJugadores())
			j.dibujar(g);

		if (subEstado == EnumEstadoJuego.TIEMPO_DE_ACCIONES) {

		} else if (subEstado == EnumEstadoJuego.VIENDO_ITEMS) {

		} else if (subEstado == EnumEstadoJuego.VIENDO_DADO) {
			g.drawString(userJugador + ": sacaste un " + tieneTurno.getCantMovimientos() + " en el dado.", 100, 750);
		} else if (subEstado == EnumEstadoJuego.MOVIENDOSE) {
			g.drawString("a " + userJugador + " le quedan " + tieneTurno.getCantMovimientos() + " movimientos.", 100,
					750);

		}
	}

	public void activarEfectoCasillero() {
		tieneTurno.getPosicion().efecto(tieneTurno, administradorUI);
	}

	public EnumEstadoJuego getSubEstado() {
		return subEstado;
	}

	public void setSubEstado(EnumEstadoJuego subEstado) {
		this.subEstado = subEstado;
	}

	public void pasarTurno() {
		int index = juego.getJugadores().indexOf(tieneTurno);
		index++;
		
		if (index < juego.getJugadores().size())
			tieneTurno = juego.getJugadores().get(index);
		else {
			index = 0;
			tieneTurno = juego.getJugadores().get(0);
			ronda++;
			juego.iniciarMinijuego();
		}
		
		if(tieneTurno.isPierdeTurno()) {
			this.pasarTurno();
		}

		subEstado = EnumEstadoJuego.TIEMPO_DE_ACCIONES;
	}

	public void handleTerminoTurno() {
		subEstado = EnumEstadoJuego.FIN_TURNO;
	}

}
