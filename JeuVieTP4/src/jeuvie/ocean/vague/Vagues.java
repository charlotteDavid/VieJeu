package jeuvie.ocean.vague;

import java.util.List;

import jeuvie.ocean.vague.casemer.CasePeuProfonde;
import jeuvie.ocean.vague.casemer.ColonneEau;
import jeuvie.ocean.vague.casemer.ICase;

public class Vagues extends LigneEau {

	

	public Vagues(int taille, boolean prevoirLesCasesVides) {
		super(taille, prevoirLesCasesVides);
	}

	
	public Vagues(List<ICase> lesCasesClones){
		super(lesCasesClones);	
	}


	@Override
	public void remplirLesCasesVides(){
	for(int i = 0; i <NB_COLONNES; i++) {		
	

		super.lesCases.add(new CasePeuProfonde());
	}
	}




	public Vagues clone(){
		Vagues leClone = new Vagues(NB_COLONNES, false);
		for (ICase iCase :this.lesCases) {  //icase= une case	
			leClone.add(((CasePeuProfonde) iCase).clone());
		}
		return leClone;
	
	
	
	
	
	
	
	}


	@Override
	protected void prevoirLesCasesVides() {
		// TODO Auto-generated method stub
		
	}	
}
