import java.util.ArrayList;
import java.util.Arrays;

public class Block {
    static int blockId = 0;/** PAY ATTENTION this variable increase in its class by creating new one
     because it is STATIC*/
    int currentHash;
    int transactionNumberLimit = 10;
    int numberOfCurrentTransaction = 0;
    ArrayList<Transaction> transactions = new ArrayList<>();
    int previousHash;

    public Block(int previousHash) {
        this.previousHash = previousHash;
        this.currentHash = this.hashCode();
        blockId++;
    }

    public void addTransaction(Transaction transaction) {
        if (numberOfCurrentTransaction <= transactionNumberLimit){
            this.transactions.add(transaction);
            numberOfCurrentTransaction++;
        }
    }

    @Override
    public String toString() {
        return "Block{" +
                "ID : " + blockId +
                "  , currentHash=" + currentHash +
                ", transactions=" + transactions.size() +
                ", previousHash=" + previousHash +
                '}';
    }
}
