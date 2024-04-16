/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


/**
 *
 * @author moloto
 */
import java.util.Scanner;

public class UserInput {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String username;
            @SuppressWarnings("UnusedAssignment")
            boolean isValidUsername = false;
            do {
                System.out.print("Enter username (must be no more than 5 characters and contain an underscore): ");
                username = scanner.nextLine();

                isValidUsername = checkUserName(username);

                if (!isValidUsername) {
                    System.out.println("Username is invalid. Please try again.");
                }
            } while (!isValidUsername);

            // Check username for capital letter
            boolean hasCapitalLetter = false;
            for (int i = 0; i < username.length(); i++) {
                if (Character.isUpperCase(username.charAt(i))) {
                    hasCapitalLetter = true;
                    break;
                }
            }
            if (!hasCapitalLetter) {
                System.out.println("Username must contain at least one capital letter.");
                // ask for user input again
            }

            // Check username for a number
            boolean hasNumber = false;
            for (int i = 0; i < username.length(); i++) {
                if (Character.isDigit(username.charAt(i))) {
                    hasNumber = true;
                    break;
                }
            }
            if (!hasNumber) {
                System.out.println("Username must contain at least one number.");
                // ask for user input again
            }

            // Check username for a special character
            String specialCharacters = "!@#$%^&*()-_=+\\|[{]};:'\",<.>/?";
            boolean hasSpecialCharacter = false;
            for (int i = 0; i < username.length(); i++) {
                if (specialCharacters.contains(String.valueOf(username.charAt(i)))) {
                    hasSpecialCharacter = true;
                    break;
                }
            }
            if (!hasSpecialCharacter) {
                System.out.println("Username must contain at least one special character.");
                // ask for user input again
            }

            String password;
            @SuppressWarnings("UnusedAssignment")
            boolean isValidPassword = false;
            do {
                System.out.print("Enter password (must be no more than 8 characters, contain a special character, a number, and a capital letter): ");
                password = scanner.nextLine();

                isValidPassword = checkPassword(password);

                if (!isValidPassword) {
                    System.out.println("Password is invalid. Please try again.");
                }
            } while (!isValidPassword);

            // Check password length
            if (password.length() < 8) {
                System.out.println("Password must be at least 8 characters long.");
                 // ask for user input again
            }

            System.out.print("Enter first name: ");
            String firstName = scanner.nextLine();

            System.out.print("Enter last name: ");
            String lastName = scanner.nextLine();

            if (isValid(username, password)) {
                System.out.println("\nUsername: " + username);
                System.out.println("Password: " + password);
                System.out.println("First name: " + firstName);
                System.out.println("Last name: " + lastName);
            } else {
                System.out.println("Invalid username or password.");
            }
        }
    }

    public static boolean checkUserName(String userName) {
        return userName.length() <= 5 && userName.contains("_");
    }

    public static boolean checkPassword(String password) {
        return password.length() >= 8 &&
               password.matches(".*[A-Z].*") &&
               password.matches(".*\\d.*") &&
               password.matches(".*[!@#$%^&*()-_=+\\\\|\\[{\\]};:'\",<.>/?].*");
    }

    public static boolean isValid(String username, String password) {
        return username.length() <= 5 && username.contains("_") &&
                hasUpperCase(username) &&
                hasNumber(username) &&
                hasSpecialCharacter(username) &&
                password.length() >= 8;
    }

    public static boolean hasUpperCase(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (Character.isUpperCase(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasNumber(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasSpecialCharacter(String str) {
        String specialCharacters = "!@#$%^&*()-_=+\\|[{]};:'\",<.>/?";
        for (int i = 0; i < str.length(); i++) {
            if (specialCharacters.contains(String.valueOf(str.charAt(i)))) {
                return true;
            }
        }
        return false;
    }
}



                                                                   