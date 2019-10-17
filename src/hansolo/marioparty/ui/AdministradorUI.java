package hansolo.marioparty.ui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hansolo.marioparty.Juego;

public class AdministradorUI {
	private Juego juego;
	private Map<String, ObjetoUI> objetos;
	
	public AdministradorUI(Juego juego) {
		this.juego = juego;
		objetos = new HashMap<String, ObjetoUI>();
	}
	
	public void calcular() {
		for (String k : objetos.keySet())
			objetos.get(k).calcular();
	}
	
	public void dibujar(Graphics g) {
		for (String k : objetos.keySet())
			objetos.get(k).dibujar(g);
	}
	
	public void onMouseMove(MouseEvent e) {
		for (String k : objetos.keySet())
			objetos.get(k).onMouseMove(e);
	}
	
	public void onMouseRelase(MouseEvent e) {
		for (String k : objetos.keySet())
			objetos.get(k).onMouseRelease(e);
	}
	
	public void agregarObjeto(String id, ObjetoUI o) {
		objetos.put(id, o);
	}
	
	public void removerObjeto(String id, ObjetoUI o) {
		objetos.remove(id);
	}

	public Juego getJuego() {
		return juego;
	}

	public void setJuego(Juego juego) {
		this.juego = juego;
	}

	public Map<String, ObjetoUI> getObjetos() {
		return objetos;
	}

	public void setObjetos(Map<String, ObjetoUI> objetos) {
		this.objetos = objetos;
	}
	
	
}
