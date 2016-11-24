package jeuvie.bestiole;

import jeuvie.Couleur;

public class Bigorneau extends Bestiole{

	private static final Couleur MORT=Couleur.GRIS_CLAIR;
	private static final Couleur VIVANT= Couleur.NOIR;

	
	
	public Bigorneau(){
		super();
		this.NUMERO= Bestiole.compteur++; // attribut static dou le Bestiole.
		couleur=getCouleurVivante();


	}
	protected Bigorneau(Couleur couleur, int n, boolean vivante){
		super(couleur,n,vivante);

	}
	@Override
	public String toString() {

		return "Bigorneau : "+" Couleur= "+ couleur+" Numero = "+  NUMERO +" Vivante ="+ vivante;
	}
	public Couleur getCouleurVivante() {
		return VIVANT;
	}
	public Couleur getCouleurMort() {

		return MORT;
	}
	
	public Bigorneau clone(){
		return new Bigorneau(this.couleur,this.NUMERO,this.vivante);
		
	}
	
}
		
	
	
	
	
	
	
	
	
	

