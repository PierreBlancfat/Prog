package Jeu;
import Treads.ThreadCalculs;
import automatesCellulaires.StructuresPeriodiques;
import automatesCellulaires.StructuresStables;
import automatesCellulaires.StructuresVaisseaux;

public class Test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Grille g = new Grille(40,40);
		Jeu jeu = new Jeu(g);
		StructuresPeriodiques.pentadecathlon(20, 20, g);
		StructuresVaisseaux.glisseur(5, 5, g);
		StructuresStables.Bateau(6, 28, g);
		StructuresStables.Ruche(10, 28, g);
		StructuresVaisseaux.vaisseauLeger(18, 6, g);
		StructuresVaisseaux.vaisseauLeger(24, 6, g);
		StructuresVaisseaux.vaisseauLeger(26, 6, g);
		StructuresVaisseaux.vaisseauLeger(3, 20, g);
		StructuresStables.Bateau(24, 28, g);
		StructuresStables.Ruche(28, 28, g);
		StructuresPeriodiques.galaxie(7, 8, g);
		StructuresPeriodiques.pentadecathlon(13, 33, g);
		StructuresPeriodiques.horloge(22, 25, g);;
		StructuresPeriodiques.horloge(18, 33, g);;
		
		//Lancement du jeu
		jeu.start();

// sans thread
//		int temps = 0;
//		while(true){
//			jeu.affiche();
//			jeu.avance();
//			System.out.println("temps : "+temps++);
//		}
		
		
		

		
	}

}

