package main;

import moteur.Moteur;
import ressources.Model;

public class Main {
	public static void main(String[] args) {
		Model mod = new Model();
		Moteur m = new Moteur(mod);
		m.run();
		
	}

}

