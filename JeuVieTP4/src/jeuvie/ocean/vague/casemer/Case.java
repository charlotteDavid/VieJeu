package jeuvie.ocean.vague.casemer;

import jeuvie.Couleur;
import jeuvie.bestiole.IBestiole;
import jeuvie.ocean.IOcean;

public abstract class Case implements ICase {


	public boolean vide=true;                     
	protected IBestiole occupant = null;

	protected abstract void setBestioleVivante();
	public abstract Couleur getCouleurCaseVide();  // retourne une couleur



	public void setVivante() {
		setBestioleVivante();
		this.vide=false;

	}



	public boolean contientBestioleVivante(){
		//boolean rep=false;
		//if (this.occupant!=null){
		//	rep=this.occupant.isVivante();
		//}			
		//return rep;
		return !vide && occupant.isVivante();
	}


	//public void contientBestioleVivante() { // methode pour mettre une bestiole - set : modifier les attributs de classe
	//	this.vide=false;       // la case n'est pas vide vu qu'on met une bestiole
	//	setBestioleVivante();  
	//}

	public Couleur getCouleur() {	
		Couleur rep;
		if(occupant==null){
			rep=getCouleurCaseVide();
		}
		else {
			rep=occupant.getCouleur();
		}
		return rep ;
	}


	public boolean isVide() {
		return vide;
	}

	public IBestiole getOccupant() {	
		return occupant;
	}

	public void tuerEventuelOccupant() {
		if(!vide){
			occupant.tuer();
		}
	}
	@Override
	public String toString() {

		return "Vide = " + vide + ", occupant = " + occupant + ", Couleur = " +this.getCouleur() ;

	}


}
