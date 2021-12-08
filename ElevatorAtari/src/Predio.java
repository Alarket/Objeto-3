
public class Predio {
	 Passageiro[] passageiro = new Passageiro[1];
		public Predio() {
	   
	  
	     passageiro[0] = new Passageiro(1,1);
	     passageiro[0].start();  
	     Elevator elevator = new Elevator(passageiro[0],1);
	     elevator.start();

	     
	 

	}
}
