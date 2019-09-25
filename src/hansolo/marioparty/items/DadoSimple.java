package hansolo.marioparty.items;

public final class DadoSimple {

	private DadoSimple() {	/* NO PERMITE CREACION DE UN OBJETO DadoSimple */	}

	public static int tirarDado(int maximoNumero) {
		double resultado = (Math.random() * maximoNumero) + 1; 
		System.out.println(resultado);
		return (int) resultado;
	}

}
