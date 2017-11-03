import javax.swing.*;
import java.awt.Graphics;

class Dessin extends JPanel{
	private ArbreBinaire copieLocale;	


	static final int xdec=2;
	static final int ydec=50;
	static final int dim=20;
	
	public Dessin(ArbreBinaire ab){
		copieLocale = ab;
	}

	
	private void dessineArbreBinaire(Graphics gg,ArbreBinaire ab, int x, int y,int n){
		gg.drawOval(x,y,dim,dim);
		gg.drawString(ab.chaine(),x+5,y+15);
		if (!ab.filsGauche().estVide()) {
			gg.drawLine(x+dim/2,y+dim,x-n*xdec+dim/2,y+ydec);
			dessineArbreBinaire(gg,ab.filsGauche(),x-n*xdec,y+ydec,n/2);
		}
		if (!ab.filsDroit().estVide()) {
			gg.drawLine(x+dim/2,y+dim,x+n*xdec+dim/2,y+ydec);
			dessineArbreBinaire(gg,ab.filsDroit(),x+n*xdec,y+ydec,n/2);
		}
	}
	
	public void paintComponent(Graphics g){	

		int x=1;
		for(int i=0;i<=copieLocale.hauteur();i++)
			x *=2;
		dessineArbreBinaire(g,copieLocale,getWidth()/2,ydec,x);
	}
	
	
}
