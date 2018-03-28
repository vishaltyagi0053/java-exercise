package ttn.cloudwords.exercise2;

import java.util.Random;

public class Producer implements Runnable {

    DataStore dataStore;

    public Producer(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (!Thread.currentThread().isInterrupted()) {
            dataStore.add(random.nextInt(100));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
