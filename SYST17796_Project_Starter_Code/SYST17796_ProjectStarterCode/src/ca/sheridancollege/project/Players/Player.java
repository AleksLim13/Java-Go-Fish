package ca.sheridancollege.project.Players;

/**
 * SYST 17796 Project Winter 2021 Base code of a could be any game. Students can
 * modify and extend to implement their game. Add your name as a modifier and
 * the date!
 */
//Imports:_______________________________
import ca.sheridancollege.project.Cards.Card;
import java.util.*;

/**
 * A class that models each Player in a possible any game. Note: Show expertise
 * in generic programming. Note: Players have an identifier, which should be
 * unique. Note: Provide user manual like in Linux man pages. Note: Remember to
 * do that for Java2 class as well. Note: Best OOP design wins the free Surface
 * Pro Laptop.
 *
 * @author AllyCat13 @ Sheridan High 2021.
 */
public abstract class Player {

    //Fields:_______________________
    protected String name;
    protected ArrayList<Card> hand;
    protected static int numOfPlayers; //the unique ID for this player
    protected int playerId;
    protected Card.Value[] books;
    protected ArrayList<Card> desirableList;

    //Constructors:______________________________
    public Player() {
        numOfPlayers++;
        playerId = numOfPlayers;
    }//End C:*

    
    //Getters & Setters:________________________
    public void setName(String newName) {
        this.name = newName;
    }//End S:*

    public void setHand(ArrayList<Card> newHand) {
        this.hand = newHand;
    }//End S:*

    public String getName() {
        return name;
    }//End G:*

    public ArrayList<Card> getHand() {
        return hand;
    }//End G:*

    public int getPlayerID() {
        return playerId;
    }//End G:*

    public static int getNumOfPlayers() {
        return numOfPlayers;
    }

    public static void setNumOfPlayers(int numOfPlayers) {
        Player.numOfPlayers = numOfPlayers;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public ArrayList<Card> getDesirableList() {
        return desirableList;
    }

    public void setDesirableList(ArrayList<Card> desirableList) {
        this.desirableList = desirableList;
    } 

    //Methods:_________________________
    public void printStats(){
    
    }//End M:*
    
    

}//End Class:_________________
