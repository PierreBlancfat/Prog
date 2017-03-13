package IHM;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import Heuristique.Heuristique;
import Plateau.Plateau;

public class Fenetre extends JFrame{

			
			public PanneauJeu panneaujeu;
			private ThreadAnimation anim;
			public Plateau p;
			public int modeJeux; // 1 p vs p, 2 p vs ia, 3 o vs o;
			private int profondeur;
			private boolean jouer;

			
			// constructeur de la fenêtre 
			public Fenetre(int x ,int y, Plateau p)
			{
				//Paramètre début de jeu
				this.p=p;
				this.modeJeux = 2;
				this.profondeur = 5;
				
				// menu 
				JMenuBar menuBar = new JMenuBar();
				JMenu menu1 = new JMenu("Menu");
		 
				// menu 1
				JMenuItem modeDeuxJoueur = new JMenuItem("Mode deux joueur ");
				modeDeuxJoueur.addActionListener( new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						startModeDeuxJoueur();
						
					}
				});
				menu1.add(modeDeuxJoueur);
		 
				JMenuItem modeOrdinateur = new JMenuItem(("Mode joueur contre ordinateur"));
				modeOrdinateur.addActionListener( new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						startModeJoueurOrdrinateur();
						
					}
				});
				menu1.add(modeOrdinateur);
				
				JMenuItem mode2Ordinateurs = new JMenuItem(("Mode joueur contre ordinateur"));
				mode2Ordinateurs.addActionListener( new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						startMode2Ordrinateurs();
						
					}
				});
				menu1.add(mode2Ordinateurs);
				
				JMenuItem quitter = new JMenuItem(("Quitter"));
				quitter.addActionListener( new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
						
					}
				});
				menu1.add(quitter);
		 
				menuBar.add(menu1);
				
				// menu 2
				JMenu menu2 = new JMenu("Difficulté");
				JMenuItem difficulte1 = new JMenuItem("1");
				JMenuItem difficulte2 = new JMenuItem("2");
				JMenuItem difficulte3 = new JMenuItem("3");
				menu2.add(difficulte1);
				menu2.add(difficulte2);
				menu2.add(difficulte3);
				
				menuBar.add(menu2);
				
				difficulte1.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						profondeur = 4;
						
					}
				});
				
				difficulte2.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						profondeur = 5;
						
					}
				});
				
				difficulte3.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						profondeur = 6;
						
					}
				});
				
				
				// menu 4
				JMenu menu4 = new JMenu("Taille (non fonctionnel)");
				JMenuItem grille1 = new JMenuItem("6*7");
				JMenuItem grille2 = new JMenuItem("7*8");
				JMenuItem grille3 = new JMenuItem("8*9");
				menu4.add(grille1);
				menu4.add(grille2);
				menu4.add(grille3);
				
				menuBar.add(menu4);
				
				difficulte1.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						profondeur = 4;
						
					}
				});
				
				difficulte2.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						profondeur = 5;
						
					}
				});
				
				difficulte3.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						profondeur = 6;
						
					}
				});
				
				
				// menu 3
				JMenu menu3 = new JMenu("?");
				JMenuItem aPropos = new JMenuItem("A propos");
				aPropos.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						Object[] options = {"ok"};
						JOptionPane.showOptionDialog(null,"Application crée en 2016 par Pierre Blanc-Fatin",null, JOptionPane.YES_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
						
					}
				});
				menu3.add(aPropos);
				menuBar.add(menu3);
				
		 
				setJMenuBar(menuBar);
				
				//Paramètres de la fenètre
				setTitle("Puissance 4");
				setSize(x,y);
				setVisible(true);
				
				//Panneau jeu 
				panneaujeu = new PanneauJeu(p,this);	
				this.setContentPane(panneaujeu);
				this.setVisible(true);
			}
			
			
			public void joue(int col) throws Exception{
				
				if ( this.modeJeux == 1)this.joueMode1(col);
				if ( this.modeJeux == 2)this.joueMode2(col);
				if ( this.modeJeux == 3)this.joueMode3(col);
			}
			
			// Mode joueur/joueur
			private void joueMode1(int col){
				this.tourJoueur(col);
				p.joueurAdverse();
			}
			// Mode joueur/IA
			private void joueMode2(int col) throws Exception{
				this.p.joueur = 1;
				this.tourJoueur(col);
				if ( jouer == true){
					this.p.joueur = 2;
					this.tourOrdinateur();					
				}
			}
			// mode IA/IA
			private void joueMode3(int col) throws Exception{
				p.joueur = 1;
				this.tourOrdinateur();
				p.joueur = 2;
				this.tourOrdinateur();
			}
			
			// Joue une colonne pour le joueur
			private void tourJoueur(int col){
				this.jouer = true;
				try {
					p.joueHaut(col);
					// si le jeton peux descendre
					if ( p.grille[p.nbLignes-2][col] == 0){
						anim = new ThreadAnimation();
						anim.run(col, this);
					}
					p.joueurSuivant();			
				} catch (Exception e) {
					System.out.println(e.getMessage());
					Object[] options = {"Ok"};
					JOptionPane.showOptionDialog(null,"Impossible, la colonne est déjà remplie",null, JOptionPane.YES_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
					jouer = false;
				}
				if ( p.gagne() == 3)
				{
					this.egalite();
					return;
				}
				if (p.gagne() != 0){
					this.gagne();
					return;
				}
				this.repaint();
			}

			// Joue une colonne pour l'ordinateur
			private void tourOrdinateur() throws Exception{
				try {
					Heuristique ia = new Heuristique(this.p);
					int col = ia.choix(this.p.grille, this.profondeur);
					try{
					p.joueHaut(col);
					anim = new ThreadAnimation();
					anim.run(col, this);
					}
					catch( Exception e){
						e.printStackTrace();
						col = colonneVideHazard();
						panneaujeu.repaint();
						anim = new ThreadAnimation();
						anim.run(col, this);
					}

					if ( p.gagne() == 3)
					{
						this.egalite();
						return;
					}
					if (p.gagne() != 0){
						this.gagne();
						return;
					}
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("Ordi joue dans colonne remplite");
				}
			}

			
			// action en cas d'agalité
			private void egalite() {
				Object[] options = {"Oui","Non, quitter"};
				Component frame = null;
				int n = JOptionPane.showOptionDialog(frame,"Vous n'avez pas réussi à vous démarquer ! Voulez-vous recommencer ?",null, JOptionPane.YES_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[1]);
				
				if( n == 0){
					p.recommence();
					p.joueur = 1;
					this.repaint();
				}
				else
				{
					System.exit(0);
				}
				
			}
			//action en cas de partie gagné
			private void gagne() {
				int joueur = p.gagne();
				String couleur;
				if ( joueur == 1)
					couleur = "jaune";
				else  
					couleur = "rouge";
				Object[] options = {"Oui","Non, quitter"};
				Component frame = null;
				int n = JOptionPane.showOptionDialog(frame,"Le joueur "+couleur+" à gagné ! Voulez-vous recommencer ?",null, JOptionPane.YES_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[1]);
				
				
				if( n == 0){
					p.recommence();
					p.joueur = 1;
					this.repaint();
				}
				else{
					System.exit(0);
				}
			}
			
			// Configure le mode joueur/joueur
			public void startModeDeuxJoueur(){
				p.recommence();
				this.modeJeux = 1;
				this.repaint();
			}
			// COnfigure le mode joueur/IA
			public void startModeJoueurOrdrinateur(){
				p.recommence();
				this.p.joueur = 1;
				this.modeJeux = 2;
				this.repaint();
			}
			//configure le mode IA/IA
			public void startMode2Ordrinateurs(){
				p.recommence();
				this.modeJeux = 3;
				this.repaint();
			
			}
			
			//Retourne une colonne jouable au hazard
			public int colonneVideHazard(){
				System.out.println("------L'ordinateur joue au hazard------");
				int col = -1;
				for ( int colonne = 0; colonne < p.nbLignes; colonne++){
				if ( this.p.grille[p.nbLignes-1][colonne] == 0 && (col != -1 || Math.random() < 0.5))
					col = colonne;
				
				}
			return col;
			}
}
		


;