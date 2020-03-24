package bankkata.feature;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static bankkata.feature.TransactionType.*;
import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {

    private Transaction actualTransaction;


    @ParameterizedTest
    @ValueSource(strings = {"24/03/2020", "23/03/2020"})
    public void addTransactionWhenDeposit(String expectedDate){
        AppendTransaction appendTransaction = (transaction) -> this.actualTransaction = transaction;
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

    @ParameterizedTest
    @ValueSource(strings = {"25/03/2020", "28/03/2020"})
    public void addTransactionWhenWithdraw(String expectedDate){
        AppendTransaction appendTransaction = (transaction) -> this.actualTransaction = transaction;
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
