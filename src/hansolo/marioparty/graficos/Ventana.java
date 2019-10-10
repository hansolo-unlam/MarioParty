package hansolo.marioparty.graficos;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Ventana {
	private JFrame frame;
	private Canvas canvas;
	
	private String title;
	private int width, height;
	
	public Ventana(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		
		createDisplay();
	}
	
	public void createDisplay() {
		// creaci�n y configuraci�n del jframe
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Que no se pueda modificar el tama�o
		frame.setResizable(false);
		//frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		// creaci�n y configuraci�n del canvas
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
