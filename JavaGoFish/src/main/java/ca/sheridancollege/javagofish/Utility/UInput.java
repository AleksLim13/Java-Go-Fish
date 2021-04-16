
package ca.sheridancollege.javagofish.Utility;

/**
 * We need a class for encapsulating all the user input data.
 * All methods are static because they should always be the same for every client. 
 * @author AllyCat13 @ Sheridan High 2021
 */

//Imports:_____________________________

import java.util.InputMismatchException;
import java.util.Scanner;

public final class UInput 

{

    /**
     * Field variable of Scanner type because wee need Scanners functionality. 
     * Static because one copy can stay the same per any number of clients.
     */
    private static Scanner input; 

    
    public static void setInput(Scanner input)
    
    {
        UInput.input = input;
    }//End M:*
    
    public UInput() 
    {
      
    }//End C:*
    
    public Scanner getInput() 
    {
        return UInput.input;
    }
    
    /**
     * When a decimal value is needed from the user.
     * @return Double type result. 
     */
    public static double promptDoubleUser() 
    {
        boolean continueInput = true;
        double userNum = 0.0;

        do {
            try 
            {

                System.out.println("Enter a double like 0.0");
                userNum = input.nextDouble();
                continueInput = false;
            } //End TR:*
            
            catch (InputMismatchException ex) 
            {
                System.out.println("Not a double!");
                input.nextLine();
            }//End CAT:*

        }//End DO:*
        
        while (continueInput);
        
        return userNum;
    }//End M:*

    /**
     * When a whole number is needed from the user.
     * @return integer as the result. 
     */
    public static int promptIntUser() 
    
    {
        boolean continueInput = true;
        int userNum = 0;

        do 
        
        {
            try 
            
            {

                System.out.println("Enter a integer like 3");
                userNum = input.nextInt();
                continueInput = false;
            } //End TR:*
            catch (InputMismatchException e) 
            {
                System.out.println("Not a Integer!");
                input.nextLine();
            }//End CAT:*

        } //End D:*
        while (continueInput);
        
        //Copy: 
        return userNum;
    }//End M:*

    /**
     * When we need a word or sentence from the user.
     * @return String type as result. 
     */
    public static String promptStringUser() 
    
    {
        boolean continueInput = true;
        String userPrompt = " ";

        do  
        {
            
            try 
            
            {

                System.out.println("Enter a String: ");
                userPrompt = input.next();
                continueInput = false;
            } //End TR:*
            
            catch (InputMismatchException ex) 
            {
                System.out.println("Not a String!");
                input.nextLine();
            }//End CAT:*

        } //End D:*
        while (continueInput);
        //Copy: 
        return userPrompt;
    }//End M:*

}//End cl:*
