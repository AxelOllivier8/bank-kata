package bankkata.feature;

@FunctionalInterface
public interface AppendTransaction {

    void append(Transaction transaction);

}
