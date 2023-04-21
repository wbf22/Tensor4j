package com.freedommuskrats.tensor4j;

import com.freedommuskrats.tensor4j.data.DfData;
import com.freedommuskrats.tensor4j.exception.DataException;
import com.freedommuskrats.tensor4j.util.Range;

import java.util.Arrays;
import java.util.Random;

import static com.freedommuskrats.tensor4j.util.GeneralUtil.getNeededSpacing;
import static com.freedommuskrats.tensor4j.util.GeneralUtil.roundPrint;
import static com.freedommuskrats.tensor4j.util.Range.range;

/**
 * <pre>
 *
 * Wrapping of double arrays that provides an convenient
 * object for multidimensional math. Compare with numpy
 * in python.
 *
 *
 * <b>Format</b>
 * For these tensors we think of the first two dimensions
 * as the x and y, or width and height. The provided toString
 * method is handy for visualizing the arrays, and can be
 * used to the view the object in editors with debuggers like
 * intellij. It shows the first two dimensions as width progressing
 * right, and height progressing downwards. The other dims are
 * shown with a sort of list like format.
 *
 *
 * <b>Efficiency</b>
 * Uses a more efficient method for matrix multiplication
 * taking advantage of the systems' cache. Certain algorithms
 * exist that are more efficient for square matrices, however
 * this implementation does not include them.
 *
 *
 * <b>Usage</b>
 *
 * Here's a list of provided methods:
 * - get
 * - set
 * - shape
 * - slice
 * - append
 * - multiply
 * - matmul
 * - dot
 * - reshape
 * - squeeze
 * - unsqueeze
 *
 * See individual methods for details.
 *
 *
 * Translations for common methods from other libraries:
 * - cat, use append
 * - vstack, use append
 * - transpose, use reshape
 *
 *
 * </pre>
 */
public class Tensor1d extends DfData {
    private double[] data;
    private int dims;


    
    /**
     * Create a new Tensor1d object with the given size and filler.
     * @param dim1 The x size or width of the array.
     * @param filler The value to fill the array with.
     */
    public Tensor1d(int dim1, double filler) {
        dims = 1;
        this.data = new double[dim1];
            Arrays.fill(data, filler);
    }

    /**
     * Create a new random Tensor1d object with the given size.
     * @param dim1 The x size or width of the array.
     */
    public Tensor1d(int dim1) {
        dims = 1;
        Random r = new Random(System.nanoTime());
        this.data = new double[dim1];
        for (int x1 = 0; x1 < dim1; x1++) {
            data[x1] = r.nextDouble();
        }
    }

    /**
     * Creates an array of zeros of the given dimensions. Use constructors for a random array.
     * @return
     */
    public static Tensor1d zeros(int dim1) {
        return new Tensor1d(dim1, 0);
    }

    /**
     * Creates an array of ones of the given dimensions. Use constructors for a random array.
     * @return
     */
    public static Tensor1d ones(int dim1) {
        return new Tensor1d(dim1, 1);
    }



    /**
     * You probably shouldn't use this.
     * Create a new Tensor object with the given data.
     * @param data The data to use.
     */
    public Tensor1d(double[] data) {
        this.data = data;
        this.dims = 1;
    }


    /**
     * Returns the array this object provides an abstraction for.
     * You probably shouldn't use this
     * @return
     */
    public double[] getData() {
        return data;
    }

    

    /**
     * Returns the value at the given index. Use slice for more control
     * @return
     */
    public double get(int x1) {
        return (data[x1]);
    }

    

    /**
     * Sets the value at the given index. Use append for more control or for along different dims
     */
    public void set(int x1, double val) {
        data[x1] = val;
    }



    /**
     * Returns the shape of the array.
     * @return
     */
    @Override
    public int[] shape() {
        return new int[]{data.length};
    }

    

    /**
     * <pre>
     * Returns a slice of the array with the given ranges.
     *
     * Eg array.slice(Range.range(0, 10), Range.range(0, 10), Range.range(0, 10));
     * Eg array.slice(Range.range(0, 10, 2), Range.all(), Range.all());
     * @return
     * </pre>
     */
    public Tensor1d slice(Range x1Range) {
        int[] x1Seq = x1Range.getSequence();

        x1Seq = (x1Seq == null)? range(data.length).getSequence() : x1Seq;

        double[] newData = new double[x1Seq.length];
        for (int x1 = 0; x1 < x1Seq.length; x1++) {
            newData[x1] = data[x1Seq[x1]];
        }

        return new Tensor1d(newData);
    }


    /**
     * <pre>
     * Appends the given array to the dimension of this array. Can be used like
     * cat() and vstack() in other libraries. Make sure the dimensions match for
     * what you're doing.
     *
     * Example in 2d:
     *
     * dim 1:
     *      1, 2, 3     append    7, 8, 9     becomes    1, 2, 3
     *      4, 5, 6                                      4, 5, 6
     *                                                   7, 8, 9
     *
     * dim 0:
     *      1, 2      append    3     becomes    1, 2, 3
     *      4, 5                6                4, 5, 6
     *
     *
     * @param toAppend
     * </pre>
     */
    public void append(Tensor1d toAppend) {

        double[] ap = toAppend.getData();

        double[] newData = new double[data.length + ap.length];
        for (int x = 0; x < newData.length; x++) {
            if (x < data.length) {
                newData[x] = data[x];
            } else {
                newData[x] = ap[x - data.length];
            }
        }
        data = newData;
    }

    /**
     * <pre>
     * Appends the given value to the array
     *
     * @param toAppend
     * </pre>
     */
    public void append(Double toAppend) {

        double[] newData = new double[data.length + 1];
        for (int x = 0; x < newData.length; x++) {
            if (x < data.length) {
                newData[x] = data[x];
            } else {
                newData[x] = toAppend;
            }
        }
        data = newData;
    }

    

    /**
     * Multiplies all values of a tensor by a scalar value.
     * @param tensor
     * @param scalar
     * @return
     */
    public static Tensor1d multiply(Tensor1d tensor, double scalar) {
        double[] data = tensor.getData();
        double[] newData = new double[data.length];

        for (int x1 = 0; x1 < data.length; x1++) {
            newData[x1] = data[x1] * scalar;
        }
        return new Tensor1d(newData);
    }


    

    /**
     * <pre>
     * Performs a dot product on two arrays. Array lengths must match.
     *
     * Eg for 2d arrays: (3,2) * (1,3) = (1,2)
     *  1,2,1  X    3       6
     *              1  =
     *              1
     *
     * @param mul
     * @param toMul
     * @return
     *
     * </pre>
     */
    public static double dot(Tensor1d mul, Tensor1d toMul) {
        checkDims(mul, toMul);
        return dot(mul.getData(), toMul.getData());
    }


    /**
     * <pre>
     * You shouldn't use this method directly. It is called by other
     * matmul methods.
     *
     * This method performs matrix multiplication on two arrays. It uses a
     * tiling approach to reduce the number of cache misses. This greatly
     * improves the speed of matrix multiplications. There are other methods
     * for multiplications of square matrices that we do not currently use,
     * but could be faster for those specific cases.
     *
     * @param mul
     * @param toMul
     * @return
     * </pre>
     */
    public static double dot(double[] mul, double[] toMul) {
        double result = 0;

        for (int x1 = 0; x1 < mul.length; x1++) {
            result += mul[x1] * toMul[x1];
        }

        return result;
    }


    /**
     * <pre>
     * Adds a dimension of size 1 to an array.
     *
     * Eg. (3) unsqueeze(1) = (3,1)
     * @param dim
     * @return
     * </pre>
     */
    public Tensor2d unsqueeze(int dim) {
        double[][] newData;
        if (dim == 0) {
            newData = new double[data.length][1];
        }
        else if (dim == 1) {
            newData = new double[1][data.length];
        }
        else {
            throw new DataException("Dimension must be between 0 and 1");
        }

        for (int x1 = 0; x1 < data.length; x1++) {
            if (dim == 0) {
                newData[x1][0] =  data[x1];
            }
            else if (dim == 1) {
                newData[0][x1] =  data[x1];
            }
        }

        return new Tensor2d(newData);
    }



    /**
     * Returns the max value of the tensor/array. Simple algorithm currently
     * which may be upgraded.
     * @return
     */
    public double max() {
        double max = Double.MIN_VALUE;
        for (int x1 = 0; x1 < data.length; x1++) {
            double val = data[x1];
            if (val > max) {
                max = val;
            }
        }

        return max;
    }


    /**
     * Returns the min value of the tensor/array. Simple algorithm currently
     * which may be upgraded.
     * @return
     */
    public double min() {
        double min = Double.MAX_VALUE;
        for (int x1 = 0; x1 < data.length; x1++) {
            double val = data[1];
            if (val < min) {
                min = val;
            }
        }

        return min;
    }


    /**
     * <pre>
     * Useful toString method. Displayed with first two dimensions (x and y)
     * as width and height respectively. Other dimensions are displayed in a
     * sort of list fashion.
     *
     * Note: the x starts from 0 and goes to the right. They y dimension starts at 0
     * and goes downwards.
     *
     * </pre>
     * @return
     */
    @Override
    public String toString() {

        int spacing = getNeededSpacing(max(), 4);

        StringBuilder sb = new StringBuilder();
        for (int x1 = 0; x1 < data.length; x1++) {
            sb.append("[");
            sb.append(roundPrint(data[x1], 4, spacing));
            if (x1 < data.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

}
