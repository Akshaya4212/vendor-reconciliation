import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class CsvReader {

    public ArrayList<Transaction> readCsv(String fileName) {

        ArrayList<Transaction> transactions = new ArrayList<>();

        try {

            BufferedReader reader = new BufferedReader(
                    new FileReader(fileName)
            );

            String line;

            // Skip the first line because it contains headings
            reader.readLine();

            while ((line = reader.readLine()) != null) {

                String[] values = line.split(",");

                String date = values[0];
                String reference = values[1];
                double amount = Double.parseDouble(values[2]);

                Transaction transaction =
                        new Transaction(date, reference, amount);

                transactions.add(transaction);
            }

            reader.close();

        } catch (Exception e) {
            System.out.println("Error reading file: " + fileName);
            System.out.println(e.getMessage());
        }

        return transactions;
    }
}