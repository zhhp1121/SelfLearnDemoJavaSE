package ProducerConsumer;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerSynchronized {
    private final int MAX_LEN = 100;
    private Queue queue = new LinkedList<String>();
    class Producer extends Thread {
    	
        @Override
        public void run() {
            produce();
        }
        private void produce() {
            while(true) {
                synchronized (queue) {
                	if (queue.size() == MAX_LEN) {
                        System.out.println("队列已经满了，等待消费");
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.add("task");
                    queue.notify();
                    System.out.println("生产一条任务，当前队列长度为" + queue.size());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
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
                synchronized (queue) {
                    if (queue.size() == 0) {
                        System.out.println("队列为空,等待生产");
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.poll();
                    queue.notify();
                    System.out.println("消费者消费一条任务，当前队列长度为" + queue.size());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        ProducerConsumerSynchronized pc = new ProducerConsumerSynchronized();
        Producer producer = pc.new Producer();
        Consumer consumer = pc.new Consumer();
        producer.start();
        consumer.start();
    }
}