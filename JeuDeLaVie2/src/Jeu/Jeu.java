package Jeu;

import Treads.ThreadAffichage;
import Treads.ThreadCalculs;

public class Jeu extends Thread {

	public Grille grille;
	private String etat;
	private int temps;	
	
	public Jeu(Grille grille){
	
		this.grille = grille;
		temps = 0;
	}
	

	public synchronized void avance() throws Exception{
		
	Grille g = new Grille(this.grille.nbLignes, this.grille.nbColonnes);
    this.grille.copyGrilleDans(g.grille);
		// On parcourt toute la grille
		for ( int i = 0; i < g.nbLignes; i++ ){
			for ( int j = 0; j < g.nbColonnes; j++ ){
				if ( g.estOccupe(i,j))
				{
					if ( g.estIsolee(i, j))
						this.grille.SupprimeCellule(i, j);
					else if ( g.estEtouffee(i, j))
						this.grille.SupprimeCellule(i, j);
					else if ( g.estMaintenue(i, j))
						this.grille.AjoutCellule(i, j);
				}
				else
				{
					if ( g.estReprouctible(i, j))
						this.grille.AjoutCellule(i, j);
				}
			}
		}
		
	}
	
	public synchronized void affiche(){
		this.grille.affiche();
	}
	
	public void run(){
		Thread calc = new ThreadCalculs(this);
		Thread affichage = new ThreadAffichage(this);
		while(true){	
			calc.start();
			affichage.start();

		}
	}
}
