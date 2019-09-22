package hansolo.marioparty.utils;

import hansolo.marioparty.tablero.Tablero;
import hansolo.marioparty.tablero.casilleros.BifurcacionCasillero;
import hansolo.marioparty.tablero.casilleros.Casillero;
import hansolo.marioparty.tablero.casilleros.EstrellaCasillero;
import hansolo.marioparty.tablero.casilleros.ItemCasillero;
import hansolo.marioparty.tablero.casilleros.MonedaCasillero;
import hansolo.marioparty.tablero.casilleros.RandomMaloCasillero;
import hansolo.marioparty.tablero.casilleros.TiendaCasillero;

public class LoaderMapa {
	private LeerArchivo archivo;
	private Tablero tablero;

	public LoaderMapa(LeerArchivo l, Tablero tablero) {
		archivo = l;
		this.tablero = tablero;
	}

	public void leerCasilleros() {
		int cantCasillero = archivo.siguienteEntero();

		for (int i = 0; i < cantCasillero; i++) {
			int id = archivo.siguienteEntero();
			char tipoCasillero = archivo.siguienteChar();
			int cantNext = archivo.siguienteEntero();

			int[] next = new int[cantNext];

			for (int j = 0; j < cantNext; j++) {
				next[j] = archivo.siguienteEntero();
			}

			try {
				tablero.getCasilleros().put(id, armarCasillero(tipoCasillero, id, next));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private Casillero armarCasillero(char tipoCasillero, int id, int next[]) throws Exception {

		switch (tipoCasillero) {
		case 'M':
			return new MonedaCasillero(id, next);
		case 'B':
			return new BifurcacionCasillero(id, next);
		case 'T':
			return new TiendaCasillero(id, next);
		case 'I':
			return new ItemCasillero(id, next);
		case 'C':
			return new RandomMaloCasillero(id, next);
		case 'E':
			return new EstrellaCasillero(id, next);
		default:
			throw new Exception("Caracter de tipo de casillero no identificado.");
		}
	}
}
