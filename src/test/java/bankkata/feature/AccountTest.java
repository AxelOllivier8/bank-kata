package bankkata.feature;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static bankkata.feature.TransactionType.*;
import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {

    private Transaction actualTransaction;
    private List<Transaction> transactionsToPrint;


    @ParameterizedTest
    @ValueSource(strings = {"24/03/2020", "23/03/2020"})
    public void addTransactionWhenDeposit(String expectedDate){
        AppendTransaction appendTransaction = (transaction) -> this.actualTransaction = transaction;
        DateTransaction dateTransaction = () -> expectedDate;
        int expectedAmount = 100;
        Transaction expectedTransaction = Transaction.aTransaction()
                .withAmount(expectedAmount)
                .withDate(expectedDate)
                .withTransactionType(DEPOSIT)
                .build();
        FetchTransaction fetchTransaction = () -> null;
        PrinterTransaction printerTransaction = (transactions) -> {};
        Account account = new Account(appendTransaction, dateTransaction, printerTransaction, fetchTransaction);
        account.deposit(100);
        assertThat(this.actualTransaction).isEqualTo(expectedTransaction);
    }

    @ParameterizedTest
    @ValueSource(strings = {"25/03/2020", "28/03/2020"})
    public void addTransactionWhenWithdraw(String expectedDate){
        AppendTransaction appendTransaction = (transaction) -> this.actualTransaction = transaction;
        DateTransaction dateTransaction = () -> expectedDate;
        int expectedAmount = 50;
        Transaction expectedTransaction = Transaction.aTransaction()
                .withAmount(expectedAmount)
                .withDate(expectedDate)
                .withTransactionType(WITHDRAWAL)
                .build();
        FetchTransaction fetchTransaction = () -> null;
        PrinterTransaction printerTransaction = (transactions) -> {};
        Account account = new Account(appendTransaction, dateTransaction, printerTransaction, fetchTransaction);

        account.withdraw(50);
        assertThat(this.actualTransaction).isEqualTo(expectedTransaction);
    }

    @Test
    public void printTransactionsWhenPrintStatement(){
        List<Transaction> expectedTransactionsToPrint = Collections.singletonList(
                Transaction.aTransaction()
                        .build()
        );
        AppendTransaction appendTransaction = (transaction) -> this.actualTransaction = transaction;
        String expectedDate = "";
        DateTransaction dateTransaction = () -> expectedDate;
        PrinterTransaction printerTransaction = (transactions) ->  this.transactionsToPrint = transactions;
        FetchTransaction fetchTransaction = () -> expectedTransactionsToPrint;
        Account account = new Account(appendTransaction, dateTransaction, printerTransaction, fetchTransaction);
        account.printStatement();
        assertThat(this.transactionsToPrint).isEqualTo(expectedTransactionsToPrint);
    }
}
