import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

	public static void main(String[] args){
		LinkedBlockingQueue<String> queue1 = new LinkedBlockingQueue<String>(100);
		ExecutorService executor = Executors.newCachedThreadPool();
		executor.submit(new Producer(queue1, "\"Producer 1\""));
		executor.submit(new Consumer(queue1, "\"Consumer 1\""));
		executor.submit(new Consumer(queue1, "\"Consumer 2\""));
	}
}



