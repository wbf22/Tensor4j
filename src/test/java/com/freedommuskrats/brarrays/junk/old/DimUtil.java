package com.freedommuskrats.brarrays.junk.old;

import com.freedommuskrats.brarrays.exception.DataException;

public class DimUtil {



    public static void verifyDimensions(double[] array, int expectedDimensions) {
        if (array.length != expectedDimensions) {
            throw new DataException(
                    String.format("Length of array must be %s, but was %s. "
                            , expectedDimensions, array.length)
            );
        }
    }

    public static void verifyDimensions(double[][] array, int[]expectedDimensions) {
        if (array.length != expectedDimensions[0]) {
            throw new DataException(
                    String.format("First dimension of array must be %s, but was %s. "
                            , expectedDimensions[0], array.length)
            );
        }
        else if (array[0].length != expectedDimensions[1]) {
            throw new DataException(
                    String.format("Second dimension of array must be %s, but was %s. "
                            , expectedDimensions[1], array[0].length)
            );
        }
    }

    public static void verifyDimensions(double[][][] array, int[]expectedDimensions) {
        if (array.length != expectedDimensions[0]) {
            throw new DataException(
                    String.format("First dimension of array must be %s, but was %s", expectedDimensions[0], array.length)
            );
        }
        else if (array[0].length != expectedDimensions[1]) {
            throw new DataException(
                    String.format("Second dimension of array must be %s, but was %s", expectedDimensions[1], array[0].length)
            );
        }
        else if (array[0][0].length != expectedDimensions[2]) {
            throw new DataException(
                    String.format("Third dimension of array must be %s, but was %s", expectedDimensions[2], array[0][0].length)
            );
        }
    }

}
