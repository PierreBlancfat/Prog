package Jeu;

public class Grille {
	
	public int getNbLignes() {
		return nbLignes;
	}
	public void setNbLignes(int nbLignes) {
		this.nbLignes = nbLignes;
	}
	public int getNbColonnes() {
		return nbColonnes;
	}
	public void setNbColonnes(int nbColonnes) {
		this.nbColonnes = nbColonnes;
	}

	public int nbLignes;
	public int nbColonnes;
	public  boolean[][] grille; 
	
	
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
		if( estDansLaGrille(numeroLigne, numeroColonne)){
			grille[numeroLigne][numeroColonne] = true; 
		}
		else
		{
			throw new Exception("La case demandé est en dehors de la grille Add");
			
		}
	}
	
	//TODO voir si la case demandé est déjà vide
	public void SupprimeCellule(int numeroLigne, int numeroColonne) throws Exception{
		if( estDansLaGrille(numeroLigne, numeroColonne)){
			this.grille[numeroLigne][numeroColonne] = false; 
		}
		else
		{
			throw new Exception("La case demandé est en dehors de la grilleSupp");
			
		}
	}
	
	
	public void affiche(){
		for( int i = -1; i < this.nbLignes; i++){
		for (int j = -1; j < this.nbColonnes; j++ ){
			if ( j == -1 && i==-1)
				System.out.print(" ");
			else if ( i == -1 )
				System.out.print(j);
			else if ( j == -1 )
				System.out.print(i);
			else{
				if ( grille[i][j] == true)
				System.out.print("0");
				else 
				System.out.print(".");
				}
			System.out.print(" ");
			}
		System.out.println();
		}
		System.out.println();
	}
	
	public boolean estOccupe(int ligne, int colonne) throws Exception{
		if (estDansLaGrille(ligne, colonne)){
				if (this.grille[ligne][colonne] == true)
					return true;
				else
					return false;
		}
		else 
			throw new Exception("La case demandé est en dehors de la grille");
	}
	
	
	public int nbVoisins(int ligne, int colonne){
		int nbVoisin = 0;
		if (estDansLaGrille(ligne, colonne))
		{
			int i = colonne;
			// Vérification de colonne -1 
			for ( i = colonne-1; i <= colonne+1; i++){
				if (estDansLaGrille(ligne-1, i)){
					if (grille[ligne-1][i] == true){
					nbVoisin++;
					}
				}
			}
			i = colonne;
		    // vérification de colonne + 1
			for ( i = colonne-1; i <= colonne+1; i++){
						if (estDansLaGrille(ligne+1, i)){
								if (grille[ligne+1][i] == true){
							nbVoisin++;
								}
							}
						}
				// vérification case du dessus
			   	if ( estDansLaGrille(ligne, colonne + 1)){
			   			if (grille[ligne][colonne + 1] == true)
						  {
			   				nbVoisin++;
						  }
			   	
				}
			   	//vérification case du dessous
				if ( estDansLaGrille(ligne, colonne -1)){
						if  (grille[ligne][colonne - 1] == true)
						{
							nbVoisin++;
						}
				}
				return nbVoisin;
		}
		else
		{
			System.out.println("La case demandé est en dehors de la grille nb voisin"+ligne+" "+colonne);
			return nbVoisin;
		}
   
	}	

	
	
	public boolean estDansLaGrille(int ligne, int colonne){
		if ( ligne >= 0 && ligne < this.nbLignes &&  colonne >= 0 && colonne < this.nbColonnes)
			return true;
		else 
			return false;
	}
	
	
	
	public boolean estReprouctible(int ligne, int colonne) throws Exception{
		
		if ( this.nbVoisins(ligne, colonne) == 3)
				return true;
		else return false;
		
	}
	
	public boolean estIsolee(int ligne, int colonne) throws Exception{
		
		if (  this.nbVoisins(ligne, colonne) <= 1)
				return true;
		else
			return false;
	}
	
	public boolean estEtouffee(int ligne, int colonne) throws Exception{
		
		if ( this.nbVoisins(ligne, colonne) >= 4)
				return true;
		else return false;
	}
	public boolean estMaintenue(int ligne, int colonne) throws Exception{
		
		if (this.nbVoisins(ligne, colonne) == 3 || this.nbVoisins(ligne, colonne) == 4)
				return true;
		else return false;
	}
	
	public boolean[][] copyGrilleDans(boolean[][] grille2){
		for( int i = 0; i < this.nbLignes; i++){
		for (int j = 0; j < this.nbColonnes; j++ ){
			grille2[i][j] = this.grille[i][j];
		}
	}
		return grille2;
	}

}
