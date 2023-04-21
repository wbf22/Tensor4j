package com.freedommuskrats.tensor4j;

import com.freedommuskrats.tensor4j.util.Range;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static com.freedommuskrats.tensor4j.Tensor1d.dot;
import static com.freedommuskrats.tensor4j.Tensor2d.multiply;
import static com.freedommuskrats.tensor4j.Tensor3d.matmul;
import static com.freedommuskrats.tensor4j.junk.old.ArrayGen.genArray3d;
import static com.freedommuskrats.tensor4j.junk.old.PrimitiveConversion.toPrimitive;
import static com.freedommuskrats.tensor4j.util.GeneralUtil.println;

class dfTest {

    @Test
    void testStuff() {
        Tensor2d a = new Tensor2d(2, 2, 0);
        Tensor2d b = new Tensor2d(2, 2, 1);
        Tensor2d c = new Tensor2d(2, 2, 3);
        Tensor2d d = new Tensor2d(2, 2, 4);

        Tensor3d e = a.unsqueeze(2);
        e.append(b);
        e.append(c);
        e.append(d);

        Tensor3d f = e.slice(Range.all(), Range.all(), Range.range(1, 4, 2));

        println(a);
        println(b);
        println(c);
        println(d);
        println(e);
        println(f);
    }

    @Test
    void squeezeUnsqueeze() {
        Tensor4d a = new Tensor4d(2, 3, 2, 2, 3);
        Tensor4d b = new Tensor4d(1, 2, 2, 2, 2);
        a.set(1,2,1,1,.2);

        println(a.toString());
        println(b.toString());
        println(Tensor4d.matmul(a, b).toString());

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
