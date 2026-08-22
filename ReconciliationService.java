import java.util.ArrayList;

public class ReconciliationService {

    public void reconcile(
            ArrayList<Transaction> vendorTransactions,
            ArrayList<Transaction> ledgerTransactions) {

        int matchedCount = 0;
        int amountMismatchCount = 0;
        int missingInLedgerCount = 0;
        int missingInVendorCount = 0;

        System.out.println("\n===== RECONCILIATION RESULTS =====\n");

        // Check every vendor transaction
        for (Transaction vendor : vendorTransactions) {

            boolean found = false;

            for (Transaction ledger : ledgerTransactions) {

                if (vendor.getReference()
                        .equalsIgnoreCase(ledger.getReference())) {

                    found = true;

                    if (vendor.getAmount() == ledger.getAmount()) {

                        System.out.println(
                                "MATCHED: "
                                        + vendor.getReference()
                        );

                        System.out.println(
                                "Vendor Amount: "
                                        + vendor.getAmount()
                        );

                        System.out.println(
                                "Ledger Amount: "
                                        + ledger.getAmount()
                        );

                        System.out.println(
                                "Reason: Reference and amount are the same."
                        );

                        System.out.println();

                        matchedCount++;

                    } else {

                        double difference =
                                vendor.getAmount()
                                        - ledger.getAmount();

                        System.out.println(
                                "AMOUNT MISMATCH: "
                                        + vendor.getReference()
                        );

                        System.out.println(
                                "Vendor Amount: "
                                        + vendor.getAmount()
                        );

                        System.out.println(
                                "Ledger Amount: "
                                        + ledger.getAmount()
                        );

                        System.out.println(
                                "Difference: "
                                        + difference
                        );

                        System.out.println(
                                "Reason: The transaction reference matches, "
                                        + "but the amounts are different."
                        );

                        System.out.println();

                        amountMismatchCount++;
                    }

                    break;
                }
            }

            if (!found) {

                System.out.println(
                        "MISSING IN LEDGER: "
                                + vendor.getReference()
                );

                System.out.println(
                        "Vendor Amount: "
                                + vendor.getAmount()
                );

                System.out.println(
                        "Reason: This transaction exists in the vendor "
                                + "statement but was not found in the "
                                + "internal ledger."
                );

                System.out.println();

                missingInLedgerCount++;
            }
        }

        // Check for transactions that exist in ledger
        // but not in vendor statement
        for (Transaction ledger : ledgerTransactions) {

            boolean found = false;

            for (Transaction vendor : vendorTransactions) {

                if (ledger.getReference()
                        .equalsIgnoreCase(vendor.getReference())) {

                    found = true;
                    break;
                }
            }

            if (!found) {

                System.out.println(
                        "MISSING IN VENDOR STATEMENT: "
                                + ledger.getReference()
                );

                System.out.println(
                        "Ledger Amount: "
                                + ledger.getAmount()
                );

                System.out.println(
                        "Reason: This transaction exists in the internal "
                                + "ledger but was not found in the vendor "
                                + "statement."
                );

                System.out.println();

                missingInVendorCount++;
            }
        }

        System.out.println("\n===== SUMMARY =====");

        System.out.println(
                "Matched Transactions: " + matchedCount
        );

        System.out.println(
                "Amount Mismatches: " + amountMismatchCount
        );

        System.out.println(
                "Missing in Ledger: " + missingInLedgerCount
        );

        System.out.println(
                "Missing in Vendor Statement: "
                        + missingInVendorCount
        );

        int totalDiscrepancies =
                amountMismatchCount
                        + missingInLedgerCount
                        + missingInVendorCount;

        System.out.println(
                "Total Discrepancies: "
                        + totalDiscrepancies
        );

        System.out.println("\n===== NATURAL LANGUAGE SUMMARY =====");

        if (totalDiscrepancies == 0) {

            System.out.println(
                    "All transactions were successfully reconciled. "
                            + "No discrepancies were found."
            );

        } else {

            System.out.println(
                    "The reconciliation process found "
                            + totalDiscrepancies
                            + " discrepancy/discrepancies."
            );

            System.out.println(
                    "There were "
                            + matchedCount
                            + " matched transaction(s), "
                            + amountMismatchCount
                            + " amount mismatch(es), "
                            + missingInLedgerCount
                            + " transaction(s) missing from the ledger, and "
                            + missingInVendorCount
                            + " transaction(s) missing from the vendor statement."
            );
        }
    }
}