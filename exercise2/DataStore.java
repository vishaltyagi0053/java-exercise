package ttn.cloudwords.exercise2;

import java.util.LinkedList;
import java.util.List;

public class DataStore {

    private List<Integer> data = new LinkedList();

    public void add(Integer val) {
        synchronized (this) {
            if (data.size() >= 10) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            data.add(val);
            System.out.println("Data added :: " + val + ", queue size > " + data.size());
            notify();
        }
    }

    public void consume() {
        synchronized (this) {
            if (data.size() == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Integer val = data.remove(0);
            System.out.println("Data consumed :: " + val + ", queue size > " + data.size());
            notify();
        }
    }
}
