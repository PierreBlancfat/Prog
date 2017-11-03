
/* pour les graphiques */
import javax.swing.*;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.ExecutionException;


/** cette classe definit un type "Arbre binaire" donc les elements sont de type E */
public class ArbreBinaire<E extends Comparable<E>>{

	protected class Cellule{
		E element;
		Cellule filsGauche;
		Cellule filsDroit;
	
		Cellule(E x, Cellule fg, Cellule fd){
			element = x;
			filsGauche=fg;
			filsDroit=fd;
		}
	}

	protected Cellule noeud;

	/**   construit un arbre binaire avec l'element e a la racine, le fils gauche
	* g, et le fils droit d  
	* @param e l'element a la racine 
	* @param g le fils gauche 
	* @param d le fils droit
	*/
	public ArbreBinaire(E e, ArbreBinaire<E> g, ArbreBinaire<E> d){
		noeud = new Cellule(e,g.noeud,d.noeud);	
	}  

	/**   construit un arbre binaire vide  */
	public ArbreBinaire(){
		noeud = null ;
	}

	/** cette methode teste si l'arbre courant est vide.
	@return vrai si l'arbre courant est vide et faux sinon */
	public boolean estVide(){
		return noeud == null ;
	}
	
	/** la methode racine renvoie la racine de l'arbre binaire. Cette methode ne
	doit etre appelee que si l'arbre binaire n'est pas vide.
	@return l'objet racine de l'arbre */
	public E racine() { 
		if ( this.estVide())
			throw new NoSuchElementException();
		else
			return noeud.element ;
	}

	/** la methode filsGauche renvoie le sous-arbre gauche de l'arbre binaire.	
	Cette methode ne doit etre appelee que si l'arbre binaire n'est pas vide.
	@return le fils Gauche de l'arbre courant */	
	public ArbreBinaire<E> filsGauche(){
		ArbreBinaire<E> a=new ArbreBinaire<E>();
		a.noeud=noeud.filsGauche;
		return a;
	}

	/** la methode filsDroit renvoie le sous-arbre droit de l'arbre binaire.	
	Cette methode ne doit etre appelee que si l'arbre binaire n'est pas vide.
	@return le fils Droit de l'arbre courant */	
	public ArbreBinaire<E> filsDroit(){
		ArbreBinaire<E> a=new ArbreBinaire<E>();
		a.noeud=noeud.filsDroit;
		return a;

	}

	/* methode pour calculer le max de deux entiers */ 
	/* utile pour calculer la hauteur */
	private static int max(int a,int b){ 
		if (a>b) return a; else return b;
	} 
	private static int min(int a,int b){ 
		if (a>b) return b; else return a;
	}  

	/** la methode hauteur renvoie la hauteur de l'arbre binaire.
	@return la hauteur de l'arbre binaire*/  
	public int hauteur(){
		if (estVide()){
			return 0;
		}
		else {
			return 1+max(filsGauche().hauteur(),filsDroit().hauteur());
		}
	}  
	
	public int hauteurMin(){
		if (estVide()){
			return 0;
		}
		else {
			return 1+min(filsGauche().hauteur(),filsDroit().hauteur());
		}
	}
	
	
	/* methode auxiliaire recursive pour toString() */
	private String toStringAux(int decalage){
		if (!this.estVide()){
			String res="";
			// on affiche la racine avec "decalage" espaces devant
			for(int i=1;i<=decalage;i++){
				res = res+" ";
			}
			res = res + this.racine() +"\n";
			
			// on affiche le fils gauche s'il est non vide avec un appel recursif (et decalage augmente de 5)
			if (!this.filsGauche().estVide()){
				res = res + this.filsGauche().toStringAux(decalage+5);
			}
			// pour eviter une confusion entre le fils droit et le fils gauche,
			// si le fils gauche est vide mais pas le fils droit on met un "-" aligne comme il faut
			else if (!this.filsDroit().estVide()){
				for(int i=1;i<=decalage+5;i++){
					res = res + " " ;
				}
				res = res + "-" + "\n";
			}
			// appel recursif pour afficher le fils droit
			res = res + this.filsDroit().toStringAux(decalage+5);
			return res ;
		}
		return "";
	}
	
	/** la methode toString renvoie une representation textuelle de
	l'arbre binaire (chaine vide si arbre vide)*/
	public String toString(){
		return this.toStringAux(5);
	}
		
	/** la methode chaine renvoie la valeur de la racine de l'arbre sous forme 
	d'une chaine, pour affichage.
	@return la chaine de caractere representant la racine de l'arbre. */
	public String chaine(){
		if (noeud!=null) return String.valueOf(noeud.element);
		else return "";
	}

	/** la methode dessine ouvre une fenetre graphique, et y dessine une 	
	representation graphique de l'arbre binaire ; 
	cette methode ne doit etre appelee que si l'arbre binaire n'est pas vide ; la 		fermeture de la fenetre graphique ferme aussi l'application qui a appele la
	methode */
	public void dessine(){	
		JFrame f = new JFrame("Arbre binaire");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		f.setSize(500,600);
		
		Dessin d = new Dessin(this);
		f.add(d);
		f.setVisible(true);		
	}	
	
	
	public int nbNoeuds(){
			if ( this.estVide())
				return 0;
			else if (this.filsDroit().estVide() ){
				return 1 + this.filsGauche().nbNoeuds();
			}
			else if (this.filsGauche().estVide()){
				return 1 + this.filsDroit().nbNoeuds();
			}
			else 
				return 1 + this.filsDroit().nbNoeuds() + this.filsGauche().nbNoeuds();
	}	
	
	
	public int nbFeuille(){
		if ( this.estVide())
			return 0;
		//SIles deux fils ne sont pas vide
		else if (!this.filsDroit().estVide() && !this.filsGauche().estVide()){
			return this.filsGauche().nbFeuille() + this.filsDroit().nbFeuille();
		}
		// Si le fils gauche n'est pas vide
		else if (!this.filsGauche().estVide()){
			return this.filsGauche().nbFeuille();
		}
		// Si le fils droit n'est pas  vide
		else if (!this.filsDroit().estVide()){
			return this.filsDroit().nbFeuille();
		}
		else
			return 1;
	}	
	
	
	public String parcoursProfondeurPrefixe(){
		//SI l'arbre est vide
		if ( this.estVide())
			return "";
		//Si les deux fils ne sont pas vide
		else if (!this.filsDroit().estVide() && !this.filsGauche().estVide()){
			return this.noeud.element + " ; " + this.filsGauche().parcoursProfondeurPrefixe() + " ; " + this.filsDroit().parcoursProfondeurPrefixe(); 
		}
		// Si le fils gauche n'est pas vide
		else if (!this.filsGauche().estVide()){
			return this.noeud.element + " ; " + this.filsGauche().parcoursProfondeurPrefixe();
		}
		// Si le fils droit n'est pas  vide
		else if (!this.filsDroit().estVide()){
			return this.noeud.element + " ; " +this.filsDroit().parcoursProfondeurPrefixe();
		}
		else
			return this.noeud.element+"";
	}
	
	
	public String parcoursProfondeurInfixe(){
		//SI l'arbre est vide
		if ( this.estVide())
			return "";
		//Si les deux fils ne sont pas vide
		else if (!this.filsDroit().estVide() && !this.filsGauche().estVide()){
			return this.filsGauche().parcoursProfondeurInfixe() + " ; " +this.noeud.element + " ; " +  this.filsDroit().parcoursProfondeurInfixe(); 
		}
		// Si le fils gauche n'est pas vide
		else if (!this.filsGauche().estVide()){
			return this.filsGauche().parcoursProfondeurInfixe() + " ; " +this.noeud.element ;
		}
		// Si le fils droit n'est pas  vide
		else if (!this.filsDroit().estVide()){
			return this.noeud.element + " ; " + this.filsDroit().parcoursProfondeurInfixe();
		}
		else
			return this.noeud.element+"";
	}
	
	
	
	public String parcoursProfondeurPostfixe(){
		//SI l'arbre est vide
		if ( this.estVide())
			return "";
		//Si les deux fils ne sont pas vide
		else if (!this.filsDroit().estVide() && !this.filsGauche().estVide()){
			return this.filsGauche().parcoursProfondeurPostfixe() +  " ; " +  this.filsDroit().parcoursProfondeurPostfixe() + " ; " +this.noeud.element; 
		}
		// Si le fils gauche n'est pas vide
		else if (!this.filsGauche().estVide()){
			return this.filsGauche().parcoursProfondeurPostfixe() + " ; " +this.noeud.element ;
		}
		// Si le fils droit n'est pas  vide
		else if (!this.filsDroit().estVide()){
			return this.filsDroit().parcoursProfondeurPostfixe()+ " ; " + this.noeud.element;
		}
		else
			return this.noeud.element+"";
	}
	
	public String parcoursLargeur(){
		LinkedList<Cellule> l = new LinkedList<Cellule>();
		l.addFirst(this.noeud);
		String s = "";
		while (!l.isEmpty()){
			Cellule n = l.removeLast();
			if ( s == "")
				s = n.element.toString();
			else 
				s = s + " ; " + n.element.toString();
			
			if (n.filsGauche != null){
				l.addFirst(n.filsGauche);
			}
			if (n.filsDroit != null){
				l.addFirst(n.filsDroit);
			}
		}
		return s;
	}
	
	
	public void inserer(E e){
		
		ArbreBinaire<E> A =  new ArbreBinaire<>(e,new ArbreBinaire<E>(),new ArbreBinaire<E>());
		
		if (!this.filsDroit().estVide() && !this.filsGauche().estVide()){
			if ( Math.random() < 0.5 )
				this.filsGauche().inserer(e);
			else 
				this.filsDroit().inserer(e);
		}
		else if (this.filsDroit().estVide() && this.filsGauche().estVide()){
			if ( Math.random() < 0.5)
				this.noeud.filsDroit= A.noeud;
			else
				this.noeud.filsGauche = A.noeud;
		}
		else if (this.filsGauche().estVide())
			this.noeud.filsDroit= A.noeud;
		else if ( this.filsDroit().estVide())
			this.noeud.filsGauche = A.noeud;
		
			
	}
	
	public ArbreBinaire<E> clone(){
		if ( this.estVide())
		{
			return new ArbreBinaire<E>();
		}
		else if ( !this.filsGauche().estVide() && !this.filsDroit().estVide()){
			return new ArbreBinaire<E>(this.noeud.element,this.filsGauche().clone(),this.filsDroit().clone());
			
		}
		else if ( !this.filsGauche().estVide()){
			return new ArbreBinaire<E>(this.noeud.element,this.filsGauche().clone(),new ArbreBinaire<E>());
		}
		else{
			return new ArbreBinaire<E>(this.noeud.element,new ArbreBinaire<E>(),this.filsDroit().clone());
		}
	}
	
	
	public boolean estABR(){
		
		return estABRAux(this.noeud.element);
		
	}

	public boolean estABRAux(E pere){
		boolean a = true;
		boolean b = true;
		
		if(!this.estVide()){
			// Si les deux fils ne sont pas vides
			if ( !this.filsGauche().estVide()){
				//Si la la racine du fils gauche respecte bien la propriété des ABR
				if ( this.filsGauche().noeud.element.compareTo(pere) < 0)
					a = this.filsGauche().estABRAux( this.filsGauche().noeud.element);
				// sinon on return false

				else a = false;
				}
			if(!this.filsDroit().estVide()){
				//Si la la racine du fils gauche respecte bien la propriété des ABR
				if ( this.filsDroit().noeud.element.compareTo(pere) > 0)
					b =  this.filsDroit().estABRAux(this.filsDroit().noeud.element);
				// sinon on return false		if ( this.estVide())
				else b = false;
				
				}
			return b && a;
			}
		return true;
	}
	
    public boolean estAbr2(){
    	
    	String s = this.parcoursProfondeurInfixe();
    	String[] s2 = s.split(" ; ");
    	
    	for (int i = 3; i <= s2.length - 1 ; i++){
    		if(  (s2[i].toString() != "" && s2[i-1].toString() != ""  && s2[i-1] != "" && s2[i] != "" )){ 
    			if ( Integer.parseInt(s2[i]) < Integer.parseInt(s2[i-1]) )
    			{
    			return false;
    			}
    		}
    	}
    	return true;
    }	 
	
	/// pour constructeur ABR � partir d'un arbre binaire
		public ArrayList<E> parcoursPronfondeurInfixeABR(ArrayList<E> e){
			if ( !this.estVide())
			{
				if (this.filsDroit().estVide() && this.filsGauche().estVide())
				{
					e.add(this.noeud.element);
				}
				if (!this.filsGauche().estVide())
				{
					e.add(this.filsGauche().noeud.element);
					this.filsGauche().parcoursPronfondeurInfixeABR(e);
				}
				if (!this.filsDroit().estVide())
				{
					e.add(this.filsDroit().noeud.element);
					this.filsDroit().parcoursPronfondeurInfixeABR(e);
				}
			}
		return e;
		}
}
   
   
