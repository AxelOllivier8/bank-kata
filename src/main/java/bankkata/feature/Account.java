package bankkata.feature;

import static bankkata.feature.TransactionType.*;

public class Account {
    private AppendTransaction appendTransaction;

    public Account(AppendTransaction appendTransaction) {

        this.appendTransaction = appendTransaction;
    }

    public void deposit(int amount) {
        if(appendTransaction != null){
            Transaction transaction = Transaction.aTransaction()
                    .withDate("24/03/2020")
                    .withAmount(amount)
                    .withTransactionType(DEPOSIT)
                    .build();

            appendTransaction.append(transaction);
        }
    }

    public void withdraw(int amount) {

    }


    public void printStatement() {

    }
}
