package jeuvie;

import java.util.ArrayList;
import java.util.List;

import controleur.Controleur;
import jeuvie.bestiole.Bestiole;
import jeuvie.bestiole.Dauphin;
import jeuvie.bestiole.IBestiole;
import jeuvie.ocean.BordDeCote;
import jeuvie.ocean.HauteMer;
import jeuvie.ocean.Ocean;
import jeuvie.ocean.vague.casemer.Case;
import jeuvie.ocean.vague.casemer.ColonneEau;


public class JeuVie {

	public static void main(String[] args) {

		/*			List<IBestiole>liste =new ArrayList<IBestiole>(10)	;
		for (int i = 0; i < 10; i++) {
		   // Dauphin kiki=new Dauphin();
		   IBestiole kiki = new Dauphin();
			if(i%2==0){
				kiki.tuer();				
			}
			liste.add(kiki);



			Case casevide= new ColonneEau();
			System.out.println(casevide);
			Case caseremplie= new ColonneEau((Dauphin) kiki,false);
			System.out.println(caseremplie);



		}
			}
		 */

		new Controleur(new BordDeCote(Ocean.PI));
		//new Controleur(new HauteMer(Ocean.ALEA));
		//new Controleur(new HauteMer(Ocean.BARRE));
		//new Controleur(new HauteMer(Ocean.CANON));
		//new Controleur(new HauteMer(Ocean.CLOWN), Controleur.ITER_CLOWN);
		//new Controleur(new HauteMer(Ocean.PI), Controleur.ITER_PI);
		//new Controleur(new HauteMer(Ocean.GRAND_VAISSEAU));
		//new Controleur(new HauteMer(Ocean.PETIT_VAISSEAU));

	}

}














