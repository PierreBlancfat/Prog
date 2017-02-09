import java.lang.reflect.Array;
import java.lang.Exception;

public class Entier {
	
   
	private static int longueur = 100;
	
	private boolean negatif;
	
	
	public void setNegatif(boolean negatif) {
		this.negatif = negatif;
	}
	private int [] entier = new int[longueur];
	

	public void setEntier(int[] entier) {
		this.entier = entier;
	}


	public int[] getEntier() {
		return entier;
	}
	
	public int getEntier(int index) {
		return this.entier[index];
	}
	
	public Entier(int[] e, boolean neg){
		for ( int i = 0; i <e.length; i++ ){
			this.entier[i] = e[i];
		}
		for (int i = e.length; i < longueur;i++){
			this.entier[i] = 0;
		}
		this.negatif = neg;
	}
	
	
	public void addition(Entier e)
	{
		if ( this.negatif && e.negatif)
		{
			this.additionAux(e);
			this.negatif = true;
		}
		if (this.negatif && !e.negatif)
		{
			e.soustraireAux(this);
			this.entier = e.entier;
		}
		if ( !this.negatif && e.negatif)
		{
			this.soustraireAux(e);
		}
		if ( !this.negatif && !e.negatif)
		{
			this.additionAux(e);
		}
		
	}
	// Addition entre nombres positifs
	public void additionAux(Entier e) {
		
		int [] retenus = new int[longueur+1];

		int add;
		
		
		for ( int i = 0; i< longueur ;i++)
		{
			
			add  = e.entier[i]+ this.entier[i]+retenus[i];
			
			//Si l'addition > 9
			if( add > 9){
			

				this.entier[i] = add % 10;
				retenus[i+1] = (add - this.entier[i])/10;	
			}
			else{
				this.entier[i]=add;
			}
		}
	}
	
	
	public void soustraire(Entier e){
		
	if (this.superieur(e) && !this.equal(e))
	{
		if ( this.negatif && e.negatif)
		{
			e.soustraireAux(this);
			this.entier = e.entier;
		}
		if (this.negatif && !e.negatif)
		{
			this.addition(e);
			this.negatif = true;
		}
		if ( !this.negatif && e.negatif)
		{
			this.addition(e);
		}
		if ( !this.negatif && !e.negatif)
		{
			this.soustraireAux(e);
		}
	}
	else if ( e.superieur(this) && !this.equal(e))
	{
		if ( this.negatif && e.negatif)
		{
			e.soustraireAux(this);
			this.entier = e.entier;
			this.negatif = false;
		}
		if (this.negatif && !e.negatif)
		{
			this.addition(e);
			this.negatif = true;
		}
		if ( !this.negatif && e.negatif)
		{
			this.addition(e);
		}
		if ( !this.negatif && !e.negatif)
		{
			int[] tmp = e.entier;
			e.soustraireAux(this);
			this.entier = tmp;
			this.negatif = true;
		}
	}
	else if ( this.equal(e)) // Egalité
	{
		if ( this.negatif && e.negatif)
		{
			this.soustraireAux(e);
		}
		if ( this.negatif && !e.negatif)

			this.addition(e);
		if ( !this.negatif && e.negatif)
		{
			e.negatif = false;
			this.addition(e);
			this.negatif = true;

		}
		if ( !this.negatif && !e.negatif)
		{
			this.soustraireAux(e);
		}
	}
		
	}
		
			
	
	// a - b avec a > b
	public void soustraireAux(Entier e)
	{
		int [] retenus = new int[longueur+1];

		int soustraction;
		
		for ( int i = 0; i < longueur-2;i++)
		{
			
			soustraction  = this.entier[i] - retenus[i] - e.entier[i]; 

			//Si la soustraction < 0
			if( soustraction < 0){
			

				this.entier[i] = 10 - e.entier[i] + this.entier[i] - retenus[i];
				retenus[i+1] = 1;
			}
			else
			{
				this.entier[i] = soustraction;
			}
		}
	}
	public void multiplier(Entier e){
		if ( this.negatif && e.negatif)
		{
			this.multiplierAux(e);
		}
		if ( this.negatif && !e.negatif)
		{
			this.multiplierAux(e);
			
		}
		if ( !this.negatif && e.negatif)
		{
			this.negatif = true;
			this.multiplierAux(e);

		}
		if ( !this.negatif && !e.negatif)
		{
			this.multiplierAux(e);
		}
	}
	
	public void multiplierAux( Entier e){
		
		int[] a = {0};
		Entier zero = new Entier(a,false);
		Entier somme = new Entier(a,false);
		
		// On multiplie un à un les chiffres tous des deux facteurs entre eux
		for ( int i = 0; i < longueur-1;i++){
			for (int j = 0; j< longueur-1;j++)
			{
				if(this.entier[i] != 0 && e.entier[j] != 0)
				{

					//multiplication
					Entier tmp = toEntier((this.entier[i])* (e.entier[j]));
					//Ajout de zeros à gauche de l'entier
					tmp.foisN(i+j);
					//Somme
					somme.addition(tmp);

				}
				else
				{
					somme.addition(zero);
				}
			
			}
		}
		
		this.entier = somme.entier;
		
	}
	
	public void Diviser(Entier e)
	{
		
	}
	
	// Simule une multiplication par n*10
	public void foisN(int n) {
	if ( n >= 1){
		
			for ( int i = longueur-1-n;i>=0;i--){
				this.entier[i+n] = this.entier[i];	
				this.entier[i] = 0;
			}
		}
	}
	
	//Converti un int en Entier 
	//Utilisé dans la fonction multiplier pour pouvoir multiplier des petits entier entre eux
	public Entier toEntier (int n){
		
		String temp = Integer.toString(n);
		int[] newGuess = new int[temp.length()];
		for (int i = 0; i < temp.length(); i++)
		{
			newGuess[i] = temp.charAt(temp.length() -1- i) - '0';
		}
		boolean negative;
		if ( n > 0)
			 negative = false;
		else 
			negative  =true;
		return new Entier(newGuess,negative);
	}
		
	public boolean superieur(Entier e){
		
	if (!e.negatif  && !this.negatif)
	{

		for ( int i = longueur - 1 ; i>=0 ;i--){

			if (this.entier[i] - e.entier[i] > 0)
			{

				return true;
			}
			if (this.entier[i] - e.entier[i] < 0)
				return false;
		}
		return false;
	}
	if (e.negatif  && this.negatif)
	{
		for ( int i = longueur-1; i>0 ;i--){
			if (this.entier[i] > e.entier[i])
				return false;
			if (this.entier[i] < e.entier[i]);
			return true;
		}
		return true;
	}
	if ( e.negatif && !this.negatif)
		return false;
	if ( !e.negatif && this.negatif)
		return true;
	return true;
	
}
	
	public boolean equal(Entier e)
	{
		if ( this.negatif == e.negatif)
		{
			for ( int i = Integer.max(e.entier.length, this.entier.length)-1; i>=0 ;i--){
				if (this.entier[i] != e.entier[i])
					return false;
			}
		}
		else{
			return false;
		}
		return true;
	}
	
	
	
	
	public void affiche(){
		boolean test = false;
		
		if (this.negatif) 
			System.out.print("-");
		for (int i = longueur-1; i>=0;i--){
			
			if( this.entier[i] != 0)
					test = true;
			if ( i == 0)
				test = true;
			if( test == true)
				System.out.print(this.entier[i]);
		}
		System.out.println("");
	}

}


		

	

