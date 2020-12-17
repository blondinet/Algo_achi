package moteur;

public class Contenu {
	public boolean run = false;
	public Contenu() {
		
	}
	public void start() {
		this.run = true;
	}
	public void stop() {
		this.run = false;
	}
	public boolean getRun() {
		return this.run;
	}
}
