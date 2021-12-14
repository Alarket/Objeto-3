import java.util.concurrent.Semaphore;

import javax.swing.ImageIcon;
import javax.swing.Timer;

import java.awt.Image;

public class Elevator extends Thread{
	
	// VARIAVEIS DE LOGICA
	int numAndar;
	int AndarAtual = 1;
	int destino;
	
	boolean sendochan = false;
	boolean livre = true;
	boolean aberto = true;
	boolean atalho = false;
	Passageiro[] passageiros;
	Passageiro p;
		
	// VARIAVEIS DE INTERFACE
	private float x  ,y;
	private int altura ,largura;
	private Image imagem;
	private Image imagem2;
    public boolean isfechado = true;
	
    public Elevator(int numAndar,Passageiro[] passageiros) {
		this.passageiros = passageiros;
    	this.numAndar = numAndar;
	    y=600;
	  
	}

	// METODOS DE LOGICA
	@Override
	public void run(){
		while(true)	{	
			
		    Dormir(1);
		    if (sendochan) {	
		   
		    BuscarPass();
	        AbrirPorta();
	        FecharPorta();
	        LevarPass();
	        atalho();
	        
		   }
		}
	
	}
	   public void verificar () {
	    	if (p.AndarAtual >numAndar ) {
	    		System.out.println(" andar: "+p.AndarAtual+"andares:"+numAndar);
	    		 p.getSemaforo().release();
	    		sendochan = false;
	    		 p.running = false;
	    	}else { if (p.andarDestino > numAndar ) {
	    		System.out.println(" elevador ligando.. ");
    		             p.andarDestino = numAndar; 	
    		             sendochan = true;
	                 }
	    	  sendochan = true;
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
			p.AndarAtual = destino;
			p.PSair();
			Dormir(1);			
		}
	}
	  
	
	 public void sobe() {
		 
		 AndarAtual++;
		 update("SUBIR");
		 p.update("SUBIR");
		 System.out.println("--elevador subiu para andar"+ AndarAtual); 
			
		 Dormir(1);
	
	   } 
	   
	   public void desce() {
		   
		 AndarAtual--;
		 update("DESCER");
	     p.update("DESCER");
         System.out.println("--elevador desceu para andar"+ AndarAtual);	
				
		 Dormir(1);
	   }
	
	
	
	public void AbrirPorta() {
		
		System.out.println("--elevador abriu a porta ");
		isfechado = false;
		Dormir(5);
				
	}
	
	public void FecharPorta() {
	
		isfechado=true;
		System.out.println("--elevador fechou a porta ");
		Dormir(3);
	}
	
	public void VisitarAndar() {
		System.out.println("--elevador abriu a porta ");
		
	}
	public void atalho() {
		for(int i=0;i<passageiros.length;i++) {
		      if (AndarAtual == passageiros[i].getAndarAtual() && passageiros[i].running == true) {
		    	  System.out.println("atalho rodando...");
		    	  p.getSemaforo().release();		    	        
		    	  passageiros[i].PChamar();
		    	  atalho = true;
		    	  }
		    	  
		      }
		  if(!atalho) {
			  p.getSemaforo().release();
			  FecharPorta();
		  }
		
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
		ImageIcon referencia = new ImageIcon("res\\Elevador_Aberto.png");
		imagem = referencia.getImage();
		ImageIcon ref = new ImageIcon("res\\Elevador_Fechado.png");
		imagem2 = ref.getImage();
		altura = imagem.getHeight(null);	
		largura = imagem.getWidth(null);
	}
	


	public void update(String opcao) {
		
		switch(opcao) {
		
		case "SUBIR":
			 y-=100;
			break;
		case "DESCER":
			 y+=100;
			break;	
		}		
	}
	 
	  //getters e setters
	public Passageiro getP() {
		return p;
	}

	public void setP(Passageiro p) {
		this.p = p;
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
	
	public Image getImagem2() {
		return imagem2;
	}
}
