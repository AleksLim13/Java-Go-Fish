/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//Imports:_____________________________

package ca.sheridancollege.project.Turns;
import ca.sheridancollege.project.Cards.Card;
import ca.sheridancollege.project.Cards.GoFishCard;
import java.util.ArrayList;

/**
 *
 * @author AllyCat13 @ Sheridan High 2021
 */
public class Deck {
    
    //Fields:________________________
    
    private ArrayList<Card> deck; 
    
    //Constructors:______________________
    
    //Empty constructor  
    public Deck() {     
        this.deck = new ArrayList<>();
    }//End C:*
    
    
    //Getters & Setters:____________________
    
        public ArrayList<Card> getDeck() {
        return deck;
    }//End G:*

    //Of objects as cards with 2 fields 
    //Takes blank array list as param 
    public void initDeck() {  
		for(Card.Suit suits: Card.Suit.values())
                {
                    for(Card.Value values: Card.Value.values())
                    {
                        deck.add(new GoFishCard(suits,values));                   
                    }//End Inner F:*
                }//end outter for   
    }//End M:*
    
  
    //Main functionality here...The old swaperoo!
    //Swap pairs of card objects at random positions / 52.
    //Needs the actually value of this class's field var
    //deck after it's been initialized. 
    public void shuffle() {
        int rando;
        for (int i = 0; i < deck.size(); i++) {
            rando = (int) (Math.random() * 52) + 1;        
            Card temp = deck.get(i);
            deck.set(i, deck.get(rando));
            deck.set(rando, temp);         
        }//End Outer F:*
    }//End M:*
} //End class:_______________________
