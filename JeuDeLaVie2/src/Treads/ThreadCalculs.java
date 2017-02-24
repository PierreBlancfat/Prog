package Treads;
import Jeu.*;


public class ThreadCalculs extends Thread {

	private Jeu j;

	public ThreadCalculs(Jeu j){
		this.j= j;
	}
	
	public  void run(){
			while(!interrupted())
				{
					try {
						j.avance();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("calculs fini");
		}        
	} 
}
	
