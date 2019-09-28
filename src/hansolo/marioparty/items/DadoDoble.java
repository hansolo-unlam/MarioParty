package hansolo.marioparty.items;

import hansolo.marioparty.entidades.Jugador;

public class DadoDoble extends Item {

	public static final int PRECIO = 3; // EN MODO PUBLICO PARA LOS TEST
	
	public DadoDoble(int cantidad) {
		super("Dado Doble", PRECIO , cantidad);

	}

	@Override
	public void usar(Jugador jugador) {
		if(jugador.getMonedas() < PRECIO || this.getCantidad() < 1) {
			System.out.println("El jugador " + jugador.getUser().getNombre() + " no puede usar este item");
			return;
		}
		
		jugador.setMonedas( jugador.getMonedas()  - PRECIO );
		this.setCantidad( this.getCantidad() - 1 );

		jugador.tirarDado();
		//jugador.avanzar(); COMENTADO PARA PODER HACER LOS TEST
		System.out.println("Dado Doble usado!");
	}
	
	

}
