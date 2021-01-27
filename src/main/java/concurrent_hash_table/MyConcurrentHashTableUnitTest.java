package concurrent_hash_table;

import org.junit.Assert;
import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class MyConcurrentHashTableUnitTest {
    private static final int MAX_ENTRIES = 1000000;
    private static final int NUM_THREADS = 100;
    private static MyConcurrentHashTable table;
    private static Map<Integer, String> result= new HashMap<>();

    public MyConcurrentHashTableUnitTest() {
    }

    @Test
    public void testPut(){  // single thread puts
        table = new MyConcurrentHashTable<Integer, String>(1000);
        for (int i = 0; i < MAX_ENTRIES; i++) {
            int randomNum = ThreadLocalRandom.current().nextInt(0, Integer.MAX_VALUE);
            String randomString = generateRandomString(50);
            table.put(randomNum, randomString);
            result.put(randomNum, randomString);
            System.out.println("<" + randomNum + ", " + randomString + ">");
        }
        Assert.assertEquals(result.size(), table.getTotal());
    }

    @Test
    public void testGet(){  // single thread puts/gets
        int hit_count = 0;
        testPut();
        for (Map.Entry<Integer, String> entry: result.entrySet()) {
            String value = (String) table.get(entry.getKey());
            if (value != null && value.equals(entry.getValue())) {
                hit_count++;
            }
            System.out.println("<" + entry.getKey() + "-> " + value + ">");
        }
        Assert.assertEquals(result.size(), hit_count);
        table.getTotal();
    }

    @Test
    public void testRemove() {  // single thread remove
        testPut();
        for (Map.Entry<Integer, String> entry : result.entrySet()) {
            table.remove(entry.getKey());
        }
        Assert.assertEquals(0, table.getTotal());
    }

    @Test
    public void testMultiPutLowBuckets(){  // test multi-thread puts on single bucket
        table = new MyConcurrentHashTable<Integer, String>(200);
        long latency = multiputTest();
        assert(latency > 40000);
    }

    @Test
    public void testMultiPutDefaultBuckets(){  // test multi-thread puts on multi buckets
        table = new MyConcurrentHashTable<Integer, String>(1000);
        long latency = multiputTest();
        assert(latency < 20000);
    }

    @Test
    public void testMultiPutMoreBuckets(){  // test multi-thread puts on multi buckets
        table = new MyConcurrentHashTable<Integer, String>(5000);
        long latency = multiputTest();
        assert(latency < 15000);
    }

    @Test
    public void testMultiPutMaxBuckets(){  // test multi-thread puts on multi buckets
        table = new MyConcurrentHashTable<Integer, String>(10000);
        long latency = multiputTest();
        assert(latency < 13000);
    }

    @Test
    public void testMultiPutAndGetDefaultBuckets(){  // test multi-thread puts on multi buckets
        table = new MyConcurrentHashTable<Integer, String>(10000);
        long latency = multiputAndGetTest();
        assert(latency < 30000);
    }

    private long multiputTest() {
        Instant start = Instant.now();
        List<MultithreadPut> threads = new ArrayList<>();
        for (int i=0; i<NUM_THREADS; i++)
        {
            MultithreadPut object = new MultithreadPut(table,MAX_ENTRIES/NUM_THREADS, i);
            threads.add(object);
            object.start();
        }

        // join threads
        for (MultithreadPut thread : threads) {
            try {
                thread.join();
            }
            catch (Exception e)
            {
                // Throwing an exception
                System.out.println ("Exception is caught");
            }
        }
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        table.getTotal();
        System.out.println("timeElapsed = " + timeElapsed.toMillis() + " milliseconds");
        return timeElapsed.toMillis();
    }

    private long multiputAndGetTest() {
        Instant start = Instant.now();
        List<Thread> threads = new ArrayList<>();
        for (int i=0; i<NUM_THREADS; i++)
        {
            MultithreadPut object = new MultithreadPut(table,MAX_ENTRIES/NUM_THREADS, i);
            threads.add(object);
            object.start();

            MultithreadGet object1 = new MultithreadGet(table,MAX_ENTRIES/NUM_THREADS, i);
            threads.add(object1);
            object1.start();
        }

        // join threads
        for (Thread thread : threads) {
            try {
                thread.join();
            }
            catch (Exception e)
            {
                // Throwing an exception
                System.out.println ("Exception is caught");
            }
        }
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        table.getTotal();
        System.out.println("timeElapsed = " + timeElapsed.toMillis() + " milliseconds");
        return timeElapsed.toMillis();
    }

    public static String generateRandomString(int length) {
        String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
        String CHAR_UPPER = CHAR_LOWER.toUpperCase();
        String NUMBER = "0123456789";

        final String DATA_FOR_RANDOM_STRING = CHAR_LOWER + CHAR_UPPER + NUMBER;
        if (length < 1) throw new IllegalArgumentException();

        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {

            // 0-62 (exclusive), random returns 0-61
            int rndCharAt = ThreadLocalRandom.current().nextInt(0,
                    DATA_FOR_RANDOM_STRING.length());
            char rndChar = DATA_FOR_RANDOM_STRING.charAt(rndCharAt);
            sb.append(rndChar);
        }

        return sb.toString();

    }
}

// Multi Puts thread creation by extending
// the Thread class
class MultithreadPut extends Thread {
    int threadId = 0;
    int batchSize = 0;
    MyConcurrentHashTable table;

    public MultithreadPut(MyConcurrentHashTable table, int batchSize, int id) {
        this.threadId = id;
        this.batchSize = batchSize;
        this.table = table;
    }

    public void run() {
        try {
            // Displaying the thread that is running
            System.out.println("Thread " + threadId + " is running");
            for (int i = 0; i < batchSize; i++) {
                int randomNum = ThreadLocalRandom.current().nextInt(0, Integer.MAX_VALUE);
                String randomString = MyConcurrentHashTableUnitTest.generateRandomString(50);
                table.put(randomNum, randomString);
                //keys.add(randomNum);
                System.out.println("<" + randomNum + ", " + randomString + ">");
            }
        } catch (Exception e) {
            // Throwing an exception
            System.out.println("Exception is caught");
        }
    }
}

// Multi Gets thread creation by extending
// the Thread class
class MultithreadGet extends Thread {
    int threadId = 0;
    int batchSize = 0;
    MyConcurrentHashTable table;

    public MultithreadGet(MyConcurrentHashTable table, int batchSize, int id) {
        this.threadId = id;
        this.batchSize = batchSize;
        this.table = table;
    }

    public void run() {
        try {
            // Displaying the thread that is running
            System.out.println("Thread " + threadId + " is running");
            for (int i = 0; i < batchSize; i++) {
                int randomNum = ThreadLocalRandom.current().nextInt(0, Integer.MAX_VALUE);
                //String randomString = MyConcurrentHashTableUnitTest.generateRandomString(50);
                String value = (String) table.get(randomNum);
                //keys.add(randomNum);
                System.out.println("<" + randomNum + "-> " + value + ">");
            }
        } catch (Exception e) {
            // Throwing an exception
            System.out.println("Exception is caught");
        }
    }
}