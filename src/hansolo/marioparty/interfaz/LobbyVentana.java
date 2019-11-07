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

	private final int WIDHT = 140;
	private final int HEIGHT = 30;
	private int desplazamiento = HEIGHT;
	private int desplazamientoX = 0;

	private JButton btnCrearSala;
	private JFrame frame;
	private JPanel contentPane;

	private JLabel lblJugadores;
	private JLabel lblSalas;
	private JTextPane textPane;

	private int cantSalas = 0;

	public LobbyVentana(String nombre) {
		init(nombre);
	}

	private void init(String nombre) {
		frame = new JFrame(nombre);
		frame.setResizable(false);
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
				cantSalas++;
				if((cantSalas-1)%7==0)
					desplazamiento = 0;
				if (cantSalas > 7) {
					desplazamientoX = WIDHT*((cantSalas-1)/7) + 30;
				}
				if(cantSalas ==14)
					btnCrearSala.setEnabled(false);
				textPane.setText(cantSalas + "\n");

				btnSala.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.out.println("Ingresar a la sala");
						Sala sala2 = new Sala(nombre);

						// 7
					}
				});

				btnSala.setBounds(240 + desplazamientoX, 60 + desplazamiento, WIDHT, HEIGHT);
				desplazamiento += HEIGHT + 10;
				contentPane.add(btnSala);
				frame.repaint();
			}

		});

		btnCrearSala.setBounds(241, 380, 160, 50);
		contentPane.add(btnCrearSala);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		LobbyVentana lobby = new LobbyVentana("Lobby");
	}

}
