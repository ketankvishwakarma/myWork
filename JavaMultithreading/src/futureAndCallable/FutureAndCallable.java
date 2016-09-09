package futureAndCallable;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureAndCallable {

	public static void main(String[] args) {

		ExecutorService executor = Executors.newCachedThreadPool();

		Future<Integer> future = executor.submit(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {

				Random random = new Random();
				int duration = random.nextInt(4000);

				System.out.println("starting...");

				Thread.sleep(duration);

				System.out.println("End...");
				return duration;
			}

		});

		executor.shutdown();
		try {
			System.out.println("Resutl is :: " + future.get());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
