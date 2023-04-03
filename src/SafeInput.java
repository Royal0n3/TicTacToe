package utilities;

import java.util.Scanner;

public class SafeInput {
    /**
     * Prompts the user to enter a non-zero length string.
     *
     * @param pipe   a Scanner opened to read from System.in
     * @param prompt the message to display as the prompt for the input
     * @return a String response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = "";  // Set this to zero length. Loop runs until it isn't
        do {
            System.out.print("\n" + prompt + ": "); // show prompt add space
            retString = pipe.nextLine();
        } while (retString.length() == 0);
        return retString;
    }

    /**
     * Prompts the user to enter an integer.
     *
     * @param pipe   a Scanner opened to read from System.in
     * @param prompt the message to display as the prompt for the input
     * @return an integer value entered by the user
     */
    public static int getInt(Scanner pipe, String prompt) {
        int result = 0;
        boolean validInput = false;
        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextInt()) {
                result = pipe.nextInt();
                validInput = true;
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                pipe.nextLine(); // clear input
            }
        } while (!validInput);
        pipe.nextLine(); // clear input
        return result;
    }

    /**
     * Prompts the user to enter a double value.
     *
     * @param pipe   a Scanner opened to read from System.in
     * @param prompt the message to display as the prompt for the input
     * @return a double value entered by the user
     */
    public static double getDouble(Scanner pipe, String prompt) {
        double result = 0;
        boolean validInput = false;
        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextDouble()) {
                result = pipe.nextDouble();
                validInput = true;
            } else {
                System.out.println("Invalid input. Please enter a double value.");
                pipe.nextLine(); // clear input
            }
        } while (!validInput);
        pipe.nextLine(); // clear input
        return result;
    }

    /**
     * Prompts the user to enter an integer within a specified range.
     *
     * @param pipe   a Scanner opened to read from System.in
     * @param prompt the message to display as the prompt for the input (without the range)
     * @param low    the low value for the input range
     * @param high   the high value for the input range
     * @return an integer value entered by the user within the specified range
     */




        private static Scanner scanner = new Scanner(System.in);

        public static int getRangedInt(Scanner console, String prompt, int min, int max) {
            int input;
            do {
                System.out.print(prompt);
                while (!scanner.hasNextInt()) {
                    scanner.nextLine();
                    System.out.print("Invalid input. " + prompt);
                }
                input = scanner.nextInt();
                scanner.nextLine();
            } while (input < min || input > max);
            return input;


            }
    }

