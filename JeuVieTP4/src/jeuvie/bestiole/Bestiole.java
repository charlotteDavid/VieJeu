package jeuvie.bestiole;
import jeuvie.Couleur;


public abstract class Bestiole implements IBestiole {
	//génerer classe bestiole abstraite depuis le jeuvie Bestiole , cocher abstrait , add Ibestiole



protected Couleur couleur;      
protected boolean vivante=true;   
protected int NUMERO; // liée a la valeur du compteur 
protected static int compteur=1;


protected abstract Couleur getCouleurVivante(); // elle servent que en dessous de la hieracrhie
protected abstract Couleur getCouleurMort();  // retournera la couleur si morte ou vivante  
// retourne un type objet  de type "Couleur." 




	protected Bestiole ( Couleur couleur,int n, boolean vivante){
		super();
		this.couleur=couleur;
		this.vivante=vivante;
		this.NUMERO=n;
		
	}
	
	public  Bestiole(){
		super();
		this.NUMERO= Bestiole.compteur++; // attribut static dou le Bestiole.
		this.couleur=getCouleurVivante();
		
	
	}

	
		public int getNumero() {
			return NUMERO;
		}

		public boolean isVivante() {
			return vivante;
		}

		public Couleur getCouleur() {	
			return couleur;
		}

		public void tuer() {
		couleur=getCouleurMort();
		vivante=false;
		
		}

	}
	
	

