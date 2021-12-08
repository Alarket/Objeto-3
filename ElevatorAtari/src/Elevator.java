
public class Elevator extends Thread{

	boolean livre = true;
	boolean aberto = true;
	int numAndar;
	int AndarAtual = 5;
	//Pessoa pessoa;
	int destino;
	
	Passageiro p;
	
	
	
	

	public Elevator(Passageiro p,int numAndar) {
		//this.setPessoa(pessoa);
	   setP(p);
	}
	
	@Override
	public void run(){
		
		if(livre && p.chamada) {
			BuscarPass();
		}
	    AbrirPorta();
	    
//		AbrirPorta(); 
//		FecharPorta();
//		VisitarAndar();
//		AbrirPorta(); 
//		FecharPorta();
	//	PegarPass();
		
	}
	public void BuscarPass() {
		System.out.println("--elevador esta no andar"+ AndarAtual);
		this.destino = p.getAndarAtual();
		
		if(destino < AndarAtual) {
		
			desce();
			
		}
		else{
			
			if(destino > AndarAtual) {
			sobe();
			
		    }
		}
		
		System.out.println("--elevador chegou ao andar do passageiro "+ p.getNum());
		
		if(AndarAtual == p.AndarAtual ) {
			p.chegou = true;
			//p.setChegou(isAlive());
				
			}
	}
		
	
	
	 public void sobe() {
		 while(destino > AndarAtual ) {
			 AndarAtual++;
			System.out.println("--elevador subiu para andar"+ AndarAtual);
			
		 }
	   } 
	   
	   public void desce() {
		   while(destino < AndarAtual ) {
			   AndarAtual--;
				System.out.println("--elevador desceu para andar"+ AndarAtual);
				
			 }
			
	   }
	
	
	
	public void AbrirPorta() {
		
		System.out.println("--elevador abriu a porta ");
	}
	
	public void FecharPorta() {
		
		System.out.println("--elevador fechou a porta ");
		
	}
	
	public void VisitarAndar() {
		System.out.println("--elevador abriu a porta ");
		
	}
	
	
	public void PegarPass() {
		System.out.println("--elevador pegou pessoa"+p.getId());
	}
	  
	  //get e set
	public Passageiro getP() {
		return p;
	}

	public void setP(Passageiro p) {
		this.p = p;
	}

//   public Pessoa getPessoa() {
//		return pessoa;
//	}
//
//	public void setPessoa(Pessoa pessoa) {
//		this.pessoa = pessoa;
//	}

}
