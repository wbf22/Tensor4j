package com.freedommuskrats.brarrays.data;

import com.freedommuskrats.brarrays.df;
import com.freedommuskrats.brarrays.exception.DataException;

import static com.freedommuskrats.brarrays.util.DimUtil.verifyDimensions;
import static com.freedommuskrats.brarrays.util.GeneralUtil.roundPrint;

public class DataDouble2d extends DfData {

    public static final int MUL_TILE_SIZE = 2; // 32 seemed to be the best. 16 - 128 were optimal testing on MacBook pro 2021.


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
        return data[index[1]][index[0]];
    }

    public DataDouble1d get(int i) {
        return new DataDouble1d(data[i]);
    }

    public DataDouble1d getH(int xl) {
        double[] newData = new double[data.length];
        for (int x1 = 0; x1 < data.length; x1++) {
            newData[x1] = data[x1][xl];
        }
        return new DataDouble1d(newData);
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
            verifyDimensions(ap, new int[]{data.length, ap[0].length});

            double[][] newData = new double[data.length][data[0].length + ap[0].length];
            for (int y = 0; y < data.length; y++) {
                for (int x = 0; x < newData[0].length; x++) {
                    if (x < data[0].length) {
                        newData[y][x] = data[y][x];
                    } else {
                        newData[y][x] = ap[y][x - data[0].length];
                    }
                }
            }
            data = newData;
        }
        else if (dim == 1) {
            verifyDimensions(ap, new int[]{ap.length, data[0].length});

            double[][] newData = new double[data.length + ap.length][data[0].length];
            for (int y = 0; y < newData.length; y++) {
                for (int x = 0; x < data[0].length; x++) {
                    if (y < data.length) {
                        newData[y][x] = data[y][x];
                    } else {
                        newData[y][x]= ap[y - data.length][x];
                    }
                }
            }
            data = newData;
        }


    }

    public void append(DataDouble1d toAppend) {

        double[] ap = toAppend.getData();

        verifyDimensions(ap, data[0].length);

        double[][] newData = new double[data.length + 1][data[0].length];
        for (int y = 0; y < newData.length; y++) {
            for (int x = 0; x < data[0].length; x++) {
                if (y < data.length) {
                    newData[y][x] = data[y][x];
                } else {
                    newData[y][x] = ap[y];
                }
            }
        }
        data = newData;
    }

    @Override
    public int[] shape() {
        return new int[]{data[0].length, data.length};
    }

    public static int[] shape(double[][] arr) {
        return new int[]{arr.length, arr[0].length};
    }

    public static DataDouble2d matmul(DataDouble2d toMul, DataDouble2d mul) {
        checkDims(toMul, mul);
        return matmul(toMul, mul, MUL_TILE_SIZE);
    }

    public static DataDouble2d matmul(DataDouble2d toMul, DataDouble2d mul, int tileSize) {
        return new DataDouble2d(matmul(toMul.getData(), mul.getData(), tileSize));
    }

    public static double[][] matmul(double[][] toMul, double[][] mul, int tileSize) {
//        1,1,1,2  X  2,3,1,1     7, 8, 7, 5
//        2,1,2,1     1,1,1,1     10,12,7, 6
//        3,1,1,1     2,2,1,1  =  10,13,7, 6
//        1,2,1,1     1,1,2,1     7, 8, 6, 5

//        1,2,1  X    3,2       6,  5
//        3,2,1       1,1  =    12, 9
//                    1,1



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

//        1,3,3    X    3,2       9, 11,
//                      1,1  =
//                      1,2

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

    public static DataDouble2d matmulNoCache(DataDouble2d toMul, DataDouble2d mul) {
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
        return new DataDouble2d(result);
    }





    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < data.length; y++) {
            sb.append("[");
            for (int x = 0; x < data[0].length; x++) {
                sb.append(roundPrint(data[y][x], precision));
                if (x != data[0].length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]\n");
        }
        return sb.toString();
    }


}
