//// ce fichier doit absolument compiler et s'executer avec les fichiers que vous me rendrez pour le TP11 
//
//public class TestTP11{
//	public static void main(String[] args){	
//		
//		ArbreBinaire<Integer> A, B, C ;
//
//		B = new ArbreBinaire<Integer>(2,new ArbreBinaire<Integer>(),new ArbreBinaire<Integer>(13,new ArbreBinaire<Integer>(),new ArbreBinaire<Integer>()));
//
//		C = new ArbreBinaire<Integer>(4,new ArbreBinaire<Integer>(),new ArbreBinaire<Integer>(1,new ArbreBinaire<Integer>(-5,new ArbreBinaire<Integer>(),new ArbreBinaire<Integer>()),new ArbreBinaire<Integer>()));
//		
//		A = new ArbreBinaire<Integer>(7,B,C);
//
//		System.out.print(A);
//		
//		A.dessine();
//
//		// classe ArbreBinaire
//		System.out.println("Nombre de noeuds de A : " + A.nbNoeuds());
//
//		System.out.println("Nombre de feuilles de A : " + A.nbFeuilles());
//
//		System.out.println("Parcours profondeur prefixe  A : ");
//		System.out.println(A.parcoursProfondeurPrefixe());
//
//		System.out.println("Parcours profondeur infixe  A : ");
//		System.out.println(A.parcoursProfondeurInfixe());
//
//		System.out.println("Parcours profondeur postfixe  A : ");
//		System.out.println(A.parcoursProfondeurPostfixe());
//
//		System.out.println("Parcours en largeur  A : ");
//		System.out.println(A.parcoursLargeur());
//
//		LectureClavier.lireChaine("avant insertion 17 : (tapez Entree) ");
//		A.inserer(17);
//		A.dessine();
//		
//		B = A.clone();
//
//		ArbreBinaire<Integer> ab1 = new ArbreBinaire<Integer>(3,new ArbreBinaire<Integer>(),new ArbreBinaire<Integer>());
//		System.out.println("Arbre de recherche v1 (T) ? " + ab1.estAbr());
//		System.out.println("Arbre de recherche v1 (F) ? " + A.estAbr());
//
//		System.out.println("Arbre de recherche v2 (T) ? " + ab1.estAbr2());
//		System.out.println("Arbre de recherche v2 (F) ? " + A.estAbr2());
//
//		// classe ABR
//		ABR<Integer> abr1 = new ABR<Integer>();
//		ABR<Integer> abr2 = new ABR<Integer>(A);
//		abr2.dessine();
//		LectureClavier.lireChaine("apres conversion A en ABR -> abr2 : (tapez Entree)");
//		abr2.inserer(-35); // insertion ABR
//		abr2.dessine();
//		LectureClavier.lireChaine("apres ajout valeur -35 a abr2 et avant suppression de -35 : (taper Entree)");
//					
//		abr2.supprimer(-35);
//		abr2.dessine();
//		LectureClavier.lireChaine("Apres suppression de -35 (tapez Entree)");
//		
//		System.out.println("AVL ? " + abr2.estAvl());
//		
//		// classe AVL
//		AVL<Integer> avl1 = new AVL<Integer>();
//		avl1.insererAvl(12);
//		avl1.insererAvl(11);
//		avl1.insererAvl(10);
//		avl1.insererAvl(9);
//		avl1.dessine();
//		LectureClavier.lireChaine("Apres insertion avl1 (tapez Entree)");
//		
//		
//		avl1.supprimer(10);	
//		avl1.dessine();	
//		LectureClavier.lireChaine("Apres suppression 10 dans avl1 (tapez Entree)");
//		
//		AVL<Integer> avl2 = new AVL<Integer>(abr2);
//		avl2.dessine();	
//		System.out.println("conversion de abr2 en AVL : (taper Entree)");
//		
//	}
//}
