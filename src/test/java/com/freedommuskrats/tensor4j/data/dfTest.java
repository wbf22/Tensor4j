package com.freedommuskrats.tensor4j.data;

import com.freedommuskrats.tensor4j.Tensor2d;
import com.freedommuskrats.tensor4j.Tensor3d;
import com.freedommuskrats.tensor4j.Tensor4d;
import com.freedommuskrats.tensor4j.junk.old.DataDouble2d;
import com.freedommuskrats.tensor4j.junk.old.DataDouble3d;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static com.freedommuskrats.tensor4j.Tensor3d.matmul;
import static com.freedommuskrats.tensor4j.junk.old.ArrayGen.genArray3d;
import static com.freedommuskrats.tensor4j.junk.old.PrimitiveConversion.toPrimitive;
import static com.freedommuskrats.tensor4j.util.GeneralUtil.println;

class dfTest {

    @Test
    void testStuff() {
        Tensor3d a = new Tensor3d(3, 1, 2, .5);
        Tensor3d b = new Tensor3d(2, 3, 2, 2.0);
        a.set(0,0,0,4.0);

        println(a);
        println(b);

        println(matmul(a,b));



    }

    @Test
    void squeezeUnsqueeze() {
        Tensor3d a = new Tensor3d(3, 2, 1);

        println("****");
        println(a);

        Tensor4d b = a.unsqueeze(3);
        println("****");
        println(b);

        a = new Tensor3d(2, 2, 1);
        println("****");
        println(a);

        Tensor2d c = a.squeeze(2);
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
