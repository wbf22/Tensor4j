package com.freedommuskrats.brarrays.data;

import com.freedommuskrats.brarrays.exception.DataException;

import java.util.Arrays;

import static com.freedommuskrats.brarrays.util.GeneralUtil.roundPrint;
import static com.freedommuskrats.brarrays.util.GeneralUtil.newLine;

public class DataDouble4d extends DfData {
    private double[][][][] data;
    private int dims;

    public DataDouble4d(double[][][][] data) {
        this.data = data;
        this.dims = 4;
    }

    public double[][][][] getData() {
        return data;
    }

    public Class<?> getType() {
        return Double.class;
    }

    public int getDims() {
        return dims;
    }

    
    public double get(int x1, int x2, int x3, int x4) {
        return data[x1][x2][x3][x4];
    }
    public DataDouble1d get(int x1, int x2, int x3) {
        return new DataDouble1d(data[x1][x2][x3]);
    }
    public DataDouble2d get(int x1, int x2) {
        return new DataDouble2d(data[x1][x2]);
    }
    public DataDouble3d get(int x1) {
        return new DataDouble3d(data[x1]);
    }

    public void set(int[] index, Object value) {
        data[index[0]][index[1]][index[2]][index[3]]  = (double) value;
    }

    public void append(DataDouble4d toAppend, int dim) {
        if (dim < 0 || dim > dims) {
            throw new DataException(
                    String.format("Can't append on dim %s for df array of size %s. " +
                            "'int dim' must be greater than zero and less than the dimension of the array", dim, dims)
            );
        }

        double[][][][] ap = toAppend.getData();

        
        if (dim == 0) {
            verifyDimensions(ap, new int[]{ap.length, data[0].length, data[0][0].length, data[0][0][0].length});
            double[][][][] newData = new double[data.length + ap.length][data[0].length][data[0][0].length][data[0][0][0].length];
            for (int x1 = 0; x1 < newData.length; x1++) {
                for (int x2 = 0; x2 < data[0].length; x2++) {
                    for (int x3 = 0; x3 < data[0][0].length; x3++) {
                        for (int x4 = 0; x4 < data[0][0][0].length; x4++) {
                            if (x1 < data.length) {
                                newData[x1][x2][x3][x4] = data[x1][x2][x3][x4];
                            } else {
                                newData[x1][x2][x3][x4] = ap[x1 - data.length][x2][x3][x4];
                            }
                        }
                    }
                }
            }
            data = newData;
        }
        if (dim == 1) {
            verifyDimensions(ap, new int[]{data.length, ap[0].length, data[0][0].length, data[0][0][0].length});
            double[][][][] newData = new double[data.length][data[0].length + ap[0].length][data[0][0].length][data[0][0][0].length];
            for (int x1 = 0; x1 < data.length; x1++) {
                for (int x2 = 0; x2 < newData[0].length; x2++) {
                    for (int x3 = 0; x3 < data[0][0].length; x3++) {
                        for (int x4 = 0; x4 < data[0][0][0].length; x4++) {
                            if (x2 < data[0].length) {
                                newData[x1][x2][x3][x4] = data[x1][x2][x3][x4];
                            } else {
                                newData[x1][x2][x3][x4] = ap[x1][x2 - data[0].length][x3][x4];
                            }
                        }
                    }
                }
            }
            data = newData;
        }
        if (dim == 2) {
            verifyDimensions(ap, new int[]{data.length, data[0].length, ap[0][0].length, data[0][0][0].length});
            double[][][][] newData = new double[data.length][data[0].length][data[0][0].length + ap[0][0].length][data[0][0][0].length];
            for (int x1 = 0; x1 < data.length; x1++) {
                for (int x2 = 0; x2 < data[0].length; x2++) {
                    for (int x3 = 0; x3 < newData[0][0].length; x3++) {
                        for (int x4 = 0; x4 < data[0][0][0].length; x4++) {
                            if (x3 < data[0][0].length) {
                                newData[x1][x2][x3][x4] = data[x1][x2][x3][x4];
                            } else {
                                newData[x1][x2][x3][x4] = ap[x1][x2][x3 - data[0][0].length][x4];
                            }
                        }
                    }
                }
            }
            data = newData;
        }
        if (dim == 3) {
            verifyDimensions(ap, new int[]{data.length, data[0].length, data[0][0].length, ap[0][0][0].length});
            double[][][][] newData = new double[data.length][data[0].length][data[0][0].length][data[0][0][0].length + ap[0][0][0].length];
            for (int x1 = 0; x1 < data.length; x1++) {
                for (int x2 = 0; x2 < data[0].length; x2++) {
                    for (int x3 = 0; x3 < data[0][0].length; x3++) {
                        for (int x4 = 0; x4 < newData[0][0][0].length; x4++) {
                            if (x4 < data[0][0][0].length) {
                                newData[x1][x2][x3][x4] = data[x1][x2][x3][x4];
                            } else {
                                newData[x1][x2][x3][x4] = ap[x1][x2][x3][x4 - data[0][0][0].length];
                            }
                        }
                    }
                }
            }
            data = newData;
        }


    }

    public void append(DataDouble3d toAppend) {

        double[][][] ap = toAppend.getData();

        
        verifyDimensions(ap, new int[]{data.length, data[0].length, data[0][0].length});
        double[][][][] newData = new double[data.length][data[0].length][data[0][0].length][data[0][0][0].length + 1];
        for (int x1 = 0; x1 < data.length; x1++) {
            for (int x2 = 0; x2 < data[0].length; x2++) {
                for (int x3 = 0; x3 < data[0][0].length; x3++) {
                    for (int x4 = 0; x4 < newData[0][0][0].length; x4++) {
                        if (x4 < data[0][0][0].length) {
                            newData[x1][x2][x3][x4] = data[x1][x2][x3][x4];
                        } else {
                            newData[x1][x2][x3][x4] = ap[x1][x2][x3];
                        }
                    }
                }
            }
        }
        data = newData;


    }

    public static void verifyDimensions(double[][][][] array, int[]expectedDimensions) {
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
        else if (array[0][0][0].length != expectedDimensions[3]) {
            throw new DataException(
                    String.format("Size of dimension 4 of array must be %s, but was %s", expectedDimensions[3], array[0][0][0].length)
            );
        }
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


    public int[] shape() {
        return new int[]{data.length, data[0].length, data[0][0].length, data[0][0][0].length};
    }

    public DataDouble4d matMul(DataDouble4d toMul, DataDouble4d mul) {
        // toMul * mul
        checkDims(toMul, mul);

        return null;



    }

    //https://www.iaeng.org/publication/WCE2010/WCE2010_pp1829-1833.pdf
    //https://stackoverflow.com/questions/64856174/an-efficient-way-to-multiply-two-object-matrixes
    //https://en.wikipedia.org/wiki/Matrix_multiplication_algorithm
    public void checkDims(DataDouble4d toMul, DataDouble4d mul) {
        int[] mulShape = mul.shape();
        int[] thisShape = toMul.shape();

        for (int i = 2; i < thisShape.length; i++) {
            if (thisShape[i] != mulShape[i]) {
                throw new DataException("Dim " + i + " in the first matrix should match dim " + i + " in the second matrix, but were "
                        + thisShape[i] + " and " + mulShape[i] + " respectively. "
                        + "Only the first two dims can differ, and dim 1 of the first and dim 0 of the second must match"
                        + " Eg: 2x3x2x2 * 3x1x2x2 = 2x1x2x2");
            }
        }

        if (thisShape[0] != mulShape[1]) {
            throw new DataException("Dim " + 0 + " in the first matrix should match dim " + 1 + " in the second matrix, but were "
                    + thisShape[0] + " and " + mulShape[1] + " respectively. "
                    + "Only the first two dims can differ, and dim 1 of the first and dim 0 of the second must match"
                    + " Eg: 2x3x2x2... * 3x1x2x2... = 2x1x2x2...");
        }
    }



    @Override
    public String toString() {
        
        StringBuilder sb = new StringBuilder();
        for (int x4 = 0; x4 < data[0][0][0].length; x4++) {
            sb.append("[");
            for (int x3 = 0; x3 < data[0][0].length; x3++) {
                sb.append(newLine());
                sb.append(" [");
                for (int x2 = 0; x2 < data[0].length; x2++) {
                    sb.append(newLine());
                    sb.append("  [");
                    for (int x1 = 0; x1 < data.length; x1++) {
                        sb.append(roundPrint(data[x1][x2][x3][x4], 4));
                        if (x1 < data.length - 1) {
                            sb.append(", ");
                        }
                    }
                    sb.append("]");
                }
                sb.append(newLine());
                sb.append(" ]");
            }
            sb.append(newLine());
            sb.append("]");
            sb.append(newLine());
        }
        return sb.toString();
    }



}