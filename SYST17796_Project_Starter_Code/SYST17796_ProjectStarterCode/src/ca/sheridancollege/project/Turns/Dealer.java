package ca.sheridancollege.project.Turns;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Imports:__________________________________
import ca.sheridancollege.project.Cards.Card;
import ca.sheridancollege.project.Cards.GoFishCard;
import ca.sheridancollege.project.Cards.PseudoCard;
import ca.sheridancollege.project.Players.Player;
import ca.sheridancollege.project.Utility.UInput;
import java.util.ArrayList;
import java.util.List;

/**************************************************
 *
 * @author AllyCat13 @ Sheridan High 2021
 ***************************************************/
public class Dealer {

    //Field Variables:_____________________
    private Deck deck;
    private ArrayList<Card> hand;

    public Dealer() 
    {
        
    }//End C:*

    //Constructors:_____________________
    
    //Define: Normal constructor. Sets fields. Calls known method. 
    public Dealer(
                  Deck deck,
                  ArrayList<Card> hand
                  ) 
    {
        this.deck = deck;
        this.hand = hand;
        this.deckSetup();
    }//End C:*

    //Getters & Setters:__________________________
    
    //Define: Normal getter. Accessing the deck. 
    public Deck getDeck() {
        return deck;
    }//End G:*

    //Define: normal setter. Assign new deck.
    public void setDeck(Deck deck) {
        this.deck = deck;
    }//End S:*

    //Define: normal getter for accessing the hand.
    public ArrayList<Card> getHand() {
        return hand;
    }//End G:*

    //Define: normal setter for a new hand.
    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }//End S:*

    //Methods:_________________________
    
    //Define: this fills deck and shuffles it. Uses 2 known methods.
    private void deckSetup() {
        deck.initDeck();
        deck.shuffle();
    }//End M:*

    //Define: Deal first card and simultaneously remove it from deck.
    private Card startDeal() {
        Card card;
        card = deck.getDeck().get(0);
        //B: 
        deck.getDeck().remove(0);
        //C: 
        return card;
    }//End M:*

    //Define: provide number of cards. Repetition solution. Call's start deal.
    public void createHand(int size) {

        if (hand.size() > 0) {
            hand.clear();
        }//End I:*

        for (int i = 0; i < size; i++) {
            hand.add(this.startDeal());
        }//End F:*     

    }//End M:*

    //Define: behavior for taking random card from deck after told to go fish. 
    private GoFishCard randShuffle() 
    {
        //A: create: ranges for random number to map against. 
        Card.Value[] values = Card.Value.values();
        Card.Suit[] suits = Card.Suit.values();

        //B: Create: the random numbers modelling suit and values. 
        int valPossible = (int) (Math.random() * values.length) + 1;
        int suitPossible = (int) (Math.random() * suits.length) + 1;

        //C: asssign: the values determined by a random number
        Card.Value randVal = values[valPossible];
        Card.Suit randSuit = suits[suitPossible];

        //D: create: the card object and copy it. 
        return new GoFishCard(randSuit, randVal);
    }//End M:*

    //Define: "sorry don't have that card dude." Allor, take a card from the deck.  
    public ArrayList<Card> drawCard(ArrayList<Card> cardHand) 
    {
        cardHand.add(randShuffle());
        return cardHand;
    }//End M:*

    //Define: ablility to remove target from other players hand. Calls delete method. 
    public ArrayList<Card> checkHandAndRemove(
            ArrayList<Card> cardHand,//Incl: list for C's.
            ArrayList<Integer> dupesHolder//Incl: list for copies. 
                                             ) 
     {
        if (dupesHolder != null) {//Eval: is it empty?
            cardHand = deleteCard(
                                  cardHand, 
                                  dupesHolder.get(0)
                                  );//Assi: 
        }//End I:*
        return cardHand;
    }//End M:*

    //Define: 
    private ArrayList<Card> deleteCard(
                                       ArrayList<Card> cardHand, 
                                       int posit
                                       ) 
    {
        ArrayList<Card> resultHand = cardHand;
        resultHand.remove(posit);
        return resultHand;
    }//End M:*

    //Define: adds a Card to a provided hand and copies the updated hand.
    public ArrayList<Card> addCard(ArrayList<Card> cardHand, Card card) {
        cardHand.add(card);
        return cardHand;
    }//End M:*

    
    //Define: under construction...
    public Player determineWinner() {
        return null;
    }//End M:*

    //Define: gets value and suit as string and then maps it. 
    //while loop overall strcuture with inner for loop and if.
    public Card askForACard() {
        boolean flag = true;
        //A: Iterate: 
        while (flag) {
            //A.1: Get: 
            System.out.println("Which card value do you want?");
            String cvDesire = UInput.promptStringUser();
            //A.2: Get: 
            System.out.println("Which card suit do you want?");
            String csDesire = UInput.promptStringUser();
            //A.3: Create: 
            PseudoCard cDesire = new PseudoCard(
                                                cvDesire.toUpperCase(), 
                                                csDesire.toUpperCase()
                                            );
            //A.4: Initialize: 
            cDesire.createDeck();
            //A.5: Repeat: 
            for (int i = 0; i < cDesire.getPseudoDeck().size(); i++) {
                //A.6: Check: 
                if (cDesire.equals(cDesire.getPseudoDeck().get(i))) {
                    //A.7: Create: 
                    Card resCard = new GoFishCard(
                                                            Card.Suit.valueOf(
                                                                        cDesire.getSuit()
                                                                             ), //End M:*
                                                            Card.Value.valueOf(
                                                                        cDesire.getValue()
                                                                              )//End M:*
                                                       );//End C:*
                    //A.9: Copy: 
                    return resCard;
                }//End I:*
            }//End F:*
        }//End W:*
        //A.10: Anticipate: 
        return null;
    }//End M:*

    //This works as a check if card is in opponents hand 
    //so there turn keeps going. Returns a yes or no. 
    public boolean goFish(ArrayList<Card> hand, Card card) {
        for (int i = 0; i < hand.size(); i++) {
            if (hand.get(i).equals(card)) {
                return false;
            }//End I:*
        }//End F:*
        return true;
    }//End M:*

    //Need to know what the index of the card need to remove 
    //from hand
    public int findPosit(ArrayList<Card> hand, Card tCard) {
        int posit = 0;
        for (int i = 0; i < hand.size(); i++) {
            if (hand.get(i).equals(tCard)) {
                posit = i;
                return posit;
            }//End I:*
        }//End F:*
        return posit;
    }//End M:*

    //Define: get a list of duplicate cards. 
    public static void getDupes(
            List<Integer> hand,
            List<Integer> dupes,
            List<Integer> books
    ) {

        //A: main for loop: compare each card to every other card in hand.
        //------------------
        for (int i = 0; i < hand.size(); i++) {
            int lCount = 0;
            //A.1: par two of compare each card to every other card in hand.
            //----
            for (int j = 0; j < hand.size(); j++) {
                if (hand.get(i).equals(hand.get(j))) {
                    //A.1.1: increase counter if they are equal. 
                    lCount++;
                }//End I:*
            }//End F:*
            //A.2: counter > 1 means theres duplicates.
            //-----
            if (lCount > 1) {
                dupes.add(hand.get(i));
            }//End I:*
        }//End F:*
    }//End M:*

    public void calcBooks(
            Card tNum,
            List<Card> dupes,
            List<Card> books,
            List<Card> hand
    ) {
        //----
        int ilCount = 0;
        for (int i = 0; i < dupes.size(); i++) {
            //A.3.1: increment counter if already in duplicate list
            if (tNum.equals(dupes.get(i))) {
                ilCount++;
            }//End I:*                    
        }//End F:*
        if (ilCount == 4) {
            books.add(tNum);
            //Notice: should only ever be four of a kind. E.g., standard deck format. 
            for (int j = 0; j < 4; j++) {
                hand.remove(findFirstIndex(tNum, hand));
            }//End I:*                  
        }//End I:*  
    }//End M:*

    public int findFirstIndex(
            Card tNum,
            List<Card> tList
    ) {
        int pos = 0;
        for (int i = 0; i < tList.size(); i++) {
            if (tNum.equals(tList.get(i))) {
                pos = i;
                return pos;
            }//End I:*
        }//End F:*
        return pos;
    }//End M:*

}//End class

