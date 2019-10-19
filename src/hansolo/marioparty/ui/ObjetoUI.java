package hansolo.marioparty.ui;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

public abstract class ObjetoUI {
	protected int x, y, width, height;
	protected boolean hover = false, hidden = false;
	
	// los limites que dicen: si el mouse está dentro de estos límites, está parado sobre este botón.
	protected Rectangle limites;
	
	public ObjetoUI(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		limites = new Rectangle(x, y, width, height);
	}
	
	public abstract void calcular();
	public abstract void dibujar(Graphics g);
	public abstract void onClick();
	
	public void onMouseMove(MouseEvent e) {
		// cuando se mueve el mouse, hay que revisar si el mouse está arriba de este ObjetoUI
		if (limites.contains(e.getX(), e.getY())) {
			hover = true;
		} else {
			hover = false;
		}
	}
	
	public void onMouseRelease(MouseEvent e) {
		// cada vez que se hace un release del mouse, significa que dio click
		// si estoy sobre el ObjetoUI (hover == true), ejecuto el método onClick
		if (hover && !hidden)
			onClick();
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public boolean isHover() {
		return hover;
	}

	public void setHover(boolean hover) {
		this.hover = hover;
	}

	public boolean isHidden() {
		return hidden;
	}

	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}
	
	
	
}
