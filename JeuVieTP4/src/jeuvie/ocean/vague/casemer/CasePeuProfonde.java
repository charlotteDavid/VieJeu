package jeuvie.ocean.vague.casemer;

import jeuvie.Couleur;
import jeuvie.bestiole.Bigorneau;
import jeuvie.bestiole.Dauphin;
import jeuvie.ocean.IOcean;

public class CasePeuProfonde extends Case {

	private static final Couleur CASEVIDE=Couleur.BLEU_SOMBRE;


	public CasePeuProfonde(){
		super();
		//occupant=null;
		//vide=true;

	}

	public CasePeuProfonde(Bigorneau occupant, boolean vide){
		super();
		this.occupant=occupant;
		super.vide=vide;

	}




	protected void setBestioleVivante(){   // visible pour ses descendants éventuel
		occupant=new Bigorneau();		
	}


	 


	@Override
	public String toString() {
		return "CasePeuProfonde :[" + super.toString()+"]"  ;
	}


	public void evoluer(IOcean copie, int iLg, int jCol) {
		int nbVivants=copie.compterVoisinsVivants(jCol,iLg);
		//System.out.println("nbVivants ColonneEau = "+nbVivants);
		
		if( !contientBestioleVivante() && nbVivants==8 || nbVivants==3 ){
			System.out.println("évoluer ColonneEau il est né !!");
			setVivante();
		}
		else if(contientBestioleVivante() && ((nbVivants==1)||(nbVivants>4)  )){
			System.out.println("évoluer ColonneEau il est MORT !!");
			this.tuerEventuelOccupant();
		}	
		
	}
	
	
	
	@Override
	public Couleur getCouleurCaseVide() {		
		return CasePeuProfonde.CASEVIDE;
	}


	public CasePeuProfonde clone(){
		Bigorneau occupant =null;
		if(!this.isVide()){	
			occupant=((Bigorneau)this.occupant).clone();
		}
		return new CasePeuProfonde(occupant,this.vide);
		//creer une variable occupant de type dauphin , verifier si différent de null alors on le clone 


	}
	
	
	
}
