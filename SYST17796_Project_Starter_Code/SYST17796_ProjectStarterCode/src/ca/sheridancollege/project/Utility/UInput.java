
package ca.sheridancollege.project.Utility;




/**
 *
 * @author Aleks Lim @ Sheridann College 2021
 */


import java.util.InputMismatchException;
import java.util.Scanner;

public class UInput {

    public UInput() {
        // TODO Auto-generated constructor stub
    }

    public double promptDoubleUser(Scanner input) {
        boolean continueInput = true;
        double userNum = 0.0;

        do {
            try {

                System.out.println("Enter a double like 3.0");
                userNum = input.nextDouble();
                continueInput = false;
            } catch (InputMismatchException ex) {
                System.out.println("Not a double!");
                input.nextLine();
            }

        } while (continueInput);

        return userNum;
    }

    public int promptIntUser(Scanner input) {
        boolean continueInput = true;
        int userNum = 0;

        do {
            try {

                System.out.println("Enter a integer like 3");
                userNum = input.nextInt();
                continueInput = false;
            } catch (InputMismatchException ex) {
                System.out.println("Not a Integer!");
                input.nextLine();
            }

        } while (continueInput);

        return userNum;
    }

    public String promptStringUser(Scanner input) {
        boolean continueInput = true;
        String userPrompt = " ";

        do {
            try {

                System.out.println("Enter a String: ");
                userPrompt = input.next();
                continueInput = false;
            } catch (InputMismatchException ex) {
                System.out.println("Not a String!");
                input.nextLine();
            }

        } while (continueInput);

        return userPrompt;
    }

    /*
    public ca.sheridancollege.project.Cards.Card.Suit pickASuit(CardTrick cardTrick){
        String uSuit = promptStringUser(new Scanner(System.in));
        Suit tSuit;
        tSuit = cardTrick.pickASuit(uSuit);
        return tSuit;
    }
    */
    
    /*
    public ca.sheridancollege.project.Cards.Card.Value pickAValue(Scanner input, CardTrick cardTrick){
        //A: 
        
        Value tValue;
        
        //B: 
        System.out.println("Pick a value please");
        if(input.hasNextInt()){
            tValue = cardTrick.pickAValue(input.nextInt());
        }
        else {
            tValue = cardTrick.pickAValue(input.next());
        }
        
        //C: 
        return tValue;
    }
    */


}//End class
