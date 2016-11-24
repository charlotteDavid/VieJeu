package jeuvie.ocean.vague;

import java.util.ArrayList;
import java.util.List;

import jeuvie.ocean.vague.casemer.Case;
import jeuvie.ocean.vague.casemer.ICase;

public abstract class LigneEau implements ILigneEau {
	
	
	public abstract void remplirLesCasesVides();	
	protected abstract void prevoirLesCasesVides();
	 
	protected List<ICase> lesCases;
	
	protected final int NB_COLONNES ;
	
	
	
	
	protected LigneEau(int taille, boolean prevoirLesCasesVides){
		super();
		NB_COLONNES=taille;
		//tableau vide pour les case  taille case 
		this.lesCases= new ArrayList<ICase> (taille);
		if (prevoirLesCasesVides){  //=true sousentendu
			remplirLesCasesVides(); 
		}
		  // si boolean prevoircasevide = true alors on remplir les cases vides
		
			
	}
	
	
	
	public LigneEau(List<ICase> lesCasesClones) {
		lesCases=lesCasesClones;
		NB_COLONNES=lesCasesClones.size();
	}


	public ICase get(int i) {
		return lesCases.get(i);
	}

	public int getNbColonnes() {
		return NB_COLONNES;
	}



	public boolean add(ICase cases){
		return lesCases.add(cases);
	}

	
	
}

