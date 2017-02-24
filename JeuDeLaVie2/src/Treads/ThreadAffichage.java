package Treads;
import Jeu.*;


public class ThreadAffichage extends Thread{
	private static int temps;
	private Jeu j;

	public ThreadAffichage(Jeu j){
		this.j= j;
	}
	
	public  void run(){
		while(!interrupted())
		{
				j.afficheConsole();
				temps++;
				System.out.println("Temps : "+temps);	
		}
		
		
	}
	
}
