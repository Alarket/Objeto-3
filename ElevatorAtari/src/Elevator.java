import java.util.concurrent.Semaphore;

import javax.swing.ImageIcon;
import javax.swing.Timer;

import java.awt.Image;

public class Elevator extends Thread{
	
	// variaveis logicas
	boolean sendochan = false;
	boolean livre = true;
	boolean aberto = true;
	int numAndar;
	int AndarAtual = 1;
	int destino;
	Passageiro p;
	Semaphore semaforo;
	
	// variaveis visuais
	private float x  ,y=600;
	private int altura ,largura;
	private Image imagem;

	public Elevator(int numAndar) {
		//this.setPessoa(pessoa);
	  
	  // this.semaforo = semaforo;
	 
	}
	
	
	


	// metodos de logica
	@Override
	public void run(){
		while(true)	{	
			
		try {
			sleep((int)(1000.0f));
				}catch(InterruptedException e) {
					
					e.printStackTrace();
				}
		if (sendochan) {
			//update();
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
						
		}
	}
	  
	
	 public void sobe() {
		 
			 AndarAtual++;
			 y-=100;
			 if(p.dentro) {
			 p.setY(p.getY()-100);
			 }
            //update();
			System.out.println("--elevador subiu para andar"+ AndarAtual); 
			
			try {
				sleep((int)(1000.0f));
					}catch(InterruptedException e) {
						
						e.printStackTrace();
					}
	
	   } 
	   
	   public void desce() {
		   
			   AndarAtual--;
			   y+=100;
			   if(p.dentro) {
			   p.setY(p.getY()+100);
			   }
				System.out.println("--elevador desceu para andar"+ AndarAtual);	
				
				try {
					sleep((int)(1000.0f));
						}catch(InterruptedException e) {
							
							e.printStackTrace();
						}
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
	
	// metodos de visual
	
	public void load() {
		ImageIcon referencia = new ImageIcon("res\\Elevador_Aberto.png");
		imagem = referencia.getImage();
		altura = imagem.getHeight(null);	
		largura = imagem.getWidth(null);
		}
	public void update() {
		
		
		y-=100;
		
	}
	 
	
	
	
	  //get e set
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
	
}
