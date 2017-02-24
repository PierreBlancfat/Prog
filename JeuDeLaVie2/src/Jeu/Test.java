package Jeu;
import Treads.ThreadCalculs;
import automatesCellulaires.StructuresPeriodiques;
import automatesCellulaires.StructuresStables;
import automatesCellulaires.StructuresVaisseaux;

public class Test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Grille g = new Grille(20,20);
		//Jeu jeu = new Jeu(g);
		StructuresPeriodiques.galaxie(1,1, g);


//		//Lancement du jeu
		//jeu.start();
		g.affiche();
		System.out.println(g.nbVoisins(7,5));
 //sans thread
//		int temps = 0;
//		while(true){
//			jeu.affiche();
//			jeu.avance();
//			System.out.println("temps : "+temps++);
//		}
		
		
		

		
	}

}

