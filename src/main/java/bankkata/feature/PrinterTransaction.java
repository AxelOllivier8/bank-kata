package bankkata.feature;

import java.util.List;

@FunctionalInterface
public interface PrinterTransaction {

    void print(List<Transaction> transactions);
}
