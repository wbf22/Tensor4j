package com.freedommuskrats.brarrays.data;

import com.freedommuskrats.brarrays.data.DataDouble2d;
import com.freedommuskrats.brarrays.data.DataDouble3d;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static com.freedommuskrats.brarrays.util.ArrayGen.genArray2d;
import com.freedommuskrats.brarrays.df;
import static com.freedommuskrats.brarrays.util.ArrayGen.genArray3d;
import static com.freedommuskrats.brarrays.util.PrimitiveConversion.toPrimitive;

class dfTest {

    @Test
    void testStuff() {
        double[][][] a1 = toPrimitive(genArray3d(Double.class, new Random(System.nanoTime()), new int[]{4, 3, 2}), 0.0);
        double[][][] a2 = toPrimitive(genArray3d(Double.class, new Random(System.nanoTime()), new int[]{4, 2, 1}), 0.0);

        DataDouble3d arr1 = new DataDouble3d(a1);
        DataDouble3d arr2 = new DataDouble3d(a2);

        System.out.println(arr1);
        System.out.println(arr2);
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