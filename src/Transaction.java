import java.util.Arrays;
import java.util.Random;

public class Transaction {
    static long TransactionPassed = 1;
    long transactionId;
    StringBuffer senderName = new StringBuffer();
    StringBuffer receiverName = new StringBuffer();
    int amount;
    String[] uppercaseLetter = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    String[] lowercaseLetter = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    Random rand = new Random();

    public Transaction() {
        this.transactionId = TransactionPassed;
        amount = rand.nextInt(900_000_00);

        senderName.append(nameCreator());
        receiverName.append(nameCreator());

        TransactionPassed++;
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
        return "\n\tTransactionId : " + transactionId +
                "\t|\tsenderName : \"" + senderName + "\"" +
                "\t|\tamount = " + amount +
                " $ " +
                "\t|\treceiverName : \"" + receiverName + "\"";
    }


}
