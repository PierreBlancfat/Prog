
public class Jeu extends Thread {

	public Grille grille;
	private String etat;
	private int temps;	
	
	public Jeu(Grille grille){
	
		this.grille = grille;
		temps = 0;
	}
	
	public void avance() throws Exception{
		
		
		// On parcout toute la grille
		for ( int i = 0; i < this.grille.nbLignes; i ++ ){
			for ( int j = 0; j < this.grille.nbLignes; j ++ ){
				
				if ( this.estReprouctible(i, j))
					this.grille.AjoutCellule(i, j);
				else if ( this.estIsolee(i, j))
					this.grille.SupprimeCellule(i, j);
				else if ( this.estEtouffee(i, j))
					this.grille.SupprimeCellule(i, j);
			}
		}
		temps++;
		
	}
	
	public void run(){
		while(true){
			try {
				avance();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			System.out.println("temps : "+temps);
		}
	}
	
	public boolean estReprouctible(int ligne, int colonne) throws Exception{
		
		if ( this.grille.estDansLaGrille(ligne, colonne) &&  !this.grille.estOccupe(ligne, colonne) && this.grille.nbVoisins(ligne, colonne) == 3)
				return true;
		else return false;
		
	}
	
	public boolean estIsolee(int ligne, int colonne) throws Exception{
		
		if ( this.grille.estDansLaGrille(ligne, colonne) &&  this.grille.estOccupe(ligne, colonne) && this.grille.nbVoisins(ligne, colonne) <= 1)
				return true;
		else return false;
	}
	
	public boolean estEtouffee(int ligne, int colonne) throws Exception{
		
		if ( this.grille.estDansLaGrille(ligne, colonne) &&  this.grille.estOccupe(ligne, colonne) && this.grille.nbVoisins(ligne, colonne) >= 4)
				return true;
		else return false;
	}
	
	
}
