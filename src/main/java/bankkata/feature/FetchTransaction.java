package bankkata.feature;

import java.util.List;

@FunctionalInterface
public interface FetchTransaction {

    List<Transaction> fetch();
}
