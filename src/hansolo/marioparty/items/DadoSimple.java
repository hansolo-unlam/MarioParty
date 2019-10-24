package hansolo.marioparty.items;

//import java.util.Random;

public final class DadoSimple {

	private DadoSimple() {	/* NO PERMITE CREACION DE UN OBJETO DadoSimple */	}

	public static int tirar() {
		//Random r = new Random();
		double resultado = (Math.random() * 6) + 1+10;
		return (int) resultado;
	}

}
