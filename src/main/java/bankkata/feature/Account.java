package bankkata.feature;

import static bankkata.feature.TransactionType.*;

public class Account {
    private AppendTransaction appendTransaction;
    private DateTransaction dateTransaction;

    public Account(AppendTransaction appendTransaction, DateTransaction dateTransaction) {
        this.dateTransaction = dateTransaction;
        this.appendTransaction = appendTransaction;
    }

    private void createTransaction(int amount, TransactionType transactionType) {
        Transaction transaction = Transaction.aTransaction()
                .withDate(dateTransaction.get())
                .withAmount(amount)
                .withTransactionType(transactionType)
                .build();

        appendTransaction.append(transaction);
    }

    public void deposit(int amount) {
        createTransaction(amount, DEPOSIT);
    }


    public void withdraw(int amount) {
        createTransaction(amount, WITHDRAWAL);
    }


    public void printStatement() {

    }
}
