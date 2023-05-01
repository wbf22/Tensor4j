package com.freedommuskrats.tensor4j;

import com.freedommuskrats.tensor4j.data.DfData;
import com.freedommuskrats.tensor4j.exception.DataException;
import com.freedommuskrats.tensor4j.util.Range;

import java.util.Arrays;
import java.util.Random;

import static com.freedommuskrats.tensor4j.util.GeneralUtil.*;
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
public class Tensor2d extends DfData {

    public static final int MUL_TILE_SIZE = 32; // 32 seemed to be the best. 16 - 128 were optimal testing on MacBook pro 2021.


    private double[][] data;
    private int dims;


    
    /**
     * Create a new Tensor2d object with the given size and filler.
     * @param dim1 The x size or width of the array.
     * @param dim2 The y size or height of the array.
     * @param filler The value to fill the array with.
     */
    public Tensor2d(int dim1, int dim2, double filler) {
        dims = 2;
        this.data = new double[dim2][dim1];
        for (int x2 = 0; x2 < dim2; x2++) {
                Arrays.fill(data[x2], filler);
        }
    }

    /**
     * Create a new random Tensor2d object with the given size.
     * @param dim1 The x size or width of the array.
     * @param dim2 The y size or height of the array.
     */
    public Tensor2d(int dim1, int dim2) {
        dims = 2;
        Random r = new Random(System.nanoTime());
        this.data = new double[dim2][dim1];
        for (int x2 = 0; x2 < dim2; x2++) {
            for (int x1 = 0; x1 < dim1; x1++) {
                data[x2][x1] = r.nextDouble();
            }
        }
    }

    /**
     * Creates an array of zeros of the given dimensions. Use constructors for a random array.
     * @return
     */
    public static Tensor2d zeros(int dim1, int dim2) {
        return new Tensor2d(dim1, dim2, 0);
    }

    /**
     * Creates an array of ones of the given dimensions. Use constructors for a random array.
     * @return
     */
    public static Tensor2d ones(int dim1, int dim2) {
        return new Tensor2d(dim1, dim2, 1);
    }



    /**
     * You probably shouldn't use this.
     * Create a new Tensor object with the given data.
     * @param data The data to use.
     */
    public Tensor2d(double[][] data) {
        this.data = data;
        this.dims = 2;
    }


    /**
     * Returns the array this object provides an abstraction for.
     * You probably shouldn't use this
     * @return
     */
    public double[][] getData() {
        return data;
    }

    

    /**
     * Returns the value at the given index. Use slice for more control
     * @return
     */
    public double get(int x1, int x2) {
        return (data[x2][x1]);
    }

    

    /**
     * Sets the value at the given index. Use append for more control or for along different dims
     */
    public void set(int x1, int x2, double val) {
        data[x2][x1] = val;
    }



    /**
     * Returns the shape of the array.
     * @return
     */
    @Override
    public int[] shape() {
        return new int[]{data[0].length, data.length};
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
    public Tensor2d slice(Range x1Range, Range x2Range) {
        int[] x1Seq = x1Range.getSequence();
        int[] x2Seq = x2Range.getSequence();

        x1Seq = (x1Seq == null)? range(data[0].length).getSequence() : x1Seq;
        x2Seq = (x2Seq == null)? range(data.length).getSequence() : x2Seq;

        double[][] newData = new double[x2Seq.length][x1Seq.length];
        for (int x2 = 0; x2 < x2Seq.length; x2++) {
            for (int x1 = 0; x1 < x1Seq.length; x1++) {
                newData[x2][x1] = data[x2Seq[x2]][x1Seq[x1]];
            }
        }

        return new Tensor2d(newData);
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
    public void append(Tensor2d toAppend, int dim) {
        if (dim < 0 || dim > dims) {
            throw new DataException(
                    String.format("Can't append on dim %s for df array of size %s. " +
                            "'int dim' must be greater than zero and less than the dimension of the array", dim, dims)
            );
        }

        double[][] ap = toAppend.getData();

        
        if (dim == 0) {
            verifyDimensions(ap, new int[]{data.length, ap[0].length});
            double[][] newData = new double[data.length][data[0].length + ap[0].length];
            for (int x2 = 0; x2 < data.length; x2++) {
                for (int x1 = 0; x1 < newData[0].length; x1++) {
                    if (x1 < data[0].length) {
                        newData[x2][x1] = data[x2][x1];
                    } else {
                        newData[x2][x1] = ap[x2][x1 - data[0].length];
                    }
                }
            }
            data = newData;
        }
        if (dim == 1) {
            verifyDimensions(ap, new int[]{ap.length, data[0].length});
            double[][] newData = new double[data.length + ap.length][data[0].length];
            for (int x2 = 0; x2 < newData.length; x2++) {
                for (int x1 = 0; x1 < data[0].length; x1++) {
                    if (x2 < data.length) {
                        newData[x2][x1] = data[x2][x1];
                    } else {
                        newData[x2][x1] = ap[x2 - data.length][x1];
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
    public void append(Tensor1d toAppend) {

        double[] ap = toAppend.getData();

        
        verifyDimensions(ap, new int[]{data[0].length});
        double[][] newData = new double[data.length + 1][data[0].length];
        for (int x2 = 0; x2 < newData.length; x2++) {
            for (int x1 = 0; x1 < data[0].length; x1++) {
                if (x2 < data.length) {
                    newData[x2][x1] = data[x2][x1];
                } else {
                    newData[x2][x1] = ap[x1];
                }
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
    public static Tensor2d multiply(Tensor2d tensor, double scalar) {
        double[][] data = tensor.getData();
        double[][] newData = new double[data.length][data[0].length];

        for (int x2 = 0; x2 < data.length; x2++) {
            for (int x1 = 0; x1 < data[0].length; x1++) {
                newData[x2][x1] = data[x2][x1] * scalar;
            }
        }
        return new Tensor2d(newData);
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
    public static Tensor2d matmul(Tensor2d mul, Tensor2d toMul) {
        checkDims(mul, toMul);
        return new Tensor2d(matmul(mul.getData(), toMul.getData(), MUL_TILE_SIZE));
    }

    /**
     * <pre>
     * You probably shouldn't use this method directly. It is called by other
     * matmul methods.
     *
     * With this method you can set the tile size for the matmul operation.
     * For certain systems different or operations  a different tile size may
     * be beneficial to take advantage of the specific type of cache the
     * system uses. Benchmarking will probably be necessary to determine
     * the best tile size.
     *
     * @param mul
     * @param toMul
     * @return
     * </pre>
     */
    public static Tensor2d matmul(Tensor2d toMul, Tensor2d mul, int tileSize) {
        return new Tensor2d(matmul(toMul.getData(), mul.getData(), tileSize));
    }

    private static int[] shape(double[][] arr) {
        return new int[]{arr.length, arr[0].length};
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
    public static double[][] matmul(double[][] toMul, double[][] mul, int tileSize) {
//        1,1,1,2  X  2,3,1,1     7, 8, 7, 5
//        2,1,2,1     1,1,1,1     10,12,7, 6
//        3,1,1,1     2,2,1,1  =  10,13,7, 6
//        1,2,1,1     1,1,2,1     7, 8, 6, 5

//        1,2,1  X    3,2       6,  5
//        3,2,1       1,1  =    12, 9
//                    1,1

//        1,3,3    X    3,2       9, 11,
//                      1,1  =
//                      1,2

        double[][] result = new double[shape(toMul)[0]][shape(mul)[1]];
        int txLength = (int) Math.round(Math.ceil(
                Math.max(
                        toMul[0].length/((double)tileSize),
                        mul[0].length/((double)tileSize)
                )
        ));
        int tyLength = (int) Math.round(Math.ceil(
                Math.max(
                        toMul.length/((double)tileSize),
                        mul.length/((double)tileSize)
                )
        ));

        for (int tx = 0; tx <= txLength; tx += tileSize) {
            for (int ty = 0; ty <= tyLength; ty += tileSize) {
                for (int tx2 = 0; tx2 <= txLength; tx2 += tileSize) {
                    for (int y = 0; y < tileSize && ty + y < result.length; y++) {
                        for (int x = 0; x < tileSize && tx2 + x < result[0].length; x++) {
                            double sum = 0;
                            for (int j = 0; j < tileSize && tx + j < toMul[0].length; j++) {
                                sum += toMul[ty + y][tx + j] * mul[tx + j][tx2 + x];
                            }
                            result[ty + y][x + tx2] += sum;
                        }
                    }
                }
            }
        }

        return result;
    }


    /**
     * <pre>
     * You shouldn't use this method. It's the basic algorithm for
     * matrix multiplication but isn't implemented to take advantage
     * of the system cache.
     *
     * So don't use it unless you're a wild child ;)
     *
     * And you don't mind a significant slowdown
     *
     * @param mul
     * @param toMul
     * @return
     * </pre>
     */
    public static Tensor2d matmulNoCache(Tensor2d toMul, Tensor2d mul) {
        checkDims(toMul, mul);

        double[][] toMulArr = toMul.getData();
        double[][] mulArr = mul.getData();
        double[][] result = new double[toMul.shape()[1]][mul.shape()[0]];

//        1,3,3    X    3,2       9, 11,
//                      1,1  =
//                      1,2

        for (int row = 0; row < toMulArr.length; row++) {
            for (int col = 0; col < mulArr[0].length; col++) {
                double sum = 0;
                for (int j = 0; j < toMulArr[0].length; j++) {
                    sum += toMulArr[row][j] * mulArr[j][col];
                }
                result[row][col] += sum;
            }
        }
        return new Tensor2d(result);
    }



    private static void verifyDimensions(double[][] array, int[]expectedDimensions) {
        if (array.length != expectedDimensions[0]) {
            throw new DataException(
                    String.format("Size of dimension 2 of array must be %s, but was %s", expectedDimensions[0], array.length)
            );
        }
        else if (array[0].length != expectedDimensions[1]) {
            throw new DataException(
                    String.format("Size of dimension 1 of array must be %s, but was %s", expectedDimensions[1], array[0].length)
            );
        }
    }


    private static void verifyDimensions(double[] array, int[]expectedDimensions) {
        if (array.length != expectedDimensions[0]) {
            throw new DataException(
                    String.format("Size of dimension 1 of array must be %s, but was %s", expectedDimensions[0], array.length)
            );
        }
    }



    

    /**
     * <pre>
     * Reshapes an array to the given dimensions. Must have the same
     * dimensions, howbeit in a different order.
     * Eg. (1,2,3) reshape(2,3,1) = (2,3,1)
     *
     * Can be used to transpose an array as well.
     * Eg. (1,2,3) reshape(3,2,1) = transpose
     *
     * </pre>
     */
     public void reshape(int dim1, int dim2) {
        int[] shape = shape();
        int[] remappings = new int[2];
        boolean dim1F = false;
        boolean dim2F = false;
        for (int i = 0; i < shape.length; i++) {
            if (dim1 == shape[i] && !dim1F) {
                remappings[0] = i;
                dim1F = true;
            }
            else if (dim2 == shape[i] && !dim2F) {
                remappings[1] = i;
                dim2F = true;
            }
            else {
                throw new DataException("For reshape the given dimensions must be " +
                        "the same as current dimensions howbeit in a different order.");
            }
        }

        double[][] newData = new double[shape[remappings[1]]][shape[remappings[0]]];

        int[] indices = new int[2];
        for (int x1 = 0; x1 < data[0].length; x1++) {
            for (int x2 = 0; x2 < data.length; x2++) {
                for (int i = 0; i < indices.length; i++) {
                    if (remappings[i] == 0) {
                        indices[i] = x1;
                    }
                    if (remappings[i] == 1) {
                        indices[i] = x2;
                    }
                }
                newData[indices[1]][indices[0]] =  data[x2][x1];
            }
        }
        this.data = newData;
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
    public Tensor3d unsqueeze(int dim) {
        double[][][] newData;
        if (dim == 0) {
            newData = new double[data.length][data[0].length][1];
        }
        else if (dim == 1) {
            newData = new double[data.length][1][data[0].length];
        }
        else if (dim == 2) {
            newData = new double[1][data.length][data[0].length];
        }
        else {
            throw new DataException("Dimension must be between 0 and 2");
        }

        for (int x1 = 0; x1 < data[0].length; x1++) {
            for (int x2 = 0; x2 < data.length; x2++) {
                if (dim == 0) {
                    newData[x2][x1][0] =  data[x2][x1];
                }
                else if (dim == 1) {
                    newData[x2][0][x1] =  data[x2][x1];
                }
                else if (dim == 2) {
                    newData[0][x2][x1] =  data[x2][x1];
                }
            }
        }

        return new Tensor3d(newData);
    }


    

    /**
     * <pre>
     * Removes a dimension of size 1 or 0 from an array.
     *
     * Eg. (1,3) unsqueeze(0) = (3)
     * @param dim
     * @return
     * </pre>
     */
    public Tensor1d squeeze(int dim) {
        int[] shape = shape();
        if (shape[dim] > 1) {
            throw new DataException("Dim 2 must be of size 1 or 0 but was " + shape[dim]);
        }

        int[] newShape = new int[1];
        int newIndex = 0;
        for (int i = 0; i < shape.length; i++) {
            if (i != dim) {
                newShape[newIndex] = shape[i];
                newIndex++;
            }
        }
        double[] newData = new double[newShape[0]];
        for (int x1 = 0; x1 < newData.length; x1++) {
            if (dim == 0) {
                newData[x1] =  data[x1][0];
                }
            else if (dim == 1) {
                newData[x1] =  data[0][x1];
                }
            }

        return new Tensor1d(newData);
    }



    /**
     * Returns the max value of the tensor/array. Simple algorithm currently
     * which may be upgraded.
     * @return
     */
    public double max() {
        double max = Double.MIN_VALUE;
        for (int x1 = 0; x1 < data[0].length; x1++) {
            for (int x2 = 0; x2 < data.length; x2++) {
                double val = data[x2][x1];
                if (val > max) {
                    max = val;
                }
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
        for (int x1 = 0; x1 < data[0].length; x1++) {
            for (int x2 = 0; x2 < data.length; x2++) {
                double val = data[2][1];
                if (val < min) {
                    min = val;
                }
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

        int spacing = getNeededSpacing(max(), PRECISION);

        StringBuilder sb = new StringBuilder();
        for (int x2 = 0; x2 < data.length; x2++) {
            sb.append("[");
            for (int x1 = 0; x1 < data[0].length; x1++) {
                sb.append(roundPrint(data[x2][x1], PRECISION, spacing));
                if (x1 < data[0].length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            sb.append(newLine());
        }
        return sb.toString();
    }



}
