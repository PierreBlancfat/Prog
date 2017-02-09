
public class Rationnel {
	
	private int numerateur;
	private int denominateur;
	
	public int getNumerateur() {
		return numerateur;
	}
	public void setNumerateur(int numerateur) {
		this.numerateur = numerateur;
	}
	public int getDenominateur() {
		return denominateur;
	}
	public void setDenominateur(int denominateur) {
		this.denominateur = denominateur;
	}
	
	public Rationnel(int num ,int den){
		this.denominateur = den;
		this.numerateur = num;
	}
	
	public void afficher(){
		System.out.println(""+this.numerateur+" / "+this.denominateur);
	}
	
	public float valeur_approx(){
		return (float)this.numerateur/this.denominateur;
	}
	
	public int pgcd(int a, int b)
	{
	  int r;
	  while (b != 0)
	    {
	      r = a%b;
	      a = b;
	      b = r;
	    }
	  return a;
	}
	
	public void simplifie(){
		
		if ( pgcd(this.numerateur,this.denominateur) != 1){
			int tmp = this.numerateur;
			this.numerateur = this.numerateur / pgcd(this.numerateur,this.denominateur);
			this.denominateur = this.denominateur / pgcd(tmp,this.denominateur);
		}	
	}
	

	public void ajouter(int n){
		this.numerateur =  this.numerateur + n*this.denominateur;
	}
	
	public void ajouter(Rationnel r ){
		
		if ( this.denominateur != r.denominateur)
		{
			
			this.numerateur = (this.numerateur *r.denominateur) + (r.numerateur * this.denominateur);
			this.denominateur = this.denominateur * r.denominateur;
		}
		else
			
			this.numerateur = this.numerateur + r.numerateur;
		 this.simplifie();
		
	}
	
	public void soustraire(int n){
		this.numerateur = this.numerateur - n*this.denominateur;
	}
	
	public void soustraire(Rationnel r ){
		
		if ( this.denominateur != r.denominateur)
		{
			this.numerateur = (this.numerateur *r.denominateur) - (r.numerateur * this.denominateur);
			this.denominateur = this.denominateur * r.denominateur;
		}
		else
		    this.numerateur = this.numerateur - r.numerateur;
		
		this.simplifie();
	 
	}
	
	public void multiplier(int n ){
		this.numerateur = this.numerateur * n;
	}
	
	public void multiplier(Rationnel r){
		this.numerateur = this.numerateur * r.numerateur;
		this.denominateur = this.denominateur * r.denominateur;
	}
	
	public void diviser( int n ){
		this.denominateur = this.denominateur * n;
	}
	public void diviser( Rationnel r ){
		Rationnel r2 = new Rationnel(r.denominateur,r.numerateur);
		this.multiplier(r2);
	}
}
