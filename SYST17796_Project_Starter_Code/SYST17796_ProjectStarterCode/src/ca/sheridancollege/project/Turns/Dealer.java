package ca.sheridancollege.project.Turns;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Imports:__________________________________
import ca.sheridancollege.project.Cards.Card;
import ca.sheridancollege.project.Cards.GoFishCard;
import ca.sheridancollege.project.Players.Player;
import ca.sheridancollege.project.Utility.UInput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author AllyCat13 @ Sheridan High 2021
 */
public class Dealer {

    //Field Variables:_____________________
    private Deck deck;
    private ArrayList<Card> hand;
    
    public Dealer(){
    }

    //Constructors:_____________________
    public Dealer(Deck deck,
            ArrayList<Card> hand) {
        this.deck = deck;
        this.hand = hand;
        this.deckSetup();
    }//End C:*

    //Getters & Setters:__________________________
    public Deck getDeck() {
        return deck;
    }//End G:*

    public void setDeck(Deck deck) {
        this.deck = deck;
    }//End S:*

    public ArrayList<Card> getHand() {
        return hand;
    }//End G:*

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }//End S:*

    //Methods:_________________________
    private void deckSetup() {
        deck.initDeck();
        deck.shuffle();
    }//End M:*

    //Deal first card and simultaneously remove it from deck.
    private Card startDeal() {
        Card card;
        card = deck.getDeck().get(0);
        //B: 
        deck.getDeck().remove(0);
        //C: 
        return card;
    }//End M:*

    public void createHand(int size) {

        if (hand.size() > 0) {
            hand.clear();
        }//End I:*

        for (int i = 0; i < size; i++) {
            hand.add(this.startDeal());
        }//End F:*     

    }//End M:*

    //Define: behavior for taking random card from deck after told to go fish. 
    private GoFishCard randShuffle() {

        //A: create ranges for random number to map against. 
        Card.Value[] values = Card.Value.values();
        Card.Suit[] suits = Card.Suit.values();

        //B: Create the random numbers modelling suit and values. 
        int valPossible = (int) (Math.random() * values.length) + 1;
        int suitPossible = (int) (Math.random() * suits.length) + 1;

        //C: asssign the values determined by a random number
        Card.Value randVal = values[valPossible];
        Card.Suit randSuit = suits[suitPossible];

        //D: create the card object and copy it. 
        return new GoFishCard(randSuit, randVal);
    }//End M:*

    //Define: "sorry don't have that card dude." Allor, take a card from the deck.  
    public ArrayList<Card> drawCard(ArrayList<Card> cardHand) {
        cardHand.add(randShuffle());
        return cardHand;
    }//End M:*

    //Define: ablility to remove target from other players hand. Calls delete method. 
    public ArrayList<Card> checkHandAndRemove(
            ArrayList<Card> cardHand,//Incl: list for C's.
            ArrayList<Integer> dupesHolder//Incl: list for copies. 
    ) {
        if (dupesHolder != null) {//Eval: is it empty?
            cardHand = deleteCard(cardHand, dupesHolder.get(0));//Assi: 
        }//End I:*
        return cardHand;
    }//End M:*

    //Takes value as parameter and uses it to remove that card from 
    //a simulated card hand also passed to it. 
    private ArrayList<Card> deleteCard(ArrayList<Card> cardHand, int posit) {
        ArrayList<Card> resultHand = cardHand;
        resultHand.remove(posit);
        return resultHand;
    }

    //Adds a value passed to it's card hand list also passed to it 
    //To simulate receiving the card from your opponent and
    //Putting it in your hand. 
    public ArrayList<Card> addCard(ArrayList<Card> cardHand, Card card) {
        cardHand.add(card);
        return cardHand;
    }//End M:*

    //compares player objects field var books. 
    //Comparison is based on nunber of key value pairs in books 
    public Player determineWinner() {
        return null;
    }//End M:*

    //This prompts for a card it knows about from a 
    //Param value taken from elsewhere to simulate a card ask of 
    //a opponent. It has validation for a value from 1-13(deck values)
    //and to make sure it's a number. 
    //Human player will respond to this method directly. 
    public PseudoCard askForACard() {
        boolean flag = true;
        while (flag) {
            System.out.println("Which card value do you want?");
            String cvDesire = UInput.promptStringUser();
            System.out.println("Which card suit do you want?");
            String csDesire = UInput.promptStringUser();
            PseudoCard cDesire = new PseudoCard(cvDesire.toLowerCase(), csDesire.toLowerCase());
            cDesire.createDeck();
            for(int i = 0; i < cDesire.getPseudoDeck().size(); i++){
               if(cDesire.equals(cDesire.getPseudoDeck().get(i))){
                   return cDesire;
               }//End F:*
            }//End F:*
        }//End W:*
        return null;
    }//End M:*

    //This works as a check if card is in opponents hand 
    //so there turn keeps going
    public boolean goFish(ArrayList<Card> hand, Card card) {
        for (int i = 0; i < hand.size(); i++) {
            if (hand.get(i).equals(card)) {
                return true;
            }//End I:*
        }//End F:*
        return false;
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
    
    public static void main(String[] args){
        Dealer dealer = new Dealer();
        PseudoCard card = dealer.askForACard();
        
        System.out.println(card.getValue() + " of " + card.getSuit());
        
    }//End M:*
    
class PseudoCard {

    private String value;
    private String suit;
    public String[] suits = {"hearts", "clubs", "diamonds", "spades"};
    public String[] values = {"ace", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "jack", "queen", "king"};
    private List<PseudoCard> pseudoDeck;

    public PseudoCard(String value, String suit) {
        this.value = value;
        this.suit = suit;
        this.pseudoDeck = new ArrayList<>();
    }//End C:*

    public List<PseudoCard> createDeck() {
        for (String v : values) {
            for (String s: suits) {
                pseudoDeck.add(new PseudoCard(v, s));
            } //End F:*
        } //End F:*
        return pseudoDeck;
    }//End M:*

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String[] getSuits() {
        return suits;
    }

    public void setSuits(String[] suits) {
        this.suits = suits;
    }

    public String[] getValues() {
        return values;
    }

    public void setValues(String[] values) {
        this.values = values;
    }

    public List<PseudoCard> getPseudoDeck() {
        return pseudoDeck;
    }

    public void setPseudoDeck(List<PseudoCard> pseudoDeck) {
        this.pseudoDeck = pseudoDeck;
    }
    
    @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            PseudoCard theCard = (PseudoCard) o;
            return value.equals(theCard.value) &&
                   suit.equals(theCard.suit);
        }//End M:*

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.value);
        hash = 23 * hash + Objects.hashCode(this.suit);
        hash = 23 * hash + Arrays.deepHashCode(this.suits);
        hash = 23 * hash + Arrays.deepHashCode(this.values);
        hash = 23 * hash + Objects.hashCode(this.pseudoDeck);
        return hash;
    }

 

}//End CL:*

}//End class

