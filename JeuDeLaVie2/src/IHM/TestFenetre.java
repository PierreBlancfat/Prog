package IHM;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.Thread.State;

import javax.swing.JComponent.AccessibleJComponent;

import Jeu.Grille;
import Jeu.Jeu;
import automatesCellulaires.StructuresPeriodiques;
import automatesCellulaires.StructuresStables;
import automatesCellulaires.StructuresVaisseaux;

public class TestFenetre {
	
	private static int tailleCellule;
	private static Component fenetre;
	private static Grille g;

	
	public static void main(String[] args) throws Exception {
		
	// Paramètres du jeu
	int nbLigne = 40;
	int nbColonnes = 40;
	int tailleCellule = 15;
	
	
	//Implémentation des éléments de jeu
	Grille g = new Grille(nbColonnes,nbLigne);
	Fenetre fenetre = new Fenetre(nbLigne*tailleCellule,nbLigne*tailleCellule,g);
	Jeu jeu = new Jeu(g,fenetre);
	StructuresPeriodiques.galaxie(1,1,g);
	StructuresVaisseaux.glisseur(10, 16, g);
	StructuresVaisseaux.glisseur(10, 22, g);
	StructuresVaisseaux.glisseur(10, 28, g);
	StructuresVaisseaux.glisseur(16, 16, g);
	StructuresVaisseaux.glisseur(16, 22, g);
	StructuresVaisseaux.glisseur(16, 28, g);
	StructuresVaisseaux.glisseur(4, 16, g);
	StructuresVaisseaux.glisseur(4, 22, g);
	StructuresVaisseaux.glisseur(4, 28, g);
	StructuresPeriodiques.horloge(20, 5, g);

	
	
	// Ajout de listenners
	
		//Clic boutton
	fenetre.bouttonStart.addActionListener( new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (jeu.suspended == true){
				jeu.affichage.resume();
				jeu.suspended = false;
			}
			else
				jeu.start();
		}
	});
	
	fenetre.bouttonFermer.addActionListener( new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
			
		}
	});
	
	fenetre.bouttonPause.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
						jeu.affichage.suspend();
						jeu.suspended = true;
	
				}
	});
	
		//Souris PanneauJeu
	fenetre.addMouseListener( new MouseAdapter() {
		
		 public void mousePressed(MouseEvent e){
			 int x = e.getX();
			 int y = e.getY();
			 System.out.println("Coordonnées : "+x+" - "+y);
			 
			 //clic gauche
			 if (e.getButton() == MouseEvent.BUTTON1){
		    	try {
					System.out.println("c'est un clic gauche de souris");
					g.AjoutCellule((x/tailleCellule),(y/tailleCellule));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		      }
			 //clic droit
			 if (e.getButton() == MouseEvent.BUTTON3){
			    	try {
						System.out.println("c'est un clic droit de souris");
						g.SupprimeCellule((x/tailleCellule),(y/tailleCellule));
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			 }
			fenetre.repaint();
		 }
	});
	}
}
