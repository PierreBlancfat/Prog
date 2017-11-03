import java.util.NoSuchElementException ;

import java.util.ArrayList ;

/** cette classe definit un type "Arbre binaire de Recherche" donc les elements sont de type E */
public class ABR<E extends Comparable<E>> extends ArbreBinaire<E> {

	public ABR(){
		super();
	}
	

	
	public ABR(ArbreBinaire<E> ab){
		noeud = new Cellule(ab.noeud.element,null,null); 
		ArrayList<E> e = new ArrayList<E>();
		e = ab.parcoursPronfondeurInfixeABR(e);
		System.out.println(e.toString());
		for (int i = 0; i < e.size();i++ ){
			this.inserer(e.get(i));
		}
	}
			
	/** redefinition de la methode filsGauche(), pour que filsGauche() soit de type ABR et
	*   non Arbrebinaire (utile pour les appels recursifs) */	
	public ABR<E> filsGauche()
	{
		ABR<E> a=new ABR<E>();
		a.noeud= this.noeud.filsGauche;
		return a;
		// si on avait deja le constructeur de la question 4, on pourrait ecrire :
		//return new ABR<E>(super.filsGauche());
	
	}

	/** redefinition de la methode filsDroit(), pour que filsDroit() soit de type ABR et
	*   non Arbrebinaire (utile pour les appels recursifs) */	
	public ABR<E> filsDroit(){
		ABR<E> a=new ABR<E>();
		a.noeud=this.noeud.filsDroit;
		return a;

	}
	

	
	public void inserer(E e){ 
	    // e n'est pas ajouté s'il est déjà présent
	    noeud = insererAux(noeud, e);
	 }
	 
	public Cellule insererAux ( Cellule r, E e){ 
		    if(r == null) 
		       return new Cellule (e, null, null);
		   else 
		       if (r.element.compareTo(e)<0) 
		    	   r.filsDroit = insererAux(r.filsDroit, e); 
		       else if (r.element.compareTo(e)>0) 
		    	   r.filsGauche = insererAux(r.filsGauche, e);
		       else System.out.println("L'élement "+e+" existe déjà dans l'abre, impossible de l'inserer");
		   return r;
	}
	
	
	public boolean estAvl(){
		if (this.hauteur() - this.hauteurMin() <= 1 && this.estABR())
			return true;
		else return false;
		
		
	}
	

}
			
	



