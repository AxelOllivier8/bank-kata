package bankkata.feature;

import static bankkata.feature.TransactionType.*;

public class Account {
    private AppendTransaction appendTransaction;

    public Account(AppendTransaction appendTransaction) {

        this.appendTransaction = appendTransaction;
    }

    private void createTransaction(int amount, String transactionDate, TransactionType transactionType) {
        Transaction transaction = Transaction.aTransaction()
                .withDate(transactionDate)
                .withAmount(amount)
                .withTransactionType(transactionType)
                .build();

        appendTransaction.append(transaction);
    }

    public void deposit(int amount) {
        createTransaction(amount, "24/03/2020", DEPOSIT);
    }


    public void withdraw(int amount) {
        createTransaction(amount, "25/03/2020", WITHDRAWAL);
    }


    public void printStatement() {

    }
}
