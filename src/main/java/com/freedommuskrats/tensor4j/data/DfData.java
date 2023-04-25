package com.freedommuskrats.tensor4j.data;

import com.freedommuskrats.tensor4j.exception.DataException;

/**
 * This is a work in progress
 */
public abstract class DfData {

    public static int PRECISION = 1;

    public abstract int[] shape();


    //https://www.iaeng.org/publication/WCE2010/WCE2010_pp1829-1833.pdf
    //https://stackoverflow.com/questions/64856174/an-efficient-way-to-multiply-two-object-matrixes
    //https://en.wikipedia.org/wiki/Matrix_multiplication_algorithm
    public static void checkDims(DfData toMul, DfData mul) {
        int[] thisShape = toMul.shape();
        int[] mulShape = mul.shape();

        if (mulShape.length == 1) {
            if (thisShape.length != mulShape.length) {
                throw new DataException("Can't dot a tensor of length " + mulShape.length + " by a tensor of " + thisShape.length
                        + ". They must have the same length");
            }
            return;
        }

        if (thisShape.length > mulShape.length) {
            throw new DataException("Can't multiply a " + mulShape.length + "d matrix by a " + thisShape.length + "d matrix."
                    + " They must have the same dimensionality or the second must have more dimensions than the first");
        }

        for (int i = 2; i < thisShape.length; i++) {
            if (thisShape[i] != mulShape[i]) {
                throw new DataException("Dim " + i + " in the first matrix should match dim " + i + " in the second matrix, but were "
                        + thisShape[i] + " and " + mulShape[i] + " respectively. "
                        + "Only the first two dims can differ, and dim 0 of the first and dim 1 of the second must match"
                        + " Eg: 2x1x2x2... * 3x2x2x2... = 3x1x2x2...");
            }
        }

        if (thisShape[0] != mulShape[1]) {
            throw new DataException("Dim " + 0 + " in the first matrix should match dim " + 1 + " in the second matrix, but were "
                    + thisShape[0] + " and " + mulShape[1] + " respectively. "
                    + "Only the first two dims can differ, and dim 0 of the first and dim 1 of the second must match"
                    + " Eg: 2x3x2x2... * 3x2x2x2... = 3x2x2x2...");
        }
    }

}
