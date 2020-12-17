package moteur;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class GUI extends JFrame {
    final int FRAME_HEIGHT = 1000;
    final int FRAME_WIDTH = 1000;
   
    public GUI(Pane p) {
    	this.setTitle("Ma premi�re fen�tre Java");
        this.setSize(520, 750);
        this.setLocationRelativeTo(null);              
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
       
        this.setContentPane(p);
        this.setVisible(true);
    	

        

        // taille et position
    
        //f.setLocationRelativeTo(null); // la fen�tre est centr�e � l'�cran
        // rendre la fen�tre visible, pack fait en sorte que tous les composants de l'application soient �
        // leur preferredSize, ou au dessus
        //
       
        
    }
}
