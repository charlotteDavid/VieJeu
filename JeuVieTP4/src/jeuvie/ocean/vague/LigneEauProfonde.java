package jeuvie.ocean.vague;

import java.util.List;

import jeuvie.ocean.vague.casemer.ColonneEau;
import jeuvie.ocean.vague.casemer.ICase;

public class LigneEauProfonde extends LigneEau {


	public LigneEauProfonde(int taille, boolean prevoirLesCasesVides) {
		super(taille, prevoirLesCasesVides);
	}

	
	public LigneEauProfonde(List<ICase> lesCasesClones){
		super(lesCasesClones);	
	}


	@Override
	public void remplirLesCasesVides(){
	for(int i = 0; i <NB_COLONNES; i++) {		
	

		super.lesCases.add(new ColonneEau());
	}
	}




	public LigneEauProfonde clone(){
		LigneEauProfonde leClone = new LigneEauProfonde(NB_COLONNES, false);
		for (ICase iCase :this.lesCases) {  //icase= une case	
			leClone.add(((ColonneEau) iCase).clone());
		}
		return leClone;

		//creer liste de caseclone   for each pour chaque case qu'on parcours on clone la case 
		// et on l'ajoute dans la nouvelles liste de clone case


		//   un autre constructeur qui demande une liste de cases - come les cases- 

}


	@Override
	protected void prevoirLesCasesVides() {
		// TODO Auto-generated method stub
		
	}
	
	
}