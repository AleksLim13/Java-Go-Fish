
package ca.sheridancollege.javagofish.Cards;


//Imports:_____________________________


import java.util.List;

/**
 * This is the Deck class. 
 * It has behavior for initializing and shuffling a deck of cards.
 * The deck is to be used throughout a card game. 
 * Most decks have 52 cards. 
 * There usually is 13 values and 4 types of suit. 
 * @author AllyCat13 @ Sheridan High 2021
 */
public abstract class Deck 

{//Start CL:*
    
    //Fields:________________________
    
    /**
     * This is a field variable of a Card list type.
     * It's final because once it is initialized with Card values the Deck's state is finished.
     * A card game becomes relevant per a single decks change in status over the game duration. 
     * Only one copy is desirable and a requirement.
     */
    
    protected final List<Card> deck; 
    
    //Constructors:______________________
    
    /**
     * @param deck of Card list type. 
     * Pass empty array list for constructor dependency injection. 
     * This constructs a instance of a Deck. 
     */
    public Deck(List<Card> deck) 
    {     
        this.deck = deck; 
    }//End C:*
    
    //Getters & Setters:___________________
    
    /**
     * A getter method to access the values in a created deck. 
     * @return the Deck field var of Card list type. 
     */
        public List<Card> getDeck() 
        {
        return this.deck;
    }//End G:*

    /**
     * This method populates the deck field var full of Card instances. 
     * Outer for loop repeats per number of suits in Cards suits range array. 
     * Inner for loop repeats per number of values in Cards values range array. 
     * So, it will make a whole values range of hearts. 
     * Then it will make a whole values range of clubs. 
     * Then it will make a whole values range of diamonds. 
     * Lastly, it will make a whole values range of spades.
     */
       
    public abstract void initDeck();
   
    /**
     * This method repeats it's body of statements 52 times.
     * Set the counter limit to the size of the field var deck.
     * This creates a random number from 0 to 52. 
     * in total it creates 52 random numbers from 0 to 52.
     * It steps through each slot in the deck list and swaps every
     * slot with a value from a random slot in the same deck list. 
     */
    public abstract void shuffle(); 
    
    /**
     * 
     * @param hand is a Card list type. The players hand to be searched.
     * @param tCard is of Card type. The position of this card in the hand is wanted. 
     * @return a integer representing the Cards position in the hand. 
     * Use this method as a method parameter anywhere a integer is expected.
     */
    public abstract int findPosit(List<Card> hand, Card tCard);
    
 
    /**
     * This method is for removing a Card from a players hand after they've handed it to a opponent.
     * @param card is of Card type and the target to be deleted.
     * @return a Card list representing the updated hand as the result. 
     */
    public abstract List<Card> removeCard(Card card); 
} //End class:_______________________
