import java.util.concurrent.LinkedBlockingQueue;

public class Producer implements Runnable{

	static boolean running = true;
	public String name_var;
	LinkedBlockingQueue<String> Producer_queue = new LinkedBlockingQueue<String>();
	
	public Producer(LinkedBlockingQueue<String> ProducerQueue,String ProducerName){
		Producer_queue = ProducerQueue;
		name_var = ProducerName;
	}
	
	@Override
	public void run() {
		int temp_v = 0;
		for (int i = 0; i <1000; i++){
			double n = Math.random();
			String s = Double.toString(n);
			if (i % 100 == 0 && Producer_queue.size() != 0) {
				System.out.println(name_var + ":" + " " + i + " " + "events produced");
			}
			try {
				Producer_queue.put(s);
			} 
			catch(InterruptedException e) {
				e.printStackTrace();
				
			}
			temp_v++;	
		}
		running = false;
		System.out.println("Summary:");
		System.out.println(name_var + " " + "produces" + " " + temp_v + " " + "events.");	
	}
}


