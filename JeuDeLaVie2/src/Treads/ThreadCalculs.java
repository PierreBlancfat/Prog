package Treads;
import Jeu.*;


public class ThreadCalculs extends Thread {

	private Jeu j;

	public ThreadCalculs(Jeu j){
		this.j= j;
	}
	
	public  void run(){
		try{
			while(!interrupted())
				{
					j.avance();
					sleep(50);
					System.out.println("calculs fini");
		}       }
		catch( InterruptedException e){
			
		} catch (Exception e) {
			System.out.println("Calcul interrompu");
		}  
	} 
}
	
