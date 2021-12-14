import javax.swing.JFrame;

public class Janela extends JFrame {

   Fase fase;	
	public Janela(Elevator elevator,Passageiro[] passageiro,Predio predio,int andares) {
	
		add(fase = new Fase(elevator,passageiro,predio,andares));
		setTitle("Elevator");
		setSize(450,750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		this.setResizable(false);
		setVisible(true);
	}
	
	
}
