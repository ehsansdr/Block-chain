import java.util.Arrays;
import java.util.Random;

public class Transaction {
    long TransactionId;
    StringBuffer senderName = new StringBuffer();
    StringBuffer receiverName = new StringBuffer();
    int amount;
    String[] uppercaseLetter = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    String[] lowercaseLetter = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    char[] currency;
    Random rand = new Random();

    public Transaction(long transactionId) {
        TransactionId = transactionId;

        senderName.append(nameCreator());
        receiverName.append(nameCreator());
    }

    private StringBuffer nameCreator() {
        StringBuffer finalName = new StringBuffer();
        int  lengthOfWord = rand.nextInt(10) + 5;

        //becuase first letter is capital so index 0 in capital:
        finalName.append(uppercaseLetter[rand.nextInt(26)]);

        //and the 1 to end would be lower case:
        for (int i = 1; i < lengthOfWord;i++){
            finalName.append(lowercaseLetter[rand.nextInt(lowercaseLetter.length)]);
        }

        return finalName;
    }
    
    @Override
    public String toString() {
        return "Transaction{" +
                "\n\tTransactionId=" + TransactionId +
                "\n\tsenderName='" + senderName + '\'' +
                "\n\treceiverName='" + receiverName + '\'' +
                "\n\tamount=" + amount +
                "\n\tcurrency=" + Arrays.toString(currency) +
                '}';
    }


}
