package com.freedommuskrats.brarrays.data;

import com.freedommuskrats.brarrays.df;
import com.freedommuskrats.brarrays.exception.DataException;

import static com.freedommuskrats.brarrays.util.DimUtil.verifyDimensions;
import static com.freedommuskrats.brarrays.util.GeneralUtil.roundPrint;

public class DataDouble1d implements DfData {
    private double[] data;
    private int dims;


    public DataDouble1d(double[] data) {
        this.data = data;
        this.dims = 1;
    }

    public double[] getData() {
        return data;
    }

    public int getDims() {
        return dims;
    }

    public Class<?> getType() {
        return Double.class;
    }


    public double get(int i) {
        return data[i];
    }

    

    public void set(int[] index, Object value) {
        data[index[0]] = (double) value;
    }

    public df unsqueeze(int dim) {
        return new df(null);
    }

    public df squeeze() {
        return new df(null);
    }

    public void append(DataDouble1d toAppend) {

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

    public void append(double toAppend) {

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int x = 0; x < data.length; x++) {
            sb.append(roundPrint(data[x], 4));
            if (x != data.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]\n");
        return sb.toString();
    }


}
