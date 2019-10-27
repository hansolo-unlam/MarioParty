package hansolo.marioparty.minijuegos.minijuegoObstaculo;

import java.awt.image.BufferedImage;

public class Animation {
	private int speed, index;
	private BufferedImage[] frames;
	private long lasTime, timer;

	public Animation(int speed, BufferedImage[] frames) {

		this.speed = speed;
		this.frames = frames;
		index = 0;
		timer = 0;
		lasTime = System.currentTimeMillis();

	}

	public void tick() {

		timer += System.currentTimeMillis() - lasTime;
		lasTime = System.currentTimeMillis();

		if (timer > speed) {
			index++;
			timer = 0;
			if (index >= frames.length) {
				index = 0;
			}
		}
	}

	public BufferedImage getCurrentFrame() {
		return frames[index];
	}
}