
public class TestAB {
	
	public static void main(String[] args){	
		
		
		ArbreBinaire<Integer> V = new ArbreBinaire<>();
		ArbreBinaire<Integer> A = new ArbreBinaire<Integer>(1,V,V);
		ArbreBinaire<Integer> B = new ArbreBinaire<Integer>(2,V,V);
		ArbreBinaire<Integer> A1 = new ArbreBinaire<Integer>(1,V,V);
		ArbreBinaire<Integer> B1 = new ArbreBinaire<Integer>(2,V,V);
		ArbreBinaire<Integer> C = new ArbreBinaire<Integer>(3,V,V);
		ArbreBinaire<Integer> D1 = new ArbreBinaire<Integer>(5,A1,B1);
		ArbreBinaire<Integer> D = new ArbreBinaire<Integer>(5,A,B);
		ArbreBinaire<Integer> E = new ArbreBinaire<Integer>(6,V,V);
		ArbreBinaire<Integer> F = new ArbreBinaire<Integer>(9,D1,E);//FG
		ArbreBinaire<Integer> G = new ArbreBinaire<Integer>(7,C,V);
		ArbreBinaire<Integer> H = new ArbreBinaire<Integer>(10,D,G);//FD
		ArbreBinaire<Integer> I = new ArbreBinaire<Integer>(11,F,H);//FD
		
		
		
		
		//I.dessine();
		System.out.println(I.nbNoeuds());
		System.out.println(I.nbFeuille());
		System.out.println(I.parcoursProfondeurPrefixe());
		System.out.println(I.parcoursProfondeurInfixe());
		System.out.println(I.parcoursProfondeurPostfixe());
		System.out.println(I.parcoursLargeur());
		I.inserer(458);
		I.dessine();
//		ArbreBinaire<Integer> Z = I.clone();
//		Z.dessine();
		
		
		
		
				
	
	}

}
