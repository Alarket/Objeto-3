import java.util.Random;
import java.util.concurrent.Semaphore;
public class Passageiro extends Thread{
	
	
	int AndarAtual;
	int num;
    boolean chamada = false;
	public boolean chegou = false;
    int andarDestino;
	

	boolean vivo = true; 
	int posx;
	int posy;
	Random rnd = new Random();
	Elevator elevator;
	boolean running = true;

	private Semaphore semaforo; 

	public Passageiro(int num,int andarAtual,int andarDestino,Semaphore sema) {
	 semaforo = sema;
		
		setNum(num);
	 setAndarAtual( andarAtual);
	 setAndarDestino(andarDestino);
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
		    running = false;
			elevator.sendochan = false;
			}
        
		public void viajando() {}
		
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

		
}