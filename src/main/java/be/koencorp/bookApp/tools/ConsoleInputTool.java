package be.koencorp.bookApp.tools;

import java.util.Scanner;

/**
 * Class for handling the inputs
 * @author Ward edited By Team-A
 */
public final class ConsoleInputTool {
    Scanner scanner = new Scanner(System.in);

    /**
     * Constructor without parameters
     */
    public ConsoleInputTool() {
    }

    /**
     * Asking for the enter if the user wants to continue
     */
    public void askPressEnterToContinue() {
        System.out.print("Press enter to continue.");
        scanner.nextLine();
    }

    /**
     * Method for asking yes or no question with a string
     * @param message is a string that you are asking to user for yes no question
     * @return is the answer of the user in type of boolean true or false
     */
    public boolean askYesOrNo(String message) {
        if (message == null || message.length() < 1) return false;
        System.out.println(message);
        String answer;
        do {
            answer = scanner.nextLine().toLowerCase();
            if (answer.length() > 1) System.err.println("Answer cannot be longer than 1 char");
            if (!answer.equals("y") && !answer.equals("n")) System.err.println("Type in y or n");
        } while (!answer.equals("y") && !answer.equals("n"));

        return answer.equals("y");
    }

    /**
     * Method for asking user to enter between 2 boundary
     * @param message is your question in type of string
     * @param low is your lowest boundary for user's answer can give
     * @param high is your highest boundary for user's answer can give
     * @return the answer of the user if all in order in type of int
     */
    public int askUserPosIntBetweenRange(String message, int low, int high) {
        if (low < 0) throw new IllegalArgumentException("low cannot be negative");
        if (low > high) throw new IllegalArgumentException("The lower end cannot be greater than the higher end");
        if (message == null) throw new IllegalArgumentException("The message cannot be null");

        String input;
        do {
            System.out.println(message);
            input = scanner.nextLine();
            if (!input.matches("[" + low + "-" + high + "]"))
                System.err.println("Input must be a number between " + low + " and " + high);
        } while (!input.matches("[" + low + "-" + high + "]"));

        return Integer.parseInt(input);
    }

    /**
     * Method for asking to user that a specific amount of digits entered between the given range
     * @param message your question to user
     * @param length user's answer's length need to be
     * @param lowDigit lowest bundary
     * @param highDigit highest boundary
     * @return is the answer if all in order in type of String
     */
    public String askSpecificAmountOfPosDigitsStringBetweenRange(String message, int length, int lowDigit, int highDigit) {
        if (length < 1 || highDigit < lowDigit || lowDigit < 0 || lowDigit > 9 || highDigit > 9) {
            return null;
        }

        String regex = "[" + lowDigit + "-" + highDigit + "]{" + length + "}";

        String input;

        do {
            System.out.println(message);
            input = scanner.nextLine();
            if (!input.matches(regex)) {
                System.err.println("Type in exactly " + length + " digits between " + lowDigit + " and " + highDigit);
            }
        } while (!input.matches(regex));

        return input;
    }

    /**
     * Checking the input if there is duplicate numbers inputted
     * @param input is the sting type of input by the user
     * @return true false according to comparing all numbers in input
     */
    public boolean checkNoDoublesInString(String input) {
        if (input == null || input.length() < 1) return false;

        for (int i = 0; i < input.length(); i++) {
            for (int j = 0; j < input.length(); j++) {
                if (i == j) continue;

                if (input.charAt(i) == input.charAt(j)) {
                    System.err.println("The input contains doubles");
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Asking user for enter a name
     * @param message is question for username
     * @return in string type the user's answer as username
     */
    public String askUserName(String message) {

        String regex = "^[a-zA-Z]+$";

        String input;

        do {
            System.out.println(message);
            input = scanner.nextLine();
            if (!input.matches(regex)) {
                System.err.println("Insert a valid name! ");
            }
        } while (!input.matches(regex));

        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }
}
