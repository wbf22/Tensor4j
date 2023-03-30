package com.freedommuskrats.brarrays.data;

import org.junit.jupiter.api.Test;

import static com.freedommuskrats.brarrays.data.DataDouble2d.*;
import static com.freedommuskrats.brarrays.util.ArrayGen.genArray1d;
import static com.freedommuskrats.brarrays.util.ArrayGen.genArray2d;
import static com.freedommuskrats.brarrays.util.PrimitiveConversion.toPrimitive;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataDouble2dTest {

    @Test
    void append_dim0 () {
        double[][] start = toPrimitive(genArray2d(Double.class, 1.0, new int[]{4, 3}), 0.0);
        DataDouble2d myArr = new DataDouble2d(start);
        double[][] d2 = toPrimitive(genArray2d(Double.class, 2.0, new int[]{1, 3}), 0.0);
        myArr.append(new DataDouble2d(d2), 0);

//        System.out.print(d3Start);
//        System.out.println();

        assertEquals(myArr.get(new int[]{0, 0}), 1.0);
        assertEquals(myArr.get(new int[]{1, 0}), 1.0);
        assertEquals(myArr.get(new int[]{1, 1}), 1.0);
        assertEquals(myArr.get(new int[]{4, 0}), 2.0);
        assertEquals(myArr.get(new int[]{4, 2}), 2.0);
    }

    @Test
    void append_dim1 () {
        double[][] start = toPrimitive(genArray2d(Double.class, 1.0, new int[]{4, 3}), 0.0);
        DataDouble2d myArr = new DataDouble2d(start);
        double[][] d2 = toPrimitive(genArray2d(Double.class, 2.0, new int[]{4, 1}), 0.0);
        myArr.append(new DataDouble2d(d2), 1);

//        System.out.print(d3Start);
//        System.out.println();

        assertEquals(myArr.get(new int[]{0, 0}), 1.0);
        assertEquals(myArr.get(new int[]{1, 0}), 1.0);
        assertEquals(myArr.get(new int[]{1, 1}), 1.0);
        assertEquals(myArr.get(new int[]{0, 3}), 2.0);
        assertEquals(myArr.get(new int[]{1, 3}), 2.0);
    }

    @Test
    void append_1dArray() {
        double[][] start = toPrimitive(genArray2d(Double.class, 1.0, new int[]{4, 3}), 0.0);
        DataDouble2d myArr = new DataDouble2d(start);
        double[] d1 = toPrimitive(genArray1d(Double.class, 2.0, new int[]{4}), 0.0);
        myArr.append(new DataDouble1d(d1));

//        System.out.print(d3Start);
//        System.out.println();

        assertEquals(myArr.get(new int[]{0, 0}), 1.0);
        assertEquals(myArr.get(new int[]{1, 1}), 1.0);
        assertEquals(myArr.get(new int[]{1, 2}), 1.0);
        assertEquals(myArr.get(new int[]{0, 3}), 2.0);
        assertEquals(myArr.get(new int[]{2, 3}), 2.0);
    }

    @Test
    void matmul_test_diff_dims() {
        double[][] start = toPrimitive(genArray2d(Double.class, 1.0, new int[]{3, 2}), 0.0);
        double[][] d2 = toPrimitive(genArray2d(Double.class, 2.0, new int[]{2, 3}), 0.0);

//        1,2,1  X    3,2       6,  5
//        3,2,1       1,1  =    12, 9
//                    1,1

        start[0][0] = 1;
        start[1][0] = 2;
        start[2][0] = 1;
        start[0][1] = 3;
        start[1][1] = 2;
        start[2][1] = 1;

        d2[0][0] = 3;
        d2[1][0] = 2;
        d2[0][1] = 1;
        d2[1][1] = 1;
        d2[0][2] = 1;
        d2[1][2] = 1;

        DataDouble2d res = matmul(new DataDouble2d(start), new DataDouble2d(d2));
        System.out.println(res);
    }

    @Test
    void matmul_test() {
        double[][] start = toPrimitive(genArray2d(Double.class, 1.0, new int[]{4, 4}), 0.0);
        double[][] d2 = toPrimitive(genArray2d(Double.class, 2.0, new int[]{4, 4}), 0.0);
//        1,1,1,2  X  2,3,1,1     7, 8, 7, 5
//        2,1,2,1     1,1,1,1     10,12,7, 6
//        3,1,1,1     2,2,1,1  =  10,13,7, 6
//        1,2,1,1     1,1,2,1     7, 8, 6, 5

        start[0][0] = 1;
        start[1][0] = 1;
        start[2][0] = 1;
        start[3][0] = 2;
        start[0][1] = 2;
        start[1][1] = 1;
        start[2][1] = 2;
        start[3][1] = 1;
        start[0][2] = 3;
        start[1][2] = 1;
        start[2][2] = 1;
        start[3][2] = 1;
        start[0][3] = 1;
        start[1][3] = 2;
        start[2][3] = 1;
        start[3][3] = 1;

        d2[0][0] = 2;
        d2[1][0] = 3;
        d2[2][0] = 1;
        d2[3][0] = 1;
        d2[0][1] = 1;
        d2[1][1] = 1;
        d2[2][1] = 1;
        d2[3][1] = 1;
        d2[0][2] = 2;
        d2[1][2] = 2;
        d2[2][2] = 1;
        d2[3][2] = 1;
        d2[0][3] = 1;
        d2[1][3] = 1;
        d2[2][3] = 2;
        d2[3][3] = 1;

        DataDouble2d res = matmul(new DataDouble2d(start), new DataDouble2d(d2));
        System.out.println(res);
    }

    @Test
    void matmul_speed_test() {


        long time;
        DataDouble2d res;

        for (int s = 128; s <= 1024; s *= 2) {
            for (int i = 2; i <= 1024 && i <= s; i *= 2) {
                double[][] start = toPrimitive(genArray2d(Double.class, 1.0, new int[]{s, s}), 0.0);
                double[][] d2 = toPrimitive(genArray2d(Double.class, 2.0, new int[]{s, s}), 0.0);

                System.out.println("Cache op : ");
                System.out.println("-size: " + s);
                System.out.println("-tile: " + i);
                time = System.currentTimeMillis();
                res = matmulWithCacheop(new DataDouble2d(start), new DataDouble2d(d2), i);
                System.out.println("-" + (System.currentTimeMillis() - time) + " ms");

                System.out.println();
            }
        }





    }
}
