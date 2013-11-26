package youngjin.Exercise.Q4;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Database<K, V> {
    private final Map<K, V> map = new HashMap<K, V>();
    private final ReadWriteLock lock = new ReentrantReadWriteLock(true /* fair */);
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();


    public Set<K> getKey() {
        return map.keySet();
    }


    public void clear() {
        verySlowly();
        map.clear();
    }

    public void assign(K key, V value) {
        writeLock.lock();
        try {
            verySlowly();
            map.put(key, value);
        } finally {
            writeLock.unlock();
        }
    }

    public V retrieve(K key) {
        readLock.lock();
        V value = null;
        try {
            slowly();
            value = map.get(key);
        } finally {
            readLock.unlock();
            System.out.println("readLock.unlock() finished");
        }

        return value;
    }

    private void slowly() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
        }
    }

    private void verySlowly() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
    }
}
