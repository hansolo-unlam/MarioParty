package hansolo.marioparty.minijuegos;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;
import java.awt.Color;
import java.awt.SystemColor;
 
 
public class JuegoDados implements ActionListener
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JTextArea txtJugador1 = new JTextArea(5,20);
    public JTextArea txtJugador2 = new JTextArea(5,20);
	public JTextArea txtJugador3 = new JTextArea(5,20);
    public JTextArea txtJugador4 = new JTextArea(5,20);
    public JComboBox cbxModoJuego = new JComboBox();
    public JButton btnJugar = new JButton(""); 
    public JLabel lblJugador1 = new JLabel("JUGADOR 1");
    public JLabel lblJugador2 = new JLabel("JUGADOR 2");
    public JScrollPane spnJugador1 = new JScrollPane(txtJugador1);
    public JScrollPane spnJugador2 = new JScrollPane(txtJugador2);
    public JLabel lblJugador3 = new JLabel("JUGADOR 3");
    public JLabel lblJugador4 = new JLabel("JUGADOR 4");
    public JScrollPane spnJugador3 = new JScrollPane(txtJugador3);
    public JScrollPane spnJugador4 = new JScrollPane(txtJugador4);
    public int NumPartida = 0;
    private JFrame frame;
 
    public JuegoDados()
    {
    	
    	//creación y configuración del jframe
    			frame = new JFrame("Juego dados");
    			frame.getContentPane().setBackground(new Color(0, 0, 51));
    			frame.setSize(400, 800); // ancho,alto
    			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    			
    			// Que no se pueda modificar el tamaño
    			frame.setResizable(false);
    			//frame.setLocationRelativeTo(null);
    			frame.setVisible(true);
  	
    	
        FlowLayout DISTRIBUIDOR = new FlowLayout(FlowLayout.RIGHT,50,20);
        frame.getContentPane().setLayout(DISTRIBUIDOR);
        btnJugar.setBackground(UIManager.getColor("Button.disabledShadow"));
        btnJugar.setIcon(new ImageIcon(JuegoDados.class.getResource("/minijuego/JugarM.png")));
        btnJugar.setSelectedIcon(new ImageIcon(JuegoDados.class.getResource("/minijuego/JugarM.png")));
        btnJugar.setForeground(SystemColor.textHighlightText);
         
        this.btnJugar.addActionListener(this);
        this.txtJugador1.setEditable(false);
        this.txtJugador2.setEditable(false);
        this.txtJugador3.setEditable(false);
        this.txtJugador4.setEditable(false);
        
         
        this.txtJugador1.setSize(100,100);
        lblJugador1.setForeground(new Color(255, 255, 255));
        lblJugador1.setBackground(new Color(255, 255, 255));
        
        frame.getContentPane().add(this.lblJugador1);
        frame.getContentPane().add(this.spnJugador1);
        lblJugador2.setForeground(new Color(255, 255, 255));
        frame.getContentPane().add(this.lblJugador2);
        frame.getContentPane().add(this.spnJugador2);
        lblJugador3.setForeground(new Color(255, 255, 255));
        frame.getContentPane().add(this.lblJugador3);
        frame.getContentPane().add(this.spnJugador3);
        lblJugador4.setForeground(new Color(255, 255, 255));
        frame.getContentPane().add(this.lblJugador4);
        frame.getContentPane().add(this.spnJugador4);
         frame.getContentPane().add(this.btnJugar);
       // frame.add(this.cbxModoJuego);
       
        
    }
 
    @Override
    public void actionPerformed(ActionEvent AE) 
    {       
        int [] resultado = new int[5];
         
        this.NumPartida++;
 
        for(int i=1;i<5;i++)
        {
            JOptionPane.showMessageDialog(frame,"TURNO DE JUGADOR"+i );
            resultado[i] = TirarDadoJugador(i,"JUGADOR" + i);
              
        }
       
            int b=0;
            int maximo=0;
            int indiceMax=0;
            for(int i=1;i<5;i++)
            {
            	 if(b==0)
                 {
            		 b=1;
                 	maximo=resultado[i];
                 	indiceMax=i;
                 }
                 else
                 {
                 	if(resultado[i]>maximo)
                 	{
                 		maximo=resultado[i];
                     	indiceMax=i;
                 	}
                 }
            }
           
            JOptionPane.showMessageDialog(frame,"GANO EL JUGADOR"+ indiceMax+ "\n\n TOTAL = " + resultado[indiceMax]);


  
    }
     
    //--Jugador01 = 1, Jugador02 = 2, Maquina = 3
    public int TirarDadoJugador(int Jugador,String NomJugador)
    {
        int Dado1,Dado2,SumaDados;        
         
        Dado1 = GenerarAleatorioDado();
        Dado2 = GenerarAleatorioDado();
        SumaDados = Dado1 + Dado2;
             
        JOptionPane.showMessageDialog(frame,"RESULTADO " + NomJugador
                                         + "\n\nDADO 1 : " + Dado1 + "\nDADO 2 : " + Dado2
                                         + "\n\n TOTAL SUMAN " + SumaDados);
         
        switch(Jugador)
        {
            case 1: this.txtJugador1.setText(this.txtJugador1.getText() + "\nJUEGO: "
                                            + this.NumPartida 
                                            + "\n DADO 1: " + Dado1 + "\n DADO 2: " + Dado2
                                            +" \n TOTAL " + SumaDados );break;
                 
            case 2: this.txtJugador2.setText(this.txtJugador2.getText() + "\nJUEGO: "
                    + this.NumPartida 
                    + "\n DADO 1: " + Dado1 + "\n DADO 2: " + Dado2
                    +" \n TOTAL " + SumaDados );break;
                 
            case 3: this.txtJugador3.setText(this.txtJugador3.getText() + "\nJUEGO: "
                    + this.NumPartida 
                    + "\n DADO 1: " + Dado1 + "\n DADO 2: " + Dado2
                    +" \n TOTAL " + SumaDados );break;
                                            
            case 4: this.txtJugador4.setText(this.txtJugador4.getText() + "\nJUEGO: "
                    + this.NumPartida 
                    + "\n DADO 1: " + Dado1 + "\n DADO 2: " + Dado2
                    +" \n TOTAL " + SumaDados );break;
                                          
        }
         
        return SumaDados;
    }
    public int GenerarAleatorioDado()
    {
        Random Aleatorio = new Random();
        int Dado;
         
        Dado = Aleatorio.nextInt(6)+1;
         
        return Dado;
    }
     
    public static void main(String[] ARGUMENTOS)
    {
        JuegoDados Dados = new JuegoDados();
        Dados.frame.setVisible(true);
    }
}