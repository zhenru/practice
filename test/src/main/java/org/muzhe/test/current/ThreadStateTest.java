package org.muzhe.test.current;

import java.util.concurrent.locks.LockSupport;

/**
 * @author muzhe-wang on  18-10-10 上午9:48.
 */
public class ThreadStateTest {

    public static void main(String[] args) {

        Thread.State state = Thread.currentThread().getState();

        Object blocker = LockSupport.getBlocker(Thread.currentThread());
        System.out.println(blocker);

    }
}
