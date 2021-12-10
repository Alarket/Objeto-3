import java.util.concurrent.Semaphore;

public class Elevator extends Thread{

	boolean livre = true;
	boolean aberto = true;
	int numAndar;
	int AndarAtual = 5;
	//Pessoa pessoa;
	int destino;
	
	Passageiro p;
	Passageiro[] pass;
	
	
	Semaphore semaforo;
    boolean sendochan = false;
	

	public Elevator(int numAndar,Semaphore semaforo) {
		//this.setPessoa(pessoa);
	  
	   this.semaforo = semaforo;
	 
	}
	
	@Override
	public void run(){
		while(true)	{	
			
		try {
			sleep((int)(1000.0f));
				}catch(InterruptedException e) {
					
					e.printStackTrace();
				}
		if (sendochan) {
		BuscarPass();
	    AbrirPorta();
	    FecharPorta();
	    LevarPass();
	    FecharPorta();
		}
		}
	
	}

	public void BuscarPass() {
		System.out.println("--elevador esta no andar"+ AndarAtual);
		this.destino = p.getAndarAtual();
		
		if(destino < AndarAtual) {
			while(destino < AndarAtual ) {
			 desce();
			}
		}
		else{
			
			if(destino > AndarAtual) {
				while(destino > AndarAtual ) {
			     sobe();
				}
		    }
		}
		
		System.out.println("--elevador chegou ao andar do passageiro "+ p.getNum());
		
		if(AndarAtual == p.AndarAtual ) {
			p.chegou = true;
			//p.setChegou(isAlive());
				
			}
	}
		
	public void LevarPass() {
		System.out.println("--levar passageiro "+ p.getNum() + " para o andar "+ p.getAndarDestino());
		this.destino = p.getAndarDestino();		
		if(destino < AndarAtual) {
			while(destino < AndarAtual ) {
			desce();
			}
		}
		else{
			
			if(destino > AndarAtual) {
				while(destino > AndarAtual ) {
			  sobe();
				}
		    }
		}
		
		if(AndarAtual == destino) {
			AbrirPorta(); 
			p.PSair();
			p.AndarAtual = destino;
			//p.setChegou(isAlive());
				
			}
	}
	  
	
	 public void sobe() {
		 
			 AndarAtual++;
			System.out.println("--elevador subiu para andar"+ AndarAtual);
			
		 
	   } 
	   
	   public void desce() {
		   
			   AndarAtual--;
				System.out.println("--elevador desceu para andar"+ AndarAtual);
				
			
			
	   }
	
	
	
	public void AbrirPorta() {
		
		System.out.println("--elevador abriu a porta ");
		try {
			sleep((int)(5000.0f));
				}catch(InterruptedException e) {
					
					e.printStackTrace();
				}
				
	}
	
	public void FecharPorta() {
		
		System.out.println("--elevador fechou a porta ");
		
	}
	
	public void VisitarAndar() {
		System.out.println("--elevador abriu a porta ");
		
	}
	
	
	
	  //get e set
	public Passageiro getP() {
		return p;
	}

	public void setP(Passageiro p) {
		this.p = p;
	}
	
	public Passageiro[] getPass() {
		return pass;
	}


//   public Pessoa getPessoa() {
//		return pessoa;
//	}
//
//	public void setPessoa(Pessoa pessoa) {
//		this.pessoa = pessoa;
//	}

}
