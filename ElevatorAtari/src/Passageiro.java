import java.awt.Image;
import java.util.Random;
import java.util.concurrent.Semaphore;

import javax.swing.ImageIcon;
public class Passageiro extends Thread{
	
	// VARIAVEIS DE LOGICA
	public int AndarAtual;
    public int andarDestino;	
	public int num;
	
    boolean chamada = false;
	public boolean chegou = false;
    
	boolean vivo = true; 
	int posx;
	int posy;
	Random rnd = new Random();
	Random rd = new Random();
	Elevator elevator;
	public boolean running = true;
    private Semaphore semaforo; 

    //VARIAVEIS DE INTERFACE
    private float x =100 ,y;
	public boolean dentro = false;
	public Image[] imagens;
	
	 
	 //METODOS DE LOGICA
	public Passageiro(int num,int andarAtual,int andarDestino,Semaphore sema) {
		
	imagens = new Image[5];
	 semaforo = sema;
	 setNum(num);
	 setAndarAtual( andarAtual);
	 setAndarDestino(andarDestino);
	 y = 750 -( AndarAtual * 100);
	
	}
	
	
	@Override
     public void run(){
		
	      while(running) {
		      try {
				sleep((int)(rnd.nextFloat()* 2000.0f));
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
			 elevator.verificar();
			 //elevator.sendochan = true;
		 }
		  Dormir(5);	
	}
		
	public void PAtual() {
		
			System.out.println("pessoa"+ num +" estar no andar"+ AndarAtual);
	}
	   
	public void PEntrar(){
			if (chegou) {
			     System.out.println("pessoa "+ num +" entra no elevador");
			     update("ENTRAR");
			     dentro = true;//remover isso
			     chegou = false;
			 Dormir(3);
			}		
	}
		
	


	public void PSair() {
			//semaforo.release();
			System.out.println("--elevador chegou ao andar destino do passageiro "+ getNum());
			System.out.println("pessoa"+ num +" saiu do elevador no andar"+ AndarAtual);
			update("SAIR");
			dentro = false;//remover isso
		    running = false;
			elevator.sendochan = false;
	}
		
	public void Dormir(int sec) {
			
			try {
			         sleep((int)(sec*1000.0f));
		    }catch(InterruptedException e) {
			          e.printStackTrace();
		    }
	}
		
		
		
    // METODOS DE INTERFACE
	public void load() {

			ImageIcon ref1 = new ImageIcon("res\\Passageiro1.png");
         	imagens[0] = ref1.getImage();
         	ImageIcon ref3 = new ImageIcon("res\\Passageiro3.png");
         	imagens[1] = ref3.getImage();
         	ImageIcon ref4 = new ImageIcon("res\\Passageiro4.png");
         	imagens[2] = ref4.getImage();
         	ImageIcon ref5 = new ImageIcon("res\\Passageiro5.png");
         	imagens[3] = ref5.getImage();
         	ImageIcon ref6 = new ImageIcon("res\\Passageiro6.png");
         	imagens[4] = ref6.getImage();
         	
			}

	public void update(String op ) {
			
			switch(op) {
			
			case "ENTRAR":
				x=20;
				break;
            case "SAIR":
            	x=200+ rd.nextInt(10)*20;
				break;
            case "SUBIR":
            	 if(dentro) {
        			   setY(getY()-100);
        			   }
				break;
            case "DESCER":
            	  if(dentro) {
          			   setY(getY()+100);
          			   }
				break;
			}
		}

		// GETTERS E SETTERS DA LOGICA
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
	public Semaphore getSemaforo() {
		return semaforo;
	}

		// GETTERS E SETTERS DA INTERFACE
    public float getX() {
				return x;
	}


	public float getY() {
				return y;
	}


	public void setY(float y) {
				this.y = y;
	}



	public Image[] getImagens() {
				return imagens;
	}
			
}