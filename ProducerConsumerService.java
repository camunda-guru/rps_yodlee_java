package com.cts.blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerService {
	public static void main(String[] args) {
		/*
		 A thread trying to dequeue from an empty queue is blocked until 
		 some other thread inserts an item into the queue. A thread trying 
		 to enqueue an item in a full queue is blocked until some other thread
		  makes space in the queue, either by dequeuing one or more items or
		   clearing the queue completely.
		  
		 */
		
        //Creating BlockingQueue of size 10
        BlockingQueue<Message> queue = new ArrayBlockingQueue<>(10);
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        //starting producer to produce messages in queue
        new Thread(producer).start();
        //starting consumer to consume messages from queue
        new Thread(consumer).start();
        System.out.println("Producer and Consumer has been started");
    }
}
