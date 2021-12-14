import java.awt.Image;
import java.util.concurrent.Semaphore;

import javax.swing.ImageIcon;

public class Predio {
	
	
	    Semaphore semaforo; 
	    int andares;
	    public float x =75 ,y =600;
		private int altura ,largura;
		private Image imagem;
	
		 Passageiro[] passageiro;
		
		public Predio() {
			
	     semaforo = new Semaphore(1);
	    
	     
	     andares = 6;
	     
		passageiro = new Passageiro[3];
	
//                                   (nome,andarAtual,Destino)
		 passageiro[0] = new Passageiro(1,2,5,semaforo);
    	 passageiro[1] = new Passageiro(2,5,3,semaforo);
         passageiro[2] = new Passageiro(3,3,2,semaforo);
//	     passageiro[3] = new Passageiro(4,6,4,semaforo);
///		 passageiro[4] = new Passageiro(5,4,2,semaforo);
	    
	     Elevator elevator = new Elevator(andares,passageiro);
	 	
	    
		
	     passageiro[0].setElevator(elevator);
         passageiro[1].setElevator(elevator);
         passageiro[2].setElevator(elevator);
//	     passageiro[3].setElevator(elevator);
//	     passageiro[4].setElevator(elevator);
     
	     
	     elevator.start();
	     passageiro[0].start();  
         passageiro[1].start();  
         passageiro[2].start();  
//	     passageiro[3].start();  
//         passageiro[4].start();  
	     
	     Janela janela = new Janela(elevator,passageiro,this,andares);
	     
	}
	

		public void load() {
			
			
			ImageIcon referencia = new ImageIcon("res\\Andar.png");
			imagem = referencia.getImage();
			
			altura = imagem.getHeight(null);	
			largura = imagem.getWidth(null);
		
			
		}
		
		public float getX() {
			return x;
		}

		public float getY() {
			return y;
		}
		
		public Image getImagem() {
			return imagem;
		}
}
