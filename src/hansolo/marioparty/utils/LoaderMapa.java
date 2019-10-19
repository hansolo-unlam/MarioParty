package hansolo.marioparty.utils;

import java.util.ArrayList;
import java.util.List;

import hansolo.marioparty.graficos.Texturas;
import hansolo.marioparty.tablero.Casillero;
import hansolo.marioparty.tablero.SiguienteCasillero;
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
		
		// for que arma los casilleros
		for (int i = 0; i < cantCasillero; i++) {
			int id = archivo.siguienteEntero();
			char tipoCasillero = archivo.siguienteChar();

			try {
				casilleros.add(armarCasillero(tipoCasillero, id));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// for que los SiguienteCasilleros a cada casillero
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
		
		// le cargo al casillero 0 sus coordenadas [X, Y]
		casilleros.get(0).setX(startX);
		casilleros.get(0).setY(startY);
		
		// función recursiva que le calcula a cada casillero sus coordenadas [X, Y] relativas a la posición del casillero 0
		calcularPosicion(casilleros.get(0).getSiguiente(), startX, startY);
		
		tablero.setCasilleros(casilleros);
	}

	private void calcularPosicion(SiguienteCasillero current, int xAnterior, int yAnterior) {
		Casillero casilleroActual = current.getCasillero();
		
		// end condition: si la posición casillero está seteado, puedo salir
		if (casilleroActual.getX() != 0) return;
		
		switch (current.getDireccion().toString()) {
		case "N":
			// El anterior está abajo de el actual
			casilleroActual.setX(xAnterior);
			casilleroActual.setY(yAnterior - Texturas.height);
			break;
		case "S":
			// el anterior está arriba de el actual
			casilleroActual.setX(xAnterior);
			casilleroActual.setY(yAnterior + Texturas.height);
			break;
		case "E":
			// el anterior está a la izquierda del actual
			casilleroActual.setX(xAnterior + Texturas.width);
			casilleroActual.setY(yAnterior);
			break;
		case "O":
			// el anterior está a la derecha del actual
			casilleroActual.setX(xAnterior - Texturas.width);
			casilleroActual.setY(yAnterior);
			break;
		}
		
		if (casilleroActual.getNorte() != null) {
			calcularPosicion(casilleroActual.getNorte(), casilleroActual.getX(), casilleroActual.getY());
		}
		
		if (casilleroActual.getSur() != null) {
			calcularPosicion(casilleroActual.getSur(), casilleroActual.getX(), casilleroActual.getY());
		}
		
		if (casilleroActual.getOeste() != null) {
			calcularPosicion(casilleroActual.getOeste(), casilleroActual.getX(), casilleroActual.getY());
		}
		
		if (casilleroActual.getEste() != null) {
			calcularPosicion(casilleroActual.getEste(), casilleroActual.getX(), casilleroActual.getY());
		}
		
		
	}

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
