package Heuristique;
import Plateau.Plateau;

public class Heuristique {
	
	private Plateau plateauJeu;
	
	public Heuristique(Plateau p){
		
		this.plateauJeu = p;

	}
	
	// choisie une solution optimale 
	public int choix(int[][] jeu, int profondeur) throws Exception{
		 int max = -1000000;
		 int mini = 2;
	     int tmp;
	     int i;
	     System.out.println(" nbmanque1coup :"+nbManque1Coup(jeu, 1));
	     System.out.println(" nbmanque1coup :"+nbManque1Coup(jeu, 2));
	     System.out.println(" nbmanque2coup :"+nbManque2Coup(jeu, 1));
	     System.out.println(" nbmanque2coup :"+nbManque2Coup(jeu, 2));
	     // pour chaque coup hypothètique du jeu de l'ordi
	     for(i=0;i<this.plateauJeu.nbColonnes;i++){
		     if(derniereCase(jeu,i) < this.plateauJeu.nbLignes ){
		    	 // simule coup adversaire
    		 	  jeu[derniereCase(jeu,i)][i] = 2;
                  // mémorise le maximum du minimum de notre jeu 
                  // Implémente la randomisation si il y a plusieurs maximum 
    		 	  tmp = this.min(jeu,profondeur-1);	 
    		 	 System.out.println("Eval "+i+" "+tmp);
			   	  if(tmp > max || ( (tmp == max) && (Math.random() < 0.6) ) )
		          {
		        	  max = tmp;
		        	  mini = i;
		          }
			   	  //Annule le coup 
                  jeu[derniereCase(jeu,i)-1][i] = 0;
			     }
	     }
	     return mini;		
	}

	// Evalue si la profondeur est 0 ou si il y a un gagnant
	// sinon renvoie le maximum du minimum de notre jeu
	private int max(int[][] jeu ,int profondeur) throws Exception
	{
	     if(gagne(jeu) != 0 || profondeur == 0)
	     {
	          return eval(jeu,profondeur);
	     }
	     int max = -1000000;
	     int i,tmp;
		 for(i=0;i<this.plateauJeu.nbColonnes;i++)
	     {
		     if(derniereCase(jeu,i) < this.plateauJeu.nbLignes){
	    	 		//simule coup adversaire
                      jeu[derniereCase(jeu,i)][i] =  2;
                      tmp = min(jeu,profondeur-1);    
                      // mémorise le maximum du minimum de notre jeu 
                      // Implémente la randomisation si il y a plusieurs maximum 
                      if(tmp > max || ( (tmp == max) && (Math.random() < 0.6) ) )
                      {
                    	  max = tmp;
                      }
                      // annule le coup 
                      jeu[derniereCase(jeu,i)-1][i] = 0;
		     }
	     }
		 return max;
	}
	
	// Evalue si la profondeur est 0 ou si il y a un gagnant
	// sinon renvoie le minimum du maximum du jeu adverse
	private int min(int[][] jeu ,int profondeur) throws Exception
	{
	     if(gagne(jeu) != 0 || profondeur == 0)
	     {
	          return eval(jeu, profondeur);
	     }
	     int min = 1000000;
	     int i,tmp;
	     for(i=0;i<this.plateauJeu.nbColonnes;i++)
	          {
		    	 if(derniereCase(jeu,i) < this.plateauJeu.nbLignes){
		    		 	// simule notre coup
		    		 	 jeu[derniereCase(jeu,i)][i] = 1;
	                      tmp = max(jeu,profondeur-1);
	                      // mémorise le minimum du jeu maximum adverse
	                      // Implémente la randomisation si il y a plusieurs minimum 
	                      if(tmp < min || ( (tmp == min) && (Math.random() < 0.6) ) )
	                      {
	                    	  min = tmp;
	                      }
	                      // Annule le coup
	                      jeu[derniereCase(jeu,i)-1][i] = 0;
		         }
	         } 
	     return min;
	}

	private int eval(int[][] jeu, int profondeur) throws Exception {
		Plateau Tmp = (Plateau) plateauJeu.clone();
		Tmp.grille = jeu;
		int tmp = 0;
		if ( Tmp.gagne() != 0){
			if ( Tmp.gagne() == 2)
				tmp = 100000 + profondeur;
			else if ( Tmp.gagne() == 1)
				tmp = -100000 - profondeur ;
			else tmp =  0;
		return tmp;
		}
		return  (50*(nbManque1Coup(jeu, 2)^3 - nbManque1Coup(jeu, 1)^3)) + (5*(nbManque2Coup(jeu, 2)^2 - nbManque2Coup(jeu, 1)^2)) ;
	}

	
	public int derniereCase(int[][] grille,int colonne){
		int i;
		for ( i = plateauJeu.nbLignes-1; i >= 0; i--){
			if ( grille[i][colonne] != 0)
				return i+1;
 		}
		return 0;
	}
	    // retourne le joueur gagnant
		// retourne 0 sinon pas de gagnant
		public int gagne(int grille[][]){
			//Pour chaque joueur
			for ( int joueur = 1; joueur <= 2; joueur++){
			//pour chaque case occupé
				for ( int ligne = 0; ligne <= 5; ligne++){
					for ( int colonne = 0; colonne < plateauJeu.nbLignes; colonne++){
						// pour chaque sens
						for ( int sens = -1; sens <= 1;sens++) {
							for (int sens2 = -1; sens2 <= 1; sens2++ ){
								if ( sens != 0 || sens2 != 0){
								//test 4 boules même couleur
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
			return 0;	
		}
		
		 // retourne le joueur gagnant
		// retourne 0 sinon pas de gagnant
		public int nbManque1Coup(int grille[][], int joueur){
			int nb = 0;
			int cptPion=0;
			int cptLibre=0;
			//Pour chaque joueur
			//pour chaque case occupé
				for ( int ligne = 0; ligne <= 5; ligne++){
						for ( int colonne = 0; colonne < plateauJeu.nbLignes; colonne++){
							if ( estOccupé(grille, ligne, colonne)){
							// pour chaque sens
							for ( int sens = -1; sens <= 1;sens++) {
								for (int sens2 = -1; sens2 <= 1; sens2++ ){
									if ( sens != 0 || sens2 != 0){
										// pour chaque case exploré
										for ( int i = 0; i < 4; i++){
											// Compteur de jeton
											if ( estDansLaGrille(ligne+(i*sens),colonne+(i*sens2)) &&( grille[ligne][colonne] != 0)){
												if (grille[ligne+(i*sens)][colonne+(i*sens2)] == 0 && ligne+(i*sens) == derniereCase(grille, colonne+(i*sens2)))
													cptLibre++;
												if (grille[ligne+(i*sens)][colonne+(i*sens2)] == joueur )
													cptPion++;
											}
											else break;
										}
										// si la combinaison est valide
									if (cptLibre == 1 && cptPion == 3) nb++;	
									cptLibre = 0;
									cptPion = 0;
									}
								}	
							}
						}
					}
			}
			return nb;	
		}
		
		
		 // retourne le nombre de combinaisons de
		// retourne 0 sinon pas de gagnant
		public int nbManque2Coup(int grille[][], int joueur){
			int nb = 0;
			int cptPion=0;
			int cptLibre=0;
			//Pour chaque joueur
			//pour chaque case occupé
				for ( int ligne = 0; ligne <= 5; ligne++){
						for ( int colonne = 0; colonne < this.plateauJeu.nbLignes; colonne++){
							if ( estOccupé(grille, ligne, colonne)){
							// pour chaque sens
							for ( int sens = -1; sens <= 1;sens++) {
								for (int sens2 = -1; sens2 <= 1; sens2++ ){
									if ( sens != 0 || sens2 != 0){
										// pour chaque case exploré
										for ( int i = 0; i < 4; i++){
											// Compteur de jeton
											if ( estDansLaGrille(ligne+(i*sens),colonne+(i*sens2))){
												if (grille[ligne+(i*sens)][colonne+(i*sens2)] == 0 )
													cptLibre++;
												if (grille[ligne+(i*sens)][colonne+(i*sens2)] == joueur )
													cptPion++;
											}
											else break;
										}
										// si la combinaison est valide
									if (cptLibre == 2 && cptPion == 2) nb++;	
									cptLibre = 0;
									cptPion = 0;
									}
								}	
							}
						}
					}
			}
			return nb;	
		}
		
		
		// Si la case est dans la grille, retourne true
		// Sinon flase
		public boolean estDansLaGrille(int  ligne, int colonne){
			if ( ligne < this.plateauJeu.nbLignes && ligne >= 0 && colonne < this.plateauJeu.nbColonnes && colonne >= 0) 
				return true;
			else return false;
		}
		
		// Si la case est occupé retourne true
		// Sinon false
		public boolean estOccupé(int[][] jeu ,int  ligne, int colonne){
			if ( jeu[ligne][colonne] != 0) 
				return true;
			else return false;
		}
		
}

