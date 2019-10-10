package hansolo.marioparty.utils;

import java.util.ArrayList;
import java.util.List;

import hansolo.marioparty.tablero.Casillero;
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
		
		int startX = archivo.siguienteEntero();
		int startY = archivo.siguienteEntero();
		
		List<Casillero> casilleros = new ArrayList<Casillero>();

		for (int i = 0; i < cantCasillero; i++) {
			int id = archivo.siguienteEntero();
			char tipoCasillero = archivo.siguienteChar();

			try {
				casilleros.add(armarCasillero(tipoCasillero, id));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		for (int i = 0; i < cantCasillero; i++) {
			int id = archivo.siguienteEntero();
			
			if (id == 71) {
				System.out.println("test");
			}

			int siguientes = archivo.siguienteEntero();

			for (int j = 0; j < siguientes; j++) {
				String[] word = archivo.siguientePalabra().split(",");
				casilleros.get(i).cardinalidad(casilleros.get(Integer.parseInt(word[0])), word[1].charAt(0));
			}
		}
		
		casilleros.get(0).setX(startX);
		casilleros.get(0).setY(startY);
		
		tablero.setCasilleros(casilleros);
	}

//	public void leerCasilleros1() {
//		int cantCasillero = archivo.siguienteEntero();
//
//		for (int i = 0; i < cantCasillero; i++) {
//			int id = archivo.siguienteEntero();
//			char tipoCasillero = archivo.siguienteChar();
//			int cantNext = archivo.siguienteEntero();
//
//			SiguienteCasillero[] next = new SiguienteCasillero[cantNext];
//
//			for (int j = 0; j < cantNext; j++) {
//				String[] word = archivo.siguientePalabra().split(",");
//				next[j] = new SiguienteCasillero(Integer.parseInt(word[0]), EnumDireccion.valueOf(word[1]));
//			}
//
//			try {
//				tablero.getCasilleros().put(id, armarCasillero(tipoCasillero, id, next));
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//	}

	private Casillero armarCasillero(char tipoCasillero, int id) throws Exception {
		switch (tipoCasillero) {
		case 'B':
			return new BifurcacionCasillero(id);
		case 'T':
			return new TeleportCasillero(id);
		case 'M':
			return new RandomMaloCasillero(id);
		case 'I':
			return new ItemCasillero(id);
		case 'S':
			return new TiendaCasillero(id);
		case 'H':
			return new HurtoCasillero(id);
		case '+':
			return new MonedaCasillero(id, 1);
		case '-':
			return new MonedaCasillero(id, -1);
		case 'A':
			tablero.getIdsCasillerosEstrella().add(id);
			return new EstrellaCasillero(id, tablero);

		default:
			throw new Exception("Caracter de tipo de casillero no identificado.");
		}
	}
}
