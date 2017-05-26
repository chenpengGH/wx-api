package cp.test.jdk;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * Description:
 *
 * @author: jhc
 * @create: 2017/5/26
 * @version: 1.0
 */
public class TestMain2 {
    public static void main(String[] args) {
        //  获取Java线程管理MXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        //  不需要同步的monitor和synchronizer信息，仅获取线程和堆栈信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        //  遍历线程信息
        for (ThreadInfo threadInfo: threadInfos) {
            System.out.println("[" + threadInfo.getThreadId() + "]" + threadInfo.getThreadName()/* + " | " + threadInfo*/);
        }
    }
}
