package com.freedommuskrats.tensor4j;

import com.freedommuskrats.tensor4j.util.Range;
import org.junit.jupiter.api.Test;

import static com.freedommuskrats.tensor4j.junk.old.ArrayGen.genArray2d;
import static com.freedommuskrats.tensor4j.junk.old.ArrayGen.genArray3d;
import static com.freedommuskrats.tensor4j.junk.old.PrimitiveConversion.toPrimitive;
import static com.freedommuskrats.tensor4j.util.Range.range;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tensor3dTest {


    @Test
    void append_dim0 () {
        double[][][] start = toPrimitive(genArray3d(Double.class, 1.0, new int[]{4, 3, 2}), 0.0);
        double[][][] sec = toPrimitive(genArray3d(Double.class, 2.0, new int[]{1, 3, 2}), 0.0);
        Tensor3d d3Start = new Tensor3d(start);
        Tensor3d d3Sec = new Tensor3d(sec);
        d3Start.append(d3Sec, 0);

//        System.out.print(d3Start);
//        System.out.println();
        assertEquals(d3Start.get(0, 0, 0), 1.0);
        assertEquals(d3Start.get(0, 1, 0), 1.0);
        assertEquals(d3Start.get(0, 1, 1), 1.0);
        assertEquals(d3Start.get(4, 0, 0), 2.0);
        assertEquals(d3Start.get(4, 1, 0), 2.0);
        assertEquals(d3Start.get(4, 1, 1), 2.0);
    }

    @Test
    void append_dim1 () {
        double[][][] start = toPrimitive(genArray3d(Double.class, 1.0, new int[]{4, 3, 2}), 0.0);
        double[][][] sec = toPrimitive(genArray3d(Double.class, 2.0, new int[]{4, 1, 2}), 0.0);
        Tensor3d d3Start = new Tensor3d(start);
        Tensor3d d3Sec = new Tensor3d(sec);
        d3Start.append(d3Sec, 1);

//        System.out.print(d3Start);
//        System.out.println();
        assertEquals(d3Start.get(0, 0, 0), 1.0);
        assertEquals(d3Start.get(1, 0, 0), 1.0);
        assertEquals(d3Start.get(1, 0, 1), 1.0);
        assertEquals(d3Start.get(0, 3, 0), 2.0);
        assertEquals(d3Start.get(1, 3, 0), 2.0);
        assertEquals(d3Start.get(1, 3, 1), 2.0);
    }

    @Test
    void append_dim2 () {
        double[][][] start = toPrimitive(genArray3d(Double.class, 1.0, new int[]{4, 3, 2}), 0.0);
        double[][][] sec = toPrimitive(genArray3d(Double.class, 2.0, new int[]{4, 3, 1}), 0.0);
        Tensor3d d3Start = new Tensor3d(start);
        Tensor3d d3Sec = new Tensor3d(sec);
        d3Start.append(d3Sec, 2);

//        System.out.print(d3Start);
//        System.out.println();
        assertEquals(d3Start.get(0, 0, 0), 1.0);
        assertEquals(d3Start.get(1, 0, 0), 1.0);
        assertEquals(d3Start.get(1, 1, 0), 1.0);
        assertEquals(d3Start.get(0, 0, 2), 2.0);
        assertEquals(d3Start.get(1, 0, 2), 2.0);
        assertEquals(d3Start.get(1, 1, 2), 2.0);
    }

    @Test
    void append_2dArray () {
        double[][][] start = toPrimitive(genArray3d(Double.class, 1.0, new int[]{4, 3, 2}), 0.0);
        Tensor3d d3Start = new Tensor3d(start);
        double[][] d2 = toPrimitive(genArray2d(Double.class, 2.0, new int[]{4, 3}), 0.0);
        d3Start.append(new Tensor2d(d2));

//        System.out.print(d3Start);
//        System.out.println();

        assertEquals(d3Start.get(0, 0, 0), 1.0);
        assertEquals(d3Start.get(1, 0, 0), 1.0);
        assertEquals(d3Start.get(1, 1, 0), 1.0);
        assertEquals(d3Start.get(0, 0, 2), 2.0);
        assertEquals(d3Start.get(1, 0, 2), 2.0);
        assertEquals(d3Start.get(1, 1, 2), 2.0);
    }

    @Test
    void matmul_diff_sizes() {
        double[][][] start = toPrimitive(genArray3d(Double.class, 1.0, new int[]{3, 1, 2}), 0.0);
        double[][][] sec = toPrimitive(genArray3d(Double.class, 2.0, new int[]{2, 3, 2}), 0.0);

        start[1][0][1] = 3.0;
        start[0][0][2] = 4.0;

        sec[0][0][1] = 5.0;
        sec[1][2][1] = 10.0;

        Tensor3d d3Start = new Tensor3d(start);
        Tensor3d d3Sec = new Tensor3d(sec);
        Tensor3d res = Tensor3d.matmul(d3Start, d3Sec);

        assertEquals(res.get(0, 0, 0), 12.0);
        assertEquals(res.get(1, 0, 0), 15.0);
        assertEquals(res.get(0, 0, 1), 10.0);
        assertEquals(res.get(1, 0, 1), 18.0);
    }

    @Test
    void matmul_diff_sizes2() {
        double[][][] start = toPrimitive(genArray3d(Double.class, 1.0, new int[]{3, 4, 3}), 0.0);
        double[][][] sec = toPrimitive(genArray3d(Double.class, 2.0, new int[]{2, 3, 3}), 0.0);

        start[1][0][1] = 3.0;
        start[0][0][2] = 4.0;

        sec[0][0][1] = 5.0;
        sec[1][2][1] = 10.0;

        Tensor3d d3Start = new Tensor3d(start);
        Tensor3d d3Sec = new Tensor3d(sec);
        Tensor3d res = Tensor3d.matmul(d3Start, d3Sec);

        assertEquals(res.get(0, 0, 0), 12.0);
        assertEquals(res.get(1, 0, 0), 15.0);
        assertEquals(res.get(0, 0, 1), 10.0);
        assertEquals(res.get(1, 0, 1), 18.0);
        assertEquals(res.get(1, 1, 1), 14.0);
        assertEquals(res.get(0, 2, 2), 6.0);
    }

    @Test
    void slice() {
        Tensor3d ten = new Tensor3d(3,2,1);
        ten = ten.slice(range(2), Range.all(), Range.all());
        int[] shape = ten.shape();
        assertEquals(2, shape[0]);
        assertEquals(2, shape[1]);
        assertEquals(1, shape[2]);

        ten = new Tensor3d(3,2,1);
        ten = ten.slice(range(2), range(1), Range.all());
        shape = ten.shape();
        assertEquals(2, shape[0]);
        assertEquals(1, shape[1]);
        assertEquals(1, shape[2]);
    }

    @Test
    void multiply() {
        Tensor3d ten = new Tensor3d(3,2,4, 3.0);
        ten = Tensor3d.multiply(ten, 2.0);

        double sum = 0;
        int[] shape = ten.shape();
        for(int x1 = 0; x1 < shape[0]; x1++) {
            for(int x2 = 0; x2 < shape[1]; x2++) {
                for(int x3 = 0; x3 < shape[2]; x3++) {
                    assertEquals(6.0, ten.get(x1, x2, x3));
                    sum += ten.get(x1, x2, x3);
                }
            }
        }

        assertEquals(144.0, sum);

    }

    @Test
    void reshape() {
        Tensor3d ten = new Tensor3d(1,2,3);
        double val = ten.get(0, 1, 0);
        ten.reshape(3,2,1);
        assertEquals(ten.get(0, 1, 0), val);
        int[] shape = ten.shape();
        assertEquals(3, shape[0]);
        assertEquals(2, shape[1]);
        assertEquals(1, shape[2]);


        val = ten.get(0, 1, 0);
        ten.reshape(1,3,2);
        assertEquals(ten.get(0, 0, 1), val);
        shape = ten.shape();
        assertEquals(1, shape[0]);
        assertEquals(3, shape[1]);
        assertEquals(2, shape[2]);

        val = ten.get(0, 2, 0);
        ten.reshape(2,1,3);
        assertEquals(ten.get(0, 0, 2), val);
        shape = ten.shape();
        assertEquals(2, shape[0]);
        assertEquals(1, shape[1]);
        assertEquals(3, shape[2]);

        val = ten.get(1, 0, 0);
        ten.reshape(2,3,1);
        assertEquals(ten.get(1, 0, 0), val);
        shape = ten.shape();
        assertEquals(2, shape[0]);
        assertEquals(3, shape[1]);
        assertEquals(1, shape[2]);

        val = ten.get(0, 0, 0);
        ten.reshape(3,1,2);
        assertEquals(ten.get(0, 0, 0), val);
        shape = ten.shape();
        assertEquals(3, shape[0]);
        assertEquals(1, shape[1]);
        assertEquals(2, shape[2]);

        val = ten.get(2, 0, 1);
        ten.reshape(3,2,1);
        assertEquals(ten.get(2, 1, 0), val);
        shape = ten.shape();
        assertEquals(3, shape[0]);
        assertEquals(2, shape[1]);
        assertEquals(1, shape[2]);
    }

    @Test
    void squeezeUnsqueeze() {
        Tensor3d ten = new Tensor3d(1,2,3);
        Tensor2d ten2 = ten.squeeze(0);
        int[] shape = ten2.shape();
        assertEquals(2, shape[0]);
        assertEquals(3, shape[1]);

        ten = ten2.unsqueeze(0);
        shape = ten.shape();
        assertEquals(1, shape[0]);
        assertEquals(2, shape[1]);
        assertEquals(3, shape[2]);

        Tensor4d ten4 = ten.unsqueeze(3);
        shape = ten4.shape();
        assertEquals(1, shape[0]);
        assertEquals(2, shape[1]);
        assertEquals(3, shape[2]);
        assertEquals(1, shape[3]);

        ten = ten4.squeeze(0);
        shape = ten.shape();
        assertEquals(2, shape[0]);
        assertEquals(3, shape[1]);
        assertEquals(1, shape[2]);

        ten2 = ten.squeeze(2);
        shape = ten.shape();
        assertEquals(2, shape[0]);
        assertEquals(3, shape[1]);

        ten = ten2.unsqueeze(1);
        shape = ten.shape();
        assertEquals(2, shape[0]);
        assertEquals(1, shape[1]);
        assertEquals(3, shape[2]);

        ten4 = ten.unsqueeze(2);
        shape = ten4.shape();
        assertEquals(2, shape[0]);
        assertEquals(1, shape[1]);
        assertEquals(1, shape[2]);
        assertEquals(3, shape[3]);
    }
}
