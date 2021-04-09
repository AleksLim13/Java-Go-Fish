/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.javagofish.Cards;

import ca.sheridancollege.javagofish.Players.APlayer;
import ca.sheridancollege.javagofish.Turns.AScoreBoard;
import ca.sheridancollege.javagofish.Utility.Printer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 *
 *
 *
 * @author AllyCat13.
 */
public class CGoFishHand extends AHand 

{

    public CGoFishHand(ADeck deck, AScoreBoard sb) 
    {
        super(deck, sb);
    }//End C:*

    @Override
    public void addCardToHand(APlayer inPlay, ACard inPlaysDesireC, APlayer notInPlay) 
    {
        //A: Find: 
        int posit = findPositPartialCard(notInPlay, inPlaysDesireC);
        //B: Get:
        ACard cTemp = notInPlay.getHand().get(posit);
        //C: Remove: 
        updateHandDelete(notInPlay, cTemp);
        //D: Add: 
        inPlay.getHand().add(cTemp);

        //E: 
        System.out.println("");
        System.out.println("Calculating dupes for " + inPlay.getName());
        //E.1: Calculate:
        this.scoreBoard.getDupes(inPlay);
        System.out.println("");
        //E.2: Order: 
        this.sort(inPlay, 'd');
        System.out.println(inPlay.getName() + " dupes: ");
        //E.3: Display: 
        Printer.printHand(inPlay.getDesirableList());
    }

    @Override
    public int findPositPartialCard(APlayer player, ACard tCard) 
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

    @Override
    public ACard createRandoCard() 
    {
        //A: create: ranges for random number to map against. 

        //B: Create: the random numbers modelling suit and values. 
        int valPossible = (int) (Math.random() * ACard.valuesRange.length) + 1;

        //C: asssign: the values determined by a random number
        ACard resCard = this.classDeck.getDeck().get(valPossible);

        //D: create: the card object and copy it. 
        this.classDeck.removeCard(resCard);

        return resCard;
    }//End M:*

    @Override
    public ACard startDeal() 
    {
        ACard card;
        card = this.classDeck.getDeck().get(0);
        //B: 
        this.classDeck.getDeck().remove(0);
        //C: 
        return card;
    }//End M:*

    @Override
    public void createHand(int size, APlayer player) 
    {
        player.setHand(new ArrayList<>());

        for (int i = 0; i < size; i++) 
        {
            player.getHand().add(this.startDeal());
        }//End F:*         
    }//End M:*

    @Override
    public void sort(APlayer player, char option) 
    {
        List<ACard> optList = new ArrayList<>();

        if (option == 'h') 
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

                ACard tmp = null;

                if ((int) cv1 > (int) cv2) 
                {
                    tmp = optList.get(i);
                    optList.set(i, optList.get(j));
                    optList.set(j, tmp);
                }//End I:*
            }//End In F:*
        }//End Out F:*    
    }//End M:*

    @Override
    public void deleteCardFromHand(APlayer notInPlay, int posit) 
    {
        notInPlay.getHand().remove(posit);
    }//End M:*

    @Override
    public void deleteCardFromDList(APlayer notInPlay, int posit) 
    {
        notInPlay.getDesirableList().remove(posit);
    }//End M:*

    @Override
    public void getCardFromDeck(APlayer player) 
    {
        player.getHand().add(createRandoCard());
        System.out.println("");

        System.out.println("");
        System.out.println("Calculating dupes for " + player.getName());
        this.scoreBoard.getDupes(player);

        System.out.println("");
        System.out.println(player.getName() + " dupes: " + player.getDesirableList().toString());
    }//End M:*

    @Override
    public void updateHandDelete(APlayer notInPlay, ACard inPlaysDesireC) 
    {
        int pHTemp = findPositFullCard(notInPlay, inPlaysDesireC);
        int pDTemp = findPositFullCardDList(notInPlay, inPlaysDesireC);
        
        deleteCardFromDList(notInPlay, pDTemp);
        deleteCardFromHand(notInPlay, pHTemp);
    }//End M:*

    @Override
    public void updateHandAdd(APlayer inPlay, ACard inPlaysDesireC, APlayer notInPlay) 
    {
        addCardToHand(inPlay, inPlaysDesireC, notInPlay);
    }//End M:*

    @Override
    public int findPositFullCard(APlayer player, ACard tCard) 
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

    @Override
    public int findPositFullCardDList(APlayer player, ACard tCard) 
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

    @Override
    public void deckSetup() 
    {
        this.classDeck.initDeck();
        this.classDeck.shuffle();
    }//End M:*

}//End CL:*
