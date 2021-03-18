
package ca.sheridancollege.project.Utility;

/**
 *
 * @author AllyCat13 @ Sheridan High 2021
 */

//Imports:_____________________________

import java.util.InputMismatchException;
import java.util.Scanner;

public class UInput {

    private static Scanner input; 

    public UInput() {
        UInput.input = new Scanner(System.in);
    }//End C:*
    
    public UInput(Scanner input) {
        // TODO Auto-generated constructor stub
        UInput.input = input; 
    }//End C:*

    public Scanner getInput() {
        return input;
    }
    
    

    public static double promptDoubleUser() {
        boolean continueInput = true;
        double userNum = 0.0;

        do {
            try {

                System.out.println("Enter a double like 0.0");
                userNum = input.nextDouble();
                continueInput = false;
            } //End TR:*
            
            catch (InputMismatchException ex) {
                System.out.println("Not a double!");
                input.nextLine();
            }//End CAT:*

        } while (continueInput);
        return userNum;
    }//End M:*

    public static int promptIntUser() {
        boolean continueInput = true;
        int userNum = 0;

        do {
            try {

                System.out.println("Enter a integer like 3");
                userNum = input.nextInt();
                continueInput = false;
            } //End TR:*
            catch (InputMismatchException ex) {
                System.out.println("Not a Integer!");
                input.nextLine();
            }//End CAT:*

        } //End D:*
        while (continueInput);
        
        //Copy: 
        return userNum;
    }//End M:*

    public static String promptStringUser() {
        boolean continueInput = true;
        String userPrompt = " ";

        do {
            
            try {

                System.out.println("Enter a String: ");
                userPrompt = input.next();
                continueInput = false;
            } //End TR:*
            
            catch (InputMismatchException ex) {
                System.out.println("Not a String!");
                input.nextLine();
            }//End CAT:*

        } //End D:*
        while (continueInput);
        //Copy: 
        return userPrompt;
    }//End M:*

}//End cl:*
