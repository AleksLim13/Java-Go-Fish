
package ca.sheridancollege.javagofish.Cards;


import ca.sheridancollege.javagofish.Players.APlayer;
import ca.sheridancollege.javagofish.Turns.AScoreBoard;
import java.util.List;


/**
 * AHAND ABSTRACT CLASS:
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
public abstract class ADealer 

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
    protected final ADeck classDeck;

    /**
     * This constructs a Hand instance with a Deck and Scoreboard object as argument thereby initializing the field variables.
     * @param deck is of Deck type. 
     * @param sb is of ScoreBoard type. 
     * This constructors calls this classes deck setup method to automatically initialize and shuffle the deck.
     */
    public ADealer(ADeck deck, AScoreBoard sb) 
    {
        this.classDeck = deck;
        this.scoreBoard = sb;
    }//End C:*

    /**
     * This is a public getter interface for accessing the Deck field var of Hand instances.
     * @return the field variable of Deck type.
     */
    public ADeck getClassDeck() 
    {
        return this.classDeck;
    }//End G:*

    //Methods:_________________________
    
 
    /**
     * This method performs routine tasks for the deck that occur once per game.
     * It initializes the deck and shuffles it. 
     */
    public abstract void deckSetup(); 

    /**
     * This method takes and deletes a Card from the central deck. 
     * @return 
     */
     public abstract ACard createRandoCard() ;
     
    /**
     * To be used when a Player has to "Go Fish" because they asked for a Card the asked PLayer doesn't have.
     * It created a random number that could be any slot in the Card list deck. 
     * @return the random Card removed and deleted from the central deck. 
     */
   
    
    public abstract ACard startDeal() ;
    
    /**
     * This method removes the Card asked for by the opponent from the asked players hand.
     * This method adds the Card to the players hand who asked for it. 
     * @param inPlay is of top level Player type.
     * @param inPlaysDesireC is is of top level Card type. 
     * @param notInPlay is of top level Player type. 
     */
    
    public abstract void addCardToHand(
            APlayer inPlay, //inplay
            ACard inPlaysDesireC, //in plays desire
            APlayer notInPlay //remove from
    );

    /**
     * This method removes the target Card from the Player's hand who is being asked.
     * @param notInPlay is of top level Player type. 
     * @param posit is of integer type representing the position of the target Card.
     */
    public abstract void deleteCardFromHand(
            APlayer notInPlay,
            int posit
    );
    
    /**
     * The game has a need to remove a Card from duplicate list when the opponent asks for it and the asked person has it.
     * @param notInPlay top level Player type.
     * @param posit integer type. 
     */
    public abstract void deleteCardFromDList(
            APlayer notInPlay,
            int posit
    );

    /**
     * This method is for when a Players asks for a Card and the asked player doesn't have it
     * That player who asked has to "Gi Fish" and draw a Card from the top of the deck. 
     * This method calls another method from this class that chooses a value from a random slot in the deck. 
     * @param player is of top level Player type. 
     */  
    public abstract void getCardFromDeck(APlayer player); 

    /**
     * This is the public interface for removing the Card from the asked players hand.
     * It deletes from the Players duplicates list to keep hand and duplicate list in sync.
     * @param notInPlay top level Player type.
     * @param inPlaysDesireC top level Card type.
     */
    public abstract void updateHandDelete(
            APlayer notInPlay,//Incl: list for C's.
            ACard inPlaysDesireC//Incl: list for copies. 
    ); 

    /**
     * public interface for adding a Card to the Player who asked for it if it's also possessed by asked player.
     * This calls this classes private method add card to hand.
     * @param inPlay top level Player type.
     * @param inPlaysDesireC top level card type.
     * @param notInPlay  top level Player type.
     */
    public abstract void updateHandAdd(
            APlayer inPlay,//Incl: list for C's.
            ACard inPlaysDesireC,//Incl: list for copies. 
            APlayer notInPlay
    ); 

    /**
     * This finds the index value of the target Card that matches by exact suit and value.
     * @param player top level Player type.
     * @param tCard top level Card type. 
     * @return integer value as position in asked Players hand.
     */
    public abstract int findPositFullCard(APlayer player, ACard tCard); 
    
    /**
     * When the asked for Card is possessed by the asked player it needs to be remove from two places.
     * Cards match by exact suit and value facilitated by the overridden equals method in Card.
     * @param player top level Player type.
     * @param tCard top level Card type. 
     * @return integer as position of target card in searched hand. 
     */
    public abstract int findPositFullCardDList(APlayer player, ACard tCard); 

    /**
     * Players as for a Card by value only. Players ask by value and not by value and suit.
     * The goal is to get as many four of a kinds as possible before the deck runs out of cards.
     * @param player top level Player type.
     * @param tCard top level Card type. 
     * @return integer as position of target card in asked players hand.
     */
    public abstract int findPositPartialCard(APlayer player, ACard tCard);
    
    

    /**
     * Calls this classes start deal method and adds the return value per a desired amount of Cards to a Players hand.
     * @param size as integer for how many cards to include in a Hand.
     * @param player top level Player type. The Hand to add cards to. 
     */
    public abstract void createHand(int size, APlayer player);

    /**
     * Two Player lists need to be sorted throughout the game for Players to make quick decisions based on their hand.
     * Sort either Players hand or duplicates list.
     * @param player top level Player type. 
     * @param option char type indicating which Player list to work on.
     */
    public abstract void sort(APlayer player, char option); 
    
    /**
     * 
     * @param hand is a Card list type. The players hand to be searched.
     * @param tCard is of Card type. The position of this card in the hand is wanted. 
     * @return a integer representing the Cards position in the hand. 
     * Use this method as a method parameter anywhere a integer is expected.
     */
    public abstract int findPosit(List<ACard> hand, ACard tCard);
    
     /**
     * This method is for removing a Card from a players hand after they've handed it to a opponent.
     * @param card is of Card type and the target to be deleted.
     * @param tHand
     * 
     */
    public abstract void removeCard(ACard card, List<ACard> tHand); 

}//End CL:*
