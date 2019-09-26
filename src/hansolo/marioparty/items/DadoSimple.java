package hansolo.marioparty.items;

public final class DadoSimple {

	private DadoSimple() {	/* NO PERMITE CREACION DE UN OBJETO DadoSimple */	}

	public static int tirar() {
		double resultado = (Math.random() * 6) + 1;
		return (int) resultado;
	}

}
