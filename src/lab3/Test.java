package lab3;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        testSynchronizedSet();
        testHashSet();
        testLockedMap();
        testHashMap();
    }

    private static void testSynchronizedSet() {
        Set<Integer> set = new HashSet<>();
        Set<Integer> synchronizedSet = new SynchronizedSet<>(set);

        Runnable task = () -> {
            for (int i = 0; i < 10000; i++) {
                synchronizedSet.add(i);
            }
        };

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(task));
        }

        threads.forEach(Thread::start);

        threads.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("Synchronized Set size: " + synchronizedSet.size());
    }
    private static void testHashSet(){

        Set<Integer> hashSet = new HashSet<>();

        Runnable task = () -> {
            for (int i = 0; i < 10000; i++) {
                hashSet.add(i);
            }
        };

        List<Thread> threads_1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads_1.add(new Thread(task));
        }

        threads_1.forEach(Thread::start);

        threads_1.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("hashSet size: " + hashSet.size());
    }
    private static void testLockedMap() {
        Map<Integer, String> lockedMap = new LockedMap<>();

        Runnable task = () -> {
            for (int i = 0; i < 10000; i++) {
                lockedMap.put(i, "Value" + i);
            }
        };

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(task));
        }

        threads.forEach(Thread::start);

        threads.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("Locked Map size: " + lockedMap.size());
    }
    private static void testHashMap() {
        Map<Integer, String> hashMap = new HashMap<>();

        Runnable task = () -> {
            for (int i = 0; i < 10000; i++) {
                hashMap.put(i, "Value" + i);
            }
        };

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(task));
        }

        threads.forEach(Thread::start);

        threads.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("hashMap size: " + hashMap.size());

    }
}
