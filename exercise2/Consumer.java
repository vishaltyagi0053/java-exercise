package ttn.cloudwords.exercise2;

public class Consumer implements Runnable {
    DataStore dataStore;

    public Consumer(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            dataStore.consume();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
