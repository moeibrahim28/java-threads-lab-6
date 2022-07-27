import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // create an executor
        ExecutorService executor = Executors.newCachedThreadPool();

        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            executor.submit(new PrimeLogger(num));
        }

    }
}

class PrimeLogger implements Runnable {
    private final int num;

    public PrimeLogger(int num) {
        this.num = num;
    }

    private boolean isAPrimeNumber() {

        if (num < 2) return false;
        if (num % 2 == 0 && num>2) return false;
        for (long i = 2; i < num; ++i) {
            if (this.num % i == 0) return false;
        }
        return true;
    }

    @Override
    public void run() {
        boolean isPrime = isAPrimeNumber();
        if (isPrime) {
            System.out.println(num + " " + isPrime);
        }
    }
}