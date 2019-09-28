package hansolo.marioparty.tablero;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import hansolo.marioparty.tablero.casilleros.EstrellaCasillero;
import hansolo.marioparty.utils.LeerArchivo;
import hansolo.marioparty.utils.LoaderMapa;

public class Tablero {
	private Map<Integer, Casillero> casilleros;
	private List<Integer> idsCasillerosEstrella;

	public Tablero(String path) {
		this.casilleros = new HashMap<Integer, Casillero>();
		cargarCasilleros(path);
		ubicarEstrella(-1);
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
		Random random = new Random();
		int indice = 0;
		
		if (idCasilleroAnterior == -1) {
			// Primer estrella que se ubica
			indice = random.nextInt(this.idsCasillerosEstrella.size()) - 1;
		} else {
			// Ya había otra estrella en el tablero
			while(idsCasillerosEstrella.get(indice) == idCasilleroAnterior) {
				indice = random.nextInt(this.idsCasillerosEstrella.size());
			}
		}
		
		EstrellaCasillero aux;
		for (int i = 0; i < this.idsCasillerosEstrella.size(); i++) {
			aux = (EstrellaCasillero)casilleros.get(idsCasillerosEstrella.get(i));
			
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

	public Map<Integer, Casillero> getCasilleros() {
		return casilleros;
	}

	public void setCasilleros(Map<Integer, Casillero> casilleros) {
		this.casilleros = casilleros;
	}
}
