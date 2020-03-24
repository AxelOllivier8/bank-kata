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
        Transaction expectedTransaction = new Transaction(expectedDate,expectedAmount, DEPOSIT);

        account.deposit(100);
        assertThat(this.actualTransaction).isEqualTo(expectedTransaction);
    }
}
