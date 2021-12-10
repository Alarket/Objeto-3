import java.util.concurrent.Semaphore;

public class Predio {
	
	
	Semaphore semaforo; 
	
		public Predio() {
			semaforo = new Semaphore(1);
		 Passageiro[] passageiro = new Passageiro[5];
	//                          (id,andarAtual,Destino)
			
		 passageiro[0] = new Passageiro(1,1,6,semaforo);
		 passageiro[1] = new Passageiro(2,4,6,semaforo);
	     passageiro[2] = new Passageiro(3,5,6,semaforo);
	     passageiro[3] = new Passageiro(4,3,6,semaforo);
		 passageiro[4] = new Passageiro(5,2,6,semaforo);
	    
	     Elevator elevator = new Elevator(1,semaforo);
	    
	     passageiro[0].setElevator(elevator);
	     passageiro[1].setElevator(elevator);
	     passageiro[2].setElevator(elevator);
	     
	     
	     elevator.start();
	     passageiro[0].start();  
	     passageiro[1].start();  
	     passageiro[2].start();  
	     passageiro[3].start();  
	     passageiro[4].start();  
	   
	     
	}
}
