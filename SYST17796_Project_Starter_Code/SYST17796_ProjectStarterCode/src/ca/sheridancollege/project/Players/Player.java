/**
 * SYST 17796 Project Winter 2021 Base code of a could be any game.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project.Players;
import ca.sheridancollege.project.Cards.Card;

import java.util.*;

/**
 * A class that models each Player in a possible any game. 
 * Show expertise in generic programming. 
 * Players have an identifier, which should be unique.
 * Provide user manual like in Linux man pages. 
 * Remember to do that for Java2 class as well. 
 * Best OOP design win the free Surface Pro Laptop. 
 * @author AllyCat13 @ Sheridan High 2021.
 */
public abstract class Player 
{
    
    //Fields:_______________________
   
    protected String name;
    protected ArrayList<Card> hand; 
    protected static int numOfPlayers; //the unique ID for this player
    protected int playerId;
   
    //Constructors:______________________________
    
    public Player()
    {  
        name = "default";    
        hand = new ArrayList<>();
        numOfPlayers++;
        playerId = numOfPlayers;
    }//End C:*
    
    public Player(String name, ArrayList<Card> hand)
    {
        this.name = "default";
        this.hand = hand;
        numOfPlayers++;
        playerId = numOfPlayers;
    }//End C:*
    
  
    //Getters & Setters:________________________
    
    public int getPlayerID() 
    {
        return playerId;
    }

    public String getName(){
    return name;
    }
    public void setName(String newName){
    this.name = newName;
    }
    
    public ArrayList<Card> getHand()
    {
        return hand; 
    }
    
    public void setHand(ArrayList<Card> newHand){
    this.hand = newHand; 
    }
    
    //Methods:_________________________
    public abstract void play();
    
}//End Class:_________________
