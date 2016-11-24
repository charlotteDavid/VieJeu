package jeuvie.ocean;

import java.util.ArrayList;
import java.util.List;

import jeuvie.ocean.vague.ILigneEau;
import jeuvie.ocean.vague.LigneEau;
import jeuvie.ocean.vague.LigneEauProfonde;
import jeuvie.ocean.vague.casemer.Case;
import jeuvie.ocean.vague.casemer.ColonneEau;
import jeuvie.ocean.vague.casemer.ICase;

public abstract class Ocean implements IOcean {

	public static final int CLOWN = 1;
	public static final int CANON = 2;
	public static final int PETIT_VAISSEAU = 3;
	public static final int GRAND_VAISSEAU = 4;
	public static final int PI = 5;
	public static final int ALEA = 6;
	public static final int BARRE = 7;
	private static final int i = 0;

	public abstract void remplirDeLignesEau();

	protected List<ILigneEau> grille = new ArrayList<ILigneEau>();

	protected abstract Ocean clone();

	protected Ocean(List<ILigneEau>grille){
		this.grille = grille;
	}

	public Ocean(int forme){
		grille=new ArrayList<ILigneEau>(getNbLignes());
		remplirDeLignesEau();
		creerFormeDeVie(forme);
	}


	public ILigneEau get(int i) {
		return grille.get(i);
	}


	public int getNbColonnes() {
		int rep=0;
		if(!this.grille.isEmpty()){
			rep= grille.get(0).getNbColonnes();
		}
		// taille de la 1ere ligne
		return rep;
	}


	private void setBestiole(int iLg, int jCol){
		grille.get(iLg).get(jCol).setVivante();			
	}

	public void etapeSuivante(){
		Ocean copie = this.clone();

		for (int ligne = 0; ligne < getNbLignes(); ligne++) {
			ILigneEau iLigneEau = this.get(ligne);
			for (int colonne = 0; colonne < getNbColonnes(); colonne++) {
				iLigneEau.get(colonne).evoluer(copie, ligne, colonne);
			}
		}



	}
	
	//2 boucles for à la case on fait evoluer

	// appeler le 1er clone : dauphin
	//T retourn   fais evoluer l'ocean , this.clone modifier le this. evoluer
	
	

	public int compterVoisinsVivants(int col, int ligne) {
		/*int nbVivants = 0;
		if (grille.get(i-1).get(j-1).contientBestioleVivante()){
			nbVivants++;
		}
		if(grille.get(i-1).get(j).contientBestioleVivante()){
			nbVivants++;
		}
		if(grille.get(i-1).get(j).contientBestioleVivante()){
			nbVivants++;
		}	
		if(grille.get(i-1).get(j+1).contientBestioleVivante()){
			nbVivants++;
		}	
		if(grille.get(i).get(j+1).contientBestioleVivante()){
			nbVivants++;
		}
		if(grille.get(i+1).get(j+1).contientBestioleVivante()){
			nbVivants++;
		}
		if(grille.get(i+1).get(j).contientBestioleVivante()){
			nbVivants++;
		}
		if(grille.get(i).get(j-1).contientBestioleVivante()){
			nbVivants++;
		}
		 */
		int colDeb=col-1;
		int colFin=col+1;
		int ligneDeb= ligne-1;
		int ligneFin= ligne+1;

		//System.out.println(col+" "+ligne);
		if (col==0){
			colDeb=0;
			}
		if(col==this.getNbColonnes()-1){
			colFin=col;
			}

		if (ligne==0){
			ligneDeb=0;
			}

		if(ligne==this.getNbLignes()-1){
			ligneFin=ligne;
			}	

		int nbVivants =0;
		int boucle=0;
		for (int l = ligneDeb; l <= ligneFin; l++) {
			ILigneEau ligneCourante= this.get(l);
			for (int k = colDeb; k <= colFin; k++) {
				boucle++;
				if((l!=ligne)||(k!=col)){
					ICase laCase =ligneCourante.get(k);
					if(laCase.contientBestioleVivante()){
						nbVivants++;
					}

				}
			}
		}

		//TODO à ôter
		/*if (boucle==8) {
			System.out.println(boucle);
		}
		if (nbVivants>3) {
			System.out.println("Ocean : compterVOisins plus de deux voisins = "+nbVivants+" boucle = "+boucle);
		}*/

		return nbVivants;

	}

	protected void creerFormeDeVie(int forme){

		final int BASE_X = 25;
		final int BASE_Y = 25;

		switch (forme) {
		case PETIT_VAISSEAU:
			for (int i = 0; i < getNbLignes()/7; i++) {
				int delta=i*7+3;
				setBestiole(3, delta);
				setBestiole(4, delta+1);
				setBestiole(2, delta+2); setBestiole(3, delta+2); setBestiole(4, delta+2);
			}
			break;
		case GRAND_VAISSEAU:
			for (int i = 0; i < getNbLignes()/9; i++) {
				int delta=i*9+3;
				setBestiole(2, delta);setBestiole(5, delta);
				setBestiole(6, delta+1);
				setBestiole(2, delta+2); setBestiole(6, delta+2);
				setBestiole(3, delta+3);setBestiole(4, delta+3);setBestiole(5, delta+3);setBestiole(6, delta+3);
			}

			break;
		case PI:
			for (int i = 0; i < (getNbLignes()/47); i++) {
				int delta= i*47 + BASE_Y;
				setBestiole(BASE_X, delta+3);
				setBestiole(BASE_X-1, delta+2);setBestiole(BASE_X+1, delta+2);
				setBestiole(BASE_X-1, delta+1);setBestiole(BASE_X+1, delta+1);
				setBestiole(BASE_X-1, delta);setBestiole(BASE_X+1, delta);
			}
			break;
		case CLOWN:

			// ligne haute
			setBestiole(BASE_X, BASE_Y); 			setBestiole(BASE_X+1, BASE_Y); 			setBestiole(BASE_X+2, BASE_Y);

			// deux barres parallèles
			setBestiole(BASE_X, BASE_Y+1);			setBestiole(BASE_X+2, BASE_Y+1);
			setBestiole(BASE_X, BASE_Y+2); 			setBestiole(BASE_X+2, BASE_Y+2);
			break;
		case BARRE:
			// ligne haute			
			setBestiole(BASE_X, BASE_Y); 			setBestiole(BASE_X+1, BASE_Y);	setBestiole(BASE_X-1, BASE_Y);

			break;
		case CANON:
			// le canon à planneur
			// carré gauche
			setBestiole(2, 10);setBestiole(3, 10);
			setBestiole(2, 11);setBestiole(3, 11);

			// carré droit

			// carré droit
			setBestiole(36, 8);setBestiole(37, 8);
			setBestiole(36, 9);setBestiole(37, 9);


			//flèche gauche
			setBestiole(14, 8);setBestiole(15, 8);
			setBestiole(13, 9);setBestiole(17, 9);
			setBestiole(12, 10); setBestiole(18, 10);
			setBestiole(12, 11);setBestiole(16, 11);setBestiole(18, 11);setBestiole(19, 11);
			setBestiole(12, 12);setBestiole(18, 12);
			setBestiole(13, 13); setBestiole(17, 13);
			setBestiole(14, 14);setBestiole(15, 14);

			//flèche droite
			setBestiole(26, 6);
			setBestiole(24, 7);setBestiole(26, 7);
			setBestiole(22, 8);setBestiole(23, 8);
			setBestiole(22, 9);setBestiole(23, 9);
			setBestiole(22, 10);setBestiole(23, 10);
			setBestiole(24, 11);setBestiole(26, 11);
			setBestiole(26, 12);

			break;

		default: creerDeLaVieAleatoirement();
		break;
		}

	}

	private void creerDeLaVieAleatoirement() {
		for (int jLg = 0; jLg < getNbLignes(); jLg++) {
			ILigneEau ligne = get(jLg);
			for (int iCol = 0; iCol < ligne.getNbColonnes(); iCol++) {
				double alea = Math.random();
				if (alea<0.2) {
					setBestiole(jLg, iCol);
				}
			}
		}
	}


}
