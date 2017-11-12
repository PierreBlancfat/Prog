import java.util.NoSuchElementException ;
import java.util.ArrayList ;

/** cette classe definit un type "Arbre binaire de Recherche Equilibre" donc les elements sont de type E */
public class AVL<E extends Comparable<E>> extends ABR<E> {

	public AVL(){
		super();
	}
	
	public AVL(ABR<E> abr){

	}
			
	/** redefinition de la methode filsGauche(), pour que filsGauche() soit de type AVL et
	*   non Arbrebinaire (utile pour les appels recursifs) */	
	public AVL<E> filsGauche(){
		AVL<E> a=new AVL<E>();
		a.noeud=noeud.filsGauche;
		return a;
	}

	/** redefinition de la methode filsDroit(), pour que filsDroit() soit de type AVL et
	*   non Arbrebinaire (utile pour les appels recursifs) */	
	public AVL<E> filsDroit(){
		AVL<E> a=new AVL<E>();
		a.noeud=noeud.filsDroit;
		return a;

	}
	public void insererAvl(E e){
		this.inserer(e);
		if ( !this.estAvl()){
			this.reequilibrage();
		}
	}
	
	
	private void reequilibrage(){
		if(!this.estVide()){
			if (this.filsDroit().estAvl() && this.filsGauche().estAvl())
			{
				if( this.filsDroit().hauteur() > this.filsDroit().hauteur())
					this.noeud = this.rotationG();
				else 
					this.noeud = this.rotationD();
			}
			else
			{
				this.filsDroit().reequilibrage();
				this.filsGauche().reequilibrage();
			}
				
		}
	}
	
	private Cellule rotationG(){
		AVL<E> r =new AVL<E>();
		ArbreBinaire<E> rg = new ArbreBinaire<E>(this.noeud.element,this.filsDroit(),this.filsDroit().filsGauche());
		return r.noeud =  new ArbreBinaire<E>(this.filsDroit().noeud.element,rg,this.filsDroit().filsDroit()).noeud;
	}
	
	
	private Cellule rotationD(){
		AVL<E> r =new AVL<E>();
		ArbreBinaire<E> rd = new ArbreBinaire<E>(this.noeud.element,this.filsGauche().filsDroit(),this.filsDroit());
		return r.noeud = new ArbreBinaire<E>(this.filsGauche().noeud.element,this.filsGauche().filsGauche(),rd).noeud;
	}
}
