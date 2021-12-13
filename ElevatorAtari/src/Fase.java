import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.util.concurrent.Semaphore;
import java.awt.event.ActionEvent;


public class Fase extends JPanel implements ActionListener{

	public Image Fundo;
	private Timer timer;
	
	public Elevator elevator;
	public Passageiro[] passageiro; 
	
	Semaphore semaforo;
	
	public Fase(Elevator elevator,Passageiro[] passageiro) {
		this.passageiro = passageiro;
		this.elevator = elevator;
		setFocusable(true);
		setDoubleBuffered(true);
		
		ImageIcon referencia = new ImageIcon("res\\Black.png");
		Fundo = referencia.getImage();
		
		//passageiro = new Passageiro(1,1,1,semaforo);
	
		 this.elevator.load();
		 for(int i=0;i< passageiro.length;i++) {
         
			 passageiro[i].load();
			 
		 }
			timer = new Timer(5, this);
			timer.start();
	}
	
	public void paint(Graphics g) {
		Graphics2D graficos = (Graphics2D) g;
		
		graficos.drawImage(Fundo,0,0,null);
		graficos.drawImage(elevator.getImagem(),(int)elevator.getX(),(int)elevator.getY(),this);
		
		for(int i=0;i<passageiro.length;i++) {
			System.out.println("pessoa"+ passageiro[i].num+"posicao y: "+passageiro[i].getY());
		graficos.drawImage(passageiro[i].getImagem(),(int)passageiro[i].getX(),(int)passageiro[i].getY(),this);
		
		 }
		
		g.dispose();
	}
	@Override
	public void actionPerformed(ActionEvent e) {	
			repaint();
	}
}
