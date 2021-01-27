package concurrent_hash_table;

public interface ConcurrentHashTable<K,V>
{
    /*
     * Concurrency setting, i.e., number of locks.
     */
    public void setConcurrency(int numLocks);

    /*
     * Get the value by key
     *
     */
    public V get(K key);

    /*
     * Put the item to the hash table
     */
    public void put(K key, V value);

    /*
     * Remove an item from the hash table
     */
    public void remove(K key);

    /*
     * Get current total number of entries
     */
    public int getTotal();
}
