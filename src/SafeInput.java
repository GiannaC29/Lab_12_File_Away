import java.util.Scanner;

public class SafeInput {

    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString;

        do {
            System.out.print(prompt + " ");
            retString = pipe.nextLine().trim();

            if (retString.isEmpty()) {
                System.out.println("Input cannot be blank. Try again.");
            }

        } while (retString.isEmpty());

        return retString;
    }

    public static int getInt(Scanner pipe, String prompt) {
        int number = 0;
        boolean valid = false;

        do {
            System.out.print(prompt + " ");

            if (pipe.hasNextInt()) {
                number = pipe.nextInt();
                pipe.nextLine();
                valid = true;
            } else {
                System.out.println("Invalid input. Enter a whole number.");
                pipe.nextLine();
            }

        } while (!valid);

        return number;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String answer;

        do {
            System.out.print(prompt + " (Y/N): ");
            answer = pipe.nextLine().trim();

        } while (!answer.equalsIgnoreCase("Y")
                && !answer.equalsIgnoreCase("N"));

        return answer.equalsIgnoreCase("Y");
    }
}
