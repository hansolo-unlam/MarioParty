package hansolo.marioparty.tablero;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import hansolo.marioparty.utils.LeerArchivo;
import hansolo.marioparty.utils.LoaderMapa;

public class Tablero {
	private Map<Integer, Casillero> casilleros;
	private List<Integer> idsCasillerosEstrella;

	public Tablero(String path) {
		this.casilleros = new HashMap<Integer, Casillero>();
		cargarCasilleros(path);
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
	
	public void ubicarEstrella(int idCasilleroAnterior) {
		int index = idCasilleroAnterior;
		
		while(index == idCasilleroAnterior) {
			Random random = new Random();
			index = random.nextInt(this.idsCasillerosEstrella.size());
			
			this.idsCasillerosEstrella.get(index - 1);
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

	public Map<Integer, Casillero> getCasilleros() {
		return casilleros;
	}

	public void setCasilleros(Map<Integer, Casillero> casilleros) {
		this.casilleros = casilleros;
	}
}
