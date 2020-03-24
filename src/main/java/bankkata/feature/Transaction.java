package bankkata.feature;

import java.util.Objects;

public class Transaction {
    private String date;
    private int amount;
    private TransactionType transactionType;

    public Transaction(String date, int amount, TransactionType transactionType) {
        this.date = date;
        this.amount = amount;
        this.transactionType = transactionType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return amount == that.amount &&
                Objects.equals(date, that.date) &&
                transactionType == that.transactionType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, amount, transactionType);
    }
}