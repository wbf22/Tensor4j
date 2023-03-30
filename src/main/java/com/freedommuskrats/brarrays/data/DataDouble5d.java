package com.freedommuskrats.brarrays.data;

import com.freedommuskrats.brarrays.exception.DataException;

import static com.freedommuskrats.brarrays.util.GeneralUtil.roundPrint;
import static com.freedommuskrats.brarrays.util.GeneralUtil.newLine;

public class DataDouble5d implements DfData {
    private double[][][][][] data;
    private int dims;

    public DataDouble5d(double[][][][][] data) {
        this.data = data;
        this.dims = 5;
    }

    public double[][][][][] getData() {
        return data;
    }

    public Class<?> getType() {
        return Double.class;
    }

    public int getDims() {
        return dims;
    }

    
    public double get(int x1, int x2, int x3, int x4, int x5) {
        return data[x1][x2][x3][x4][x5];
    }
    public double[] get(int x1, int x2, int x3, int x4) {
        return data[x1][x2][x3][x4];
    }
    public double[][] get(int x1, int x2, int x3) {
        return data[x1][x2][x3];
    }
    public double[][][] get(int x1, int x2) {
        return data[x1][x2];
    }
    public double[][][][] get(int x1) {
        return data[x1];
    }

    public void set(int[] index, Object value) {
        data[index[0]][index[1]][index[2]][index[3]][index[4]]  = (double) value;
    }

    public void append(DataDouble5d toAppend, int dim) {
        if (dim < 0 || dim > dims) {
            throw new DataException(
                    String.format("Can't append on dim %s for df array of size %s. " +
                            "'int dim' must be greater than zero and less than the dimension of the array", dim, dims)
            );
        }

        double[][][][][] ap = toAppend.getData();

        
        if (dim == 0) {
            verifyDimensions(ap, new int[]{ap.length, data[0].length, data[0][0].length, data[0][0][0].length, data[0][0][0][0].length});
            double[][][][][] newData = new double[data.length + ap.length][data[0].length][data[0][0].length][data[0][0][0].length][data[0][0][0][0].length];
            for (int x1 = 0; x1 < newData.length; x1++) {
                for (int x2 = 0; x2 < data[0].length; x2++) {
                    for (int x3 = 0; x3 < data[0][0].length; x3++) {
                        for (int x4 = 0; x4 < data[0][0][0].length; x4++) {
                            for (int x5 = 0; x5 < data[0][0][0][0].length; x5++) {
                                if (x1 < data.length) {
                                    newData[x1][x2][x3][x4][x5] = data[x1][x2][x3][x4][x5];
                                } else {
                                    newData[x1][x2][x3][x4][x5] = ap[x1 - data.length][x2][x3][x4][x5];
                                }
                            }
                        }
                    }
                }
            }
            data = newData;
        }
        if (dim == 1) {
            verifyDimensions(ap, new int[]{data.length, ap[0].length, data[0][0].length, data[0][0][0].length, data[0][0][0][0].length});
            double[][][][][] newData = new double[data.length][data[0].length + ap[0].length][data[0][0].length][data[0][0][0].length][data[0][0][0][0].length];
            for (int x1 = 0; x1 < data.length; x1++) {
                for (int x2 = 0; x2 < newData[0].length; x2++) {
                    for (int x3 = 0; x3 < data[0][0].length; x3++) {
                        for (int x4 = 0; x4 < data[0][0][0].length; x4++) {
                            for (int x5 = 0; x5 < data[0][0][0][0].length; x5++) {
                                if (x2 < data[0].length) {
                                    newData[x1][x2][x3][x4][x5] = data[x1][x2][x3][x4][x5];
                                } else {
                                    newData[x1][x2][x3][x4][x5] = ap[x1][x2 - data[0].length][x3][x4][x5];
                                }
                            }
                        }
                    }
                }
            }
            data = newData;
        }
        if (dim == 2) {
            verifyDimensions(ap, new int[]{data.length, data[0].length, ap[0][0].length, data[0][0][0].length, data[0][0][0][0].length});
            double[][][][][] newData = new double[data.length][data[0].length][data[0][0].length + ap[0][0].length][data[0][0][0].length][data[0][0][0][0].length];
            for (int x1 = 0; x1 < data.length; x1++) {
                for (int x2 = 0; x2 < data[0].length; x2++) {
                    for (int x3 = 0; x3 < newData[0][0].length; x3++) {
                        for (int x4 = 0; x4 < data[0][0][0].length; x4++) {
                            for (int x5 = 0; x5 < data[0][0][0][0].length; x5++) {
                                if (x3 < data[0][0].length) {
                                    newData[x1][x2][x3][x4][x5] = data[x1][x2][x3][x4][x5];
                                } else {
                                    newData[x1][x2][x3][x4][x5] = ap[x1][x2][x3 - data[0][0].length][x4][x5];
                                }
                            }
                        }
                    }
                }
            }
            data = newData;
        }
        if (dim == 3) {
            verifyDimensions(ap, new int[]{data.length, data[0].length, data[0][0].length, ap[0][0][0].length, data[0][0][0][0].length});
            double[][][][][] newData = new double[data.length][data[0].length][data[0][0].length][data[0][0][0].length + ap[0][0][0].length][data[0][0][0][0].length];
            for (int x1 = 0; x1 < data.length; x1++) {
                for (int x2 = 0; x2 < data[0].length; x2++) {
                    for (int x3 = 0; x3 < data[0][0].length; x3++) {
                        for (int x4 = 0; x4 < newData[0][0][0].length; x4++) {
                            for (int x5 = 0; x5 < data[0][0][0][0].length; x5++) {
                                if (x4 < data[0][0][0].length) {
                                    newData[x1][x2][x3][x4][x5] = data[x1][x2][x3][x4][x5];
                                } else {
                                    newData[x1][x2][x3][x4][x5] = ap[x1][x2][x3][x4 - data[0][0][0].length][x5];
                                }
                            }
                        }
                    }
                }
            }
            data = newData;
        }
        if (dim == 4) {
            verifyDimensions(ap, new int[]{data.length, data[0].length, data[0][0].length, data[0][0][0].length, ap[0][0][0][0].length});
            double[][][][][] newData = new double[data.length][data[0].length][data[0][0].length][data[0][0][0].length][data[0][0][0][0].length + ap[0][0][0][0].length];
            for (int x1 = 0; x1 < data.length; x1++) {
                for (int x2 = 0; x2 < data[0].length; x2++) {
                    for (int x3 = 0; x3 < data[0][0].length; x3++) {
                        for (int x4 = 0; x4 < data[0][0][0].length; x4++) {
                            for (int x5 = 0; x5 < newData[0][0][0][0].length; x5++) {
                                if (x5 < data[0][0][0][0].length) {
                                    newData[x1][x2][x3][x4][x5] = data[x1][x2][x3][x4][x5];
                                } else {
                                    newData[x1][x2][x3][x4][x5] = ap[x1][x2][x3][x4][x5 - data[0][0][0][0].length];
                                }
                            }
                        }
                    }
                }
            }
            data = newData;
        }


    }

    public void append(DataDouble4d toAppend) {

        double[][][][] ap = toAppend.getData();

        
        verifyDimensions(ap, new int[]{data.length, data[0].length, data[0][0].length, data[0][0][0].length});
        double[][][][][] newData = new double[data.length][data[0].length][data[0][0].length][data[0][0][0].length][data[0][0][0][0].length + 1];
        for (int x1 = 0; x1 < data.length; x1++) {
            for (int x2 = 0; x2 < data[0].length; x2++) {
                for (int x3 = 0; x3 < data[0][0].length; x3++) {
                    for (int x4 = 0; x4 < data[0][0][0].length; x4++) {
                        for (int x5 = 0; x5 < newData[0][0][0][0].length; x5++) {
                            if (x5 < data[0][0][0][0].length) {
                                newData[x1][x2][x3][x4][x5] = data[x1][x2][x3][x4][x5];
                            } else {
                                newData[x1][x2][x3][x4][x5] = ap[x1][x2][x3][x4];
                            }
                        }
                    }
                }
            }
        }
        data = newData;


    }

    
    public static void verifyDimensions(double[][][][][] array, int[]expectedDimensions) {
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
        else if (array[0][0][0][0].length != expectedDimensions[4]) {
            throw new DataException(
                    String.format("Size of dimension 5 of array must be %s, but was %s", expectedDimensions[4], array[0][0][0][0].length)
            );
        }
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



    @Override
    public String toString() {
        
        StringBuilder sb = new StringBuilder();
        for (int x5 = 0; x5 < data[0][0][0][0].length; x5++) {
            sb.append("[");
            for (int x4 = 0; x4 < data[0][0][0].length; x4++) {
                sb.append(newLine());
                sb.append(" [");
                for (int x3 = 0; x3 < data[0][0].length; x3++) {
                    sb.append(newLine());
                    sb.append("  [");
                    for (int x2 = 0; x2 < data[0].length; x2++) {
                        sb.append(newLine());
                        sb.append("   [");
                        for (int x1 = 0; x1 < data.length; x1++) {
                            sb.append(roundPrint(data[x1][x2][x3][x4][x5], 4));
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
                sb.append("  ]");
            }
            sb.append(newLine());
            sb.append("]");
            sb.append(newLine());
        }
        return sb.toString();
    }



}