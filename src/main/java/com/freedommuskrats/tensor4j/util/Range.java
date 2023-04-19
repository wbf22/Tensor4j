package com.freedommuskrats.tensor4j.util;


/**
 * Class for generating ranges similar to Python range.
 * Generates int array ranges.
 */
public class Range {

    private boolean all;
    private int[] sequence;


    private Range(boolean all, int[] sequence) {
        this.all = all;
        this.sequence = sequence;
    }

    /**
     * Creates a range that it marked with an all flag.
     * However, calling getSequence will return a null
     * array.
     * @return
     */
    public static Range all() {
        return new Range(true, null);
    }

    /**
     * Creates a range sequence from 0 to stop.
     * Stop can be negative.
     * @param stop
     * @return
     */
    public static Range range (int stop) {
        return range(0, stop, 1);
    }

    /**
     * Creates a range sequence from start to stop.
     * Start can be greater than Stop
     * @param stop
     * @return
     */
    public static Range range (int start, int stop) {
        return range(start, stop, 1);
    }

    /**
     * Creates a range sequence from start to stop with given step.
     * Start can be greater than Stop, and step can be negative.
     * If step is 0 an empty array is returned.
     * @param stop
     * @return
     */
    public static Range range (int start, int stop, int step) {
        int size = (step == 0)? (stop - start) : (stop - start) / step;
        size = (stop < start)? size * -1 : size;

        int[] sequence = new int[size];
        for (int i = 0; i < sequence.length; i++) {
            sequence[i] = start + i * step;
        }

        return new Range(false, sequence);
    }

    public int size() {
        return (all)? Integer.MAX_VALUE : sequence.length;
    }

    public int[] getSequence() {
        return sequence;
    }
}
