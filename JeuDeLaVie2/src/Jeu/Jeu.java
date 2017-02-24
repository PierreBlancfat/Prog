package Jeu;
import Treads.ThreadAffichage;
import Treads.ThreadCalculs;
import java.awt.Button;
import java.awt.event.ActionListener;

import IHM.Fenetre;

public class Jeu extends Thread {

	public Grille grille;
	public Fenetre fenetre;
	public Thread calc = new ThreadCalculs(this);
	public Thread affichage = new ThreadAffichage(this);	
	private String etat;
	private int temps;	
	public boolean suspended = false;
	
	public Jeu(Grille grille, Fenetre fenetre){
	
		this.grille = grille;
		this.fenetre = fenetre;
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
		wait();
	}
	
	public void afficheConsole(){
		this.grille.affiche();
	}
	
	public synchronized void affiche() throws InterruptedException{
		this.fenetre.repaint();
		notifyAll();
	}
	
	
	public void run(){
		calc.start();
		affichage.start();
	}

	

}
