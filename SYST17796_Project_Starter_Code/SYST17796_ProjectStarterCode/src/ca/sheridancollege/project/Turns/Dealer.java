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
        }
              
            for (int i = 0; i < size; i++) {
                hand.add(this.startDeal());
            }//End F:*
       

    }//End M:*

    //Recall: enum Value{ACE, ..., KING};
    public int[][] recordTypes(//Note: tally increm.
            Card.Value card,//Incl: card item. 
            int[][] scoreBoard//Incl: 2d Arry. 
                            ) {
        switch (card) {//Alt: multiple cards.
            case ACE:
                scoreBoard[0][1] += 1;
                return scoreBoard;
            case TWO:
                scoreBoard[1][1] += 1;
                return scoreBoard;
            case THREE:
                scoreBoard[2][1] += 1;
                return scoreBoard;
            case FOUR:
                scoreBoard[3][1] += 1;
                return scoreBoard;
            case FIVE:
                scoreBoard[4][1] += 1;
                return scoreBoard;
            case SIX:
                scoreBoard[5][1] += 1;
                return scoreBoard;
            case SEVEN:
                scoreBoard[6][1] += 1;
                return scoreBoard;
            case EIGHT:
                scoreBoard[7][1] += 1;
                return scoreBoard;
            case NINE:
                scoreBoard[8][1] += 1;
                return scoreBoard;
            case TEN:
                scoreBoard[9][1] += 1;
                return scoreBoard;
            case JACK:
                scoreBoard[10][1] += 1;
                return scoreBoard;
            case QUEEN:
                scoreBoard[11][1] += 1;
                return scoreBoard;
            case KING:
                scoreBoard[12][1] += 1;
                return scoreBoard;
        }//End SW:*
        return scoreBoard;
    }//End M:*

    //Define: Calls record types on each card and ticks the matching tallies in scoreBoard
    public int[][] checkHand(int[][] countHolder, ArrayList<Card> cardHand) {
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

    //Define: "sorry don't have that card dude." Allor, take a card from the deck.  
    public ArrayList<Card> drawCard(ArrayList<Card> cardHand) {
        cardHand.add(randShuffle());
        return cardHand;
    }//End M:*

    //Define: determine which card to ask for based on players hand having duplicates.
    public Card.Value[] cardDecision(
            int[][] scoreBoard,//R:13,J:2 2DAR
            Card.Value[] dupesHolder//enum 1-13, A-K.
                                    ) {

        //A: get storage for Cards range of values.  A-K, 13x2
        Card.Value[] values = Card.Value.values();

        //B: repeat. set a list of players duplicate values. 
        for (int i = 0; i < scoreBoard.length; i++) {
            //Eval: right column. top-bottom. 
            if (scoreBoard[i][1] > 1) {
                //Assi: save right Card value to same type array. 
                dupesHolder[i] = values[i];
            }//End I:*
        }//End F:*

        //C: Copy the list. Remember the gist.
        return dupesHolder;
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

    //Notice: player's hand is assumed to be ordered ascendingly already
    public Player checkBooks(Player player) {

        //Declare: Assi:  
        ArrayList<Card> targetHand = player.getHand();
        Card.Value[] values = Card.Value.values();
        int[][] targetSB = player.getScoreBoard();
        int[][] books = player.getBooks();
        int posit;

        //Repeat: Step 2:
        for (int i = 0; i < targetSB.length; i++) {
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

  
    //Returns the players book
    public int[][] updateBooks(int[][] books, int[][] scoreBoard) {
        for (int i = 0; i < scoreBoard.length; i++) {
            if (scoreBoard[i][1] >= 4) {
                books[i][1] = 1;
            }//End I:*
        }//End F:*
        return books;
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
