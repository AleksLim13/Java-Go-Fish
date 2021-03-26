package ca.sheridancollege.project.Start;

//Imports:__________________________

import ca.sheridancollege.project.Cards.Card;
import ca.sheridancollege.project.Players.CompPlayer;
import ca.sheridancollege.project.Players.HumanPlayer;
import ca.sheridancollege.project.Players.Player;
import ca.sheridancollege.project.Turns.Dealer;
import ca.sheridancollege.project.Turns.Deck;
import ca.sheridancollege.project.Turns.TurnSwitcher;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author AllyCat13 @ Sheridan High 2021
 */
public class GoFish extends Game {

    private final Dealer dealer; 
    private final Player human;
    private final Player computer;
    private final TurnSwitcher turnController;
   
            
    public GoFish(     String hName,
                       ArrayList<Card> hand,
                       ArrayList<Card> desirableList,
                       String cName,
                       TurnSwitcher turnController) {
        super("Go Fish");
        this.dealer = new Dealer(new Deck(), new ArrayList<>());
        this.human = new HumanPlayer();
        this.computer = new CompPlayer();
       this.turnController = turnController; 
        
    }//End C:*
    public GoFish(
                  Dealer dealer,
                  Player human,
                  Player computer,
                  TurnSwitcher turnController
                  ) {
        super("Go Fish");
        this.dealer = dealer;
        this.human = human;
        this.computer = computer;
        this.turnController = turnController; 
    }//End C:*

    public Dealer getDealer() {
        return dealer;
    }

    public Player getHuman() {
        return human;
    }

    public Player getComputer() {
        return computer;
    }

    public TurnSwitcher getTurnController() {
        return turnController;
    }

    
    @Override
    public void play() {

        
      
    }//End M:*
    


    @Override
    public void declareWinner() {

        //To change body of generated methods, choose Tools | Templates.
    }//End M:*
    
    


}//End Class:________________+

class PseudoCard {

    private String value;
    private String suit;
    public String[] suits = {"hearts", "clubs", "diamonds", "spades"};
    public String[] values = {"ace", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "jack", "queen", "king"};
    private List<PseudoCard> pseudoDeck;

    public PseudoCard(String value, String suit) {
        this.value = value;
        this.suit = suit;
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