package moteur;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import ressources.Model;
import ressources.Robot;

public class Pane extends JPanel {
	private Model model;
	public Pane(Model model) {
		super();
		this.model=model;
		this.setBackground(Color.WHITE);
	}
	
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawMap(g);
        
        g.setColor(Color.PINK);
        g.fillRect(model.getRobot().getCaseCourante().getPosX()*100, model.getRobot().getCaseCourante().getPosY()*100, 100, 100); //x,y du coin supérieur gauche de la forme puis width et height
        
        g.setColor(Color.BLACK);
        if(model.getRobot().getDirection()==Robot.HAUT) {
        	g.fillRect((model.getRobot().getCaseCourante().getPosX()*100)+50, (model.getRobot().getCaseCourante().getPosY()*100)+50, 1, 50);
        }
        else if(model.getRobot().getDirection()==Robot.BAS) {
        	g.fillRect((model.getRobot().getCaseCourante().getPosX()*100)+50, (model.getRobot().getCaseCourante().getPosY()*100)+50, 1, -50);
        }
        else if(model.getRobot().getDirection()==Robot.DROITE) {
        	g.fillRect((model.getRobot().getCaseCourante().getPosX()*100)+50, (model.getRobot().getCaseCourante().getPosY()*100)+50, 50, 1);
        }
		else if(model.getRobot().getDirection()==Robot.GAUCHE) {
			g.fillRect((model.getRobot().getCaseCourante().getPosX()*100)+50, (model.getRobot().getCaseCourante().getPosY()*100)+50, -50, 1);
		}
    }
	
	public void drawMap(Graphics g){
		for(int i=0;i<model.getRobot().getMap()[0].length;i++) {
			for(int j=0;j<model.getRobot().getMap().length;j++) {
				g.setColor(model.getRobot().getColorFromString(model.getRobot().getMap()[j][i]));
				g.fillRect(i*100, j*100, 100, 100);
			}
		}
		g.setColor(Color.BLACK);
		for(int i=0;i<=model.getRobot().getMap()[0].length;i++) {
			g.fillRect(i*100, 0, 1, 700);
			for(int j=0;j<=model.getRobot().getMap().length;j++) {
				g.fillRect(0, j*100, 500, 1);
			}
		}
	
		
		//(, model.getRobot().getCaseCourante().getPosY(), 40, 80); //x,y du coin supérieur gauche de la forme puis width et height
	}
	
	public void renderGame(){
		repaint();
	}
}

