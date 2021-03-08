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

    //Constructors:______________________________
    public Player() {
        name = "default";
        hand = new ArrayList<>();
        numOfPlayers++;
        playerId = numOfPlayers;
    }//End C:*

    public Player(String name, ArrayList<Card> hand) {
        this.name = "default";
        this.hand = hand;
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

    //Methods:_________________________
    public abstract void printStats();

}//End Class:_________________
