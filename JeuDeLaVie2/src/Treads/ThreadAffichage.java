package Treads;
import Jeu.*;


public class ThreadAffichage extends Thread{
	private static int temps;
	private Jeu j;

	public ThreadAffichage(Jeu j){
		this.j= j;
	}
	
	public void run(){
		while(!interrupted())
		{
				try {
					j.affiche();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
				try {
					sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				temps++;
				System.out.println("Temps : "+temps);
		}
		
		
	}
	
}
