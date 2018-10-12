package org.muzhe.lambada.ch6;

import java.util.function.Consumer;

/**
 * @author muzhe-wang on  18-10-12 下午4:46.
 */
public class CollectorHarness {

    public static void main(String[] args) {

    }


    /**
     * 及栓出当前的最快的值
     * @param primePartitioner
     * @return
     */
    private static long execute(Consumer<Integer> primePartitioner) {

        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            primePartitioner.accept(1_000_000);
            long duration = (System.nanoTime() - start) / 1_000_000;
            if (duration < fastest) {
                fastest = duration;
            }
            System.out.println(" done in " + duration);
        }
        return fastest;
    }
}
