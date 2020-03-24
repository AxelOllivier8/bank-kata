package bankkata.feature;

import static bankkata.feature.TransactionType.*;

public class Account {
    private AppendTransaction appendTransaction;
    private AppendTransactionObject appendTransactionObject;

    public Account(AppendTransaction appendTransaction) {

        this.appendTransaction = appendTransaction;
    }

    public Account(AppendTransactionObject appendTransaction) {

        appendTransactionObject = appendTransaction;
    }

    public void deposit(int amount) {
        if(appendTransaction != null) {
            appendTransaction.append(amount);
        }
        if(appendTransactionObject != null){
            Transaction transaction = new Transaction("24/03/2020", amount, DEPOSIT);
            appendTransactionObject.append(transaction);
        }
    }

    public void withdraw(int amount) {

    }


    public void printStatement() {

    }
}
