import java.util.Random;
public class Passageiro extends Thread{
	
	
	int AndarAtual;
	int num;
    boolean chamada = false;
	public boolean chegou = false;

	

	boolean vivo = true; 
	int posx;
	int posy;
   // private Pessoa pessoa;
	Random rnd = new Random();
	Elevator elevator;
	



	public Passageiro(int num,int andarAtual) {
	 setNum(num);
	 setAndarAtual( andarAtual);
	 setElevator(elevator);
	}
	
	
	@Override
     public void run(){
	
//			PDormir();
			PAtual();
			PChamar();
		
			System.out.println(chegou);
				
	
		    PEntrar();
		    System.out.println(chegou);
//			PSair();
//			PAtual();
	
	 }
	 
		public void PChamar() {
			System.out.println("pessoa"+ num +" chamando elevador...");
			chamada = true;
			try {
				sleep((int)(rnd.nextFloat()* 10000.0f);
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
			sleep((int)(rnd.nextFloat()* 9000.0f));
			}catch(InterruptedException e) {
				
				e.printStackTrace();
			}
			
		}
	   
		public void PEntrar(){
			System.out.println("pessoa"+ num +"entra no elevador");
		}
		public void PSair() {
		//	System.out.println("pessoa"+ id +" saindo do elevador");
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
		
		
		public Elevator getElevator() {
			return elevator;
		}

		public void setElevator(Elevator elevator) {
			this.elevator = elevator;
		}
		
		
		public boolean isChegou() {
			return chegou;
		}
		public void setChegou(boolean chegou) {
			this.chegou = chegou;
		}
}