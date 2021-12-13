import java.awt.Image;
import java.util.Random;
import java.util.concurrent.Semaphore;

import javax.swing.ImageIcon;
public class Passageiro extends Thread{
	
	// variaveis logicas
	public int AndarAtual;
    public int andarDestino;	
	public int num;
	
    boolean chamada = false;
	public boolean chegou = false;
    
	boolean vivo = true; 
	int posx;
	int posy;
	Random rnd = new Random();
	Elevator elevator;
	boolean running = true;
    private Semaphore semaforo; 

    //variaveis visuais
    private float x =100 ,y;
	private int altura ,largura;
	private Image imagem;
	public boolean dentro = false;
    
    //metodos de logicas
	public Passageiro(int num,int andarAtual,int andarDestino,Semaphore sema) {
	 semaforo = sema;
		setNum(num);
	 setAndarAtual( andarAtual);
	 setAndarDestino(andarDestino);
	 y = 700 -( AndarAtual * 100);
	}
	
	
	@Override
     public void run(){
		
	 while(running) {
		 try {
				sleep((int)(rnd.nextFloat()* 1000.0f));
					}catch(InterruptedException e) {
						
						e.printStackTrace();
					}
			PAtual();
			PChamar();	
		    PEntrar();
			
	 }
	 }
	 
		public void PChamar() {
			
		 if(semaforo.tryAcquire()) {
			 System.out.println("pessoa"+ num +" chamando elevador...");
			 elevator.setP(this);
			 
			 elevator.sendochan = true;
		 }
		try {
			sleep((int)(rnd.nextFloat()* 6000.0f));
				}catch(InterruptedException e) {
					
					e.printStackTrace();
				}
				
			
		}
		public void PAtual() {
		
			System.out.println("pessoa"+ num +" estar no andar"+ AndarAtual);
		}
		
		public void PDormir() {
			//System.out.println("pessoa"+ id +" esperando...");
			
			try {
			sleep((int)(rnd.nextFloat()* 5000.0f));
			}catch(InterruptedException e) {
				
				e.printStackTrace();
			}
			
		}
	   
		public void PEntrar(){
			if (chegou) {
			System.out.println("pessoa "+ num +" entra no elevador");
			 x=0;
			 dentro = true;
			chegou = false;
			try {
				Thread.sleep((int)( 5000.0f));
				}catch(InterruptedException e) {
				
					e.printStackTrace();
					
				}
			}		
		}
		public void PSair() {
			semaforo.release();
			System.out.println("--elevador chegou ao andar destino do passageiro "+ getNum());
			System.out.println("pessoa"+ num +" saiu do elevador no andar"+ AndarAtual);
			x=100;
			dentro = false;
		    running = false;
			elevator.sendochan = false;
			}
        
       // metodos visuais
		public void load() {
			ImageIcon referencia = new ImageIcon("res\\Pass.png");
			imagem = referencia.getImage();
			altura = imagem.getHeight(null);	
			largura = imagem.getWidth(null);
			}
		
		
		// get e set
		public int getNum() {
			return num;
		}

		public void setNum(int num) {
			this.num = num;
		}
		
		public int getAndarAtual() {
			return AndarAtual;
		}

		public void setAndarAtual(int andarAtual) {
			AndarAtual = andarAtual;
		}
		
		
		public boolean isChegou() {
			return chegou;
		}
		public void setChegou(boolean chegou) {
			this.chegou = chegou;
		}


		public int getAndarDestino() {
			return andarDestino;
		}


		public void setAndarDestino(int andarDestino) {
			this.andarDestino = andarDestino;
		}
		

	     public void setElevator(Elevator elevator) {
			this.elevator = elevator;
		}

		// getset visuais
	     
	     public float getX() {
				return x;
			}


			public float getY() {
				return y;
			}


			public void setY(float y) {
				this.y = y;
			}


			public Image getImagem() {
				return imagem;
			}
	     
	     
}