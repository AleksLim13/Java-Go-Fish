/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project.Turns;
import ca.sheridancollege.project.Cards.Card;
import ca.sheridancollege.project.Cards.GoFishCard;
import ca.sheridancollege.project.Cards.Card.Suit;
import ca.sheridancollege.project.Cards.Card.Value;

import java.util.ArrayList;

/**
 *
 * @author AllyCat13 @ Sheridan High 2021
 */
public class Deck {

    private ArrayList<Card> deck;
    Suit suit = Suit.DEFAULT;
    Value value = Value.DEFAULT;
    private Card cardStuff = new GoFishCard(suit, value); 
    private Suit[] suitList; 
    private Value[] valueList; 

    
    //Empty constructor  
    public Deck() {

    }
    
    //Call this first
    public void initDI(
                       ArrayList<Card> deck, 
                       Suit[] suitList, 
                       Value[] valueList
                       ) 
    {
      
        this.deck = deck;
        this.suitList = suitList;
        this.valueList = valueList; 
    }
    
    //Call First
    public void setMyLists(){
    cardStuff.setSuitList();
    cardStuff.setValueList();
    }
    
    //Call second 
    public void assignMyLists(){
       this.suitList = cardStuff.getSuitList();
       this.valueList = cardStuff.getValueList();
    }

 
    //Of objects as cards with 2 fields 
    //Takes blank array list as param 
    public ArrayList<Card> initDeck(ArrayList<Card> tDeck) {

        //A: 
        //Assumes values list are set elsewhere
        
        
        //B:
        for (int i = 0; i < valueList.length; i++) {
            //C: 
            for (int j = 0; j < suitList.length; j++) {
              
                tDeck.add(new GoFishCard(suitList[j], valueList[i]));
            }
        }
        
        //C: 
        return tDeck; 
      
    }
    
  
    //Main functionality here...The old swaperoo!
    //Swap pairs of card objects at random positions / 52.
    //Needs the actually value of this class's field var
    //deck after it's been initialized. 
    public ArrayList<Card> shuffle(ArrayList<Card> tDeck) {

        //A: Create 
        int rando;
        for (int i = 0; i < tDeck.size()-1; i++) {
            rando = (int) (Math.random() * 59) + 1;

            //C: 
            for (int j = 0; j < 1; j++) {

                //C.1: 
                Card temp = tDeck.get(i);
                tDeck.set(i, tDeck.get(rando));
                tDeck.set(rando, temp);

            }//End C

        }
        return tDeck; 
    }
    
    //To set a new deck 
    //Just to reset it if needed
    public void setDeck(ArrayList<Card> newDeck) {
        this.deck = newDeck;
    }
    
    //Normal getter method 
    //Returns value of field var deck of this class
    public ArrayList<Card> getDeck() {
        return deck;
    }
   
    
    
    

} //End class
