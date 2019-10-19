package hansolo.marioparty.graficos;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Ventana {
	private String title;
	private int width, height;
	
	private JFrame frame;
	private Canvas canvas;
	
	public Ventana(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		
		createDisplay();
	}
	
	public void createDisplay() {
		// creación y configuración del jframe
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setResizable(false); 			// que no se pueda modificar el tamaño
		frame.setLocationRelativeTo(null); 	// que se abra en el centro de la pantalla
		frame.setVisible(true); 			// que se pueda ver
		
		// creación y configuración del canvas
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setFocusable(false);
		
		frame.add(canvas);
		frame.pack();
	}
	
	public Canvas getCanvas() {
		return canvas;
	}
	
	public JFrame getFrame() {
		return frame;
	}
}
