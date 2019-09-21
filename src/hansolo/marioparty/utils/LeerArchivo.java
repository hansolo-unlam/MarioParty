package hansolo.marioparty.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import hansolo.marioparty.entidades.Jugador;
import hansolo.marioparty.tablero.casilleros.Casillero;

public class LeerArchivo {
	private String path;
	private Scanner sc;

	public LeerArchivo(String path) {
		this.path = path;
	}

	public List<Casillero> leerCasilleros() {

		File f_arch = new File(path);
		try {
			sc = new Scanner(f_arch);
		} catch (FileNotFoundException e) {
			System.out.println("No se pudo abrir el archivo" + this.path);
		}

		sc.useLocale(Locale.ENGLISH);
		List<Casillero> casillero = new ArrayList<Casillero>();
		int cantCasillero = sc.nextInt();

		for (int i = 0; i < cantCasillero; i++) {
			int id = sc.nextInt();
			char tipoCasillero = sc.next().charAt(0);
			int siguientes = sc.nextInt();
			int[] next = new int[siguientes];

			for (int j = 0; j < siguientes; j++) {
				next[j] = sc.nextInt();
			}

			comprobarTipodeCasillero(tipoCasillero);

		}

		return casillero;

	}

	private void comprobarTipodeCasillero(char tipoCasillero) {

		switch (tipoCasillero) {

		case 'M':

			break;
		case 'B':

			break;
		case 'T':

			break;
		case 'I':

			break;
		}
	}

	public double siguienteNumero() {
		return sc.nextDouble();
	}

	public void cerrarLeerArchivo() {
		sc.close();
	}
}
