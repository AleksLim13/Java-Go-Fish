package ca.sheridancollege.javagofish.Players;

/**
 * SYST 17796 Project Winter 2021 Base code of a could be any game. Students can
 * modify and extend to implement their game. Add your name as a modifier and
 * the date!
 */
//Imports:_______________________________
import ca.sheridancollege.javagofish.Cards.Card;
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
    protected List<Card> hand;
    protected static int numOfPlayers; //the unique ID for this player
    protected int playerId;
    protected List<Card> books;
    protected List<Card> desirableList;

    //Constructors:______________________________
    public Player(
                  String name, 
                  List<Card> books, 
                  List<Card> dL
                  ) 
    {
        this.name = name;
        Player.numOfPlayers++;
        this.playerId = numOfPlayers;
        this.books = books;
        this.desirableList = dL;
    }//End C:*
    
    //Getters & Setters:________________________
    public void setName(String newName) 
    {
        this.name = newName;
    }//End S:*

    public void setHand(List<Card> newHand) {
        this.hand = newHand;
    }//End S:*

    public String getName() {
        return name;
    }//End G:*

    public List<Card> getHand() {
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

    public List<Card> getDesirableList() {
        return desirableList;
    }

    public void setDesirableList(List<Card> desirableList) {
        this.desirableList = desirableList;
    } 

    public List<Card> getBooks() {
        return books;
    }

    public void setBooks(List<Card> books) {
        this.books = books;
    }
    
    //Methods:_________________________
    public String printStats(){
        return "[" + "Name: " + name + "," + " Id: " + playerId + "]";
    }//End M:*
    
    

}//End Class:_________________
