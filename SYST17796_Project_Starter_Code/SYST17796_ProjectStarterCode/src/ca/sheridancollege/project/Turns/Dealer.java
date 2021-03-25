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
import java.util.List;

/**
 *
 * @author AllyCat13 @ Sheridan High 2021
 */
public class Dealer {

    //Field Variables:_____________________
    private Deck deck;
    private ArrayList<Card> hand;
    private int[][] scoreBoard;


    //Constructors:_____________________
    public Dealer(Deck deck,
                  ArrayList<Card> hand) {
        this.deck = deck;
        this.hand = hand;
        this.deckSetup();
    }//End C:*

   
    //Getters & Setters:__________________________

    public int[][] getScoreBoard() {
        return scoreBoard;
    }

    public void setScoreBoard(int[][] scoreBoard) {
        this.scoreBoard = scoreBoard;
    }
    
    
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
      
        if(hand.size() > 0){
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
    public int askForACard() {
        //Step 1: 
        System.out.println("What card do you want");
        int target = UInput.promptIntUser();
        // Step 2:
        boolean flag = true;
        if (target < 1 || target > 13) {
            while (flag) {
                //2.2
                System.out.println("Notice: Cards in a standard deck range from 1-13");
                target = UInput.promptIntUser();
                //2.3 
                if (target >= 1 && target <= 13) {
                    flag = false;
                    return target;
                }//End Inner I:*
            }//End W:*
        } //End Outer I:*      
        //Step 3: 
        else {
            return target;
        }//End E:*
        //Step 4:
        return target;
    }//End M:*

    //This works as a check if card is in opponents hand 
    //so there turn keeps going
    public boolean goFish(ArrayList<Card> hand, Card card) {
        boolean shouldKeepGoing = false;
        for (int i = 0; i < hand.size(); i++) {
            if (hand.get(i) == card) {
                shouldKeepGoing = true;
                return shouldKeepGoing;
            }//End I:*
        }//End F:*
        return shouldKeepGoing;
    }//End M:*

    //Need to know what the index of the card need to remove 
    //from hand
    public int findPosit(ArrayList<Card> hand, Card.Value value) {
        int posit = 0;
        for (int i = 0; i < hand.size(); i++) {
            if (hand.get(i).getValue() == value) {
                posit = i;
                return posit;
            }//End I:*
        }//End F:*
        return posit;
    }//End M:*
    
 //Define: get a list of duplicate cards. 
    public static void getDupes(List<Integer> hand, List<Integer> dupes, List<Integer> books) {

        //A: main for loop: compare each card to every other card in hand.
        //------------------
        for (int i = 0; i < hand.size(); i++) {
            int lCount = 0;
            //A.1: par two of compare each card to every other card in hand.
            //----
            for (int j = 0; j < hand.size(); j++) {
                if (hand.get(i) == hand.get(j)) {
                    //A.1.1: increase counter if they are equal. \
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

    public void calcBooks(Integer tNum, List<Integer> dupes,
            List<Integer> books, List<Integer> hand){
        
                //A.3: we want just one copy in duplicate list. 
                //----
                int ilCount = 0;
                for (int i = 0; i < dupes.size(); i++) {                   
                    //A.3.1: increment counter if already in duplicate list
                    if (tNum == dupes.get(i)) {
                        ilCount++;
                    }//End I:*                    
                }//End F:*
                if (ilCount == 4) {  
                    books.add(tNum);
                    for (int j = 0; j < 4; j++) {            
                        hand.remove(findFirstIndex(tNum, hand));
                    }//End I:*                  
                }//End I:*
                //A.4: if not in dupe list already then place inside. 
                //----          
    }//End M:*
    
    public int findFirstIndex(int tNum, List<Integer> tList){
         int pos = 0;
       for(int i = 0; i < tList.size(); i++){
           if(2 == tList.get(i)){
              pos = i;
              return pos;
           }//End I:*
       }//End F:*
       return pos;
    }//End M:*

}//End class
