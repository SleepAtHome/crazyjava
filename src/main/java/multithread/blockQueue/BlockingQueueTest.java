package multithread.blockQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * ClassName: BlockingQueueTest
 * Description: BlockingQueue的基本用法
 * date: 2019/11/27 23:10
 *
 * @author jingyuankui
 * @since JDK 1.8
 */
public class BlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(2);
        blockingQueue.put("JYK");
        blockingQueue.put("JYK2");
        // 阻塞线程（使用put阻塞、使用add异常、使用offer返回false，元素不被放入）
        // 类似，当BlockingQueue为空时，使用take阻塞、使用remove异常、使用poll返回false
        blockingQueue.put("JYK3");

    }
}
