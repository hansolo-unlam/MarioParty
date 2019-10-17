package hansolo.marioparty.states;

/**
 * TIEMPO_DE_ACCIONES: 
 * 	estado inicial del turno del jugador.
 * 	único estado en el que el jugador puede tirarDado, verDados o verItems.
 * 	puede pasar a VIENDO_ITEMS para ver y usar uno de sus items.
 * 	puede pasar a VIENDO_DADO tirando el dado.
 * 
 * VIENDO_ITEMS:
 * 	estado en el que el jugador puede elegir usar uno de los items que tiene.
 * 	se cancele o se use un item, se volverá a TIEMPO_DE_ACCIONES.
 * 
 * VIENDO_DADO:
 * 	estado temporal que dura solo 3 segundos.
 * 	un estado en el que se muestra el resultado del dado recién tirado.
 * 	pasados tres segundos, pasa a MOVIENDOSE
 * 
 * MOVIENDOSE:
 * 	estado en el que el jugador está avanzando por el tablero
 * 	no puede tirarDado, verDados o verItems.
 * 
 * FIN_TURNO:
 * 	estado final de un turno, el jugador no tiene otra opción más que terminar el turno
 * 	cuando termina el turno pasa a TIEMPO_DE_ACCIONES del siguiente jugador
 * 
 * @author facundotourn
 *
 */
public enum EnumEstadoJuego {
	TIEMPO_DE_ACCIONES, VIENDO_DADO, VIENDO_ITEMS, MOVIENDOSE, FIN_TURNO 
}
