package jeuvie.ocean;

import java.util.ArrayList;
import java.util.List;

import jeuvie.ocean.vague.ILigneEau;
import jeuvie.ocean.vague.LigneEauProfonde;
import jeuvie.ocean.vague.casemer.ColonneEau;
import jeuvie.ocean.vague.casemer.ICase;

public class HauteMer extends Ocean {
	
	private static final int NB_COLONNES=55;
	private static final int NB_LIGNES=60;
	
	
	public HauteMer(int forme) {
		super(forme);
	
	}

	public HauteMer(List<ILigneEau> grille) {
		super(grille);
		
	}

	public void remplirDeLignesEau() {
		for (int i = 0; i < NB_LIGNES; i++) {	
			grille.add(new LigneEauProfonde(NB_COLONNES,true));
				
		}		
	}

	public int getNbLignes() {
		return NB_LIGNES;
	}


	public HauteMer clone(){
		List<ILigneEau> oceanClone = new ArrayList <ILigneEau>();
		for (ILigneEau iLigneEau : this.grille) {
			oceanClone.add(((LigneEauProfonde)iLigneEau).clone());						
		}
		return new HauteMer(oceanClone);
				
	}
	
	
}
