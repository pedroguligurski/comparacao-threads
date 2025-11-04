import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ModelNM {
    public static void main(String[] args) throws InterruptedException {
        int[] threadCounts = {10, 100, 500, 1000};
        int poolSize = 8;

        for (int n : threadCounts) {
            ExecutorService executor = Executors.newFixedThreadPool(poolSize);

            long start = System.currentTimeMillis();

            for (int i = 0; i < n; i++) {
                executor.submit(new Task(i));
            }

            executor.shutdown();
            executor.awaitTermination(1, TimeUnit.HOURS);

            long end = System.currentTimeMillis();
            System.out.printf("N:M -> %d tarefas em %d ms (pool de %d threads)%n",
                    n, (end - start), poolSize);
        }
    }
}
