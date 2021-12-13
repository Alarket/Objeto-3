import javax.swing.JFrame;

public class Janela extends JFrame {

   Fase fase;	
	public Janela(Elevator elevator,Passageiro[] passageiro) {
	
		add(fase = new Fase(elevator,passageiro));
		setTitle("Elevator");
		setSize(500,750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		this.setResizable(false);
		setVisible(true);
	}
	
	
}
