package IHM;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.Object;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import Jeu.Grille;

public class Fenetre extends JFrame{
	
		public PanneauJeu panneauJeu;
		public JButton bouttonStart = new JButton("Start");
		public JButton bouttonPause = new JButton("Pause");
		public JButton bouttonFermer = new JButton("Fermer");
		private Grille grille;
		
		public Fenetre(int x ,int y, Grille g)
		{
			this.grille = g;
			//Paramètres de la fenètre
			setTitle("Jeu de la vie");
			setSize(x,y);
			setVisible(true);
			//Panneau jeu 
			PanneauJeu panneaujeu= new PanneauJeu(g);	
			//boutons	
			panneaujeu.add(bouttonStart);
			panneaujeu.add(bouttonPause);
			panneaujeu.add(bouttonFermer);

			panneaujeu.setBackground(Color.BLUE);
			this.setContentPane(panneaujeu);
			this.setVisible(true);
			
			// Splitage TODO
		}
		
		
}
	
