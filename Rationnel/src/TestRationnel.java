public class TestRationnel {

	public static void main(String[] args) {
		
		
		Rationnel a = new Rationnel(12, 3);
		Rationnel b = new Rationnel(5,7);
	    Rationnel c = new Rationnel(3,4);
	    Rationnel d = new Rationnel(1, 2);
	    Rationnel e = new Rationnel(1, 6);
	    
		a.afficher();
		b.afficher();
		
	    a.ajouter(b);
	    a.afficher();
	    
	    a.afficher();
	    b.afficher();
	    
	    a.ajouter(2);
	    a.afficher();
	    
	    a.ajouter(d);
	    a.afficher();
	    
	    a.multiplier(5);
	    a.afficher();
	    
	    a.diviser(b);
	    a.afficher();
	    
	    a.diviser(d);
	    a.afficher();
	    
	    a.simplifie();
	    a.afficher();
	    
	    System.out.println("----U-----");
	    Exo2.suiteURationnel(3);
	    Exo2.suiteUDouble(3);
	    Exo2.suiteURationnel(9);
	    Exo2.suiteUDouble(9);
	    System.out.println("----V-----");
	    Exo2.suiteVRationnel(2,2);
	    Exo2.suiteVDouble(2,2);
	    Exo2.suiteVRationnel(3,4);
	    Exo2.suiteVDouble(3,4);
	    Exo2.suiteVRationnel(4,4);
	    Exo2.suiteVDouble(4,4);
	        
	 
	}

}

