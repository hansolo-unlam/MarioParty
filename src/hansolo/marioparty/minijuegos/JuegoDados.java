package hansolo.marioparty.minijuegos;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

import hansolo.marioparty.Juego;

import java.awt.Color;
import java.awt.SystemColor;

public class JuegoDados extends Minijuego implements ActionListener {


	public JTextArea[] txtJugadores = new JTextArea[juego.getJugadores().size()];
	public JButton btnJugar = new JButton("");
	public JLabel[] lblJugadores = new JLabel[juego.getJugadores().size()];
	public JScrollPane[] spnJugadores = new JScrollPane[juego.getJugadores().size()];
	public int NumPartida = 0;

	public JuegoDados(Juego juego) {
		
		super(juego);
		// creación y configuración del jframe
		frame = new JFrame("Juego dados");
		frame.getContentPane().setBackground(new Color(0, 0, 51));
		frame.setSize(400, 200 + juego.getJugadores().size()*100); // ancho,alto
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Que no se pueda modificar el tamaño
		frame.setResizable(false);
		// frame.setLocationRelativeTo(null);

		FlowLayout DISTRIBUIDOR = new FlowLayout(FlowLayout.RIGHT, 50, 20);
		frame.getContentPane().setLayout(DISTRIBUIDOR);
		btnJugar.setBackground(UIManager.getColor("Button.disabledShadow"));
		btnJugar.setIcon(new ImageIcon(JuegoDados.class.getResource("/minijuego/JugarM.png")));
		btnJugar.setSelectedIcon(new ImageIcon(JuegoDados.class.getResource("/minijuego/JugarM.png")));
		btnJugar.setForeground(SystemColor.textHighlightText);

		this.btnJugar.addActionListener(this);
		
		for(int i=0; i<juego.getJugadores().size(); i++) {
			this.txtJugadores[i] = new JTextArea(5, 20);
			this.spnJugadores[i] = new JScrollPane(txtJugadores[i]);
			this.lblJugadores[i] = new JLabel(juego.getJugadores().get(i).getUser().getNombre());
			this.txtJugadores[i].setEditable(false);
			this.txtJugadores[i].setSize(100, 100);
			this.lblJugadores[i].setForeground(new Color(255, 255, 255));
			this.lblJugadores[i].setBackground(new Color(255, 255, 255));
			frame.getContentPane().add(lblJugadores[i]);
			frame.getContentPane().add(spnJugadores[i]);
			
		}

		frame.getContentPane().add(this.btnJugar);
		// frame.add(this.cbxModoJuego);

	}

	@Override
	public void actionPerformed(ActionEvent AE) {
		int[] resultado = new int[juego.getJugadores().size()];

		this.NumPartida++;

		for (int i = 0; i < juego.getJugadores().size(); i++) {
			JOptionPane.showMessageDialog(frame, "TURNO DE " + juego.getJugadores().get(i).getUser().getNombre());
			resultado[i] = TirarDadoJugador(i+1, juego.getJugadores().get(i).getUser().getNombre());

		}
		
		int posiciones[] = new int[juego.getJugadores().size()];
		posiciones[0] = 0;

		for (int i = 1; i < juego.getJugadores().size(); i++) {
			int j = i;
			while(j>0 && resultado[i]>resultado[posiciones[j-1]]){
				posiciones[j] = posiciones[j-1];
				j--;
			}
			posiciones[j] = i;
			
		}
		
		String puesto ="PUESTO N° ";
		int posicion = 1;
		for(int i=0; i<juego.getJugadores().size(); i++) {
			JOptionPane.showMessageDialog(frame, puesto + posicion + ": "+ juego.getJugadores().get(posiciones[i]).getUser().getNombre() + "\n\n TOTAL = " + resultado[posiciones[i]]);
			posicion++;
		}

		frame.setVisible(false);
		juego.premiar(posiciones);
		for(int i=0; i<juego.getJugadores().size(); i++) {
			txtJugadores[i].setText("");
		}


	}

	// --Jugador01 = 1, Jugador02 = 2, Maquina = 3
	public int TirarDadoJugador(int Jugador, String NomJugador) {
		int Dado1, Dado2, SumaDados;

		Dado1 = GenerarAleatorioDado();
		Dado2 = GenerarAleatorioDado();
		SumaDados = Dado1 + Dado2;

		JOptionPane.showMessageDialog(frame, "RESULTADO " + NomJugador + "\n\nDADO 1 : " + Dado1 + "\nDADO 2 : " + Dado2
				+ "\n\n TOTAL SUMAN " + SumaDados);

		switch (Jugador) {
		case 1:
			this.txtJugadores[0].setText(this.txtJugadores[0].getText() + "\nJUEGO: " + this.NumPartida + "\n DADO 1: " + Dado1
					+ "\n DADO 2: " + Dado2 + " \n TOTAL " + SumaDados);
			break;

		case 2:
			this.txtJugadores[1].setText(this.txtJugadores[1].getText() + "\nJUEGO: " + this.NumPartida + "\n DADO 1: " + Dado1
					+ "\n DADO 2: " + Dado2 + " \n TOTAL " + SumaDados);
			break;

		case 3:
			this.txtJugadores[2].setText(this.txtJugadores[2].getText() + "\nJUEGO: " + this.NumPartida + "\n DADO 1: " + Dado1
					+ "\n DADO 2: " + Dado2 + " \n TOTAL " + SumaDados);
			break;

		case 4:
			this.txtJugadores[3].setText(this.txtJugadores[3].getText() + "\nJUEGO: " + this.NumPartida + "\n DADO 1: " + Dado1
					+ "\n DADO 2: " + Dado2 + " \n TOTAL " + SumaDados);
			break;

		}

		return SumaDados;
	}

	public int GenerarAleatorioDado() {
		Random Aleatorio = new Random();
		int Dado;

		Dado = Aleatorio.nextInt(6) + 1;

		return Dado;
	}

	/*
	 * public static void main(String[] ARGUMENTOS) { JuegoDados Dados = new
	 * JuegoDados(); Dados.frame.setVisible(true); }
	 */
}