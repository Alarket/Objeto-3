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
	public Predio predio;
	int andares ;
	
	
	public Fase(Elevator elevator,Passageiro[] passageiro,Predio predio,int andares) {
		this.andares = andares;
		this.passageiro = passageiro;
		this.elevator = elevator;
		this.predio = predio;
		
		setFocusable(true);
		setDoubleBuffered(true);
		
		//CARREGANDO IMGS
		ImageIcon referencia = new ImageIcon("res\\Black.png");
		Fundo = referencia.getImage();
	    this.predio.load();
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
		
		for(int i=0;i<andares;i++) {
		graficos.drawImage(predio.getImagem(),(int)predio.getX(),(int)predio.getY()-(i*100),this);
		}
		
		if(!elevator.isfechado)
		graficos.drawImage(elevator.getImagem(),(int)elevator.getX(),(int)elevator.getY(),this);
		
		for(int i=0;i<passageiro.length;i++) {
		graficos.drawImage(passageiro[i].getImagens()[i],(int)passageiro[i].getX(),(int)passageiro[i].getY(),this);
		 }
			
		if(elevator.isfechado)
			graficos.drawImage(elevator.getImagem2(),(int)elevator.getX(),(int)elevator.getY(),this);

		g.dispose();
	}
	@Override
	public void actionPerformed(ActionEvent e) {	
		
			repaint();
	}
}
