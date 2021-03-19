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
import java.util.HashMap;

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

    //Deal first card and simultaneously remove it from deck
    //Like in real life...
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
        }
              
            for (int i = 0; i < size; i++) {
                hand.add(this.startDeal());
            }//End F:*
       

    }//End M:*

    //public enum Value{ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, DEFAULT};
    public HashMap<Card.Value, Integer> recordTypes(
            Card.Value card,
            HashMap<Card.Value, Integer> scoreBoard
    ) {

        //A: 
        Card.Value ACE = Card.Value.ACE;
        Card.Value TWO = Card.Value.TWO;
        Card.Value THREE = Card.Value.THREE;
        Card.Value FOUR = Card.Value.FOUR;
        Card.Value FIVE = Card.Value.FIVE;
        Card.Value SIX = Card.Value.SIX;
        Card.Value SEVEN = Card.Value.SEVEN;
        Card.Value EIGHT = Card.Value.EIGHT;
        Card.Value NINE = Card.Value.NINE;
        Card.Value TEN = Card.Value.TEN;
        Card.Value JACK = Card.Value.JACK;
        Card.Value QUEEN = Card.Value.QUEEN;
        Card.Value KING = Card.Value.KING;

        //B:
        switch (card) {
            case ACE:
                scoreBoard.put(ACE, scoreBoard.get(ACE) + 1);
                return scoreBoard;
            case TWO:
                scoreBoard.put(TWO, scoreBoard.get(TWO) + 1);
                return scoreBoard;
            case THREE:
                scoreBoard.put(THREE, scoreBoard.get(THREE) + 1);
                return scoreBoard;
            case FOUR:
                scoreBoard.put(FOUR, scoreBoard.get(FOUR) + 1);
                return scoreBoard;
            case FIVE:
                scoreBoard.put(FIVE, scoreBoard.get(FIVE) + 1);
                return scoreBoard;
            case SIX:
                scoreBoard.put(SIX, scoreBoard.get(SIX) + 1);
                return scoreBoard;
            case SEVEN:
                scoreBoard.put(SEVEN, scoreBoard.get(SEVEN) + 1);
                return scoreBoard;
            case EIGHT:
                scoreBoard.put(EIGHT, scoreBoard.get(EIGHT) + 1);
                return scoreBoard;
            case NINE:
                scoreBoard.put(NINE, scoreBoard.get(NINE) + 1);
                return scoreBoard;
            case TEN:
                scoreBoard.put(TEN, scoreBoard.get(TEN) + 1);
                return scoreBoard;
            case JACK:
                scoreBoard.put(JACK, scoreBoard.get(JACK) + 1);
                return scoreBoard;
            case QUEEN:
                scoreBoard.put(QUEEN, scoreBoard.get(QUEEN) + 1);
                return scoreBoard;
            case KING:
                scoreBoard.put(KING, scoreBoard.get(KING) + 1);
                return scoreBoard;
        }//End SW:*
        return scoreBoard;
    }//End M:*

    //Define: Calls record types on each card and ticks the matching tallies in scoreBoard
    public HashMap<Card.Value, Integer> checkHand(HashMap<Card.Value, Integer> countHolder, ArrayList<Card> cardHand) {
        for (int i = 0; i < cardHand.size(); i++) {
            recordTypes(cardHand.get(i).getValue(), countHolder);
        }//End F:*
        return countHolder;
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

    //Define: "sorry don't have that card dude." So, take a card from the deck.  
    public ArrayList<Card> drawCard(ArrayList<Card> cardHand) {
        cardHand.add(randShuffle());
        return cardHand;
    }//End M:*

    //Define: determine which card to ask for based on players hand having duplicates.
    public Card.Value[] cardDecision(
            HashMap<Card.Value, Integer> scoreBoard,
            Card.Value[] dupesHolder
    ) {

        //A: get storage for Cards range of values. 
        Card.Value[] values = Card.Value.values();

        //B: repeat. set a list of players duplicate values. 
        for (int i = 0; i < values.length; i++) {
            if (scoreBoard.get(values[i]) > 1) {
                dupesHolder[i] = values[i];
            }//End I:*
        }//End F:*

        //C: Copy the list. 
        return dupesHolder;
    }//End M:*

    //And uses it to remove the right card from my hand when I have to give the 
    //card to the other player. 
    //It calls another method who knows how to delete cards from a hand
    public ArrayList<Card> checkHandAndRemove(
            ArrayList<Card> cardHand,
            ArrayList<Integer> dupesHolder
    ) {

        if (dupesHolder != null) {
            cardHand = deleteCard(cardHand, dupesHolder.get(0));
        }//End I:*
        return cardHand;
    }//End M:*

    //Notice: player's hand is assumed to be ordered ascendingly already
    public Player checkBooks(Player player) {

        //Step 1: 
        ArrayList<Card> targetHand = player.getHand();
        Card.Value[] values = Card.Value.values();
        int[][] targetSB = player.getScoreBoard();
        int[][] books = player.getBooks();
        int posit;

        //Step 2: 
        for (int i = 0; i < 13; i++) {
            if (targetSB[i][1] >= 4) {

                //A: Update books var
                books[i][1] = 1; 

                //B: Get card type position
                posit = findPosit(targetHand, values[i]);

                //C: Remove book values from hand
                for (int j = 0; j < 4; j++) {
                    targetHand = deleteCard(targetHand, posit);//Think about it...
                }//End Inner F:*              
                //D: Reset players updated hand 
                player.setHand(targetHand);
            }//End I:*
        }//End Outer F:*
        //Step 3: 
        return player;
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

    //Takes as parameter a hash map with left key as card number and
    //right value is just the 4 amount value to indicate a book was made. 
    //Returns the players book
    public HashMap<Integer, Integer> updateBooks(HashMap<Integer, Integer> books, int[][] scoreBoard) {
        for (int i = 0; i < 13; i++) {
            if (scoreBoard[i][1] >= 4) {
                books.put(scoreBoard[i][0], scoreBoard[i][1]);
            }
        }
        return books;
    }

    //compares player objects field var books. 
    //Comparison is based on nunber of key value pairs in books 
    public Player determineWinner(Player human,
            Player computer,
            HashMap<Card.Value, Integer> hBook,
            HashMap<Card.Value, Integer> cBook,
            Player winner) {
        if (hBook.size() > cBook.size()) {
            winner = human;
        } //End I:*
        else {
            winner = computer;
        }//End E:*
        return winner;
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
    
    public int[][] createScoreBoard(int[][] sb) {
        //array_name[row_index][column_index] = value;
        scoreBoard = sb;
        for (int i = 0; i < scoreBoard.length; i++) {
            scoreBoard[i][0] = i + 1;
            scoreBoard[i][1] = 0;          
        }//End F:*
        return scoreBoard;
    }//End M:*

}//End class
