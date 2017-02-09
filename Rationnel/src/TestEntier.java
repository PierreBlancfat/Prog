import java.awt.Event;

public class TestEntier {

	public static void main(String[] args) throws Exception {
		
		int[] a = {7};
		int[] b = {5,0,1};
		int[] c = {1,1};
		int[] d = {2,2};
		
		Entier ea = new Entier(a,false);
		Entier eb = new Entier(d,false);
		Entier ec = new Entier(b,false);
		Entier ed = new Entier(c,false);
		
		
		int[] t = {9};
		int[] u = {1};
		
		Entier et = new Entier(t,false);
		Entier eu = new Entier(u,false);
		
		et.affiche();
		eu.affiche();
		et.soustraire(eu);
		et.affiche();
		
		
		
		System.out.println("-------------------");
		ec.affiche();
		System.out.println("-");
		eb.affiche();
		System.out.println(ec.superieur(eb));
		System.out.println(ec.equal(eb));
		System.out.println("=");
		ec.soustraire(eb);
		ec.affiche();

		System.out.println("-------------------");
		ec.affiche();
		System.out.println("-");
		eb.affiche();
		System.out.println(ec.superieur(eb));
		System.out.println("=");
		ec.soustraire(eb);
		ec.affiche();
		
		System.out.println("-------------------");
		ec.affiche();
		System.out.println("-");
		eb.affiche();
		System.out.println(ec.superieur(eb));
		System.out.println("=");
		ec.soustraire(eb);
		ec.affiche();
		
		System.out.println("-------------------");
		ec.affiche();
		System.out.println("-");
		eb.affiche();
		System.out.println(ec.superieur(eb));
		System.out.println("=");
		ec.soustraire(eb);
		ec.affiche();
		
		System.out.println("-------------------");
		ec.affiche();
		System.out.println("-");
		eb.affiche();
		System.out.println(ec.superieur(eb));
		System.out.println("=");
		ec.soustraire(eb);
		ec.affiche();
		
		
		System.out.println("-------------------");
		ec.affiche();
		System.out.println("-");
		eb.affiche();
		System.out.println(ec.superieur(eb));
		System.out.println("=");
		ec.soustraire(eb);
		ec.affiche();
		
		
		System.out.println("-------------------");
		ec.affiche();
		System.out.println("-");
		eb.affiche();
		System.out.println(ec.superieur(eb));
		System.out.println("=");
		ec.soustraire(eb);
		ec.affiche();
		
		
		System.out.println("-------------------");
		ec.affiche();
		System.out.println("-");
		eb.affiche();
		System.out.println(ec.superieur(eb));
		System.out.println("=");
		ec.soustraire(eb);
		ec.affiche();
		

		
		
		ec.setNegatif(false);
		
		
		System.out.println("-------------------");
		ec.affiche();
		System.out.println("-");
		eb.affiche();
		System.out.println(ec.superieur(eb));
		System.out.println("=");
		ec.soustraire(eb);
		ec.affiche();
		
		System.out.println("-------------------");
		ec.affiche();
		System.out.println("-");
		ea.affiche();
		System.out.println(ec.superieur(eb));
		System.out.println("=");
		ec.addition(ea);
		ec.affiche();
		
		

	

		ea = new Entier(a,false);
		eb = new Entier(b,false);
	    ec = new Entier(c,false);
		ed = new Entier(d,false);
	
		
		System.out.println("-------------------");
		ec.affiche();
		System.out.println("*");
		ed.affiche();
		System.out.println("=");
		ec.multiplier(ed);
		ec.affiche();

		System.out.println("-------------------");
		ec.affiche();
		System.out.println("*");
		ed.affiche();
		System.out.println("=");
		ec.multiplier(ed);
		ec.affiche();
		
		System.out.println("-------------------");
		ec.affiche();
		System.out.println("*");
		ed.affiche();
		System.out.println("=");
		ec.multiplier(ed);
		ec.affiche();
		System.out.println("---------Factorielle----------");
//		ed.affiche();
		
		
		
		ea = new Entier(a,false);
		eb = new Entier(d,false);
		ec = new Entier(b,false);
		ed = new Entier(c,false);
		
		factorielle(ed).affiche();
		
		
		
	}
	
	
	
	public static Entier factorielle(Entier e)
	{
		
		int[] c = {1};
		int[] d = {0};
		Entier a = new Entier(c,false);
		Entier b = new Entier(d, false);
		Entier tmp = b;
		Entier tmp2 = b;
	
		if (e.equal(b)) {
            return a;
        } else {
        	tmp = e;
        	tmp.soustraireAux(a); // n-1
        	tmp2 = factorielle(tmp); // fact(n-1)
        	tmp2.multiplier(e);
            return tmp2;
        }
	        
	}

}
