
package ca.sheridancollege.javagofish.Cards;


import ca.sheridancollege.javagofish.Players.Player;
import ca.sheridancollege.javagofish.Turns.AScoreBoard;
import java.util.ArrayList;
import java.util.List;

/**
 * HAND ABSTRACT CLASS:
 * --------------------
 * 
 * 
 * This class has all the functionality for tasks relating to a players hand.
 * Only one of these Hand objects need to be created during a games life cycle. 
 * It can be declared as a final field variable in the aggregating class. 
 * This class aggregates Deck and Scoreboard as it needs one of each along with their functionality.
 * 
 * 
 * 
 * @author AllyCat13.
 */
public abstract class AHand 

{

    /**
     * A reference to scoreboard is needed for calculating duplicates of players hand.
     * Once a scoreboard object is created it's life cycle is complete.
     * A Hand instance will access scoreboard through a public getter interface.
     */
    protected final AScoreBoard scoreBoard;
    
    /**
     * A Hand instance needs a reference to a Deck instance to create hands and update the Deck. 
     * Only one copy is ever needed and needs to be created only once.
     */
    protected final ADeck deck;

    /**
     * This constructs a Hand instance with a Deck and Scoreboard object as argument thereby initializing the field variables.
     * @param deck is of Deck type. 
     * @param sb is of ScoreBoard type. 
     * This constructors calls this classes deck setup method to automatically initialize and shuffle the deck.
     */
    public AHand(ADeck deck, AScoreBoard sb) 
    {
        this.deck = deck;
        this.scoreBoard = sb;
        this.deckSetup();
    }//End C:*

    /**
     * This is a public getter interface for accessing the Deck field var of Hand instances.
     * @return the field variable of Deck type.
     */
    public ADeck getDeck() 
    {
        return this.deck;
    }//End G:*

    
    /**
     * This method removes the Card asked for by the opponent from the asked players hand.
     * This method adds the Card to the players hand who asked for it. 
     * @param inPlay is of top level Player type.
     * @param inPlaysDesireC is is of top level Card type. 
     * @param notInPlay is of top level Player type. 
     */
    
    public abstract void addCardToHand(
            Player inPlay, //inplay
            ACard inPlaysDesireC, //in plays desire
            Player notInPlay //remove from
    );

    /**
     * This method removes the target Card from the Player's hand who is being asked.
     * @param notInPlay is of top level Player type. 
     * @param posit is of integer type representing the position of the target Card.
     */
    private void deleteCardFromHand(
            Player notInPlay,
            int posit
    ) {

        notInPlay.getHand().remove(posit);
    }//End M:*
    
    /**
     * The game has a need to remove a Card from duplicate list when the opponent asks for it and the asked person has it.
     * @param notInPlay top level Player type.
     * @param posit integer type. 
     */
    private void deleteCardFromDList(
            Player notInPlay,
            int posit
    ) {

        notInPlay.getDesirableList().remove(posit);
    }//End M:*

    /**
     * This method is for when a Players asks for a Card and the asked player doesn't have it
     * That player who asked has to "Gi Fish" and draw a Card from the top of the deck. 
     * This method calls another method from this class that chooses a value from a random slot in the deck. 
     * @param player is of top level Player type. 
     */  
    public void getCardFromDeck(Player player) 
    {
        player.getHand().add(createRandoCard());
        System.out.println("");


        System.out.println("");
        System.out.println("Calculating dupes for " + player.getName());
        this.scoreBoard.getDupes(player);

        System.out.println("");
        System.out.println(player.getName() + " dupes: " + player.getDesirableList().toString());
    }//End M:*

    /**
     * This is the public interface for removing the Card from the asked players hand.
     * It deletes from the Players duplicates list to keep hand and duplicate list in sync.
     * @param notInPlay top level Player type.
     * @param inPlaysDesireC top level Card type.
     */
    public void updateHandDelete(
            Player notInPlay,//Incl: list for C's.
            ACard inPlaysDesireC//Incl: list for copies. 
    ) {
        int pHTemp = findPositFullCard(notInPlay, inPlaysDesireC);
        int pDTemp = findPositFullCardDList(notInPlay, inPlaysDesireC);
        
        deleteCardFromDList(notInPlay, pDTemp);
        deleteCardFromHand(notInPlay, pHTemp);
    }//End M:*

    /**
     * public interface for adding a Card to the Player who asked for it if it's also possessed by asked player.
     * This calls this classes private method add card to hand.
     * @param inPlay top level Player type.
     * @param inPlaysDesireC top level card type.
     * @param notInPlay  top level Player type.
     */
    public void updateHandAdd(
            Player inPlay,//Incl: list for C's.
            ACard inPlaysDesireC,//Incl: list for copies. 
            Player notInPlay
    ) 
    {
        addCardToHand(inPlay, inPlaysDesireC, notInPlay);
    }//End M:*

    /**
     * This finds the index value of the target Card that matches by exact suit and value.
     * @param player top level Player type.
     * @param tCard top level Card type. 
     * @return integer value as position in asked Players hand.
     */
    private int findPositFullCard(Player player, ACard tCard) 
    {
        int posit = 0;
        for (int i = 0; i < player.getHand().size(); i++) 
        {
            if (player.getHand().get(i).equals(tCard)) 
            {
                posit = i;
                return posit;
            }//End I:*
        }//End F:*
        return posit;
    }//End M:*
    
 

    /**
     * When the asked for Card is possessed by the asked player it needs to be remove from two places.
     * Cards match by exact suit and value facilitated by the overridden equals method in Card.
     * @param player top level Player type.
     * @param tCard top level Card type. 
     * @return integer as position of target card in searched hand. 
     */
    private int findPositFullCardDList(Player player, ACard tCard) 
    {
        int posit = 0;
        for (int i = 0; i < player.getDesirableList().size(); i++) 
        {
            if (player.getDesirableList().get(i).equals(tCard)) 
            {
                posit = i;
                return posit;
            }//End I:*
        }//End F:*
        return posit;
    }//End M:*

    /**
     * Players as for a Card by value only. Players ask by value and not by value and suit.
     * The goal is to get as many four of a kinds as possible before the deck runs out of cards.
     * @param player top level Player type.
     * @param tCard top level Card type. 
     * @return integer as position of target card in asked players hand.
     */
    public abstract int findPositPartialCard(Player player, ACard tCard);
    
    /**
     * To be used when a Player has to "Go Fish" because they asked for a Card the asked PLayer doesn't have.
     * It created a random number that could be any slot in the Card list deck. 
     * @return the random Card removed and deleted from the central deck. 
     */
    public abstract ACard createRandoCard() ;

    //Methods:_________________________
    
    
    /**
     * This method performs routine tasks for the deck that occur once per game.
     * It initializes the deck and shuffles it. 
     */
    private void deckSetup() 
    {
        this.deck.initDeck();
        this.deck.shuffle();
    }//End M:*

    /**
     * This method takes and deletes a Card from the central deck. 
     * @return 
     */
    public abstract ACard startDeal() ;

    /**
     * Calls this classes start deal method and adds the return value per a desired amount of Cards to a Players hand.
     * @param size as integer for how many cards to include in a Hand.
     * @param player top level Player type. The Hand to add cards to. 
     */
    public abstract void createHand(int size, Player player);

    /**
     * Two Player lists need to be sorted throughout the game for Players to make quick decisions based on their hand.
     * Sort either Players hand or duplicates list.
     * @param player top level Player type. 
     * @param option char type indicating which Player list to work on.
     */
    public abstract void sort(Player player, char option) ; 

}//End CL:*
