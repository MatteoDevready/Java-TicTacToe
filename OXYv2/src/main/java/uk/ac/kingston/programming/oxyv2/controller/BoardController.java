package uk.ac.kingston.programming.oxyv2.controller;


/**
 *
 * @author k1728913
 */

import uk.ac.kingston.programming.oxyv2.view.BoardView;
import uk.ac.kingston.programming.oxyv2.view.Square;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ImageIcon;


public class BoardController {

    private ArrayList<Square> squareList = new ArrayList<>();
    private String currentPlayer = "X";
    private int currentPlayerTurns = 0;
    private int totalTurns;
    
    ImageIcon icon = new ImageIcon("src/img/tictac.png");
    private Square [] [] slot = new Square[4] [4];
     
    public Square[][] getSlot() {
      return slot;
    }

    public void setSlot(Square[][] slots) {
      this.slot = slots;
    }
    
    public void setCurrentPlayer(String player){
     this.currentPlayer = player;
    }
    public String getCurrentPlayer(){
        return this.currentPlayer;
    }
    private BoardView getView() {
        return BoardView.getInstance();
    }
    
    public void newGame() {//method created so that during a match restart we can have a clean board where to start a new game
        
        currentPlayer = "X";
        currentPlayerTurns = 0;
        totalTurns = 0;
        getView().getSquarePanel().removeAll();
        
        getView().getScoreLabel().setText("Player turn: " + currentPlayer);
        
        for(int x = 0; x <= 3; x++) {//creating the squares for the X coordinates
            for(int y = 0; y <=3; y++) {// creating the squares for the Y coordinates
                Square square = new Square();
                this.getSlot()[x][y] = square;
                
                square.addMouseListener(new MouseListener(){
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if(square.isSelected()){//if a player took that square dont do anything and simply return.
                            return;
                        }
                        totalTurns++;
                        currentPlayerTurns++; //using current player integer as a way to understand the current turn after player event
                        switch(currentPlayerTurns){//checking turns for each player
                            case 1: 
                            case 2:
                                if(currentPlayerTurns == 2) {
                                    String currentPlayerTurn = currentPlayer.equals("X") ? "O" : "X";
                                    getView().getScoreLabel().setText("Player turn: " + currentPlayerTurn);
                                }
                                square.setText(currentPlayer);
                                break;
                            case 3:
                                currentPlayerTurns = 1;//when one of the player finish the two turn the turn of the next player is set to one
                                currentPlayer = currentPlayer.equals("X") ? "O" : "X";// saying that if the player is equal to a string or another string symbol that due to the turn the symbol is going to switch
                                square.setText(currentPlayer);//setting the text symbol to the new current player
                                break;// exit and start again from the beginning of switch
                        }
                        if(totalTurns == 16){//basically if all square are full and no winning conditon have been
                            //triggered the the variable will reach 16 moves and 
                            int saved = JOptionPane.showConfirmDialog(null, "No Winners X & O end up with a STALEMATE\nDo you wish to Restart?","Tic Tac Toe Game",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
                               if(saved==JOptionPane.YES_OPTION){
                                   newGame();
                                   
                               } else {
                                   getView().dispose();
                               }
                        }
                        if(isWinner()) {
                           int savedTwo = JOptionPane.showConfirmDialog(null, ""+getCurrentPlayer()+" is the Winner!\nDo you wish to Restart?","Tic Tac Toe Game",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
                               if(savedTwo==JOptionPane.YES_OPTION){
                                   newGame();
                                   
                               } else {
                                   getView().dispose();
                               }
                            //JOptionPane.showMessageDialog(null, ""+getCurrentPlayer()+" is the Winner!");//the message box interrupt the game to carry on, altought
                           //once ok is clicked the user can do another move before another winning message appears with the wrong winning player
                        }
                       
                    }
                    

                    @Override
                    public void mousePressed(MouseEvent e) {
                        
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                        
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        
                    }
                } );
                getView().getSquarePanel().add(square);
                squareList.add(square);
                
            }
            
            getView().getSquarePanel().updateUI();
        }
    }
    
    
   public boolean isWinner(){
       
       Square[][] lines = new Square[10][10];
       lines[0] = new Square[] {this.getSlot()[0][0], this.getSlot()[0][1], this.getSlot()[0][2], this.getSlot()[0][3]};
       lines[1] = new Square[] {this.getSlot()[1][0], this.getSlot()[1][1], this.getSlot()[1][2], this.getSlot()[1][3]};
       lines[2] = new Square[] {this.getSlot()[2][0], this.getSlot()[2][1], this.getSlot()[2][2], this.getSlot()[2][3]};
       lines[3] = new Square[] {this.getSlot()[3][0], this.getSlot()[3][1], this.getSlot()[3][2], this.getSlot()[3][3]};
      
        //The two lines below checks the diagonal
       lines[4] = new Square[] {this.getSlot()[0][0], this.getSlot()[1][1], this.getSlot()[2][2], this.getSlot()[3][3]};
       lines[5] = new Square[] {this.getSlot()[3][0], this.getSlot()[2][1], this.getSlot()[1][2], this.getSlot()[0][3]};
       
       lines[6] = new Square[] {this.getSlot()[0][0], this.getSlot()[1][0], this.getSlot()[2][0], this.getSlot()[3][0]};
       lines[7] = new Square[] {this.getSlot()[0][1], this.getSlot()[1][1], this.getSlot()[2][1], this.getSlot()[3][1]};
       lines[8] = new Square[] {this.getSlot()[0][2], this.getSlot()[1][2], this.getSlot()[2][2], this.getSlot()[3][2]};
       lines[9] = new Square[] {this.getSlot()[0][3], this.getSlot()[1][3], this.getSlot()[2][3], this.getSlot()[3][3]};
       
     
       /* Board visual
     3 |Y||_||_||x|    //the diagonal for X
     2 |_||Y||x||_|    //digonal for the Y    
     1 |_||x||Y||_|
     0 |x||_||_||Y|    
        0  1  2  3
       */
       for(String player : new String[] {"X", "O"}) {
        for(Square[] line : lines) {
            if(isWinningLine(line, player)) {
                return true;
            }
        }
       }
       
       return false;
   }

    private boolean isWinningLine(Square[] line, String player) {
        return line[0].getText().equals(player) && 
                line[1].getText().equals(player) && 
                line[2].getText().equals(player)  && 
                line[3].getText().equals(player);
    }
    
}

