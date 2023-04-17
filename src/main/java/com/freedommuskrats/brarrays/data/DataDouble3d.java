package com.freedommuskrats.brarrays.data;

import com.freedommuskrats.brarrays.exception.DataException;

import java.util.Random;
import java.util.Arrays;

import static com.freedommuskrats.brarrays.data.DataDouble2d.MUL_TILE_SIZE;
import static com.freedommuskrats.brarrays.data.Range.range;
import static com.freedommuskrats.brarrays.util.GeneralUtil.roundPrint;
import static com.freedommuskrats.brarrays.util.GeneralUtil.newLine;

public class DataDouble3d extends DfData {
    private double[][][] data;
    private int dims;


    
    /**
     * Create a new DataDouble3d object with the given size and filler.
     * @param dim1 The x size or width of the array.
     * @param dim2 The y size or height of the array.
     * @param dim3 The z size or depth of the array.
     * @param filler The value to fill the array with.
     */
    public DataDouble3d(int dim1, int dim2, int dim3, double filler) {
        this.data = new double[dim3][dim2][dim1];
        for (int x3 = 0; x3 < dim1; x3++) {
            for (int x2 = 0; x2 < dim1; x2++) {
                    Arrays.fill(data[x3][x2], filler);
            }
        }
    }

    /**
     * Create a new random DataDouble3d object with the given size.
     * @param dim1 The x size or width of the array.
     * @param dim2 The y size or height of the array.
     * @param dim3 The z size or depth of the array.

     */
    public DataDouble3d(int dim1, int dim2, int dim3) {
        dims = 3;
        Random r = new Random(System.nanoTime());
        this.data = new double[dim3][dim2][dim1];
        for (int x3 = 0; x3 < dim3; x3++) {
            for (int x2 = 0; x2 < dim2; x2++) {
                for (int x1 = 0; x1 < dim1; x1++) {
                    data[x3][x2][x1] = r.nextDouble();
                }
            }
        }
    }

    /**
     * Creates an array of zeros of the given dimensions. Use constructors for a random array.
     * @return
     */
    public static DataDouble3d zeros(int dim1, int dim2, int dim3) {
        return new DataDouble3d(dim1, dim2, dim3, 0);
    }

    /**
     * Creates an array of ones of the given dimensions. Use constructors for a random array.
     * @return
     */
    public static DataDouble3d ones(int dim1, int dim2, int dim3) {
        return new DataDouble3d(dim1, dim2, dim3, 1);
    }


    /**
     * Create a new DataDouble3d object with the given data.
     * @param data The data to use.
     */
    public DataDouble3d(double[][][] data) {
        this.data = data;
        this.dims = 3;
    }

    /**
     * Returns the array this object provides an abstraction for.
     * @return
     */
    public double[][][] getData() {
        return data;
    }

    /**
     * Returns the value at the given index. Use slice for more control
     * @return
     */
    public double get(int x1, int x2, int x3) {
        return (data[x3][x2][x1]);
    }

    /**
     * Returns the value at the given index. Use slice for more control
     * @return
     */
    public DataDouble1d get(int x2, int x3) {
        return new DataDouble1d(data[x3][x2]);
    }

    /**
     * Returns the value at the given index. Use slice for more control
     * @return
     */
    public DataDouble2d get(int x3) {
        return new DataDouble2d(data[x3]);
    }

    /**
     * Sets the value at the given index. Use append for more control
     * @return
     */
    public void set(int x1, int x2, int x3, double val) {
        data[x3][x2][x1] = val;
    }

    public void set(int x1, int x2, DataDouble1d val) {
        data[x2][x1] = val.getData();
    }

    public void set(int x1, DataDouble2d val) {
        data[x1] = val.getData();
    }


    /**
     * Returns the shape of the array.
     * @return
     */
    @Override
    public int[] shape() {
        return new int[]{data[0][0].length, data[0].length, data.length};
    }

    /**
     * Returns a slice of the array with the given ranges.
     *
     * Eg array.slice(Range.range(0, 10), Range.range(0, 10), Range.range(0, 10));
     * Eg array.slice(Range.range(0, 10, 2), Range.all(), Range.all());
     * @return
     */
    public DataDouble3d slice(Range x1Range, Range x2Range, Range x3Range) {
        int[] x1Seq = x1Range.getSequence();
        int[] x2Seq = x2Range.getSequence();
        int[] x3Seq = x3Range.getSequence();

        x1Seq = (x1Seq == null)? range(data[0][0].length).getSequence() : x1Seq;
        x2Seq = (x2Seq == null)? range(data[0].length).getSequence() : x2Seq;
        x3Seq = (x3Seq == null)? range(data.length).getSequence() : x3Seq;

        double[][][] newData = new double[x3Seq.length][x2Seq.length][x1Seq.length];
        for (int x3 = 0; x3 < x3Seq.length; x3++) {
            for (int x2 = 0; x2 < x2Seq.length; x2++) {
                for (int x1 = 0; x1 < x1Seq.length; x1++) {
                    newData[x3][x2][x1] = data[x3Seq[x3]][x2Seq[x2]][x1Seq[x1]];
                }
            }
        }

        return new DataDouble3d(newData);
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
     * @param dim
     * </pre>
     */
    public void append(DataDouble3d toAppend, int dim) {
        if (dim < 0 || dim > dims) {
            throw new DataException(
                    String.format("Can't append on dim %s for df array of size %s. " +
                            "'int dim' must be greater than zero and less than the dimension of the array", dim, dims)
            );
        }

        double[][][] ap = toAppend.getData();

        
        if (dim == 0) {
            verifyDimensions(ap, new int[]{data.length, data[0].length, ap[0][0].length});
            double[][][] newData = new double[data.length][data[0].length][data[0][0].length + ap[0][0].length];
            for (int x3 = 0; x3 < data.length; x3++) {
                for (int x2 = 0; x2 < data[0].length; x2++) {
                    for (int x1 = 0; x1 < newData[0][0].length; x1++) {
                        if (x1 < data[0][0].length) {
                            newData[x3][x2][x1] = data[x3][x2][x1];
                        } else {
                            newData[x3][x2][x1] = ap[x3][x2][x1 - data[0][0].length];
                        }
                    }
                }
            }
            data = newData;
        }
        if (dim == 1) {
            verifyDimensions(ap, new int[]{data.length, ap[0].length, data[0][0].length});
            double[][][] newData = new double[data.length][data[0].length + ap[0].length][data[0][0].length];
            for (int x3 = 0; x3 < data.length; x3++) {
                for (int x2 = 0; x2 < newData[0].length; x2++) {
                    for (int x1 = 0; x1 < data[0][0].length; x1++) {
                        if (x2 < data[0].length) {
                            newData[x3][x2][x1] = data[x3][x2][x1];
                        } else {
                            newData[x3][x2][x1] = ap[x3][x2 - data[0].length][x1];
                        }
                    }
                }
            }
            data = newData;
        }
        if (dim == 2) {
            verifyDimensions(ap, new int[]{ap.length, data[0].length, data[0][0].length});
            double[][][] newData = new double[data.length + ap.length][data[0].length][data[0][0].length];
            for (int x3 = 0; x3 < newData.length; x3++) {
                for (int x2 = 0; x2 < data[0].length; x2++) {
                    for (int x1 = 0; x1 < data[0][0].length; x1++) {
                        if (x3 < data.length) {
                            newData[x3][x2][x1] = data[x3][x2][x1];
                        } else {
                            newData[x3][x2][x1] = ap[x3 - data.length][x2][x1];
                        }
                    }
                }
            }
            data = newData;
        }


    }

    /**
     * <pre>
     * Appends the given array to the dimension of this array. Can be used like
     * cat() and vstack() in other libraries. This method appends arrays of one
     * dimension less than the array it is called on. It can
     * only append on the last dimension.
     *
     * Example in 3d:
     *
     *
     * dim 1:
     *      1, 2      append   10,11     becomes    1, 2
     *      4, 5               12,13                4, 5
     *
     *      6, 7                                    6, 7
     *      8, 9                                    8, 9
     *
     *                                              10,11
     *                                              12,13
     *
     * @param toAppend
     * </pre>
     */
    public void append(DataDouble2d toAppend) {

        double[][] ap = toAppend.getData();

        
        verifyDimensions(ap, new int[]{data[0].length, data[0][0].length});
        double[][][] newData = new double[data.length + 1][data[0].length][data[0][0].length];
        for (int x3 = 0; x3 < newData.length; x3++) {
            for (int x2 = 0; x2 < data[0].length; x2++) {
                for (int x1 = 0; x1 < data[0][0].length; x1++) {
                    if (x3 < data.length) {
                        newData[x3][x2][x1] = data[x3][x2][x1];
                    } else {
                        newData[x3][x2][x1] = ap[x3][x2];
                    }
                }
            }
        }
        data = newData;


    }

    /**
     * Multiplies all values of an array by a scalar value.
     * @param array
     * @param scaler
     * @return
     */
    public static DataDouble3d multiply(DataDouble3d array, double scaler) {
        double[][][] data = array.getData();

        for (int x3 = 0; x3 < data.length; x3++) {
            for (int x2 = 0; x2 < data[0].length; x2++) {
                for (int x1 = 0; x1 < data[0][0].length; x1++) {
                    data[x3][x2][x1] *= scaler;
                }
            }
        }
        return new DataDouble3d(data);
    }


    /**
     * <pre>
     * Performs a matrix multiplication on two arrays. Array dimensions must
     * all match except the first two dimensions. For these dim 0 of the first
     * array must match dim 1 of the second array. Dim 1 of the first array
     * and dim 0 of the second array don't have to match
     *
     * Eg for 2d arrays: (3,2) * (1,3) = (1,2)
     *  1,2,1  X    3       6
     *  3,2,1       1  =    12
     *              1
     *
     * Eg for 3d arrays: (2,2,2) * (3,2,2) = (3,2,2)
     *  1,1    X     1,4,1     2, 6, 2
     *  1,3          1,2,1  =  4,10, 4
     *
     *  1,3          1,1,5     4, 4, 8
     *  1,1          1,1,1     2, 2, 6
     *
     * @param mul
     * @param toMul
     * @return
     *
     * </pre>
     */
    public static DataDouble3d matmul(DataDouble3d mul, DataDouble3d toMul) {
        checkDims(mul, toMul);
        return new DataDouble3d(matmul(mul.getData(), toMul.getData()));
    }

    /**
     * <pre>
     * This method performs matrix multiplication on two arrays. It uses a
     * tiling approach to reduce the number of cache misses. This greatly
     * improves the speed of matrix multiplications. There are other methods
     * for multiplications of square matrices that we do not currently use
     * could be faster for those specific cases.
     *
     * You shouldn't use this method directly. It is called by other
     * matmul methods.
     *
     * @param mul
     * @param toMul
     * @return
     * </pre>
     */
    public static double[][][] matmul(double[][][] mul, double[][][] toMul) {

        double[][][] result = new double[mul.length][mul[0].length][toMul[0][0].length];

        for (int x3 = 0; x3 < mul.length; x3++) {
            result[x3] =  DataDouble2d.matmul(mul[x3], toMul[x3], MUL_TILE_SIZE);
        }

        return result;
    }


    
    public static void verifyDimensions(double[][][] array, int[]expectedDimensions) {
        if (array.length != expectedDimensions[0]) {
            throw new DataException(
                    String.format("Size of first dimension of array must be %s, but was %s", expectedDimensions[0], array.length)
            );
        }
        else if (array[0].length != expectedDimensions[1]) {
            throw new DataException(
                    String.format("Size of second dimension of array must be %s, but was %s", expectedDimensions[1], array[0].length)
            );
        }
        else if (array[0][0].length != expectedDimensions[2]) {
            throw new DataException(
                    String.format("Size of third dimension of array must be %s, but was %s", expectedDimensions[2], array[0][0].length)
            );
        }
    }


    public static void verifyDimensions(double[][] array, int[]expectedDimensions) {
        if (array.length != expectedDimensions[0]) {
            throw new DataException(
                    String.format("Size of first dimension of array must be %s, but was %s", expectedDimensions[0], array.length)
            );
        }
        else if (array[0].length != expectedDimensions[1]) {
            throw new DataException(
                    String.format("Size of second dimension of array must be %s, but was %s", expectedDimensions[1], array[0].length)
            );
        }

    }


    /**
     * <pre>
     * Useful to string method. Displayed with first two dimensions (x and y)
     * as width and height respectively. Other dimensions are displayed in a
     * sort of list fashion.
     *
     * Note: the x start from 0 and go to the right. They y dimension start at 0
     * and go downwards.
     *
     * </pre>
     * @return
     */
    @Override
    public String toString() {
        
        StringBuilder sb = new StringBuilder();
        for (int x3 = 0; x3 < data.length; x3++) {
            sb.append("[");
            for (int x2 = 0; x2 < data[0].length; x2++) {
                sb.append(newLine());
                sb.append(" [");
                for (int x1 = 0; x1 < data[0][0].length; x1++) {
                    sb.append(roundPrint(data[x3][x2][x1], 4));
                    if (x1 < data[0][0].length - 1) {
                        sb.append(", ");
                    }
                }
                sb.append("]");
            }
            sb.append(newLine());
            sb.append("]");
            sb.append(newLine());
        }
        return sb.toString();
    }



}
