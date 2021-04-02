/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project.Cards;

import ca.sheridancollege.project.Players.Player;
import ca.sheridancollege.project.Turns.Deck;
import ca.sheridancollege.project.Turns.ScoreBoard;
import ca.sheridancollege.project.Utility.Printer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AllyCat13:
 *
 */
public class Hand {

    private final ScoreBoard scoreBoard;
    private Deck deck;

    public Hand(Deck deck, ScoreBoard sb) {
        this.deck = deck;
        this.scoreBoard = sb;
        this.deckSetup();
    }//End C:*

    public Deck getDeck() {
        return this.deck;
    }//End G:*

    public void setDeck(Deck deck) {
        this.deck = deck;
    }//End S:*

    //Define: yes. the opponent has the card. add to inplay and subtract not in play.
    private void addCardToHand(
            Player inPlay, //inplay
            Card inPlaysDesireC, //in plays desire
            Player notInPlay //remove from
    ) {

        int posit = findPositPartialCard(notInPlay, inPlaysDesireC);
        Card cTemp = notInPlay.getHand().get(posit);
        notInPlay.getHand().remove(posit);
        inPlay.getHand().add(cTemp);

        System.out.println("");
        System.out.println("Calculating books on " + cTemp.toString());
        this.scoreBoard.calcBooks(cTemp, inPlay);

        System.out.println("");
        System.out.println("Calculating dupes for " + inPlay.getName());
        this.scoreBoard.getDupes(inPlay);

        System.out.println("");
        this.sort(inPlay, 'd');
        System.out.println(inPlay.getName() + " dupes: ");
        Printer.printHand(inPlay.getDesirableList());

    }//End M:*

    //Define: opponent has card. Remove it after giving it to player in play. 
    private void deleteCardFromHand(
            Player notInPlay,
            int posit
    ) {

        notInPlay.getHand().remove(posit);
    }//End M:*

    //Define: "sorry don't have that card dude." Allor, take a card from the deck.  
    public void getCardFromDeck(Player player) {
        player.getHand().add(createRandoCard());
        System.out.println("");

        System.out.println("Calculating books on " + player
                .getHand()
                .get(
                        player
                                .getHand()
                                .size() - 1
                )//End G:*
                .toString()
        );//End M:*
        this.scoreBoard.calcBooks(
                player
                        .getHand()
                        .get(
                                player
                                        .getHand()
                                        .size() - 1
                        ), //End G:*
                player
        );//End M:*

        System.out.println("");
        System.out.println("Calculating dupes for " + player.getName());
        this.scoreBoard.getDupes(player);

        System.out.println("");
        System.out.println(player.getName() + " dupes: " + player.getDesirableList().toString());
    }//End M:*

    //Define: Not in play has the card. Remove it from not in play. 
    public void updateHandDelete(
            Player notInPlay,//Incl: list for C's.
            Card inPlaysDesireC//Incl: list for copies. 
    ) {
        int pTemp = findPositFullCard(notInPlay, inPlaysDesireC);
        deleteCardFromHand(notInPlay, pTemp);
    }//End M:*

    //Define: ablility to remove target from other players hand. Calls delete method. 
    public void updateHandAdd(
            Player inPlay,//Incl: list for C's.
            Card inPlaysDesireC,//Incl: list for copies. 
            Player notInPlay
    ) 
    {
        addCardToHand(inPlay, inPlaysDesireC, notInPlay);
    }//End M:*

    //Need to know what the index of the card need to remove 
    //from hand
    //Define: 
    private int findPositFullCard(Player player, Card tCard) 
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

    //Define: 
    private int findPositPartialCard(Player player, Card tCard) 
    {
        int posit = 0;
        for (int i = 0; i < player.getHand().size(); i++) 
        {
            if (player.getHand().get(i).getValue().equals(tCard.getValue())) 
            {
                posit = i;
                return posit;
            }//End I:*
        }//End F:*
        return posit;
    }//End M:*

    //Define: behavior for taking random card from deck after told to go fish. 
    private Card createRandoCard() 
    {
        //A: create: ranges for random number to map against. 

        //B: Create: the random numbers modelling suit and values. 
        int valPossible = (int) (Math.random() * Card.valuesRange.length) + 1;

        //C: asssign: the values determined by a random number
        Card resCard = this.deck.getDeck().get(valPossible);

        //D: create: the card object and copy it. 
        this.deck.removeCard(resCard);

        return resCard;
    }//End M:*

    //Methods:_________________________
    //Define: this fills deck and shuffles it. Uses 2 known methods.
    private void deckSetup() 
    {
        this.deck.initDeck();
        this.deck.shuffle();
    }//End M:*

    //Define: Deal first card and simultaneously remove it from deck.
    private Card startDeal() 
    {//Notice: end of line style looks better.
        Card card;
        card = this.deck.getDeck().get(0);
        //B: 
        this.deck.getDeck().remove(0);
        //C: 
        return card;
    }//End M:*

    //Define: provide number of cards. Repetition solution. Call's start deal.
    public void createHand(int size, Player player) 
    {
        player.setHand(new ArrayList<>());

        for (int i = 0; i < size; i++) {
            player.getHand().add(this.startDeal());
        }//End F:*         
    }//End M:

    public void sort(Player player, char option) 
    { 
        
        List<Card> optList = new ArrayList<>();
        
        if(option == 'h')
        {
            optList = player.getHand();
        }//End I:*
        
        else if (option == 'd')
        {
            optList = player.getDesirableList();
        }//End EI:*
        
        //Notice: watch nested for loop structure. 
        for (int i = 0; i < optList.size(); i++) 
        {       
            for (int j = i + 1; j < optList.size(); j++) 
                
            {
                //Get: value of card and store it in String VAR.
                String v1 = optList.get(i).getValue();
                char cv1 = v1.charAt(0);
                
                String v2 = optList.get(j).getValue();
                char cv2 = v2.charAt(0);
                //Extract: use char at to get first letter of above step. 
                             
                Card tmp = null;
                
                if ((int)cv1 > (int)cv2) 
                {
                    tmp = optList.get(i);
                    optList.set(i, optList.get(j));
                    optList.set(j, tmp);
                }//End I:*
            }//End In F:*
        }//End Out F:*
    }//End M:*

}//End CL:*
