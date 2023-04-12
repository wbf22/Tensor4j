package com.freedommuskrats.brarrays.data;

import com.freedommuskrats.brarrays.data.DataDouble2d;
import com.freedommuskrats.brarrays.data.DataDouble3d;
import org.junit.jupiter.api.Test;

import java.util.Random;

import com.freedommuskrats.brarrays.df;

import static com.freedommuskrats.brarrays.util.ArrayGen.*;
import static com.freedommuskrats.brarrays.util.ArrayGen.genArray4d;
import static com.freedommuskrats.brarrays.util.PrimitiveConversion.toPrimitive;

class dfTest {

    @Test
    void testStuff() {
        double[][][] start = toPrimitive(genArray3d(Double.class, 1.0, new int[]{4, 3, 2}), 0.0);
        double[][][] sec = toPrimitive(genArray3d(Double.class, 2.0, new int[]{1, 3, 2}), 0.0);
        DataDouble3d d3 = new DataDouble3d(start);
        DataDouble3d d3Sec = new DataDouble3d(sec);
        d3.append(d3Sec, 0);


        System.out.println(d3);
        System.out.println("***************");
        System.out.println(d3.get(0));
        System.out.println(d3.get(4));
    }

    @Test
    void casting() {
        double[][][] a1 = toPrimitive(genArray3d(Double.class, new Random(System.nanoTime()), new int[]{4, 3, 2}), 0.0);
        double[][][] a2 = toPrimitive(genArray3d(Double.class, new Random(System.nanoTime()), new int[]{4, 2, 1}), 0.0);
        Object obj = a1;
        double[][][] recovered = (double[][][]) obj;

        System.out.println(recovered);
        System.out.println();
    }

    @Test
    void primitiveSpeedTests() {
        double[] t = new double[50000000];
        for (int i = 0; i < 5000000; i++){
            t[i] = i;
        }


        long time = System.currentTimeMillis();
        double[] arr = new double[50000000];
        for (int i = 0; i < 5000000; i++){
            arr[i] = i;
        }
        for (int i = 0; i < 5000000; i++){
            arr[i] *= 5;
        }

        System.out.println(System.currentTimeMillis() - time);
        time = System.currentTimeMillis();

        Double[] arr2 = new Double[50000000];
        for (int i = 0; i < 5000000; i++){
            arr2[i] = (double) i;
        }
        for (int i = 0; i < 5000000; i++){
            arr2[i] *= 5;
        }

        System.out.println(System.currentTimeMillis() - time);


    }



}
