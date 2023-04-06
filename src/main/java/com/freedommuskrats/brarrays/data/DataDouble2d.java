package com.freedommuskrats.brarrays.data;

import com.freedommuskrats.brarrays.df;
import com.freedommuskrats.brarrays.exception.DataException;

import static com.freedommuskrats.brarrays.util.DimUtil.verifyDimensions;
import static com.freedommuskrats.brarrays.util.GeneralUtil.roundPrint;

public class DataDouble2d extends DfData {

    private static final int MUL_TILE_SIZE = 2; // 32 seemed to be the best. 16 - 128 were optimal testing on MacBook pro 2021.


    private double[][] data;
    private int dims;
    private int precision = 0;

    public DataDouble2d(double[][] data) {
        this.data = data;
        this.dims = 2;
    }

    public double[][] getData() {
        return data;
    }

    public int getDims() {
        return dims;
    }

    public Class<?> getType() {
        return Double.class;
    }

    public double get(int[] index) {
        return data[index[0]][index[1]];
    }

    public DataDouble1d get(int i) {
        return new DataDouble1d(data[i]);
    }

    public void set(int[] index, Object value) {
        data[index[0]][index[1]] = (double) value;
    }

    public df unsqueeze(int dim) {
        return new df(null);
    }

    public df squeeze() {
        return new df(null);
    }

    public void append(DataDouble2d toAppend, int dim) {
        if (dim < 0 || dim > dims - 1) {
            throw new DataException(
                    String.format("Can't append on dim %s for df array of size %s. " +
                            "'int dim' must be greater than zero and less than the dimension of the array", dim, dims)
            );
        }

        double[][] ap = toAppend.getData();

        if (dim == 0) {
            verifyDimensions(ap, new int[]{ap.length, data[0].length});

            double[][] newData = new double[data.length + ap.length][data[0].length];
            for (int x = 0; x < newData.length; x++) {
                for (int y = 0; y < data[0].length; y++) {
                    if (x < data.length) {
                        newData[x][y] = data[x][y];
                    } else {
                        newData[x][y] = ap[x - data.length][y];
                    }
                }
            }
            data = newData;
        }
        else if (dim == 1) {
            verifyDimensions(ap, new int[]{data.length, ap[0].length});

            double[][] newData = new double[data.length][data[0].length + ap[0].length];
            for (int x = 0; x < data.length; x++) {
                for (int y = 0; y < newData[0].length; y++) {
                    if (y < data[0].length) {
                        newData[x][y] = data[x][y];
                    } else {
                        newData[x][y]= ap[x][y - data[0].length];
                    }
                }
            }
            data = newData;
        }


    }

    public void append(DataDouble1d toAppend) {

        double[] ap = toAppend.getData();

        verifyDimensions(ap, data.length);

        double[][] newData = new double[data.length][data[0].length + 1];
        for (int x = 0; x < data.length; x++) {
            for (int y = 0; y < newData[0].length; y++) {
                if (y < data[0].length) {
                    newData[x][y] = data[x][y];
                } else {
                    newData[x][y] = ap[x];
                }
            }
        }
        data = newData;
    }

    public int[] shape() {
        return new int[]{data.length, data[0].length};
    }

    public static int[] shape(double[][] arr) {
        return new int[]{arr.length, arr[0].length};
    }

    public static DataDouble2d matmul(DataDouble2d toMul, DataDouble2d mul) {
        return new DataDouble2d(matmul(toMul.getData(), mul.getData(), MUL_TILE_SIZE));
    }

    public static DataDouble2d matmul(DataDouble2d toMul, DataDouble2d mul, int tileSize) {
        return new DataDouble2d(matmul(toMul.getData(), mul.getData(), tileSize));
    }

    public static double[][] matmul(double[][] toMul, double[][] mul, int tileSize) {
        checkDims(toMul, mul);

//        1,1,1,2  X  2,3,1,1     7, 8, 7, 5
//        2,1,2,1     1,1,1,1     10,12,7, 6
//        3,1,1,1     2,2,1,1  =  10,13,7, 6
//        1,2,1,1     1,1,2,1     7, 8, 6, 5

//        1,2,1  X    3,2       6,  5
//        3,2,1       1,1  =    12, 9
//                    1,1

//        1,3,3    X    3,2,1       9, 10, 13
//                      1,1,2  =
//                      1,2,2

        double[][] result = new double[shape(mul)[0]][shape(toMul)[1]];
        int txLength = (int) Math.round(Math.ceil(
                    Math.max(
                            toMul.length/((double)tileSize),
                            mul.length/((double)tileSize)
                    )
        ));
        int tyLength = (int) Math.round(Math.ceil(
                Math.max(
                        toMul[0].length/((double)tileSize),
                        mul[0].length/((double)tileSize)
                )
        ));

        for (int tx = 0; tx <= txLength; tx += tileSize) {
            for (int ty = 0; ty <= tyLength; ty += tileSize) {
                for (int tx2 = 0; tx2 <= txLength; tx2 += tileSize) {
                    for (int y = 0; y < tileSize && ty + y < result[0].length; y++) {
                        for (int x = 0; x < tileSize && tx2 + x < result.length; x++) {
                            double sum = 0;
                            for (int j = 0; j < tileSize && tx + j < toMul.length; j++) {
                                sum += toMul[tx + j][ty + y] * mul[tx2 + x][tx + j];
                            }
                            result[x + tx2][ty + y] += sum;
                        }
                    }
                }
            }
        }

        return result;
    }

    public static DataDouble2d matmulNoCache(DataDouble2d toMul, DataDouble2d mul) {
        checkDims(toMul.getData(), mul.getData());

        double[][] toMulArr = toMul.getData();
        double[][] mulArr = mul.getData();
        double[][] result = new double[mul.shape()[0]][toMul.shape()[1]];

        for (int row = 0; row < toMulArr[0].length; row++) {
            for (int col = 0; col < mulArr.length; col++) {
                double sum = 0;
                for (int j = 0; j < toMulArr.length; j++) {
                    sum += toMulArr[j][row] * mulArr[col][j];
                }
                result[col][row] += sum;
            }
        }
        return new DataDouble2d(result);
    }

    public static void checkDims(double[][] toMul, double[][] mul) {
        int[] mulShape = shape(mul);
        int[] thisShape = shape(toMul);

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
        for (int y = 0; y < data[0].length; y++) {
            sb.append("[");
            for (int x = 0; x < data.length; x++) {
                sb.append(roundPrint(data[x][y], precision));
                if (x != data.length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]\n");
        }
        return sb.toString();
    }


}
