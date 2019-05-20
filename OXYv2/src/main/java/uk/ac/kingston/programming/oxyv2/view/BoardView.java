package uk.ac.kingston.programming.oxyv2.view;

/**
 *
 * @author matte
 */
import uk.ac.kingston.programming.oxyv2.controller.BoardController;
import uk.ac.kingston.programming.oxyv2.model.Board;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
/**
 *
 * @author k1728913
 */
public class BoardView extends JFrame {

    private JPanel scorePanel;
    private JPanel squarePanel;
    private JPanel buttonPanel;
    private JButton btnRestart;
    
    private JLabel scoreLabel;
    
    private BoardController controller = new BoardController();
    
    private static BoardView instance = null;
    
    public static BoardView getInstance(){
        if(instance == null) instance = new BoardView();
        return instance;
    }

    
    public void initialise() {
        
        setLayout(new BorderLayout());
        
        scorePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
       
        scoreLabel = new JLabel();
        
        scorePanel.add(getScoreLabel());
        
        add(scorePanel, BorderLayout.NORTH);
        
        squarePanel = new JPanel(new GridLayout(4,4));//setting the grid layout with 4 by 4
        add(getSquarePanel(), BorderLayout.CENTER);
        
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        btnRestart = new JButton("Restart");
        btnRestart.addActionListener((ActionEvent e) -> {
            controller.newGame();
        });
        buttonPanel.add(btnRestart);
        
        add(buttonPanel, BorderLayout.SOUTH);
        
        controller.newGame();
    }

    /**
     * @return the squarePanel
     */
    public JPanel getSquarePanel() {
        return squarePanel;
    }

    /**
     * @return the scoreLabel
     */
    public JLabel getScoreLabel() {
        return scoreLabel;
    }

}

