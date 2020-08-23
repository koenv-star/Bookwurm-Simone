package be.koencorp.bookApp.tools;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * ConsoleInputTool
 * A Utility class to get input from the user using the console
 *
 * @version 2.3.0 , 12-may-2020
 */
public final class ConsoleInputTool {
   Scanner keyboard = new Scanner(System.in);

   /**
    * Initializes a new ConsoleInputTool object, connected with System.in
    */
   public ConsoleInputTool() {
   }

   /**
    * Requests the user to press the return key to continue.
    */
   public void askPressEnterToContinue() {
      System.out.print("Press enter to continue.");
      keyboard.nextLine();
   }

   /**
    * Ask the user for a boolean(may repeat until input is correct).
    * when the use leaves the input blank the default value will be used if allowed.
    *
    * @param question          The question to ask(print to) the user.
    * @param allowBlankDefault whether the user is allowed to input a blank line, use default value.
    * @param defaultValue      The default value to use if the user inputs a blank line.
    * @return the user input: string.
    */
   public boolean askUserYesNoQuestion(String question, boolean allowBlankDefault, boolean defaultValue) {
      do {
         System.out.print(question);
         String answer = keyboard.nextLine();
         answer = answer.toLowerCase();
         if (answer.equals("y") || answer.equals("yes") || answer.equals("j") || answer.equals("ja")) return true;
         else if (answer.equals("n") || answer.equals("no") || answer.equals("nee")) return false;
         else if (allowBlankDefault && answer.isBlank()) return defaultValue;
         System.err.println("Error: input must be y or n.");
      } while (true);
   }

   /**
    * Ask the user for a boolean(repeat until input is correct).
    *
    * @param question The question to ask(print to) the user.
    * @return the user input: string.
    */
   public boolean askUserYesNoQuestion(String question) {
      return askUserYesNoQuestion(question, false, false);
   }

   /**
    * Ask the user for a boolean(repeat until input is correct).
    * when the use leaves the input blank the default value will be used.
    *
    * @param question     The question to ask(print to) the user.
    * @param defaultValue The default value to use if the user inputs a blank line.
    * @return the user input: string.
    */
   public boolean askUserYesNoQuestion(String question, boolean defaultValue) {
      return askUserYesNoQuestion(question, true, defaultValue);
   }

   /**
    * Ask the user for a String(repeat until input is correct).
    *
    * @param question          the question to ask(print to) the user.
    * @param minimumCharacters the minimum length of String to return.
    * @return the user input: string.
    */
   public String askUserString(String question, int minimumCharacters) {
      if (minimumCharacters <= 0) {
         System.out.print(question);
         return keyboard.nextLine();
      } else {
         String input;
         do {
            System.out.print(question);
            input = keyboard.nextLine();
            if (input.length() < minimumCharacters)
               System.err.format("Error: Input must be at least %d character%s.\n", minimumCharacters, minimumCharacters > 1 ? "s" : "");
         } while (input.length() < minimumCharacters);
         return input;
      }
   }


   /**
    * Ask the user for a String(repeat until input is correct).
    *
    * @param question          the question to ask(print to) the user.
    * @param minimumCharacters the minimum length of String to return.
    * @param maximumCharacters the maximum length of String to return.
    * @return the user input: string.
    */
   public String askUserString(String question, int minimumCharacters, int maximumCharacters) {
      String input;
      do {
         System.out.print(question);
         input = keyboard.nextLine();
         if (input.length() < minimumCharacters)
            System.err.format("Error: Input must be at least %d character%s.\n", minimumCharacters, minimumCharacters > 1 ? "s" : "");
         if (input.length() > maximumCharacters)
            System.err.format("Error: Input must be at most %d character%s.\n", maximumCharacters, minimumCharacters > 1 ? "s" : "");
      } while (input.length() < minimumCharacters || input.length() > maximumCharacters);
      return input;
   }

   /**
    * Ask the user for a String(repeat until input is correct).
    *
    * @param question the question to ask(print to) the user.
    * @return the user input: string.
    */
   public String askUserString(String question) {
      return askUserString(question, 0);
   }


   /**
    * Ask the user for a integer(repeat until input is correct).
    *
    * @param question the question to ask(print to) the user.
    * @return the user input: integer.
    */
   public int askUserInteger(String question) {
      int input;
      while (true) {
         try {
            System.out.print(question);
            input = keyboard.nextInt();
            break;
         } catch (InputMismatchException ime) {
            System.err.println("Error: input is not a number");
         } finally {
            keyboard.nextLine();
         }
      }
      return input;
   }

   /**
    * Ask the user for a integer(repeat until input is correct).
    *
    * @param question the question to ask(print to) the user.
    * @param minimum  the minimum the integer is allowed to be.
    * @return the user input: integer.
    */
   public int askUserInteger(String question, int minimum) {
      int input;// = minimum - 1;
      do {
         input = askUserInteger(question);
         if (input < minimum) {
            System.err.println("Error: input must be equal or higher than " + minimum);
         }
      } while (input < minimum);
      return input;
   }

   /**
    * Ask the user for a integer(repeat until input is correct).
    *
    * @param question the question to ask(print to) the user.
    * @param minimum  the minimum the integer is allowed to be.
    * @param maximum  the maximum the integer is allowed to be.
    * @return the user input: integer.
    */
   public int askUserInteger(String question, int minimum, int maximum) {
      int input;// = 0;
      do {
         input = askUserInteger(question);
         if (input < minimum) {
            System.err.println("Error: input must be equal or higher than " + minimum);
         } else if (input > maximum) {
            System.err.println("Error: input must be equal or lower than " + maximum);
         }
      } while (input < minimum || input > maximum);
      return input;
   }

   public
}
