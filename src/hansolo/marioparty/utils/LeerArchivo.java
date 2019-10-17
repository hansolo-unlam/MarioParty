package hansolo.marioparty.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

/**
 * Para leer un archivo nomás.
 * @author facundotourn
 *
 */
public class LeerArchivo {
	private String path;
	private Scanner sc;

	public LeerArchivo(String path) throws FileNotFoundException {
		this.path = path;
		sc = new Scanner(new File(this.path));
		sc.useLocale(Locale.ENGLISH);
	}
	
	public String siguientePalabra() {
		return sc.next();
	}

	public double siguienteNumero() {
		return sc.nextDouble();
	}
	
	public int siguienteEntero() {
		return sc.nextInt();
	}
	
	public char siguienteChar() {
		return sc.next().charAt(0);
	}

	public void cerrarLeerArchivo() {
		sc.close();
	}
}
