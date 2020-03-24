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
        DateTransaction dateTransaction = () -> expectedDate;
        int expectedAmount = 100;
        Account account = new Account(appendTransaction, dateTransaction);
        Transaction expectedTransaction = Transaction.aTransaction()
                .withAmount(expectedAmount)
                .withDate(expectedDate)
                .withTransactionType(DEPOSIT)
                .build();

        account.deposit(100);
        assertThat(this.actualTransaction).isEqualTo(expectedTransaction);
    }

    @Test
    void addAnotherTestDeposit() {
        AppendTransaction appendTransaction = (transaction) -> this.actualTransaction = transaction;
        String expectedDate = "23/03/2020";
        DateTransaction dateTransaction = () -> expectedDate;
        int expectedAmount = 50;
        Account account = new Account(appendTransaction, dateTransaction);
        Transaction expectedTransaction = Transaction.aTransaction()
                .withAmount(expectedAmount)
                .withDate(expectedDate)
                .withTransactionType(DEPOSIT)
                .build();

        account.deposit(50);
        assertThat(this.actualTransaction).isEqualTo(expectedTransaction);
    }

    @Test
    public void addTransactionWhenWithdraw(){
        AppendTransaction appendTransaction = (transaction) -> this.actualTransaction = transaction;
        String expectedDate = "25/03/2020";
        DateTransaction dateTransaction = () -> expectedDate;
        int expectedAmount = 50;
        Account account = new Account(appendTransaction, dateTransaction);
        Transaction expectedTransaction = Transaction.aTransaction()
                .withAmount(expectedAmount)
                .withDate(expectedDate)
                .withTransactionType(WITHDRAWAL)
                .build();

        account.withdraw(50);
        assertThat(this.actualTransaction).isEqualTo(expectedTransaction);
    }

    @Test
    void aNewTestWithdraw() {
        AppendTransaction appendTransaction = (transaction) -> this.actualTransaction = transaction;
        String expectedDate = "28/03/2020";
        DateTransaction dateTransaction = () -> expectedDate;
        int expectedAmount = 50;
        Account account = new Account(appendTransaction, dateTransaction);
        Transaction expectedTransaction = Transaction.aTransaction()
                .withAmount(expectedAmount)
                .withDate(expectedDate)
                .withTransactionType(WITHDRAWAL)
                .build();

        account.withdraw(50);
        assertThat(this.actualTransaction).isEqualTo(expectedTransaction);
    }
}
