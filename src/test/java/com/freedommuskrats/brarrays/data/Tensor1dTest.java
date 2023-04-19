package com.freedommuskrats.brarrays.data;

import org.junit.jupiter.api.Test;

import static com.freedommuskrats.brarrays.junk.old.ArrayGen.genArray1d;
import static com.freedommuskrats.brarrays.junk.old.PrimitiveConversion.toPrimitive;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Tensor1dTest {

    @Test
    void append () {
        double[] start = toPrimitive(genArray1d(Double.class, 1.0, new int[]{4}), 0.0);
        Tensor1d myArr = new Tensor1d(start);
        double[] d2 = toPrimitive(genArray1d(Double.class, 2.0, new int[]{1}), 0.0);
        myArr.append(new Tensor1d(d2));

//        System.out.print(d3Start);
//        System.out.println();

        assertEquals(myArr.get(0), 1.0);
        assertEquals(myArr.get(1), 1.0);
        assertEquals(myArr.get(1), 1.0);
        assertEquals(myArr.get(4), 2.0);
    }

    @Test
    void append_double () {
        double[] start = toPrimitive(genArray1d(Double.class, 1.0, new int[]{4}), 0.0);
        Tensor1d myArr = new Tensor1d(start);
        myArr.append(4.9);

//        System.out.print(d3Start);
//        System.out.println();

        assertEquals(myArr.get(0), 1.0);
        assertEquals(myArr.get(1), 1.0);
        assertEquals(myArr.get(1), 1.0);
        assertEquals(myArr.get(4), 4.9);
    }
}
