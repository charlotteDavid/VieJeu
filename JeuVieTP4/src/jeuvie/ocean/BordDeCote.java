package jeuvie.ocean;

import java.util.ArrayList;
import java.util.List;

import jeuvie.ocean.vague.ILigneEau;
import jeuvie.ocean.vague.LigneEauProfonde;
import jeuvie.ocean.vague.Vagues;

public class BordDeCote extends Ocean {

	private static final int NB_COLONNES=95;
	private static final int NB_LIGNES=70;
	
	
	public BordDeCote(int forme) {
		super(forme);
	
	}

	public BordDeCote(List<ILigneEau> grille) {
		super(grille);
		
	}

	public void remplirDeLignesEau() {
		for (int i = 0; i < NB_LIGNES; i++) {	
			grille.add(new Vagues(NB_COLONNES,true));
				
		}		
	}

	public int getNbLignes() {
		return NB_LIGNES;
	}


	public BordDeCote clone(){
		List<ILigneEau> oceanClone = new ArrayList <ILigneEau>();
		for (ILigneEau iLigneEau : this.grille) {
			oceanClone.add(((Vagues)iLigneEau).clone());						
		}
		return new BordDeCote(oceanClone);
				
	}
	
	
	
}
