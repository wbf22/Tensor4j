package com.freedommuskrats.brarrays.data;

import com.freedommuskrats.brarrays.junk.old.DataDouble2d;
import com.freedommuskrats.brarrays.junk.old.DataDouble3d;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static com.freedommuskrats.brarrays.junk.old.ArrayGen.genArray3d;
import static com.freedommuskrats.brarrays.junk.old.PrimitiveConversion.toPrimitive;
import static com.freedommuskrats.brarrays.util.GeneralUtil.println;

class dfTest {

    @Test
    void testStuff() {
        DataDouble3d a = new DataDouble3d(2, 2, 2);

        println("****");
        println(a);

        Tensor4d b = a.unsqueeze(3);
        println("****");
        println(b);

        a = new DataDouble3d(2, 2, 1);
        println("****");
        println(a);

        DataDouble2d c = a.squeeze(2);
        println("****");
        println(c);

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
