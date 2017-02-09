
public class Grille {
	
	public int nbLignes;
	public int nbColonnes;
	private boolean[][] grille; 
	
	public Grille(int nbLignes,int nbColonnes) throws Exception {
		if ( nbLignes >= 2 && nbColonnes >= 2 ){
			this.nbLignes = nbLignes;
			this.nbColonnes = nbColonnes;
			grille = new boolean[this.nbLignes][this.nbColonnes];
			for ( int i  = 0; i < nbLignes; i++){
				for ( int j = 0; j < nbColonnes; j++){
				 this.grille[i][j]= false;
				}
			}


		}
		else{
			throw new Exception(" Impossible de créer une grille avec 0 ou moins de colonnes, ou de lignes");
		}
		
	}
	// TODO voir si une cellule est dajà présente
	public void AjoutCellule(int numeroLigne, int numeroColonne) throws Exception{
		if( numeroLigne > 0 && numeroLigne <= this.nbLignes &&  numeroLigne > 0 && numeroLigne <= this.nbColonnes){
			grille[numeroLigne][numeroColonne] = true; 
		}
		else
		{
			throw new Exception("La case demandé est en dehors de la grille");
			
		}
	}
	
	//TODO voir si la case demandé est déjà vide
	public void SupprimeCellule(int numeroLigne, int numeroColonne) throws Exception{
		if( numeroLigne > 0 && numeroLigne <= this.nbLignes &&  numeroLigne > 0 && numeroLigne <= this.nbColonnes){
			grille[numeroLigne][numeroColonne] = false; 
		}
		else
		{
			throw new Exception("La case demandé est en dehors de la grille");
			
		}
	}
	
	
	public void affiche(){

		for (int j = 0; j < this.nbColonnes; j++ ){
			for( int i = 0; i < this.nbLignes; i++){
				if ( grille[j][i] == true)
				System.out.print("0");
				else 
				System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public boolean estOccupe(int ligne, int colonne) throws Exception{
		if ( estDansLaGrille(ligne, colonne)){
				if (grille[ligne][colonne] == true)
					return true;
				else
					return false;
		}
		else 
			throw new Exception("La case demandé est en dehors de la grille");
	}
	
	
	public int nbVoisins(int ligne, int colonne) throws Exception{
		int nbVoisin = 0;
		if ( estDansLaGrille(ligne, colonne))
		{
			int i = colonne;
			// Vérification de colonne -1 
			for ( i = colonne-1; i <= colonne+1; i++){
				if (estDansLaGrille(ligne-1, i) && grille[ligne-1][i] == true)
					nbVoisin++;
			}
		  i = colonne;
		// vérification de colonne + 1
			for ( i = colonne-1; i <= colonne+1; i++){
				if (estDansLaGrille(ligne+1, i) && grille[ligne+1][i] == true)
					nbVoisin++;
			}
	   	if ( estDansLaGrille(ligne, colonne + 1) && grille[ligne][colonne + 1] == true)
				nbVoisin++;
		if ( estDansLaGrille(ligne, colonne -1) && grille[ligne][colonne - 1] == true)
				nbVoisin++;
		
		return nbVoisin;
			
		}
		else 
			throw new Exception("La case demandé est en dehors de la grille");
	}
	
	
	public boolean estDansLaGrille(int ligne, int colonne){
		if ( this.nbLignes >= 0 && ligne <= this.nbLignes &&  colonne >= 0 && colonne <= this.nbColonnes)
			return true;
		else 
			return false;
	}

}
