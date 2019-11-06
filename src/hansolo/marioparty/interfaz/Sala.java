package hansolo.marioparty.interfaz;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Sala {

	private JFrame frame;
	private int WIDTH = 410;
	private int HEIGHT = 310;

	private JLabel lblJugadores;
	private JTextPane textPane;
	private JButton btnSalirButton;

	public Sala(String nombre) {
		init(nombre);
	}

	private void init(String nombreSala) {
		frame = new JFrame(nombreSala);
		frame.setResizable(false);
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		frame.setLayout(null);

		lblJugadores = new JLabel("JUGADORES");
		lblJugadores.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblJugadores.setHorizontalAlignment(SwingConstants.CENTER);
		lblJugadores.setBounds(31, 22, 138, 32);
		lblJugadores.setVisible(true);

		frame.add(lblJugadores);

		textPane = new JTextPane();
		textPane.setBounds(41, 52, 138, 198);
		textPane.setEditable(false);

		frame.add(textPane);

		btnSalirButton = new JButton("Salir de la sala");
		btnSalirButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Tocaste salir");
			}
		});
		btnSalirButton.setBounds(241, 182, 120, 23);
		frame.add(btnSalirButton);

		JButton btnComenzarButton = new JButton("Comenzar");
		btnComenzarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Empezar partida");
			}
		});
		btnComenzarButton.setBounds(239, 216, 122, 23);
		frame.add(btnComenzarButton);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		Sala sala = new Sala("SALA 1");
	}
}
