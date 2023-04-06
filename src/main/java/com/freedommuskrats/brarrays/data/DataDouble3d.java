package com.freedommuskrats.brarrays.data;

import com.freedommuskrats.brarrays.df;
import com.freedommuskrats.brarrays.exception.DataException;

import static com.freedommuskrats.brarrays.util.DimUtil.verifyDimensions;
import static com.freedommuskrats.brarrays.util.GeneralUtil.roundPrint;

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

    public double get(int[] index) {
        return data[index[0]][index[1]][index[2]];
    }

    public DataDouble2d get(int i) {
        return new DataDouble2d(data[i]);
    }

    public void set(int[] index, Object value) {
        data[index[0]][index[1]][index[3]]  = (double) value;
    }

    public df unsqueeze(int dim) {
        return new df(null);
    }

    public df squeeze() {
        return new df(null);
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
            verifyDimensions(ap, new int[]{ap.length, data[0].length, data[0][0].length});

            double[][][] newData = new double[data.length + ap.length][data[0].length][data[0][0].length];
            for (int x = 0; x < newData.length; x++) {
                for (int y = 0; y < data[0].length; y++) {
                    for (int z = 0; z < data[0][0].length; z++) {
                        if (x < data.length) {
                            newData[x][y][z] = data[x][y][z];
                        } else {
                            newData[x][y][z] = ap[x - data.length][y][z];
                        }
                    }
                }
            }
            data = newData;
        }
        else if (dim == 1) {
            verifyDimensions(ap, new int[]{data.length, ap[0].length, data[0][0].length});

            double[][][] newData = new double[data.length][data[0].length + ap[0].length][data[0][0].length];
            for (int x = 0; x < data.length; x++) {
                for (int y = 0; y < newData[0].length; y++) {
                    for (int z = 0; z < data[0][0].length; z++) {
                        if (y < data[0].length) {
                            newData[x][y][z] = data[x][y][z];
                        } else {
                            newData[x][y][z] = ap[x][y - data[0].length][z];
                        }
                    }
                }
            }
            data = newData;
        }
        else if (dim == 2) {
            verifyDimensions(ap, new int[]{data.length, data[0].length, ap[0][0].length});

            double[][][] newData = new double[data.length][data[0].length][data[0][0].length + ap[0][0].length];
            for (int x = 0; x < data.length; x++) {
                for (int y = 0; y < data[0].length; y++) {
                    for (int z = 0; z < newData[0][0].length; z++) {
                        if (z < data[0][0].length) {
                            newData[x][y][z] = data[x][y][z];
                        } else {
                            newData[x][y][z] = ap[x][y][z - data[0][0].length];
                        }
                    }
                }
            }
            data = newData;
        }
    }

    public void append(DataDouble2d toAppend) {

        //TODO: put this clue somewhere "Appending 2d array onto 3d array first and second dims must match"

        double[][] ap = toAppend.getData();

        verifyDimensions(ap, new int[]{data.length, data[0].length});

        double[][][] newData = new double[data.length][data[0].length][data[0][0].length + 1];
        for (int x = 0; x < data.length; x++) {
            for (int y = 0; y < data[0].length; y++) {
                for (int z = 0; z < newData[0][0].length; z++) {
                    if (z < data[0][0].length) {
                        newData[x][y][z] = data[x][y][z];
                    } else {
                        newData[x][y][z] = ap[x][y];
                    }
                }
            }
        }
        data = newData;
    }


    public String print2() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < data.length; i++) {
            sb.append("[");
            for (int j = 0; j < data[i].length; j++) {
                sb.append("[");
                for (int k = 0; k < data[i][j].length; k++) {
                    sb.append(data[i][j][k]);
                    if (k != data[i][j].length - 1) {
                        sb.append(", ");
                    }
                }
                sb.append("]");
                if (j != data[i].length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            if (i != data.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int z = 0; z < data[0][0].length; z++) {
            sb.append("[");
            for (int y = 0; y < data[0].length; y++) {
                sb.append("\n [");
                for (int x = 0; x < data.length; x++) {
                    sb.append(roundPrint(data[x][y][z], 4));
                    if (x != data.length - 1) {
                        sb.append(", ");
                    }
                }
                sb.append("]");
            }
            sb.append("\n]\n");
        }
        return sb.toString();
    }



}
