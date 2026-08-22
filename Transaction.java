public class Transaction {

    private String date;
    private String reference;
    private double amount;

    public Transaction(String date, String reference, double amount) {
        this.date = date;
        this.reference = reference;
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public String getReference() {
        return reference;
    }

    public double getAmount() {
        return amount;
    }

    public String toString() {
        return "Date: " + date
                + ", Reference: " + reference
                + ", Amount: " + amount;
    }
}