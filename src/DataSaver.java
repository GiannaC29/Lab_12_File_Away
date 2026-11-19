import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataSaver {

    public static void main(String[] args) {

        Scanner pipe = new Scanner(System.in);

        ArrayList<String> records = new ArrayList<>();

        int idNumber = 1;
        boolean anotherRecord = true;

        while (anotherRecord) {

            System.out.println("\nENTER STUDENT INFORMATION");

            String firstName = SafeInput.getNonZeroLenString(pipe, "Enter First Name:");
            String lastName = SafeInput.getNonZeroLenString(pipe, "Enter Last Name:");
            String email = SafeInput.getNonZeroLenString(pipe, "Enter Email:");

            int birthYear = SafeInput.getInt(pipe, "Enter Year of Birth:");

            String id = String.format("%06d", idNumber);

            String record = firstName + ", " +
                    lastName + ", " +
                    id + ", " +
                    email + ", " +
                    birthYear;

            records.add(record);

            idNumber++;

            anotherRecord = SafeInput.getYNConfirm(pipe, "Would you like to enter another record?");
        }

        String fileName = SafeInput.getNonZeroLenString(pipe,
                "Enter the CSV file name (without .csv)");

        if (!fileName.toLowerCase().endsWith(".csv")) {
            fileName += ".csv";
        }

        File outputFile = new File("src", fileName);

        try {
            PrintWriter writer = new PrintWriter(outputFile);

            for (String record : records) {
                writer.println(record);
            }

            writer.close();

            System.out.println("\nFile successfully saved!");
            System.out.println("File Name: " + outputFile.getName());
            System.out.println("Records Saved: " + records.size());

        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }

        pipe.close();
    }
}
