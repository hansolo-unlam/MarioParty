package hansolo.marioparty.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class ImageButton extends ObjetoUI {
	private BufferedImage[] imagenes;
	private ClickListener clicker;

	public ImageButton(int x, int y, int width, int height, BufferedImage[] imagenes, ClickListener clicker) {
		super(x, y, width, height);
		this.imagenes = imagenes;
		this.clicker = clicker;
	}
 
	@Override
	public void calcular() {}

	@Override
	public void dibujar(Graphics g) {
		if (hidden)
			return;
		
		if (hover)
			g.drawImage(imagenes[1], x, y, width, height, null);
		else
			g.drawImage(imagenes[0], x, y, width, height, null);
			
	}

	@Override
	public void onClick() {
		clicker.onClick();
	}

}
