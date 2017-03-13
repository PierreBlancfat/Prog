package IHM;
import Plateau.Plateau;

public class ThreadAnimation extends Thread {
	
	
	// Tant que le jeton de la colonne peux descendre, on le descend
	// attend ensuite 0.1 secondes
	public void run(int colone, Fenetre f){
		int l = f.p.nbColonnes-1;
			while(!interrupted())
				{
				f.update(f.getGraphics());
				l--;
					try {
						if(f.p.descendJeton(l,colone) == false )
						{	
							this.interrupt();
							return;
						}
						sleep(70);
					} catch (Exception e) {
						e.printStackTrace();
					}
					f.repaint();
		}   
		
	}
	
	

}
