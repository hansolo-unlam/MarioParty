package hansolo.marioparty.states;

import java.awt.Color;
import java.awt.Graphics;

import hansolo.marioparty.Juego;
import hansolo.marioparty.entidades.Jugador;
import hansolo.marioparty.graficos.Texturas;
import hansolo.marioparty.items.DadoSimple;
import hansolo.marioparty.tablero.Tablero;
import hansolo.marioparty.ui.AdministradorUI;
import hansolo.marioparty.ui.ClickListener;
import hansolo.marioparty.ui.ImageButton;

public class JuegoState extends State {
	private Tablero tablero;
	private Jugador tieneTurno;
	
	private AdministradorUI administradorUI;
	
	private EnumEstadoJuego subEstado;
	
	public JuegoState(Juego juego) {
		super(juego);
		
		tablero = new Tablero("./recursos/map0.txt", juego);
		this.tieneTurno = juego.getJugadores().get(0);
		
		this.subEstado = EnumEstadoJuego.TIEMPO_DE_ACCIONES;
		
		administradorUI = new AdministradorUI(juego);
		juego.getMouseManager().settearAdministradorUI(administradorUI);
		
		administradorUI.agregarObjeto("btnTirarDado", new ImageButton(20, 50, 82, 32, Texturas.btnTirarDado, new ClickListener() {
			@Override
			public void onClick() {
				System.out.println("test");
				tieneTurno.setCantMovimientos(DadoSimple.tirar());
				subEstado = EnumEstadoJuego.MOVIENDOSE;
			}
		}));
	}

	@Override
	public void calcular() {
		// ac� calculo todo lo que tenga que ir cambiando
		tablero.calcular();
		administradorUI.calcular();
		
		
		for (Jugador j : juego.getJugadores())
			j.calcular();
		
		if (subEstado == EnumEstadoJuego.TIEMPO_DE_ACCIONES) {
			administradorUI.getObjetos().get("btnTirarDado").setHidden(false);
			
		} else if (subEstado == EnumEstadoJuego.VIENDO_ITEMS) {
			
		} else if (subEstado == EnumEstadoJuego.MOVIENDOSE) {
			administradorUI.getObjetos().get("btnTirarDado").setHidden(true);
			
		}
	}

	@Override
	public void dibujar(Graphics g) {
		// ac� dibujo tablero, jugadores, etc
		String userJugador = tieneTurno.getUser().getNombre();

		g.setColor(Color.white);
		g.drawString("Le toca jugar a " + userJugador, 20, 15);
		g.drawString("Monedas de " + userJugador + ": " + tieneTurno.getMonedas(), 20, 30);
		g.drawString("Estrellas de " + userJugador + ": " + tieneTurno.getEstrellas(), 20, 45);
		
		tablero.dibujar(g);
		administradorUI.dibujar(g);
		
		for (Jugador j : juego.getJugadores())
			j.dibujar(g);
		
		if (subEstado == EnumEstadoJuego.TIEMPO_DE_ACCIONES) {
			
		} else if (subEstado == EnumEstadoJuego.VIENDO_ITEMS) {
			
		} else if (subEstado == EnumEstadoJuego.MOVIENDOSE) {
			g.drawString(userJugador + " sac� un " + tieneTurno.getCantMovimientos() + " del dado.", 100, 750);
			
		}
	}
}
