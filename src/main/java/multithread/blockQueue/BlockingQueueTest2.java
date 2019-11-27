package multithread.blockQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * ClassName: BlockingQueueTest2
 * Description: 使用BlockingQueue进行线程通信
 * date: 2019/11/27 23:23
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class BlockingQueueTest2 {
    public static void main(String[] args) {
        // 创建一个容量为1的BlockingQueue
        BlockingQueue<String> bq = new ArrayBlockingQueue<>(1);

        // 启动3个生产者线程
        new Producer(bq).start();
        new Producer(bq).start();
        new Producer(bq).start();

        //启动1个消费者线程
        new Customer(bq).start();
    }
}

class Producer extends Thread {
    private BlockingQueue<String> blockingQueue;

    public Producer(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        String[] srtArr = new String[]{"Java","Spring","SQL"};
        for (int i=0; i<999999999; i++) {
            System.out.println(getName()+"生产者准备生产集合元素！");
            try {
                Thread.sleep(200);
                // 尝试放入元素，如果队列已满，则线程被阻塞
                blockingQueue.put(srtArr[i%3]);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName()+"生产完成："+blockingQueue);
        }
    }
}

class Customer extends Thread {
    private BlockingQueue<String> blockingQueue;

    public Customer(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(getName()+"消费者准备消费集合元素！");
            try {
                Thread.sleep(200);
                // 尝试取出元素，如果队列已空，则线程被阻塞
                blockingQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 这里的blockingQueue有可能打印出来里面包含元素，是因为在take之后，打印之前，其他线程可能已经放入其中了
            System.out.println(getName()+"消费完成："+blockingQueue);
        }
    }
}
