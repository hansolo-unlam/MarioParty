package hansolo.marioparty.utils;

import hansolo.marioparty.tablero.Tablero;
import hansolo.marioparty.tablero.casilleros.*;

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
		case 'B':
			return new BifurcacionCasillero(id, next);
		case 'T':
			return new TeleportCasillero(id, next);
		case 'M':
			return new RandomMaloCasillero(id, next);
		case 'I':
			return new ItemCasillero(id, next);
		case 'S':
			return new TiendaCasillero(id, next);
		case 'H':
			return new HurtoCasillero(id, next);
		case '+':
			return new MonedaCasillero(id, next, 1);
		case '-':
			return new MonedaCasillero(id, next, -1);
		case 'A':
			return new EstrellaCasillero(id, next);
		default:
			throw new Exception("Caracter de tipo de casillero no identificado.");
		}
	}
}
