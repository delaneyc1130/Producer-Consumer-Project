# Producer-Consumer-Project
An implementation that simulates producer and consumer threads.
The consumer will take more time to complete than the producer, causing the machine to run out of memory if threads are not synchronized in such a way that no more than a specified number of units are produced prior to being consumed.

 Implement Runnable to simulate the producer. When executed, a total of 1000 random Strings are added to the above queue. Then print the progress once every 100 Strings added.
 
 Implement Runnable to simulate the consumer. When executed, this thread consumes Strings from the queue. Consumption continues as long as there are Strings in the queue or the producer hasn’t finished. Then print the progress once every 100 Strings consumed. 
