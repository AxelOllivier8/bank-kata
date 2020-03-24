package bankkata.feature;

import static bankkata.feature.TransactionType.*;

public class Account {
    private AppendTransaction appendTransaction;
    private DateTransaction dateTransaction;
    private PrinterTransaction printerTransaction;
    private FetchTransaction fetchTransaction;

    public Account(AppendTransaction appendTransaction, DateTransaction dateTransaction, PrinterTransaction printerTransaction, FetchTransaction fetchTransaction) {

        this.appendTransaction = appendTransaction;
        this.dateTransaction = dateTransaction;
        this.printerTransaction = printerTransaction;
        this.fetchTransaction = fetchTransaction;
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
        printerTransaction.print(this.fetchTransaction.fetch());
    }
}
