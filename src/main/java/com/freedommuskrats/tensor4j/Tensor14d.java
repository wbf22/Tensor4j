package com.freedommuskrats.tensor4j;

import com.freedommuskrats.tensor4j.data.DfData;
import com.freedommuskrats.tensor4j.exception.DataException;
import com.freedommuskrats.tensor4j.util.Range;

import java.util.Random;
import java.util.Arrays;

import static com.freedommuskrats.tensor4j.util.GeneralUtil.*;
import static com.freedommuskrats.tensor4j.Tensor2d.MUL_TILE_SIZE;
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

public class Tensor14d extends DfData {
    private double[][][][][][][][][][][][][][] data;
    private int dims;


    
    /**
     * Create a new Tensor14d object with the given size and filler.
     * @param dim1 The x size or width of the array.
     * @param dim2 The y size or height of the array.
     * @param dim3 The z size or depth of the array.
     * @param dim4 The dim4 size of the array.
     * @param dim5 The dim5 size of the array.
     * @param dim6 The dim6 size of the array.
     * @param dim7 The dim7 size of the array.
     * @param dim8 The dim8 size of the array.
     * @param dim9 The dim9 size of the array.
     * @param dim10 The dim10 size of the array.
     * @param dim11 The dim11 size of the array.
     * @param dim12 The dim12 size of the array.
     * @param dim13 The dim13 size of the array.
     * @param dim14 The dim14 size of the array.
     * @param filler The value to fill the array with.
     */
    public Tensor14d(int dim1, int dim2, int dim3, int dim4, int dim5, int dim6, int dim7, int dim8, int dim9, int dim10, int dim11, int dim12, int dim13, int dim14, double filler) {
        dims = 14;
        this.data = new double[dim14][dim13][dim12][dim11][dim10][dim9][dim8][dim7][dim6][dim5][dim4][dim3][dim2][dim1];
        for (int x14 = 0; x14 < dim14; x14++) {
            for (int x13 = 0; x13 < dim13; x13++) {
                for (int x12 = 0; x12 < dim12; x12++) {
                    for (int x11 = 0; x11 < dim11; x11++) {
                        for (int x10 = 0; x10 < dim10; x10++) {
                            for (int x9 = 0; x9 < dim9; x9++) {
                                for (int x8 = 0; x8 < dim8; x8++) {
                                    for (int x7 = 0; x7 < dim7; x7++) {
                                        for (int x6 = 0; x6 < dim6; x6++) {
                                            for (int x5 = 0; x5 < dim5; x5++) {
                                                for (int x4 = 0; x4 < dim4; x4++) {
                                                    for (int x3 = 0; x3 < dim3; x3++) {
                                                        for (int x2 = 0; x2 < dim2; x2++) {
                                                                Arrays.fill(data[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2], filler);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Create a new random Tensor14d object with the given size.
     * @param dim1 The x size or width of the array.
     * @param dim2 The y size or height of the array.
     * @param dim3 The z size or depth of the array.
     * @param dim4 The dim4 size of the array.
     * @param dim5 The dim5 size of the array.
     * @param dim6 The dim6 size of the array.
     * @param dim7 The dim7 size of the array.
     * @param dim8 The dim8 size of the array.
     * @param dim9 The dim9 size of the array.
     * @param dim10 The dim10 size of the array.
     * @param dim11 The dim11 size of the array.
     * @param dim12 The dim12 size of the array.
     * @param dim13 The dim13 size of the array.
     * @param dim14 The dim14 size of the array.
     */
    public Tensor14d(int dim1, int dim2, int dim3, int dim4, int dim5, int dim6, int dim7, int dim8, int dim9, int dim10, int dim11, int dim12, int dim13, int dim14) {
        dims = 14;
        Random r = new Random(System.nanoTime());
        this.data = new double[dim14][dim13][dim12][dim11][dim10][dim9][dim8][dim7][dim6][dim5][dim4][dim3][dim2][dim1];
        for (int x14 = 0; x14 < dim14; x14++) {
            for (int x13 = 0; x13 < dim13; x13++) {
                for (int x12 = 0; x12 < dim12; x12++) {
                    for (int x11 = 0; x11 < dim11; x11++) {
                        for (int x10 = 0; x10 < dim10; x10++) {
                            for (int x9 = 0; x9 < dim9; x9++) {
                                for (int x8 = 0; x8 < dim8; x8++) {
                                    for (int x7 = 0; x7 < dim7; x7++) {
                                        for (int x6 = 0; x6 < dim6; x6++) {
                                            for (int x5 = 0; x5 < dim5; x5++) {
                                                for (int x4 = 0; x4 < dim4; x4++) {
                                                    for (int x3 = 0; x3 < dim3; x3++) {
                                                        for (int x2 = 0; x2 < dim2; x2++) {
                                                            for (int x1 = 0; x1 < dim1; x1++) {
                                                                data[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1] = r.nextDouble();
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Creates an array of zeros of the given dimensions. Use constructors for a random array.
     * @return
     */
    public static Tensor14d zeros(int dim1, int dim2, int dim3, int dim4, int dim5, int dim6, int dim7, int dim8, int dim9, int dim10, int dim11, int dim12, int dim13, int dim14) {
        return new Tensor14d(dim1, dim2, dim3, dim4, dim5, dim6, dim7, dim8, dim9, dim10, dim11, dim12, dim13, dim14, 0);
    }

    /**
     * Creates an array of ones of the given dimensions. Use constructors for a random array.
     * @return
     */
    public static Tensor14d ones(int dim1, int dim2, int dim3, int dim4, int dim5, int dim6, int dim7, int dim8, int dim9, int dim10, int dim11, int dim12, int dim13, int dim14) {
        return new Tensor14d(dim1, dim2, dim3, dim4, dim5, dim6, dim7, dim8, dim9, dim10, dim11, dim12, dim13, dim14, 1);
    }



    /**
     * You probably shouldn't use this.
     * Create a new Tensor object with the given data.
     * @param data The data to use.
     */
    public Tensor14d(double[][][][][][][][][][][][][][] data) {
        this.data = data;
        this.dims = 14;
    }


    /**
     * Returns the array this object provides an abstraction for.
     * You probably shouldn't use this
     * @return
     */
    public double[][][][][][][][][][][][][][] getData() {
        return data;
    }

    

    /**
     * Returns the value at the given index. Use slice for more control
     * @return
     */
    public double get(int x1, int x2, int x3, int x4, int x5, int x6, int x7, int x8, int x9, int x10, int x11, int x12, int x13, int x14) {
        return (data[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1]);
    }

    

    /**
     * Sets the value at the given index. Use append for more control or for along different dims
     */
    public void set(int x1, int x2, int x3, int x4, int x5, int x6, int x7, int x8, int x9, int x10, int x11, int x12, int x13, int x14, double val) {
        data[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1] = val;
    }



    /**
     * Returns the shape of the array.
     * @return
     */
    @Override
    public int[] shape() {
        return new int[]{data[0][0][0][0][0][0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0].length, data[0][0][0][0][0][0].length, data[0][0][0][0][0].length, data[0][0][0][0].length, data[0][0][0].length, data[0][0].length, data[0].length, data.length};
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
    public Tensor14d slice(Range x1Range, Range x2Range, Range x3Range, Range x4Range, Range x5Range, Range x6Range, Range x7Range, Range x8Range, Range x9Range, Range x10Range, Range x11Range, Range x12Range, Range x13Range, Range x14Range) {
        int[] x1Seq = x1Range.getSequence();
        int[] x2Seq = x2Range.getSequence();
        int[] x3Seq = x3Range.getSequence();
        int[] x4Seq = x4Range.getSequence();
        int[] x5Seq = x5Range.getSequence();
        int[] x6Seq = x6Range.getSequence();
        int[] x7Seq = x7Range.getSequence();
        int[] x8Seq = x8Range.getSequence();
        int[] x9Seq = x9Range.getSequence();
        int[] x10Seq = x10Range.getSequence();
        int[] x11Seq = x11Range.getSequence();
        int[] x12Seq = x12Range.getSequence();
        int[] x13Seq = x13Range.getSequence();
        int[] x14Seq = x14Range.getSequence();

        x1Seq = (x1Seq == null)? range(data[0][0][0][0][0][0][0][0][0][0][0][0][0].length).getSequence() : x1Seq;
        x2Seq = (x2Seq == null)? range(data[0][0][0][0][0][0][0][0][0][0][0][0].length).getSequence() : x2Seq;
        x3Seq = (x3Seq == null)? range(data[0][0][0][0][0][0][0][0][0][0][0].length).getSequence() : x3Seq;
        x4Seq = (x4Seq == null)? range(data[0][0][0][0][0][0][0][0][0][0].length).getSequence() : x4Seq;
        x5Seq = (x5Seq == null)? range(data[0][0][0][0][0][0][0][0][0].length).getSequence() : x5Seq;
        x6Seq = (x6Seq == null)? range(data[0][0][0][0][0][0][0][0].length).getSequence() : x6Seq;
        x7Seq = (x7Seq == null)? range(data[0][0][0][0][0][0][0].length).getSequence() : x7Seq;
        x8Seq = (x8Seq == null)? range(data[0][0][0][0][0][0].length).getSequence() : x8Seq;
        x9Seq = (x9Seq == null)? range(data[0][0][0][0][0].length).getSequence() : x9Seq;
        x10Seq = (x10Seq == null)? range(data[0][0][0][0].length).getSequence() : x10Seq;
        x11Seq = (x11Seq == null)? range(data[0][0][0].length).getSequence() : x11Seq;
        x12Seq = (x12Seq == null)? range(data[0][0].length).getSequence() : x12Seq;
        x13Seq = (x13Seq == null)? range(data[0].length).getSequence() : x13Seq;
        x14Seq = (x14Seq == null)? range(data.length).getSequence() : x14Seq;

        double[][][][][][][][][][][][][][] newData = new double[x14Seq.length][x13Seq.length][x12Seq.length][x11Seq.length][x10Seq.length][x9Seq.length][x8Seq.length][x7Seq.length][x6Seq.length][x5Seq.length][x4Seq.length][x3Seq.length][x2Seq.length][x1Seq.length];
        for (int x14 = 0; x14 < x14Seq.length; x14++) {
            for (int x13 = 0; x13 < x13Seq.length; x13++) {
                for (int x12 = 0; x12 < x12Seq.length; x12++) {
                    for (int x11 = 0; x11 < x11Seq.length; x11++) {
                        for (int x10 = 0; x10 < x10Seq.length; x10++) {
                            for (int x9 = 0; x9 < x9Seq.length; x9++) {
                                for (int x8 = 0; x8 < x8Seq.length; x8++) {
                                    for (int x7 = 0; x7 < x7Seq.length; x7++) {
                                        for (int x6 = 0; x6 < x6Seq.length; x6++) {
                                            for (int x5 = 0; x5 < x5Seq.length; x5++) {
                                                for (int x4 = 0; x4 < x4Seq.length; x4++) {
                                                    for (int x3 = 0; x3 < x3Seq.length; x3++) {
                                                        for (int x2 = 0; x2 < x2Seq.length; x2++) {
                                                            for (int x1 = 0; x1 < x1Seq.length; x1++) {
                                                                newData[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1] = data[x14Seq[x14]][x13Seq[x13]][x12Seq[x12]][x11Seq[x11]][x10Seq[x10]][x9Seq[x9]][x8Seq[x8]][x7Seq[x7]][x6Seq[x6]][x5Seq[x5]][x4Seq[x4]][x3Seq[x3]][x2Seq[x2]][x1Seq[x1]];
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return new Tensor14d(newData);
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
    public void append(Tensor14d toAppend, int dim) {
        if (dim < 0 || dim > dims) {
            throw new DataException(
                    String.format("Can't append on dim %s for df array of size %s. " +
                            "'int dim' must be greater than zero and less than the dimension of the array", dim, dims)
            );
        }

        double[][][][][][][][][][][][][][] ap = toAppend.getData();

        
        if (dim == 0) {
            verifyDimensions(ap, new int[]{data.length, data[0].length, data[0][0].length, data[0][0][0].length, data[0][0][0][0].length, data[0][0][0][0][0].length, data[0][0][0][0][0][0].length, data[0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0][0][0][0].length, ap[0][0][0][0][0][0][0][0][0][0][0][0][0].length});
            double[][][][][][][][][][][][][][] newData = new double[data.length][data[0].length][data[0][0].length][data[0][0][0].length][data[0][0][0][0].length][data[0][0][0][0][0].length][data[0][0][0][0][0][0].length][data[0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0][0][0].length + ap[0][0][0][0][0][0][0][0][0][0][0][0][0].length];
            for (int x14 = 0; x14 < data.length; x14++) {
                for (int x13 = 0; x13 < data[0].length; x13++) {
                    for (int x12 = 0; x12 < data[0][0].length; x12++) {
                        for (int x11 = 0; x11 < data[0][0][0].length; x11++) {
                            for (int x10 = 0; x10 < data[0][0][0][0].length; x10++) {
                                for (int x9 = 0; x9 < data[0][0][0][0][0].length; x9++) {
                                    for (int x8 = 0; x8 < data[0][0][0][0][0][0].length; x8++) {
                                        for (int x7 = 0; x7 < data[0][0][0][0][0][0][0].length; x7++) {
                                            for (int x6 = 0; x6 < data[0][0][0][0][0][0][0][0].length; x6++) {
                                                for (int x5 = 0; x5 < data[0][0][0][0][0][0][0][0][0].length; x5++) {
                                                    for (int x4 = 0; x4 < data[0][0][0][0][0][0][0][0][0][0].length; x4++) {
                                                        for (int x3 = 0; x3 < data[0][0][0][0][0][0][0][0][0][0][0].length; x3++) {
                                                            for (int x2 = 0; x2 < data[0][0][0][0][0][0][0][0][0][0][0][0].length; x2++) {
                                                                for (int x1 = 0; x1 < newData[0][0][0][0][0][0][0][0][0][0][0][0][0].length; x1++) {
                                                                    if (x1 < data[0][0][0][0][0][0][0][0][0][0][0][0][0].length) {
                                                                        newData[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1] = data[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1];
                                                                    } else {
                                                                        newData[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1] = ap[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1 - data[0][0][0][0][0][0][0][0][0][0][0][0][0].length];
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            data = newData;
        }
        if (dim == 1) {
            verifyDimensions(ap, new int[]{data.length, data[0].length, data[0][0].length, data[0][0][0].length, data[0][0][0][0].length, data[0][0][0][0][0].length, data[0][0][0][0][0][0].length, data[0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0][0][0].length, ap[0][0][0][0][0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0][0][0][0][0].length});
            double[][][][][][][][][][][][][][] newData = new double[data.length][data[0].length][data[0][0].length][data[0][0][0].length][data[0][0][0][0].length][data[0][0][0][0][0].length][data[0][0][0][0][0][0].length][data[0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0][0].length + ap[0][0][0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0][0][0].length];
            for (int x14 = 0; x14 < data.length; x14++) {
                for (int x13 = 0; x13 < data[0].length; x13++) {
                    for (int x12 = 0; x12 < data[0][0].length; x12++) {
                        for (int x11 = 0; x11 < data[0][0][0].length; x11++) {
                            for (int x10 = 0; x10 < data[0][0][0][0].length; x10++) {
                                for (int x9 = 0; x9 < data[0][0][0][0][0].length; x9++) {
                                    for (int x8 = 0; x8 < data[0][0][0][0][0][0].length; x8++) {
                                        for (int x7 = 0; x7 < data[0][0][0][0][0][0][0].length; x7++) {
                                            for (int x6 = 0; x6 < data[0][0][0][0][0][0][0][0].length; x6++) {
                                                for (int x5 = 0; x5 < data[0][0][0][0][0][0][0][0][0].length; x5++) {
                                                    for (int x4 = 0; x4 < data[0][0][0][0][0][0][0][0][0][0].length; x4++) {
                                                        for (int x3 = 0; x3 < data[0][0][0][0][0][0][0][0][0][0][0].length; x3++) {
                                                            for (int x2 = 0; x2 < newData[0][0][0][0][0][0][0][0][0][0][0][0].length; x2++) {
                                                                for (int x1 = 0; x1 < data[0][0][0][0][0][0][0][0][0][0][0][0][0].length; x1++) {
                                                                    if (x2 < data[0][0][0][0][0][0][0][0][0][0][0][0].length) {
                                                                        newData[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1] = data[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1];
                                                                    } else {
                                                                        newData[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1] = ap[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2 - data[0][0][0][0][0][0][0][0][0][0][0][0].length][x1];
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            data = newData;
        }
        if (dim == 2) {
            verifyDimensions(ap, new int[]{data.length, data[0].length, data[0][0].length, data[0][0][0].length, data[0][0][0][0].length, data[0][0][0][0][0].length, data[0][0][0][0][0][0].length, data[0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0][0].length, ap[0][0][0][0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0][0][0][0][0].length});
            double[][][][][][][][][][][][][][] newData = new double[data.length][data[0].length][data[0][0].length][data[0][0][0].length][data[0][0][0][0].length][data[0][0][0][0][0].length][data[0][0][0][0][0][0].length][data[0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0].length + ap[0][0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0][0][0].length];
            for (int x14 = 0; x14 < data.length; x14++) {
                for (int x13 = 0; x13 < data[0].length; x13++) {
                    for (int x12 = 0; x12 < data[0][0].length; x12++) {
                        for (int x11 = 0; x11 < data[0][0][0].length; x11++) {
                            for (int x10 = 0; x10 < data[0][0][0][0].length; x10++) {
                                for (int x9 = 0; x9 < data[0][0][0][0][0].length; x9++) {
                                    for (int x8 = 0; x8 < data[0][0][0][0][0][0].length; x8++) {
                                        for (int x7 = 0; x7 < data[0][0][0][0][0][0][0].length; x7++) {
                                            for (int x6 = 0; x6 < data[0][0][0][0][0][0][0][0].length; x6++) {
                                                for (int x5 = 0; x5 < data[0][0][0][0][0][0][0][0][0].length; x5++) {
                                                    for (int x4 = 0; x4 < data[0][0][0][0][0][0][0][0][0][0].length; x4++) {
                                                        for (int x3 = 0; x3 < newData[0][0][0][0][0][0][0][0][0][0][0].length; x3++) {
                                                            for (int x2 = 0; x2 < data[0][0][0][0][0][0][0][0][0][0][0][0].length; x2++) {
                                                                for (int x1 = 0; x1 < data[0][0][0][0][0][0][0][0][0][0][0][0][0].length; x1++) {
                                                                    if (x3 < data[0][0][0][0][0][0][0][0][0][0][0].length) {
                                                                        newData[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1] = data[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1];
                                                                    } else {
                                                                        newData[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1] = ap[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3 - data[0][0][0][0][0][0][0][0][0][0][0].length][x2][x1];
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            data = newData;
        }
        if (dim == 3) {
            verifyDimensions(ap, new int[]{data.length, data[0].length, data[0][0].length, data[0][0][0].length, data[0][0][0][0].length, data[0][0][0][0][0].length, data[0][0][0][0][0][0].length, data[0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0].length, ap[0][0][0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0][0][0][0][0].length});
            double[][][][][][][][][][][][][][] newData = new double[data.length][data[0].length][data[0][0].length][data[0][0][0].length][data[0][0][0][0].length][data[0][0][0][0][0].length][data[0][0][0][0][0][0].length][data[0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0].length + ap[0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0][0][0].length];
            for (int x14 = 0; x14 < data.length; x14++) {
                for (int x13 = 0; x13 < data[0].length; x13++) {
                    for (int x12 = 0; x12 < data[0][0].length; x12++) {
                        for (int x11 = 0; x11 < data[0][0][0].length; x11++) {
                            for (int x10 = 0; x10 < data[0][0][0][0].length; x10++) {
                                for (int x9 = 0; x9 < data[0][0][0][0][0].length; x9++) {
                                    for (int x8 = 0; x8 < data[0][0][0][0][0][0].length; x8++) {
                                        for (int x7 = 0; x7 < data[0][0][0][0][0][0][0].length; x7++) {
                                            for (int x6 = 0; x6 < data[0][0][0][0][0][0][0][0].length; x6++) {
                                                for (int x5 = 0; x5 < data[0][0][0][0][0][0][0][0][0].length; x5++) {
                                                    for (int x4 = 0; x4 < newData[0][0][0][0][0][0][0][0][0][0].length; x4++) {
                                                        for (int x3 = 0; x3 < data[0][0][0][0][0][0][0][0][0][0][0].length; x3++) {
                                                            for (int x2 = 0; x2 < data[0][0][0][0][0][0][0][0][0][0][0][0].length; x2++) {
                                                                for (int x1 = 0; x1 < data[0][0][0][0][0][0][0][0][0][0][0][0][0].length; x1++) {
                                                                    if (x4 < data[0][0][0][0][0][0][0][0][0][0].length) {
                                                                        newData[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1] = data[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1];
                                                                    } else {
                                                                        newData[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1] = ap[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4 - data[0][0][0][0][0][0][0][0][0][0].length][x3][x2][x1];
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            data = newData;
        }
        if (dim == 4) {
            verifyDimensions(ap, new int[]{data.length, data[0].length, data[0][0].length, data[0][0][0].length, data[0][0][0][0].length, data[0][0][0][0][0].length, data[0][0][0][0][0][0].length, data[0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0].length, ap[0][0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0][0][0][0][0].length});
            double[][][][][][][][][][][][][][] newData = new double[data.length][data[0].length][data[0][0].length][data[0][0][0].length][data[0][0][0][0].length][data[0][0][0][0][0].length][data[0][0][0][0][0][0].length][data[0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0].length + ap[0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0][0][0].length];
            for (int x14 = 0; x14 < data.length; x14++) {
                for (int x13 = 0; x13 < data[0].length; x13++) {
                    for (int x12 = 0; x12 < data[0][0].length; x12++) {
                        for (int x11 = 0; x11 < data[0][0][0].length; x11++) {
                            for (int x10 = 0; x10 < data[0][0][0][0].length; x10++) {
                                for (int x9 = 0; x9 < data[0][0][0][0][0].length; x9++) {
                                    for (int x8 = 0; x8 < data[0][0][0][0][0][0].length; x8++) {
                                        for (int x7 = 0; x7 < data[0][0][0][0][0][0][0].length; x7++) {
                                            for (int x6 = 0; x6 < data[0][0][0][0][0][0][0][0].length; x6++) {
                                                for (int x5 = 0; x5 < newData[0][0][0][0][0][0][0][0][0].length; x5++) {
                                                    for (int x4 = 0; x4 < data[0][0][0][0][0][0][0][0][0][0].length; x4++) {
                                                        for (int x3 = 0; x3 < data[0][0][0][0][0][0][0][0][0][0][0].length; x3++) {
                                                            for (int x2 = 0; x2 < data[0][0][0][0][0][0][0][0][0][0][0][0].length; x2++) {
                                                                for (int x1 = 0; x1 < data[0][0][0][0][0][0][0][0][0][0][0][0][0].length; x1++) {
                                                                    if (x5 < data[0][0][0][0][0][0][0][0][0].length) {
                                                                        newData[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1] = data[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1];
                                                                    } else {
                                                                        newData[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1] = ap[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5 - data[0][0][0][0][0][0][0][0][0].length][x4][x3][x2][x1];
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            data = newData;
        }
        if (dim == 5) {
            verifyDimensions(ap, new int[]{data.length, data[0].length, data[0][0].length, data[0][0][0].length, data[0][0][0][0].length, data[0][0][0][0][0].length, data[0][0][0][0][0][0].length, data[0][0][0][0][0][0][0].length, ap[0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0][0][0][0][0].length});
            double[][][][][][][][][][][][][][] newData = new double[data.length][data[0].length][data[0][0].length][data[0][0][0].length][data[0][0][0][0].length][data[0][0][0][0][0].length][data[0][0][0][0][0][0].length][data[0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0].length + ap[0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0][0][0].length];
            for (int x14 = 0; x14 < data.length; x14++) {
                for (int x13 = 0; x13 < data[0].length; x13++) {
                    for (int x12 = 0; x12 < data[0][0].length; x12++) {
                        for (int x11 = 0; x11 < data[0][0][0].length; x11++) {
                            for (int x10 = 0; x10 < data[0][0][0][0].length; x10++) {
                                for (int x9 = 0; x9 < data[0][0][0][0][0].length; x9++) {
                                    for (int x8 = 0; x8 < data[0][0][0][0][0][0].length; x8++) {
                                        for (int x7 = 0; x7 < data[0][0][0][0][0][0][0].length; x7++) {
                                            for (int x6 = 0; x6 < newData[0][0][0][0][0][0][0][0].length; x6++) {
                                                for (int x5 = 0; x5 < data[0][0][0][0][0][0][0][0][0].length; x5++) {
                                                    for (int x4 = 0; x4 < data[0][0][0][0][0][0][0][0][0][0].length; x4++) {
                                                        for (int x3 = 0; x3 < data[0][0][0][0][0][0][0][0][0][0][0].length; x3++) {
                                                            for (int x2 = 0; x2 < data[0][0][0][0][0][0][0][0][0][0][0][0].length; x2++) {
                                                                for (int x1 = 0; x1 < data[0][0][0][0][0][0][0][0][0][0][0][0][0].length; x1++) {
                                                                    if (x6 < data[0][0][0][0][0][0][0][0].length) {
                                                                        newData[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1] = data[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1];
                                                                    } else {
                                                                        newData[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1] = ap[x14][x13][x12][x11][x10][x9][x8][x7][x6 - data[0][0][0][0][0][0][0][0].length][x5][x4][x3][x2][x1];
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            data = newData;
        }
        if (dim == 6) {
            verifyDimensions(ap, new int[]{data.length, data[0].length, data[0][0].length, data[0][0][0].length, data[0][0][0][0].length, data[0][0][0][0][0].length, data[0][0][0][0][0][0].length, ap[0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0][0][0][0][0].length});
            double[][][][][][][][][][][][][][] newData = new double[data.length][data[0].length][data[0][0].length][data[0][0][0].length][data[0][0][0][0].length][data[0][0][0][0][0].length][data[0][0][0][0][0][0].length][data[0][0][0][0][0][0][0].length + ap[0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0][0][0].length];
            for (int x14 = 0; x14 < data.length; x14++) {
                for (int x13 = 0; x13 < data[0].length; x13++) {
                    for (int x12 = 0; x12 < data[0][0].length; x12++) {
                        for (int x11 = 0; x11 < data[0][0][0].length; x11++) {
                            for (int x10 = 0; x10 < data[0][0][0][0].length; x10++) {
                                for (int x9 = 0; x9 < data[0][0][0][0][0].length; x9++) {
                                    for (int x8 = 0; x8 < data[0][0][0][0][0][0].length; x8++) {
                                        for (int x7 = 0; x7 < newData[0][0][0][0][0][0][0].length; x7++) {
                                            for (int x6 = 0; x6 < data[0][0][0][0][0][0][0][0].length; x6++) {
                                                for (int x5 = 0; x5 < data[0][0][0][0][0][0][0][0][0].length; x5++) {
                                                    for (int x4 = 0; x4 < data[0][0][0][0][0][0][0][0][0][0].length; x4++) {
                                                        for (int x3 = 0; x3 < data[0][0][0][0][0][0][0][0][0][0][0].length; x3++) {
                                                            for (int x2 = 0; x2 < data[0][0][0][0][0][0][0][0][0][0][0][0].length; x2++) {
                                                                for (int x1 = 0; x1 < data[0][0][0][0][0][0][0][0][0][0][0][0][0].length; x1++) {
                                                                    if (x7 < data[0][0][0][0][0][0][0].length) {
                                                                        newData[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1] = data[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1];
                                                                    } else {
                                                                        newData[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1] = ap[x14][x13][x12][x11][x10][x9][x8][x7 - data[0][0][0][0][0][0][0].length][x6][x5][x4][x3][x2][x1];
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            data = newData;
        }
        if (dim == 7) {
            verifyDimensions(ap, new int[]{data.length, data[0].length, data[0][0].length, data[0][0][0].length, data[0][0][0][0].length, data[0][0][0][0][0].length, ap[0][0][0][0][0][0].length, data[0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0][0][0][0][0].length});
            double[][][][][][][][][][][][][][] newData = new double[data.length][data[0].length][data[0][0].length][data[0][0][0].length][data[0][0][0][0].length][data[0][0][0][0][0].length][data[0][0][0][0][0][0].length + ap[0][0][0][0][0][0].length][data[0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0][0][0].length];
            for (int x14 = 0; x14 < data.length; x14++) {
                for (int x13 = 0; x13 < data[0].length; x13++) {
                    for (int x12 = 0; x12 < data[0][0].length; x12++) {
                        for (int x11 = 0; x11 < data[0][0][0].length; x11++) {
                            for (int x10 = 0; x10 < data[0][0][0][0].length; x10++) {
                                for (int x9 = 0; x9 < data[0][0][0][0][0].length; x9++) {
                                    for (int x8 = 0; x8 < newData[0][0][0][0][0][0].length; x8++) {
                                        for (int x7 = 0; x7 < data[0][0][0][0][0][0][0].length; x7++) {
                                            for (int x6 = 0; x6 < data[0][0][0][0][0][0][0][0].length; x6++) {
                                                for (int x5 = 0; x5 < data[0][0][0][0][0][0][0][0][0].length; x5++) {
                                                    for (int x4 = 0; x4 < data[0][0][0][0][0][0][0][0][0][0].length; x4++) {
                                                        for (int x3 = 0; x3 < data[0][0][0][0][0][0][0][0][0][0][0].length; x3++) {
                                                            for (int x2 = 0; x2 < data[0][0][0][0][0][0][0][0][0][0][0][0].length; x2++) {
                                                                for (int x1 = 0; x1 < data[0][0][0][0][0][0][0][0][0][0][0][0][0].length; x1++) {
                                                                    if (x8 < data[0][0][0][0][0][0].length) {
                                                                        newData[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1] = data[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1];
                                                                    } else {
                                                                        newData[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1] = ap[x14][x13][x12][x11][x10][x9][x8 - data[0][0][0][0][0][0].length][x7][x6][x5][x4][x3][x2][x1];
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            data = newData;
        }
        if (dim == 8) {
            verifyDimensions(ap, new int[]{data.length, data[0].length, data[0][0].length, data[0][0][0].length, data[0][0][0][0].length, ap[0][0][0][0][0].length, data[0][0][0][0][0][0].length, data[0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0][0][0][0][0].length});
            double[][][][][][][][][][][][][][] newData = new double[data.length][data[0].length][data[0][0].length][data[0][0][0].length][data[0][0][0][0].length][data[0][0][0][0][0].length + ap[0][0][0][0][0].length][data[0][0][0][0][0][0].length][data[0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0][0][0].length];
            for (int x14 = 0; x14 < data.length; x14++) {
                for (int x13 = 0; x13 < data[0].length; x13++) {
                    for (int x12 = 0; x12 < data[0][0].length; x12++) {
                        for (int x11 = 0; x11 < data[0][0][0].length; x11++) {
                            for (int x10 = 0; x10 < data[0][0][0][0].length; x10++) {
                                for (int x9 = 0; x9 < newData[0][0][0][0][0].length; x9++) {
                                    for (int x8 = 0; x8 < data[0][0][0][0][0][0].length; x8++) {
                                        for (int x7 = 0; x7 < data[0][0][0][0][0][0][0].length; x7++) {
                                            for (int x6 = 0; x6 < data[0][0][0][0][0][0][0][0].length; x6++) {
                                                for (int x5 = 0; x5 < data[0][0][0][0][0][0][0][0][0].length; x5++) {
                                                    for (int x4 = 0; x4 < data[0][0][0][0][0][0][0][0][0][0].length; x4++) {
                                                        for (int x3 = 0; x3 < data[0][0][0][0][0][0][0][0][0][0][0].length; x3++) {
                                                            for (int x2 = 0; x2 < data[0][0][0][0][0][0][0][0][0][0][0][0].length; x2++) {
                                                                for (int x1 = 0; x1 < data[0][0][0][0][0][0][0][0][0][0][0][0][0].length; x1++) {
                                                                    if (x9 < data[0][0][0][0][0].length) {
                                                                        newData[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1] = data[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1];
                                                                    } else {
                                                                        newData[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1] = ap[x14][x13][x12][x11][x10][x9 - data[0][0][0][0][0].length][x8][x7][x6][x5][x4][x3][x2][x1];
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            data = newData;
        }
        if (dim == 9) {
            verifyDimensions(ap, new int[]{data.length, data[0].length, data[0][0].length, data[0][0][0].length, ap[0][0][0][0].length, data[0][0][0][0][0].length, data[0][0][0][0][0][0].length, data[0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0][0][0][0][0].length});
            double[][][][][][][][][][][][][][] newData = new double[data.length][data[0].length][data[0][0].length][data[0][0][0].length][data[0][0][0][0].length + ap[0][0][0][0].length][data[0][0][0][0][0].length][data[0][0][0][0][0][0].length][data[0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0][0][0].length];
            for (int x14 = 0; x14 < data.length; x14++) {
                for (int x13 = 0; x13 < data[0].length; x13++) {
                    for (int x12 = 0; x12 < data[0][0].length; x12++) {
                        for (int x11 = 0; x11 < data[0][0][0].length; x11++) {
                            for (int x10 = 0; x10 < newData[0][0][0][0].length; x10++) {
                                for (int x9 = 0; x9 < data[0][0][0][0][0].length; x9++) {
                                    for (int x8 = 0; x8 < data[0][0][0][0][0][0].length; x8++) {
                                        for (int x7 = 0; x7 < data[0][0][0][0][0][0][0].length; x7++) {
                                            for (int x6 = 0; x6 < data[0][0][0][0][0][0][0][0].length; x6++) {
                                                for (int x5 = 0; x5 < data[0][0][0][0][0][0][0][0][0].length; x5++) {
                                                    for (int x4 = 0; x4 < data[0][0][0][0][0][0][0][0][0][0].length; x4++) {
                                                        for (int x3 = 0; x3 < data[0][0][0][0][0][0][0][0][0][0][0].length; x3++) {
                                                            for (int x2 = 0; x2 < data[0][0][0][0][0][0][0][0][0][0][0][0].length; x2++) {
                                                                for (int x1 = 0; x1 < data[0][0][0][0][0][0][0][0][0][0][0][0][0].length; x1++) {
                                                                    if (x10 < data[0][0][0][0].length) {
                                                                        newData[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1] = data[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1];
                                                                    } else {
                                                                        newData[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1] = ap[x14][x13][x12][x11][x10 - data[0][0][0][0].length][x9][x8][x7][x6][x5][x4][x3][x2][x1];
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            data = newData;
        }
        if (dim == 10) {
            verifyDimensions(ap, new int[]{data.length, data[0].length, data[0][0].length, ap[0][0][0].length, data[0][0][0][0].length, data[0][0][0][0][0].length, data[0][0][0][0][0][0].length, data[0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0][0][0][0][0].length});
            double[][][][][][][][][][][][][][] newData = new double[data.length][data[0].length][data[0][0].length][data[0][0][0].length + ap[0][0][0].length][data[0][0][0][0].length][data[0][0][0][0][0].length][data[0][0][0][0][0][0].length][data[0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0][0][0].length];
            for (int x14 = 0; x14 < data.length; x14++) {
                for (int x13 = 0; x13 < data[0].length; x13++) {
                    for (int x12 = 0; x12 < data[0][0].length; x12++) {
                        for (int x11 = 0; x11 < newData[0][0][0].length; x11++) {
                            for (int x10 = 0; x10 < data[0][0][0][0].length; x10++) {
                                for (int x9 = 0; x9 < data[0][0][0][0][0].length; x9++) {
                                    for (int x8 = 0; x8 < data[0][0][0][0][0][0].length; x8++) {
                                        for (int x7 = 0; x7 < data[0][0][0][0][0][0][0].length; x7++) {
                                            for (int x6 = 0; x6 < data[0][0][0][0][0][0][0][0].length; x6++) {
                                                for (int x5 = 0; x5 < data[0][0][0][0][0][0][0][0][0].length; x5++) {
                                                    for (int x4 = 0; x4 < data[0][0][0][0][0][0][0][0][0][0].length; x4++) {
                                                        for (int x3 = 0; x3 < data[0][0][0][0][0][0][0][0][0][0][0].length; x3++) {
                                                            for (int x2 = 0; x2 < data[0][0][0][0][0][0][0][0][0][0][0][0].length; x2++) {
                                                                for (int x1 = 0; x1 < data[0][0][0][0][0][0][0][0][0][0][0][0][0].length; x1++) {
                                                                    if (x11 < data[0][0][0].length) {
                                                                        newData[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1] = data[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1];
                                                                    } else {
                                                                        newData[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1] = ap[x14][x13][x12][x11 - data[0][0][0].length][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1];
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            data = newData;
        }
        if (dim == 11) {
            verifyDimensions(ap, new int[]{data.length, data[0].length, ap[0][0].length, data[0][0][0].length, data[0][0][0][0].length, data[0][0][0][0][0].length, data[0][0][0][0][0][0].length, data[0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0][0][0][0][0].length});
            double[][][][][][][][][][][][][][] newData = new double[data.length][data[0].length][data[0][0].length + ap[0][0].length][data[0][0][0].length][data[0][0][0][0].length][data[0][0][0][0][0].length][data[0][0][0][0][0][0].length][data[0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0][0][0].length];
            for (int x14 = 0; x14 < data.length; x14++) {
                for (int x13 = 0; x13 < data[0].length; x13++) {
                    for (int x12 = 0; x12 < newData[0][0].length; x12++) {
                        for (int x11 = 0; x11 < data[0][0][0].length; x11++) {
                            for (int x10 = 0; x10 < data[0][0][0][0].length; x10++) {
                                for (int x9 = 0; x9 < data[0][0][0][0][0].length; x9++) {
                                    for (int x8 = 0; x8 < data[0][0][0][0][0][0].length; x8++) {
                                        for (int x7 = 0; x7 < data[0][0][0][0][0][0][0].length; x7++) {
                                            for (int x6 = 0; x6 < data[0][0][0][0][0][0][0][0].length; x6++) {
                                                for (int x5 = 0; x5 < data[0][0][0][0][0][0][0][0][0].length; x5++) {
                                                    for (int x4 = 0; x4 < data[0][0][0][0][0][0][0][0][0][0].length; x4++) {
                                                        for (int x3 = 0; x3 < data[0][0][0][0][0][0][0][0][0][0][0].length; x3++) {
                                                            for (int x2 = 0; x2 < data[0][0][0][0][0][0][0][0][0][0][0][0].length; x2++) {
                                                                for (int x1 = 0; x1 < data[0][0][0][0][0][0][0][0][0][0][0][0][0].length; x1++) {
                                                                    if (x12 < data[0][0].length) {
                                                                        newData[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1] = data[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1];
                                                                    } else {
                                                                        newData[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1] = ap[x14][x13][x12 - data[0][0].length][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1];
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            data = newData;
        }
        if (dim == 12) {
            verifyDimensions(ap, new int[]{data.length, ap[0].length, data[0][0].length, data[0][0][0].length, data[0][0][0][0].length, data[0][0][0][0][0].length, data[0][0][0][0][0][0].length, data[0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0][0][0][0][0].length});
            double[][][][][][][][][][][][][][] newData = new double[data.length][data[0].length + ap[0].length][data[0][0].length][data[0][0][0].length][data[0][0][0][0].length][data[0][0][0][0][0].length][data[0][0][0][0][0][0].length][data[0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0][0][0].length];
            for (int x14 = 0; x14 < data.length; x14++) {
                for (int x13 = 0; x13 < newData[0].length; x13++) {
                    for (int x12 = 0; x12 < data[0][0].length; x12++) {
                        for (int x11 = 0; x11 < data[0][0][0].length; x11++) {
                            for (int x10 = 0; x10 < data[0][0][0][0].length; x10++) {
                                for (int x9 = 0; x9 < data[0][0][0][0][0].length; x9++) {
                                    for (int x8 = 0; x8 < data[0][0][0][0][0][0].length; x8++) {
                                        for (int x7 = 0; x7 < data[0][0][0][0][0][0][0].length; x7++) {
                                            for (int x6 = 0; x6 < data[0][0][0][0][0][0][0][0].length; x6++) {
                                                for (int x5 = 0; x5 < data[0][0][0][0][0][0][0][0][0].length; x5++) {
                                                    for (int x4 = 0; x4 < data[0][0][0][0][0][0][0][0][0][0].length; x4++) {
                                                        for (int x3 = 0; x3 < data[0][0][0][0][0][0][0][0][0][0][0].length; x3++) {
                                                            for (int x2 = 0; x2 < data[0][0][0][0][0][0][0][0][0][0][0][0].length; x2++) {
                                                                for (int x1 = 0; x1 < data[0][0][0][0][0][0][0][0][0][0][0][0][0].length; x1++) {
                                                                    if (x13 < data[0].length) {
                                                                        newData[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1] = data[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1];
                                                                    } else {
                                                                        newData[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1] = ap[x14][x13 - data[0].length][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1];
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            data = newData;
        }
        if (dim == 13) {
            verifyDimensions(ap, new int[]{ap.length, data[0].length, data[0][0].length, data[0][0][0].length, data[0][0][0][0].length, data[0][0][0][0][0].length, data[0][0][0][0][0][0].length, data[0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0][0][0][0][0].length});
            double[][][][][][][][][][][][][][] newData = new double[data.length + ap.length][data[0].length][data[0][0].length][data[0][0][0].length][data[0][0][0][0].length][data[0][0][0][0][0].length][data[0][0][0][0][0][0].length][data[0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0][0][0].length];
            for (int x14 = 0; x14 < newData.length; x14++) {
                for (int x13 = 0; x13 < data[0].length; x13++) {
                    for (int x12 = 0; x12 < data[0][0].length; x12++) {
                        for (int x11 = 0; x11 < data[0][0][0].length; x11++) {
                            for (int x10 = 0; x10 < data[0][0][0][0].length; x10++) {
                                for (int x9 = 0; x9 < data[0][0][0][0][0].length; x9++) {
                                    for (int x8 = 0; x8 < data[0][0][0][0][0][0].length; x8++) {
                                        for (int x7 = 0; x7 < data[0][0][0][0][0][0][0].length; x7++) {
                                            for (int x6 = 0; x6 < data[0][0][0][0][0][0][0][0].length; x6++) {
                                                for (int x5 = 0; x5 < data[0][0][0][0][0][0][0][0][0].length; x5++) {
                                                    for (int x4 = 0; x4 < data[0][0][0][0][0][0][0][0][0][0].length; x4++) {
                                                        for (int x3 = 0; x3 < data[0][0][0][0][0][0][0][0][0][0][0].length; x3++) {
                                                            for (int x2 = 0; x2 < data[0][0][0][0][0][0][0][0][0][0][0][0].length; x2++) {
                                                                for (int x1 = 0; x1 < data[0][0][0][0][0][0][0][0][0][0][0][0][0].length; x1++) {
                                                                    if (x14 < data.length) {
                                                                        newData[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1] = data[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1];
                                                                    } else {
                                                                        newData[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1] = ap[x14 - data.length][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1];
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
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
    public void append(Tensor13d toAppend) {

        double[][][][][][][][][][][][][] ap = toAppend.getData();

        
        verifyDimensions(ap, new int[]{data[0].length, data[0][0].length, data[0][0][0].length, data[0][0][0][0].length, data[0][0][0][0][0].length, data[0][0][0][0][0][0].length, data[0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0][0][0][0].length, data[0][0][0][0][0][0][0][0][0][0][0][0][0].length});
        double[][][][][][][][][][][][][][] newData = new double[data.length + 1][data[0].length][data[0][0].length][data[0][0][0].length][data[0][0][0][0].length][data[0][0][0][0][0].length][data[0][0][0][0][0][0].length][data[0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0][0][0].length];
        for (int x14 = 0; x14 < newData.length; x14++) {
            for (int x13 = 0; x13 < data[0].length; x13++) {
                for (int x12 = 0; x12 < data[0][0].length; x12++) {
                    for (int x11 = 0; x11 < data[0][0][0].length; x11++) {
                        for (int x10 = 0; x10 < data[0][0][0][0].length; x10++) {
                            for (int x9 = 0; x9 < data[0][0][0][0][0].length; x9++) {
                                for (int x8 = 0; x8 < data[0][0][0][0][0][0].length; x8++) {
                                    for (int x7 = 0; x7 < data[0][0][0][0][0][0][0].length; x7++) {
                                        for (int x6 = 0; x6 < data[0][0][0][0][0][0][0][0].length; x6++) {
                                            for (int x5 = 0; x5 < data[0][0][0][0][0][0][0][0][0].length; x5++) {
                                                for (int x4 = 0; x4 < data[0][0][0][0][0][0][0][0][0][0].length; x4++) {
                                                    for (int x3 = 0; x3 < data[0][0][0][0][0][0][0][0][0][0][0].length; x3++) {
                                                        for (int x2 = 0; x2 < data[0][0][0][0][0][0][0][0][0][0][0][0].length; x2++) {
                                                            for (int x1 = 0; x1 < data[0][0][0][0][0][0][0][0][0][0][0][0][0].length; x1++) {
                                                                if (x14 < data.length) {
                                                                    newData[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1] = data[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1];
                                                                } else {
                                                                    newData[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1] = ap[x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1];
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
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
    public static Tensor14d multiply(Tensor14d tensor, double scalar) {
        double[][][][][][][][][][][][][][] data = tensor.getData();
        double[][][][][][][][][][][][][][] newData = new double[data.length][data[0].length][data[0][0].length][data[0][0][0].length][data[0][0][0][0].length][data[0][0][0][0][0].length][data[0][0][0][0][0][0].length][data[0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0][0][0].length];

        for (int x14 = 0; x14 < data.length; x14++) {
            for (int x13 = 0; x13 < data[0].length; x13++) {
                for (int x12 = 0; x12 < data[0][0].length; x12++) {
                    for (int x11 = 0; x11 < data[0][0][0].length; x11++) {
                        for (int x10 = 0; x10 < data[0][0][0][0].length; x10++) {
                            for (int x9 = 0; x9 < data[0][0][0][0][0].length; x9++) {
                                for (int x8 = 0; x8 < data[0][0][0][0][0][0].length; x8++) {
                                    for (int x7 = 0; x7 < data[0][0][0][0][0][0][0].length; x7++) {
                                        for (int x6 = 0; x6 < data[0][0][0][0][0][0][0][0].length; x6++) {
                                            for (int x5 = 0; x5 < data[0][0][0][0][0][0][0][0][0].length; x5++) {
                                                for (int x4 = 0; x4 < data[0][0][0][0][0][0][0][0][0][0].length; x4++) {
                                                    for (int x3 = 0; x3 < data[0][0][0][0][0][0][0][0][0][0][0].length; x3++) {
                                                        for (int x2 = 0; x2 < data[0][0][0][0][0][0][0][0][0][0][0][0].length; x2++) {
                                                            for (int x1 = 0; x1 < data[0][0][0][0][0][0][0][0][0][0][0][0][0].length; x1++) {
                                                                newData[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1] = data[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1] * scalar;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return new Tensor14d(newData);
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
    public static Tensor14d matmul(Tensor14d mul, Tensor14d toMul) {
        checkDims(mul, toMul);
        return new Tensor14d(matmul(mul.getData(), toMul.getData()));
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
    public static double[][][][][][][][][][][][][][] matmul(double[][][][][][][][][][][][][][] mul, double[][][][][][][][][][][][][][] toMul) {

        double[][][][][][][][][][][][][][] result = new double[mul.length][mul[0].length][mul[0][0].length][mul[0][0][0].length][mul[0][0][0][0].length][mul[0][0][0][0][0].length][mul[0][0][0][0][0][0].length][mul[0][0][0][0][0][0][0].length][mul[0][0][0][0][0][0][0][0].length][mul[0][0][0][0][0][0][0][0][0].length][mul[0][0][0][0][0][0][0][0][0][0].length][mul[0][0][0][0][0][0][0][0][0][0][0].length][mul[0][0][0][0][0][0][0][0][0][0][0][0].length][toMul[0][0][0][0][0][0][0][0][0][0][0][0][0].length];

        for (int x14 = 0; x14 < mul.length; x14++) {
            for (int x13 = 0; x13 < mul[0].length; x13++) {
                for (int x12 = 0; x12 < mul[0][0].length; x12++) {
                    for (int x11 = 0; x11 < mul[0][0][0].length; x11++) {
                        for (int x10 = 0; x10 < mul[0][0][0][0].length; x10++) {
                            for (int x9 = 0; x9 < mul[0][0][0][0][0].length; x9++) {
                                for (int x8 = 0; x8 < mul[0][0][0][0][0][0].length; x8++) {
                                    for (int x7 = 0; x7 < mul[0][0][0][0][0][0][0].length; x7++) {
                                        for (int x6 = 0; x6 < mul[0][0][0][0][0][0][0][0].length; x6++) {
                                            for (int x5 = 0; x5 < mul[0][0][0][0][0][0][0][0][0].length; x5++) {
                                                for (int x4 = 0; x4 < mul[0][0][0][0][0][0][0][0][0][0].length; x4++) {
                                                    for (int x3 = 0; x3 < mul[0][0][0][0][0][0][0][0][0][0][0].length; x3++) {
                                                        result[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3] =  Tensor2d.matmul(mul[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3], toMul[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3], MUL_TILE_SIZE);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return result;
    }

    
    private static void verifyDimensions(double[][][][][][][][][][][][][][] array, int[]expectedDimensions) {
        if (array.length != expectedDimensions[0]) {
            throw new DataException(
                    String.format("Size of dimension 13 of array must be %s, but was %s", expectedDimensions[0], array.length)
            );
        }
        else if (array[0].length != expectedDimensions[1]) {
            throw new DataException(
                    String.format("Size of dimension 12 of array must be %s, but was %s", expectedDimensions[1], array[0].length)
            );
        }
        else if (array[0][0].length != expectedDimensions[2]) {
            throw new DataException(
                    String.format("Size of dimension 11 of array must be %s, but was %s", expectedDimensions[2], array[0][0].length)
            );
        }
        else if (array[0][0][0].length != expectedDimensions[3]) {
            throw new DataException(
                    String.format("Size of dimension 10 of array must be %s, but was %s", expectedDimensions[3], array[0][0][0].length)
            );
        }
        else if (array[0][0][0][0].length != expectedDimensions[4]) {
            throw new DataException(
                    String.format("Size of dimension 9 of array must be %s, but was %s", expectedDimensions[4], array[0][0][0][0].length)
            );
        }
        else if (array[0][0][0][0][0].length != expectedDimensions[5]) {
            throw new DataException(
                    String.format("Size of dimension 8 of array must be %s, but was %s", expectedDimensions[5], array[0][0][0][0][0].length)
            );
        }
        else if (array[0][0][0][0][0][0].length != expectedDimensions[6]) {
            throw new DataException(
                    String.format("Size of dimension 7 of array must be %s, but was %s", expectedDimensions[6], array[0][0][0][0][0][0].length)
            );
        }
        else if (array[0][0][0][0][0][0][0].length != expectedDimensions[7]) {
            throw new DataException(
                    String.format("Size of dimension 6 of array must be %s, but was %s", expectedDimensions[7], array[0][0][0][0][0][0][0].length)
            );
        }
        else if (array[0][0][0][0][0][0][0][0].length != expectedDimensions[8]) {
            throw new DataException(
                    String.format("Size of dimension 5 of array must be %s, but was %s", expectedDimensions[8], array[0][0][0][0][0][0][0][0].length)
            );
        }
        else if (array[0][0][0][0][0][0][0][0][0].length != expectedDimensions[9]) {
            throw new DataException(
                    String.format("Size of dimension 4 of array must be %s, but was %s", expectedDimensions[9], array[0][0][0][0][0][0][0][0][0].length)
            );
        }
        else if (array[0][0][0][0][0][0][0][0][0][0].length != expectedDimensions[10]) {
            throw new DataException(
                    String.format("Size of dimension 3 of array must be %s, but was %s", expectedDimensions[10], array[0][0][0][0][0][0][0][0][0][0].length)
            );
        }
        else if (array[0][0][0][0][0][0][0][0][0][0][0].length != expectedDimensions[11]) {
            throw new DataException(
                    String.format("Size of dimension 2 of array must be %s, but was %s", expectedDimensions[11], array[0][0][0][0][0][0][0][0][0][0][0].length)
            );
        }
        else if (array[0][0][0][0][0][0][0][0][0][0][0][0].length != expectedDimensions[12]) {
            throw new DataException(
                    String.format("Size of dimension 1 of array must be %s, but was %s", expectedDimensions[12], array[0][0][0][0][0][0][0][0][0][0][0][0].length)
            );
        }
        else if (array[0][0][0][0][0][0][0][0][0][0][0][0][0].length != expectedDimensions[13]) {
            throw new DataException(
                    String.format("Size of dimension 0 of array must be %s, but was %s", expectedDimensions[13], array[0][0][0][0][0][0][0][0][0][0][0][0][0].length)
            );
        }
    }


    private static void verifyDimensions(double[][][][][][][][][][][][][] array, int[]expectedDimensions) {
        if (array.length != expectedDimensions[0]) {
            throw new DataException(
                    String.format("Size of dimension 12 of array must be %s, but was %s", expectedDimensions[0], array.length)
            );
        }
        else if (array[0].length != expectedDimensions[1]) {
            throw new DataException(
                    String.format("Size of dimension 11 of array must be %s, but was %s", expectedDimensions[1], array[0].length)
            );
        }
        else if (array[0][0].length != expectedDimensions[2]) {
            throw new DataException(
                    String.format("Size of dimension 10 of array must be %s, but was %s", expectedDimensions[2], array[0][0].length)
            );
        }
        else if (array[0][0][0].length != expectedDimensions[3]) {
            throw new DataException(
                    String.format("Size of dimension 9 of array must be %s, but was %s", expectedDimensions[3], array[0][0][0].length)
            );
        }
        else if (array[0][0][0][0].length != expectedDimensions[4]) {
            throw new DataException(
                    String.format("Size of dimension 8 of array must be %s, but was %s", expectedDimensions[4], array[0][0][0][0].length)
            );
        }
        else if (array[0][0][0][0][0].length != expectedDimensions[5]) {
            throw new DataException(
                    String.format("Size of dimension 7 of array must be %s, but was %s", expectedDimensions[5], array[0][0][0][0][0].length)
            );
        }
        else if (array[0][0][0][0][0][0].length != expectedDimensions[6]) {
            throw new DataException(
                    String.format("Size of dimension 6 of array must be %s, but was %s", expectedDimensions[6], array[0][0][0][0][0][0].length)
            );
        }
        else if (array[0][0][0][0][0][0][0].length != expectedDimensions[7]) {
            throw new DataException(
                    String.format("Size of dimension 5 of array must be %s, but was %s", expectedDimensions[7], array[0][0][0][0][0][0][0].length)
            );
        }
        else if (array[0][0][0][0][0][0][0][0].length != expectedDimensions[8]) {
            throw new DataException(
                    String.format("Size of dimension 4 of array must be %s, but was %s", expectedDimensions[8], array[0][0][0][0][0][0][0][0].length)
            );
        }
        else if (array[0][0][0][0][0][0][0][0][0].length != expectedDimensions[9]) {
            throw new DataException(
                    String.format("Size of dimension 3 of array must be %s, but was %s", expectedDimensions[9], array[0][0][0][0][0][0][0][0][0].length)
            );
        }
        else if (array[0][0][0][0][0][0][0][0][0][0].length != expectedDimensions[10]) {
            throw new DataException(
                    String.format("Size of dimension 2 of array must be %s, but was %s", expectedDimensions[10], array[0][0][0][0][0][0][0][0][0][0].length)
            );
        }
        else if (array[0][0][0][0][0][0][0][0][0][0][0].length != expectedDimensions[11]) {
            throw new DataException(
                    String.format("Size of dimension 1 of array must be %s, but was %s", expectedDimensions[11], array[0][0][0][0][0][0][0][0][0][0][0].length)
            );
        }
        else if (array[0][0][0][0][0][0][0][0][0][0][0][0].length != expectedDimensions[12]) {
            throw new DataException(
                    String.format("Size of dimension 0 of array must be %s, but was %s", expectedDimensions[12], array[0][0][0][0][0][0][0][0][0][0][0][0].length)
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
     public void reshape(int dim1, int dim2, int dim3, int dim4, int dim5, int dim6, int dim7, int dim8, int dim9, int dim10, int dim11, int dim12, int dim13, int dim14) {
        int[] shape = shape();
        int[] remappings = new int[14];
        boolean dim1F = false;
        boolean dim2F = false;
        boolean dim3F = false;
        boolean dim4F = false;
        boolean dim5F = false;
        boolean dim6F = false;
        boolean dim7F = false;
        boolean dim8F = false;
        boolean dim9F = false;
        boolean dim10F = false;
        boolean dim11F = false;
        boolean dim12F = false;
        boolean dim13F = false;
        boolean dim14F = false;
        for (int i = 0; i < shape.length; i++) {
            if (dim14 == shape[i] && !dim14F) {
                remappings[13] = i;
                dim14F = true;
            }
            else if (dim13 == shape[i] && !dim13F) {
                remappings[12] = i;
                dim13F = true;
            }
            else if (dim12 == shape[i] && !dim12F) {
                remappings[11] = i;
                dim12F = true;
            }
            else if (dim11 == shape[i] && !dim11F) {
                remappings[10] = i;
                dim11F = true;
            }
            else if (dim10 == shape[i] && !dim10F) {
                remappings[9] = i;
                dim10F = true;
            }
            else if (dim9 == shape[i] && !dim9F) {
                remappings[8] = i;
                dim9F = true;
            }
            else if (dim8 == shape[i] && !dim8F) {
                remappings[7] = i;
                dim8F = true;
            }
            else if (dim7 == shape[i] && !dim7F) {
                remappings[6] = i;
                dim7F = true;
            }
            else if (dim6 == shape[i] && !dim6F) {
                remappings[5] = i;
                dim6F = true;
            }
            else if (dim5 == shape[i] && !dim5F) {
                remappings[4] = i;
                dim5F = true;
            }
            else if (dim4 == shape[i] && !dim4F) {
                remappings[3] = i;
                dim4F = true;
            }
            else if (dim3 == shape[i] && !dim3F) {
                remappings[2] = i;
                dim3F = true;
            }
            else if (dim2 == shape[i] && !dim2F) {
                remappings[1] = i;
                dim2F = true;
            }
            else if (dim1 == shape[i] && !dim1F) {
                remappings[0] = i;
                dim1F = true;
            }
            else {
                throw new DataException("For reshape the given dimensions must be " +
                        "the same as current dimensions howbeit in a different order.");
            }
        }

        double[][][][][][][][][][][][][][] newData = new double[shape[remappings[13]]][shape[remappings[12]]][shape[remappings[11]]][shape[remappings[10]]][shape[remappings[9]]][shape[remappings[8]]][shape[remappings[7]]][shape[remappings[6]]][shape[remappings[5]]][shape[remappings[4]]][shape[remappings[3]]][shape[remappings[2]]][shape[remappings[1]]][shape[remappings[0]]];

        int[] indices = new int[14];
        for (int x1 = 0; x1 < data[0][0][0][0][0][0][0][0][0][0][0][0][0].length; x1++) {
            for (int x2 = 0; x2 < data[0][0][0][0][0][0][0][0][0][0][0][0].length; x2++) {
                for (int x3 = 0; x3 < data[0][0][0][0][0][0][0][0][0][0][0].length; x3++) {
                    for (int x4 = 0; x4 < data[0][0][0][0][0][0][0][0][0][0].length; x4++) {
                        for (int x5 = 0; x5 < data[0][0][0][0][0][0][0][0][0].length; x5++) {
                            for (int x6 = 0; x6 < data[0][0][0][0][0][0][0][0].length; x6++) {
                                for (int x7 = 0; x7 < data[0][0][0][0][0][0][0].length; x7++) {
                                    for (int x8 = 0; x8 < data[0][0][0][0][0][0].length; x8++) {
                                        for (int x9 = 0; x9 < data[0][0][0][0][0].length; x9++) {
                                            for (int x10 = 0; x10 < data[0][0][0][0].length; x10++) {
                                                for (int x11 = 0; x11 < data[0][0][0].length; x11++) {
                                                    for (int x12 = 0; x12 < data[0][0].length; x12++) {
                                                        for (int x13 = 0; x13 < data[0].length; x13++) {
                                                            for (int x14 = 0; x14 < data.length; x14++) {
                                                                for (int i = 0; i < indices.length; i++) {
                                                                    if (remappings[i] == 0) {
                                                                        indices[i] = x1;
                                                                    }
                                                                    if (remappings[i] == 1) {
                                                                        indices[i] = x2;
                                                                    }
                                                                    if (remappings[i] == 2) {
                                                                        indices[i] = x3;
                                                                    }
                                                                    if (remappings[i] == 3) {
                                                                        indices[i] = x4;
                                                                    }
                                                                    if (remappings[i] == 4) {
                                                                        indices[i] = x5;
                                                                    }
                                                                    if (remappings[i] == 5) {
                                                                        indices[i] = x6;
                                                                    }
                                                                    if (remappings[i] == 6) {
                                                                        indices[i] = x7;
                                                                    }
                                                                    if (remappings[i] == 7) {
                                                                        indices[i] = x8;
                                                                    }
                                                                    if (remappings[i] == 8) {
                                                                        indices[i] = x9;
                                                                    }
                                                                    if (remappings[i] == 9) {
                                                                        indices[i] = x10;
                                                                    }
                                                                    if (remappings[i] == 10) {
                                                                        indices[i] = x11;
                                                                    }
                                                                    if (remappings[i] == 11) {
                                                                        indices[i] = x12;
                                                                    }
                                                                    if (remappings[i] == 12) {
                                                                        indices[i] = x13;
                                                                    }
                                                                    if (remappings[i] == 13) {
                                                                        indices[i] = x14;
                                                                    }
                                                                }
                                                                newData[indices[13]][indices[12]][indices[11]][indices[10]][indices[9]][indices[8]][indices[7]][indices[6]][indices[5]][indices[4]][indices[3]][indices[2]][indices[1]][indices[0]] =  data[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1];
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
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
    public Tensor15d unsqueeze(int dim) {
        double[][][][][][][][][][][][][][][] newData;
        if (dim == 0) {
            newData = new double[data.length][data[0].length][data[0][0].length][data[0][0][0].length][data[0][0][0][0].length][data[0][0][0][0][0].length][data[0][0][0][0][0][0].length][data[0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0][0][0].length][1];
        }
        else if (dim == 1) {
            newData = new double[data.length][data[0].length][data[0][0].length][data[0][0][0].length][data[0][0][0][0].length][data[0][0][0][0][0].length][data[0][0][0][0][0][0].length][data[0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0][0].length][1][data[0][0][0][0][0][0][0][0][0][0][0][0][0].length];
        }
        else if (dim == 2) {
            newData = new double[data.length][data[0].length][data[0][0].length][data[0][0][0].length][data[0][0][0][0].length][data[0][0][0][0][0].length][data[0][0][0][0][0][0].length][data[0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0].length][1][data[0][0][0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0][0][0].length];
        }
        else if (dim == 3) {
            newData = new double[data.length][data[0].length][data[0][0].length][data[0][0][0].length][data[0][0][0][0].length][data[0][0][0][0][0].length][data[0][0][0][0][0][0].length][data[0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0].length][1][data[0][0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0][0][0].length];
        }
        else if (dim == 4) {
            newData = new double[data.length][data[0].length][data[0][0].length][data[0][0][0].length][data[0][0][0][0].length][data[0][0][0][0][0].length][data[0][0][0][0][0][0].length][data[0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0].length][1][data[0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0][0][0].length];
        }
        else if (dim == 5) {
            newData = new double[data.length][data[0].length][data[0][0].length][data[0][0][0].length][data[0][0][0][0].length][data[0][0][0][0][0].length][data[0][0][0][0][0][0].length][data[0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0].length][1][data[0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0][0][0].length];
        }
        else if (dim == 6) {
            newData = new double[data.length][data[0].length][data[0][0].length][data[0][0][0].length][data[0][0][0][0].length][data[0][0][0][0][0].length][data[0][0][0][0][0][0].length][data[0][0][0][0][0][0][0].length][1][data[0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0][0][0].length];
        }
        else if (dim == 7) {
            newData = new double[data.length][data[0].length][data[0][0].length][data[0][0][0].length][data[0][0][0][0].length][data[0][0][0][0][0].length][data[0][0][0][0][0][0].length][1][data[0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0][0][0].length];
        }
        else if (dim == 8) {
            newData = new double[data.length][data[0].length][data[0][0].length][data[0][0][0].length][data[0][0][0][0].length][data[0][0][0][0][0].length][1][data[0][0][0][0][0][0].length][data[0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0][0][0].length];
        }
        else if (dim == 9) {
            newData = new double[data.length][data[0].length][data[0][0].length][data[0][0][0].length][data[0][0][0][0].length][1][data[0][0][0][0][0].length][data[0][0][0][0][0][0].length][data[0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0][0][0].length];
        }
        else if (dim == 10) {
            newData = new double[data.length][data[0].length][data[0][0].length][data[0][0][0].length][1][data[0][0][0][0].length][data[0][0][0][0][0].length][data[0][0][0][0][0][0].length][data[0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0][0][0].length];
        }
        else if (dim == 11) {
            newData = new double[data.length][data[0].length][data[0][0].length][1][data[0][0][0].length][data[0][0][0][0].length][data[0][0][0][0][0].length][data[0][0][0][0][0][0].length][data[0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0][0][0].length];
        }
        else if (dim == 12) {
            newData = new double[data.length][data[0].length][1][data[0][0].length][data[0][0][0].length][data[0][0][0][0].length][data[0][0][0][0][0].length][data[0][0][0][0][0][0].length][data[0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0][0][0].length];
        }
        else if (dim == 13) {
            newData = new double[data.length][1][data[0].length][data[0][0].length][data[0][0][0].length][data[0][0][0][0].length][data[0][0][0][0][0].length][data[0][0][0][0][0][0].length][data[0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0][0][0].length];
        }
        else if (dim == 14) {
            newData = new double[1][data.length][data[0].length][data[0][0].length][data[0][0][0].length][data[0][0][0][0].length][data[0][0][0][0][0].length][data[0][0][0][0][0][0].length][data[0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0][0].length][data[0][0][0][0][0][0][0][0][0][0][0][0][0].length];
        }
        else {
            throw new DataException("Dimension must be between 0 and 14");
        }

        for (int x1 = 0; x1 < data[0][0][0][0][0][0][0][0][0][0][0][0][0].length; x1++) {
            for (int x2 = 0; x2 < data[0][0][0][0][0][0][0][0][0][0][0][0].length; x2++) {
                for (int x3 = 0; x3 < data[0][0][0][0][0][0][0][0][0][0][0].length; x3++) {
                    for (int x4 = 0; x4 < data[0][0][0][0][0][0][0][0][0][0].length; x4++) {
                        for (int x5 = 0; x5 < data[0][0][0][0][0][0][0][0][0].length; x5++) {
                            for (int x6 = 0; x6 < data[0][0][0][0][0][0][0][0].length; x6++) {
                                for (int x7 = 0; x7 < data[0][0][0][0][0][0][0].length; x7++) {
                                    for (int x8 = 0; x8 < data[0][0][0][0][0][0].length; x8++) {
                                        for (int x9 = 0; x9 < data[0][0][0][0][0].length; x9++) {
                                            for (int x10 = 0; x10 < data[0][0][0][0].length; x10++) {
                                                for (int x11 = 0; x11 < data[0][0][0].length; x11++) {
                                                    for (int x12 = 0; x12 < data[0][0].length; x12++) {
                                                        for (int x13 = 0; x13 < data[0].length; x13++) {
                                                            for (int x14 = 0; x14 < data.length; x14++) {
                                                                if (dim == 0) {
                                                                    newData[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1][0] =  data[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1];
                                                                }
                                                                else if (dim == 1) {
                                                                    newData[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][0][x1] =  data[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1];
                                                                }
                                                                else if (dim == 2) {
                                                                    newData[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][0][x2][x1] =  data[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1];
                                                                }
                                                                else if (dim == 3) {
                                                                    newData[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][0][x3][x2][x1] =  data[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1];
                                                                }
                                                                else if (dim == 4) {
                                                                    newData[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][0][x4][x3][x2][x1] =  data[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1];
                                                                }
                                                                else if (dim == 5) {
                                                                    newData[x14][x13][x12][x11][x10][x9][x8][x7][x6][0][x5][x4][x3][x2][x1] =  data[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1];
                                                                }
                                                                else if (dim == 6) {
                                                                    newData[x14][x13][x12][x11][x10][x9][x8][x7][0][x6][x5][x4][x3][x2][x1] =  data[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1];
                                                                }
                                                                else if (dim == 7) {
                                                                    newData[x14][x13][x12][x11][x10][x9][x8][0][x7][x6][x5][x4][x3][x2][x1] =  data[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1];
                                                                }
                                                                else if (dim == 8) {
                                                                    newData[x14][x13][x12][x11][x10][x9][0][x8][x7][x6][x5][x4][x3][x2][x1] =  data[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1];
                                                                }
                                                                else if (dim == 9) {
                                                                    newData[x14][x13][x12][x11][x10][0][x9][x8][x7][x6][x5][x4][x3][x2][x1] =  data[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1];
                                                                }
                                                                else if (dim == 10) {
                                                                    newData[x14][x13][x12][x11][0][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1] =  data[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1];
                                                                }
                                                                else if (dim == 11) {
                                                                    newData[x14][x13][x12][0][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1] =  data[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1];
                                                                }
                                                                else if (dim == 12) {
                                                                    newData[x14][x13][0][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1] =  data[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1];
                                                                }
                                                                else if (dim == 13) {
                                                                    newData[x14][0][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1] =  data[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1];
                                                                }
                                                                else if (dim == 14) {
                                                                    newData[0][x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1] =  data[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1];
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return new Tensor15d(newData);
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
    public Tensor13d squeeze(int dim) {
        int[] shape = shape();
        if (shape[dim] > 1) {
            throw new DataException("Dim 14 must be of size 1 or 0 but was " + shape[dim]);
        }

        int[] newShape = new int[13];
        int newIndex = 0;
        for (int i = 0; i < shape.length; i++) {
            if (i != dim) {
                newShape[newIndex] = shape[i];
                newIndex++;
            }
        }
        double[][][][][][][][][][][][][] newData = new double[newShape[12]][newShape[11]][newShape[10]][newShape[9]][newShape[8]][newShape[7]][newShape[6]][newShape[5]][newShape[4]][newShape[3]][newShape[2]][newShape[1]][newShape[0]];
        for (int x1 = 0; x1 < newData[0][0][0][0][0][0][0][0][0][0][0][0].length; x1++) {
            for (int x2 = 0; x2 < newData[0][0][0][0][0][0][0][0][0][0][0].length; x2++) {
                for (int x3 = 0; x3 < newData[0][0][0][0][0][0][0][0][0][0].length; x3++) {
                    for (int x4 = 0; x4 < newData[0][0][0][0][0][0][0][0][0].length; x4++) {
                        for (int x5 = 0; x5 < newData[0][0][0][0][0][0][0][0].length; x5++) {
                            for (int x6 = 0; x6 < newData[0][0][0][0][0][0][0].length; x6++) {
                                for (int x7 = 0; x7 < newData[0][0][0][0][0][0].length; x7++) {
                                    for (int x8 = 0; x8 < newData[0][0][0][0][0].length; x8++) {
                                        for (int x9 = 0; x9 < newData[0][0][0][0].length; x9++) {
                                            for (int x10 = 0; x10 < newData[0][0][0].length; x10++) {
                                                for (int x11 = 0; x11 < newData[0][0].length; x11++) {
                                                    for (int x12 = 0; x12 < newData[0].length; x12++) {
                                                        for (int x13 = 0; x13 < newData.length; x13++) {
                                                            if (dim == 0) {
                                                                newData[x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1] =  data[x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1][0];
                                                                }
                                                            else if (dim == 1) {
                                                                newData[x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1] =  data[x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][0][x1];
                                                                }
                                                            else if (dim == 2) {
                                                                newData[x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1] =  data[x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][0][x2][x1];
                                                                }
                                                            else if (dim == 3) {
                                                                newData[x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1] =  data[x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][0][x3][x2][x1];
                                                                }
                                                            else if (dim == 4) {
                                                                newData[x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1] =  data[x13][x12][x11][x10][x9][x8][x7][x6][x5][0][x4][x3][x2][x1];
                                                                }
                                                            else if (dim == 5) {
                                                                newData[x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1] =  data[x13][x12][x11][x10][x9][x8][x7][x6][0][x5][x4][x3][x2][x1];
                                                                }
                                                            else if (dim == 6) {
                                                                newData[x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1] =  data[x13][x12][x11][x10][x9][x8][x7][0][x6][x5][x4][x3][x2][x1];
                                                                }
                                                            else if (dim == 7) {
                                                                newData[x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1] =  data[x13][x12][x11][x10][x9][x8][0][x7][x6][x5][x4][x3][x2][x1];
                                                                }
                                                            else if (dim == 8) {
                                                                newData[x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1] =  data[x13][x12][x11][x10][x9][0][x8][x7][x6][x5][x4][x3][x2][x1];
                                                                }
                                                            else if (dim == 9) {
                                                                newData[x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1] =  data[x13][x12][x11][x10][0][x9][x8][x7][x6][x5][x4][x3][x2][x1];
                                                                }
                                                            else if (dim == 10) {
                                                                newData[x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1] =  data[x13][x12][x11][0][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1];
                                                                }
                                                            else if (dim == 11) {
                                                                newData[x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1] =  data[x13][x12][0][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1];
                                                                }
                                                            else if (dim == 12) {
                                                                newData[x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1] =  data[x13][0][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1];
                                                                }
                                                            else if (dim == 13) {
                                                                newData[x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1] =  data[0][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1];
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

        return new Tensor13d(newData);
    }


    

    /**
     * Returns the max value of the tensor/array. Simple algorithm currently
     * which may be upgraded.
     * @return
     */
    public double max() {
        double max = Double.MIN_VALUE;
        for (int x1 = 0; x1 < data[0][0][0][0][0][0][0][0][0][0][0][0][0].length; x1++) {
            for (int x2 = 0; x2 < data[0][0][0][0][0][0][0][0][0][0][0][0].length; x2++) {
                for (int x3 = 0; x3 < data[0][0][0][0][0][0][0][0][0][0][0].length; x3++) {
                    for (int x4 = 0; x4 < data[0][0][0][0][0][0][0][0][0][0].length; x4++) {
                        for (int x5 = 0; x5 < data[0][0][0][0][0][0][0][0][0].length; x5++) {
                            for (int x6 = 0; x6 < data[0][0][0][0][0][0][0][0].length; x6++) {
                                for (int x7 = 0; x7 < data[0][0][0][0][0][0][0].length; x7++) {
                                    for (int x8 = 0; x8 < data[0][0][0][0][0][0].length; x8++) {
                                        for (int x9 = 0; x9 < data[0][0][0][0][0].length; x9++) {
                                            for (int x10 = 0; x10 < data[0][0][0][0].length; x10++) {
                                                for (int x11 = 0; x11 < data[0][0][0].length; x11++) {
                                                    for (int x12 = 0; x12 < data[0][0].length; x12++) {
                                                        for (int x13 = 0; x13 < data[0].length; x13++) {
                                                            for (int x14 = 0; x14 < data.length; x14++) {
                                                                double val = data[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1];
                                                                if (val > max) {
                                                                    max = val;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
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
        for (int x1 = 0; x1 < data[0][0][0][0][0][0][0][0][0][0][0][0][0].length; x1++) {
            for (int x2 = 0; x2 < data[0][0][0][0][0][0][0][0][0][0][0][0].length; x2++) {
                for (int x3 = 0; x3 < data[0][0][0][0][0][0][0][0][0][0][0].length; x3++) {
                    for (int x4 = 0; x4 < data[0][0][0][0][0][0][0][0][0][0].length; x4++) {
                        for (int x5 = 0; x5 < data[0][0][0][0][0][0][0][0][0].length; x5++) {
                            for (int x6 = 0; x6 < data[0][0][0][0][0][0][0][0].length; x6++) {
                                for (int x7 = 0; x7 < data[0][0][0][0][0][0][0].length; x7++) {
                                    for (int x8 = 0; x8 < data[0][0][0][0][0][0].length; x8++) {
                                        for (int x9 = 0; x9 < data[0][0][0][0][0].length; x9++) {
                                            for (int x10 = 0; x10 < data[0][0][0][0].length; x10++) {
                                                for (int x11 = 0; x11 < data[0][0][0].length; x11++) {
                                                    for (int x12 = 0; x12 < data[0][0].length; x12++) {
                                                        for (int x13 = 0; x13 < data[0].length; x13++) {
                                                            for (int x14 = 0; x14 < data.length; x14++) {
                                                                double val = data[14][13][12][11][10][9][8][7][6][5][4][3][2][1];
                                                                if (val < min) {
                                                                    min = val;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
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
        for (int x14 = 0; x14 < data.length; x14++) {
            sb.append("[");
            for (int x13 = 0; x13 < data[0].length; x13++) {
                sb.append(newLine());
                sb.append(" [");
                for (int x12 = 0; x12 < data[0][0].length; x12++) {
                    sb.append(newLine());
                    sb.append("  [");
                    for (int x11 = 0; x11 < data[0][0][0].length; x11++) {
                        sb.append(newLine());
                        sb.append("   [");
                        for (int x10 = 0; x10 < data[0][0][0][0].length; x10++) {
                            sb.append(newLine());
                            sb.append("    [");
                            for (int x9 = 0; x9 < data[0][0][0][0][0].length; x9++) {
                                sb.append(newLine());
                                sb.append("     [");
                                for (int x8 = 0; x8 < data[0][0][0][0][0][0].length; x8++) {
                                    sb.append(newLine());
                                    sb.append("      [");
                                    for (int x7 = 0; x7 < data[0][0][0][0][0][0][0].length; x7++) {
                                        sb.append(newLine());
                                        sb.append("       [");
                                        for (int x6 = 0; x6 < data[0][0][0][0][0][0][0][0].length; x6++) {
                                            sb.append(newLine());
                                            sb.append("        [");
                                            for (int x5 = 0; x5 < data[0][0][0][0][0][0][0][0][0].length; x5++) {
                                                sb.append(newLine());
                                                sb.append("         [");
                                                for (int x4 = 0; x4 < data[0][0][0][0][0][0][0][0][0][0].length; x4++) {
                                                    sb.append(newLine());
                                                    sb.append("          [");
                                                    for (int x3 = 0; x3 < data[0][0][0][0][0][0][0][0][0][0][0].length; x3++) {
                                                        sb.append(newLine());
                                                        sb.append("           [");
                                                        for (int x2 = 0; x2 < data[0][0][0][0][0][0][0][0][0][0][0][0].length; x2++) {
                                                            sb.append(newLine());
                                                            sb.append("            [");
                                                            for (int x1 = 0; x1 < data[0][0][0][0][0][0][0][0][0][0][0][0][0].length; x1++) {
                                                                sb.append(roundPrint(data[x14][x13][x12][x11][x10][x9][x8][x7][x6][x5][x4][x3][x2][x1], PRECISION, spacing));
                                                                if (x1 < data[0][0][0][0][0][0][0][0][0][0][0][0][0].length - 1) {
                                                                    sb.append(", ");
                                                                }
                                                            }
                                                            sb.append("]");
                                                        }
                                                        sb.append(newLine());
                                                        sb.append(" ]");
                                                    }
                                                    sb.append(newLine());
                                                    sb.append("  ]");
                                                }
                                                sb.append(newLine());
                                                sb.append("   ]");
                                            }
                                            sb.append(newLine());
                                            sb.append("    ]");
                                        }
                                        sb.append(newLine());
                                        sb.append("     ]");
                                    }
                                    sb.append(newLine());
                                    sb.append("      ]");
                                }
                                sb.append(newLine());
                                sb.append("       ]");
                            }
                            sb.append(newLine());
                            sb.append("        ]");
                        }
                        sb.append(newLine());
                        sb.append("         ]");
                    }
                    sb.append(newLine());
                    sb.append("          ]");
                }
                sb.append(newLine());
                sb.append("           ]");
            }
            sb.append(newLine());
            sb.append("]");
            sb.append(newLine());
        }
        return sb.toString();
    }



}
