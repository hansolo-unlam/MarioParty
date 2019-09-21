package hansolo.marioparty.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class LeerArchivo {
	private String path;
	private Scanner sc;
	
	public LeerArchivo(String path) throws FileNotFoundException {
		this.path = path;
		sc = new Scanner(new File(this.path));
		sc.useLocale(Locale.ENGLISH);
	}
	
	public double siguienteNumero() {
		return sc.nextDouble();
	}
	
	public void cerrarLeerArchivo() {
		sc.close();
	}
}
