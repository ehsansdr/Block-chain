import java.util.ArrayList;

public class Chain implements Runnable {
     Block firstBlock = new Block(0);
     private int transactionPS = firstBlock.transactionNumberLimit;
     private int blockPS = 1;
     ArrayList<Block> blocks = new ArrayList<>();
     Thread ChainLoopThread;
     int i = 1;

     public Chain(){
         blocks.add(firstBlock);

         ChainLoopThread = new Thread(this);
         ChainLoopThread.start();
     }

     @Override
     public void run(){
         double timePerEachTransaction = 1000000000.0 / transactionPS;
         double timePerEachBlock = 1000000000.0 / blockPS;
         long previousTime = System.nanoTime();

         int frames = 0;
         int updates = 0;
         long lastCheck = System.currentTimeMillis();

         double deltaBlockTime = 0;
         double deltaTransactionTime = 0;

         while (true) {
             long currentTime = System.nanoTime();

             deltaBlockTime += (currentTime - previousTime) / timePerEachBlock;
             deltaTransactionTime += (currentTime - previousTime) / timePerEachTransaction;
             previousTime = currentTime;


             //for creating block
             if (deltaBlockTime >= 1) {
                 System.out.println();
                 blocks.add(new Block(blocks.get(blocks.size() - 1).hashCode()));
                 System.out.println(blocks.get(blocks.size() - (blocks.size() == 1 ? 1 : 2)));
                 i++;

                 updates++;
                 deltaBlockTime--;
             }

             //for creating transaction
             if (deltaTransactionTime >= 1) {
                 blocks.get(blocks.size() - 1).addTransaction(new Transaction( ));

                 updates++;
                 deltaTransactionTime--;
             }

//             if (System.currentTimeMillis() - lastCheck >= 1000) {//every 1 sec
//                 lastCheck = System.currentTimeMillis();
//                 System.out.println("FPS: " + frames +" | blockPS: " + updates );
//                 frames = 0;
//                 updates = 0;
//             }
         }
     }
}
