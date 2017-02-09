package automatesCellulaires;
import Jeu.Grille;

/**Classe contenant des méthodes pour insérer des structures périodiques dans une grille. 
 * 
 * @author Amalik
 *
 */
public class StructuresPeriodiques extends Structure{

	public static void horloge(int i, int j, Grille g) throws Exception{
		if(i>=0 && j>=0 && (i+11)<g.getNbLignes() && (j+11)<g.getNbColonnes()){
			StructuresStables.bloc(i+4, j, g);
			StructuresStables.bloc(i, j+6, g);
			StructuresStables.bloc(i+10, j+4, g);
			StructuresStables.bloc(i+6, j+10, g);
			ligneVerticale(i+4, j+3, 4, g);
			ligneVerticale(i+4, j+8, 4, g);
			ligneHorizontale(i+3, j+4, 4, g);
			ligneHorizontale(i+8, j+4, 4, g);
			g.AjoutCellule(i+5, j+4);
			g.AjoutCellule(i+6, j+5);
			g.AjoutCellule(i+6, j+6);
		}else{
			System.out.println("il n'y a pas assez d'espace pour insérer cette Structure");
		}
	}
	public static void pentadecathlon(int i, int j, Grille g) throws Exception{
		if(i>=0 && j>= 0 && (i+8)<g.getNbLignes() && (j+15)<g.getNbColonnes()){
			j = j+3;
			ligneVerticale(i+3, j, 3, g);
			ligneVerticale(i+3, j+9, 3, g);
			ligneHorizontale(i, j+4, 2, g);
			ligneHorizontale(i+8, j+4, 2, g);
			ligneDiagonale(i+2, j+1, g, 2, true, false);
			ligneDiagonale(i+6, j+1, g, 2, true, true);
			ligneDiagonale(i+6, j+8, g, 2, false, true);
			ligneDiagonale(i+2, j+8, g, 2, false, false);
		}else{
			System.out.println("il n'y a pas assez d'espace pour insérer cette Structure");
		}
	}
	
	public static void galaxie(int i, int j, Grille g) throws Exception{
		if(i>=0 && j>= 0 && (i+14)<g.getNbLignes() && (j+15)<g.getNbColonnes()){
			i = i+3;
			j = j+3;
			ligneVerticale(i, j, 6, g);
			ligneVerticale(i, j+1, 6, g);
			ligneVerticale(i+3, j+7, 6, g);
			ligneVerticale(i+3, j+8, 6, g);
			ligneHorizontale(i, j+3, 6, g);
			ligneHorizontale(i+1, j+3, 6, g);
			ligneHorizontale(i+7, j, 6, g);
			ligneHorizontale(i+8, j, 6, g);
		}else{
			System.out.println("il n'y a pas assez d'espace pour insérer cette Structure");
		}
	}
}
