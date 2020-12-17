package ressources;

import moteur.Contenu;

public class Model {
	private Robot rob;
	public Contenu con;	// Contenu contient le contenu interne utile au moteur (l'arret par example);
	
	
	public Model() {
		this.rob = new Robot(new Position(0, 0), new Position(4, 6), this);
		this.con = new Contenu();
	}

	public Robot getRobot() {
		return this.rob;
	}
	
	public Contenu getContenu() {
		return con;
	}
}
