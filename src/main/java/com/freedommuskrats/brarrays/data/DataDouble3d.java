package com.freedommuskrats.brarrays.data;

import com.freedommuskrats.brarrays.exception.DataException;

import static com.freedommuskrats.brarrays.data.DataDouble2d.MUL_TILE_SIZE;
import static com.freedommuskrats.brarrays.util.GeneralUtil.roundPrint;
import static com.freedommuskrats.brarrays.util.GeneralUtil.newLine;

public class DataDouble3d extends DfData {
    private double[][][] data;
    private int dims;

    public DataDouble3d(double[][][] data) {
        this.data = data;
        this.dims = 3;
    }

    public double[][][] getData() {
        return data;
    }

    public Class<?> getType() {
        return Double.class;
    }

    public int getDims() {
        return dims;
    }

    
    public double get(int x1, int x2, int x3) {
        return data[x3][x2][x1];
    }
    public double[] get(int x1, int x2) {
        return data[x2][x1];
    }
    public double[][] get(int x1) {
        return data[x1];
    }

    @Override
    public int[] shape() {
        return new int[]{data[0][0].length, data[0].length, data.length};
    }

    public void set(int[] index, Object value) {
        data[index[0]][index[1]][index[2]]  = (double) value;
    }

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

    public static double[][][] matmul(DataDouble3d mul, DataDouble3d toMul) {
        checkDims(mul, toMul);

        double[][][] mulD = mul.getData();
        double[][][] toMulD = toMul.getData();

        double[][][] result = new double[mulD.length][mulD[0].length][toMulD[0][0].length];

        for(int x3 = 0; x3 < mulD.length; x3++) {
            result[x3] = DataDouble2d.matmul(mulD[x3], toMulD[x3], MUL_TILE_SIZE);
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