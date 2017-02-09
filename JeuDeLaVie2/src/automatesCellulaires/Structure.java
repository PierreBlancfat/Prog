package automatesCellulaires;
import Jeu.Grille;

/**Classe contenant des méthodes pour former des structures basiques. 
 * 
 * @author Amalik
 */
public abstract class Structure {
	
	/**Ajoute des cellules sur une ligne verticale à partir des coordonnées(i,j)
	 * 
	 * @param i la ligne sur laquelle poser la première cellule. 
	 * @param j la colonne sur laquelle poser la première cellule.
	 * @param length le nombre de cellule de la ligne. 
	 * @param g la grille sur laquelle insérer la ligne. 
	 * @throws Exception 
	 */
	protected static void ligneVerticale(int i, int j, int length, Grille g) throws Exception{
		if(i>=0 && j>= 0 && (i+length)<g.getNbLignes() && j<g.getNbColonnes()){
			for(int a = 0; a<length; a++){
				g.AjoutCellule(i+a, j);
			}
		}
	}
	
	/**Ajoute des cellules sur une ligne horizontale à partir des coordonnées(i,j)
	 * 
	 * @param i la ligne sur laquelle poser la première cellule. 
	 * @param j la colonne sur laquelle poser la première cellule.
	 * @param length le nombre de cellule de la ligne. 
	 * @param g la grille sur laquelle insérer la ligne. 
	 * @throws Exception 
	 */
	protected static void ligneHorizontale(int i, int j, int length, Grille g) throws Exception{
		if(i>=0 && j>= 0 && i<g.getNbLignes() && (j+length)<g.getNbColonnes()){
			for(int a = 0; a<length; a++){
				g.AjoutCellule(i, j+a);
			}
		}
	}
	
	/**Ajoute des cellules sur une diagonale à partir des coordonnées(i,j)
	 * 
	 * @param i la ligne sur laquelle poser la première cellule. 
	 * @param j la colonne sur laquelle poser la première cellule. 
	 * @param length le nombre de cellule de la diagonale. 
	 * @param droite booléen, si true : la diagonale se prolonge vers la droite. sinon elle se prolonge vers la gauche. 
	 * @param bas booléen, si true : la diagonale se prolonge vers le bas. sinon elle se prolonge vers le haut. 
	 * @throws Exception 
	 */
	protected static void ligneDiagonale(int i, int j, Grille g, int length, boolean droite, boolean bas) throws Exception{
		int abs = 1;
		int ord = 1;
		if(!droite)
			ord = -1;
		if(!bas)
			abs = -1;
		if(Math.min(i, i+abs*length)>=0 && Math.min(j, j+ord*length)>= 0 && Math.max(i, i+abs*length)<g.getNbLignes() && Math.max(j, j+ord*length)<g.getNbColonnes()){
			for(int a = 0; a<length; a++)
				g.AjoutCellule(i+abs*a, j+ord*a);
		}
	}
}
