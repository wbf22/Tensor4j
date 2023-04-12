package com.freedommuskrats.brarrays;

import com.freedommuskrats.brarrays.data.DataDouble2d;
import com.freedommuskrats.brarrays.data.DataDouble3d;
import com.freedommuskrats.brarrays.exception.UnsupportedTypeException;

import java.util.Random;

import static com.freedommuskrats.brarrays.util.ArrayGen.*;
import static com.freedommuskrats.brarrays.util.PrimitiveConversion.toPrimitive;

public class df {

    private Object dataDouble;

    public df(Object array) {
        this.dataDouble = array;
    }


    public Object getDataDouble() {
        return dataDouble;
    }

    public Class<?> getType() {
        return dataDouble.getClass().arrayType();
    }

    public Object get() {
        return null;
    }

    public void set(int[] index, Object value) {

    }

    public df unsqueeze(int dim) {
        return new df(null);
    }

    public df squeeze() {
        return new df(null);
    }

    public void append(df toAppend, int dim) {
        if (dataDouble instanceof DataDouble3d casted) {

            if (toAppend.getDataDouble() instanceof DataDouble3d apCasted) {
                casted.append(apCasted, dim);
            }
            else {
                throw new UnsupportedTypeException(
                        String.format("Type %s isn't supported for appending to a 3d array", toAppend.getDataDouble())
                );
            }

            dataDouble = casted;

        }
    }

    public void append(df toAppend) {
        if (dataDouble instanceof DataDouble3d casted) {
            if (toAppend.getDataDouble() instanceof DataDouble2d apCasted) {
                casted.append(apCasted);
            }
            else {
                throw new UnsupportedTypeException(
                        String.format("Type %s isn't supported for appending to a 3d array", toAppend.getDataDouble())
                );
            }
        }

    }


    @Override
    public String toString() {
        return dataDouble.toString();
    }

    //##########################
    //## Static methods
    //##########################
    public static df array(double[] val) {
        return new df(val);
    }

//    public static df random(int[] size, Class<?> type) {
//        if (!isSupportedNumberType(type)) {
//            throw new UnsupportedTypeException(
//                    String.format("Type %s isn't supported a supported number type for random array gen", type.getName())
//            );
//        }
//
//        return switch (size.length) {
//            case 1 -> new df(random1d(size, type));
//            case 2 -> new df(random2d(size, type));
//            case 3 -> new df(random3d(size, type));
//            case 4 -> new df(random4d(size, type));
//            case 5 -> new df(random5d(size, type));
//            case 6 -> new df(random6d(size, type));
//            case 7 -> new df(random7d(size, type));
//            case 8 -> new df(random8d(size, type));
//            default -> new df(null);
//        };
//    }

    public static Object random1d(int[] size, Class<?> type) {
        Object data = null;
        if (type == Double.class) {
            data = toPrimitive(genArray1d(type, new Random(), size), 0.0);
        }
        else if (type == Integer.class) {
            data = toPrimitive(genArray1d(type, new Random(), size), 0);
        }
        else if (type == Float.class) {
            data = toPrimitive(genArray1d(type, new Random(), size), 0.0f);
        }
        else if (type == Long.class) {
            data = toPrimitive(genArray1d(type, new Random(), size), 0L);
        }
        return data;
    }

    public static Object random2d(int[] size, Class<?> type) {
        Object data = null;
        if (type == Double.class) {
            data = toPrimitive(genArray2d(type, new Random(), size), 0.0);
        }
        else if (type == Integer.class) {
            data = toPrimitive(genArray2d(type, new Random(), size), 0);
        }
        else if (type == Float.class) {
            data = toPrimitive(genArray2d(type, new Random(), size), 0.0f);
        }
        else if (type == Long.class) {
            data = toPrimitive(genArray2d(type, new Random(), size), 0L);
        }
        return data;
    }

    public static Object random3d(int[] size, Class<?> type) {
        Object data = null;
        if (type == Double.class) {
            data = toPrimitive(genArray3d(type, new Random(), size), 0.0);
        }
        else if (type == Integer.class) {
            data = toPrimitive(genArray3d(type, new Random(), size), 0);
        }
        else if (type == Float.class) {
            data = toPrimitive(genArray3d(type, new Random(), size), 0.0f);
        }
        else if (type == Long.class) {
            data = toPrimitive(genArray3d(type, new Random(), size), 0L);
        }
        return data;
    }

    public static Object random4d(int[] size, Class<?> type) {
        Object data = null;
        if (type == Double.class) {
            data = toPrimitive(genArray4d(type, new Random(), size), 0.0);
        }
        else if (type == Integer.class) {
            data = toPrimitive(genArray4d(type, new Random(), size), 0);
        }
        else if (type == Float.class) {
            data = toPrimitive(genArray4d(type, new Random(), size), 0.0f);
        }
        else if (type == Long.class) {
            data = toPrimitive(genArray4d(type, new Random(), size), 0L);
        }
        return data;
    }

//
//    public static Object random5d(int[] size, Class<?> type) {
//        Object data = null;
//        if (type == Double.class) {
//            data = toPrimitive(genArray5d(type, new Random(), size), 0.0);
//        }
//        else if (type == Integer.class) {
//            data = toPrimitive(genArray5d(type, new Random(), size), 0);
//        }
//        else if (type == Float.class) {
//            data = toPrimitive(genArray5d(type, new Random(), size), 0.0f);
//        }
//        else if (type == Long.class) {
//            data = toPrimitive(genArray5d(type, new Random(), size), 0L);
//        }
//        return data;
//    }
//
//    public static Object random6d(int[] size, Class<?> type) {
//        Object data = null;
//        if (type == Double.class) {
//            data = toPrimitive(genArray6d(type, new Random(), size), 0.0);
//        }
//        else if (type == Integer.class) {
//            data = toPrimitive(genArray6d(type, new Random(), size), 0);
//        }
//        else if (type == Float.class) {
//            data = toPrimitive(genArray6d(type, new Random(), size), 0.0f);
//        }
//        else if (type == Long.class) {
//            data = toPrimitive(genArray6d(type, new Random(), size), 0L);
//        }
//        return data;
//    }
//
//    public static Object random7d(int[] size, Class<?> type) {
//        Object data = null;
//        if (type == Double.class) {
//            data = toPrimitive(genArray7d(type, new Random(), size), 0.0);
//        }
//        else if (type == Integer.class) {
//            data = toPrimitive(genArray7d(type, new Random(), size), 0);
//        }
//        else if (type == Float.class) {
//            data = toPrimitive(genArray7d(type, new Random(), size), 0.0f);
//        }
//        else if (type == Long.class) {
//            data = toPrimitive(genArray7d(type, new Random(), size), 0L);
//        }
//        return data;
//    }
//
//    public static Object random8d(int[] size, Class<?> type) {
//        Object data = null;
//        if (type == Double.class) {
//            data = toPrimitive(genArray8d(type, new Random(), size), 0.0);
//        }
//        else if (type == Integer.class) {
//            data = toPrimitive(genArray8d(type, new Random(), size), 0);
//        }
//        else if (type == Float.class) {
//            data = toPrimitive(genArray8d(type, new Random(), size), 0.0f);
//        }
//        else if (type == Long.class) {
//            data = toPrimitive(genArray8d(type, new Random(), size), 0L);
//        }
//        return data;
//    }


    private static boolean isSupportedNumberType(Class<?> type) {
        return type == Double.class ||
                type == Integer.class ||
                type == Float.class ||
                type == Long.class;
    }

}
