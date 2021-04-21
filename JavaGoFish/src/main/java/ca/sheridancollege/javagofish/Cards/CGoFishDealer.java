/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.javagofish.Cards;

import ca.sheridancollege.javagofish.Players.APlayer;
import ca.sheridancollege.javagofish.Turns.AScoreBoard;
import ca.sheridancollege.javagofish.Utility.Printer;
import java.nio.BufferOverflowException;
import java.util.ArrayList;
import java.util.List;

/**
 * CGOFISHHAND CLASS:
 *
 * This is a concrete version of AHand. This models hands for a hand made up of
 * Go Fish cards and what needs to happen to them throughout a game. I added some exception
 * handling to the methods for worst case scenarios. The try portion is the best case and the 
 * catch is the worst case.
 *
 *
 * @author AllyCat13.
 */
    public class CGoFishDealer extends ADealer 

{

    public CGoFishDealer(ADeck deck, AScoreBoard sb) 
    {
        super(deck, sb);
        this.deckSetup();
    }//End C:*

    @Override
    public void addCardToHand(APlayer inPlay, ACard inPlaysDesireC, APlayer notInPlay) 
    {
        try {//STRT TRY:*

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

        }//End TRY:*
        catch (Exception e) 
        {
            System.out.println("Players could be null or hands being updated: " + e);
        }//End CAT:*

    }//End M:*

    @Override
    public int findPositPartialCard(APlayer player, ACard tCard) 
    {
        try 
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
        }//End TRY:*
        catch (Exception e) 
        {
            System.out.println(e);
        }//End CAT:*

        return -1;
    }//End M:*

    @Override
    public ACard createRandoCard() 
    {
        try 
        {
            //A: create: ranges for random number to map against. 
            //Notice: this is the best case scenario.

            //B: Create: the random numbers modelling suit and values. 
            int valPossible = (int) (Math.random() * ACard.valuesRange.length) + 1;

            //C: asssign: the values determined by a random number
            ACard resCard = this.classDeck.getDeck().get(valPossible);

            //D: create: the card object and copy it. 
            this.removeCard(resCard, this.classDeck.getDeck());

            //E: Remember:
            return resCard;

        }//End TRY:*
        catch (NullPointerException | IndexOutOfBoundsException e) 
        {
            System.out.println(e);
        }//End CAT:*

        //Leave: worst case scenario. 
        return null;
    }//End M:*

    @Override
    public ACard startDeal() 
    {
        try 
        {

            ACard card;
            card = this.classDeck.getDeck().get(0);
            //B: 
            this.classDeck.getDeck().remove(0);
            //C: 
            return card;
        }//End TRY:*
        catch (NullPointerException | IndexOutOfBoundsException e) 
        {
            System.out.println("ADeck field could be null or deck index is incorrect " + e);
        }//End CAT:*

        //Leave: worst case scenario. 
        return null;
    }//End M:*

    @Override
    public void createHand(int size, APlayer player) 
    {
        try 
        {
            player.setHand(new ArrayList<>());

            for (int i = 0; i < size; i++) 
            {
                player.getHand().add(this.startDeal());
            }//End F:*  

        }//End TRY:*
        catch (NullPointerException | BufferOverflowException e) 
        {
            System.out.println("" + e);
        }//End CAT:*

    }//End M:*

    @Override
    public void sort(APlayer player, char option) 
    {
        try 
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
        }//End TRY:*
        catch (Exception e) 
        {
            System.out.println(e);
        }//End CAT:*
    }//End M:*

    @Override
    public void deleteCardFromHand(APlayer notInPlay, int posit) 
    {
        try 
        {
            notInPlay.getHand().remove(posit);
        }//End TRY:*
        catch (ArrayIndexOutOfBoundsException | StackOverflowError e) 
        {
            System.out.println(e);
        }//End CAT:*

    }//End M:*

    @Override
    public void deleteCardFromDList(APlayer notInPlay, int posit) 
    {
        try 
        {
            notInPlay.getDesirableList().remove(posit);
        } catch (ArrayIndexOutOfBoundsException | StackOverflowError e) 
        {
            System.out.println(e);
        }//End CAT:*

    }//End M:*

    @Override
    public void getCardFromDeck(APlayer player) 
    {
        try 
        {
            player.getHand().add(createRandoCard());
            System.out.println("");

            System.out.println("");
            System.out.println("Calculating dupes for " + player.getName());
            this.scoreBoard.getDupes(player);

            System.out.println("");
            System.out.println(player.getName() + " dupes: " + player.getDesirableList().toString());
        }//End TRY:*
        catch (Exception e) 
        {
            System.out.println(e);
        }//End CAT:*

    }//End M:*

    @Override
    public void updateHandDelete(APlayer notInPlay, ACard inPlaysDesireC) 
    {
        try 
        {
            int pHTemp = findPositFullCard(notInPlay, inPlaysDesireC);
            int pDTemp = findPositFullCardDList(notInPlay, inPlaysDesireC);

            deleteCardFromDList(notInPlay, pDTemp);
            deleteCardFromHand(notInPlay, pHTemp);
        }//End TRY:*
        catch (Exception e) 
        {
            System.out.println(e);
        }//End CAT:*

    }//End M:*

    @Override
    public void updateHandAdd(APlayer inPlay, ACard inPlaysDesireC, APlayer notInPlay) 
    {
        try 
        {
            addCardToHand(inPlay, inPlaysDesireC, notInPlay);
        }//End TRY:*
        catch (Exception e) 
        {
            System.out.println(e);
        }//end CAT:*

    }//End M:*

    @Override
    public int findPositFullCard(APlayer player, ACard tCard) 
    {
        try 
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
        }//End TRY:*
        catch (NullPointerException | ArrayIndexOutOfBoundsException e) 
        {
            System.out.println(e);
        }//End CAT:*
        return -1;
    }//End M:*

    @Override
    public int findPositFullCardDList(APlayer player, ACard tCard) 
    {
        try 
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
        }//End TRY:*
        catch (NullPointerException | ArrayIndexOutOfBoundsException e) 
        {
            System.out.println("player could be null, card could be null, index might be out of bounds " + e);
        }//End CAT:*

        return -1;
    }//End M:*

    @Override
    public void deckSetup() 
    {
        this.classDeck.initDeck();
        this.classDeck.shuffle();
    }//End M:*

    @Override
    public void removeCard(ACard card, List<ACard> tHand) 
    {
        try 
        {
            tHand.remove(findPosit(tHand, card));
        }//End TRY:*
        catch (Exception e) 
        {
            System.out.println(e);
        }//End CAT:*

    }//End M:*

    @Override
    public int findPosit(List<ACard> hand, ACard tCard) 
    {
        try 
        {
            int posit = 0;
            for (int i = 0; i < hand.size(); i++) 
            {
                if (hand.get(i).equals(tCard)) 
                {
                    posit = i;
                    return posit;
                }//End I:*
            }//End F:*
            return posit;
        }//End tRY:*
        catch (NullPointerException | ArrayIndexOutOfBoundsException e) 
        {
            System.out.println(e);
        }//End CAT:*
        return -1;
    }///End M:*

}//End CL:*
