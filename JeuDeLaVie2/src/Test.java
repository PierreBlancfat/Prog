
public class Test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Grille one = new Grille(5,5);
		one.affiche();
		one.AjoutCellule(1,2);
		one.affiche();
		System.out.println(one.nbVoisins(1,3));
		one.AjoutCellule(2,2);
		one.affiche();
		System.out.println(one.nbVoisins(1,3));
		one.AjoutCellule(2,2);
		one.affiche();
		System.out.println(one.nbVoisins(1,0));
	}

}
