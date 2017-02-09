import java.lang.Exception;

public class Exo2 {
	

	public static void suiteURationnel (int fin){
		
		
		// Valeurs de un0 et un1
		Rationnel un0 = new Rationnel(3,2);
		Rationnel un1 = new Rationnel(5,3);
		Rationnel u2003 = new Rationnel(2003,1);
		
		// Cas Principale, on demande
		if ( fin >= 2)
		{	
			// ré-itération de la suite jusqu'à la valeur souhaitée ( fin ) 
			for (int i = 2;i <= fin;i++)
			{
			 u2003.setDenominateur(1);
			 u2003.setNumerateur(2003);
			 
			 // Définition des constantes
			 Rationnel u6002 = new Rationnel(6002,1);
			 Rationnel u4000 = new Rationnel(4000,1);
	
			 int tmpDenUn1 = un1.getDenominateur() ; 
			 int tmpNumUn1 = un1.getNumerateur();
					 
			 
			 // Calculs
		      u6002.diviser(un1);// 6002 / un+1
		      un1.multiplier(un0);  // un.un
		      u4000.diviser(un1); // 4000 / un.un1
		      u2003.ajouter(u4000); 
		      u2003.soustraire(u6002);

		      // Redéfinition des valeurs un -1 et un -2 pour la prochaine boucle
		      un0.setNumerateur(tmpNumUn1);
		      un0.setDenominateur(tmpDenUn1);
		      
		      un1.setNumerateur(u2003.getNumerateur());
		      un1.setDenominateur(u2003.getDenominateur());		  
			}
		}
		if ( fin  == 0){
			u2003.setDenominateur(2);
			u2003.setNumerateur(3);			
		}
		if ( fin == 1 ){
			u2003.setDenominateur(3);
			u2003.setNumerateur(5);
		}
		if ( fin < 0)
		{
			System.out.println(" Indéfini pour un indice inférieur à zéro");
		}
		else
			
		u2003.simplifie();
		u2003.afficher();
	}
		
	
	public static void suiteUDouble(int fin){
		
		
		// Définition de un0 et un1
		 double un0 = 3/2;
		 double un1 = 5/3;
		 double un = 0;
		 
		if ( fin >= 2)
		{
			for (int i = 2; i <= fin; i++)
			{
			// Calculs du prochain terme de la suite
         	 un = 2003 - (6002/(un1)) + 4000/(un1*un0);
    		 un0 = un1;
    		 un1 = un;
			}
		}
		if ( fin  == 0){
		 un = 3/2;
		}
		if ( fin == 1 ){
		un = 5/3;
		}
		if ( fin < 0)
		{
		System.out.println(" Indéfini pour un indice inférieur à zéro");
		}
		else
		System.out.println(un);
	}	
	
	
	public static void suiteVRationnel (int fin, int a){
		
		
		// Valeurs de un0 et un1
		Rationnel un0 = new Rationnel(1,1);
		Rationnel un1 = new Rationnel(1,2);
		Rationnel unTmp = new Rationnel(a,2);
		// Cas Principal
		if ( fin >= 1)
		{	
			// ré-itération de la suite jusqu'à la valeur souhaitée ( fin ) 
			for (int i = 1;i <= fin;i++)
			{
				
				un1 = new Rationnel(1,2);
				
				 un1.multiplier(un0);
				 unTmp.diviser(un0);
				 un1.ajouter(unTmp);
				 
				 // Redéfinition de un -1
				 un0.setDenominateur(un1.getDenominateur());
				 un0.setNumerateur(un1.getNumerateur());
			}
		}
		if ( fin  == 0){
			un1.setDenominateur(1);
			un1.setNumerateur(1);			
		}
		if ( fin < 0)
		{
			System.out.println(" Indéfini pour un indice inférieur à zéro");
		}
		else
			
//		un1.simplifie();
		un1.afficher();
	}
		
	
	public static void suiteVDouble(int fin, int a){
		
		// Définition de un0 et un1
		 double un0 = 1;
		 double un = 0;
		 
		if ( fin >= 1)
		{
			for (int i = 1; i <= fin; i++)
			{
			 
			// Calculs du prochain terme de la suite
         	 un = un0/2 + a/(2*un0);
    		 un0 = un;
			}
		}
		if ( fin  == 0){
		 un = 1;
		}
		if ( fin < 0)
		{
		System.out.println(" Indéfini pour un indice inférieur à zéro");
		}
		else
		System.out.println(un);
		
	}	
}
	


