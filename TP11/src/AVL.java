import java.util.NoSuchElementException ;
import java.util.ArrayList ;

/** cette classe definit un type "Arbre binaire de Recherche Equilibre" donc les elements sont de type E */
public class AVL<E extends Comparable<E>> extends ABR<E> {

	public AVL(){
		super();
	}
	
	public AVL(ABR<E> abr){

	}
			
	/** redefinition de la methode filsGauche(), pour que filsGauche() soit de type ABR et
	*   non Arbrebinaire (utile pour les appels recursifs) */	
	public AVL<E> filsGauche(){
		AVL<E> a=new AVL<E>();
		a.noeud=noeud.filsGauche;
		return a;
	}

	/** redefinition de la methode filsDroit(), pour que filsDroit() soit de type ABR et
	*   non Arbrebinaire (utile pour les appels recursifs) */	
	public AVL<E> filsDroit(){
		AVL<E> a=new AVL<E>();
		a.noeud=noeud.filsDroit;
		return a;

	}
	public void inserer(E e){
		
	}
}
