package IHM;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;
import Jeu.Grille;

public class PanneauJeu extends JPanel{
	
	public Grille grille;

	
	public PanneauJeu (Grille g){
		this.grille = g;
		this.setVisible(true);

	}
	public static void main( String[] argz[]){
		
	}
	
	@Override
	public void paintComponent(Graphics graph){
		int largeur=getWidth()/grille.getNbColonnes();
		int hauteur=getHeight()/grille.getNbLignes();
	    for(int i=0; i<grille.getNbColonnes(); i++){
	    		for(int j=0; j<grille.nbLignes; j++){
	    			
	    			try {
						if(grille.estOccupe(i,j)){
							graph.setColor(Color.YELLOW);
						}
						else
						{
							graph.setColor(Color.BLACK);
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	    			graph.fillRect(i*largeur, j*hauteur, largeur, hauteur);
	    		}
	    }
}


}

