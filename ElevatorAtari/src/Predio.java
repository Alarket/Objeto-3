import java.util.concurrent.Semaphore;

public class Predio {
	
	
	Semaphore semaforo; 
	
		public Predio() {
		
			semaforo = new Semaphore(1);
		 Passageiro[] passageiro = new Passageiro[2];
	//                          (id,andarAtual,Destino)
			
		 passageiro[0] = new Passageiro(1,3,6,semaforo);
		 passageiro[1] = new Passageiro(2,1,5,semaforo);
//	     passageiro[2] = new Passageiro(3,4,6,semaforo,300);
//	     passageiro[3] = new Passageiro(4,5,4,semaforo,400);
//		 passageiro[4] = new Passageiro(5,1,2,semaforo,500);
//	    
	     Elevator elevator = new Elevator(1);
	 	
	    
		
	     passageiro[0].setElevator(elevator);
         passageiro[1].setElevator(elevator);
//	     passageiro[2].setElevator(elevator);
//	     passageiro[3].setElevator(elevator);
//	     passageiro[4].setElevator(elevator);
//	     
	     
	     elevator.start();
	     passageiro[0].start();  
         passageiro[1].start();  
//	     passageiro[2].start();  
//	     passageiro[3].start();  
//	     passageiro[4].start();  
//	     
	     Janela janela = new Janela(elevator,passageiro);
	     
	}
}
