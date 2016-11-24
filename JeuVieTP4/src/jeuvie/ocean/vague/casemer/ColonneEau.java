package jeuvie.ocean.vague.casemer;

import jeuvie.Couleur;
import jeuvie.bestiole.Dauphin;
import jeuvie.bestiole.IBestiole;
import jeuvie.ocean.IOcean;

public class ColonneEau extends Case{

	private static final Couleur CASEVIDE=Couleur.BLEU_SOMBRE;


	public ColonneEau(){
		super();
		//occupant=null;
		//vide=true;

	}

	public ColonneEau(Dauphin occupant, boolean vide){
		super();
		this.occupant=occupant;
		super.vide=vide;

	}




	protected void setBestioleVivante(){   // visible pour ses descendants éventuel
		occupant=new Dauphin();		
	}


	
	
	

	 


	@Override
	public String toString() {
		return "ColonneEau :[" + super.toString()+"]"  ;
	}


	public void evoluer(IOcean copie, int iLg, int jCol) {
		int nbVivants=copie.compterVoisinsVivants(jCol,iLg);
		//System.out.println("nbVivants ColonneEau = "+nbVivants);
		
		if( !contientBestioleVivante() && nbVivants==3 ){
			//System.out.println("évoluer ColonneEau il est né !!");
			setVivante();
		}
		else if(contientBestioleVivante() && (nbVivants>3 || nbVivants<2)){
			//System.out.println("évoluer ColonneEau il est MORT !!");
			this.tuerEventuelOccupant();
		}	
		
	}
	
	
	
	@Override
	public Couleur getCouleurCaseVide() {		
		return ColonneEau.CASEVIDE;
	}


	public ColonneEau clone(){
		Dauphin occupant =null;
		if(!this.isVide()){	
			occupant=((Dauphin)this.occupant).clone();
		}
		return new ColonneEau(occupant,this.vide);
		//creer une variable occupant de type dauphin , verifier si différent de null alors on le clone 


	}





}
