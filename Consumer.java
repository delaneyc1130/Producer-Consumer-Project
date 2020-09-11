import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable {

	Random rand_var = new Random();
	static boolean running = true;
	public String name_var;
	LinkedBlockingQueue<String> Consumer_queue = new LinkedBlockingQueue<String>();
	
	public Consumer(LinkedBlockingQueue<String> ConsumerQueue,String ConsumerName){
		Consumer_queue = ConsumerQueue;
		name_var = ConsumerName;
	}
	
	@Override
	public void run() {
		int consumer_total = 0;
		int steps = 0;
		while (Consumer_queue.size() >= 1 || Producer.running == true) {
			if (steps % 100 == 0 && consumer_total != 0) {
				System.out.println(name_var + ":" + " " + steps + " " + "events consumed");
			}
			try {
				String poll_var = Consumer_queue.poll(rand_var.nextInt(10) +1, TimeUnit.MILLISECONDS);
				if (poll_var != null){
					consumer_total++;
				}

			}
			catch(InterruptedException e){
			}
			steps++;
		}
		System.out.println(name_var + " " + "consumes" + " " + consumer_total + " " + "events.");
	}

}


