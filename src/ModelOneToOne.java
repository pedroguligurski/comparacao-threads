public class ModelOneToOne {
    public static void main(String[] args) throws InterruptedException {
        int[] threadCounts = {10, 100, 500, 1000};

        for (int n : threadCounts) {
            Thread[] threads = new Thread[n];

            long start = System.currentTimeMillis();

            for (int i = 0; i < n; i++) {
                threads[i] = new Thread(new Task(i));
                threads[i].start();
            }

            for (Thread t : threads) {
                t.join();
            }

            long end = System.currentTimeMillis();
            System.out.printf("1:1 -> %d threads em %d ms%n", n, (end - start));
        }
    }
}
