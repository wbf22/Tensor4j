package com.freedommuskrats.brarrays.data;

import org.junit.jupiter.api.Test;

import static com.freedommuskrats.brarrays.util.ArrayGen.*;
import static com.freedommuskrats.brarrays.util.PrimitiveConversion.toPrimitive;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataDoulbe4dTest {
    @Test
    void append_dim0 () {
        double[][][][] start = toPrimitive(
                genArray4d(Double.class, 1.0, new int[]{4, 4, 2, 2}), 0.0
        );
        double[][][][] sec = toPrimitive(
                genArray4d(Double.class, 2.0, new int[]{1, 4, 2, 2}), 0.0
        );
        DataDouble4d d3Start = new DataDouble4d(start);
        DataDouble4d d3Sec = new DataDouble4d(sec);
        d3Start.append(d3Sec, 0);

//        System.out.print(d3Start);
//        System.out.println();
        assertEquals(d3Start.get(3, 0, 1, 1), 1.0);
        assertEquals(d3Start.get(2, 2, 1, 1), 1.0);
        assertEquals(d3Start.get(1, 3, 0, 0), 1.0);
        assertEquals(d3Start.get(4, 1, 1, 1), 2.0);
        assertEquals(d3Start.get(4, 1, 0, 0), 2.0);
        assertEquals(d3Start.get(4, 3, 1, 1), 2.0);
    }

    @Test
    void append_dim1 () {
        double[][][][] start = toPrimitive(
                genArray4d(Double.class, 1.0, new int[]{4, 4, 2, 2}), 0.0
        );
        double[][][][] sec = toPrimitive(
                genArray4d(Double.class, 2.0, new int[]{4, 1, 2, 2}), 0.0
        );
        DataDouble4d d3Start = new DataDouble4d(start);
        DataDouble4d d3Sec = new DataDouble4d(sec);
        d3Start.append(d3Sec, 1);

//        System.out.print(d3Start);
//        System.out.println();
        assertEquals(d3Start.get(3, 0, 1, 1), 1.0);
        assertEquals(d3Start.get(2, 2, 1, 1), 1.0);
        assertEquals(d3Start.get(1, 3, 0, 0), 1.0);
        assertEquals(d3Start.get(3, 4, 1, 1), 2.0);
        assertEquals(d3Start.get(2, 4, 0, 0), 2.0);
        assertEquals(d3Start.get(0, 4, 1, 1), 2.0);
    }

    @Test
    void append_dim3 () {
        double[][][][] start = toPrimitive(
                genArray4d(Double.class, 1.0, new int[]{4, 4, 3, 2}), 0.0
        );
        double[][][][] sec = toPrimitive(
                genArray4d(Double.class, 2.0, new int[]{4, 4, 3, 3}), 0.0
        );
        DataDouble4d d3Start = new DataDouble4d(start);
        DataDouble4d d3Sec = new DataDouble4d(sec);
        d3Start.append(d3Sec, 3);

//        System.out.print(d3Start);
//        System.out.println();
        assertEquals(d3Start.get(3, 0, 1, 1), 1.0);
        assertEquals(d3Start.get(2, 2, 1, 1), 1.0);
        assertEquals(d3Start.get(1, 3, 0, 0), 1.0);
        assertEquals(d3Start.get(3, 3, 1, 3), 2.0);
        assertEquals(d3Start.get(2, 1, 0, 4), 2.0);
        assertEquals(d3Start.get(0, 2, 1, 2), 2.0);
    }

    @Test
    void append_2dArray () {
        double[][][][] start = toPrimitive(
                genArray4d(Double.class, 1.0, new int[]{4, 4, 3, 2}), 0.0
        );
        double[][][] sec = toPrimitive(
                genArray3d(Double.class, 2.0, new int[]{4, 4, 3}), 0.0
        );
        DataDouble4d d3Start = new DataDouble4d(start);
        DataDouble3d d3Sec = new DataDouble3d(sec);
        d3Start.append(d3Sec);

//        System.out.print(d3Start);
//        System.out.println();

        assertEquals(d3Start.get(3, 0, 1, 1), 1.0);
        assertEquals(d3Start.get(2, 2, 1, 1), 1.0);
        assertEquals(d3Start.get(1, 3, 0, 0), 1.0);
        assertEquals(d3Start.get(3, 3, 1, 2), 2.0);
        assertEquals(d3Start.get(2, 2, 0, 2), 2.0);
        assertEquals(d3Start.get(0, 3, 1, 2), 2.0);
    }

}