package IHM;
import Plateau.Plateau;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Test {

	public static void main( String[] argz) throws Exception{
		
		// Initialisation Plateau
		int nbColonnes = 7;
		int nbLignes  = 6;
		Plateau p = new Plateau(nbLignes,nbColonnes);
		// Initialisation fénètre graphique
		Fenetre fen = new Fenetre(nbColonnes*70, nbLignes*70,p );
		p.joueur  = 1;
		
		//écouteur souris
		fen.addMouseListener( new MouseAdapter() {
			
			 public void mousePressed(MouseEvent e){
				 int x = e.getX();
				 int y = e.getY();
				 System.out.println("Coordonnées : "+x+" - "+y);
				 
				 //clic gauche
				 if (e.getButton() == MouseEvent.BUTTON1){
				 
					 for (int i = 1; i< p.nbColonnes+1; i++){
						 if ( x <= i*(fen.getWidth()/p.nbColonnes)){
							 try {
								fen.joue(nbColonnes-1-(i-1));
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							 break;
						 }
					 }
					 
				 }
			 }
		});
		
		
		//Grille de départ
		p.imprime();
	}
}
