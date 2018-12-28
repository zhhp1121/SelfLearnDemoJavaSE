package ProducerConsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerConcurentQueue {

	 private BlockingQueue<String> queue = new LinkedBlockingQueue<String>();
	 
	 class Producer extends Thread {
	        @Override
	        public void run() {
	            produce();
	        }
	        private void produce() {
	            while(true) {
	                try {
	                    queue.put(new String("task"));
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	                System.out.println("生产一条任务，当前队列长度为" + queue.size());
	                try {
	                    Thread.sleep(500);
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	    }
	    class Consumer extends Thread {
	        @Override
	        public void run() {
	            consumer();
	        }
	        private void consumer() {
	            while (true) {
	                try {
	                    queue.take();
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	                System.out.println("消费者消费一条任务，当前队列长度为" + queue.size());
	                try {
	                    Thread.sleep(500);
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	    }
	    public static void main(String[] args) {
	    	ProducerConsumerConcurentQueue pc = new ProducerConsumerConcurentQueue();
	        Producer producer = pc.new Producer();
	        Consumer consumer = pc.new Consumer();
	        producer.start();
	        consumer.start();
	    }
}
