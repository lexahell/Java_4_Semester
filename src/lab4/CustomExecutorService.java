package lab4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class CustomExecutorService implements ExecutorService {
    private final List<Thread> threads;
    private final BlockingQueue<Runnable> tasks;

    public CustomExecutorService(int numberOfThreads) {
        threads = new ArrayList<>(numberOfThreads);
        tasks = new LinkedBlockingQueue<>();

        for (int i = 0; i < numberOfThreads; i++) {
            Thread thread = new Thread(() -> {
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        Runnable task = tasks.take();
                        task.run();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            });
            thread.start();
            threads.add(thread);
        }
    }

    @Override
    public void shutdown() {
        for (Thread thread : threads) {
            thread.interrupt();
        }
    }

    @Override
    public List<Runnable> shutdownNow() {
        shutdown();
        List<Runnable> remainingTasks = new ArrayList<>();
        tasks.drainTo(remainingTasks);
        return remainingTasks;
    }

    @Override
    public boolean isShutdown() {
        for (Thread thread : threads) {
            if (thread.isAlive()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isTerminated() {
        for (Thread thread : threads) {
            if (!thread.isInterrupted()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        long endTime = System.currentTimeMillis() + unit.toMillis(timeout);
        while (System.currentTimeMillis() < endTime) {
            if (isTerminated()) {
                return true;
            }
            Thread.sleep(100); // Wait for a short while before checking again
        }
        return false;
    }

    @Override
    public <T> Future<T> submit(Callable<T> task) {
        return null;
    }

    @Override
    public <T> Future<T> submit(Runnable task, T result) {
        return null;
    }

    @Override
    public Future<?> submit(Runnable task) {
        tasks.add(task);
        return null;
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
        return null;
    }

    @Override
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException {
        return null;
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
        return null;
    }

    @Override
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return null;
    }

    @Override
    public void execute(Runnable command) {
        if (command == null) {
            throw new NullPointerException();
        }
        try {
            tasks.put(command);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
