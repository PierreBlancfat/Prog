package Plateau;
import java.util.Scanner;
public class Test {

	public static void main(String[] args) throws Exception {
		
		// TODO Auto-generated method stub
		
		Plateau p = new Plateau(6,7);
		p.imprime();
		Scanner sc = new Scanner(System.in);
		String col;
		p.joueur  = 1;
		int joueurGagnant;
		while ( true){
			System.out.println("joueur :"+p.joueur);
			col = sc.nextLine();
			p.joue(Integer.parseInt(col));
			p.imprime();
			joueurGagnant = p.gagne();
			if (joueurGagnant == 1 || joueurGagnant == 2){
				System.out.println("Le joueur "+joueurGagnant+" a gagné !");
				break;
			}
			p.joueurSuivant();
		}
		sc.close();


	}

}
