package hansolo.marioparty.tablero.casilleros;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

import hansolo.marioparty.entidades.Jugador;
import hansolo.marioparty.graficos.Texturas;
import hansolo.marioparty.tablero.Casillero;
import hansolo.marioparty.tablero.SiguienteCasillero;
import hansolo.marioparty.ui.AdministradorUI;

/**
 * Casillero que le hace algo malo al jugador que cae en �l
 * 
 * @author facundotourn
 *
 */
public class RandomMaloCasillero extends Casillero {

	public RandomMaloCasillero(int id) {
		super(id, false);
	}

	@Override
	public void efecto(Jugador jugador, AdministradorUI administradorUI) {
		Random random = new Random();
		int indice = random.nextInt(8);
		
		switch (indice) {
		case 0:
			jugador.setMonedas((int)(jugador.getMonedas()*0.9));
			break;
			
		case 1:
			jugador.setMonedas((int)(jugador.getMonedas()*0.8));
			break;
			
		case 2:
			jugador.setMonedas((int)(jugador.getMonedas()*0.7));
			break;
		
		case 3:
			jugador.setMonedas((int)(jugador.getMonedas()*0.9));
			break;
			
		case 4:
			jugador.setMonedas((int)(jugador.getMonedas()*0.8));
			break;
			
		case 5:
			jugador.setMonedas((int)(jugador.getMonedas()*0.7));
			break;
		
		case 6:
			if(jugador.getEstrellas()>0)
				jugador.setEstrellas(jugador.getEstrellas()-1);
			break;
		
		case 7:	
			jugador.setPierdeTurno(true);
		}
		System.out.println(jugador.getUser().getNombre() + " call� en un casillero malo");
	}

	@Override
	protected void dibujar(Graphics g) {
		g.drawImage(Texturas.casillero_random_malo, x, y, null);
		
//		g.setFont(new Font("Calibri", Font.PLAIN, 20));
//		g.drawString(Integer.toString(id), x + 16, y + 16);
		
		//g.drawImage(Texturas.casillero_random_malo, x+8, y+12, null);
		
	}

}
