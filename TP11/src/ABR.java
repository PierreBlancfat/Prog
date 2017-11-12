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
	
	
	public ArbreBinaire<E>.Cellule supprimer( E e){ 
 	   if (this.noeud==null) return this.noeud;// l’objet o n’est pas trouvé
 	   else{
 	      if (this.noeud.element.compareTo(e)==0)
 	    	  return supprimerAux(this.noeud);
 	      else if(this.noeud.element.compareTo(e)>0) this.noeud.filsGauche = this.filsGauche().supprimer(e); 
 	           else 
 	        	   this.noeud.filsDroit = this.filsDroit().supprimer(e)
 	       ;return this.noeud;
 	   }
 	   } 
 
 	   ArbreBinaire<E>.Cellule supprimerAux (ArbreBinaire<E>.Cellule c){ 
 	   if(c.filsGauche==null) return c = c.filsDroit; 
 	   else
 	      if(c.filsDroit==null) return c = c.filsGauche;
 	      else{ 
 	    	  ArbreBinaire<E>.Cellule  c1 = c.filsGauche;
 	    	  ArbreBinaire<E>.Cellule  pere = c;
 	         while(c1.filsDroit!=null) {
 	             pere = c1;
 	             c1 = c1.filsDroit;
 	         }
 	         c.element = c1.element;
 	         if(pere == c) pere.filsGauche = c1.filsGauche;
 	         else pere.filsDroit = c1.filsGauche;
 	         return c;
 	      }
 	 }
	
	public boolean estAvl(){
		if (this.hauteur() - this.hauteurMin() <= 1 && this.estABR())
			return true;
		else return false;
		
		
	}
	

}
			
	



