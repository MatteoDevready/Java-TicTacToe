package uk.ac.kingston.programming.oxyv2;

/**
 *
 * @author matte
 */
import uk.ac.kingston.programming.oxyv2.view.BoardView;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
/**
 *
 * @author k1728913
 */
public class Runner {

    public static char [] [] board = new char [4] [4];
    
    public static void main(String[] args) {
        BoardView boardView = BoardView.getInstance();
        boardView.initialise();
        boardView.pack();
        boardView.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        boardView.setVisible(true);
    }
    
}

