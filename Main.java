import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("   VENDOR RECONCILIATION COPILOT");
        System.out.println("======================================");

        CsvReader csvReader = new CsvReader();

        ArrayList<Transaction> vendorTransactions =
                csvReader.readCsv("data/vendor.csv");

        ArrayList<Transaction> ledgerTransactions =
                csvReader.readCsv("data/ledger.csv");

        System.out.println("\nVendor Transactions Loaded: "
                + vendorTransactions.size());

        System.out.println("Ledger Transactions Loaded: "
                + ledgerTransactions.size());

        ReconciliationService reconciliationService =
                new ReconciliationService();

        reconciliationService.reconcile(
                vendorTransactions,
                ledgerTransactions
        );
    }
}