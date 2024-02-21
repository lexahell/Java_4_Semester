package lab4;

import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {
        // Создаем экземпляр CustomExecutorService с двумя потоками
        CustomExecutorService executorService = new CustomExecutorService(2);

        // Создаем несколько задач для выполнения
        Runnable task1 = () -> {
            System.out.println("Task 1 started");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Task 1 completed");
        };

        Runnable task2 = () -> {
            System.out.println("Task 2 started");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Task 2 completed");
        };

        Runnable task3 = () -> {
            System.out.println("Task 3 started");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Task 3 completed");
        };

        // Передаем задачи на выполнение
        executorService.execute(task1);
        executorService.execute(task2);
        executorService.execute(task3);

    }
}
