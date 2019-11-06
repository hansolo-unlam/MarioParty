package hansolo.marioparty.interfaz;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


public class LobbyVentana {

	private JButton btnCrearSala;
	private JFrame frame;
	private JPanel contentPane;

	private JLabel lblJugadores;
	private JLabel lblSalas;
	private JTextPane textPane;


	public LobbyVentana(String nombre) {
		init(nombre);
	}

	private void init(String nombre) {
		frame = new JFrame(nombre);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setSize(600, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		frame.setContentPane(contentPane);
		contentPane.setLayout(null);

		lblJugadores = new JLabel("JUGADORES EN LINEA");
		lblJugadores.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblJugadores.setHorizontalAlignment(SwingConstants.CENTER);
		lblJugadores.setBounds(41, 22, 138, 32);

		contentPane.add(lblJugadores);

		lblSalas = new JLabel("SALAS");
		lblSalas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSalas.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalas.setBounds(300, 22, 138, 32);

		contentPane.add(lblSalas);
		
		textPane = new JTextPane();
		textPane.setBounds(25, 52, 180, 400);
		textPane.setEditable(false);

		contentPane.add(textPane);

		btnCrearSala = new JButton("Crear nueva sala");
		btnCrearSala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = JOptionPane.showInputDialog("Ingresar nombre de la sala");
				Sala sala = new Sala(nombre);
				
				JButton btnSala = new JButton(nombre);
				btnSala.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.out.println("Ingresar a la sala");
						Sala sala2 = new Sala(nombre);
					}
				});
				btnSala.setBounds(220, 60, 120, 30);
				contentPane.add(btnSala);
			}
		});
		btnCrearSala.setBounds(241, 380, 160, 50);
		contentPane.add(btnCrearSala);
	}

	public static void main(String[] args) {
		LobbyVentana lobby = new LobbyVentana("Lobby");
	}

}
