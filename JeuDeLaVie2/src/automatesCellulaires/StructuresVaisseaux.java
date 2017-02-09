package automatesCellulaires;
import Jeu.Grille;

public class StructuresVaisseaux extends Structure{

	public static void glisseur(int i, int j, Grille g) throws Exception{
		if(i>=0 && j>=0 && (i+2)<g.getNbLignes() && (j+2)<g.getNbColonnes()){
			ligneDiagonale(i, j+1, g, 2, true, true);
			ligneHorizontale(i+2, j, 3, g);
		}
	}
	
	public static void vaisseauLeger(int i, int j, Grille g) throws Exception{
		if(i>=0 && j>=0 && (i+3)<g.getNbLignes() && (j+4)<g.getNbColonnes()){
			g.AjoutCellule(i, j);
			g.AjoutCellule(i+2, j);
			ligneDiagonale(i, j+3, g, 2, true, true);
			ligneHorizontale(i+3, j+1, 4, g);
			ligneVerticale(i+1, j+4, 3, g);
		}
	}
}
