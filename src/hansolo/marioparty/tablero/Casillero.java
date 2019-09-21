package hansolo.marioparty.tablero;

public abstract class Casillero {
	private Casillero[] next;
	
	public Casillero(Casillero[] next) {
		this.next = next;
	}
}
