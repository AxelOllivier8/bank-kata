package bankkata.feature;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BankAccountTest {

    @Test
    public void firstTest(){
        assertThat(false).isFalse();
    }

    //Example 1 : Deposit into account -> An account with zero balance is making a deposit of 100 ->
    // it becomes an account with a balance of 100
    // account.balance = 0 && account.deposit(100) -> account.balance = 100
    //Example 2 : Deposit into account -> Making a deposit of zero -> account is still with a balance of zero
    // account.deposit(0) -> do nothing

    @Test
    public void printAValidStatementWhenACustomerMakesADepositOf500AndAWithdrawOf100AndThenPrint(){
        TestDouble testDouble = new TestDouble();
        String expectedFirstLine = "DATE       | AMOUNT  | BALANCE";
        String expectedSecondLine = "10/04/2014 | 500.00  | 1400.00";
        String expectedThirdLine = "02/04/2014 | -100.00 | 900.00";
        Account account = new Account((AppendTransaction) null, null);
        account.deposit(500);
        account.withdraw(100);
        account.printStatement();
        List<String> printedList = testDouble.getStatement();
        assertThat(printedList).containsExactly(expectedFirstLine,expectedSecondLine, expectedThirdLine);
    }
}
