package Plateau;

public class Plateau implements Cloneable{
	
	
	public int nbLignes;
	public int nbColonnes;
	public  int[][] grille; 
	public int[] derniereCaseJoué[];
	public int joueur; // 1 ou 2
	
	// Constructeur du plateau 
	// Vérifie si il n'y on ne demande pas un nb de lignes/colonnes négatif
	public Plateau(int nbLignes,int nbColonnes) throws Exception {
		if ( nbLignes >= 2 && nbColonnes >= 2 ){
			this.nbLignes = nbLignes;
			this.nbColonnes = nbColonnes;
			grille = new int[this.nbLignes][this.nbColonnes];
			for ( int i  = 0; i < nbLignes; i++){
				for ( int j = 0; j < nbColonnes; j++){
				 this.grille[i][j]= 0;
				}
			}
		}
		else{
			throw new Exception(" Impossible de créer une grille avec 0 ou moins de colonnes, ou de lignes");
		}
		
	}
	
	// constructeur vide
	public Plateau() {
	}

	
	// Affiche la grille dans la sortie standard
	public void imprime(){
			for( int i = -1; i < this.nbLignes; i++){
			for (int j = -1; j < this.nbColonnes; j++ ){
				if ( j == -1 && i==-1)
					System.out.print(" ");
				else if ( i == -1 )
					System.out.print(j);
				else if ( j == -1 )
					System.out.print(i);
				else{
					if ( grille[i][j] == 0)
					System.out.print("0");
					if ( grille[i][j] == 1)
					System.out.print("1");
					if ( grille[i][j] == 2)
					System.out.print("2");
					}
				System.out.print(" ");
				}
			System.out.println();
			}
			System.out.println();
		}
	
	
	// Joue un jeton dans une colonne
	// Méthode sans animation
	public void joue(int i){
		for ( int j = 0; j<= nbLignes; j++){
			if ( this.grille[j][i] == 0){
				grille[j][i] = joueur;
				return;
			}
		}
	}
	
	// Joue un jeton dans la premier case dans une colonne
	//Méthode avec animation
	public void joueHaut(int i) throws Exception{
		if(grille[nbLignes-1][i] !=0 )
			throw new Exception("La colonne "+i+" est déjà remplie !");
		else
			grille[nbLignes-1][i] = joueur;			
	}
	
	//Descend le jeton joué d'une case si c'est possible et retourne true
	// Sinon retourne false
	public boolean descendJeton (int ligne, int colonne){
		if ( ligne > 0){
			if ( grille[ligne-1][colonne] == 0){
				grille[ligne][colonne] = 0;
				grille[ligne-1][colonne] = joueur;
				return true;
			}
		}
		System.out.println("false");
		return false;
			
	}
	
	// retourne le joueur gagnant si il y a une victoire
	// retourne 3 si égalité
	// return 0 sinon
	public int gagne(){
		boolean testEgalite =true;
		//Pour chaque joueur
		for ( int joueur = 1; joueur <= 2; joueur++){
		//pour chaque case 
			for ( int ligne = 0; ligne <= 5; ligne++){
				for ( int colonne = 0; colonne <nbLignes ;colonne++){
					// test égalité
					if ( grille[ligne][colonne] == 0)
						testEgalite = false;
					// pour chaque sens
					for ( int sens = -1; sens <= 1;sens++) 
					{
						for (int sens2 = -1; sens2 <= 1; sens2++ ){
							if ( sens != 0 || sens2 != 0){
								
						 // test de présence de 4 jetons alignés
							boolean gagne = true;
								for ( int i = 0; i < 4; i++){
									if ( estDansLaGrille(ligne+(i*sens),colonne+(i*sens2)) ){
										if (grille[ligne+(i*sens)][colonne+(i*sens2)] != joueur)
										{
											gagne = false;
										}
									}
									else gagne = false;
								}
							if ( gagne == true) return joueur;		
							}
						}	
					}
				}
			}
		}
		// test égalité
		if ( testEgalite == true)
			return 3;
		else
			return 0;	
	}
	
	// Si le jeton est dans la grille retourne true 
	// Sinon retourne false
	public boolean estDansLaGrille(int  ligne, int colonne){
		if ( ligne < nbLignes && ligne >= 0 && colonne < nbColonnes && colonne >= 0) 
			return true;
		else return false;
	}
	
	// change de joueur 1 -> 2, 2 -> 1
	public void joueurSuivant(){
		if ( this.joueur == 1)
			this.joueur = 2;
		else
			joueur = 1;
	}
	
	//Remet la grille à zéro
	public void recommence(){
		for ( int i = 0; i<nbLignes;i++){
			for ( int j = 0; j<nbColonnes;j++){
				this.grille[i][j] = 0;
			}
		}
	}
	
	
	// retourne la dernière case vide d'une colonne
	public int dernierCaseLibre(int colonne){
		int ligneCourante = this.nbLignes-1;
		 while(this.grille[ligneCourante][colonne] > 1){
			 ligneCourante--;
		 }
		return ligneCourante;
	}
	
	
	// renvoie le joueur adverse
	public int joueurAdverse(){
		if (this.joueur == 1)return 2;
		else return 1;
	}
	
	
	//Permet de clonner un plateau 
	public Object clone() {
		Object o = null;
		try {
			o = super.clone();
		} catch(CloneNotSupportedException cnse) {
			cnse.printStackTrace(System.err);
		}
		return o;
	}
	
}

	


