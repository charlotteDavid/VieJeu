package jeuvie.bestiole;

import jeuvie.Couleur;

public class Dauphin extends Bestiole {

	private static final Couleur MORT = Couleur.BLEU_MARINE; 
	private static final Couleur VIVANT = Couleur.BLEU_GRIS;


	public Dauphin(){
		super();
		this.NUMERO= Bestiole.compteur++; // attribut static dou le Bestiole.
		couleur=getCouleurVivante();


	}
	protected Dauphin(Couleur couleur, int n, boolean vivante){
		//super();
		//super.NUMERO=n;
		//super.vivante=vivante;
		//super.couleur=couleur;
		//ou
		super(couleur,n,vivante);


	}
	@Override
	public String toString() {

		return "Dauphin : "+" Couleur= "+ couleur+" Numero = "+  NUMERO +" Vivante ="+ vivante;
	}
	@Override
	public Couleur getCouleurVivante() {

		return VIVANT;
	}
	@Override
	public Couleur getCouleurMort() {

		return MORT;
	}
	
	public Dauphin clone(){
		return new Dauphin(this.couleur,this.NUMERO,this.vivante);
		
	}
	
}
