package hansolo.marioparty.graficos;

import java.awt.image.BufferedImage;

public class HojaSprites {
	private BufferedImage hoja;
	
	public HojaSprites(BufferedImage hoja) {
		this.hoja = hoja;
	}
	
	public BufferedImage recortar(int x, int y, int width, int height) {
		return hoja.getSubimage(x, y, width, height);
	}
}
