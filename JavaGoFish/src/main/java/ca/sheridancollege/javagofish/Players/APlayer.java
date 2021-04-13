package ca.sheridancollege.javagofish.Players;


//Imports:_______________________________
import ca.sheridancollege.javagofish.Cards.ACard;
import java.util.*;

/**
 * Parent class that models a generic Player. 
 * All the data a  Player needs during a Card game is declared and defined here. 
 *
 * @author AllyCat13 @ Sheridan High 2021.
 */
    public abstract class APlayer 

{

    //Fields:_______________________
    
    /**
     * Every player needs a String variable to store their name.
     */
    protected String name;
    
    /**
     * Every Player needs a Card list to hold their Hand.
     */
    protected List<ACard> hand;
    
    /**
     * This variable keeps track of number of Players created to set Ids automatically. 
     */
    protected static int numOfPlayers; //the unique ID for this player
    
    /**
     * Each Player needs a number variable to store their Id to differentiate them from other Players.
     */
    protected int playerId;
    
    /**
     * Each player needs a Card list variable to store their number of four of a kinds.
     */
    protected List<ACard> books;
    
    /**
     * Each Player needs a Card list to store their duplicates to know what to ask for. 
     */
    protected List<ACard> desirableList;

    //Constructors:______________________________
    
    /**
     * Constructs a Player and initializes the Players name, book, and duplicate list. 
     * @param name String type.
     * @param books card list type.
     * @param dL card list type. 
     */
    public APlayer(
                  String name, 
                  List<ACard> books, 
                  List<ACard> dL
                  ) 
    {
        this.name = name;
        APlayer.numOfPlayers++;
        this.playerId = numOfPlayers;
        this.books = books;
        this.desirableList = dL;
    }//End C:*
    
    //Getters & Setters:________________________
    public void setName(String newName) 
    {
        this.name = newName;
    }//End S:*

    public void setHand(List<ACard> newHand) 
    {
        this.hand = newHand;
    }//End S:*

    public String getName() 
    {
        return name;
    }//End G:*

    public List<ACard> getHand() 
    {
        return hand;
    }//End G:*

    public int getPlayerID() 
    {
        return playerId;
    }//End G:*

    public static int getNumOfPlayers() 
    {
        return numOfPlayers;
    }

    public static void setNumOfPlayers(int numOfPlayers) 
    {
        APlayer.numOfPlayers = numOfPlayers;
    }

    public int getPlayerId() 
    {
        return playerId;
    }

    public void setPlayerId(int playerId) 
    {
        this.playerId = playerId;
    }

    public List<ACard> getDesirableList() 
    {
        return desirableList;
    }

    public void setDesirableList(List<ACard> desirableList) 
    {
        this.desirableList = desirableList;
    } 

    public List<ACard> getBooks() 
    {
        return books;
    }

    public void setBooks(List<ACard> books) 
    {
        this.books = books;
    }
    
    //Methods:_________________________
    
    /**
     * Returns String representation of all a Players data. 
     * Easy printing and display of all a Players attributes.
     * @return concatenated String of all a Players data. 
     */
    public String printStats()
    {
        return  
                "_______________________________________" +
                "Id: " + this.playerId + "\n" + 
                "Name: " + this.name + "\n" +
                "Hand: " + this.hand.toString() + "\n" +
                "Duplicats: " + this.desirableList.toString() + "\n" +
                "Books: " + this.books.toString() + "\n" +
                "________________________________________";
    }//End M:*
    
    

}//End Class:_________________
