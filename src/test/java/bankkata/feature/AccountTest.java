package bankkata.feature;

import org.junit.jupiter.api.Test;

import static bankkata.feature.TransactionType.*;
import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {

    private Transaction actualTransaction;


    @Test
    public void addTransactionWhenDeposit(){
        AppendTransaction appendTransaction = (transaction) -> this.actualTransaction = transaction;
        String expectedDate = "24/03/2020";
        int expectedAmount = 100;
        Account account = new Account(appendTransaction);
        Transaction expectedTransaction = Transaction.aTransaction()
                .withAmount(expectedAmount)
                .withDate(expectedDate)
                .withTransactionType(DEPOSIT)
                .build();

        account.deposit(100);
        assertThat(this.actualTransaction).isEqualTo(expectedTransaction);
    }

    @Test
    public void addTransactionWhenWithdraw(){
        AppendTransaction appendTransaction = (transaction) -> this.actualTransaction = transaction;
        String expectedDate = "25/03/2020";
        int expectedAmount = 50;
        Account account = new Account(appendTransaction);
        Transaction expectedTransaction = Transaction.aTransaction()
                .withAmount(expectedAmount)
                .withDate(expectedDate)
                .withTransactionType(WITHDRAWAL)
                .build();

        account.withdraw(50);
        assertThat(this.actualTransaction).isEqualTo(expectedTransaction);
    }


}
