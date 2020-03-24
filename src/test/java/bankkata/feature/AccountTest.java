package bankkata.feature;

import org.junit.jupiter.api.Test;

import static bankkata.feature.TransactionType.*;
import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {

    private int actualAmount;
    private String actualDate;
    private TransactionType transactionType;
    private Transaction actualTransaction;

    @Test
    public void addTransactionToListWhenDeposit(){
        AppendTransaction appendTransaction = (amount) -> this.actualAmount = amount;
        Account account = new Account(appendTransaction);
        int expectedAmount = 100;
        account.deposit(100);
        assertThat(this.actualAmount).isEqualTo(expectedAmount);
    }

    @Test
    public void aa(){
        AppendTransactionObject appendTransaction = (transaction) -> this.actualTransaction = transaction;
        String expectedDate = "24/03/2020";
        TransactionType expectedTransactionType = DEPOSIT;
        int expectedAmount = 100;
        Account account = new Account(appendTransaction);
        Transaction expectedTransaction = new Transaction(expectedDate,expectedAmount,expectedTransactionType);

        account.deposit(100);
        assertThat(this.actualTransaction).isEqualTo(expectedTransaction);
    }
}
