package IHM;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import Plateau.Plateau;

public class PanneauJeu extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Plateau p;
	Fenetre f;
	public PanneauJeu ( Plateau p,Fenetre f){
		this.setBackground(Color.BLUE);
		f.setBackground(Color.BLUE);
		this.f = f;
		this.p = p;
		
	}
	public static void main( String[] argz[]){
		
	}
	@Override
	public void paintComponent(Graphics graph){
		
		int largeur=this.getWidth()/p.nbColonnes;
		int hauteur=this.getHeight()/p.nbLignes;
	    for(int i=0; i<p.nbLignes; i++){
	    		for(int j=0; j<p.nbColonnes; j++){
	    			
	    			try {
						if(p.grille[i][j] == 1){
							graph.setColor(Color.YELLOW);
						}
						else if(p.grille[i][j] == 2)
						{
							graph.setColor(Color.RED);
						}
						else{
							graph.setColor(Color.BLACK);
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	    			graph.fillOval((p.nbLignes-j)*largeur, (p.nbColonnes-i-2)*hauteur, largeur, hauteur);
	    			
	    		}
	    }
}


}

