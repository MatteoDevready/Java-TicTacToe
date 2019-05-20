package uk.ac.kingston.programming.oxyv2.view;

/**
 *
 * @author matte
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
public final class Square extends JPanel {
    
    private JLabel squareLabel;
    public Square()
    {
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.black), BorderFactory.createEmptyBorder(10, 20, 20, 20)));
        setPreferredSize(new Dimension(100,100));//setting dimension of the squares within the window
        squareLabel = new JLabel();
        squareLabel.setFont(new Font("Sergio UI", Font.BOLD, 52));
        add(squareLabel);
    }
    
    public void setText(String text) {
        squareLabel.setText(text);
    }
    
    public String getText() {
        return squareLabel.getText();
    }
    
    public boolean isSelected (){
        return !squareLabel.getText().equals("");// within this method we are checking the square is not equal to an empty string,
        //so if is not equal to and empty string is meaning that a player is already in that position.  
    }
}

