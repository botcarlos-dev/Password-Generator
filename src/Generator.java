import java.util.Scanner;
import java.util.Objects;


public class Generator {
    Alphabet alphabet;
    public static Scanner keyboard;

    public Generator(Scanner scanner) {
        keyboard = scanner;
    }

    public Generator(boolean IncludeUpper, boolean IncludeLower, boolean IncludeNumbers, boolean IncludeSymbols) {
        alphabet = new Alphabet(IncludeUpper, IncludeLower, IncludeNumbers, IncludeSymbols);
    }

    public void mainLoop() {
        System.out.println("Welcome to the Password Generator!");
        printMenu();

        String userOption = "-1";

        while (!userOption.equals("4")) {
            userOption = keyboard.next();

            switch (userOption) {
                case "1" -> {
                    requestPassword();
                    printMenu();
                }
                case "2" -> {
                    checkPassword();
                    printMenu();
                }
                case "3" -> {
                    printUsefulInfo();
                    printMenu();
                }
                case "4" -> printQuitMessage();
                default -> {
                    System.out.println();
                    System.out.println("Invalid option. Please try again.");
                    printMenu();

                }

            }
        }
    }

    private Password GeneratePassword(int length) {
        final StringBuilder pass = new StringBuilder("");

        final int alphabetLength = alphabet.getAlphabet().length();

        int max = alphabetLength - 1;
        int min = 0;
        int range = max - min + 1;

        for (int i = 0; i < length; i ++) {
            int index = (int) (Math.random() * range) + min;
            pass.append(alphabet.getAlphabet().charAt(index));
        }

        return new Password(pass.toString());
    }

    private void printUsefulInfo() {
        System.out.println();
        System.out.println("Use a minimum password length of 8 or more characters if permitted");
        System.out.println("Include lowercase and uppercase alphabetic characters, numbers and symbols if permitted");
        System.out.println("Generate passwords randomly where feasible");
        System.out.println("Avoid using the same password twice (e.g., across multiple user accounts and/or software systems)");
        System.out.println("Avoid character repetition, keyboard patterns, dictionary words, letter or number sequences," +
                "\nusernames, relative or pet names, romantic links (current or past) " +
                "and biographical information (e.g., ID numbers, ancestors' names or dates).");
        System.out.println("Avoid using information that the user's colleagues and/or " +
                "acquaintances might know to be associated with the user");
        System.out.println("Do not use passwords which consist wholly of any simple combination of the aforementioned weak components");
    }

    private void requestPassword() {
        boolean IncludeUpper = false;
        boolean IncludeLower = false;
        boolean IncludeNumbers = false;
        boolean IncludeSymbols = false;

        boolean correctParams;

        System.out.println();
        System.out.println("Hello, welcome to the Password Generator :) answer"
                + " the following questions by Yes or No \n");

        do {
            String input;
            correctParams = false;

                do {
                    System.out.println("Do you want to include Uppercase letters? \"ABCD...\"");
                    input = keyboard.next();
                    PasswordRequestError(input);
                } while (!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"));

                if (isInclude(input)) IncludeUpper = true;

                do {
                    System.out.println("Do you want to include Lowercase letters? \"abcd...\"");
                    input = keyboard.next();
                    PasswordRequestError(input);
                } while (!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"));

                if (isInclude(input)) IncludeLower = true;

                do {
                    System.out.println("Do you want to include Numbers? \"1234...\"");
                    input = keyboard.next();
                    PasswordRequestError(input);
                } while (!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"));

                if (isInclude(input)) IncludeNumbers = true;

                do {
                    System.out.println("Do you want to include Symbols? \"!@#$...\"");
                    input = keyboard.next();
                    PasswordRequestError(input);
                } while (!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"));

                if (isInclude(input)) IncludeSymbols = true;

                if (!IncludeUpper && !IncludeLower && !IncludeNumbers && !IncludeSymbols) {
                    System.out.println("You have selected no characters to generate your " +
                            "password, at least one of your answers should be Yes\n");
                    correctParams = true;
                }

            }while (correctParams);

            System.out.println("How many characters do you want your password to have?");
            int length = keyboard.nextInt();

            final Generator generator = new Generator(IncludeUpper, IncludeLower, IncludeNumbers, IncludeSymbols);
            final Password password = generator.GeneratePassword(length);

            System.err.println("Your password -> " + password);
        }

        private boolean isInclude(String input) {
            return input.equalsIgnoreCase("yes");
        }

        private void PasswordRequestError(String i) {
            if (!i.equalsIgnoreCase("yes") && !i.equalsIgnoreCase("no")) {
                System.out.println("Invalid option. Please try again.");
            }
        }

        private void checkPassword() {
            String input;

            System.out.print("\nEnter your password: ");
            input = keyboard.next();

            final Password password = new Password(input);

            System.out.println(password.calculateScore());
        }

        private void printMenu() {
            System.out.println();
            System.out.println("Select an option:");
            System.out.println("Enter 1 -> Password Generator");
            System.out.println("Enter 2 -> Password Strength Checker");
            System.out.println("Enter 3 -> Useful Information");
            System.out.println("Enter 4 -> Quit");
            System.out.println("Choice:");
        }

        private void printQuitMessage() {
            System.out.println();
            System.out.println("Thank you for using the Password Generator!");
        }
}
