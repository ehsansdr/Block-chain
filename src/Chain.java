public class Chain implements Runnable {
     private int fps = 120;
     private int UPS = 120;
     Thread ChainLoopThread;

     public Chain(){
         ChainLoopThread = new Thread(this);
         ChainLoopThread.start();
     }

     @Override
     public void run(){
         double timePerFrame = 1000000000.0 / fps;
         double timePerUpdate = 1000000000.0 / UPS;
         long previousTime = System.nanoTime();

         int frames = 0;
         int updates = 0;
         long lastCheck = System.currentTimeMillis();

         double deltaU = 0;
         double deltaF = 0;

         while (true) {
             long currentTime = System.nanoTime();

             deltaU += (currentTime - previousTime) / timePerUpdate;
             deltaF += (currentTime - previousTime) / timePerFrame;
             previousTime = currentTime;

             if (deltaU >= 1) {

             }

             if (deltaF >= 1) {//fbs

             }

             if (System.currentTimeMillis() - lastCheck >= 1000) {//every 1 sec
                 lastCheck = System.currentTimeMillis();
                 System.out.println("FPS: " + frames +" | " + updates );
                 frames = 0;
                 updates = 0;
             }
         }
     }
}
