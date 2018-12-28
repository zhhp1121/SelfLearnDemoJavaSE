package ProducerConsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class ProducerConsumerLock {

	private final int MAX_LEN = 100;
    private Queue queue = new LinkedList<String>();
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    class Producer extends Thread {
    	
        @Override
        public void run() {
            produce();
        }
        private void produce() {
            while(true) {
            	lock.lock();
            	try {
            		if (queue.size() == MAX_LEN) {
                        System.out.println("队列已经满了，等待消费");
                        try {
                        	condition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.add("task");
                    condition.signal();
                    System.out.println("生产一条任务，当前队列长度为" + queue.size());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            	}finally {
            		lock.unlock();
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
            	lock.lock();
            	try {
            		if (queue.size() == 0) {
                        System.out.println("队列为空,等待生产");
                        try {
                        	condition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.poll();
                    condition.signal();
                    System.out.println("消费者消费一条任务，当前队列长度为" + queue.size());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            	}finally {
            		lock.unlock();
            	}
            }
        }
    }
    public static void main(String[] args) {
    	ProducerConsumerLock pc = new ProducerConsumerLock();
        Producer producer = pc.new Producer();
        Consumer consumer = pc.new Consumer();
        producer.start();
        consumer.start();
    }
}
