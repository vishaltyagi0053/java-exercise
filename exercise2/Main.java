package ttn.cloudwords.exercise2;

public class Main {

    public static void main(String[] args) {
        DataStore dataStore = new DataStore();
        Thread thread = new Thread(new Producer(dataStore));
        Thread thread1 = new Thread(new Consumer(dataStore));
        thread.start();
        thread1.start();
    }
}
