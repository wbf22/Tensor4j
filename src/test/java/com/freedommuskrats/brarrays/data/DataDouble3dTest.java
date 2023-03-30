package com.freedommuskrats.brarrays.data;

import org.junit.jupiter.api.Test;

import static com.freedommuskrats.brarrays.util.ArrayGen.genArray2d;
import static com.freedommuskrats.brarrays.util.ArrayGen.genArray3d;
import static com.freedommuskrats.brarrays.util.PrimitiveConversion.toPrimitive;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataDouble3dTest {


    @Test
    void append_dim0 () {
        double[][][] start = toPrimitive(genArray3d(Double.class, 1.0, new int[]{4, 3, 2}), 0.0);
        double[][][] sec = toPrimitive(genArray3d(Double.class, 2.0, new int[]{1, 3, 2}), 0.0);
        DataDouble3d d3Start = new DataDouble3d(start);
        DataDouble3d d3Sec = new DataDouble3d(sec);
        d3Start.append(d3Sec, 0);

//        System.out.print(d3Start);
//        System.out.println();
        assertEquals(d3Start.get(new int[]{0, 0, 0}), 1.0);
        assertEquals(d3Start.get(new int[]{0, 1, 0}), 1.0);
        assertEquals(d3Start.get(new int[]{0, 1, 1}), 1.0);
        assertEquals(d3Start.get(new int[]{4, 0, 0}), 2.0);
        assertEquals(d3Start.get(new int[]{4, 1, 0}), 2.0);
        assertEquals(d3Start.get(new int[]{4, 1, 1}), 2.0);
    }

    @Test
    void append_dim1 () {
        double[][][] start = toPrimitive(genArray3d(Double.class, 1.0, new int[]{4, 3, 2}), 0.0);
        double[][][] sec = toPrimitive(genArray3d(Double.class, 2.0, new int[]{4, 1, 2}), 0.0);
        DataDouble3d d3Start = new DataDouble3d(start);
        DataDouble3d d3Sec = new DataDouble3d(sec);
        d3Start.append(d3Sec, 1);

//        System.out.print(d3Start);
//        System.out.println();
        assertEquals(d3Start.get(new int[]{0, 0, 0}), 1.0);
        assertEquals(d3Start.get(new int[]{1, 0, 0}), 1.0);
        assertEquals(d3Start.get(new int[]{1, 0, 1}), 1.0);
        assertEquals(d3Start.get(new int[]{0, 3, 0}), 2.0);
        assertEquals(d3Start.get(new int[]{1, 3, 0}), 2.0);
        assertEquals(d3Start.get(new int[]{1, 3, 1}), 2.0);
    }

    @Test
    void append_dim2 () {
        double[][][] start = toPrimitive(genArray3d(Double.class, 1.0, new int[]{4, 3, 2}), 0.0);
        double[][][] sec = toPrimitive(genArray3d(Double.class, 2.0, new int[]{4, 3, 1}), 0.0);
        DataDouble3d d3Start = new DataDouble3d(start);
        DataDouble3d d3Sec = new DataDouble3d(sec);
        d3Start.append(d3Sec, 2);

//        System.out.print(d3Start);
//        System.out.println();
        assertEquals(d3Start.get(new int[]{0, 0, 0}), 1.0);
        assertEquals(d3Start.get(new int[]{1, 0, 0}), 1.0);
        assertEquals(d3Start.get(new int[]{1, 1, 0}), 1.0);
        assertEquals(d3Start.get(new int[]{0, 0, 2}), 2.0);
        assertEquals(d3Start.get(new int[]{1, 0, 2}), 2.0);
        assertEquals(d3Start.get(new int[]{1, 1, 2}), 2.0);
    }

    @Test
    void append_2dArray () {
        double[][][] start = toPrimitive(genArray3d(Double.class, 1.0, new int[]{4, 3, 2}), 0.0);
        DataDouble3d d3Start = new DataDouble3d(start);
        double[][] d2 = toPrimitive(genArray2d(Double.class, 2.0, new int[]{4, 3}), 0.0);
        d3Start.append(new DataDouble2d(d2));

//        System.out.print(d3Start);
//        System.out.println();

        assertEquals(d3Start.get(new int[]{0, 0, 0}), 1.0);
        assertEquals(d3Start.get(new int[]{1, 0, 0}), 1.0);
        assertEquals(d3Start.get(new int[]{1, 1, 0}), 1.0);
        assertEquals(d3Start.get(new int[]{0, 0, 2}), 2.0);
        assertEquals(d3Start.get(new int[]{1, 0, 2}), 2.0);
        assertEquals(d3Start.get(new int[]{1, 1, 2}), 2.0);
    }
}