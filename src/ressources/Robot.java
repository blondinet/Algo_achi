package ressources;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;

import comportement.Deplacement;
import ressources.Position;

public class Robot {
	// fonctionnement du robot
	private String[][] tableauCouleurInitial = new String [7][5] ;
	// Tableau des correspondance, l'entier de la place de la couleur égale la couleur
	private String[] tableauCorrespondanceColorInt = { "Rouge", "Bleu", "Vert", "Orange", "Blanc" };
	private HashMap<String, Color> tabColor = new HashMap<String, Color>();
	
	
	public static final int HAUT 	= 8; //etre droit dans la longueur du plateau (le 7)
	public static final int BAS		= 5;
	public static final int DROITE  = 6;
	public static final int GAUCHE  = 4; // etre vers le bas du tableau ( voir le tableau des couleurs);

	private final int[] tabDirection = {HAUT, DROITE, BAS, GAUCHE};
	private Deplacement cerveau;
	ArrayList<Position> listPositionGoal; 
	
	// La postion inital du robot
	private Position posCourante;
	private Position posGoal;
	private int direction = 0;
	private Model model;
	
	public Robot(Position pos1, Position pos2, Model m) {
		this.model = m;
		this.initMapColorInitial();
		posCourante = pos1;
		posGoal = pos2;
		
		cerveau = new Deplacement(this);
		deplacementRobotToGoal();
		
		tabColor.put("Rouge", Color.RED);
		tabColor.put("Bleu", Color.BLUE);
		tabColor.put("Vert", Color.GREEN);
		tabColor.put("Orange", Color.ORANGE);
		tabColor.put("Blanc", Color.WHITE);
		
	}
	
	public void deplacementRobotToGoal() {
		//System.out.println(cerveau.rechercheChemin());
		listPositionGoal = cerveau.rechercheChemin();
		
	}
	
	public Color getColorFromString(String c) {
		return tabColor.get(c);
	}
	
	public void update() {
		// tournerRobotAngleDroit(true);
		// avanceUneCase();
		if(listPositionGoal.size()>0) {
			cerveau.deplacementList(listPositionGoal.get(0));
			listPositionGoal.remove(0);
		}
		else {
			this.model.getContenu().stop();
		}
	}
	
	/**
	 * Tableau qui initiale la carte des couleurs (triche) Il utilise la carte de
	 * tabString et traduit l'entier avec le tableau de correspondance des couleurs
	 * avec l'incrementeur en l'incorporant à la position
	 */
	public void initMapColorInitial() {

		int[] tabString = { 0, 2, 1, 1, 1,
				1, 2, 2, 2, 1, 
				1, 2, 3, 3, 1, 
				1, 2, 4, 2, 1, 
				1, 3, 1, 2, 1, 
				1, 3, 2, 2, 0, 
				1, 1, 1, 1, 1 
				};
		int incrementeur = 0;
		//tableauCouleurInitial[0][0] = tableauCorrespondanceColorInt[tabString[incrementeur]];

		for (int i = 0; i <= 6; i++) {
			for (int j = 0; j <= 4; j++) {
				try {
					tableauCouleurInitial[i][j] = tableauCorrespondanceColorInt[tabString[incrementeur++]];
					//System.out.println(incrementeur);
				}catch (Exception e) {
					System.out.println(e);
				}
			}
		}

	}
	
	public String[][] getMap() {
		return tableauCouleurInitial;
	}
	
	public void avanceUneCase() {
		switch(tabDirection[this.direction]) {
			case HAUT:
				this.posCourante.moveY(1);
				break;
			case BAS:
				this.posCourante.moveY(-1);
				break;
			case DROITE:
				this.posCourante.moveX(1);
				break;
			case GAUCHE:
				this.posCourante.moveX(-1);
				break;
		}
	}
	
	public void tournerRobotAngleDroit(boolean dir) {
		if(dir) {
			if(this.direction !=3) {this.direction++;}
			else {this.direction=0;}
		}
		else {
			if(this.direction != 0) {this.direction--;}
			else {this.direction=3;}
		}
	}
	
	public int getDirection() {
		return tabDirection[this.direction];
	}
	public void setDirection(int dir) {
		this.direction=dir;
	}
	
	
	
	/**
	* Fonction qui renvoie la case Objectif du robot
	* 
	* @Modification Xavier Jacob--Guizon
	*/
	public Position getCaseGoal(){
		return posGoal;
	}
	
	/**
	* Fonction qui permet de changer la  la case Objectif du robot
	* 
	* @Modification Xavier Jacob--Guizon
	*/
	public void setCaseGoal(Position g){
		this.posGoal=g;
	}
	
	/**
	* Fonction qui renvoie la case courante du robot
	* 
	* @Modification Xavier Jacob--Guizon
	*/
	public Position getCaseCourante(){
		return posCourante;
	}

	/**
	* Fonction qui permet de modifier la case courante du robot
	* 
	* @Modification Xavier Jacob--Guizon
	*/
	public void setCaseCourante(Position c){
		this.posCourante=c;
	}
	
}
