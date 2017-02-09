package automatesCellulaires;
import Jeu.Grille;

/**Classe contenant des méthodes pour insérer des structures stables dans une grille. 
 * 
 * @author Amalik
 *
 */
public class StructuresStables extends Structure{
	

	public static void bloc(int i, int j, Grille g) throws Exception{
		if(i>=0 && j>= 0 && (i+1)<g.getNbLignes() && (j-1)<g.getNbColonnes()){
			ligneHorizontale(i, j, 2, g);
			ligneHorizontale(i+1, j, 2, g);
		}
	}
	
	public static void tube(int i, int j, Grille g) throws Exception{
		if(i>=0 && j>= 0 && (i+2)<g.getNbLignes() && (j+2)<g.getNbColonnes()){
			ligneDiagonale(i, j+1, g, 2, true, true);
			ligneDiagonale(i+1, j, g, 2, true, true);
		}
	}
	
	public static void Bateau(int i, int j, Grille g) throws Exception{
		if(i>=0 && j>= 0 && (i+2)<g.getNbLignes() && (j+2)<g.getNbColonnes()){
			g.AjoutCellule(i, j);
			tube(i,j,g);
		}
	}
	
	public static void Ruche(int i, int j, Grille g) throws Exception{
		if(i>=0 && j>= 0 && (i+3)<g.getNbLignes() && (j+2)<g.getNbColonnes()){
			g.AjoutCellule(i, j+1);
			ligneVerticale(i+1, j, 2, g);
			ligneVerticale(i+1, j+2, 2, g);
			g.AjoutCellule(i+3, j+1);
		}
	}
	
	public static void Hamecon(int i, int j, Grille g) throws Exception{
		if(i>=0 && j>= 0 && (i+3)<g.getNbLignes() && (j+3)<g.getNbColonnes()){
			g.AjoutCellule(i, j);
			ligneVerticale(i, j+1, 3, g);			
			g.AjoutCellule(i+2, j+3);
			ligneHorizontale(i+3, j+2, 2, g);
		}
	}
}
