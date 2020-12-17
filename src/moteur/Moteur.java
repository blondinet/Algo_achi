package moteur;
import ressources.Model;

public class Moteur {
	private final static double FPS = 60.00;
	private final static double TICK = 10000000;
	
	private double ns = 1000000000 / FPS;
	private double start;
	private double last;
	private double timerTick;
	private int nbIterationMinute;
	
	private long timer = System.currentTimeMillis();
	
	private Model model;
	private GUI gui;
	public int count=0;
	
	private Pane pan;
	
	/**
	 * Constructeur du moteur
	 * Contient le nombre d'iteration, la variable de test du 1/60 de seconde, le contenu 
	 * Le constructeur lance le moteur
	 */
	public Moteur(Model mod) { 
		this.model=mod;
		this.nbIterationMinute=0;
		this.last=System.currentTimeMillis();
		
		model.getContenu().start();
		pan = new Pane(this.model);
		gui = new GUI(pan);
	}
	
	/**
	 * Moteur de la simulation
	 */
	public void run() {
		// Tant que le contenu souhaite executer la boucle
		while(this.model.getContenu().getRun()) {
			// on test si 1/60 d'une seconde est passé
			start = System.nanoTime();
			
			if((System.nanoTime()-timerTick)>=TICK) {
				timerTick=System.nanoTime();
				this.updateGame();
			}
			
			if((start - last)>=this.ns) {
				// Remise à zero le compteur, on affiche une frame et on compte la frame
				last = System.nanoTime();
				repaint();
				this.nbIterationMinute++;
			}
			
			
			// Test si une seconde c'est déroulé
			if(System.currentTimeMillis() - timer > 1000) {
				// Remise à zero pour une nouvelle seconde, affichage du nombre de fps et remise à zero
				timer += 1000;
				System.out.println(this.nbIterationMinute);
				this.nbIterationMinute = 0;
			    //updates = 0;
			}
		}	
		System.out.println("Merci d'avoir joué");
		System.exit(0);
	}
	
	
	
	public void updateGame(){
		if(count++ >=100) {
			this.model.getRobot().update();
			count=0;
			
			
		}
	}
	
	public void repaint() {
		this.pan.renderGame();
		System.out.print(this.model.getRobot().getCaseCourante().getPosX());
		System.out.println(" : "+this.model.getRobot().getCaseCourante().getPosY());
		/*for(String[] tabS : this.model.getRobot().getMap()){
			for(String s : tabS) {
				System.out.print(s+" : ");
			}
			System.out.println();
		}*/
	}
}
