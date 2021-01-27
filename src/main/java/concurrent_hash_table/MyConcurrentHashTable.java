package concurrent_hash_table;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author l.xie@salesforce.com
 * @version $Revision$
 */
public class MyConcurrentHashTable<K, V> implements ConcurrentHashTable<K, V> {
    /**
     * Total number of buckets. This is the concurrency setting.
     */
    private static int _numBuckets = 1000; //default concurrency
    /**
     * Array list to store the hash buckets. We use an ArrayList instead of an array so that we can
     * use generics. We explicitly use ArrayList (instead of List) because this needs to support
     * efficient index based access. Similarly, we use LinkedList for the buckets, since they must
     * support efficient insert and delete.
     * <p>
     * Alternatively we could use "Node[] _buckets = new Node<Object, Object>(_numBuckets);", but that
     * requires an unchecked cast for the return value in "get". Note that you cannot create
     * Node[] _buckets = new Node[_numBuckets] - that will not compile (generics error).
     */
    private final ArrayList<LinkedList<Node>> _buckets = new ArrayList<LinkedList<Node>>(_numBuckets);

    /**
     * Array of ReentrantLocks used to guard the hashtable buckets (LinkedLists) from concurrent
     * access. The lock array is the same size as the bucket array, but that is not strictly necessary.
     * Using fewer locks would simply mean more than one bucket is guarded by each lock
     * <p>
     * We could allow a concurrency factor to be passed to the constructor and and calculate
     * an appropriate number of locks from that, but do not do that here for simplicity sake.
     */
    private final ArrayList<ReentrantLock> _bucketLocks = new ArrayList<ReentrantLock>(_numBuckets);

    /**
     * Create a new, empty hashtable.
     */
    public MyConcurrentHashTable(int concurrency) {
        // Initialize the buckets and locks.
        // We must initialize the _buckets or else _buckets.size() is zero and we get
        // OutOfBoundsExceptions. If we used an array instead of ArrayList then we would not have to
        // initialize _buckets (since arrays elements automatically initialize to null).
        setConcurrency(concurrency);
        for (int i = 0; i < _numBuckets; i++) {
            _bucketLocks.add(new ReentrantLock());
            _buckets.add(null);
        }
    }

    @Override
    public void setConcurrency(int numLocks) {
        _numBuckets = numLocks;
    }

    /**
     * Return the value associated with the given key. If the key does not exist then return null.
     *
     * @param key key to lookup
     * @return value associated with key; null if none exists
     * @throws NullPointerException if key is null
     */
    @Override
    public V get(K key) {
        try {
            // Lock and get the bucket for this key
            LinkedList<Node> bucket = lockAndReturnBucket(key);

            // Iterate through the bucket looking for the key. If we find it, return the value.
            for (Node node : bucket) {
                if (node.key.equals(key)) {
                    return node.value;
                }
            }

            // We did not find the key. Return null.
            return null;
        } finally {
            // Unlock the bucket
            unlockBucket(key);
        }
    }

    /**
     * Add the key-value pair to the hashtable. If the key already exists, it's value will be
     * overwritten. Key and value must be non-null.
     *
     * @param key   the key
     * @param value the value
     * @throws NullPointerException if key or value are null
     */
    @Override
    public void put(K key, V value) {
        try {
            // Lock and get the bucket for this key
            LinkedList<Node> bucket = lockAndReturnBucket(key);

            // Iterate through the bucket looking for the key. If we find it then replace the value and return.
            for (Node node : bucket) {
                if (node.key.equals(key)) {
                    node.value = value;
                    return;
                }
            }

            // We did not find the key already in the bucket. Add it and return.
            bucket.add(new Node(key, value));
        } finally {
            // Unlock the bucket
            unlockBucket(key);
        }
    }

    /**
     * Obtain a lock on the bucket for the given key, then return the bucket. All calls
     * to this method must be followed by a call to {@see #unlockBucket(K)} in a
     * {@code finally} block.
     *
     * @param key the desired bucket's key
     */
    private LinkedList<Node> lockAndReturnBucket(K key) {
        // Calculate the hash code for the key, then convert that to the index within the
        // buckets List.
        int hashCode = key.hashCode();
        int bucketIndex = Math.abs(hashCode % _numBuckets);

        _bucketLocks.get(bucketIndex).lock();

        // Find the LinkedList in the buckets array. If we haven't initialized that bucket yet
        // then create a new LinkedList and put it at the correct spot in the list.
        LinkedList<Node> bucket = _buckets.get(bucketIndex);
        if (bucket == null) {
            bucket = new LinkedList<Node>();
            _buckets.set(bucketIndex, bucket);
        }

        // Return the LinkedList bucket
        return bucket;
    }

    /**
     * Unlock a bucket that was previously locked with a call to {@see #lockAndReturnBucket(K)}.
     *
     * @param key the bucket's key
     */
    private void unlockBucket(K key) {
        // Calculate the hash code for the key, then convert that to the index within the
        // buckets List.
        int hashCode = key.hashCode();
        int bucketIndex = Math.abs(hashCode % _numBuckets);

        _bucketLocks.get(bucketIndex).unlock();
    }

    /**
     * Inner class to represent a key-value pair in the LinkedList "buckets".
     */
    public class Node {
        K key;
        V value;

        private Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // The remove method, which is not included in the interface, is shown below. The candidate does not need to write this method. I am adding it because I already have it written, and we may decide to add it to the interface in the future.
    /**
     * Remove the given key (and its associated value) from this Hashtable.
     *
     * @param key key to lookup
     * @throws NullPointerException if key is null
     */
    @Override
    public void remove(K key) {
        try {
            // Lock and get the bucket for this key
            LinkedList<Node> bucket = lockAndReturnBucket(key);

            // Iterate over the bucket looking for the key. If we find it, remove it from the bucket.
            // Notice that we use an explicit iterator so that we may call ".remove" on the iterator and
            // remove the item.
            Iterator<Node> bucketIterator = bucket.iterator();
            while (bucketIterator.hasNext()) {
                Node node = bucketIterator.next();
                if (node.key.equals(key)) {
                    bucketIterator.remove();
                    return;
                }
            }
        } finally {
            // Unlock the bucket
            unlockBucket(key);
        }
    }

    @Override
    public int getTotal() {
        int total = 0;
        System.out.println("stats in hash table");
        for (int i=0; i<_buckets.size(); ++i) {
            System.out.println(i + " : " + _buckets.get(i).size());
            total += _buckets.get(i).size();
        }
        return total;
    }
}
