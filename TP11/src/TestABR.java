
public class TestABR {

	public static void main(String[] args) {
		ArbreBinaire<Integer> V = new ArbreBinaire<>();
		ArbreBinaire<Integer> D1 =new ArbreBinaire<Integer>(2,V,V);
		ArbreBinaire<Integer> D = new ArbreBinaire<Integer>(6,V,V);
		ArbreBinaire<Integer> E = new ArbreBinaire<Integer>(4,V,V);
		ArbreBinaire<Integer> F = new ArbreBinaire<Integer>(3,D1,E);//FG
		ArbreBinaire<Integer> G = new ArbreBinaire<Integer>(8,V,V);
		ArbreBinaire<Integer> H = new ArbreBinaire<Integer>(7,D,G);//FD
		ArbreBinaire<Integer> I = new ArbreBinaire<Integer>(5,F,H);//FD
		
		
		
		ABR<Integer> A = new ABR<Integer>();
		A.inserer(4);
		A.inserer(5);
		A.inserer(6);
		A.inserer(10);
		A.inserer(2);
		A.inserer(3);
		A.inserer(1);
		A.inserer(12);
		A.dessine();

	}
}
