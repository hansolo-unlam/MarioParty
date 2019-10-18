package hansolo.marioparty.tablero;

import java.awt.Graphics;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import hansolo.marioparty.Juego;
import hansolo.marioparty.admin.Usuario;
import hansolo.marioparty.entidades.Jugador;
import hansolo.marioparty.tablero.casilleros.EstrellaCasillero;
import hansolo.marioparty.utils.LeerArchivo;
import hansolo.marioparty.utils.LoaderMapa;

public class Tablero {
	private List<Casillero> casilleros;
	private List<Integer> idsCasillerosEstrella;
	private Juego juego;

	public Tablero(String path, Juego juego) {
		this.juego = juego;
		
		this.casilleros = new ArrayList<Casillero>();
		cargarCasilleros(path);
		ubicarEstrella(-1);
		ubicarJugadores();
	}

	private void ubicarJugadores() {
		for (Jugador j : juego.getJugadores()) {
			j.setX(casilleros.get(0).getX());
			j.setY(casilleros.get(0).getY());
			j.setPosicion(casilleros.get(0));
		}
	}

	public void calcular() {
		
	}
	
	public void predibujar(Graphics g) {
		for (Casillero c : casilleros)
			c.predibujar(g);
	}

	public void dibujar(Graphics g) {
		for (Casillero c : casilleros)
			c.dibujar(g);
	}

	private void cargarCasilleros(String path) {
		this.idsCasillerosEstrella = new ArrayList<Integer>();
		LeerArchivo leer;

		try {
			leer = new LeerArchivo(path);
			LoaderMapa loader = new LoaderMapa(leer, this);

			loader.leerCasilleros();
		} catch (FileNotFoundException e) {
			System.out.println("No se encontró el archivo del mapa");
			e.printStackTrace();
		}
	}

	/**
	 * Método para encontrar una nueva ubicación para la estrella. Básicamente setea
	 * el parámetro .tieneEstrella de los CasillerosEstrella del tablero en false,
	 * salvo uno que queda en true que es donde está la estrella.
	 * 
	 * @param idCasilleroAnterior es el id del casillero estrella donde se
	 *                            encontraba la estrella hasta que se llamó a esta
	 *                            función.
	 */
	public void ubicarEstrella(int idCasilleroAnterior) {
		Random random = new Random();
		int indice = 0;

		if (idCasilleroAnterior == -1) {
			// Primer estrella que se ubica
			indice = random.nextInt(this.idsCasillerosEstrella.size());
		} else {
			// Ya había otra estrella en el tablero
			while (idsCasillerosEstrella.get(indice) == idCasilleroAnterior) {
				indice = random.nextInt(this.idsCasillerosEstrella.size());
			}
		}

		// Actualizo el .tieneEstrella de todos los CasillerosEstrella
		EstrellaCasillero aux;
		for (int i = 0; i < this.idsCasillerosEstrella.size(); i++) {
			aux = (EstrellaCasillero) casilleros.get(idsCasillerosEstrella.get(i));

			if (i == indice) {
				aux.setTieneEstrella(true);
				continue;
			}

			aux.setTieneEstrella(false);
		}
	}

	public Casillero getStart() {
		return casilleros.get(0);
	}

	public List<Integer> getIdsCasillerosEstrella() {
		return idsCasillerosEstrella;
	}

	public void setIdsCasillerosEstrella(List<Integer> idsCasillerosEstrella) {
		this.idsCasillerosEstrella = idsCasillerosEstrella;
	}

	public List<Casillero> getCasilleros() {
		return casilleros;
	}

	public void setCasilleros(List<Casillero> casilleros) {
		this.casilleros = casilleros;
	}
}
