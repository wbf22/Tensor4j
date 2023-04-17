package com.freedommuskrats.brarrays.data;

import com.freedommuskrats.brarrays.exception.RangeException;

public class Range {

    private boolean all;
    private int[] sequence;

    private Range(boolean all, int[] sequence) {
        this.all = all;
        this.sequence = sequence;
    }

    public static Range all() {
        return new Range(true, null);
    }

    public static Range range (int stop) {
        return range(0, stop, 1);
    }

    public static Range range (int start, int stop) {
        return range(start, stop, 1);
    }

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
