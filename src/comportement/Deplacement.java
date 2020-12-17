package comportement;

import java.util.ArrayList;

import ressources.*;

public class Deplacement {

	private ArrayList<Position> listPosCheminGoal = new ArrayList<Position>();
	private Robot robot;
	
	/**
	 * @Modification Xavier Jacob--Guizon
	 * @param r le robot dont on cherche les chemins
	 */
	public Deplacement(Robot r) {
		this.robot = r;
	}
	
	/**
	 * Fonction qui cherche le chemin et le stock dans listPosCheminGoal
	 * @Modification Xavier Jacob--Guizon
	 * @return ArrayList le chemin 
	 */
	public ArrayList rechercheChemin() {
		ArrayList<Position> list = new ArrayList<Position>();
		Position posCourante = new Position(this.robot.getCaseCourante().getPosX(),this.robot.getCaseCourante().getPosY());
		Position goal = this.robot.getCaseGoal();
		
		
		// On recherche le chemin en y (en longeur)
		while(posCourante.getPosY() > goal.getPosY()) {
			list.add(new Position(posCourante));
			posCourante.setPosY(posCourante.getPosY()-1);
		}
		while(posCourante.getPosY() < goal.getPosY()) {
			list.add(new Position(posCourante));
			posCourante.setPosY(posCourante.getPosY()+1);
		}
		
		// On recherche le chemin en x (en largeur)
		while(posCourante.getPosX() > goal.getPosX()) {
			list.add(new Position(posCourante));
			posCourante.setPosX(posCourante.getPosX()-1);
			
		}
		while(posCourante.getPosX() < goal.getPosX()) {
			list.add(new Position(posCourante));
			posCourante.setPosX(posCourante.getPosX()+1);
			//System.out.print(posCourante);
		}
		list.add(goal);
		
		return list;
	}
	
	
	
	/**
	 * Fonction qui analyse le tableau et 
	 * la position du robot ainsi que la position futur du robot 
	 * et retour si c'est possible de s'y déplacer
	 * @return boolean deplacment possible
	 */
	public boolean previsionDeplacement() {
		return false;
		//Le robot à un argument de case courante
		//Le robot à un argument de case futur
		//Le robot à un argument de case goal
		//Le robot à la taille d'une case et d'une ligne
		
		
		
	}
	
	/**
	 * methode qui prend en parametre une liste et fait ce déplacer le robot par rapport aux position de la liste
	 * @Modification Xavier Jacob--Guizon
	 */
	public void deplacementList(Position pos) {
		
		
		if(!this.robot.getCaseCourante().estCase(pos)) {
			if(this.robot.getCaseCourante().getPosX() < pos.getPosX()) {
				//tourner le robot pour la bonne position
				
				if(this.robot.getDirection()!=this.robot.DROITE) {
					while(this.robot.getDirection()!=this.robot.DROITE) {
						this.tournerDir(this.robot.DROITE);
					}
				}
				else {
					this.robot.avanceUneCase();
				}
				//System.out.println("droite");

			
				//System.out.println("droiteAvance");
				
				//System.out.println("droiteAvanceEffect");
				
			}else if(this.robot.getCaseCourante().getPosX() > pos.getPosX()) {
				if(this.robot.getDirection()!=this.robot.GAUCHE) {
					while(this.robot.getDirection()!=this.robot.GAUCHE) {
						this.tournerDir(this.robot.GAUCHE);
					}
				}
				else {
					this.robot.avanceUneCase();
				}
				//System.out.println("gauche");
				
				
				//System.out.println("gaucheAvance");
				
				
				//System.out.println("gaucheAvanceEffect");
			}
			else if(this.robot.getCaseCourante().getPosY() < pos.getPosY()) {
				if(this.robot.getDirection()!=this.robot.HAUT) {
					while(this.robot.getDirection()!=this.robot.HAUT) {
						this.tournerDir(this.robot.HAUT);
					}
				}
				else {
					this.robot.avanceUneCase();
				}
				//System.out.println("Haut");
				
				//System.out.println("HautAvance");
				
				
				//System.out.println("HautAvanceEffect");
				
				
			}else if(this.robot.getCaseCourante().getPosY() > pos.getPosY()) {
				if(this.robot.getDirection()!=this.robot.BAS) {
					while(this.robot.getDirection()!=this.robot.BAS) {
						this.tournerDir(this.robot.BAS);
					}
				}
				else {
					this.robot.avanceUneCase();
				}
			}
			
		}
		
	}
	
	/**
	 * méthode qui fait tourner le robot jusqu'a ce qu'il soit dans la bonne direction
	 */
	public void tournerDir(int dir) {
		int directionRobot = this.robot.getDirection();
		
		int[] listDir ={this.robot.HAUT, this.robot.DROITE, this.robot.BAS, this.robot.GAUCHE};
		
		for(int i =0;i<=listDir.length-1;i++) {
			
			if(directionRobot == listDir[i]) {
				
				if(i==listDir.length-1) {
					if(dir == listDir[i-1]) {
						this.robot.tournerRobotAngleDroit(false);
						
						
					}else if(dir == listDir[0]) {
						this.robot.tournerRobotAngleDroit(true);
						
					}else {this.robot.tournerRobotAngleDroit(true);} // si le robot est a plus de deux case de la direction voulu, on tourne à droite
			
				}else if(i==0) {
					if(dir == listDir[listDir.length-1]) {
						this.robot.tournerRobotAngleDroit(false);
						
						
					}else if(dir == listDir[i+1]) {
						this.robot.tournerRobotAngleDroit(true);
						
					}else {this.robot.tournerRobotAngleDroit(true);} // si le robot est a plus de deux case de la direction voulu, on tourne à droite
			
					
				}else{
					if(dir == listDir[i-1]) {
						this.robot.tournerRobotAngleDroit(false);
						
					}else if(dir == listDir[i+1]) {
						this.robot.tournerRobotAngleDroit(true);
						
					}else {this.robot.tournerRobotAngleDroit(true);} // si le robot est a plus de deux case de la direction voulu, on tourne à droite
				}
				break;
			}
		}
		//if(dir != this.robot.getDirection()) {
			
		//}
	}
	
	/**
	 * fonction qui test si la case correspond à la carte qu'on à fourni au robot
	 */
	//public 
}
